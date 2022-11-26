package com.fakebili.infrastructure.constant.enums.error.system;

import com.fakebili.infrastructure.common.api.ErrorCode;
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

    B_REQUEST_REPEATED_ERROR("B_REQUEST_repeatedError", "重复请求");

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
