package com.example.springCloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 自定義配置類,
*/

@Configuration
public class ConfigBean {

    ///@LoadBalanced表示這個RestTemplate開啟負載均衡，在調用服務提供者的接口時，
    // 可使用 服務名稱 替代真實IP地址。服務名稱 就是服務提供者在application.yml中
    // 配置的spring.application.name屬性的值。
    @LoadBalanced
    @Bean // 向容器中添加 RestTemplate 組件,直接通過此組件可調用 REST 接口
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}