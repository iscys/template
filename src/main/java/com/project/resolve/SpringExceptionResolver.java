package com.project.resolve;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpringExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        System.out.println("==============异常开始=============");
        e.printStackTrace();
        System.out.println("==============异常结束=============");
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", e.toString().replaceAll("\n", "<br/>"));
        return mv;
    }
}
