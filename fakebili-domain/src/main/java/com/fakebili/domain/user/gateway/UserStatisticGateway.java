package com.fakebili.domain.user.gateway;

import com.fakebili.domain.user.entity.UserEntity;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:07
 * @since 0.1.0
 */
public interface UserStatisticGateway {

    /**
     * 保存用户信息
     *
     * @param userEntity userEntity
     * @return 用户信息实体
     */
    UserEntity save(UserEntity userEntity);

    /**
     * 查询用户关联信息
     */
    UserEntity info(UserEntity userEntity);
}