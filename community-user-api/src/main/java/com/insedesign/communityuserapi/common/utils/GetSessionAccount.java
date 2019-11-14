package com.insedesign.communityuserapi.common.utils;

import com.insedesign.communityuserapi.common.resp.Base;
import com.insedesign.communityuserapi.model.entity.BusinessUser;
import com.insedesign.communityuserapi.model.vo.UserVo;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/13 11:59
 * @Explain:
 */
@Component
public class GetSessionAccount {
    /**
     * @Explain  从Session获取当前用户
     * @param request
     * @return
     */
    public BusinessUser thisAccount(HttpServletRequest request){
        BusinessUser user = (BusinessUser)request.getSession().getAttribute(Base.THIS_USER);
        return user;
    }
}
