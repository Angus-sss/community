package com.insedesign.communityuser.common.interceptor;


import com.alibaba.fastjson.JSON;
import com.insedesign.communityuser.common.enmus.ResultCode;
import com.insedesign.communityuser.common.resp.Base;
import com.insedesign.communityuser.common.resp.Resp;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain: 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response
            , Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession();
        System.out.println("SessionId:"+session.getId());
        System.out.println(session.getAttribute(Base.ROLE_USER));
        if (null == session) {
            //未登录
            //用户响应？
            writerLoginErrorResp(response);
            return false;
        }
        //判断session是否有用户信息
        Object userObj = session.getAttribute(Base.ROLE_USER);
        if (null == userObj) {
            //未登录
            //用户响应？
            writerLoginErrorResp(response);
            return false;
        }
        return true;

    }

    private void writerLoginErrorResp(HttpServletResponse response) {
        //用户未登录
        Resp resp = new Resp();
        resp.setResultCode(ResultCode.NOT_LOGGED_IN);
        String respStr = JSON.toJSONString(resp);

        //输出错误信息到response对象
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().print(respStr);
        } catch (IOException e) {
            resp.setResultCode(ResultCode.SYSTEM_INNER_ERROR);
        }
    }



}