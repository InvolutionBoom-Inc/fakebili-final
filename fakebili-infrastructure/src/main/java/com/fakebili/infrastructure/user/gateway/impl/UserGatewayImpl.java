package com.fakebili.infrastructure.user.gateway.impl;

import com.alibaba.cola.exception.BizException;
import com.fakebili.infrastructure.user.database.converter.UserConverter;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.client.user.dto.data.error.user.UserCodeEnum;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserDO;
import com.fakebili.infrastructure.user.gateway.impl.database.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

/**
 * @author lgz
 * @version 0.1.0 2022/11/24 18:11:05
 * @since 0.1.0
 */
@Component("userGateway")
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public UserEntity save(UserEntity userEntity) {
        // 新增
        if (Objects.isNull(userEntity.getId())) {
            return addUser(userEntity);
        }

        // 修改
        return modifyUser(userEntity);
    }

    @Override
    public Boolean checkByUsername(Long userId, String username) {
        return null;
    }

    /**
     * 新增用户
     */
    private UserEntity addUser(UserEntity userEntity) {
        UserDO queryUser = userMapper.selectById(userEntity.getId());
        if (queryUser != null) {
            throw new BizException(UserCodeEnum.B_USER_USERNAME_REPEAT.getMessage());
        }

        // 2. 再保存userDO
        UserDO userDO = UserConverter.toAddUserDO(userEntity);
        int update = userMapper.insert(userDO);
        if (update < 1) {
            throw new PersistenceException("注册用户异常");
        }

        return userEntity;
    }

    /**
     * 修改用户
     */
    private UserEntity modifyUser(UserEntity userEntity) {
        Optional<UserDO> findById = Optional.ofNullable(userMapper.selectById(userEntity.getId()));
        if (findById.isEmpty()) {
            throw new BizException(UserCodeEnum.B_USER_UNDEFINED.getMessage());
        }

        UserDO userDO = findById.get();

        // 2. 再保存userDO
        int update = userMapper.update(userDO, null);
        if (update < 1) {
            throw new PersistenceException("更新用户异常");
        }

        return UserConverter.toEntity(userDO);
    }

}
