package com.fakebili.dto.data;

import com.fakebili.dto.data.error.user.SexEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 23:11:04
 * @since 0.1.0
 */
@Data
public class UserVO {
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
