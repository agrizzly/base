package com.grizzly.base.aop;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Aspect
@Slf4j
public class LoggerAdvice {
    @Before("within(com.grizzly.base.controller..*) && @annotation(apiOperation)")
    public void addBeforeLogger(JoinPoint joinPoint, ApiOperation apiOperation) {
        log.info("==>执行【" + apiOperation.value() + "】开始");
        log.info(joinPoint.getSignature().toString());

        log.info(parseParames(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "rvt", value = "within(com.grizzly.base.controller..*) && @annotation(apiOperation)")
    public void addAfterReturningLogger(JoinPoint joinPoint, Object rvt, ApiOperation apiOperation) {
        log.info("返回结果:{}", rvt);
        log.info("执行 【" + apiOperation.value() + "】 结束");
    }

    @AfterThrowing(pointcut = "within(com.grizzly.base.controller..*) && @annotation(apiOperation)", throwing = "ex")
    public void addAfterThrowingLogger(JoinPoint joinPoint, ApiOperation apiOperation, Exception ex) {
        log.error(" ****************执行 【" + apiOperation.value() + "】  异常 ****************", ex);
    }


    private String parseParames(Object[] parames) {

        if (null == parames || parames.length <= 0) {
            return "";
        }
        StringBuffer param = new StringBuffer("传入参数 # 个:【 ");
        int i = 0;
        for (Object obj : parames) {
            if (obj instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) obj;
                Enumeration<String> params = request.getParameterNames();
                while (params.hasMoreElements()) {
                    String paraName = params.nextElement();
                    log.info("参数:{}={}", paraName, request.getParameter(paraName));
                }
            }
            i++;
            if (i == 1) {
                param.append(obj);
                continue;
            }
            param.append(",").append(obj);
        }
        return param.append(" 】").toString().replace("#", String.valueOf(i));
    }
}