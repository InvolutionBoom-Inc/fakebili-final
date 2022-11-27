package com.fakebili.client.captcha.dto.api;

import com.alibaba.cola.dto.Response;
import com.fakebili.client.captcha.dto.command.SendVerifyCmd;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/26 17:11:36
 * @since 0.1.0
 */
public interface ITextCaptchaService {

    /**
     * 发送验证码
     * @param cmd 包含邮箱地址
     */
    Response sendVerifyCode(SendVerifyCmd cmd);
}
