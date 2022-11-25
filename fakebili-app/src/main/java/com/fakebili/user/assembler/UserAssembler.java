package com.fakebili.user.assembler;

import com.fakebili.domain.user.UserEntity;
import com.fakebili.dto.UserRegisterCmd;
import com.fakebili.dto.data.UserVO;

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
