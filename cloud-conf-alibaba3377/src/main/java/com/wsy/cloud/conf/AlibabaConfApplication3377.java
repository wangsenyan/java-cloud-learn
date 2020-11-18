package com.wsy.cloud.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * nacos配置:
 * @EnableDiscoveryClient 先从注册中心获取配置文件,然后启动应用
 * config:
 *    namespace:
 *    group:
 * spring:
 *    profiles:
 *        active:
 *
 * nacos集群:
 * - 集群 nginx
 * - 持久化 mysql，默认 derby
 *   - 执行config-nacos.sql
 *   - 配置application.properties
 *   - 重启 startup.sh
 *   - 配置cluster.conf
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class AlibabaConfApplication3377 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConfApplication3377.class,args);
    }
}
