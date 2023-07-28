package com.example.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClient {
    //會從github中的microservice-config-application.yml中獲取
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String port;

    //請求訪問
    @RequestMapping("/config")
    public String getConfig() {
        String content = "applicationName:" + applicationName + ", port:" + port;
        System.out.println("content: " + content);
        return content;
    }
}
