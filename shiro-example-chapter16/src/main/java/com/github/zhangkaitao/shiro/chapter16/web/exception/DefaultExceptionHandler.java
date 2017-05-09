package com.github.zhangkaitao.shiro.chapter16.web.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-12
 * <p>Version: 1.0
 * 公用的一个controller
 * 当抛出下面方法上指定的异常类型时就会跳转到这里
 * 针对这个异常，我们可以做一些处理，使页面不再是在页面上把异常直接显示出来
 * 而是这个经过我们处理跳转的错误页面 也包括上面显示的错误信息 ModelAndView
 * 这个类在spring配置文件中有指定它，作为一个全局的异常处理类
 * <!-- 控制器异常处理 -->
 <bean id="exceptionHandlerExceptionResolver" class="org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver">
 </bean>

 <bean class="com.github.zhangkaitao.shiro.chapter16.web.exception.DefaultExceptionHandler"/>

 */
@ControllerAdvice
public class DefaultExceptionHandler {
    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.setViewName("unauthorized");
        return mv;
    }
}
