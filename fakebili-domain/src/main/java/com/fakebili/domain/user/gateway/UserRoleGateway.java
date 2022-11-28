package com.fakebili.domain.user.gateway;

import com.fakebili.domain.user.entity.UserRoleEntity;

/**
 * @author lgz
 * @version 0.1.0 2022/11/27 22:11:44
 * @since 0.1.0
 */
public interface UserRoleGateway {

    /**
     * 保存用户关联角色信息
     * @param userRoleEntity mid，role_id
     * @return 是否成功
     */
    UserRoleEntity save(UserRoleEntity userRoleEntity);
}
