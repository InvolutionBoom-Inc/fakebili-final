package com.fakebili.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    private String nickname;

    /**
     * 密码
     */
    private String password;

    private String email;

    private String code;

}
