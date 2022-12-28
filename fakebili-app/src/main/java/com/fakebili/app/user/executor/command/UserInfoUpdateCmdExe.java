package com.fakebili.app.user.executor.command;

import com.alibaba.cola.exception.BizException;
import com.fakebili.app.user.assembler.UserAssembler;
import com.fakebili.app.user.assembler.UserInfoAssembler;
import com.fakebili.client.user.api.IUserService;
import com.fakebili.client.user.dto.command.UserInfoUpdateCmd;
import com.fakebili.client.user.dto.data.UserInfoVO;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.infrastructure.constant.enums.error.user.UserCodeEnum;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Gwj
 * @ClassName UserInfoUpdateCmdExe
 * @description ****
 * @since 2022/12/27 16:12:24
 */
@Component
@RequiredArgsConstructor
public class UserInfoUpdateCmdExe {

    private final UserGateway userGateway;

    private final IUserService userService;

    public UserInfoVO execute(UserInfoUpdateCmd cmd){
        if (SensitiveWordHelper.contains(cmd.getNickname())) {
            throw new BizException(UserCodeEnum.B_USER_NICKNAME_ERROR.getCode(), UserCodeEnum.B_USER_NICKNAME_ERROR.getMessage());
        }
        if (userService.queryOnByNickname(cmd.getNickname())){
            throw new BizException(UserCodeEnum.B_USER_NICKNAME_EXIST.getCode(), UserCodeEnum.B_USER_NICKNAME_EXIST.getMessage());
        }
        UserEntity userEntity = userGateway.update(UserAssembler.toEntity(cmd));
        return UserInfoAssembler.toValueObject(userEntity);
    }
}
