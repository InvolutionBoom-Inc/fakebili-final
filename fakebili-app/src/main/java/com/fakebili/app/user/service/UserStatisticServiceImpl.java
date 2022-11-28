package com.fakebili.app.user.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.fakebili.app.user.executor.command.UserStatisticSaveCmdExe;
import com.fakebili.client.user.api.IUserStatisticService;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 13:11:14
 * @since 0.1.0
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class UserStatisticServiceImpl implements IUserStatisticService {

    private final UserStatisticSaveCmdExe userStatisticSaveCmdExe;

    @Override
    public Response save(UserStatisticSaveCmd cmd) {
        userStatisticSaveCmdExe.execute(cmd);
        return Response.buildSuccess();
    }
}
