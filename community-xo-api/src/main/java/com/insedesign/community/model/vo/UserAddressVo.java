package com.insedesign.community.model.vo;

import java.util.Date;

/**
 * @author NALHOUG
 */
public class UserAddressVo {

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String tel;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 地址
     */
    private String address;

    /**
     * 是否为默认地址 1，表示默认地址 0 或空不是默认地址
     */
    private String isDefault;

    /**
     * 创建时间
     */
    private Date createTime;

}
