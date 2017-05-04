记住我功能 13章节
http://jinnianshilongnian.iteye.com/blog/2031823

subject.isAuthenticated()表示用户进行了身份验证登录的，
即使有Subject.login进行了登录；subject.isRemembered()：
表示用户是通过记住我登录的，此时可能并不是真正的你

访问一般网页，如个人在主页之类的，我们使用user拦截器即可，user拦截器只要用户登录(isRemembered()==true or isAuthenticated()==true)过即可访问成功；

访问特殊网页，如我的订单，提交订单页面，我们使用authc拦截器即可，authc拦截器会判断用户是否是通过Subject.login（isAuthenticated()==true）登录的，如果是才放行，否则会跳转到登录页面叫你重新登录。



因此RememberMe使用过程中，需要配合相应的拦截器来实现相应的功能，用错了拦截器可能就不能满足你的需求了

http://localhost:8080/chapter13/
登录后，关闭浏览器，重新访问，还是登录