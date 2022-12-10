package com.fakebili.infrastructure.common.aspect;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.fakebili.domain.operationlog.entity.OperationLogEntity;
import com.fakebili.domain.user.entity.UserEntity;
import com.fakebili.infrastructure.common.annotation.OptLog;
import com.fakebili.infrastructure.common.util.IpUtil;
import com.fakebili.infrastructure.event.OperationLogEvent;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;


/**
 * @author lgz
 * @version 0.1.0 2022/12/07 16:12:34
 * @since 0.1.0
 */
@Aspect
@Component
@RequiredArgsConstructor
public class OperationLogAspect {

    private final ApplicationContext applicationContext;

    @Pointcut("@annotation(com.fakebili.infrastructure.common.annotation.OptLog)")
    public void operationLogPointCut() {
    }

    @AfterReturning(value = "operationLogPointCut()", returning = "keys")
    public void saveOperationLog(JoinPoint joinPoint, Object keys) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(requestAttributes).resolveReference(RequestAttributes.REFERENCE_REQUEST);

        OperationLogEntity operationLogEntity = new OperationLogEntity();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        OptLog optLog = method.getAnnotation(OptLog.class);
        operationLogEntity.setOptModule(optLog.optModuleType());
        operationLogEntity.setOptType(optLog.optType());
        operationLogEntity.setOptDesc(optLog.optDesc());

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = method.getName();
        methodName = className + "." + methodName;
        operationLogEntity.setRequestMethod(Objects.requireNonNull(request).getMethod());
        operationLogEntity.setOptMethod(methodName);

        if (joinPoint.getArgs().length > 0) {
            if (joinPoint.getArgs()[0] instanceof MultipartFile) {
                operationLogEntity.setRequestParam("file");
            } else {
                operationLogEntity.setRequestParam(JSON.toJSONString(joinPoint.getArgs()));
            }
        }

        operationLogEntity.setResponseData(JSON.toJSONString(keys));
        operationLogEntity.setUserId(StpUtil.getLoginIdAsInt());
        UserEntity userEntity = (UserEntity) StpUtil.getSession().get("user");
        operationLogEntity.setNickname(userEntity.getNickname());

        String ipAddress = IpUtil.getIpAddress(request);
        operationLogEntity.setIpAddress(ipAddress);
        operationLogEntity.setIpSource(IpUtil.getIpSource(ipAddress));
        operationLogEntity.setOptUri(request.getRequestURI());

        applicationContext.publishEvent(new OperationLogEvent(operationLogEntity));
    }
}

