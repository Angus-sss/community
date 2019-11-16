package com.insedesign.community.resp;

import com.insedesign.community.enmus.ResultCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain: 统一返回对象
 */
@Data
public class Resp<T> {
    private Integer code;
    private String msg;
    private T data;

    public Resp() {
    }

    public Resp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功
     * @return
     */
    public static Resp success() {
        Resp result = new Resp();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 成功并携带数据
     * @param data
     * @return
     */
    public static Resp success(Object data) {
        Resp result = new Resp();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败 自定义失败信息
     * @param resultCode
     * @return
     */
    public static Resp error(ResultCode resultCode) {
        Resp result = new Resp();
        result.setResultCode(resultCode);
        return result;
    }

    /**
     * 失败 并携带数据
     * @param resultCode
     * @param data
     * @return
     */
    public static Resp error(ResultCode resultCode,Object data) {
        Resp result = new Resp();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

    public Map<String, T> simple() {
        Map<String, T> simple = new HashMap<String, T>();
        this.data = (T) simple;

        return simple;
    }


}
