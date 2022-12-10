package com.fakebili.client.operationlog.api;

import com.fakebili.client.operationlog.dto.command.OperationLogSaveCmd;

/**
 * @author Emilelu
 * @version 0.1.0 2022/12/07 19:12:46
 * @since 0.1.0
 */
public interface IOperationLogService {

    Boolean save(OperationLogSaveCmd operationLogSaveCmd);
}
