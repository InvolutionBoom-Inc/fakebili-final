package com.fakebili.domain.operationlog.gateway;

import com.fakebili.domain.operationlog.entity.OperationLogEntity;

/**
 * @author Emilelu
 * @version 0.1.0 2022/12/07 19:12:08
 * @since 0.1.0
 */
public interface OperationLogGateway {

    /**
     * 保存操作日志
     *
     * @param operationLogEntity operationLogEntity
     * @return 是否成功
     */
    Boolean save(OperationLogEntity operationLogEntity);
}
