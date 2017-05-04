14章节
http://jinnianshilongnian.iteye.com/blog/2036420
对于SSL的支持，Shiro只是判断当前url是否需要SSL登录，
如果需要自动重定向到https进行访问
首先生成数字证书，生成证书到D:\localhost.keystore

使用JDK的keytool命令，生成证书（包含证书/公钥/私钥）到D:\localhost.keystore：

keytool -genkey -keystore "D:\localhost.keystore" -alias localhost -keyalg RSA

Secure Socket Layer为Netscape所研发，用以保障在Internet上数据传输之安全
传输层安全（Transport Layer Security，TLS）
SSL协议位于TCP/IP协议与各种应用层协议之间，为数据通讯提供安全支持