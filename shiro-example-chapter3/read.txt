chapter3内容
讨论角色 权限关系
对于Role-Permission两级权限体系，大多数情况下，我们都是直接使用Shiro提供的WildcardPermission来实现细粒度的权限控制。

isPermitted
checkPermissions
checkRoles

授权相关authorize
#自定义permission 以+开头的形式 +资源+权限+实例
#自定义permissionResolver  解析权限字符串的2种形式，就是个中转站
#自定义rolePermissionResolver 直接在里面定义某种角色有某种权限
realm基于authrize
#自定义realm

问题：从db中获取realm,即用户，权限，角色的关系时，对于表结构字段的有规定吗？


Shiro为我们定义了一个抽象的权限描述字串：
【资源】：【操作】：【实例】

例如：”user:create,update”,”user:delete:100110”，等等。

Shiro的通配符权限，可以这样使用【以下描述中『授权』指分配给当前用户的权限，而『校验』指在注解或JSP标签中写的权限】：

    授权（user），校验（user），结果（通过）
    授权（user），校验（user:create），结果（通过）
    授权（user:create），校验（user:update），结果（不通过）
    授权（user:create），校验（user:create,update），结果（不通过）
    授权（user:create,update），校验（user:update），结果（通过）
    授权（user:create），校验（user:*），结果（不通过）
    授权（user:*），校验（user:create），结果（通过）
  printer:print:epsoncolor   //第一个是资源   第二个是操作  第三个是该资源的实例
+授权，也叫访问控制，即在应用中控制谁能访问哪些资源（如访问页面/编辑数据/页面操作等）。在授权中需了解的几个关键对象：主体（Subject）、资源（Resource）、权限（Permission）、角色（Role）。
+主体
+主体，即访问应用的用户，在Shiro中使用Subject代表该用户。用户只有授权后才允许访问相应的资源。
+资源
+在应用中用户可以访问的任何东西，比如访问JSP页面、查看/编辑某些数据、访问某个业务方法、打印文本等等都是资源。用户只要授权后才能访问。
+权限
+安全策略中的原子授权单位，通过权限我们可以表示在应用中用户有没有操作某个资源的权力。即权限表示在应用中用户能不能访问某个资源，如：
+访问用户列表页面
+查看/新增/修改/删除用户数据（即很多时候都是CRUD（增查改删）式权限控制）
+打印文档等等。
+
+* 用户-角色 ：规则即：“用户名=密码,角色1，角色2”，
+* 角色-权限 ：规则：“用户名=密码，角色1，角色2”“角色=权限1，权限2”，
+
+此时我们继承AuthorizingRealm而不是实现Realm接口；推荐使用AuthorizingRealm，因为：
+AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)：表示获取身份验证信息；
+AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)：表示根据用户身份获取授权信息。
+这种方式的好处是当只需要身份验证时只需要获取身份验证信息而不需要获取授权信息。
* @brief  *  规则
+ *    +资源字符串+权限位+实例ID
+ *
+ *  以+开头 中间通过+分割
+ *
+ *  权限：
+ *     0 表示所有权限
+ *     1 新增 0001
+ *     2 修改 0010
+ *     4 删除 0100
+ *     8 查看 1000
+ *  如 +user+10 表示对资源user拥有修改/查看权限
+ *  不考虑一些异常情况