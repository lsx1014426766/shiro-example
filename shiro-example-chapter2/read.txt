1自定义realm
2学会使用xx.ini配置文件
登录认证，用户信息存储方式有很多，可以直接写在配置文件中
也可以写在db中，也可以写在自定义的realm中
3关于realm,需要指定实现的策略，策略可以使用shiro内置的，也可以自定义
4在securityManager里指定realm,这个realm是自己实现的，shiro不会帮你实现
可以同时指定多个，此时策略就是很关键，当有多个realm时，在执行时，会依据策略对
最后的结果进行处理，包括对与错 不满足策略的话就会抛出异常
SecurityUtils.getSubject();
subject.getPrincipals()