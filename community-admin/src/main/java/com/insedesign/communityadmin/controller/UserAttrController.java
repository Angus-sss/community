package com.insedesign.communityadmin.controller;

import com.insedesign.communityadmin.common.enmus.ResultCode;
import com.insedesign.communityadmin.common.resp.Resp;
import com.insedesign.communityadmin.common.utils.GetSessionAccount;
import com.insedesign.communityuserapi.model.dto.UserAttrDto;
import com.insedesign.communityadmin.model.entity.BusinessUserAttr;
import com.insedesign.communityuserapi.model.vo.UserAttrVo;
import com.insedesign.communityadmin.service.BusinessUserAttrService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/13 11:57
 * @Explain:
 */
@RestController
@RequestMapping(value = "/attr")
public class UserAttrController {
    @Resource
    private BusinessUserAttrService userAttrService;
    @Resource
    private GetSessionAccount getSessionAccount;

    /**
     * @Explain 查询用户属性
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public Resp checkUserAttr(HttpServletRequest request){
        BusinessUserAttr userAttr = userAttrService.selectByUserId(getSessionAccount.thisAccount(request).getUserId());
        return Resp.success(userAttr);
    }

    /**
     * @Explain 修改
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Resp updateUserAttr(UserAttrDto userAttrDto, HttpServletRequest request){
        BusinessUserAttr userAttr = userAttrService.update(userAttrDto);
        if (null==userAttr){
            return Resp.error(ResultCode.ERROR);
        }
        UserAttrVo userAttrVo = new UserAttrVo();
        BeanUtils.copyProperties(userAttr,userAttrVo);
        return Resp.success(userAttrVo);
    }
    /**
     * @Explain 添加
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Resp addUserAttr(UserAttrDto userAttrDto, HttpServletRequest request){
        userAttrDto.setUserId(getSessionAccount.thisAccount(request).getUserId());
        BusinessUserAttr userAttr = userAttrService.insert(userAttrDto);
        if (null==userAttr){
            return Resp.error(ResultCode.ERROR,userAttrDto);
        }
        UserAttrVo userAttrVo = new UserAttrVo();
        BeanUtils.copyProperties(userAttr,userAttrVo);
        return Resp.success(userAttrVo);

    }

    /**
     * @Explain 删除
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Resp delUserAttr(HttpServletRequest request){
        Resp resp = new Resp();
        if (0<userAttrService.del(getSessionAccount.thisAccount(request).getUserId())){
            resp.setResultCode(ResultCode.SUCCESS);
            return resp;
        }
        resp.setResultCode(ResultCode.ERROR);
        return resp;
    }

}
