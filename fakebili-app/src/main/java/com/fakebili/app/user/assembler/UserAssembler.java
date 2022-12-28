package com.fakebili.app.user.assembler;

import com.fakebili.client.user.dto.command.ResetPasswordCmd;
import com.fakebili.client.user.dto.command.UserInfoUpdateCmd;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.data.UserVO;
import com.fakebili.domain.user.entity.UserEntity;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 22:11:55
 * @since 0.1.0
 */
public class UserAssembler {

    private UserAssembler() {
    }

    public static UserEntity toEntity(UserRegisterCmd co) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNickname(co.getNickname());
        userEntity.setEmail(co.getEmail());
        userEntity.setPassword(co.getPassword());
        return userEntity;
    }

    public static UserEntity toEntity(ResetPasswordCmd co) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(co.getId());
        userEntity.setEmail(co.getEmail());
        userEntity.setPassword(co.getPassword());
        return userEntity;
    }

    public static UserEntity toEntity(UserInfoUpdateCmd co) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(co.getId());
        userEntity.setNickname(co.getNickname());
        userEntity.setSex(co.getSex());
        return userEntity;
    }

    public static UserVO toValueObject(UserEntity userEntity) {
        UserVO userVO = new UserVO();
        userVO.setId(userEntity.getId());
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
