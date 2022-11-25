package com.fakebili.infrastructure.constant.enums.error.user;

import com.fakebili.client.api.ErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author zzl
 * @version 2022/11/23 16:05:56
 * @since 0.1.0
 * 关于用户状态的枚举
 */

@SuppressWarnings(value = "all")
@AllArgsConstructor
public enum UserCodeEnum implements ErrorCode {

    B_USER_USERNAME_REPEAT("B_USER_usernameRepeat", "用户名重复"),
    B_USER_UNDEFINED("B_USER_undefined", "用户不存在"),
    B_USER_PASSWORD_ERROR("B_USER_passwordError", "用户名或密码不正确"),
    B_USER_NICKNAME_ERROR("B_USER_nicknameError","用户昵称不合法");

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
