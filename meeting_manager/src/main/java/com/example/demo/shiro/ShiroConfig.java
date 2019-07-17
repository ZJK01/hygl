/*
 * package com.example.demo.shiro;
 * 
 * import java.util.LinkedHashMap; import java.util.Map;
 * 
 * import org.apache.shiro.authc.credential.HashedCredentialsMatcher; import
 * org.apache.shiro.spring.web.ShiroFilterFactoryBean; import
 * org.apache.shiro.web.mgt.DefaultWebSecurityManager; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
 * 
 * shiro的配置类
 * 
 * @Configuration public class ShiroConfig {
 * 
 *//**
	 * 创建shiroFilterFactoryBean
	 */
/*
 * @Bean public ShiroFilterFactoryBean getShiroFilterFactoryBean(
 * 
 * @Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
 * ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
 * // 设置安全管理器 shiroFilterFactoryBean.setSecurityManager(securityManager);
 * 
 * // 添加Shiro内置过滤器
 *//**
	 * Shiro内置过滤器，可以实现权限相关的拦截器 常用的过滤器： anon: 无需认证（登录）可以访问 authc: 必须认证才可以访问 user:
	 * 如果使用rememberMe的功能可以直接访问 perms： 该资源必须得到资源权限才可以访问 role: 该资源必须得到角色权限才可以访问
	 */
/*
 * Map<String, String> filterMap = new LinkedHashMap<String, String>();
 * 
 * 
 * filterMap.put("/add","authc"); filterMap.put("/update","authc");
 * //authc会进行拦截(默认进入login.jsp)
 * 
 * 
 * filterMap.put("/zhuce", "anon"); filterMap.put("/login", "anon"); //
 * 放行去login的界面，这样才不会进行拦截
 * 
 * filterMap.put("/*", "anon"); // 授权过滤器 // 注意:当授权拦截后,shiro会自动跳转到未授权页面
 * 
 * filterMap.put("/add","perms[user:add]");
 * filterMap.put("/update","perms[user:update]"); //user:
 * 如果使用rememberMe的功能可以直接访问 filterMap.put("/search","user");
 * filterMap.put("/","authc");
 * 
 * 
 * // 修改调整的登录页面(默认login.jsp) shiroFilterFactoryBean.setLoginUrl("/toLogin");
 * 
 * // 设置调整的登录页面(未授权页面) shiroFilterFactoryBean.setUnauthorizedUrl("/notAuth");
 * 
 * shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap); return
 * shiroFilterFactoryBean; }
 * 
 *//**
	 * 创建DefaultWebSecurityManager(默认需要+rememberMe)
	 */
/*
 * @Bean(name = "securityManager") public DefaultWebSecurityManager
 * getdeDefaultWebSecurityManager(@Qualifier("MyRealm") MyRealm myRealm) {
 * DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
 * // 关联realm securityManager.setRealm(myRealm);
 * 
 * // 注入记住我管理器(shiro 的rememberMe功能加入这句代码)
 * securityManager.setRememberMeManager(rememberManager()); return
 * securityManager; }
 * 
 *//**
	 * 创建Realm
	 **/
/*
 * @Bean(name = "MyRealm") public MyRealm getRealm() { MyRealm userRealm = new
 * MyRealm(); // 配置加密(在加密后,不配置的话会导致登录密码失败)
 * userRealm.setCredentialsMatcher(hashedCredentialsMatcher()); return
 * userRealm; }
 * 
 *//**
	 * 配置ShiroDialect,用于thymeleaf和shiro标签配合使用
	 */
/*
 * @Bean public ShiroDialect getShiroDialect() { return new ShiroDialect(); }
 * 
 *//**
	 * 盐加密
	 */
/*
 * @Bean public HashedCredentialsMatcher hashedCredentialsMatcher() {
 * HashedCredentialsMatcher hashedCredentialsMatcher = new
 * HashedCredentialsMatcher(); // 使用md5,算法进行加密
 * hashedCredentialsMatcher.setHashAlgorithmName("md5"); // 设置加密次数
 * hashedCredentialsMatcher.setHashIterations(1024); return
 * hashedCredentialsMatcher; }
 * 
 *//**
	 * --------rememberMe-------- cookie对象(暂时屏蔽这个功能)
	 * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
	 *//*
		 * 
		 * @Bean public SimpleCookie rememberMeCookie() {
		 * //设置cookie的名称,对应前端的checkbox的name=rememberMe SimpleCookie simpleCookie=new
		 * SimpleCookie("rememberMe"); //设置cookie的实效时间,默认秒 simpleCookie.setMaxAge(120);
		 * return simpleCookie; }
		 * 
		 * cookie管理对象
		 * 
		 * @Bean public CookieRememberMeManager rememberManager() {
		 * CookieRememberMeManager cookieRememberMeManager=new
		 * CookieRememberMeManager();
		 * cookieRememberMeManager.setCookie(rememberMeCookie()); //rememberMe
		 * cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
		 * cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="
		 * )); return cookieRememberMeManager; }
		 * 
		 * 
		 * }
		 */