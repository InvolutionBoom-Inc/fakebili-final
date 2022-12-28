package com.fakebili.app.person.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.app.person.excutor.ResetEmailCmdExe;
import com.fakebili.client.person.api.IPersonService;
import com.fakebili.client.person.dto.command.ResetEmailCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jie
 * @ClassName PersonServiceImpl.java
 * @description ****
 * @since 2022/12/12 09:40:03
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {
    private final ResetEmailCmdExe resetEmailCmdExe;

    @Override
    public Response resetEmail(ResetEmailCmd cmd) {
        resetEmailCmdExe.execute(cmd);
        return Response.buildSuccess();
    }
}
