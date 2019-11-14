package com.insedesign.communityadmin.common.exception;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain: 自定义异常
 */
public class MessageException extends RuntimeException {
    private static final long serialVersionUID = 3506744187536228284L;

    private Integer errCode;
    private String errMsg;

    public MessageException(String errMsg) {
        this.errMsg = errMsg;
    }


    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public MessageException(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

}