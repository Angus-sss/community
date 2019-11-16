package com.insedesign.community.communitybusiness;

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
@MapperScan("com.insedesign.communitybuilding.mapper")
public class CommunityBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityBusinessApplication.class, args);
    }

}
