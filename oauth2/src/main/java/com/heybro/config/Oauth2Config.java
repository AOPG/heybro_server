package com.heybro.config;

import com.heybro.service.impl.MyClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Created by on 16/3/7.
 */
@Configuration
public class Oauth2Config {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Bean
    public RedisTokenStore tokenStore(RedisConnectionFactory connectionFactory) {
        return new RedisTokenStore(connectionFactory);
    }

    @EnableResourceServer
    protected static class ResourcesServer extends ResourceServerConfigurerAdapter {

        @Autowired
        private RedisTokenStore tokenStore;

        @Autowired
        private Environment environment;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.tokenStore(tokenStore);
            resources.resourceId(environment.getProperty("security.oauth2.resource.id"));
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.cors().disable()
                    .authorizeRequests()
                    // 不拦截获取token的请求
                    .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
                    // 不拦截网页请求
//                    .antMatchers(HttpMethod.GET, "/**/*.html").permitAll()
                    // 不拦截注册
//                    .antMatchers(HttpMethod.POST, "/api/register").permitAll()
                    // 不拦截登录
//                    .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                    // 不拦截获取授权令牌
                    .antMatchers(environment.getProperty("security.oauth2.authorization.un-hook-list").split(",")).permitAll()
                    // 其他请求都需要经过授权
                    .anyRequest().access("#oauth2.hasAnyScope('read', 'write')");
        }
    }

    @EnableAuthorizationServer
    protected static class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
        @Autowired
        private RedisTokenStore tokenStore;

        @Autowired
        private MyClientDetailsService clientDetailsService;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.withClientDetails(clientDetailsService);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.tokenStore(tokenStore);
        }

    }
}
