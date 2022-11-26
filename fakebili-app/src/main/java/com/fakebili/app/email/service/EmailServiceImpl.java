package com.fakebili.app.email.service;

import com.fakebili.app.email.executor.command.SendEmailCmdExe;
import com.fakebili.client.email.api.IEmailService;
import com.fakebili.client.email.dto.command.SendEmailCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zzl
 * @date 2022/11/26 18:38:43
 * @description
 */
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements IEmailService {

    public final SendEmailCmdExe sendEmailCmdExe;

    @Override
    public boolean sendEmail(SendEmailCmd cmd) {
        return sendEmailCmdExe.execute(cmd);
    }
}
