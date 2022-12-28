package com.fakebili.client.person.dto.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Jie
 * @ClassName ResetEmailCmd.java
 * @description ****
 * @since 2022/12/12 08:55:10
 */
@Data
public class ResetEmailCmd {
    /**
     * 用户id
     */
    @NotNull
    private Integer id;
    /**
     * 用户邮箱(旧)
     */
    @NotBlank
    private String oldEmail;

    /**
     * 验证码
     */
    @NotBlank
    private String oldCaptcha;

    /**
     * 用户邮箱(新)
     */
    @NotBlank
    private String newEmail;

    /**
     * 验证码(新)
     */
    @NotBlank
    private String newCaptcha;
}
