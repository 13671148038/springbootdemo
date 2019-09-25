package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 全局异常处理类
 * @Author zhushaopeng
 * @Date 2019/9/25
 **/
@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Object handleControllerException(HttpServletRequest request, Exception e) {
        logger.error("system exception:", e);
        HttpStatus status = getStatus(request);
        Map<String, Object> result = new HashMap();
        result.put("message", e.getMessage());
        result.put("status", status.value());
        result.put("path", request.getServletPath());
        result.put("timestamp", new Date().getTime());
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stackTrace.length; i++) {
            stringBuilder.append(stackTrace[i].toString());
        }
        result.put("exception", e.getStackTrace()[0].toString());
        return result;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
