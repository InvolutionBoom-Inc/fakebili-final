package com.fakebili.infrastructure.event;

import com.fakebili.domain.operationlog.entity.OperationLogEntity;
import org.springframework.context.ApplicationEvent;

/**
 * @author lgz
 * @version 0.1.0 2022/12/07 16:12:21
 * @since 0.1.0
 */
public class OperationLogEvent extends ApplicationEvent {

    public OperationLogEvent(OperationLogEntity operationLogEntity) {
        super(operationLogEntity);
    }
}
