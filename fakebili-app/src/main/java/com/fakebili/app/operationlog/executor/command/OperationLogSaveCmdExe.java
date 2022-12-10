package com.fakebili.app.operationlog.executor.command;

import com.fakebili.app.operationlog.assembler.OperationLogAssembler;
import com.fakebili.client.operationlog.dto.command.OperationLogSaveCmd;
import com.fakebili.domain.operationlog.gateway.OperationLogGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Emilelu
 * @version 0.1.0 2022/12/07 20:12:43
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class OperationLogSaveCmdExe {

    private final OperationLogGateway operationLogGateway;

    public Boolean execute(OperationLogSaveCmd cmd) {
        operationLogGateway.save(OperationLogAssembler.toEntity(cmd));
        return true;
    }
}
