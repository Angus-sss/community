package com.insedesign.communityuserapi.common.exception;

import com.insedesign.communityuserapi.common.enmus.ResultCode;
import com.insedesign.communityuserapi.common.resp.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain: 全局异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 自定义异常
     * @param e
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MessageException.class)
    public Resp handleLoginException(MessageException e, HttpServletRequest request) {
        Resp resp = new Resp();
        log.info("自定义异常");
        resp.setCode(e.getErrCode());
        resp.setMsg(e.getErrMsg());
        return resp;
    }

    /**
     * 数据操作格式异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    public Resp requestExceptionHandler(DataIntegrityViolationException e){
        log.error("数据操作格式异常:",e);
        return Resp.error(ResultCode.PARAM_TYPE_ERROR);
    }

    /**
     * 空指针异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public Resp exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("空指针异常:",e);
        return Resp.error(ResultCode.PARAM_IS_NULL);
    }
    /**
     * 其他异常
     * @param e
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Resp handleException(Exception e, HttpServletRequest request) {
        log.error("系统错误:",e);
        return Resp.error(ResultCode.SYSTEM_INNER_ERROR);
    }


}
