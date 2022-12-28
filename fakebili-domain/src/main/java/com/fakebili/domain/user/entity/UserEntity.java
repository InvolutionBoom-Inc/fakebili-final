package com.fakebili.domain.user.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:17
 * @since 0.1.0
 */
@Data
public class UserEntity {

    private Integer id;
    
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

    /**
     * 注册时间
     */
    private LocalDateTime jointime;

    /**
     * 封禁状态
     */
    private Boolean silence;

}
