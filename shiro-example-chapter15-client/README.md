15章
Shiro 1.2开始提供了Jasig CAS单点登录的支持，单点登录主要用于多系统集成
客户端：9080 9443端口
服务端：8080 8443端口
利用java提供的工具（keytool）来生成证书
此证书 名字写成localhost


[INFO] started o.m.j.p.JettyWebAppContext{/chapter15-client,file:/D:/b/shiro/shiro-example/shiro-example-chapter15-client/src/main/webapp/},file:/D:/b/shiro/shiro-example/shiro-example-chapter15-client/src/main/webapp/
[INFO] Started SelectChannelConnector@0.0.0.0:9080
[INFO] Enabled Protocols [SSLv2Hello, SSLv3, TLSv1, TLSv1.1, TLSv1.2] of [SSLv2Hello, SSLv3, TLSv1, TLSv1.1, TLSv1.2]
[INFO] Started SslSocketConnector@0.0.0.0:9443
[INFO] Started Jetty Server

http://localhost:9080/chapter15-client
https://localhost:9443/chapter15-client/cas?ticket=ST-1-xWwmdZFhHWPlioob5oZu-cas01.example.org
https://localhost:9443/chapter15-client/casFailure.jsp
 java.security.cert.CertificateException: No name matching localhost found
javax.net.ssl.SSLHandshakeException: java.security.cert.CertificateException: No name matching localhost found

keytool -genkey -keystore "D:\b\localhost.keystore" -alias localhost -keyalg RSA
keytool -export -alias localhost -file D:\b\localhost.cer -keystore D:\b\localhost.keystore
D:\workLsx\jdk\jre\lib\security
keytool -import -alias localhost -file D:\b\localhost.cer -noprompt -trustcacerts -storetype jks -keystore cacerts -storepass 123456

casServerUrlPrefix：是CAS Server服务器端地址；

casService：是当前应用CAS服务URL，即用于接收并处理登录成功后的Ticket的