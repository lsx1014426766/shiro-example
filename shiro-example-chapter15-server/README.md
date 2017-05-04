https://localhost:8443/chapter15-server/login
[INFO] Started SelectChannelConnector@0.0.0.0:8080
[INFO] Enabled Protocols [SSLv2Hello, SSLv3, TLSv1, TLSv1.1, TLSv1.2] of [SSLv2Hello, SSLv3, TLSv1, TLSv1.1, TLSv1.2]
[INFO] Started SslSocketConnector@0.0.0.0:8443
[INFO] Started Jetty Server

中心认证服务
CAS central access service
服务端 发放service ticket 返回servcice对应的客户端处理url

客户端拿到ticket后则，再访问受保护的资源时就要带着这个凭证到服务端做验证

术语：
 SSO 单点登录  single sign on
 TGT ticket granting ticket 用户认证凭证票据
 ST service ticket 服务许可凭证票据
 TGC ticket granting cookie 存放用户认证凭证的cookie

 在服务端进行身份认证，需要服务端获取相应的用户信息
 用户信息的存储方式有多种  db   xml文件检索   LDAP server等
 这里我们以db方式获取
 CAS 提供了一种灵活但统一的接口和实现分离的方式，
 实际使用中 CAS 采用哪种方式认证是与 CAS 的基本协议分离开的，
 用户可以根据认证的接口去定制和扩展。
 CAS 提供扩展认证的核心是 AuthenticationHandler 接口
 CAS3中还提供了对AuthenticationHandler 接口的一些
     抽象实现AbstractPreAndPostProcessingAuthenticationHandler
 由于实际运用中，最常用的是用户名和密码方式的认证，CAS3 提供了针对该方式的
      实现AbstractUsernamePasswordAuthenticationHandler
参考
https://www.ibm.com/developerworks/cn/opensource/os-cn-cas/
本示例中直接给定了用户名和密码的方式
JDBC 认证方法
1. 配置 DataStore

打开文件 %CATALINA_HOME%/webapps/cas/WEB-INF/deployerConfigContext.xml
2. 配置 AuthenticationHandler

在 cas-server-support-jdbc-3.1.1.jar 包中，
提供了 3 个基于 JDBC 的 AuthenticationHandler，
分别为
 BindModeSearchDatabaseAuthenticationHandler,
 QueryDatabaseAuthenticationHandler,
 SearchModeSearchDatabaseAuthenticationHandler。

 BindModeSearchDatabaseAuthenticationHandler
   是用所给的用户名和密码
   去建立数据库连接，根据连接建立是否成功来判断验证成功与否；
 QueryDatabaseAuthenticationHandler
    通过配置一个 SQL 语句查出密码，与所给密码匹配
 SearchModeSearchDatabaseAuthenticationHandler
    通过配置存放用户验证信息的表、用户名字段和密码字段，构造查询语句来验证
    使用 QueryDatabaseAuthenticationHandler：

    <bean class="org.jasig.cas.adaptors.jdbc.QueryDatabaseAuthenticationHandler">
     <property name="dataSource" ref=" casDataSource " />
     <property name="sql"
           value="select password from userTable where lower(userName) = lower(?)" />
    </bean>
    使用 SearchModeSearchDatabaseAuthenticationHandler：

    <bean id="SearchModeSearchDatabaseAuthenticationHandler"
          class="org.jasig.cas.adaptors.jdbc.SearchModeSearchDatabaseAuthenticationHandler"
          abstract="false" singleton="true" lazy-init="default"
                           autowire="default" dependency-check="default">
      <property  name="tableUsers">
       <value>userTable</value>
      </property>
      <property name="fieldUser">
       <value>userName</value>
      </property>
      <property name="fieldPassword">
       <value>password</value>
      </property>
      <property name="dataSource" ref=" casDataSource " />
    </bean>

    指定加密类
    <bean class="org.jasig.cas.adaptors.jdbc.QueryDatabaseAuthenticationHandler">
      <property name="dataSource" ref=" casDataSource " />
      <property name="sql"
       value="select password from userTable where lower(userName) = lower(?)" />
      <property  name="passwordEncoder"  ref="myPasswordEncoder"/>
    </bean>

    其中 myPasswordEncoder 是对清单 8 中设置的实际加密器类的引用：
    清单 8. 指定具体加密器类

    <bean id="passwordEncoder"
        class="org.jasig.cas.authentication.handler.MyPasswordEncoder"/>
