package com.insedesign.community.enmus;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain:
 */
public enum ResultCode {
    //成功
    SUCCESS(10000, "成功"),
    ERROR(20000, "失败"),
    SESSION_TIME_OUT(20001, "Session超时"),

    //验证码
    VERIFICATION_CODE_ERROR(20002, "验证码错误"),

    //登录成功
    LOGIN_SUCCESS(30000,"登录成功"),
    LOGOUT_SUCCESS(30001,"用户退出登录"),
    LOGIN_PASSWORD_ERROR(30002, "用户密码错误"),
    ACCOUNT_NOT_EXIST(30003, "用户不存在"),
    ACCOUNT_IS_LOGIN(30004, "请先退出当前用户"),

    //注册
    ACCOUNT_REGISTER_ERROR(40001, "用户注册错误"),
    ACCOUNT_REGISTER_SUCCESS(40000, "注册成功"),
    ACCOUNT_HAS_USERNAME(40002, "账号已被注册"),
    ACCOUNT_HAS_EMAIL(40003, "邮箱已被注册"),
    ACCOUNT_HAS_PHONE(40004, "号码已被注册"),


    //用户状态
    HAS_EXISTED(50000, "用户已存在"),
    NOT_LOGGED_IN(50001, "用户未登录"),
    ACCOUNT_OFF(50002, "账号已自行注销"),
    ACCOUNT_FORBIDDEN(50003, "账号已被禁用"),
    ACCOUNT_EXCEPTION(50004, "账号状态异常"),

    //错误
    SYSTEM_INNER_ERROR(60000, "系统繁忙，请稍后重试"),
    PARAM_IS_NULL(60001, "参数为空"),
    PARAM_TYPE_ERROR(60002, "参数类型错误"),
    PARAM_NOT_COMPLETE(60003, "参数缺失"),
    CODE_IS_ERROR(60004, "验证码错误"),
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(60005, "业务出现问题"),
    PARAM_IS_INVALID(60006, "参数无效"),
    PARAM_IS_RE(60007, "参数中有已存在的对象"),



    //等待
    SUBMIT_AUDIT(70000, "已提交审核"),
    WAIT_FOR_REVIEW(70001, "正在审核"),

    //系统错误

    //数据错误
    DATA_IS_NONE(62000, "数据未找到"),
    DATA_IS_WRONG(62001, "数据有误"),
    DATA_IS_HAS(620002, "数据已存在"),

    //数据条数限制
    DATA_MAX_CEILING(80200, "数量已经达上限"),

    //权限错误
    PERMISSION_NO_ACCESS(65000, "无访问权限"),
    ILLEGAL_OPERATION(66000,"警告！非法操作"),

    //文件上传
    UPLOAD_ERROR(66000, "上传失败");



    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
