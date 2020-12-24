package com.wsy.cloud.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 需要的效果
 * 1. 动态返回地址
 * 2. 多端使用
 * 如何高效的查看jar
 * **********SpringSecurity原理*************
 * 1. 过滤器链
 *   -
 */
@SpringBootApplication
public class OAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class,args);
    }
}
