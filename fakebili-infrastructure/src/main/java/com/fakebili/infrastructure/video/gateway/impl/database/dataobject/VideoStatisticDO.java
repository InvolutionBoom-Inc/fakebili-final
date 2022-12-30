package com.fakebili.infrastructure.video.gateway.impl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fakebili.infrastructure.common.api.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author Jie
 * @ClassName VideoStatisticDO.java
 * @description ****
 * @since 2022/12/29 15:27:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fakebili_video_statistic")
public class VideoStatisticDO extends BaseDO {

    /**
     * 播放数
     */
    private Integer viewCount;

    /**
     * 获赞数
     */
    private Integer gotLikesCount;

    /**
     * 收藏数
     */
    private Integer collectCount;

    /**
     * 投币数
     */
    private Integer coinCount;

    /**
     * 转发数
     */
    private Integer retweetCount;

    /**
     * 评论数
     */
    private Integer commentCount;

}
