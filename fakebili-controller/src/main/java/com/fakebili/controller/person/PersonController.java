package com.fakebili.controller.person;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.client.person.api.IPersonService;
import com.fakebili.client.person.dto.command.ResetEmailCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author Jie
 * @ClassName personController.java
 * @description ****
 * @since 2022/12/12 08:45:04
 */
@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService personService;

    @PostMapping("/resetEmail")
    public Response resetEmail(@RequestBody @Valid ResetEmailCmd cmd){
        return personService.resetEmail(cmd);
    }

}
