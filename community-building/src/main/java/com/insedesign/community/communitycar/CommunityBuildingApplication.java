package com.insedesign.community.communitycar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author NALHOUG
 */

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
public class CommunityBuildingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityBuildingApplication.class, args);
    }

}
