package com.insedesign.community.communityuser.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.insedesign.community.utils.DateUtil;
import com.insedesign.community.communityuser.service.GetMainService;
import com.insedesign.community.enmus.Base;
import com.insedesign.community.enmus.ResultCode;
import com.insedesign.community.model.dto.UserRegisterDto;
import com.insedesign.community.model.entity.BusinessUser;
import com.insedesign.community.model.entity.BusinessUserAdmin;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.BusinessUserAdminService;
import com.insedesign.community.service.BusinessUserService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/15 17:26
 * @Explain: 管理员身份表用户表，只有BOSS才有添加管理员此权限
 */
@Slf4j
@RestController
@RequestMapping("/credentials")
public class UserAdminController {
    @Resource
    private BusinessUserAdminService adminService;
    @Resource
    private BusinessUserService userService;
    @Resource
    private GetMainService mainService;




    /**
     * 查找单个
     * @param adminId
     * @return
     */
    @ResponseBody
    @PostMapping("/selectOne")
    public Resp select(@NotNull String adminId){
        QueryWrapper<BusinessUserAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserAdmin.COL_STATE,Base.IS_OK)
                .eq(BusinessUserAdmin.COL_ADMIN_ID,adminId);
        return Resp.success(adminService.getOne(wrapper));
    }
    /**
     * 管理员列表
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/selectCount")
    public Resp selectCount(){
        QueryWrapper<BusinessUserAdmin> wrapper = new QueryWrapper<>();
        return Resp.success(adminService.count(wrapper));
    }


    /**
     * 根据用户id查找
     * @param userId
     * @return
     */
    @ResponseBody
    @PostMapping("/selectByUserId")
    public Resp selectByUserId(@NotNull String userId){
        QueryWrapper<BusinessUserAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq(BusinessUserAdmin.COL_STATE,Base.IS_OK)
        .eq(BusinessUserAdmin.COL_USER_ID,userId);
        return Resp.success(adminService.getOne(wrapper));
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
        QueryWrapper<BusinessUserAdmin> queryWrapper = new QueryWrapper<>();
        Page<BusinessUserAdmin> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        //查询状态为正常的数据
        queryWrapper.eq(BusinessUserAdmin.COL_STATE, Base.IS_OK);
        IPage<BusinessUserAdmin> carPage = adminService.page(page,queryWrapper);
        return Resp.success(carPage.getRecords());
    }


    /**
     * 后台添加用户
     * @param userRegisterDto
     * @return
     */
    @ResponseBody
    @PostMapping("/addUser")
    public Resp addUser(@NotNull UserRegisterDto userRegisterDto,HttpSession session){
        Resp register = mainService.register(userRegisterDto);
        if (ResultCode.ACCOUNT_REGISTER_SUCCESS.code().equals(register.getCode())){
            log.info(thisUser(session).getUserId()+"通过后台创建了用户:"+userRegisterDto.getUserId());
        }
        return register;
    }
    /**
     * 设置普通用户为管理员
     * @param userId
     * @return
     */
    @ResponseBody
    @PostMapping("/setAdmin")
    public Resp setAdmin(@NotNull String userId,HttpSession session) {
        //查找用户
        Resp respDate = selectByUserId(userId);
        BusinessUser dbUser = (BusinessUser) respDate.getData();
        //设置为管理员
        dbUser.setUserStatus(Base.IS_ADMIN);
        if (userService.updateById(dbUser)) {
            //创建管理员表
            BusinessUserAdmin businessUserAdmin = new BusinessUserAdmin();
            businessUserAdmin.setAdminId(Base.ADMIN + DateUtil.getTimeId());
            if (adminService.save(businessUserAdmin)) {
                log.info(thisUser(session).getUserId() + "通过后台设置用户：" + userId + "为管理员。");
                Resp.success();
            }
        }
        return Resp.error(ResultCode.ERROR);
    }


    /**
     * 添加管理员
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/addAdmin")
    public Resp addAdmin(@NotNull UserRegisterDto user,HttpSession session){
        if (ResultCode.ACCOUNT_REGISTER_SUCCESS.code().equals(addUser(user, session).getCode())){
            if (ResultCode.SUCCESS.code().equals(setAdmin(user.getUserId(),session).getCode())){
                return Resp.success();
            }
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
        QueryWrapper<BusinessUserAdmin> queryWrapper = new QueryWrapper<>();
        for(String item : carIds) {

            //查询数据
            BusinessUserAdmin businessBuildingRoom = adminService.getById(item);
            //设置状态为删除
            businessBuildingRoom.setState(Base.IS_DEL);
            //更新数据
            queryWrapper.eq(BusinessUserAdmin.COL_ADMIN_ID,item);
            adminService.update(queryWrapper);
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
    public Resp update(@NotNull BusinessUserAdmin entity , HttpServletRequest request){
        if (adminService.updateById(entity)){
            return Resp.success();
        }
        return Resp.error(ResultCode.ERROR);
    }


    /**
     * 获取当前用户
     */
    private BusinessUser thisUser(HttpSession session){
        BusinessUser thisUser = (BusinessUser)session.getAttribute(Base.THIS_USER);
        return thisUser;
    }

}
