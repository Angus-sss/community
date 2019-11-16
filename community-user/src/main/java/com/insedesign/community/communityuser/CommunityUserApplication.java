package com.insedesign.community.communityuser;

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
@MapperScan(value = "com.insedesign.communitymain.mapper")
public class CommunityUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityUserApplication.class, args);
    }


}
