package com.fakebili.client.captcha.dto.api;

import com.fakebili.client.captcha.dto.command.SendVerifyCmd;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/26 17:11:36
 * @since 0.1.0
 */
public interface ITextCaptchaService {

    void sendVerifyCode(SendVerifyCmd cmd);
}