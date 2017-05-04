12章
http://jinnianshilongnian.iteye.com/blog/2029717/
Shiro的组件都是JavaBean/POJO式的组件，所以非常容易使用Spring进行组件管理，可以非常方便的从ini配置迁移到Spring进行管理，且支持JavaSE应用及Web应用的集成。



在示例之前，需要导入shiro-spring及spring-context依赖，具体请参考pom.xml。

spring-beans.xml配置文件提供了基础组件如DataSource、DAO、Service组件的配置
DelegatingFilterProxy会自动到Spring容器中查找名字为shiroFilter的bean并把filter请求交给它处理
Shiro权限注解

Shiro提供了相应的注解用于权限控制，如果使用这些注解就需要使用AOP的功能来进行判断，如Spring AOP；Shiro提供了Spring AOP集成用于权限注解的解析和验证。

为了测试，此处使用了Spring MVC来测试Shiro注解，当然Shiro注解不仅仅可以在web环境使用，在独立的JavaSE中也是可以用的，此处只是以web为例了。



在spring-mvc.xml配置文件添加Shiro Spring AOP权限注解的支持：
Java代码  收藏代码

    <aop:config proxy-target-class="true"></aop:config>
    <bean class="
    org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor">
        <property name="securityManager" ref="securityManager"/>
    </bean>

如上配置用于开启Shiro Spring AOP权限注解的支持；<aop:config proxy-target-class="true">表示代理类。



接着就可以在相应的控制器（AnnotationController）中使用如下方式进行注解：
Java代码  收藏代码

    @RequiresRoles("admin")
    @RequestMapping("/hello2")
    public String hello2() {
        return "success";
    }

        @RequiresUser

    表示当前Subject已经身份验证或者通过记住我登录的
        @RequiresRoles(value={“admin”, “user”}, logical= Logical.AND)

    表示当前Subject需要角色admin和user
        @RequiresPermissions (value={“user:a”, “user:b”}, logical= Logical.OR)

    表示当前Subject需要权限user:a或user:b。//
 启动报错：
 Unable to process Jar entry [org/springframework/web/servlet/tags/form/AbstractDataBoundFormElementTag.class] from Jar [jar:file:/D:/placeMavenRepository/org/springframework/spring-webmvc/4.0.0.RELEASE/spring-webmvc-4.0.0.RELEASE.jar!/] for annotations
 java.util.zip.ZipException: invalid distance too far back
     Unable to process Jar entry [org/springframework/web/servlet/tags/form/OptionsTag$OptionsWriter.class] from Jar [jar:file:/D:/placeMavenRepository/org/springframework/spring-webmvc/4.0.0.RELEASE/spring-webmvc-4.0.0.RELEASE.jar!/] for annotations

    java.util.zip.ZipException: invalid LOC header (bad signature)
    这个原因就是maven下载相关jar包时未下载完全，导致服务器进行加载解压时出错。

    这个就需要查看相关日志，找到没有下载完全的包进行手动下载

    删除本地有问题的依赖包，重新下载即可
    启动项目
    http://localhost:8080/chapter12/
    .JasperException: java.lang.NullPointerException
    此错误还是因为tomcat包下已经有了servle包，删除一个
    在pom.xml中注释servlet的依赖javax.servlet-api,jsp-api
    --- tomcat7-maven-plugin:2.2:run (default-cli) @ shiro-example-chapter12 ---
    [INFO] Running war on http://localhost:8080/chapter12
    [INFO] Using existing Tomcat server configuration at D:\b\shiro\shiro-example\shiro-example-chapter12\target\tomcat
    [INFO] create webapp with contextPath: /chapter12
    SLF4J: Defaulting to no-operation (NOP) logger implementation
    Mapped "{[/hello2],methods=[],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String com.github.zhangkaitao.shiro.chapter12.web.mvc.AnnotationController.hello2()
     Starting Servlet Engine: Apache Tomcat/7.0.47
    Root WebApplicationContext: initialization completed in 910 ms
    FrameworkServlet 'spring': initialization completed in 1010 ms

    匿名拦截器，即不需要登录即可访问；一般用于静态资源过滤；示例“/static/**=anon”
    登录通过表单验证拦截器，进入userRealm进行验证，成功则会进入上个页面
    （如果没有指定成功页面的话）

    整体来说：
    db方面 permission存储权限符合use:create这种形式
    shiro已经提供好了封装的authenticationInfo,authorizationInfo对象
    认证方面：
      利用shiroFilter bean来控制去往useRealm里做用户认证
    启动tomcat，jetty方面，注意jar包的完整性 问题jar可能就需要重新下载了
    注意观看启动日志记录

    时刻关注shiro提供的基础操作类
    像shiro权限注解 可以检查用户当具有某种角色或者是权限后才可以访问某个方法
    对于异常
    可以用spring的全局异常处理类 自定义实现加上注解@ControllerService
    给指定的异常类一个去往的错误页面

