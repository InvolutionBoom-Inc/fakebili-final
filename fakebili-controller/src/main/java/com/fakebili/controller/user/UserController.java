package com.fakebili.controller.user;

import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.client.user.api.IUserService;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import com.fakebili.client.user.dto.data.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("register")
    public SingleResponse<UserVO> register(@RequestBody @Valid UserRegisterCmd cmd) {
        return userService.register(cmd);
    }

}
