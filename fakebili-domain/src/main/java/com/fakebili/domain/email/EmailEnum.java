package com.fakebili.domain.email;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
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

    VERIFY_CODE(0, "验证码");

    private final Integer key;

    private final String value;
}
