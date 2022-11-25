package com.fakebili.domain.gateway;

import com.fakebili.domain.user.UserEntity;

/**
 * @author lgz
 * @version 0.1.0 2022/11/24 18:11:43
 * @since 0.1.0
 */
public interface UserGateway {

    /**
     * 保存用户
     *
     * @param userEntity User Domain
     * @return 用户实体
     */
    UserEntity save(UserEntity userEntity);

    /**
     * 判断用户名是否已存在
     *
     * @param userId   用户ID
     * @param username 用户名
     * @return true-已存在
     */
    Boolean checkByUsername(Long userId, String username);
}
