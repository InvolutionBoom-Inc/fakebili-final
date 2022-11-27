package com.fakebili.infrastructure.constant.enums.error.captcha;

import com.fakebili.infrastructure.common.api.ErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author zzl
 * @date 2022/11/27 20:56:13
 * @description 关于验证码的枚举
 */
@SuppressWarnings(value = "all")
@AllArgsConstructor
public enum CaptchaCodeEnum implements ErrorCode {

    B_CAPTCHA_EXPIRED("B_CAPTCHA_expired", "验证码过期"),
    B_CAPTCHA_ERROR("B_CAPTCHA_error", "验证码错误");

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
