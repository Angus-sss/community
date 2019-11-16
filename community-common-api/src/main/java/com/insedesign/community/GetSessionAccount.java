package com.insedesign.community;
import javax.servlet.http.HttpServletRequest;


/**
 * @Author: NALHOUG
 * @Time: 2019/11/13 11:59
 * @Explain:
 */
public class GetSessionAccount {
    /**
     * @Explain  从Session获取当前用户
     * @param request
     * @return
     */
    public static Object thisAccount(HttpServletRequest request,String key){
        return (Object)request.getSession().getAttribute(key);
    }
}