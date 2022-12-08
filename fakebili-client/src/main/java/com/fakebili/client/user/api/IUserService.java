package com.fakebili.client.user.api;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.client.user.dto.command.ResetPasswordCmd;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.data.UserVO;
import com.fakebili.client.user.dto.query.UserLoginCmd;

import java.util.Map;

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
    SingleResponse<UserVO> register(UserRegisterCmd cmd);

    /**
     * 用户登录
     *
     * @param cmd 用户登录请求
     * @return Response
     */
    SingleResponse<Map<String, Object>> login(UserLoginCmd cmd);

    /**
     * 忘记密码
     *
     * @param cmd 忘记密码请求
     * @return Response
     */
    Response resetPassword(ResetPasswordCmd cmd);

    /**
     * 登出
     *
     * @return Response
     */
    Response logout();

}
