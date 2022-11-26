package com.fakebili.client.captcha.dto.command;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import java.io.Serial;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/26 17:11:33
 * @since 0.1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SendVerifyCmd extends Command {

    @Serial
    private static final long serialVersionUID = 1L;

    @Email
    private String email;

}
