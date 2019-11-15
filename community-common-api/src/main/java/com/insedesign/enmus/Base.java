package com.insedesign.enmus;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain: 基本常量值
 */
public class Base {
    /**
     * Session 用户标记
     */
    public static final String ROLE_USER = "user";
    public static final String THIS_USER = "user";

    /**
     * 常用的正则表达式 邮箱 手机
     */
    public static final String EMAIL_REGULAR = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    public static final String PHONE_REGULAR = ("^[1][34578]\\d{9}$");


    /**
     * 账户状态
     */
    public static final Integer ACCOUNT_FORBIDDEN = 0;
    public static final Integer ACCOUNT_OFF = 2;
    public static final Integer ACCOUNT_EXCEPTION = 3;


    /**
     * 数据状态 0为删除 1为存在
     */
    public static final Integer IS_DEL = 0;
    public static final Integer IS_OK = 1;


    /**
     * 用户身份  管理员和普通用户
     */
    public static final String ADMIN_SITE = "ADMIN";
    public static final String USER_CONTENT = "USER";
    /**
     * ID前缀
     */
    public static final String BUILDING = "BUILDING";
    public static final String ROOM = "ROOM";
    public static final String OWNER = "OWNER";
    public static final String LV = "LV";
    public static final String IMG = "IMG";
    public static final String CAR = "CAR";
    public static final String USER = "USER";

    /**
     *车位状态
     */
    public static final String PC_STATE_SELL = "SELL";
    public static final String PC_STATE_RENT = "RENT";
    public static final String PC_STATE_FREE = "FREE";

    /**
     * 业主成员身份
     */
    public static final String FAMILY_OWNER = "1001";
    public static final String FAMILY_MEMBER = "1002";

    /**
     * 业务状态  2001 业主未迁入 2002 业主迁入 2003 业主迁出
     */







}