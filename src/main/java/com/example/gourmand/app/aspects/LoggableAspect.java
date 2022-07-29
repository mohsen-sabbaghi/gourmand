package com.example.gourmand.app.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Aspect //let know Spring that this is an Aspect class
@Component //Spring will consider this class as a Spring bean
@Order(0)
@Slf4j
public class LoggableAspect {


    private final HttpServletRequest httpServletRequest;
    private final HttpServletResponse httpServletResponse;

    public LoggableAspect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
    }

    public static Map<String, String> getHeadersInfo(HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();
        if (null != response) {
            map = response.getHeaderNames().stream().collect(Collectors.toMap(Function.identity(), response::getHeader));
        }
        return map;
    }

    public static String getRequestClientIpComplete(HttpServletRequest req) {
        String clientIp = req.getHeader("X-Real-IP");
        if (clientIp == null || "".equals(clientIp)) { // extract from forward ips
            String ipForwarded = req.getHeader("X-FORWARDED-FOR");
            String[] ips = ipForwarded == null ? null : ipForwarded.split(",");
            clientIp = (ips == null || ips.length == 0) ? null : ips[0];
            // extract from remote addr
            clientIp = (clientIp == null || clientIp.isEmpty()) ? req.getRemoteAddr() : clientIp;
        }
        if ("0:0:0:0:0:0:0:1".equals(clientIp)) clientIp = "127.0.0.1";
        return clientIp;
    }

    @Around("@annotation(Loggable)") //define the logic to execute
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String classMethod = className + "." + methodName;

        Map<String, String> mapRequest = getHeadersInfo(httpServletResponse);

        String rest = httpServletRequest.getMethod() + " " + httpServletRequest.getServletPath();

        String clientIp = getRequestClientIpComplete(httpServletRequest);
        Object result = joinPoint.proceed();

        Map<String, String> mapResponse = getHeadersInfo(httpServletResponse);

        log.debug("[" + String.format("%-6d", (System.currentTimeMillis() - startTime)) + " ms] " + String.format("%-50s", classMethod) + " -> IP: " + clientIp + " ;#" + rest + " ;#result:" + result + " ;#headers.request: " + mapRequest + " ;#header.response: " + mapResponse);

        return result;
    }
}
