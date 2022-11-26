package com.fakebili.client.email.dto.command;

import com.alibaba.cola.dto.Command;
import com.fakebili.domain.email.EmailEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serial;

/**
 * @author zzl
 * @date 2022/11/26 19:04:49
 * @description 发送邮件命令
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SendEmailCmd extends Command {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 收件人
     */
    @Email
    private String recipient;

    /**
     * 邮件种类
     */
    private EmailEnum type;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;
}
