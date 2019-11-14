package com.insedesign.communityuserapi.configuration;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/14 17:48
 * @Explain:
 */
@Configuration
public class SentinelAspectConfiguration {
        @Bean
        public SentinelResourceAspect sentinelResourceAspect() {
            return new SentinelResourceAspect();
        }
}
