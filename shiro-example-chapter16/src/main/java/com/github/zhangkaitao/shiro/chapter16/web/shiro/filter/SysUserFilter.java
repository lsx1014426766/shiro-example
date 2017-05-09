package com.github.zhangkaitao.shiro.chapter16.web.shiro.filter;

import com.github.zhangkaitao.shiro.chapter16.Constants;
import com.github.zhangkaitao.shiro.chapter16.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 * 路径过滤器，在shiroFilter里面有根据[urls]拦截请求，处理
 * 这里会把所有登录用户的信息，通过用户名从db查出来，然后放在request attribute里
 * 以供后面的注解@CurrentUser使用
 *
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, userService.findByUsername(username));
        return true;
    }
}
