package com.insedesign.communityadmin.controller;

import com.insedesign.communityadmin.common.enmus.ResultCode;
import com.insedesign.communityadmin.common.resp.Resp;
import com.insedesign.communityadmin.common.utils.GetSessionAccount;
import com.insedesign.communityuserapi.model.dto.UserTagDto;
import com.insedesign.communityadmin.model.entity.BusinessUserTag;
import com.insedesign.communityuserapi.model.vo.UserTagVo;
import com.insedesign.communityadmin.service.BusinessUserTagService;
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
@RequestMapping(value = "/tag")
public class UserTagController {
    @Resource
    private BusinessUserTagService userTagService;
    @Resource
    private GetSessionAccount getSessionAccount;
    /**
     * @Explain 查询用户标签
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public Resp checkUserTag(HttpServletRequest request){
        BusinessUserTag userTag = userTagService.selectByUserId(getSessionAccount.thisAccount(request).getUserId());
        return Resp.success(userTag);
    }

    /**
     * @Explain 修改
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Resp updateUserTag(UserTagDto userTagDto, HttpServletRequest request){
        BusinessUserTag userTag = userTagService.update(userTagDto);
        if (null==userTag){
            return Resp.error(ResultCode.ERROR);
        }
        UserTagVo userTagVo = new UserTagVo();
        BeanUtils.copyProperties(userTag,userTagVo);
        return Resp.success(userTagVo);
    }
    /**
     * @Explain 添加
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Resp addUserTag(UserTagDto userTagDto, HttpServletRequest request){
        userTagDto.setUserId(getSessionAccount.thisAccount(request).getUserId());
        BusinessUserTag userTag = userTagService.insert(userTagDto);
        if (null==userTag){
            return Resp.error(ResultCode.ERROR,userTagDto);
        }
        BusinessUserTag userCredentialsVo = new BusinessUserTag();
        BeanUtils.copyProperties(userTag,userCredentialsVo);
        return Resp.success(userCredentialsVo);

    }

    /**
     * @Explain 删除
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Resp delUserTag(HttpServletRequest request){
        Resp resp = new Resp();
        if (0<userTagService.del(getSessionAccount.thisAccount(request).getUserId())){
            resp.setResultCode(ResultCode.SUCCESS);
            return resp;
        }
        resp.setResultCode(ResultCode.ERROR);
        return resp;
    }

}
