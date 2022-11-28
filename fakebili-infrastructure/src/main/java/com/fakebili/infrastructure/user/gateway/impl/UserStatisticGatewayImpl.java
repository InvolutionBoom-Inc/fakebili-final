package com.fakebili.infrastructure.user.gateway.impl;

import com.alibaba.cola.exception.BizException;
import com.fakebili.domain.user.entity.UserStatisticEntity;
import com.fakebili.domain.user.gateway.UserStatisticGateway;
import com.fakebili.infrastructure.constant.enums.error.system.SystemCodeEnum;
import com.fakebili.infrastructure.constant.enums.error.user.UserRoleCodeEnum;
import com.fakebili.infrastructure.constant.enums.error.user.UserStatisticCodeEnum;
import com.fakebili.infrastructure.user.database.converter.UserStatisticConverter;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserStatisticDO;
import com.fakebili.infrastructure.user.gateway.impl.database.mapper.UserStatisticMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.exceptions.PersistenceException;
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
    public UserStatisticEntity save(UserStatisticEntity userStatisticEntity) {
        // 新增
        if (userStatisticMapper.selectById(userStatisticEntity.getId()) == null) {
            return addUserStatistic(userStatisticEntity);
        }
        // 修改
        return modifyUserStatistic(userStatisticEntity);

    }

    /**
     * 新增用户
     */
    private UserStatisticEntity addUserStatistic(UserStatisticEntity userStatisticEntity) {

        try {
            userStatisticMapper.insert(UserStatisticConverter.toAddUserStatisticDO(userStatisticEntity));
        } catch (Exception e) {
            throw new BizException(UserStatisticCodeEnum.B_USER_STATISTIC_REPEAT.getMessage());
        }

        return userStatisticEntity;

    }

    /**
     * 修改用户
     */
    private UserStatisticEntity modifyUserStatistic(UserStatisticEntity userStatisticEntity) {

        UserStatisticDO userStatisticDO = UserStatisticConverter.toAddUserStatisticDO(userStatisticEntity);
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
