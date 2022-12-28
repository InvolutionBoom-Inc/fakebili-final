package com.fakebili.infrastructure.constant.enums.error.user;

import com.fakebili.infrastructure.common.api.ErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 13:11:58
 * @since 0.1.0
 */
@AllArgsConstructor
public enum UserRoleCodeEnum implements ErrorCode {

    B_USER_ROLE_UNDEFINED("B_USER_roleUndefined", "用户角色信息不存在"),
    B_USER_ROLE_ERROR("B_USER_roleError", "用户角色关联异常");

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
