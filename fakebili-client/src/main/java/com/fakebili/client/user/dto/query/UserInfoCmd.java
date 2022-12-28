package com.fakebili.client.user.dto.query;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author zzl
 * @date 2022/12/06 16:28:34
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoCmd extends Command {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer id;

}
