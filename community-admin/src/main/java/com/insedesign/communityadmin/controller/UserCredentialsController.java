package com.insedesign.communityadmin.controller;

import com.insedesign.communityadmin.common.enmus.ResultCode;
import com.insedesign.communityadmin.common.resp.Resp;
import com.insedesign.communityadmin.common.utils.GetSessionAccount;
import com.insedesign.communityadmin.model.entity.BusinessUserCredentials;
import com.insedesign.communityadmin.service.BusinessUserCredentialsService;
import com.insedesign.model.dto.UserCredentialsDto;
import com.insedesign.model.vo.UserCredentialsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/13 11:56
 * @Explain:
 */
@RestController
@RequestMapping(value = "cred")
public class UserCredentialsController {
    @Resource
    private BusinessUserCredentialsService userCredentialsService;
    @Resource
    private GetSessionAccount getSessionAccount;
    /**
     * @Explain 查询用户证件
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public Resp selectUserCredentials(HttpServletRequest request){
        BusinessUserCredentials userCredentials = userCredentialsService.selectByUserId(getSessionAccount.thisAccount(request).getUserId());
        return Resp.success(userCredentials);
    }
    /**
     * @Explain 修改证件资料
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Resp updateUserCredentials(UserCredentialsDto userCredentialsDto, HttpServletRequest request){
        BusinessUserCredentials userCredentials = userCredentialsService.update(userCredentialsDto);
        if (null==userCredentials){
            return Resp.error(ResultCode.ERROR);
        }
        UserCredentialsVo userCredentialsVo = new UserCredentialsVo();
        BeanUtils.copyProperties(userCredentials,userCredentialsVo);
        return Resp.success(userCredentialsVo);
    }
    /**
     * @Explain 添加证件
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Resp addUserCredentials(UserCredentialsDto userCredentialsDto,HttpServletRequest request){
        userCredentialsDto.setUserId(getSessionAccount.thisAccount(request).getUserId());
        BusinessUserCredentials userCredentials = userCredentialsService.insert(userCredentialsDto);
        if (null==userCredentials){
            return Resp.error(ResultCode.ERROR);
        }
        UserCredentialsVo userCredentialsVo = new UserCredentialsVo();
        BeanUtils.copyProperties(userCredentials,userCredentialsVo);
        return Resp.success(userCredentialsVo);
    }

    /**
     * @Explain 删除证件
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Resp delUserCredentials(HttpServletRequest request){
        Resp resp = new Resp();
        if (0<userCredentialsService.del(getSessionAccount.thisAccount(request).getUserId())){
            resp.setResultCode(ResultCode.SUCCESS);
            return resp;
        }
        resp.setResultCode(ResultCode.ERROR);
        return resp;
    }




}
