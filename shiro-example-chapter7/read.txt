第7章节 http://jinnianshilongnian.iteye.com/blog/2024723
Shiro提供了与Web集成的支持，其通过一个ShiroFilter入口来拦截需要安全控制的URL，
然后进行相应的控制，ShiroFilter类似于如Strut2/SpringMVC这种web框架的前端控制器，
其是安全控制的入口点，其负责读取配置（如ini配置文件），然后判断URL是否需要登录/权限等工作

当前测试中，将权限和角色，用户，密码等信息都直接放在了ini配置文件中，正式环境中应该是在
servlert里面根据用户登录时输入的用户名密码进行db验证，判断获取其相应的角色和权限

shiro只是在它能控制的范围内，为我们做了他所能做的一切，以便我们可以专注于逻辑的开发

1、创建webapp应用

此处我们使用了jetty-maven-plugin和tomcat7-maven-plugin插件；这样可以直接使用“mvn jetty:run”或“mvn tomcat7:run”直接运行webapp了。
然后通过URLhttp://localhost:8080/chapter7/访问即可

!我在配置中写的 jetty:run 前面没有mvn

 Context path = /chapter7
[INFO] Tmp directory = D:\b\shiro\shiro-example\shiro-example-chapter7\target\tmp
[INFO] Web defaults = org/eclipse/jetty/webapp/webdefault.xml
[INFO] Web overrides =  none
[INFO] web.xml file = file:/D:/b/shiro/shiro-example/shiro-example-chapter7/src/main/webapp/WEB-INF/web.xml
[INFO] Webapp directory = D:\b\shiro\shiro-example\shiro-example-chapter7\src\main\webapp
[INFO] jetty-8.1.8.v20121106

访问入口
http://localhost:8080/chapter7/

1、使用IniShiroFilter作为Shiro安全控制的入口点，通过url-pattern指定需要安全的URL；

2、通过configPath指定ini配置文件位置，默认是先从/WEB-INF/shiro.ini加载，如果没有就默认加载classpath:shiro.ini，即默认相对于web应用上下文根路径；

3、也可以通过如下方式直接内嵌ini配置文件内容到web.xml
Java代码

    <init-param>
        <param-name>config</param-name>
        <param-value>
            ini配置文件贴在这
        </param-value>
    </init-param>

 [urls]部分的配置，其格式是： “url=拦截器[参数]，拦截器[参数]”；即如果当前请求的url匹配[urls]部分的某个url模式，将会执行其配置的拦截器。比如anon拦截器表示匿名访问（即不需要登录即可访问）；authc拦截器表示需要身份认证通过后才能访问；roles[admin]拦截器表示需要有admin角色授权才能访问；而perms["user:create"]拦截器表示需要有“user:create”权限才能访问。
若拦截器为annon,则为匿名访问，谁都可以，下一步就是跳转到指定的url对应的servlet里了


 url模式使用Ant风格模式

 Ant路径通配符支持?、*、**，注意通配符匹配不包括目录分隔符“/”：

 ?：匹配一个字符，如”/admin?”将匹配/admin1，但不匹配/admin或/admin2；

 *：匹配零个或多个字符串，如/admin*将匹配/admin、/admin123，但不匹配/admin/1；

 **：匹配路径中的零个或多个路径，如/admin/**将匹配/admin/a或/admin/a/b。



 url模式匹配顺序

 url模式匹配顺序是按照在配置中的声明顺序匹配，即从头开始使用第一个匹配的url模式对应的拦截器链。如：
 Java代码  收藏代码

     /bb/**=filter1
     /bb/aa=filter2
     /**=filter3

 如果请求的url是“/bb/aa”，因为按照声明顺序进行匹配，那么将使用filter1进行拦截

 Shiro内置了登录（身份验证）的实现：基于表单的和基于Basic的验证，其通过拦截器实现
     [main]
     authcBasic.applicationName=please login
     ………省略users
     [urls]
     /role=authcBasic,roles[admin]

 1、authcBasic是org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter类型的实例，其用于实现基于Basic的身份验证；applicationName用于弹出的登录框显示信息使用
 基于表单的拦截器身份验证

 基于表单的拦截器身份验证和【1】类似，但是更简单，因为其已经实现了大部分登录逻辑；我们只需要指定：登录地址/登录失败后错误信息存哪/成功的地址即可。

 3.1、shiro-formfilterlogin.ini

     [main]
     authc.loginUrl=/formfilterlogin
     authc.usernameParam=username
     authc.passwordParam=password
     authc.successUrl=/
     authc.failureKeyAttribute=shiroLoginFailure

     [urls]
     /role=authc,roles[admin]

 1、authc是org.apache.shiro.web.filter.authc.FormAuthenticationFilter类型的实例，
 其用于实现基于表单的身份验证；通过loginUrl指定当身份验证时的登录表单；
 usernameParam指定登录表单提交的用户名参数名；
 passwordParam指定登录表单提交的密码参数名；
 successUrl指定登录成功后重定向的默认地址（默认是“/”）（如果有上一个地址会自动重定向带该地址）；
 failureKeyAttribute指定登录失败时的request属性key（默认shiroLoginFailure）；
 这样可以在登录表单得到该错误key显示相应的错误消息；
 输入http://localhost:8080/chapter7/role，会跳转到“/formfilterlogin”登录表单，
 提交表单如果authc拦截器登录成功后，会直接重定向会之前的地址“/role”；
 假设我们直接访问“/formfilterlogin”的话登录成功将直接到默认的successUrl

 @WebServlet(name = "authenticatedServlet", urlPatterns = "/authenticated")
 public class AuthenticatedServlet extends HttpServlet
 使用注解方式，就不需要在web.xml里写Servlet里，此注解为servlet包提供的