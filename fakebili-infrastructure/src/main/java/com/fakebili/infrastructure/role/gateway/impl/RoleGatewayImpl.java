package com.fakebili.infrastructure.role.gateway.impl;

import com.fakebili.domain.role.gateway.RoleGateway;
import com.fakebili.infrastructure.role.gateway.impl.database.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:48
 * @since 0.1.0
 */
@Component("roleGateway")
@RequiredArgsConstructor
public class RoleGatewayImpl implements RoleGateway {

    private final RoleMapper roleMapper;

    @Override
    public Boolean checkById(Integer id) {
        return roleMapper.selectById(id) != null;
    }
}
