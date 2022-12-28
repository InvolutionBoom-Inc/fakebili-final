package com.fakebili.app.user.executor.command;

import com.alibaba.cola.exception.BizException;
import com.fakebili.app.user.assembler.UserStatisticAssembler;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import com.fakebili.client.user.dto.data.UserStatisticVO;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.domain.user.gateway.UserStatisticGateway;
import com.fakebili.infrastructure.constant.enums.error.user.UserCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 11:11:40
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class UserStatisticSaveCmdExe {

    private final UserStatisticGateway userStatisticGateway;

    private final UserGateway userGateway;

    public UserStatisticVO execute(UserStatisticSaveCmd cmd) {

        if (Boolean.FALSE.equals(userGateway.checkById(cmd.getId()))) {
            throw new BizException(UserCodeEnum.B_USER_UNDEFINED.getCode(), UserCodeEnum.B_USER_UNDEFINED.getMessage());
        }
        UserEntity userEntity = userStatisticGateway.save(UserStatisticAssembler.toEntity(cmd));
        return UserStatisticAssembler.toValueObject(userEntity);

    }

}
