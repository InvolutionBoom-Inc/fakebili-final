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

    private Integer dynamicCount;

    private Integer coinCount;

    private Integer gotLikesCount;

}
