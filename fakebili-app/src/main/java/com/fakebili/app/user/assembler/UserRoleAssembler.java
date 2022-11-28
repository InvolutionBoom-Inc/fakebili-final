package com.fakebili.app.user.assembler;

import com.fakebili.client.user.dto.command.UserRoleSaveCmd;
import com.fakebili.domain.user.entity.UserRoleEntity;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 09:11:20
 * @since 0.1.0
 */
public class UserRoleAssembler {

    private UserRoleAssembler(){
    }

    public static UserRoleEntity toEntity(UserRoleSaveCmd co) {
        return UserRoleEntity.builder().id(co.getId()).roleId(co.getRoleId()).mid(co.getMid()).build();
    }
}
