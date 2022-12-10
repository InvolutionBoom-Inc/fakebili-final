package com.fakebili.app.user.executor.query;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.fakebili.app.user.assembler.UserInfoAssembler;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.domain.user.gateway.UserStatisticGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zzl
 * @date 2022/12/07 15:58:37
 * @description
 */
@Component
@RequiredArgsConstructor
public class UserInfoCmdExe {

    private final UserGateway userGateway;
    private final UserStatisticGateway userStatisticGateway;

    public Map<String, Object> getUserInfo(Integer id) {
        UserEntity userinfo = copyUserInfo(userGateway.getInfo(id));
        UserEntity info = infoMerge(userStatisticGateway.info(userinfo), userinfo);
        return UserInfoAssembler.toMap(UserInfoAssembler.toValueObject(info));
    }

    public UserEntity copyUserInfo(UserEntity info) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(info, userEntity);
        return userEntity;
    }

    public UserEntity infoMerge(UserEntity info, UserEntity entity) {
        BeanUtil.copyProperties(info,entity, CopyOptions.create().ignoreNullValue());
        return entity;
    }

}
