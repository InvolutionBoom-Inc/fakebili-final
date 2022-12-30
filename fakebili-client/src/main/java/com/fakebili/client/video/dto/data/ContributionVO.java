package com.fakebili.client.video.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Jie
 * @ClassName ContributionVO.java
 * @description ****
 * @since 2022/12/29 15:55:11
 */
@Data
public class ContributionVO {

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

}
