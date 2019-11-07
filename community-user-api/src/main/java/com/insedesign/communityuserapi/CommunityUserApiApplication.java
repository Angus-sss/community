package com.insedesign.communityuserapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author NALHOUG
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.insedesign.communityuserapi.mapper")
public class CommunityUserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityUserApiApplication.class, args);
    }

}
