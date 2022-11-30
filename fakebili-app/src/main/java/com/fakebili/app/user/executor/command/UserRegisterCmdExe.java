package com.fakebili.app.user.executor.command;

import com.alibaba.cola.exception.BizException;
import com.fakebili.app.user.assembler.UserAssembler;
import com.fakebili.client.email.api.IEmailService;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.data.UserVO;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.infrastructure.constant.enums.error.captcha.CaptchaCodeEnum;
import com.fakebili.infrastructure.constant.enums.error.user.UserCodeEnum;
import com.fakebili.infrastructure.constant.security.Encryption;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 23:11:10
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class UserRegisterCmdExe {

    @Resource
    private UserGateway userGateway;

    public final IEmailService emailService;

    public UserVO execute(UserRegisterCmd cmd) {

        if (SensitiveWordHelper.contains(cmd.getNickname())) {
            throw new BizException(UserCodeEnum.B_USER_NICKNAME_ERROR.getCode(), UserCodeEnum.B_USER_NICKNAME_ERROR.getMessage());
        }
        if (!emailService.checkCaptcha(cmd.getEmail(), cmd.getCode())) {
            throw new BizException(CaptchaCodeEnum.B_CAPTCHA_ERROR.getCode(), CaptchaCodeEnum.B_CAPTCHA_ERROR.getMessage());
        }

        cmd.setPassword(Encryption.addSalt(cmd.getPassword()));

        UserEntity userEntity = userGateway.save(UserAssembler.toEntity(cmd));
        return UserAssembler.toValueObject(userEntity);

    }

}
