package com.fakebili.client.user.dto.command;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serial;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 11:11:17
 * @since 0.1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserStatisticSaveCmd extends Command {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer id;

    @NotNull
    private Integer dynamicCount;

    @NotNull
    private Integer coinCount;

    @NotNull
    private Integer gotLikesCount;

}
