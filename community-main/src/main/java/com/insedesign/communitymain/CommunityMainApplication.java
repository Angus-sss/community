package com.insedesign.communitymain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author NALHOUG
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(value = "com.insedesign.community.mapper")
@ComponentScan(basePackages = {
        "com.insedesign.community.service",
        "com.insedesign.community.utils",
        })
public class CommunityMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityMainApplication.class, args);
    }


}
