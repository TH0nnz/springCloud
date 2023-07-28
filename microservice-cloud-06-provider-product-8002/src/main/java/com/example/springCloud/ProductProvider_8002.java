package com.example.springCloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.example.springCloud.mapper") //掃描所有Mapper接口
@SpringBootApplication
@EnableEurekaClient //本服務啟動後會自動註冊進Eureka中心
public class ProductProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_8002.class, args);
    } }
