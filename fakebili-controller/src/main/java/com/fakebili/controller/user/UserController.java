package com.fakebili.controller.user;

import com.alibaba.cola.dto.Response;
import com.fakebili.client.user.api.IUserService;
import com.fakebili.client.user.dto.command.UserRegisterCmd;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final IUserService userService;

    @PostMapping("register")
    public Response register(@RequestBody @Valid UserRegisterCmd cmd) {
        userService.register(cmd);
        return Response.buildSuccess();
    }
}
