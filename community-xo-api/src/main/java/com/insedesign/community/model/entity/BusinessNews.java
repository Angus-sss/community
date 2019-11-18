package com.insedesign.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "business_news")
public class BusinessNews implements Serializable {
    /**
     * 新闻id
     */
    @TableField(value = "new_id")
    private String newId;

    /**
     * 新闻标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 标题图片
     */
    @TableField(value = "head_img")
    private String headImg;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 状态值
     */
    @TableField(value = "state")
    private Integer state;

    /**
     * 审核状态
     */
    @TableField(value = "audit")
    private String audit;

    private static final long serialVersionUID = 1L;

    public static final String COL_NEW_ID = "new_id";

    public static final String COL_TITLE = "title";

    public static final String COL_HEAD_IMG = "head_img";

    public static final String COL_CONTENT = "content";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_STATE = "state";

    public static final String COL_AUDIT = "audit";
}