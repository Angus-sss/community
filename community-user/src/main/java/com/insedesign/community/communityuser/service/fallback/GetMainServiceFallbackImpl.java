package com.insedesign.community.communityuser.service.fallback;

import com.insedesign.community.communityuser.service.GetMainService;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.dto.UserRegisterDto;
import com.insedesign.community.resp.Resp;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/18 19:46
 * @Explain: 熔断返回
 */

public class GetMainServiceFallbackImpl implements GetMainService {
    @Override
    public Resp register(UserRegisterDto userRegisterDto) {
        return Resp.error(ResultCode.SYSTEM_INNER_ERROR);
    }
}
