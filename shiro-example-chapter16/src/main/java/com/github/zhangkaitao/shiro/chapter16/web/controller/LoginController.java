package com.github.zhangkaitao.shiro.chapter16.web.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
@Controller
public class LoginController {
    private Logger logger= LoggerFactory.getLogger(LoginController.class);
    @RequestMapping(value = "/login"    )
    public String showLoginForm(HttpServletRequest req, Model model) {
        /**
         * 从form表单提交过来，先进入userReam，当验证用户信息失败时会再次来到这里
         * 当验证通过后就直接去往下一个页面，当没有配置successUrl时就会跳到上一个页面
         */
        logger.info("LoginController.showLoginForm");
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
            logger.info("LoginController.showLoginForm error:UnknownAccountException");
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
            logger.info("LoginController.showLoginForm error:IncorrectCredentialsException");
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
            logger.info("LoginController.showLoginForm error:"+error);

        }
        model.addAttribute("error", error);
        return "login";
    }


}
