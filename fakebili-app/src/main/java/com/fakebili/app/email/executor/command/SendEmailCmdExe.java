package com.fakebili.app.email.executor.command;

import com.fakebili.client.email.dto.command.SendEmailCmd;
import com.fakebili.infrastructure.common.cache.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zzl
 * @date 2022/11/26 19:39:14
 * @description 发送邮件命令执行器
 */
@Component
@RequiredArgsConstructor
public class SendEmailCmdExe {

    //邮件工具类
    private final JavaMailSender javaMailSender;
    private final RedisService redisService;

    @Value("${spring.mail.username}")
    private String sendMailer;

    public void execute(SendEmailCmd cmd) {
        sendEmail(cmd);
    }

    public void sendEmail(SendEmailCmd cmd) {

        SimpleMailMessage mail = new SimpleMailMessage();
        //邮件发件人
        mail.setFrom(sendMailer);
        //邮件收件人 1或多个
        mail.setTo(cmd.getRecipient());
        //邮件主题
        mail.setSubject(cmd.getSubject());
        //邮件内容
        mail.setText(cmd.getContent());
        //邮件发送时间
        mail.setSentDate(new Date());

        javaMailSender.send(mail);

    }

    public boolean checkCaptcha(String key, String captcha) {
        if (redisService.hasKey(key)) {
            String code = (String) redisService.get(key);
            return code.equals(captcha);
        }
        return false;
    }

}
