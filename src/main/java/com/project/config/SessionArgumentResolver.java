package com.project.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 自定义参数解析器，基于spring 提供的 HandlerMethodArgumentResolver
 * 会在参数handlerAdapter 参数解析的时候进行解析
 * 该解析器用于解析session
 */
public class SessionArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //得到参数的类型
        Class<?> paramType = parameter.getParameterType();
        //参数是否有注解
      //  if (parameter.hasParameterAnnotation(RequestParam.class)) {

       // }
        SessionAttribute sessionAttribute = parameter.getParameterAnnotation(SessionAttribute.class);
        if(null==sessionAttribute)
        return false;else return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        SessionAttribute sessionAttribute = parameter.getParameterAnnotation(SessionAttribute.class);
        String value = sessionAttribute.value();//定义的session key
        HttpServletRequest http = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpSession session = http.getSession();
        Object attribute = session.getAttribute(value);
        return attribute;
    }
}
