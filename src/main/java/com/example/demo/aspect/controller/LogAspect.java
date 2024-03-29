package com.example.demo.aspect.controller;

import com.example.demo.aspect.CommonAspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Description: controller 方法打印日志切面
 * @Author zhushaopeng
 * @Date 2019/10/17
 **/
@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * 换行符
     */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 以自定义@ControllerLog注解为切点
     */
//    @Pointcut("@annotation(com.example.demo.aspect.controller.ControllerLog)")
    @Pointcut("execution(public * com.example.demo.controller*..*Controller.*(..))")
    public void controllerLog() {
    }

    @Around("controllerLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = CommonAspectUtil.getUseTime(proceedingJoinPoint);
        return result;
    }

    @After("controllerLog()")
    public void doAfter() {
        log.info("doAfter====");
    }

    @AfterReturning("controllerLog()")
    public void doAfterReturning() {
        log.info("doAfterReturning=====");
    }
    @AfterThrowing("controllerLog()")
    public void doAfterThrowing() {
        log.info("doAfterThrowing=====");
    }

    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
//        // 获取 @WebLog 注解的描述信息
//        String methodDescription = getAspectLogDescription(joinPoint);
        // 打印请求相关参数
        log.info("==========================================Controller Log Start ==========================================");
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
//        // 打印描述信息
//        log.info("Description    : {}", methodDescription);
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method  Params : {}.{}.{}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), "(req)", CommonAspectUtil.getParam(joinPoint));

    }

    /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(ControllerLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }


}
