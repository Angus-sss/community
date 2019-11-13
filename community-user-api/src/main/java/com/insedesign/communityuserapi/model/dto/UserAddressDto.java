package com.insedesign.communityuserapi.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/13 14:33
 * @Explain:
 */
@Data
public class UserAddressDto {

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 用户ID
     */
    private String userId;

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

    /**
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    private String operate;
}
