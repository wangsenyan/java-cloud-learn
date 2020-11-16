package com.wsy.cloud.prov.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.wsy.cloud.mbg.mapper"})
public class MybatisConfig {
}
