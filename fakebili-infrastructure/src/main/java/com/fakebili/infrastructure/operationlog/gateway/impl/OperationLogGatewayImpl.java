package com.fakebili.infrastructure.operationlog.gateway.impl;

import com.alibaba.cola.exception.BizException;
import com.fakebili.domain.operationlog.entity.OperationLogEntity;
import com.fakebili.domain.operationlog.gateway.OperationLogGateway;
import com.fakebili.infrastructure.constant.enums.error.system.SystemCodeEnum;
import com.fakebili.infrastructure.operationlog.database.converter.OperationLogConverter;
import com.fakebili.infrastructure.operationlog.gateway.impl.database.mapper.OperationLogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Emilelu
 * @version 0.1.0 2022/12/07 19:12:01
 * @since 0.1.0
 */
@Component("operationLogGateway")
@RequiredArgsConstructor
public class OperationLogGatewayImpl implements OperationLogGateway {

    private final OperationLogMapper operationLogMapper;

    @Override
    public Boolean save(OperationLogEntity operationLogEntity) {

        try {
            operationLogMapper.insert(OperationLogConverter.toAddOperationLogDO(operationLogEntity));
        } catch (Exception e) {
            throw new BizException(SystemCodeEnum.B_SERVER_ERROR.getMessage());
        }

        return true;
    }
}
