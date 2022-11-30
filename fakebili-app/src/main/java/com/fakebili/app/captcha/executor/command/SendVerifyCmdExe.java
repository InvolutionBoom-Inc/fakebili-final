package com.fakebili.app.captcha.executor.command;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.cola.exception.BizException;
import com.fakebili.client.captcha.dto.command.SendVerifyCmd;
import com.fakebili.domain.captcha.entity.TextVerifyEntity;
import com.fakebili.infrastructure.common.cache.RedisService;
import com.fakebili.infrastructure.constant.enums.error.system.SystemCodeEnum;
import com.fakebili.infrastructure.event.SendVerifyEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/26 18:11:33
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class SendVerifyCmdExe {

    private final ApplicationContext applicationContext;
    private final RedisService redisService;

    public void execute(SendVerifyCmd cmd) {
        String code = (String) redisService.get(cmd.getEmail());
        if (StringUtils.hasText(code)) {
            throw new BizException(SystemCodeEnum.B_REQUEST_REPEATED_ERROR.getCode(), SystemCodeEnum.B_REQUEST_REPEATED_ERROR.getMessage());
        }
        code = RandomUtil.randomNumbers(6);
        redisService.set(cmd.getEmail(), code, 300);
        this.applicationContext.publishEvent(new SendVerifyEvent(TextVerifyEntity.builder().type(cmd.getType()).code(code).email(cmd.getEmail()).build()));
    }
}
