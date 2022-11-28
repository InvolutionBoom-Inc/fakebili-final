package com.fakebili.infrastructure.user.database.converter;

import com.fakebili.domain.user.entity.UserStatisticEntity;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserStatisticDO;
import org.springframework.beans.BeanUtils;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 11:11:03
 * @since 0.1.0
 */
public class UserStatisticConverter {

    public static UserStatisticEntity toEntity(UserStatisticDO userStatisticDO) {
        UserStatisticEntity userStatisticEntity = new UserStatisticEntity();
        BeanUtils.copyProperties(userStatisticDO, userStatisticEntity);
        return userStatisticEntity;
    }

    public static UserStatisticDO toAddUserStatisticDO(UserStatisticEntity userStatisticEntity) {

        UserStatisticDO userStatisticDO = new UserStatisticDO();
        BeanUtils.copyProperties(userStatisticEntity, userStatisticDO);
        return userStatisticDO;
    }
}
