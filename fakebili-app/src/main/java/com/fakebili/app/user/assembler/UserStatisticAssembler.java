package com.fakebili.app.user.assembler;

import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import com.fakebili.client.user.dto.data.UserStatisticVO;
import com.fakebili.domain.user.entity.UserEntity;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 12:11:45
 * @since 0.1.0
 */
public class UserStatisticAssembler {

    private UserStatisticAssembler() {
    }

    public static UserEntity toEntity(UserStatisticSaveCmd co) {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(co.getId());
        userEntity.setDynamicCount(co.getDynamicCount());
        userEntity.setCoinCount(co.getCoinCount());
        userEntity.setGotLikesCount(co.getGotLikesCount());

        return userEntity;

    }

    public static UserStatisticVO toValueObject(UserEntity userEntity) {

        UserStatisticVO userStatisticVO = new UserStatisticVO();
        userStatisticVO.setId(userEntity.getId());
        userStatisticVO.setDynamicCount(userEntity.getDynamicCount());
        userStatisticVO.setCoinCount(userEntity.getCoinCount());
        userStatisticVO.setGotLikesCount(userEntity.getGotLikesCount());

        return userStatisticVO;

    }

}
