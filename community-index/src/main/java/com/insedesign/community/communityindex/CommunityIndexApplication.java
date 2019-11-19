package com.insedesign.community.communityindex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
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
@EnableCaching
@MapperScan(value = "com.insedesign.community.mapper")
@ComponentScan(basePackages = {
        "com.insedesign.community.service",
        "com.insedesign.community.utils",
        "com.insedesign.community.communityindex.controller",
})
public class CommunityIndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityIndexApplication.class, args);
    }

}
