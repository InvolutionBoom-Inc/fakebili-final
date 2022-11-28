package com.fakebili.infrastructure.user.gateway.impl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fakebili.infrastructure.common.api.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lgz
 * @version 0.1.0 2022/11/27 22:11:57
 * @since 0.1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fakebili_user_role")
public class UserRoleDO extends BaseDO {

    private Integer mid;

    private Integer roleId;

}
