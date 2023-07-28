package com.example.springCloud;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@MapperScan("com.example.springCloud.mapper") //掃描所有Mapper接口
@EnableHystrix //開啟 Hystrix 熔斷機制的支持
@EnableEurekaClient //本服務啟動後會自動註冊進Eureka服務中
@SpringBootApplication
public class ProductProvider_8001_Hystrix {

    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_8001_Hystrix.class, args);
    }

    // 如果yml有配置management.endpoints.web.exposure.include: hystrix.stream 下面就不用
//    /***
//     * 此配置是為了服形監控而配置，與服務終鐠本身無關
//     * ServletRegistrationBean因為spningbeat的镇設路盛不是"/hystrix.stream™
//     * *只要在白己的項日裡配置士不面的servlet就可以丁
//     * @return
//     */
//    @Bean//被監控服務上添加暴露端點
//    public ServletRegistrationBean getServlet(){
//        HystrixMetricsStreamServlet hystrix=new HystrixMetricsStreamServlet();
//        ServletRegistrationBean bean=new ServletRegistrationBean(hystrix);
//        bean.setLoadOnStartup(1);
//        bean.addUrlMappings("/hystrix.stream");
//        bean.setName("HystrixMetricsStreamServlet");
//        return bean;
//    }

}
