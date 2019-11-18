package com.insedesign.community.communityuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.entity.BusinessUser;
import com.insedesign.community.model.entity.BusinessUserAddress;
import com.insedesign.community.model.vo.UserAddressVo;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessUserAddressService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.WeakHashMap;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 17:26
 * @Explain:
 */
@RestController
@RequestMapping("/address")
public class UserAddressController {
    @Resource
    private BusinessUserAddressService service;

    /**
     * 根据用户id查找
     * @param userId
     * @return
     */
    @ResponseBody
    @PostMapping("/select")
    public Resp selectByUserId(@NotNull String userId){
        return Resp.success(service.getById(userId));
    }
    /**
     * 查询所有
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/selectList")
    public Resp selectList(){
        //条件构造器
        QueryWrapper<BusinessUserAddress> queryWrapper = new QueryWrapper<>();
        //查询状态为正常的数据
        queryWrapper.eq(BusinessUserAddress.COL_STATE, Base.IS_OK);
        return Resp.success(service.list(queryWrapper));
    }
    /**
     * 分页查询
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/select/{currentPage}/{pageSize}")
    public Resp selectPage(@PathVariable int currentPage, @PathVariable int pageSize){
        //条件构造器
        QueryWrapper<BusinessUserAddress> queryWrapper = new QueryWrapper<>();
        Page<BusinessUserAddress> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessUserAddress.COL_STATE, Base.IS_OK);
        IPage<BusinessUserAddress> carPage = service.page(page,queryWrapper);
        return Resp.success(carPage.getRecords());
    }


    /**
     * 增加 地址数量最多存5条
     * @param userId
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Resp select(@NotNull String userId){
        QueryWrapper<BusinessUserAddress> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserAddress.COL_USER_ID,userId);
        //地址最多存5条
        if (Base.DATA_NUM_MAX_5<service.count(wrapper)){
            return Resp.success(service.getById(userId));
        }
        return Resp.error(ResultCode.DATA_MAX_CEILING);
    }

    /**
     * 获取默认地址
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/getDefault")
    public Resp getDefault(HttpSession session){
        QueryWrapper<BusinessUserAddress> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserAddress.COL_IS_DEFAULT,Base.ADDRESS_IS_DEFAULT
        ).eq(BusinessUserAddress.COL_USER_ID, thisUser(session).getUserId());
        BusinessUserAddress address = service.getOne(wrapper);
        if (null!=address){
            UserAddressVo userAddressVo = new UserAddressVo();
            BeanUtils.copyProperties(address,userAddressVo);
            return Resp.success(userAddressVo);
        }
        return Resp.error(ResultCode.DATA_MAX_CEILING);
    }

    /**
     * 设置默认地址
     * 修改默认地址
     * 确保默认只有一个
     * 1.修改默认地址为正常
     * 2.设置指定地址为默认
     *
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/setDefault")
    public Resp setDefault(@NotNull String addressId,HttpSession session){
        //获取默认地址
        Resp resp = getDefault(session);
        BusinessUserAddress address;
        if (null!=resp.getData()){
            address = (BusinessUserAddress) resp.getData();
            //设置为正常
            address.setIsDefault(Base.ADDRESS_NOT_DEFAULT);
        }else{
            //防止恶意修改他人数据
            return Resp.error(ResultCode.DATA_IS_NONE);
        }
        //更新数据库
        QueryWrapper<BusinessUserAddress> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserAddress.COL_ADDRESS_ID,address.getAddressId());
        service.update(address,wrapper);
        //设置新的默认值
        QueryWrapper<BusinessUserAddress> wrapper1 = new QueryWrapper<>();
        wrapper1.eq(BusinessUserAddress.COL_ADDRESS_ID,addressId);
        BusinessUserAddress one = service.getOne(wrapper1);
        one.setIsDefault(Base.ADDRESS_IS_DEFAULT);
        QueryWrapper<BusinessUserAddress> wrapper2 = new QueryWrapper<>();
        wrapper2.eq(BusinessUserAddress.COL_ADDRESS_ID,addressId);
        if (service.update(one,wrapper2)){
            return Resp.success();
        }
        return Resp.error(ResultCode.ERROR);
    }


    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/del")
    public Resp delete(List<String> carIds , HttpServletRequest request){
        return getDel(carIds);
    }
    @NotNull
    private Resp getDel(List<String> carIds) {
        QueryWrapper<BusinessUserAddress> queryWrapper = new QueryWrapper<>();
        for(String item : carIds) {
            //查询数据
            BusinessUserAddress businessBuildingRoom = service.getById(item);
            //设置状态为删除
            businessBuildingRoom.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessUserAddress.COL_ADDRESS_ID,item);
            service.update(queryWrapper);
        }
        return Resp.success();
    }

    /**
     * 修改
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/update")
    public Resp update(BusinessUserAddress entity , HttpServletRequest request){
        if (null==entity){
            return Resp.error(ResultCode.PARAM_IS_NULL);
        }
        return Resp.success(service.updateById(entity));
    }


    /**
     * 获取当前用户
     */
    private BusinessUser thisUser(HttpSession session){
        BusinessUser thisUser = (BusinessUser)session.getAttribute(Base.THIS_USER);
        return thisUser;
    }

}
