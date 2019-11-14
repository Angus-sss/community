package com.insedesign.communitybuilding.common.resp;


import com.insedesign.communitybuilding.common.enmus.ResultCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain:
 */

public class Resp<T> {
    //私有属性
    private Integer code;
    private String msg;
    private T data;

    public Resp() {
    }

    public Resp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //成功提示
    public static Resp success() {
        Resp result = new Resp();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    //成功并携带数据
    public static Resp success(Object data) {
        Resp result = new Resp();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
    //错误提示
    public static Resp error(ResultCode resultCode) {
        Resp result = new Resp();
        result.setResultCode(resultCode);
        return result;
    }
    //错误并携带数据
    public static Resp error(ResultCode resultCode, Object data) {
        Resp result = new Resp();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
    //set
    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

    //常用参数
    public Map<String, T> simple() {
        Map<String, T> simple = new HashMap<String, T>();
        this.data = (T) simple;

        return simple;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
