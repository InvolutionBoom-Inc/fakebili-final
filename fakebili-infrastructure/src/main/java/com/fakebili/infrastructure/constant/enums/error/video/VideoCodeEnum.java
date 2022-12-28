package com.fakebili.infrastructure.constant.enums.error.video;

import com.fakebili.infrastructure.common.api.ErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author zzl
 * @date 2022/12/28 16:31:52
 * @description 关于视频的错误枚举
 */
@AllArgsConstructor
public enum VideoCodeEnum implements ErrorCode {

    B_VIDEO_UNDEFINED("B_VIDEO_undefined", "视频不存在");

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
