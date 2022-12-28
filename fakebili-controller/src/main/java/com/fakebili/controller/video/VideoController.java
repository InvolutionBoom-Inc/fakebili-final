package com.fakebili.controller.video;

import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.video.api.IVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author zzl
 * @date 2022/12/28 15:40:57
 * @description
 */
@RestController
@RequestMapping("api/v1/video")
@RequiredArgsConstructor
public class VideoController {
    private final IVideoService videoService;

    @GetMapping("load/{id}")
    public SingleResponse<Map<String, Object>> videoLoad(@PathVariable @NotNull Integer id) {
        return videoService.videoLoad(id);
    }
}