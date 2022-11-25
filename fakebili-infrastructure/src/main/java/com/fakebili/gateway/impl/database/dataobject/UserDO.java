package com.fakebili.gateway.impl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fakebili.common.api.BaseDO;
import com.fakebili.dto.data.error.user.SexEnum;
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

}
