package com.insedesign.communityuserapi.model.vo;


import lombok.Data;

import java.util.Date;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:56
 * @Explain:
 */
@Data
public class UserVo {
    /**
     * 业务Id
     */
    private String bId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 名称
     */
    private String name;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 现居住地址
     */
    private String address;

    /**
     * 用户地区
     */
    private String locationCd;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 性别，0表示男孩 1表示女孩
     */
    private String sex;

    private String tel;

    /**
     * 用户级别,关联user_level
     */
    private String levelCd;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 数据状态，添加ADD，修改MOD 删除DEL
     */
    private Integer operate;
}
