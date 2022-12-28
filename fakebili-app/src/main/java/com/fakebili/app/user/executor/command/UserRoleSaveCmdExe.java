package com.fakebili.app.user.executor.command;

import com.alibaba.cola.exception.BizException;
import com.fakebili.app.user.assembler.UserRoleAssembler;
import com.fakebili.client.user.dto.command.UserRoleSaveCmd;
import com.fakebili.domain.role.gateway.RoleGateway;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.domain.user.gateway.UserRoleGateway;
import com.fakebili.infrastructure.constant.enums.error.role.RoleCodeEnum;
import com.fakebili.infrastructure.constant.enums.error.user.UserCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author lgz
 * @version 0.1.0 2022/11/27 22:11:20
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class UserRoleSaveCmdExe {
    private final UserRoleGateway userRoleGateway;

    private final UserGateway userGateway;
    private final RoleGateway roleGateway;

    public Boolean execute(UserRoleSaveCmd cmd) {

        if (Boolean.FALSE.equals(userGateway.checkById(cmd.getMid()))) {
            throw new BizException(UserCodeEnum.B_USER_UNDEFINED.getCode(), UserCodeEnum.B_USER_UNDEFINED.getMessage());
        }
        if (Boolean.FALSE.equals(roleGateway.checkById(cmd.getRoleId()))) {
            throw new BizException(RoleCodeEnum.B_ROLE_UNDEFINED.getCode(), RoleCodeEnum.B_ROLE_UNDEFINED.getMessage());
        }
        userRoleGateway.save(UserRoleAssembler.toEntity(cmd));
        return true;

    }
}
