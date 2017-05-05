16章节
参考文档：http://jinnianshilongnian.iteye.com/blog/2037222
Running war on http://localhost:8080/chapter16
信息: Mapped "{[/],methods=[],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.IndexController.index(com.github.zhangkaitao.shiro.chapter16.entity.User,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/welcome],methods=[],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.IndexController.welcome()
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/login],methods=[],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.LoginController.showLoginForm(javax.servlet.http.HttpServletRequest,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization/{id}/update],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.update(com.github.zhangkaitao.shiro.chapter16.entity.Organization,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.index(org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization/{id}/delete],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.delete(java.lang.Long,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization/{parentId}/appendChild],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.create(com.github.zhangkaitao.shiro.chapter16.entity.Organization)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization/{sourceId}/move],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.move(java.lang.Long,java.lang.Long)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization/success],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.success()
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization/{id}/maintain],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.showMaintainForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization/{parentId}/appendChild],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.showAppendChildForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization/{sourceId}/move],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.showMoveForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/organization/tree],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.OrganizationController.showTree(org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/resource/{id}/update],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.ResourceController.update(com.github.zhangkaitao.shiro.chapter16.entity.Resource,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/resource],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.ResourceController.list(org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/resource/{id}/delete],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.ResourceController.delete(java.lang.Long,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/resource/{parentId}/appendChild],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.ResourceController.create(com.github.zhangkaitao.shiro.chapter16.entity.Resource,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/resource/{parentId}/appendChild],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.ResourceController.showAppendChildForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/resource/{id}/update],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.ResourceController.showUpdateForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/role/{id}/update],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.RoleController.update(com.github.zhangkaitao.shiro.chapter16.entity.Role,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/role],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.RoleController.list(org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/role/{id}/delete],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.RoleController.delete(java.lang.Long,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/role/create],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.RoleController.create(com.github.zhangkaitao.shiro.chapter16.entity.Role,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/role/create],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.RoleController.showCreateForm(org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/role/{id}/delete],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.RoleController.showDeleteForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/role/{id}/update],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.RoleController.showUpdateForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/user/{id}/update],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.UserController.update(com.github.zhangkaitao.shiro.chapter16.entity.User,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/user],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.UserController.list(org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/user/{id}/delete],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.UserController.delete(java.lang.Long,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/user/create],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.UserController.create(com.github.zhangkaitao.shiro.chapter16.entity.User,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/user/create],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.UserController.showCreateForm(org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/user/{id}/delete],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.UserController.showDeleteForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/user/{id}/changePassword],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.UserController.showChangePasswordForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/user/{id}/update],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.UserController.showUpdateForm(java.lang.Long,org.springframework.ui.Model)
五月 04, 2017 3:50:24 下午 org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping registerHandlerMethod
信息: Mapped "{[/user/{id}/changePassword],methods=[POST],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter16.web.controller.UserController.changePassword(java.lang.Long,java.lang.String,org.springframework.web.servlet.mvc.support.RedirectAttributes)
五月 04, 2017 3:50:25 下午 org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver initExceptionHandlerAdviceCache
信息: Detected @ExceptionHandler methods in com.github.zhangkaitao.shiro.chapter16.web.exception.DefaultExceptionHandler#0
五月 04, 2017 3:50:25 下午 org.springframework.web.servlet.handler.SimpleUrlHandlerMapping registerHandler
信息: Mapped URL path [/**] onto handler 'org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler#0'
五月 04, 2017 3:50:25 下午 org.springframework.web.servlet.handler.SimpleUrlHandlerMapping registerHandler
信息: Mapped URL path [/static/**] onto handler 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0'
五月 04, 2017 3:50:25 下午 org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver initExceptionHandlerAdviceCache
信息: Detected @ExceptionHandler methods in com.github.zhangkaitao.shiro.chapter16.web.exception.DefaultExceptionHandler#0
五月 04, 2017 3:50:25 下午 org.springframework.web.servlet.DispatcherServlet initServletBean
信息: FrameworkServlet 'spring': initialization completed in 1503 ms
五月 04, 2017 3:50:25 下午 org.apache.coyote.AbstractProtocol start
信息: Starting ProtocolHandler ["http-bio-8080"]


关于log4j的使用：
http://www.codeceo.com/article/log4j-usage.html
关于log4j起作用：
没有引入log4j相关的依赖的话，log不打印，也不报错
1普通java项目
2web项目  依赖于一个servlet
3依靠spring的方式：
   1引入依赖pom.xml:
     <dependency>
               <groupId>log4j</groupId>
               <artifactId>log4j</artifactId>
               <version>1.2.16</version>
           </dependency>
           <dependency>
               <groupId>org.slf4j</groupId>
               <artifactId>slf4j-log4j12</artifactId>
               <version>1.7.21</version>
           </dependency>
           <dependency>
                <groupId>org.perf4j</groupId>
                <artifactId>perf4j</artifactId>
                <version>0.9.16</version>
            </dependency>
            注意perf4j不引入的话会去报错ClassNotFound
            2在web.xml中加入配置文件log4j.propertes和监听器
             <context-param>
                    <param-name>log4jConfigLocation</param-name>
                    <param-value>classpath:log4j.properties</param-value>
                </context-param>
                 <listener>
                        <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
                    </listener>

  springframework提供了自己的标签库
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
http://blog.csdn.net/xuweilinjijis/article/details/8691538

  springMVC使用HandlerMethodArgumentResolver 自定义解析器实现请求参数绑定方法参数
  http://blog.csdn.net/truong/article/details/30971317
  http://blog.csdn.net/fytain/article/details/43918609

  jquery ztree用法
  http://dl2.iteye.com/upload/attachment/0047/5757/4a192c83-78f1-3558-8c06-f889acedbaa2.pdf

  sql like通配符用法
  http://blog.csdn.net/xushichang/article/details/4399204
  % 	替代一个或多个字符
  _ 	仅替代一个字符
  SELECT * FROM Person.Contact WHERE LastName LIKE 'Ad%'     --Ad开头
  SELECT * FROM Person.Contact WHERE LastName LIKE '%[fk]%'  --包含f或者k

关于@CurrentUser注解：
此注解在IndexController中访问"/"时，参数loginUser会获取到数据：
1在进入此controller之前，先经过了sysuserFilter,它会根据userName查找到
用户的信息放在user对象中，并且把这个对象放在了request的attribute里
2注解类CUrrentUserMethodArgumentResolver实现了HandlerMethodArgumentResolver接口
在里面，获取到request attribute里的user对象，并把它和注解@CurrentUser关联起来了
然后就可以通过在接口参数中获取到了

4关于struts遇到的一个问题：
struts的jsp里，如果使用struts提供的form标签，可以不写访问的action后缀，标签会自动加上这个默认的后缀
但是，如果使用的是普通的form标签的话，就需要把这个路径的action后缀加上
在访问时其实已经跳往了这个指定的action里，然后return "login"，而这个login在
struts的配置文件里是没有定义这个result的，所以就导致错误信息
但是看起来，这个过程让人以为是路径一开始跳转的问题，所以在这里记录下
还是应该在走过的路上，都打上断点，获取做日志跟踪
遇到问题的时候，多试试，多测，或许就能找到出错的源头在哪里了

当遇到jar包缺失，而这个类所在的jar包的名字又不知道时
可以尝试着去maven repository里搜索包名里面出现的关键词，容纳后在maven中
找到后，把这个jar下载，查看，确认后，再把它加入项目的classpath中
及时认为这个jar在项目中自己用不到，但又不知道是哪里内部用到了，就先把它引入进来
让项目正常运行，至于到底在哪里用到了就先不追究了
不要在行走的路上被太多东西牵绊，遇到问题先解决并做个记录 标记， 等以后可能
在自己需要的时候就可能真正明白了
先把自己的关注点搞明白了
因为使用框架或者是工具，本身就是基于一些处理好的东西的基础上，避免了去思考很多底层的实现
既然，站在巨人的肩膀上，就先把目的实现了
在这一路上一步步思考
等哪天就会豁然开朗

项目导入进来后，报错，而且是基础的servlet类：
原因：这个类的来源并不是自己在项目中手动导入的，而是基于eclipse中
配置配置的tomcat 下的lib包 而项目刚引入进来还没有关联jdk,tomcat


解决：
在configure buildpaths时，注意绑定tomcat，jdk

相反的，在绑定了tomcat后，
很多时候，如果tomcat下有了这个包，而自己在项目中又引入了
此时就会造成jar包的冲突
经常会遇到报错jasper  null pointer之类的错误，在项目启动的时候
这时只留下一份jar就解决问题了
maven项目中，通过工具idea把project structure下的dependency删除不用的
或者是把pom.xml引入的2个dependency javax-servlert-api,jsp-api注释掉