package com.fakebili.app.operationlog.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.fakebili.app.operationlog.executor.command.OperationLogSaveCmdExe;
import com.fakebili.client.operationlog.api.IOperationLogService;
import com.fakebili.client.operationlog.dto.command.OperationLogSaveCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Emilelu
 * @version 0.1.0 2022/12/07 20:12:24
 * @since 0.1.0
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class OperationLogServiceImpl implements IOperationLogService {

    private final OperationLogSaveCmdExe operationLogSaveCmdExe;

    @Override
    public Boolean save(OperationLogSaveCmd operationLogSaveCmd) {
        return operationLogSaveCmdExe.execute(operationLogSaveCmd);
    }
}
