package com.fakebili.app.user.executor.command;

import com.alibaba.cola.exception.BizException;
import com.fakebili.client.user.dto.data.error.user.UserCodeEnum;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.data.UserVO;
import com.fakebili.app.user.assembler.UserAssembler;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 23:11:10
 * @since 0.1.0
 */
@Component
public class UserRegisterCmdExe {

    @Resource
    private UserGateway userGateway;

    public UserVO execute(UserRegisterCmd cmd) {
        boolean isLegalNickname = SensitiveWordHelper.contains(cmd.getNickname());
        if(isLegalNickname){
            throw new BizException(UserCodeEnum.B_USER_NICKNAME_ERROR.getCode(),UserCodeEnum.B_USER_NICKNAME_ERROR.getMessage());
        }

        UserEntity userEntity = userGateway.save(UserAssembler.toEntity(cmd));
        return UserAssembler.toValueObject(userEntity);
    }

}
