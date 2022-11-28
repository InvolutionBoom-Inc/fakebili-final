package com.fakebili.client.user.dto.command;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serial;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/24 22:11:28
 * @since 0.1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRegisterCmd extends Command {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    @Size(max = 10, min = 1, message = "昵称需在1-10之间")
    private String nickname;

    /**
     * 密码
     */
    @Size(max = 10, min = 6, message = "密码长度需为6-10")
    private String password;

    @Email
    private String email;

    private String code;

}
