package com.fakebili.domain.user.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lgz
 * @version 0.1.0 2022/11/24 20:11:25
 * @since 0.1.0
 */
@Data
public class UserEntity {

    private Long id;

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
