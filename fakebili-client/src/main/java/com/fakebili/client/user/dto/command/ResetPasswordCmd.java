package com.fakebili.client.user.dto.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zzl
 * @date 2022/11/30 14:01:05
 * @description 忘记密码的命令
 */
@Data
public class ResetPasswordCmd {
    /**
     * 用户id
     */
    @NotNull
    private Integer id;
    /**
     * 用户邮箱
     */
    @NotBlank
    private String email;
    /**
     * 密码
     */
    @NotBlank
    private String password;
    /**
     * 验证码
     */
    @NotBlank
    private String captcha;
}
