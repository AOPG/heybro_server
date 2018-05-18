package com.heybro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 静态页面配置
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 登录
        registry.addViewController("/login").setViewName("login");
        //网站管理
        registry.addViewController("/system").setViewName("system/backendUser/index");
        registry.addViewController("/editUser").setViewName("system/backendUser/edit");
        registry.addViewController("/addUser").setViewName("system/backendUser/add");
        //角色管理
        registry.addViewController("/role").setViewName("system/role/index");
        registry.addViewController("/editRole").setViewName("system/role/edit");
        registry.addViewController("/addRole").setViewName("system/role/add");
        //授权管理
        registry.addViewController("/authorization").setViewName("system/authorization/index");
        registry.addViewController("/index").setViewName("index");

    }

}
