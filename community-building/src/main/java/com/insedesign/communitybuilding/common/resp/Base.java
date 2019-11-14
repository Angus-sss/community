package com.insedesign.communitybuilding.common.resp;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain:
 */

//常量
public class Base {
    /**
     * Session 用户标记
     */
    //用户
    public static final String ROLE_USER = "user";
    //当前用户
    public static final String THIS_USER = "user";

    /**
     * 常用的正则表达式
     */
    //邮箱正则表达式
    public static final String EMAIL_REGULAR = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    //手机号正则表达式
    public static final String PHONE_REGULAR = ("^[1][34578]\\d{9}$");

    public static final Integer IS_DEL = 0;
    public static final Integer IS_OK = 1;


}
