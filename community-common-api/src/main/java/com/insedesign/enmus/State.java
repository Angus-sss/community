package com.insedesign.enmus;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 22:19
 * @Explain: 通用状态值
 */
public enum State{
    /**
     * 通用状态值
     */
    FAMILY_OWNER("业主本人", "1001"),
    FAMILY_MEMBER("家庭成员", "1002"),

    /**
     * 车位状态
     */
    PC_STATE_SELL("出售", "SELL"),
    PC_STATE_RENT("出租", "RENT"),
    PC_STATE_FREE("空闲", "FREE"),

    /**
     * 业务状态
     */
    BUSINESS_STATE_NOT_IN("业主未迁入", "2001"),
    BUSINESS_STATE_IS_IN("业主迁入", "2002"),
    BUSINESS_STATE_IS_OUT("业主迁出", "2003"),

    /**
     * 账号状态
     */
    ACCOUNT_DEL("删除账户", "0"),
    ACCOUNT_OFF("自行注销", "2"),
    ACCOUNT_EXCEPTION("账号异常", "3"),

    /**
     * 数据状态
     */
    DATE_STATE_IS_ADD("添加", "ADD"),
    DATE_STATE_IS_MOD("修改", "MOD"),
    DATE_STATE_IS_DEL("删除", "DEL"),

    /**
     * 车辆类型
     */
    CAR_TYPE_IS_SEDAN("小汽车", "9901"),
    CAR_TYPE_IS_COACH("客车", "9902"),
    CAR_TYPE_IS_TRUCKS("货车", "9903"),


    /**
     * 车位类型
     */
    SPACE_TYPE_UP("地上停车位", "1001"),
    BLOG_AUTHOR_DOWN("地下停车位", "2001"),
    BLOG_AUTHOR_OTHER("其他停车位", "2001");



    private String content;
    private String state;

    State(String content, String state) {
        this.content = content;
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
