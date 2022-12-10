package com.fakebili.domain.operationlog.entity;

import lombok.Data;

/**
 * @author lgz
 * @version 0.1.0 2022/12/07 17:12:56
 * @since 0.1.0
 */
@Data
public class OperationLogEntity {

    private Integer id;

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
