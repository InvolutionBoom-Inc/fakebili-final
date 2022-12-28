package com.fakebili.client.user.dto.data;

import lombok.Data;

/**
 * @author zzl
 * @date 2022/12/07 22:55:41
 * @description
 */
@Data
public class UserInfoVO {

    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

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
}
