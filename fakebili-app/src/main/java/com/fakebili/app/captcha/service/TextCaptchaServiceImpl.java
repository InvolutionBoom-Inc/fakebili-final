package com.fakebili.app.captcha.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.fakebili.app.captcha.executor.command.SendVerifyCmdExe;
import com.fakebili.client.captcha.dto.api.ITextCaptchaService;
import com.fakebili.client.captcha.dto.command.SendVerifyCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/26 17:11:13
 * @since 0.1.0
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class TextCaptchaServiceImpl implements ITextCaptchaService {
    private final SendVerifyCmdExe sendVerifyCmdExe;

    @Override
    public Response sendVerifyCode(SendVerifyCmd cmd) {
        sendVerifyCmdExe.execute(cmd);
        return Response.buildSuccess();
    }
}
