package com.insedesign.communityuserapi.common.exception;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain:
 */
public class MessageException extends RuntimeException {
    private static final long serialVersionUID = 3506744187536228284L;

    private String errCode;
    private String errMsg;

    public MessageException(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public MessageException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

}