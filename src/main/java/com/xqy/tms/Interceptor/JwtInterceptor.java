package com.xqy.tms.Interceptor;


import com.alibaba.druid.util.StringUtils;
import com.github.isrsal.logging.ResponseWrapper;
import com.xqy.tms.annotion.JwtIgnore;
import com.xqy.tms.config.Audience;
import com.xqy.tms.exception.CustomException;
import com.xqy.tms.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ========================
 * token验证拦截器
 * Created with IntelliJ IDEA.
 * User：xqy
 * Date：2023/2/9 9:46
 * Version: v1.0
 * ========================
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private Audience audience;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + handler.toString());
        log.info("REQUEST_PARAMS : " + request.getParameterMap().toString());
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        HandlerMethod handlerMethod;
        if (handler instanceof HandlerMethod){
            handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }else{
            throw new CustomException("请求错误");
        }

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        if (handlerMethod.getBeanType().getName().contains("com.xqy.tms.controller")){
            // 获取请求头信息authorization信息
            final String authHeader = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
            log.info("## authHeader= {}", authHeader);
            if (StringUtils.isEmpty(authHeader) || !authHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
                log.info("### 用户未登录，请先登录 ###");
                throw new CustomException("### 用户未登录，请先登录 ###");
            }
            // 获取token
            final String token = authHeader.substring(7);
            if(audience == null){
                BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                audience = (Audience) factory.getBean("audience");
            }
            // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
            JwtTokenUtil.parseJWT(token, audience.getBase64Secret());
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 记录响应日志
        ResponseWrapper responseWrapper = new ResponseWrapper(Thread.currentThread().getId(), response);
        log.info("RESPONSE : " + new String(responseWrapper.toByteArray(), responseWrapper.getCharacterEncoding()));
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 记录完成日志
        log.info("REQUEST_END");
    }
}