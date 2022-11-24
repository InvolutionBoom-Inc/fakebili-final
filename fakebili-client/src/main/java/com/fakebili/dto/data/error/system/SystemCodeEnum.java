package com.fakebili.dto.data.error.system;

import com.fakebili.dto.data.ErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author zzl
 * @version 2022/11/23 16:05:56
 * @since 0.1.0
 * 关于系统状态的枚举
 */

@SuppressWarnings(value = "all")
@AllArgsConstructor
public enum SystemCodeEnum implements ErrorCode {

    B_USER_PASSWORD_ERROR("B_USER_passwordError", "用户名或密码不正确");

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
