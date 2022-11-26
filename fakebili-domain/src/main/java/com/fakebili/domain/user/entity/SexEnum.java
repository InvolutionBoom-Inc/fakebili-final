package com.fakebili.domain.user.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexEnum {

    DEFAULT(0, "保密"),
    MALE(1, "男"),
    FEMALE(2, "女");

    @EnumValue
    private final Integer key;

    @JsonValue
    private final String value;

}