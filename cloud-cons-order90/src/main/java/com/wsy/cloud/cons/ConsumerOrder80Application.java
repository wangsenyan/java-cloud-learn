package com.wsy.cloud.cons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 让应用没有数据库连接也可以启动 @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ConsumerOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80Application.class,args);
    }
}
