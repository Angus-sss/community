package com.insedesign.communityadmin.common.resp;

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


    /**
     * 账户状态
     */
    //账号被禁封
    public static final Integer ACCOUNT_FORBIDDEN = 0;
    //账号自行注销
    public static final Integer ACCOUNT_OFF = 2;
    //账号异常
    public static final Integer ACCOUNT_EXCEPTION = 3;


    /**
     * 用户身份
     */
    //网站管理员
    public static final String ADMIN_SITE = "INGSING02";
    //内容管理员
    public static final String ADMIN_CONTENT = "INGSING03";
    //办公管理员
    public static final String ADMIN_OFFICE = "INGSING04";
    //不是管理员
    public static final String GUEST_ACCOUNT = "GUEST";


    //会员用户
    public static final String USER_VIP = "USER01";
    //普通用户
    public static final String USER_DEFAULT_ = "USER02";


}
