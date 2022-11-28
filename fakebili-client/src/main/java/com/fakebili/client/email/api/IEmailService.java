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
     */
    void sendEmail(SendEmailCmd cmd);

    /**
     * 验证码校验
     *
     * @param key redis存储的key
     * @return 验证码是否有效
     */
    boolean checkCaptcha(String key,String captcha);
}
