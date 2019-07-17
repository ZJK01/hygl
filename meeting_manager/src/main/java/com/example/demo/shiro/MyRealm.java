/*
 * package com.example.demo.shiro;
 * 
 * import javax.annotation.Resource;
 * 
 * import org.apache.shiro.SecurityUtils; import
 * org.apache.shiro.authc.AuthenticationException; import
 * org.apache.shiro.authc.AuthenticationInfo; import
 * org.apache.shiro.authc.AuthenticationToken; import
 * org.apache.shiro.authc.SimpleAuthenticationInfo; import
 * org.apache.shiro.authc.UsernamePasswordToken; import
 * org.apache.shiro.authz.AuthorizationInfo; import
 * org.apache.shiro.authz.SimpleAuthorizationInfo; import
 * org.apache.shiro.realm.AuthorizingRealm; import
 * org.apache.shiro.subject.PrincipalCollection; import
 * org.apache.shiro.subject.Subject; import org.apache.shiro.util.ByteSource;
 * 
 * import com.example.demo.entity.Employee; import
 * com.example.demo.service.EmployeeService;
 * 
 * public class MyRealm extends AuthorizingRealm {
 * 
 * 
 * @Override // 授权(授权过滤器) protected AuthorizationInfo
 * doGetAuthorizationInfo(PrincipalCollection principals) {
 * System.out.println("执行授权逻辑"); //给资源进行授权 SimpleAuthorizationInfo info=new
 * SimpleAuthorizationInfo();
 * 
 * 
 * 添加资源的授权字符串(静态查询) info.addStringPermission("user:add");
 * 
 * //获取当前登录用户 Subject subject=SecurityUtils.getSubject();
 * System.out.println("2"+subject.getPrincipal()); Employee employee=(Employee)
 * subject.getPrincipal();
 * 
 * Employee employee2 =employeeservice.findById(employee.getEmployeeId());
 * String power=employee2.getPower(); //赋予权限 info.addStringPermission(power);
 * 
 * return info; }
 * 
 * @Resource(name = "EmployeeServiceImpl") private EmployeeService
 * employeeservice; //必须放在中间,不然莫名报错(会先执行上面的内容)
 * 
 * @Override // 认证 protected AuthenticationInfo
 * doGetAuthenticationInfo(AuthenticationToken arg0) throws
 * AuthenticationException { System.out.println("执行认证逻辑");
 * 
 * // 编写shiro判断逻辑，判断用户名和密码 // 1.判断用户名 UsernamePasswordToken token =
 * (UsernamePasswordToken) arg0;
 * 
 * Employee employee = employeeservice.findByName(token.getUsername());
 * 
 * if (employee == null){ // 用户名如果不存在 return null;
 * //shiro底层会跑出unknowAccountException } //加盐MD5 ByteSource
 * salt=ByteSource.Util.bytes("123");
 * 
 * // 2.判断密码(getPrincipal()==下面的user对象)
 * 
 * return new SimpleAuthenticationInfo(user, user.getPassword(),"");
 * 用户,密码,盐值,realme名字 return new
 * SimpleAuthenticationInfo(employee,employee.getEmployeepassword(), salt,
 * "MyRealm"); }
 * 
 * }
 * 
 */