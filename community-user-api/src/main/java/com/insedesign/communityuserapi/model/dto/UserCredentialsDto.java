package com.insedesign.communityuserapi.model.dto;

import lombok.Data;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/13 14:32
 * @Explain:
 */
@Data
public class UserCredentialsDto {
    /**
     * 证件ID主键
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


}
