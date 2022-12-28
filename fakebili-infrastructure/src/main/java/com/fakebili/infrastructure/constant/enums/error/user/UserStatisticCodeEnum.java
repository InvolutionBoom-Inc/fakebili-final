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

    B_USER_STATISTIC_UNDEFINED("B_USER_statisticUndefined", "用户统计信息不存在"),
    B_USER_STATISTIC_REPEAT("B_USER_statisticRepeat", "用户统计重复");

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
