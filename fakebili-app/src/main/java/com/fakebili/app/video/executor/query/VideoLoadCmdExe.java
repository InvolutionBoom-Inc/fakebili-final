package com.fakebili.app.video.executor.query;

import com.alibaba.cola.exception.BizException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fakebili.infrastructure.constant.enums.error.video.VideoCodeEnum;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserDO;
import com.fakebili.infrastructure.user.gateway.impl.database.mapper.UserMapper;
import com.fakebili.infrastructure.video.gateway.impl.database.dataobject.VideoDO;
import com.fakebili.infrastructure.video.gateway.impl.database.mapper.VideoMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzl
 * @date 2022/12/28 17:32:54
 * @description
 */
@Component
@RequiredArgsConstructor
public class VideoLoadCmdExe {

    private final VideoMapper videoMapper;
    private final UserMapper userMapper;

    public Map<String, Object> videoLoad(Integer id) {
        LambdaQueryWrapper<VideoDO> videoWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<UserDO> userWrapper = new LambdaQueryWrapper<>();
        videoWrapper.eq(VideoDO::getId, id);
        if (videoMapper.selectCount(videoWrapper) < 1) {
            throw new BizException(VideoCodeEnum.B_VIDEO_UNDEFINED.getCode(), VideoCodeEnum.B_VIDEO_UNDEFINED.getMessage());
        }
        VideoDO videoDO = videoMapper.selectOne(videoWrapper);
        userWrapper.eq(UserDO::getId, videoDO.getMid());
        UserDO userDO = userMapper.selectOne(userWrapper);
        return setMap(videoDO, userDO);
    }

    public Map<String, Object> setMap(VideoDO videoDO, UserDO userDO) {
        HashMap<String, Object> map = new HashMap<>();

        HashMap<String, Object> videoMap = new HashMap<>();
        videoMap.put("mid", videoDO.getMid());
        videoMap.put("title", videoDO.getTitle());
        videoMap.put("video_pic", videoDO.getVideoPic());
        videoMap.put("description", videoDO.getDescription());
        videoMap.put("video_url", videoDO.getVideoUrl());
        videoMap.put("duration", videoDO.getDuration());
        videoMap.put("pub_date", videoDO.getPubDate());
        videoMap.put("ctime", videoDO.getCtime());
        videoMap.put("video_update_time", videoDO.getVideoUpdateTime());

        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("nickname", userDO.getNickname());
        userMap.put("face", userDO.getFace());

        map.put("video",videoMap);
        map.put("user",userMap);

        return map;
    }
}
