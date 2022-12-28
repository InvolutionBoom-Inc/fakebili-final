package com.fakebili.controller.user;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fakebili.client.user.api.IUserStatisticService;
import com.fakebili.client.user.dto.command.UserInfoUpdateCmd;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;
import com.fakebili.infrastructure.user.gateway.impl.database.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.geom.QuadCurve2D;
import java.util.Map;

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

    @GetMapping("info/{id}")
    public SingleResponse<Map<String, Object>> getUserInfo(@PathVariable @Valid Integer id) {
        return userStatisticService.getUserInfo(id);
    }

    @PostMapping("update")
    public Response update(@RequestBody @Valid UserInfoUpdateCmd cmd){
        return userStatisticService.update(cmd);
    }
}
