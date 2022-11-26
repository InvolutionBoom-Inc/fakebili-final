package com.fakebili.app.email.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zzl
 * @date 2022/11/26 18:34:38
 * @description 监听邮件发送
 */
@Slf4j
@Component
@Transactional
public class EmailListener {
//    @EventListener(classes = OrderPayFinishEvent.class)
//    public void onApplicationEvent(OrderPayFinishEvent event) {
//        //todo 处理业务逻辑
//    }
}