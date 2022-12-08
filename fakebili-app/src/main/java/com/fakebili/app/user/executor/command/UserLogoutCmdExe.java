package com.fakebili.app.user.executor.command;

import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jie
 * @ClassName UserLogoutCmdExe.java
 * @description ****
 * @since 2022/12/07 19:37:31
 */
@Component
@RequiredArgsConstructor
public class UserLogoutCmdExe {

    public Boolean execute(){
        System.out.println("已进入接口");
        System.out.println(StpUtil.getTokenSession());
        Integer loginId = StpUtil.getLoginIdAsInt();
        StpUtil.logout(loginId);
        return true;
    }

}
