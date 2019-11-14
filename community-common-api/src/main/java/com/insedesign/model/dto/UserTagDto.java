package com.insedesign.model.dto;


import lombok.Data;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/13 14:12
 * @Explain:
 */
@Data
public class UserTagDto {
    /**
     * 打标ID
     */
    private Integer tagId;

    /**
     * 业务Id
     */
    private String bId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 标签编码,参考tag表
     */
    private String tagCd;

    /**
     * 备注
     */
    private String remark;



}
