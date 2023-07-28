package com.example.springCloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * 刷新數據源
 */
//一定不要在此類加@RefreshScope，不然報錯
@Configuration //不要少了
public class DruidConfig {
    @RefreshScope //刷新數據源
    @ConfigurationProperties(prefix = "spring.datasource") //綁定數據源配置
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }
}