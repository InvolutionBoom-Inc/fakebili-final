package com.fakebili.infrastructure.constant.email;

import org.springframework.stereotype.Component;

/**
 * @author zzl
 * @date 2022/11/28 08:59:39
 * @description 邮件模板
 */
@Component
public class EmailTemplate {

    public String content;

    public String captchaTemplate(String captcha){
        content = "您好！您正在进行邮箱验证，本次请求的验证码为:"+captcha;
        return content;
    }
}
