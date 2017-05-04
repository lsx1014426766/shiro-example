package com.github.zhangkaitao.shiro.chapter12.web.mvc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-12
 * <p>Version: 1.0
 * 2个方法都可以达到权限拦截，一个是方法调用，一个是注解的方式
 * 在表单登录认证过程中，用户的认证信息和授权信息都被记录下来了，由
 * security来统一管理保存
 * 错误信息：您没有权限[Subject does not have role [admin]]
 */
@Controller
public class AnnotationController {

    @RequestMapping("/hello1")
    public String hello1() {
        SecurityUtils.getSubject().checkRole("admin");
        //转发进入success.jsp
        return "success";
    }


    @RequiresRoles("admin")
    @RequestMapping("/hello2")
    public String hello2() {
        return "success";
    }
}
