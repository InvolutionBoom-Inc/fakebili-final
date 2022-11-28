package com.fakebili.app.role.executor.command.query;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.fakebili.domain.role.gateway.RoleGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:48
 * @since 0.1.0
 */
@Component
@CatchAndLog
@RequiredArgsConstructor
public class RoleCheckIdQueryExe {

    @Resource
    private RoleGateway roleGateway;

    public Boolean execute(Integer id) {
        return roleGateway.checkById(id);
    }

}
