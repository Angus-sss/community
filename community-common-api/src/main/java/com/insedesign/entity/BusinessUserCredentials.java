package com.insedesign.entity;

import java.util.Date;
import lombok.Data;

@Data
public class BusinessUserCredentials {
    /**
    * 证件ID
    */
    private Integer credentialsId;

    /**
    * 业务Id
    */
    private String bId;

    /**
    * 用户ID
    */
    private String userId;

    /**
    * 证件类型
    */
    private String credentialsCd;

    /**
    * 证件号码
    */
    private String value;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 数据状态，添加ADD，修改MOD 删除DEL
    */
    private String operate;
}