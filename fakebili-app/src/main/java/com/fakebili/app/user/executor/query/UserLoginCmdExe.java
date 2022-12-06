package com.fakebili.app.user.executor.query;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.cola.exception.BizException;
import com.fakebili.app.user.assembler.UserAssembler;
import com.fakebili.client.user.dto.data.UserVO;
import com.fakebili.client.user.dto.query.UserLoginCmd;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.domain.user.gateway.UserGateway;
import com.fakebili.infrastructure.constant.enums.error.user.UserCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 23:11:10
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class UserLoginCmdExe {

    @Resource
    private UserGateway userGateway;

    public Map<String, Object> execute(UserLoginCmd cmd) {
        String encodedPassword = MD5.create().digestHex(cmd.getPassword() + "114514");

        UserEntity userEntity = (UserEntity) userGateway.selectUser(null, cmd.getNickname());
        if (!userEntity.getPassword().equals(encodedPassword)) {
            throw new BizException(UserCodeEnum.B_USER_PASSWORD_ERROR.getMessage());
        }

        StpUtil.login(userEntity.getId());

        UserVO user = UserAssembler.toValueObject(userEntity);
        HashMap<String, Object> data = new HashMap<>();
        data.put("user", user);
        data.put("permission_list", StpUtil.getPermissionList());
        data.put("role_list", StpUtil.getRoleList());
        data.put("token", StpUtil.getTokenValue());

        return data;
    }

}
