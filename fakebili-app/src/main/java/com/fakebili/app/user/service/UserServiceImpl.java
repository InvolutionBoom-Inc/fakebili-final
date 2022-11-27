package com.fakebili.app.user.service;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.client.user.api.IUserService;
import com.fakebili.app.user.executor.command.UserRegisterCmdExe;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.data.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 23:11:09
 * @since 0.1.0
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRegisterCmdExe userRegisterCmdExe;

    @Override
    public SingleResponse<UserVO> register(UserRegisterCmd cmd) {
        UserVO vo = userRegisterCmdExe.execute(cmd);
        return SingleResponse.of(vo);
    }

}
