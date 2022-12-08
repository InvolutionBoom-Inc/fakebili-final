package com.fakebili.controller.user;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.client.user.api.IUserService;
import com.fakebili.client.user.dto.command.ResetPasswordCmd;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.data.UserVO;
import com.fakebili.client.user.dto.query.UserLoginCmd;
import com.fakebili.infrastructure.common.annotation.OptLog;
import com.fakebili.infrastructure.constant.OptTypeConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("register")
    public SingleResponse<UserVO> register(@RequestBody @Valid UserRegisterCmd cmd) {
        return userService.register(cmd);
    }

    @OptLog(optType = OptTypeConstant.SELECT, optModuleType = "user", optDesc = "登录")
    @PostMapping("login")
    public SingleResponse<Map<String, Object>> login(@RequestBody @Valid UserLoginCmd cmd) {
        return userService.login(cmd);
    }

    @PostMapping("reset")
    public Response resetPassword(@RequestBody @Valid ResetPasswordCmd cmd) {
        return userService.resetPassword(cmd);
    }

    @PostMapping("logout")
    public Response logout(){
        return userService.logout();
    }
}
