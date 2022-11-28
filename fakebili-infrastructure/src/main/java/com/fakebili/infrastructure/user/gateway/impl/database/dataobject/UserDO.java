package com.fakebili.infrastructure.user.gateway.impl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fakebili.infrastructure.common.api.BaseDO;
import com.fakebili.domain.user.entity.SexEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author lgz
 * @version 0.1.0 2022/11/24 18:11:20
 * @since 0.1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fakebili_user")
public class UserDO extends BaseDO {

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private SexEnum sex;

    /**
     * 头像链接
     */
    private String face;

    /**
     * 注册时间
     */
    private LocalDateTime jointime;

    /**
     * 封禁状态
     */
    private Boolean silence;

    @TableLogic
    @TableField(select = false)
    private Boolean deleteFlag;

}
