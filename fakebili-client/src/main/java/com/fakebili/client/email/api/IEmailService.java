package com.fakebili.client.email.api;

import com.fakebili.client.email.dto.command.SendEmailCmd;

/**
 * @author zzl
 * @date 2022/11/26 18:45:36
 * @description
 */
public interface IEmailService {
    /**
     * 发送邮件
     *
     * @param cmd 发送邮件请求
     * @return 是否发送成功
     */
    boolean sendEmail(SendEmailCmd cmd);
}
