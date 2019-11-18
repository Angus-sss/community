package com.insedesign.community.enmus;

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
     * Session 用户身份
     */
    public static final String IS_USER = "USER";
    public static final String IS_ADMIN = "ADMIN";

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
     * 数据状态 通用的 0 和 1
     */
    public static final Integer STATE0 = 0;
    public static final Integer STATE1 = 1;

    /**
     * ID前缀
     */
    public static final String BUILDING = "BUILDING";
    public static final String ROOM = "ROOM";
    public static final String OWNER = "OWNER";
    public static final String IMG = "IMG";
    public static final String CAR = "CAR";
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";
    public static final String U_ADDRESS = "UAS";
    public static final String U_ATTR = "UAR";
    public static final String U_TAG = "UTG";
    public static final String U_CRED = "CRED";
    public static final String U_LEVEL = "ULV";


    /**
     * 最大数据条数
     */
    public static final Integer DATA_NUM_MAX_1 = 1;
    public static final Integer DATA_NUM_MAX_2 = 2;
    public static final Integer DATA_NUM_MAX_5 = 5;
    public static final Integer DATA_NUM_MAX_10= 10;
    public static final Integer DATA_NUM_MAX_20= 20;
    public static final Integer DATA_NUM_MAX_50= 50;
    public static final Integer DATA_NUM_1MAX_100= 100;

    /**
     * 用户地址状态
     */
    public static final Integer ADDRESS_IS_DEFAULT = 1;
    public static final Integer ADDRESS_NOT_DEFAULT = 0;

}
