package com.fakebili.app.user.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.app.user.executor.command.UserLoginCmdExe;
import com.fakebili.app.user.executor.command.UserRegisterCmdExe;
import com.fakebili.app.user.executor.command.UserRoleSaveCmdExe;
import com.fakebili.app.user.executor.command.UserStatisticSaveCmdExe;
import com.fakebili.client.user.api.IUserService;
import com.fakebili.client.user.dto.command.UserLoginCmd;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.command.UserRoleSaveCmd;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import com.fakebili.client.user.dto.data.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 23:11:09
 * @since 0.1.0
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRegisterCmdExe userRegisterCmdExe;

    private final UserLoginCmdExe userLoginCmdExe;

    private final UserRoleSaveCmdExe userRoleSaveCmdExe;

    private final UserStatisticSaveCmdExe userStatisticSaveCmdExe;

    @Override
    public SingleResponse<UserVO> register(UserRegisterCmd cmd) {

        UserVO vo = userRegisterCmdExe.execute(cmd);

        UserRoleSaveCmd userRoleSaveCmd = new UserRoleSaveCmd();
        userRoleSaveCmd.setRoleId(2);
        userRoleSaveCmd.setMid(vo.getId());
        userRoleSaveCmdExe.execute(userRoleSaveCmd);

        UserStatisticSaveCmd userStatisticSaveCmd = new UserStatisticSaveCmd();
        userStatisticSaveCmd.setId(vo.getId());
        userStatisticSaveCmd.setDynamicCount(0);
        userStatisticSaveCmd.setCoinCount(0);
        userStatisticSaveCmd.setGotLikesCount(0);

        userStatisticSaveCmdExe.execute(userStatisticSaveCmd);
        return SingleResponse.of(vo);

    }

    @Override
    public SingleResponse<Map<String, Object>> login(UserLoginCmd cmd) {
        return SingleResponse.of(userLoginCmdExe.execute(cmd));
    }

}
