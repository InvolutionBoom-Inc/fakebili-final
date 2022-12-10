package com.fakebili.client.operationlog.dto.command;

import lombok.Data;

/**
 * @author Emilelu
 * @version 0.1.0 2022/12/07 19:12:04
 * @since 0.1.0
 */
@Data
public class OperationLogSaveCmd {

    private String optModule;

    private String optUri;

    private String optType;

    private String optMethod;

    private String optDesc;

    private String requestMethod;

    private String requestParam;

    private String responseData;

    private Integer userId;

    private String nickname;

    private String ipAddress;

    private String ipSource;
}
