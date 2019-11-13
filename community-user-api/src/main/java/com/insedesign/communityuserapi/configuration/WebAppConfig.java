package com.insedesign.communityuserapi.configuration;

import com.insedesign.communityuserapi.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;


/**
 * @author: NALHOUG
 * @time: 2019/11/1 15:09
 * @explain: 拦截器
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    @Resource
    private LoginInterceptor loginInterceptor;

    /**
     * 登录拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                //addPathPatterns 用于添加拦截规则
                .addPathPatterns("/**")
                //excludePathPatterns 用于排除拦截
                //注意content-path：ding是不用填写的
                //项目启动测试接口
                .excludePathPatterns("/")
                //用户登录
                .excludePathPatterns("/login")
                //用户注册
                .excludePathPatterns("/register/**");
        super.addInterceptors(registry);
    }

}


