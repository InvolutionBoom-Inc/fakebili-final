package com.fakebili.infrastructure.user.gateway.impl;

import com.alibaba.cola.exception.BizException;
import com.fakebili.domain.user.entity.UserRoleEntity;
import com.fakebili.domain.user.gateway.UserRoleGateway;
import com.fakebili.infrastructure.constant.enums.error.system.SystemCodeEnum;
import com.fakebili.infrastructure.constant.enums.error.user.UserRoleCodeEnum;
import com.fakebili.infrastructure.user.database.converter.UserRoleConverter;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserRoleDO;
import com.fakebili.infrastructure.user.gateway.impl.database.mapper.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lgz
 * @version 0.1.0 2022/11/27 22:11:40
 * @since 0.1.0
 */
@Component("userRoleGateway")
@RequiredArgsConstructor
public class UserRoleGatewayImpl implements UserRoleGateway {

    private final UserRoleMapper userRoleMapper;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public UserRoleEntity save(UserRoleEntity userRoleEntity) {
        // 新增
        if (userRoleEntity.getId() == null) {
            return addUserRole(userRoleEntity);
        }
        // 修改
        return modifyUserRole(userRoleEntity);
    }

    /**
     * 新增用户
     */
    private UserRoleEntity addUserRole(UserRoleEntity userRoleEntity) {

        try {
            userRoleMapper.insert(UserRoleConverter.toAddUserRoleDO(userRoleEntity));
        } catch (Exception e) {
            throw new BizException(UserRoleCodeEnum.B_USER_ROLE_ERROR.getMessage());
        }

        return userRoleEntity;

    }

    /**
     * 修改用户
     */
    private UserRoleEntity modifyUserRole(UserRoleEntity userRoleEntity) {

        UserRoleDO userRoleDO = UserRoleConverter.toAddUserRoleDO(userRoleEntity);
        if (userRoleMapper.selectById(userRoleDO.getId()) == null) {
            throw new BizException(UserRoleCodeEnum.B_USER_ROLE_UNDEFINED.getMessage());
        }

        try {
            userRoleMapper.updateById(userRoleDO);
        } catch (Exception e) {
            throw new BizException(SystemCodeEnum.B_SERVER_ERROR.getMessage());
        }

        return UserRoleConverter.toEntity(userRoleDO);

    }

}
