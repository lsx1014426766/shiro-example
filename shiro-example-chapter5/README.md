参看http://www.codeweblog.com/shiro%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E4%BA%94-credentialsmatcher/

存入db的是加密后的值
主要涉及到了加密环节，之前几个章节密码是明文存储的
Salting password，加盐的密码。对密码进行一些混淆增加破解的难度。
一般对密码都不会是明文存储，而是对密码进行MD5处理，增强反向解密难度。但这样还是能可以找出破绽。
如果用户可以查看数据库，那么他可以观察到自己的密码和别人的密码加密后的结果都是一样
那么，就会知道别人用的和自己就是同一个密码。
对于这个问题其实只要稍微混淆一下就能防范住了，这在加密术语中称为“加盐”。
具体来说就是在原有材料（用户自定义密码）中加入其它成分（一般是用户自有且不变的因素），
以此来增加系统复杂度。当这种盐和用户密码相结合后，再通过摘要处理，就能得到隐蔽性更强的摘要值

EhCache 是一个纯Java的进程内缓存框架，具有快速、精干等特点，是Hibernate中默认的CacheProvider
一种广泛使用的开源Java分布式缓存
它具有内存和磁盘存储，缓存加载器,缓存扩展,缓存异常处理程序,一个gzip缓存servlet过滤器,支持REST和SOAP api等特点。
在java项目广泛的使用。它是一个开源的、设计于提高在数据从RDBMS中取出来的高花费、高延迟采取的一种缓存方案。正因为Ehcache具有健壮性（基于java开发）、被认证（具有apache 2.0  license）、充满特色（稍后会详细介绍），所以被用于大型复杂分布式web application的各个节点中。
特点：快，简单，袖珍
提供LRU、LFU、FIFO淘汰算法，  缓存清除策略
够简单就是Ehcache的一大特色，自然用起来just so easy!


//使用testGeneratePassword生成的散列密码
以明文密码 salt=username+随机数 再由此生成散列密码，db中同时保存salt和散列密码，注意
这个salt因为是随机数，所以必须要salt和散列密码匹配才能得到匹配得到明文密码

shiro提供了PasswordService及CredentialsMatcher用于提供加密密码及验证密码服务
shiro默认提供了PasswordService的实现DefaultPasswordService；
CredentialsMatcher的实现PasswordMatcher及HashedCredentialsMatcher（更强大）

public class PasswordMatcher implements CredentialsMatcher

对于服务器端存储的密码分成String和Hash两种，然后由PasswordService 来分别处理。
所以PasswordMatcher 也只是完成了一个流程工作，具体的内容要到PasswordService 来看

Hash computed =
new SimpleHash(algorithmName, source, salt, iterations)这就就是上文我们强调的加密核心

format就是将一些算法信息、hash次数、salt等进行字符串的拼接，
parse过程则是根据拼接的信息逆向获取算法信息、hash次数、salt等信息而已。
这里就终于明白了，为什么PasswordMatcher 对服务器端存储的密码分成Hash和String来处理了，
他们都是存储算法、salt、hash次数等信息的地方，Hash直接是以结构化的类来存储，
而String则是以格式化的字符串来存储，需要parse才能获取算法、salt等信息