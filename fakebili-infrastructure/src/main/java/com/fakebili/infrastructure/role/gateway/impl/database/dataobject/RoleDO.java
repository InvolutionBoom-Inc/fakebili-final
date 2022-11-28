package com.fakebili.infrastructure.role.gateway.impl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fakebili.infrastructure.common.api.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:52
 * @since 0.1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fakebili_role")
public class RoleDO extends BaseDO {

    private String name;
}
