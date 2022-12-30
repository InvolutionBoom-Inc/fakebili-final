package com.fakebili.client.video.dto.command;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Jie
 * @ClassName ContributionCmd.java
 * @description ****
 * @since 2022/12/29 15:10:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ContributionCmd extends Command {
    /**
     * 作者ID
     */
    @NotNull
    private Integer mid;
    /**
     * 标题
     */
    @NotBlank
    private String title;
    /**
     * 视频封面
     */
    @NotBlank
    private String videoPic;
    /**
     * 简介
     */
    @NotBlank
    private String description;
    /**
     * 视频路径
     */
    @NotBlank
    private String videoUrl;
}
