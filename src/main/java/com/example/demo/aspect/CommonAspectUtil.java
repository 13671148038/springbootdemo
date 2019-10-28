package com.example.demo.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.time.Clock;

/**
 * @Description:
 * @Author zhushaopeng
 * @Date 2019/10/17
 **/
@Slf4j
public class CommonAspectUtil {

    /**
     * @param
     * @return
     * @throws Throwable
     * @Author zhushaopeng
     */
    public static Object getUseTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //记录调用接口开始时间
        long methodBeginMillis = Clock.systemUTC().millis();
        //执行切点
        Object result = proceedingJoinPoint.proceed();
        //打印方法返回值
        log.info("Class Method  return : {}.{}.{}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), "(rsp)", JSON.toJSONString(result));
        //打印方法耗时
        log.info("time consuming:{}", Clock.systemUTC().millis() - methodBeginMillis);
        return result;
    }

    /**
     * @param
     * @return
     * @throws Throwable
     * @Author zhushaopeng
     */
    public static String getParam(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        StringBuilder param = new StringBuilder();
        if (parameterNames.length > 0) {
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < parameterNames.length; i++) {
                try {
                    param.append(parameterNames[i]).append(":").append(JSON.toJSONString(args[i])).append(",");
                } catch (Exception e) {
                }
            }
        }
        return param.toString();
    }

}
