package com.fakebili.service;

import com.fakebili.api.IUserService;
import com.fakebili.dto.UserRegisterCmd;
import com.fakebili.dto.data.UserVO;
import com.fakebili.user.command.UserRegisterCmdExe;
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
    public UserVO register(UserRegisterCmd cmd) {
        return userRegisterCmdExe.execute(cmd);
    }

}
