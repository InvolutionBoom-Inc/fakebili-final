package com.fakebili.app.operationlog.consumer;

import com.fakebili.domain.operationlog.entity.OperationLogEntity;
import com.fakebili.domain.operationlog.gateway.OperationLogGateway;
import com.fakebili.infrastructure.event.OperationLogEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author lgz
 * @version 0.1.0 2022/12/07 17:12:24
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class OperationLogListener {

    private final OperationLogGateway operationLogGateway;

    @Async
    @EventListener(classes = OperationLogEvent.class)
    public void onApplicationEvent(OperationLogEvent event) {
        OperationLogEntity source = (OperationLogEntity) event.getSource();
        operationLogGateway.save(source);
    }
}
