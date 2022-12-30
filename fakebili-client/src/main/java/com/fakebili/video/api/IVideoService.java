package com.fakebili.video.api;

import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.client.video.dto.command.ContributionCmd;
import com.fakebili.client.video.dto.data.ContributionVO;

import java.util.Map;

/**
 * @author zzl
 * @date 2022/12/28 15:42:21
 * @description
 */
public interface IVideoService {
    /**
     * 视频加载
     *
     * @param id 视频id
     * @return response
     */
    SingleResponse<Map<String, Object>> videoLoad(Integer id);

    /**
     * 视频投稿
     * @param cmd 投稿信息
     * @return SingleResponse<ContributionVO>
     */
    SingleResponse<ContributionVO> contribution(ContributionCmd cmd);
}
