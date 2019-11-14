package com.insedesign.entity;

import java.util.Date;
import lombok.Data;

@Data
public class BusinessUserTag {
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

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 数据状态，添加ADD，修改MOD 删除DEL
    */
    private String operate;
}