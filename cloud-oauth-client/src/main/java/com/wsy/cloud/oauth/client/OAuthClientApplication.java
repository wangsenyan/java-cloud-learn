package com.wsy.cloud.oauth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@EnableOAuth2Sso //启用单点登录功能
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OAuthClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuthClientApplication.class,args);
    }
}
