package com.fakebili.client.user.api;

import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.data.UserVO;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 23:11:50
 * @since 0.1.0
 */
public interface IUserService {

    /**
     * 注册用户
     *
     * @param cmd 用户注册请求
     * @return Response
     */
    UserVO register(UserRegisterCmd cmd);
}
