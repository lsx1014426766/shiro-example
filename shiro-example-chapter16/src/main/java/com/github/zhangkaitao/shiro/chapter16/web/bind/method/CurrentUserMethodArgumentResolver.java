package com.github.zhangkaitao.shiro.chapter16.web.bind.method;

import com.github.zhangkaitao.shiro.chapter16.web.bind.annotation.CurrentUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * <p>用于绑定@FormModel的方法参数解析器
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-12 下午5:01
 * <p>Version: 1.0
 * 这个自定义的类，作为方法的参数，用注解方式接收传递的参数
 * spring调用该接口实现Controller的参数装配。
 * HandlerMethodArgumentResolver实现类中会调用DataBinder，Converter等
 * 来定制method参数和返回值
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public CurrentUserMethodArgumentResolver() {
    }

    //@Override
    public boolean supportsParameter(MethodParameter parameter) {
        //判断参数类型是否支持，我的注解类CurrentUser
        if (parameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    //@Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        CurrentUser currentUserAnnotation = parameter.getParameterAnnotation(CurrentUser.class);
        return webRequest.getAttribute(currentUserAnnotation.value(), NativeWebRequest.SCOPE_REQUEST);
    }
}
