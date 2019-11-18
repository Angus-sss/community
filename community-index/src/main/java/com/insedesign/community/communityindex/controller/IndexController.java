package com.insedesign.community.communityindex.controller;

import com.insedesign.community.resp.Resp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/16 10:37
 * @Explain: 网站开放的内容和操作 （社区新闻等，小区活动，用户发布的动态，小区人数，小区楼房数量，车位数，空闲房屋，小区地址地图，基本信息统计等可公开信息等等）
 */
@RestController
public class IndexController {
    @Resource
    BusinessBuildingUnitService buildingUnitService;
    @Resource
    BusinessBuildingRoomService buildingRoomService;
    @Resource
    BusinessParkingSpaceService parkingSpaceService;
    @Resource
    BusinessNewsService newsService;




    /**
     * 封装主页信息
     * 一个请求获取多个数据
     * @return map集合数据
     */
    @PostMapping("/index")
    public Resp indexDates(){
        return Resp.success();

    }

    /**
     * 导航信息
     * @return
     */
    @PostMapping("/head")
    public Resp head(){
        return Resp.success();

    }

    /**
     * 站点信息
     * @return
     */
    @PostMapping("/siteInfo")
    public Resp siteInfo(){
        return Resp.success();

    }


}
