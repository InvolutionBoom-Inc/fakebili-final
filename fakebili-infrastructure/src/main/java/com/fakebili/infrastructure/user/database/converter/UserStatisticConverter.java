package com.fakebili.infrastructure.user.database.converter;

import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserStatisticDO;
import org.springframework.beans.BeanUtils;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 11:11:03
 * @since 0.1.0
 */
public class UserStatisticConverter {

    public static UserEntity toEntity(UserStatisticDO userStatisticDO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userStatisticDO, userEntity);
        return userEntity;
    }

    public static UserStatisticDO toAddUserStatisticDO(UserEntity userEntity) {

        UserStatisticDO userStatisticDO = new UserStatisticDO();
        BeanUtils.copyProperties(userEntity, userStatisticDO);
        return userStatisticDO;
    }

    public static UserStatisticDO toAddValue(UserEntity userEntity) {
        UserStatisticDO userStatisticDO = new UserStatisticDO();
        userStatisticDO.setUserId(userEntity.getId());
        return userStatisticDO;
    }
}
