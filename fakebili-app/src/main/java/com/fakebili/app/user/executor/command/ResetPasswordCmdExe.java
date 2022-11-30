package com.fakebili.app.user.executor.command;

import com.alibaba.cola.exception.BizException;
import com.fakebili.app.user.assembler.UserAssembler;
import com.fakebili.client.email.api.IEmailService;
import com.fakebili.client.user.dto.command.ResetPasswordCmd;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.infrastructure.constant.enums.error.captcha.CaptchaCodeEnum;
import com.fakebili.infrastructure.constant.enums.error.user.UserCodeEnum;
import com.fakebili.infrastructure.constant.security.Encryption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author zzl
 * @date 2022/11/30 14:03:37
 * @description
 */
@Component
@RequiredArgsConstructor
public class ResetPasswordCmdExe {

    private final UserGateway userGateway;
    private final IEmailService emailService;

    public Boolean execute(ResetPasswordCmd cmd) {
        if (!userGateway.checkById(cmd.getId())) {
            throw new BizException(UserCodeEnum.B_USER_UNDEFINED.getCode(), UserCodeEnum.B_USER_UNDEFINED.getMessage());
        }
        if (!emailService.checkCaptcha(cmd.getEmail(), cmd.getCaptcha())) {
            throw new BizException(CaptchaCodeEnum.B_CAPTCHA_ERROR.getCode(), CaptchaCodeEnum.B_CAPTCHA_ERROR.getMessage());
        }

        cmd.setPassword(Encryption.addSalt(cmd.getPassword()));
        userGateway.save(UserAssembler.toEntity(cmd));

        return true;

    }
}
