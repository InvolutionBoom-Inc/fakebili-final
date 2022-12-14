package com.fakebili.client.user.dto.data;

import lombok.Data;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 11:11:55
 * @since 0.1.0
 */
@Data
public class UserStatisticVO {

    private Integer id;

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
