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

    B_USERROLE_UNDEFINED("B_USERROLE_undefined", "用户统计信息不存在");

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
