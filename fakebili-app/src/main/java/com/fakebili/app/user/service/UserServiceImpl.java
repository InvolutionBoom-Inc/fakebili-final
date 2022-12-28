package com.fakebili.app.user.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Query;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.app.user.executor.command.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fakebili.app.user.executor.command.ResetPasswordCmdExe;
import com.fakebili.app.user.executor.command.UserRegisterCmdExe;
import com.fakebili.app.user.executor.command.UserRoleSaveCmdExe;
import com.fakebili.app.user.executor.command.UserStatisticSaveCmdExe;
import com.fakebili.app.user.executor.query.UserLoginCmdExe;
import com.fakebili.client.user.api.IUserService;
import com.fakebili.client.user.dto.command.ResetPasswordCmd;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.command.UserRoleSaveCmd;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import com.fakebili.client.user.dto.data.UserVO;
import com.fakebili.client.user.dto.query.UserLoginCmd;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserDO;
import com.fakebili.infrastructure.user.gateway.impl.database.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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

    private final ResetPasswordCmdExe resetPasswordCmdExe;

    private final UserLogoutCmdExe userLogoutCmdExe;

    private final UserMapper userMapper;

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

    @Override
    public Response resetPassword(ResetPasswordCmd cmd) {
        resetPasswordCmdExe.execute(cmd);
        return Response.buildSuccess();
    }

    @Override
    public Response logout() {
        userLogoutCmdExe.execute();
        return Response.buildSuccess();
    }

    @Override
    public Boolean queryOnByNickname(String nickname) {
        QueryWrapper<UserDO> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("nickname",nickname);
        UserDO userDO = userMapper.selectOne(userQueryWrapper);
        if (userDO!=null){
            return true;
        }else {
            return false;

        }
    }

}
