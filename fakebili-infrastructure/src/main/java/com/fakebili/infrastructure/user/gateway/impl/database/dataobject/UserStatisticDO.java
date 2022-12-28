package com.fakebili.infrastructure.user.gateway.impl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fakebili.infrastructure.common.api.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:06
 * @since 0.1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fakebili_user_statistic")
public class UserStatisticDO extends BaseDO {
    /**
     * 用户关联Id
     */
    private Integer userId;
    /**
     * 动态数
     */
    private Integer dynamicCount;
    /**
     * 硬币数
     */
    private Integer coinCount;
    /**
     * 获赞数
     */
    private Integer gotLikesCount;
    
}
