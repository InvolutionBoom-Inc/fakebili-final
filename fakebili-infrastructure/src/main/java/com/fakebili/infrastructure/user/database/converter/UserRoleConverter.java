package com.fakebili.infrastructure.user.database.converter;

import com.fakebili.domain.user.entity.UserRoleEntity;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserRoleDO;
import org.springframework.beans.BeanUtils;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 09:11:05
 * @since 0.1.0
 */
public class UserRoleConverter {

    public static UserRoleDO toAddUserRoleDO(UserRoleEntity userRoleEntity) {
        UserRoleDO userRoleDO = new UserRoleDO();
        BeanUtils.copyProperties(userRoleEntity, userRoleDO);
        return userRoleDO;
    }

    public static UserRoleEntity toEntity(UserRoleDO userRoleDO) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        BeanUtils.copyProperties(userRoleDO, userRoleEntity);
        return userRoleEntity;
    }
}
