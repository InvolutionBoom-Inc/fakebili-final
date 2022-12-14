package com.fakebili.infrastructure.user.gateway.impl;

import com.alibaba.cola.exception.BizException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.infrastructure.constant.enums.error.system.SystemCodeEnum;
import com.fakebili.infrastructure.constant.enums.error.user.UserCodeEnum;
import com.fakebili.infrastructure.user.database.converter.UserConverter;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserDO;
import com.fakebili.infrastructure.user.gateway.impl.database.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
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
    public UserEntity selectUser(Integer userId, String username) {
        LambdaQueryWrapper<UserDO> user = new LambdaQueryWrapper<>();
        user.eq(UserDO::getNickname, username).or().eq(UserDO::getId, userId);
        return UserConverter.toEntity(userMapper.selectOne(user));
    }

    @Override
    public Boolean checkById(Integer id) {
        return userMapper.selectById(id) != null;
    }

    @Override
    public UserEntity getInfo(Integer id) {
        UserDO userDO = userMapper.selectById(id);
        if (userDO == null) {
            throw new BizException(UserCodeEnum.B_USER_UNDEFINED.getMessage());
        }
        return UserConverter.toEntity(userDO);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        Optional<UserDO> findById = Optional.ofNullable(userMapper.selectById(userEntity.getId()));
        if (findById.isEmpty()) {
            throw new BizException(UserCodeEnum.B_USER_UNDEFINED.getMessage());
        }

        UserDO userDO = findById.get();
        userDO.setNickname(userEntity.getNickname());
        userDO.setSex(userEntity.getSex());

        // 2. 再保存userDO
        try {
            userMapper.updateById(userDO);
        } catch (Exception e) {
            throw new BizException(SystemCodeEnum.B_SERVER_ERROR.getMessage());
        }

        return UserConverter.toEntity(userDO);
    }

    /**
     * 新增用户
     */
    private UserEntity addUser(UserEntity userEntity) {
        try {
            userMapper.insert(UserConverter.toAddUserDO(userEntity));
        } catch (Exception e) {
            throw new BizException(UserCodeEnum.B_USER_USER_REPEAT.getMessage());
        }

        LambdaQueryWrapper<UserDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserDO::getEmail, userEntity.getEmail());
        UserDO userDO = userMapper.selectOne(queryWrapper);

        userEntity.setId(userDO.getId());

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
        userDO.setPassword(userEntity.getPassword());
        userDO.setEmail(userEntity.getEmail());

        // 2. 再保存userDO
        try {
            userMapper.updateById(userDO);
        } catch (Exception e) {
            throw new BizException(SystemCodeEnum.B_SERVER_ERROR.getMessage());
        }

        return UserConverter.toEntity(userDO);
    }

}
