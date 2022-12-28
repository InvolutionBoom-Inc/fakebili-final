package com.fakebili.client.person.api;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.client.person.dto.command.ResetEmailCmd;

import java.util.Map;

/**
 * @author Jie
 * @ClassName IPersonService.java
 * @description ****
 * @since 2022/12/12 08:47:06
 */
public interface IPersonService {
    Response resetEmail(ResetEmailCmd cmd);
}
