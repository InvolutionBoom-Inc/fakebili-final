package com.fakebili.infrastructure.config;

import cn.dev33.satoken.stp.StpInterface;
import com.fakebili.infrastructure.user.gateway.impl.database.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zzl
 * @date 2022/11/24 15:53:37
 * @description 自定义权限验证接口扩展
 */
@Component
@RequiredArgsConstructor
public class StpInterfaceImpl implements StpInterface {

    private final UserMapper userMapper;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return userMapper.selectPermsByUserId(Integer.valueOf((String) loginId));
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return userMapper.selectRolesByUserId(Integer.valueOf((String) loginId));
    }

}