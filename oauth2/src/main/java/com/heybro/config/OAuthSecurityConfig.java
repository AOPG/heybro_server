package com.heybro.config;

import com.heybro.custom.CustomUserDetailsService;
import com.heybro.entity.AverageUser;
import com.heybro.mapper.AverageUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import tk.mybatis.mapper.entity.Example;

import javax.sql.DataSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by simon on 2017/2/18.
 */
@Configuration
@EnableAuthorizationServer
public class OAuthSecurityConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean // 声明TokenStore实现
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Bean // 声明 ClientDetails实现
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private ClientDetailsService clientDetails;

    @Autowired
    private AverageUserMapper averageUserMapper;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore());
        endpoints.userDetailsService(userService);
        endpoints.setClientDetailsService(clientDetails);
        endpoints.tokenEnhancer(new MyTokenEnhancer());
        //配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); // 1天
        endpoints.tokenServices(tokenServices);
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore);

        return tokenServices;
    }

    class MyTokenEnhancer implements TokenEnhancer{

        @Override
        public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
            if (oAuth2AccessToken instanceof DefaultOAuth2AccessToken){
                DefaultOAuth2AccessToken token= (DefaultOAuth2AccessToken) oAuth2AccessToken;
                String accessTokenString = token.getValue();

                AverageUser averageUser = new AverageUser();
                averageUser.setUserName(oAuth2Authentication.getName());
                averageUser.setAccessToken(accessTokenString);
                Example averageUserExample = new Example(AverageUser.class);
                Example.Criteria criteria = averageUserExample.createCriteria();
                criteria.andEqualTo("userName",oAuth2Authentication.getName());
                averageUserMapper.updateByExampleSelective(averageUser,averageUserExample);

                Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();
                additionalInformation.put("username",oAuth2Authentication.getName());
                token.setAdditionalInformation(additionalInformation);
                return token;
            }
            return oAuth2AccessToken;
        }
    }

}
