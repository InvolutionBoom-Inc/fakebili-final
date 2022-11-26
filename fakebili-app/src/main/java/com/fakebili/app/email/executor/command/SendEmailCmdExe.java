package com.fakebili.app.email.executor.command;

import com.fakebili.client.email.dto.command.SendEmailCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @author zzl
 * @date 2022/11/26 19:39:14
 * @description 发送邮件命令执行器
 */
@Component
@RequiredArgsConstructor
public class SendEmailCmdExe {

    //注入邮件工具类
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sendMailer;

    public boolean execute(SendEmailCmd cmd){
        switch(cmd.getType().getKey()){
            case 0 -> SendCode(cmd);
        }
        return true;
    }

    public void SendCode(SendEmailCmd cmd){
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
}
