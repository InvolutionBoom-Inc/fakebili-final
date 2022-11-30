package com.fakebili.domain.email;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zzl
 * @date 2022/11/26 20:53:37
 * @description 邮箱类型枚举
 */
@Getter
@AllArgsConstructor
public enum EmailEnum {

    VERIFY_CODE(0, "fakebili--账户注册验证"),
    RESET_PASSWORD_CODE(1, "fakebili--忘记密码验证");

    private final Integer key;

    private final String value;
}
