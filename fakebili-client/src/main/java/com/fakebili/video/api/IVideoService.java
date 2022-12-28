package com.fakebili.video.api;

import com.alibaba.cola.dto.SingleResponse;

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
}
