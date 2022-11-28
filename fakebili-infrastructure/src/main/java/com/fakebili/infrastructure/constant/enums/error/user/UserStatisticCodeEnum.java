package com.fakebili.infrastructure.constant.enums.error.user;

import com.fakebili.infrastructure.common.api.ErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 11:11:43
 * @since 0.1.0
 */
@AllArgsConstructor
public enum UserStatisticCodeEnum implements ErrorCode {

    B_USERSTATISTIC_UNDEFINED("B_USERSTATISTIC_undefined", "用户统计不存在"),
    B_USERSTATISTIC_USERSTATISTIC_REPEAT("B_USERSTATISTIC_userStatisticRepeat", "用户统计重复");

    private String code;
    private String message;

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
