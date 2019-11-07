package com.insedesign.communitybuildingapi;

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
@MapperScan("com.insedesign.communitybuildingapi.mapper")
public class CommunityBuildingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityBuildingApiApplication.class, args);
    }

}
