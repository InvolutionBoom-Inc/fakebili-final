package com.fakebili.user.command;

import com.fakebili.domain.gateway.UserGateway;
import com.fakebili.domain.user.UserEntity;
import com.fakebili.dto.UserRegisterCmd;
import com.fakebili.dto.data.UserVO;
import com.fakebili.user.assembler.UserAssembler;
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
        UserEntity userEntity = userGateway.save(UserAssembler.toEntity(cmd));
        return UserAssembler.toValueObject(userEntity);
    }

}
