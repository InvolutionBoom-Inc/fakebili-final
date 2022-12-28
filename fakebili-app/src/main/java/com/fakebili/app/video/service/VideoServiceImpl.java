package com.fakebili.app.video.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.BizException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fakebili.app.video.executor.query.VideoLoadCmdExe;
import com.fakebili.infrastructure.constant.enums.error.video.VideoCodeEnum;
import com.fakebili.infrastructure.video.gateway.impl.database.dataobject.VideoDO;
import com.fakebili.infrastructure.video.gateway.impl.database.mapper.VideoMapper;
import com.fakebili.video.api.IVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    
    @Override
    public SingleResponse<Map<String, Object>> videoLoad(Integer id) {
        return SingleResponse.of(videoLoadCmdExe.videoLoad(id));
    }
}
