package com.wsy.cloud.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()//所有请求
                .authenticated()//表示已登录用户才能访问
                .and()
                .requestMatchers()
                .antMatchers("/user/**");//配置需要保护的资源路径
                //.accessDecisionManager(accessDecisionManager());//表示绑定在url上的鉴权管理器
    }
}