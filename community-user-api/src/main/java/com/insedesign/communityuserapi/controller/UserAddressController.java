package com.insedesign.communityuserapi.controller;

import com.insedesign.communityuserapi.common.enmus.ResultCode;
import com.insedesign.communityuserapi.common.resp.Resp;
import com.insedesign.communityuserapi.common.utils.GetSessionAccount;
import com.insedesign.communityuserapi.model.dto.UserAddressDto;
import com.insedesign.communityuserapi.model.entity.BusinessUserAddress;
import com.insedesign.communityuserapi.model.vo.UserAddressVo;
import com.insedesign.communityuserapi.service.BusinessUserAddressService;
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
@RequestMapping(value = "/address")
public class UserAddressController {
    @Resource
    private BusinessUserAddressService userAddressService;
    @Resource
    private GetSessionAccount getSessionAccount;


    /**
     * @Explain 查询用户地址
     * @param request
     * @return
     * */
    @ResponseBody
    @RequestMapping(value = "/address",method = RequestMethod.POST)
    public Resp checkUserAddress(HttpServletRequest request){
        BusinessUserAddress userAddress = userAddressService.selectByUserId(getSessionAccount.thisAccount(request).getUserId());
        return Resp.success(userAddress);
    }

    /**
     * @Explain 修改
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Resp updateUserAddress(UserAddressDto userAddressDto, HttpServletRequest request){
        BusinessUserAddress userAddress = userAddressService.update(userAddressDto);
        if (null==userAddress){
            return Resp.error(ResultCode.ERROR);
        }
       UserAddressVo userAddressVo = new UserAddressVo();
        BeanUtils.copyProperties(userAddress,userAddressVo);
        return Resp.success(userAddressVo);
    }
    /**
     * @Explain 添加
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Resp addUserAddress(UserAddressDto userAddressDto, HttpServletRequest request){
        userAddressDto.setUserId(getSessionAccount.thisAccount(request).getUserId());
        BusinessUserAddress userAddress = userAddressService.update(userAddressDto);
        if (null==userAddress){
            return Resp.error(ResultCode.ERROR,userAddressDto);
        }
        UserAddressVo userAddressVo = new UserAddressVo();
        BeanUtils.copyProperties(userAddress,userAddressVo);
        return Resp.success(userAddressVo);

    }

    /**
     * @Explain 删除
     * @param request
     * @return
     *
     */
    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Resp delUserAddress(HttpServletRequest request){
        Resp resp = new Resp();
        if (0<userAddressService.del(getSessionAccount.thisAccount(request).getUserId())){
            resp.setResultCode(ResultCode.SUCCESS);
            return resp;
        }
        resp.setResultCode(ResultCode.ERROR);
        return resp;
    }



}
