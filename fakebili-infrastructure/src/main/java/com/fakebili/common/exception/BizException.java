package com.fakebili.common.exception;

import com.fakebili.dto.data.ErrorCode;

import java.io.Serial;

/**
 * @author zzl
 * @version 0.1.0
 * @date 2022/11/23 16:24:45
 */
public class BizException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
