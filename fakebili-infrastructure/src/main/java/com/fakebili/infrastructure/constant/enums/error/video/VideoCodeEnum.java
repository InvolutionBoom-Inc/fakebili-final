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

    B_VIDEO_UNDEFINED("B_VIDEO_undefined", "视频不存在"),
    B_USERID_ERROR("B_USERID_ERROR","该投稿的作者id与登录用户id不符"),
    B_VIDEO_PIC_UNDEFINED("B_VIDEO_PIC_UNDEFINED","该视频封面不存在"),
    B_VIDEO_URL_UNDEFINED("B_VIDEO_URL_UNDEFINED","该视频地址不存在"),
    B_VIDEO_REPEAT("B_VIDEO_REPEAT","该视频投稿已存在");

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
