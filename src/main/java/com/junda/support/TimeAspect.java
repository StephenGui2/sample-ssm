package com.junda.support;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    private static Logger logger = LoggerFactory.getLogger(TimeAspect.class);

    private static final long ONE_MINUTE = 60000;

    public static final String POINT = "execution (* com.qunar.qfc.dao.*.*(..))";


    @Around(POINT)
    public Object timeAround(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();

        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error("统计dao方法执行耗时环绕通知出错", e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        this.printExecTime(methodName, startTime, endTime);
        return obj;
    }

    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        logger.warn("==========" + methodName + " 方法执行耗时：" + diffTime + " ms");
    }

}