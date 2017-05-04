https://localhost:8443/chapter15-server/login
[INFO] Started SelectChannelConnector@0.0.0.0:8080
[INFO] Enabled Protocols [SSLv2Hello, SSLv3, TLSv1, TLSv1.1, TLSv1.2] of [SSLv2Hello, SSLv3, TLSv1, TLSv1.1, TLSv1.2]
[INFO] Started SslSocketConnector@0.0.0.0:8443
[INFO] Started Jetty Server

getResponseFromServer
严重: https://localhost:8443/chapter14-server/serviceValidate?ticket=ST-1-LrOjETJf641ECkVC4f9u-cas01.example.org&service=https%3A%2F%2Flocalhost%3A9443%2Fchapter14-client%2Fcas
java.io.FileNotFoundException: https://localhost:8443/chapter14-server/serviceValidate?ticket=ST-1-LrOjETJf641ECkVC4f9u-cas01.example.org&service=https%3A%2F%2Flocalhost%3A9443%2Fchapter14-client%2Fcas
	at sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1624)