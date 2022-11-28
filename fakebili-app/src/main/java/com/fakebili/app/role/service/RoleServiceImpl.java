package com.fakebili.app.role.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.fakebili.app.role.executor.command.query.RoleCheckIdQueryExe;
import com.fakebili.client.role.api.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:17
 * @since 0.1.0
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final RoleCheckIdQueryExe roleCheckIdQueryExe;

    @Override
    public Boolean checkId(Integer id) {
        return roleCheckIdQueryExe.execute(id);
    }
}
