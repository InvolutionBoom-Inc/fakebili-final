package com.fakebili.app.user.executor.command.query;

import com.fakebili.domain.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 09:11:21
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class UserCheckIdQueryExe {

    @Resource
    private UserGateway userGateway;

    public Boolean execute(Integer id) {
        return userGateway.checkById(id);
    }
}
