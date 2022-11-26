package com.fakebili.controller.captcha;

import com.alibaba.cola.dto.Response;
import com.fakebili.client.captcha.dto.api.ITextCaptchaService;
import com.fakebili.client.captcha.dto.command.SendVerifyCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/26 20:11:15
 * @since 0.1.0
 */
@RestController
@RequestMapping("/api/v1/captcha")
@RequiredArgsConstructor
public class CaptchaController {

    private final ITextCaptchaService textCaptchaService;

    @PostMapping("sendTextCaptcha")
    public Response SendTextCaptcha(@RequestBody @Valid SendVerifyCmd cmd) {
        textCaptchaService.sendVerifyCode(cmd);
        return Response.buildSuccess();
    }
}
