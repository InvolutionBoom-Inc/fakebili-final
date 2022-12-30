package com.fakebili.controller.video;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.client.video.dto.command.ContributionCmd;
import com.fakebili.client.video.dto.data.ContributionVO;
import com.fakebili.video.api.IVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/contribution")
    public SingleResponse<ContributionVO> contribution(@RequestBody @Valid ContributionCmd cmd){
        return videoService.contribution(cmd);
    }

}