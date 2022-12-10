package com.fakebili.app.operationlog.assembler;

import com.fakebili.client.operationlog.dto.command.OperationLogSaveCmd;
import com.fakebili.domain.operationlog.entity.OperationLogEntity;
import org.springframework.beans.BeanUtils;

/**
 * @author Emilelu
 * @version 0.1.0 2022/12/07 20:12:48
 * @since 0.1.0
 */
public class OperationLogAssembler {

    private OperationLogAssembler() {
    }

    public static OperationLogEntity toEntity(OperationLogSaveCmd co) {
        OperationLogEntity operationLogEntity = new OperationLogEntity();
        BeanUtils.copyProperties(co, operationLogEntity);
        return operationLogEntity;
    }
}
