package com.fakebili.app.email.consumer;

import com.fakebili.client.email.api.IEmailService;
import com.fakebili.client.email.dto.command.SendEmailCmd;
import com.fakebili.domain.captcha.entity.TextVerifyEntity;
import com.fakebili.domain.email.EmailEnum;
import com.fakebili.infrastructure.constant.email.EmailTemplate;
import com.fakebili.infrastructure.event.SendVerifyEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
 
/**
 * @author zzl
 * @date 2022/11/26 18:34:38
 * @description 监听邮件发送
 */
@Component
@RequiredArgsConstructor
public class EmailListener {

    public final IEmailService emailService;

    public final EmailTemplate emailTemplate;

    @Async
    @EventListener(classes = SendVerifyEvent.class)
    public void onApplicationEvent(SendVerifyEvent event) {

        TextVerifyEntity source = (TextVerifyEntity) event.getSource();
        SendEmailCmd sendEmailCmd = new SendEmailCmd();
        if (source.getType() == 0) {
            sendEmailCmd.setType(EmailEnum.VERIFY_CODE);
            sendEmailCmd.setSubject(EmailEnum.VERIFY_CODE.getValue());
        }
        sendEmailCmd.setRecipient(source.getEmail());
        sendEmailCmd.setContent(emailTemplate.captchaTemplate(source.getCode()));

        emailService.sendEmail(sendEmailCmd);
    }
}