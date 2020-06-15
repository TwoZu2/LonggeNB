package com.sjiag.Shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
//    @Bean
//    public CookieRememberMeManager cookieRememberMeManager() {
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        simpleCookie.setMaxAge(259200000);
//        cookieRememberMeManager.setCookie(simpleCookie);
//        cookieRememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
//        return cookieRememberMeManager;
//    }

    //设置自定义Shiro Session
    @Bean
    public DefaultWebSessionManager getDefaultWebSessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(5*60*1000);
        return sessionManager;
    }
    //支持缓存
    @Bean
    public EhCacheManager getEhCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return ehCacheManager;

    }

    //支持 Shiro 注解
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //设置加密方式
        matcher.setHashAlgorithmName("md5");
        //设置hash次数
        matcher.setHashIterations(1);
        return matcher;
    }

    @Bean
    public MyRealm getMyRealm(HashedCredentialsMatcher matcher){
//       JdbcRealm jdbcRealm = new JdbcRealm();
//       //JdbcRealm 会自行从数据源里查询用户以及权限数据 (表结构必须符合规范)
//      jdbcRealm.setDataSource(dataSource);
//
//      //JdbcRealm 默认开启认证功能 需要手动开启授权功能
//        jdbcRealm.setPermissionsLookupEnabled(true);
        MyRealm myRealm = new MyRealm();
        //设置加密
        myRealm.setCredentialsMatcher(matcher);
        return myRealm;
    }
    @Bean
    public CookieRememberMeManager getCookieRememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setMaxAge(30*24*60*60);
        cookieRememberMeManager.setCookie(cookie);
        return cookieRememberMeManager;
    }
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyRealm myRealm,EhCacheManager ehCacheManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        //设置缓存
        securityManager.setCacheManager(ehCacheManager);
        //设置记住我
        securityManager.setRememberMeManager(getCookieRememberMeManager());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //过滤器就是Shiro进行权限校验的核心,进行认证和授权是需要securityManager的
        factoryBean.setSecurityManager(securityManager);

        //设置Shiro的拦截规则
        /*
        * anon 匿名用户可以访问
        * authc 认证用户可以访问
        * user  使用RemberMe用户可以访问
        * perms 对应权限用户可以访问
        * role  对应角色可以访问
        * */
        Map<String,String> filterMap = new HashMap<>();
            filterMap.put("/","anon");
            filterMap.put("/login.html","anon");
            filterMap.put("/regist.html","anon");
            filterMap.put("/user/login","anon");
            filterMap.put("/user/regist","anon");
            filterMap.put("/layui/**","anon");


        filterMap.put("/webSocket/**","anon");
        filterMap.put("/index.html","user");
        filterMap.put("/**","authc");
                filterMap.put("/logout","logout");
         factoryBean.setFilterChainDefinitionMap(filterMap);
         factoryBean.setLoginUrl("/");
         //设置未授权访问的路径
         factoryBean.setUnauthorizedUrl("/");
        return factoryBean;
    }

}
