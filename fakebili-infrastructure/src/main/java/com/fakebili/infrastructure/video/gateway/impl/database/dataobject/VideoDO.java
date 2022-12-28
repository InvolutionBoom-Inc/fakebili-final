package com.fakebili.infrastructure.video.gateway.impl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fakebili.infrastructure.common.api.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author zzl
 * @date 2022/12/28 15:55:56
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fakebili_video")
public class VideoDO extends BaseDO {
    /**
     * 作者ID
     */
    private Integer mid;
    /**
     * 标题
     */
    private String title;
    /**
     * 视频封面
     */
    private String videoPic;
    /**
     * 简介
     */
    private String description;
    /**
     * 视频路径
     */
    private String videoUrl;
    /**
     * 视频时长
     */
    private Integer duration;
    /**
     * 发布时间
     */
    private LocalDateTime pubDate;
    /**
     * 投稿时间
     */
    private LocalDateTime ctime;
    /**
     * 视频修改时间
     */
    private LocalDateTime videoUpdateTime;
}