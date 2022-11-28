package com.fakebili.app.user.assembler;

import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import com.fakebili.client.user.dto.data.UserStatisticVO;
import com.fakebili.domain.user.entity.UserStatisticEntity;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 12:11:45
 * @since 0.1.0
 */
public class UserStatisticAssembler {

    private UserStatisticAssembler(){
    }

    public static UserStatisticEntity toEntity(UserStatisticSaveCmd co) {

        UserStatisticEntity userStatisticEntity = new UserStatisticEntity();
        userStatisticEntity.setId(co.getId());
        userStatisticEntity.setDynamicCount(co.getDynamicCount());
        userStatisticEntity.setCoinCount(co.getCoinCount());
        userStatisticEntity.setGotLikesCount(co.getGotLikesCount());

        return userStatisticEntity;

    }

    public static UserStatisticVO toValueObject(UserStatisticEntity userEntity) {

        UserStatisticVO userStatisticVO = new UserStatisticVO();
        userStatisticVO.setId(userEntity.getId());
        userStatisticVO.setDynamicCount(userEntity.getDynamicCount());
        userStatisticVO.setCoinCount(userEntity.getCoinCount());
        userStatisticVO.setGotLikesCount(userEntity.getGotLikesCount());

        return userStatisticVO;

    }

}
