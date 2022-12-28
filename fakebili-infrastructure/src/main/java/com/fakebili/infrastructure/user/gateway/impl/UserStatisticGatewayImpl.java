package com.fakebili.infrastructure.user.gateway.impl;

import com.alibaba.cola.exception.BizException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.domain.user.gateway.UserStatisticGateway;
import com.fakebili.infrastructure.constant.enums.error.system.SystemCodeEnum;
import com.fakebili.infrastructure.constant.enums.error.user.UserStatisticCodeEnum;
import com.fakebili.infrastructure.user.database.converter.UserStatisticConverter;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserStatisticDO;
import com.fakebili.infrastructure.user.gateway.impl.database.mapper.UserStatisticMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:28
 * @since 0.1.0
 */
@Component("userStatisticGateway")
@RequiredArgsConstructor
public class UserStatisticGatewayImpl implements UserStatisticGateway {

    private final UserStatisticMapper userStatisticMapper;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public UserEntity save(UserEntity userEntity) {
        // 新增
        if (userStatisticMapper.selectById(userEntity.getId()) == null) {
            return addUserStatistic(userEntity);
        }
        // 修改
        return modifyUserStatistic(userEntity);

    }

    /**
     * 查询用户关联信息
     */
    public UserEntity info(UserEntity userEntity) {
        LambdaQueryWrapper<UserStatisticDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserStatisticDO::getUserId, userEntity.getId());
        UserStatisticDO userStatisticDO = userStatisticMapper.selectOne(wrapper);
        if (userStatisticDO == null) {
            throw new BizException(UserStatisticCodeEnum.B_USER_STATISTIC_UNDEFINED.getMessage());
        }
        return UserStatisticConverter.toEntity(userStatisticDO);
    }

    /**
     * 新增用户
     */
    private UserEntity addUserStatistic(UserEntity userEntity) {

        try {
            userStatisticMapper.insert(UserStatisticConverter.toAddUserStatisticDO(userEntity));
        } catch (Exception e) {
            throw new BizException(UserStatisticCodeEnum.B_USER_STATISTIC_REPEAT.getMessage());
        }

        return userEntity;

    }

    /**
     * 修改用户
     */
    private UserEntity modifyUserStatistic(UserEntity userEntity) {

        UserStatisticDO userStatisticDO = UserStatisticConverter.toAddUserStatisticDO(userEntity);
        if (userStatisticMapper.selectById(userStatisticDO.getId()) == null) {
            throw new BizException(UserStatisticCodeEnum.B_USER_STATISTIC_UNDEFINED.getMessage());
        }

        try {
            userStatisticMapper.updateById(userStatisticDO);
        } catch (Exception e) {
            throw new BizException(SystemCodeEnum.B_SERVER_ERROR.getMessage());
        }

        return UserStatisticConverter.toEntity(userStatisticDO);

    }


}
