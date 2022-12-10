package com.fakebili.infrastructure.operationlog.gateway.impl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fakebili.infrastructure.common.api.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lgz
 * @version 0.1.0 2022/12/07 16:12:29
 * @since 0.1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("fakebili_operation_log")
public class OperationLogDO extends BaseDO {

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
