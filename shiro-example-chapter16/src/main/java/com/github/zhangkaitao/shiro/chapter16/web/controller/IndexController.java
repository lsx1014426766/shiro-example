package com.github.zhangkaitao.shiro.chapter16.web.controller;

import com.github.zhangkaitao.shiro.chapter16.entity.Resource;
import com.github.zhangkaitao.shiro.chapter16.entity.User;
import com.github.zhangkaitao.shiro.chapter16.service.ResourceService;
import com.github.zhangkaitao.shiro.chapter16.service.UserService;
import com.github.zhangkaitao.shiro.chapter16.web.bind.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 * 用户有组织
 * 组织有角色
 * 用户有角色
 * 角色有对应的访问资源
 * 角色有对应的权限
 * 资源有类型，有权限
 *
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private UserService userService;

    //未登录之前会被过滤前往登录页，只有成功登录才会进入这里所以不会又user为空的情况

    /**
     * 在sysuserFilter里面获取到了用户user信息，然后放在request attribute里
     * 在通过中介@CurrentUser这个注解取出来，给了参数接收对象
     * @param loginUser
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(@CurrentUser User loginUser, Model model) {
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
       //通过权限查找资源列表
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


}
