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

    SendEmailCmd sendEmailCmd = new SendEmailCmd();

    @Async
    @EventListener(classes = SendVerifyEvent.class)
    public void onApplicationEvent(SendVerifyEvent event) {

        TextVerifyEntity source = (TextVerifyEntity) event.getSource();

        switch (source.getType()) {
            case 0 -> emailContent(EmailEnum.VERIFY_CODE, emailTemplate.captchaTemplate(source.getCode()));
            case 1 ->
                    emailContent(EmailEnum.RESET_PASSWORD_CODE, emailTemplate.resetPasswordTemplate(source.getCode()));
        }

        sendEmailCmd.setRecipient(source.getEmail());
        emailService.sendEmail(sendEmailCmd);
    }

    private void emailContent(EmailEnum type, String content) {
        sendEmailCmd.setType(type);
        sendEmailCmd.setSubject(type.getValue());
        sendEmailCmd.setContent(content);
    }
}