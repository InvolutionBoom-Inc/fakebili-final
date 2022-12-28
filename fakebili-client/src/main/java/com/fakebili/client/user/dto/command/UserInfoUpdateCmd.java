package com.fakebili.client.user.dto.command;

import com.alibaba.cola.dto.Command;
import com.fakebili.domain.user.entity.SexEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;

/**
 * @author Gwj
 * @ClassName UserInfoUpdateCmd
 * @description ****
 * @since 2022/12/27 16:12:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoUpdateCmd extends Command {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @NotNull
    private Integer id;
    /**
     * 昵称
     */
    @Size(max = 10, min = 1, message = "昵称需在1-10之间")
    private String nickname;

    /**
     * 性别
     */
    @NotNull
    private SexEnum sex;
}
