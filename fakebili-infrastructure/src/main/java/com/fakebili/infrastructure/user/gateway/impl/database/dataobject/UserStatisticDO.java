package com.fakebili.infrastructure.user.gateway.impl.database.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:06
 * @since 0.1.0
 */
@Data
@TableName("fakebili_user_statistic")
public class UserStatisticDO {

    private Integer id;

    private Integer dynamicCount;

    private Integer coinCount;

    private Integer gotLikesCount;

    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
