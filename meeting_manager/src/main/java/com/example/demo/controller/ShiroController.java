/*
 * package com.example.demo.controller;
 * 
 * import org.apache.shiro.SecurityUtils; import
 * org.apache.shiro.authc.IncorrectCredentialsException; import
 * org.apache.shiro.authc.UnknownAccountException; import
 * org.apache.shiro.authc.UsernamePasswordToken; import
 * org.apache.shiro.crypto.hash.SimpleHash; import
 * org.apache.shiro.subject.Subject; import org.apache.shiro.util.ByteSource;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.example.demo.entity.Employee; import
 * com.example.demo.service.EmployeeService;
 * 
 * 
 * @Controller
 * 
 * @RequestMapping("/shiro") public class ShiroController {
 * 
 * @Autowired private EmployeeService employeeService;
 * 
 *//**
	 * 注册
	 **/
/*
 * @PostMapping("zhuce") public String zhuce(String name,String password,Model
 * model) { Employee employee=new Employee(); employee.setEmployeeName(name);
 * employee.setEmployeePassword(((new SimpleHash("MD5",password,
 * ByteSource.Util.bytes("123"), 1024)).toString()));
 * employeeService.add(employee); //设置密码加密方式 return "index"; }
 * 
 * 
 *//**
	 * 登录逻辑处理
	 */
/*
 * @PostMapping("login") public String login(String name, String
 * password,boolean rememberMe, Model model) {
 * 
 *//**
	 * 使用Shiro编写认证操作
	 *//*
		 * // 1.获取Subject Subject subject = SecurityUtils.getSubject();
		 * 
		 * // 2.封装用户数据 UsernamePasswordToken token = new UsernamePasswordToken(name,
		 * password,rememberMe);
		 * 
		 * // 3.执行登录方法 try { subject.login(token);
		 * 
		 * // 登录成功 // 跳转到test.html return "redirect:/testThymeleaf"; } catch
		 * (UnknownAccountException e) { // e.printStackTrace(); // 登录失败:用户名不存在
		 * model.addAttribute("msg", "用户名不存在"); return "index"; } catch
		 * (IncorrectCredentialsException e) { // e.printStackTrace(); // 登录失败:密码错误
		 * model.addAttribute("msg", "密码错误"); return "index"; } }
		 * 
		 * 
		 * 拦截后的跳转页面 修改调整的登录页面 == shiroFilterFactoryBean.setLoginUrl("/toLogin");
		 * 
		 * 
		 * @RequestMapping("toLogin") public String login() { return "index"; }
		 * 
		 * @RequestMapping("add") public String add() { return "user/add"; }
		 * 
		 * @RequestMapping("update") public String update() { return "user/update"; }
		 * 
		 * @RequestMapping("notAuth") public String noAuth() { return "notAuth"; }
		 * 
		 * }
		 */