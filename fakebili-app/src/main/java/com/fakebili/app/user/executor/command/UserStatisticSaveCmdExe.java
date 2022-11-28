package com.fakebili.app.user.executor.command;

import com.alibaba.cola.exception.BizException;
import com.fakebili.app.user.assembler.UserStatisticAssembler;
import com.fakebili.client.user.api.IUserService;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import com.fakebili.client.user.dto.data.UserStatisticVO;
import com.fakebili.domain.user.entity.UserStatisticEntity;
import com.fakebili.domain.user.gateway.UserStatisticGateway;
import com.fakebili.infrastructure.constant.enums.error.user.UserCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 11:11:40
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class UserStatisticSaveCmdExe {

    @Resource
    private UserStatisticGateway userStatisticGateway;

    private final IUserService userService;

    public UserStatisticVO execute(UserStatisticSaveCmd cmd) {

        if (Boolean.FALSE.equals(userService.checkId(cmd.getId()))) {
            throw new BizException(UserCodeEnum.B_USER_UNDEFINED.getCode(), UserCodeEnum.B_USER_UNDEFINED.getMessage());
        }
        UserStatisticEntity userStatisticEntity = userStatisticGateway.save(UserStatisticAssembler.toEntity(cmd));
        return UserStatisticAssembler.toValueObject(userStatisticEntity);

    }

}
