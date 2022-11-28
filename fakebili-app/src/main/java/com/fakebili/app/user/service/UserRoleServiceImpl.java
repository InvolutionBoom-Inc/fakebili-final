package com.fakebili.app.user.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.fakebili.app.user.executor.command.UserRoleSaveCmdExe;
import com.fakebili.client.user.api.IUserRoleService;
import com.fakebili.client.user.dto.command.UserRoleSaveCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 13:11:02
 * @since 0.1.0
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class UserRoleServiceImpl implements IUserRoleService {

    private final UserRoleSaveCmdExe userRoleSaveCmdExe;

    @Override
    public Response save(UserRoleSaveCmd cmd) {
        userRoleSaveCmdExe.execute(cmd);
        return Response.buildSuccess();
    }
}
