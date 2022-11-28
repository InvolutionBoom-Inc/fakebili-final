package com.fakebili.app.user.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.app.user.executor.command.UserRegisterCmdExe;
import com.fakebili.app.user.executor.command.UserRoleSaveCmdExe;
import com.fakebili.app.user.executor.command.UserStatisticSaveCmdExe;
import com.fakebili.app.user.executor.command.query.UserCheckIdQueryExe;
import com.fakebili.client.user.api.IUserService;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.command.UserRoleSaveCmd;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import com.fakebili.client.user.dto.data.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    private final UserRoleSaveCmdExe userRoleSaveCmdExe;

    private final UserCheckIdQueryExe userCheckIdQueryExe;

    private final UserStatisticSaveCmdExe userStatisticSaveCmdExe;

    @Override
    public SingleResponse<UserVO> register(UserRegisterCmd cmd) {

        UserVO vo = userRegisterCmdExe.execute(cmd);
        userRoleSaveCmdExe.execute(UserRoleSaveCmd.builder().mid(vo.getId()).roleId(2).build());
        userStatisticSaveCmdExe.execute(UserStatisticSaveCmd.builder().id(vo.getId()).coinCount(0).dynamicCount(0).gotLikesCount(0).build());
        return SingleResponse.of(vo);

    }

    @Override
    public Boolean checkId(Integer id) {
        return userCheckIdQueryExe.execute(id);
    }

}
