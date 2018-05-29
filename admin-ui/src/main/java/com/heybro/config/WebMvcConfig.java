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
        //篮球信息管理-竞猜管理
        registry.addViewController("/guess").setViewName("baseManege/basketInfo/index");
        //篮球信息管理-篮球资讯管理
        registry.addViewController("/basketInfo").setViewName("baseManege/basketInfo/index");
        //篮球信息管理-篮球赛事管理
        registry.addViewController("/competition").setViewName("baseManege/guess/index");
        //篮球信息管理-篮球视频管理
        registry.addViewController("/video").setViewName("baseManege/video/index");
        //商家管理-商家信息管理
        registry.addViewController("/business").setViewName("businessManage/business/index");
        //商家管理-商品管理
        registry.addViewController("/goods").setViewName("businessManage/goods/index");
        //商品管理-购物车管理
        registry.addViewController("/car").setViewName("businessManage/car/index");
        //商品管理-订单管理
        registry.addViewController("/order").setViewName("businessManage/order/index");
        //用户管理-普通用户管理
        registry.addViewController("/averageUser").setViewName("userManage/averageUser/index");
        //用户管理-消息管理
        registry.addViewController("/massage").setViewName("userManage/massage/index");
        //用户管理-动态管理
        registry.addViewController("/comment").setViewName("userManage/comment/index");
        //用户管理-历史记录管理
        registry.addViewController("/history").setViewName("userManage/history/index");
        //用户管理-房间管理
        registry.addViewController("/room").setViewName("userManage/room/index");
        //合作方管理-场地合作方管理
        registry.addViewController("/cooperate").setViewName("cooperateManage/cooperate/index");
        //合作方管理-场地管理
        registry.addViewController("/space").setViewName("cooperateManage/space/index");
    }

}
