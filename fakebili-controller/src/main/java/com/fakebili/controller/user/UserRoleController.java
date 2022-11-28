package com.fakebili.controller.user;

import com.alibaba.cola.dto.Response;
import com.fakebili.client.user.api.IUserRoleService;
import com.fakebili.client.user.dto.command.UserRoleSaveCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 13:11:12
 * @since 0.1.0
 */
@RestController
@RequestMapping("/api/v1/user/role")
@RequiredArgsConstructor
public class UserRoleController {

    private final IUserRoleService userRoleService;

    @PostMapping("save")
    public Response save(@RequestBody @Valid UserRoleSaveCmd cmd) {
        return userRoleService.save(cmd);
    }
}
