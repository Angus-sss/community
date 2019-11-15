package com.insedesign.resp;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain:
 */
public class Base {
    /**
     * Session 用户标记
     */
    public static final String ROLE_USER = "user";

    /**
     * 邮箱正则
     */
    public static final String EMAIL_REGULAR = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 手机正则
     */
    public static final String PHONE_REGULAR = ("^[1][34578]\\d{9}$");


    /**
     * 用户状态 0 为禁封 2为销户 3为异常
     */
    public static final Integer ACCOUNT_FORBIDDEN = 0;
    public static final Integer ACCOUNT_OFF = 2;
    public static final Integer ACCOUNT_EXCEPTION = 3;

    /**
     *
     */

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
