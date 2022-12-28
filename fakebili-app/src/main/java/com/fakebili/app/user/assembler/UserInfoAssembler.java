package com.fakebili.app.user.assembler;

import com.fakebili.client.user.dto.data.UserInfoVO;
import com.fakebili.domain.user.entity.UserEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzl
 * @date 2022/12/08 14:08:42
 * @description
 */
public class UserInfoAssembler {
    private UserInfoAssembler() {

    }

    public static UserInfoVO toValueObject(UserEntity userEntity) {

        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setNickname(userEntity.getNickname());
        userInfoVO.setFace(userEntity.getFace());
        userInfoVO.setDynamicCount(userEntity.getDynamicCount());
        userInfoVO.setCoinCount(userEntity.getCoinCount());
        userInfoVO.setGotLikesCount(userEntity.getGotLikesCount());

        return userInfoVO;

    }

    public static Map<String, Object> toMap(UserInfoVO vo) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", vo.getId());
        data.put("nickname", vo.getNickname());
        data.put("face", vo.getFace());
        data.put("dynamic_count", vo.getDynamicCount());
        data.put("coin_count", vo.getCoinCount());
        data.put("gotLikes_count", vo.getGotLikesCount());
        return data;
    }
}
