package com.fakebili.domain.captcha.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/26 20:11:58
 * @since 0.1.0
 */
@Builder
@Data
public class TextVerifyEntity {

    private String code;

    private int type;

    private String email;

}
