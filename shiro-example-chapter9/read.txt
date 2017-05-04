9章
http://jinnianshilongnian.iteye.com/blog/2026398
http://localhost:8080/chapter9
JasperException: java.lang.NullPointerException

Shiro提供了JSTL标签用于在JSP/GSP页面进行权限控制，如根据登录用户显示相应的页面按钮
将Java web工程部署到tomcat中，启动tomcat打开jsp页面出现org.apache.jasper.JasperException: Java.lang.NullPointerException错误。这是由于项目中build path中加载的一些包与tomcat中的包重复，在项目中删除对应的包就行。

之前出现另外一种类似的情况，也是提示org.apache.jasper.JasperException: java.lang.NullPointerException错误。是通过ftp登录tomcat所在服务器，直接修改web工程中的jsp页面，然后重启tomcat。这时tomcat没有重新编译对应的jsp文件，导致没有重新生成class。需要将jsp文件下载到本地进行修改，再上传到服务器上覆盖原来的文件，重新启动tomcat。
  在pom.xml中加了注释，就会从当前maven依赖中移除，此时OK了
  <!--  <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.0.1</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>-->

        默认访问index.jsp吗，，web.xml中没有指定？