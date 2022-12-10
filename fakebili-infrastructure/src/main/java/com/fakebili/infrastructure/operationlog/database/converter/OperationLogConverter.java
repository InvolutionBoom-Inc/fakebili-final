package com.fakebili.infrastructure.operationlog.database.converter;

import com.fakebili.domain.operationlog.entity.OperationLogEntity;
import com.fakebili.infrastructure.operationlog.gateway.impl.database.dataobject.OperationLogDO;
import org.springframework.beans.BeanUtils;

/**
 * @author Emilelu
 * @version 0.1.0 2022/12/07 19:12:23
 * @since 0.1.0
 */
public class OperationLogConverter {

    public static OperationLogDO toAddOperationLogDO(OperationLogEntity operationLogEntity) {
        OperationLogDO operationLogDO = new OperationLogDO();
        BeanUtils.copyProperties(operationLogEntity, operationLogDO);
        return operationLogDO;
    }

    public static OperationLogEntity toEntity(OperationLogDO operationLogDO) {
        OperationLogEntity operationLogEntity = new OperationLogEntity();
        BeanUtils.copyProperties(operationLogDO, operationLogEntity);
        return operationLogEntity;
    }
}
