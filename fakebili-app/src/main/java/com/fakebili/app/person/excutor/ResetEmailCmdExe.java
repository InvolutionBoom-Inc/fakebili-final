package com.fakebili.app.person.excutor;

import com.alibaba.cola.exception.BizException;
import com.fakebili.app.user.assembler.UserAssembler;
import com.fakebili.client.email.api.IEmailService;
import com.fakebili.client.person.dto.command.ResetEmailCmd;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.infrastructure.constant.enums.error.captcha.CaptchaCodeEnum;
import com.fakebili.infrastructure.constant.enums.error.user.UserCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Jie
 * @ClassName ResetEmailCmdExe.java
 * @description ****
 * @since 2022/12/12 09:43:12
 */
@Component
@RequiredArgsConstructor
public class ResetEmailCmdExe {
    private final UserGateway userGateway;
    private final IEmailService emailService;

    public Boolean execute(ResetEmailCmd cmd){
        if (!userGateway.checkById(cmd.getId())) {
            throw new BizException(UserCodeEnum.B_USER_UNDEFINED.getCode(), UserCodeEnum.B_USER_UNDEFINED.getMessage());
        }
        if (!emailService.checkCaptcha(cmd.getOldEmail(), cmd.getOldCaptcha())) {
            throw new BizException(CaptchaCodeEnum.B_CAPTCHA_ERROR.getCode(), CaptchaCodeEnum.B_CAPTCHA_ERROR.getMessage());
        }
        if (!emailService.checkCaptcha(cmd.getNewEmail(), cmd.getNewCaptcha())) {
            throw new BizException(CaptchaCodeEnum.B_CAPTCHA_ERROR.getCode(), CaptchaCodeEnum.B_CAPTCHA_ERROR.getMessage());
        }
        UserEntity save = userGateway.save(UserAssembler.toEntity(cmd));
        return true;
    }

}
