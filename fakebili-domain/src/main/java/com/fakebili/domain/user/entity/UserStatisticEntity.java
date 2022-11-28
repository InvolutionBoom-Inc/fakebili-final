package com.fakebili.domain.user.entity;

import lombok.Data;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:17
 * @since 0.1.0
 */
@Data
public class UserStatisticEntity {

    private Integer id;

    private Integer dynamicCount;

    private Integer coinCount;

    private Integer gotLikesCount;

}
