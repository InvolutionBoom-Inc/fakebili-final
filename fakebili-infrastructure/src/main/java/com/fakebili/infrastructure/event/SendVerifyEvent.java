package com.fakebili.infrastructure.event;

import com.fakebili.domain.captcha.entity.TextVerifyEntity;
import org.springframework.context.ApplicationEvent;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/26 20:11:29
 * @since 0.1.0
 */
public class SendVerifyEvent extends ApplicationEvent {

    public SendVerifyEvent(TextVerifyEntity textVerifyEntity) {
        super(textVerifyEntity);
    }
}
