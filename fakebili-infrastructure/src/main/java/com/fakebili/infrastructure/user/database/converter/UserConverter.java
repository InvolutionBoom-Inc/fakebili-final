package com.fakebili.infrastructure.user.database.converter;

import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.domain.user.entity.SexEnum;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserDO;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 22:11:52
 * @since 0.1.0
 */
public class UserConverter {

    public static UserEntity toEntity(UserDO userDO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDO, userEntity);
        return userEntity;
    }

    public static UserDO toAddUserDO(UserEntity userEntity) {
        UserDO userDO = new UserDO();
        userDO.setId(userEntity.getId());
        userDO.setNickname(userEntity.getNickname());
        userDO.setEmail(userEntity.getEmail());
        userDO.setTel(userEntity.getTel());
        userDO.setPassword(userEntity.getPassword());
        userDO.setSex(userEntity.getSex() == null ? SexEnum.DEFAULT : userEntity.getSex());
        userDO.setFace(userEntity.getFace());
        userDO.setJointime(userEntity.getJointime() == null ? Timestamp.from(Instant.now()).toLocalDateTime() : userEntity.getJointime());
        userDO.setSilence(userEntity.getSilence() != null && userEntity.getSilence());
        return userDO;
    }

}
