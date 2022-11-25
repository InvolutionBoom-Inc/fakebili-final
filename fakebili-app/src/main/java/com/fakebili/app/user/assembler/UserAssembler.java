package com.fakebili.app.user.assembler;

import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.data.UserVO;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 22:11:55
 * @since 0.1.0
 */
public class UserAssembler {

    public static UserEntity toEntity(UserRegisterCmd co) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNickname(co.getNickname());
        userEntity.setEmail(co.getEmail());
        userEntity.setPassword(co.getPassword());
        return userEntity;
    }

    public static UserVO toValueObject(UserEntity userEntity) {
        UserVO userVO = new UserVO();
        userVO.setNickname(userEntity.getNickname());
        userVO.setEmail(userEntity.getEmail());
        userVO.setTel(userEntity.getTel());
        userVO.setSex(userEntity.getSex());
        userVO.setFace(userEntity.getFace());
        userVO.setJointime(userEntity.getJointime());
        userVO.setSilence(userEntity.getSilence());
        return userVO;
    }

}
