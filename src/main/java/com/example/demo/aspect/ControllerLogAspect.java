//package com.example.demo.aspect;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.validationgroupkind.After;
//import org.aspectj.lang.validationgroupkind.Around;
//import org.aspectj.lang.validationgroupkind.Before;
//import org.aspectj.lang.validationgroupkind.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.ui.Model;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @Description: controller 方法打印日志切面
// * @Author zhushaopeng
// * @Date 2019/10/17
// **/
//@Slf4j
////@Aspect
////@Component
//public class ControllerLogAspect {
//
//    /**
//     * 以自定义@ControllerLog注解为切点
//     */
//    @Pointcut("execution(* com.xyy.tuangou.operationalplatform.controller..*.*(..))||execution(* com.xyy.tuangou.drugstoreplatform.controller..*.*(..))")
//    public void controllerLog() {
//    }
//
//    @Around("controllerLog()")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
//        try {
//            return proceedingJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            log.error("Class Method Params Error : {}.{}(error).{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), getParam(proceedingJoinPoint), throwable);
//        }
//        return new ResultVO.ResultVoBuilder<>().code(1).msg("服务异常，请联系管理员").builder();
//    }
//
//    @After("controllerLog()")
//    public void doAfter() {
//    }
//
//    @Before("controllerLog()")
//    public void doBefore(JoinPoint joinPoint) {
//        // 开始打印请求日志
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (null == attributes) {
//            return;
//        }
//        HttpServletRequest request = attributes.getRequest();
//        // 打印请求相关参数
//        log.info("URL:{},HTTP Method:{},IP:{}\nClass Method Params : {}.{}(req).{}", request.getRequestURL().toString(), request.getMethod(), request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), getParam(joinPoint));
//    }
//
//
//    public String getParam(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        String[] parameterNames = signature.getParameterNames();
//        StringBuilder param = new StringBuilder();
//        if (parameterNames.length > 0) {
//            Object[] args = joinPoint.getArgs();
//            for (int i = 0; i < parameterNames.length; i++) {
//                try {
//                    Object arg = args[i];
//                    if (arg instanceof MultipartFile) {
//                        continue;
//                    }else if(arg instanceof HttpServletRequest){
//                        continue;
//                    }else if(arg instanceof HttpServletResponse){
//                        continue;
//                    }else if(arg instanceof Model){
//                        continue;
//                    }else if(arg instanceof ModelAndView){
//                        continue;
//                    }
//                    String s = JSON.toJSONString(args[i]);
//                    param.append(parameterNames[i]).append(":").append(s).append(",");
//                } catch (Exception e) {
//                    log.info("the parameter {} not to json, reason:{}", parameterNames[i], e.getMessage());
//                }
//            }
//        }
//        if (param.length() == 0) {
//            param.append("no parameter");
//        }
//        return param.toString();
//    }
//
//}
