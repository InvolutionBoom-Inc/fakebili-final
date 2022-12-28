package com.fakebili.app.user.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.app.user.executor.command.UserInfoUpdateCmdExe;
import com.fakebili.app.user.executor.command.UserStatisticSaveCmdExe;
import com.fakebili.app.user.executor.query.UserInfoCmdExe;
import com.fakebili.client.user.api.IUserStatisticService;
import com.fakebili.client.user.dto.command.UserInfoUpdateCmd;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    private final UserInfoUpdateCmdExe userInfoUpdateCmdExe;
    private final UserInfoCmdExe userInfoCmdExe;

    @Override
    public Response save(UserStatisticSaveCmd cmd) {
        userStatisticSaveCmdExe.execute(cmd);
        return Response.buildSuccess();
    }

    @Override
    public SingleResponse<Map<String, Object>> getUserInfo(Integer id) {
        return SingleResponse.of(userInfoCmdExe.getUserInfo(id));
    }

    @Override
    public Response update(UserInfoUpdateCmd cmd) {
        userInfoUpdateCmdExe.execute(cmd);
        return Response.buildSuccess();
    }
}
