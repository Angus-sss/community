package com.insedesign.communityuserapi.common.exception;

import com.insedesign.communityuserapi.common.enmus.ResultCode;
import com.insedesign.communityuserapi.common.resp.Resp;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain:
 */
@Component
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Resp handleException(Exception e, HttpServletRequest request) {
        Resp resp = new Resp();
        resp.setCode(ResultCode.SYSTEM_INNER_ERROR.code());
        resp.setMsg(e.getMessage());
        return resp;
    }
    @ExceptionHandler(MessageException.class)
    public Resp handleLoginException(MessageException e, HttpServletRequest request) {
        Resp resp = new Resp();
        Resp.error(ResultCode.PARAM_IS_INVALID);
        resp.setMsg(e.getMessage());
        return resp;
    }

}
