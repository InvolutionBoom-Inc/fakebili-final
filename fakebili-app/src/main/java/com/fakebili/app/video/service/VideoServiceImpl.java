package com.fakebili.app.video.service;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.BizException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fakebili.app.video.executor.query.VideoLoadCmdExe;
import com.fakebili.client.video.dto.command.ContributionCmd;
import com.fakebili.client.video.dto.data.ContributionVO;
import com.fakebili.infrastructure.constant.enums.error.video.VideoCodeEnum;
import com.fakebili.infrastructure.video.gateway.impl.database.dataobject.VideoDO;
import com.fakebili.infrastructure.video.gateway.impl.database.dataobject.VideoStatisticDO;
import com.fakebili.infrastructure.video.gateway.impl.database.mapper.VideoMapper;
import com.fakebili.infrastructure.video.gateway.impl.database.mapper.VideoStatisticMapper;
import com.fakebili.video.api.IVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ws.schild.jave.FFmpegFileInfo;
import ws.schild.jave.MultimediaInfo;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzl
 * @date 2022/12/28 15:48:23
 * @description
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class VideoServiceImpl implements IVideoService {
    public final VideoLoadCmdExe videoLoadCmdExe;
    private final VideoMapper videoMapper;
    private final VideoStatisticMapper videoStatisticMapper;
    
    @Override
    public SingleResponse<Map<String, Object>> videoLoad(Integer id) {
        return SingleResponse.of(videoLoadCmdExe.videoLoad(id));
    }

    @Override
    public SingleResponse<ContributionVO> contribution(ContributionCmd cmd) {
        Integer loginId = Integer.parseInt((String) StpUtil.getLoginId());
        // 判断登录用户是否为投稿用户
        if (cmd.getMid()!= loginId){
            throw new BizException(VideoCodeEnum.B_USERID_ERROR.getCode(),VideoCodeEnum.B_USERID_ERROR.getMessage());
        }
        // 判断封面以及视频是否存在
        if (!fileIsExisting(cmd.getVideoPic())){
            throw new BizException(VideoCodeEnum.B_VIDEO_PIC_UNDEFINED.getCode(),VideoCodeEnum.B_VIDEO_PIC_UNDEFINED.getMessage());
        }
        if (!fileIsExisting(cmd.getVideoUrl())){
            throw new BizException(VideoCodeEnum.B_VIDEO_URL_UNDEFINED.getCode(),VideoCodeEnum.B_VIDEO_URL_UNDEFINED.getMessage());
        }
        Integer videoDuration = getVideoDuration(cmd.getVideoUrl());

        // 保存video,顺便创建一个同id的video_static
        VideoDO videoDO = contributionCmdToVideoDO(cmd);
        videoDO.setDuration(videoDuration);
        if (videoMapper.selectOne(new QueryWrapper<VideoDO>().setEntity(videoDO)) !=null){
            throw new BizException(VideoCodeEnum.B_VIDEO_REPEAT.getCode(),VideoCodeEnum.B_VIDEO_REPEAT.getMessage());
        }
        videoMapper.insert(videoDO);
        VideoDO videoDO1 = videoMapper.selectOne(new QueryWrapper<VideoDO>().setEntity(videoDO));
        VideoStatisticDO videoStatisticDO = intialVideoStatisticDO(videoDO1.getId());
        videoStatisticMapper.insert(videoStatisticDO);

        return SingleResponse.of(videoDOToContributionVO(videoDO));
    }

    /**
     * 判断文件是否存在
     * @param url
     * @return
     */
    private Boolean fileIsExisting(String url){
        try {
            URL serverUrl = new URL(url);
            HttpURLConnection urlcon = (HttpURLConnection) serverUrl.openConnection();
            String message = urlcon.getHeaderField(0);
            if (StringUtils.hasText(message) && message.startsWith("HTTP/1.1 404")) {
                return false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 通过视频url获取视频时长
     * @param url
     * @return
     */
    private Integer getVideoDuration(String url){
        File file = new File(url);
        try {
            FFmpegFileInfo instance = new FFmpegFileInfo(file);
            MultimediaInfo result = instance.getInfo(url);
            // 毫秒 -> 秒 -> 分钟 -> 小时
            Integer ls = Math.toIntExact(result.getDuration() / 1000);
            return ls;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 将ContributionCmd转换为VideoDO
     * @param cmd
     * @return
     */
    private VideoDO contributionCmdToVideoDO(ContributionCmd cmd){
        VideoDO videoDO = new VideoDO();
        videoDO.setMid(cmd.getMid());
        videoDO.setTitle(cmd.getTitle());
        videoDO.setVideoPic(cmd.getVideoPic());
        videoDO.setDescription(cmd.getDescription());
        videoDO.setVideoUrl(cmd.getVideoUrl());
        videoDO.setPubDate(LocalDateTime.now());
        videoDO.setCtime(LocalDateTime.now());
        videoDO.setVideoUpdateTime(LocalDateTime.now());
        return videoDO;
    }

    /**
     * 初始化VideoStatisticDO
     * @param videoId
     * @return
     */
    private VideoStatisticDO intialVideoStatisticDO(Integer videoId){
        VideoStatisticDO videoStatisticDO = new VideoStatisticDO();
        videoStatisticDO.setId(videoId);
        videoStatisticDO.setViewCount(0);
        videoStatisticDO.setGotLikesCount(0);
        videoStatisticDO.setCollectCount(0);
        videoStatisticDO.setCoinCount(0);
        videoStatisticDO.setRetweetCount(0);
        videoStatisticDO.setCommentCount(0);
        return videoStatisticDO;
    }

    /**
     * 将VideoDO转换为ContributionVO
     * @param videoDO
     * @return
     */
    private ContributionVO videoDOToContributionVO(VideoDO videoDO){
        ContributionVO contributionVO = new ContributionVO();
        contributionVO.setMid(videoDO.getMid());
        contributionVO.setTitle(videoDO.getTitle());
        contributionVO.setVideoPic(videoDO.getVideoPic());
        contributionVO.setDescription(videoDO.getDescription());
        contributionVO.setVideoUrl(videoDO.getVideoUrl());
        contributionVO.setDuration(videoDO.getDuration());
        contributionVO.setCtime(videoDO.getCtime());
        contributionVO.setPubDate(videoDO.getPubDate());
        return contributionVO;
    }

}
