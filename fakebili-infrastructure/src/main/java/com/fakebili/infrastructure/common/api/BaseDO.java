package com.fakebili.infrastructure.common.api;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author lgz
 * @version 0.1.0 2022/11/24 16:11:42
 * @since 0.1.0
 */
@Getter
@Setter
@Accessors(chain = true)
public abstract class BaseDO {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

}
