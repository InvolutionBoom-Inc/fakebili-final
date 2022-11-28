package com.fakebili.controller.user;

import com.alibaba.cola.dto.Response;
import com.fakebili.client.user.api.IUserStatisticService;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 13:11:24
 * @since 0.1.0
 */
@RestController
@RequestMapping("/api/v1/user/statistic")
@RequiredArgsConstructor
public class UserStatisticController {

    private final IUserStatisticService userStatisticService;

    @PostMapping("save")
    public Response save(@RequestBody @Valid UserStatisticSaveCmd cmd) {
        return userStatisticService.save(cmd);
    }
}
