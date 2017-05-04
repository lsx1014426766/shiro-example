8章http://jinnianshilongnian.iteye.com/blog/2025656
主讲filter过滤器[filter]
AccessControlFilter还提供了如下方法用于处理如登录成功后/重定向到上一个请求：
Java代码

    void setLoginUrl(String loginUrl) //身份验证时使用，默认/login.jsp
    String getLoginUrl()
    Subject getSubject(ServletRequest request, ServletResponse response) //获取Subject实例
    boolean isLoginRequest(ServletRequest request, ServletResponse response)//当前请求是否是登录请求
    void saveRequestAndRedirectToLogin(ServletRequest request, ServletResponse response) throws IOException //将当前请求保存起来并重定向到登录页面
    void saveRequest(ServletRequest request) //将请求保存起来，如登录成功后再重定向回该请求
    void redirectToLogin(ServletRequest request, ServletResponse response) //重定向到登录页面

Shiro对Servlet容器的FilterChain进行了代理，即ShiroFilter在继续Servlet容器的Filter链的执行之前，通过ProxiedFilterChain对Servlet容器的FilterChain进行了代理；即先走Shiro自己的Filter体系，然后才会委托给Servlet容器的FilterChain进行Servlet容器级别的Filter链执行
DefaultFilterChainManager会默认添加org.apache.shiro.web.filter.mgt.DefaultFilter中声明的拦截器
    public enum DefaultFilter {
        anon(AnonymousFilter.class),
        authc(FormAuthenticationFilter.class),
        authcBasic(BasicHttpAuthenticationFilter.class),
        logout(LogoutFilter.class),
        noSessionCreation(NoSessionCreationFilter.class),
        perms(PermissionsAuthorizationFilter.class),
        port(PortFilter.class),
        rest(HttpMethodPermissionFilter.class),
        roles(RolesAuthorizationFilter.class),
        ssl(SslFilter.class),
        user(UserFilter.class);
    }

    PathMatchingFilterChainResolver内部通过FilterChainManager维护着拦截器链，比如DefaultFilterChainManager实现维护着url模式与拦截器链的关系
    默认的拦截器会自动注册，可以直接在ini配置文件中通过“拦截器名.属性”设置其属性
    1、扩展OncePerRequestFilter

    OncePerRequestFilter保证一次请求只调用一次doFilterInternal，即如内部的forward不会再多执行一次
    2、扩展AdviceFilter

    AdviceFilter提供了AOP的功能，其实现和SpringMVC中的Interceptor思想一样：具体可参考我的SpringMVC教程中的处理器拦截器部分：

    http://www.iteye.com/blogs/subjects/kaitao-springmvc
    3、PathMatchingFilter

    PathMatchingFilter继承了AdviceFilter，提供了url模式过滤的功能，如果需要对指定的请求进行处理，可以扩展PathMatchingFilter：

    4、AccessControlFilter继承了PathMatchingFilter，并扩展了了两个方法
    isAccessAllowed：即是否允许访问，返回true表示允许；

    onAccessDenied：表示访问拒绝时是否自己处理，如果返回true表示自己不处理且继续拦截器链执行，返回false表示自己已经处理了（比如重定向到另一个页面）