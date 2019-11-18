package com.insedesign.community.communityuser.service;

import com.insedesign.community.communityuser.service.fallback.GetMainServiceFallbackImpl;
import com.insedesign.community.model.dto.UserRegisterDto;
import com.insedesign.community.resp.Resp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/18 19:43
 * @Explain: 调用入口接口
 */
@FeignClient(value = "community-main",fallback = GetMainServiceFallbackImpl.class)
public interface GetMainService {
    /**
     * 后台添加用户
     * @param userRegisterDto
     * @return
     */
    @PostMapping("/register")
    Resp register(UserRegisterDto userRegisterDto);

}
