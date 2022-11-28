package com.fakebili.infrastructure.constant.enums.error.role;

import com.fakebili.infrastructure.common.api.ErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:09
 * @since 0.1.0
 */
@AllArgsConstructor
public enum RoleCodeEnum implements ErrorCode {

    B_ROLE_UNDEFINED("B_ROLE_undefined", "角色不存在");
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
