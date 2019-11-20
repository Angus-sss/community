package com.insedesign.community.communityindex.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.insedesign.community.model.entity.BusinessCommunity;
import com.insedesign.community.model.entity.BusinessCommunityMember;
import com.insedesign.community.resp.Resp;
import com.insedesign.community.service.*;
import com.insedesign.community.utils.JsonUtils;
import com.insedesign.community.utils.StringUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/16 10:37
 * @Explain: 网站开放的内容和操作 （社区新闻等，小区活动，用户发布的动态，小区人数，小区楼房数量，车位数，空闲房屋，小区地址地图，基本信息统计等可公开信息等等）
 */
@RestController
public class IndexController {
    @Resource
    private BusinessBuildingUnitService buildingUnitService;
    @Resource
    private BusinessBuildingRoomService buildingRoomService;
    @Resource
    private BusinessParkingSpaceService parkingSpaceService;
    @Resource
    private BusinessNewsService newsService;
    @Resource
    private BusinessCommunityMemberService memberService;
    @Resource
    private BusinessCommunityService communityService;


    /**
     * 封装主页信息
     * 一个请求获取多个数据
     * @return map集合数据
     */
    @GetMapping("/index")
    public Resp indexDates(){
        return Resp.success();
    }

    /**
     * 页面静态信息
     * @return
     */
    @GetMapping("/info")
    public Resp staticInfo(){
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        //从redis中获取数据
        String jsonResult = redisTemplate.opsForValue().get("STATIC_INFO");
        //判断redis中是否有数据
        if (StringUtils.isNotEmpty(jsonResult)){
            //如果redis有数据
            Map map = JsonUtils.jsonToMap(jsonResult);
            return Resp.success(map);
        }
        //如果redis没有数据 从MySQL数据库中获取
        Resp resp = new Resp();
        QueryWrapper<BusinessCommunity> wrapper = new QueryWrapper<>();
        Map<String, Object> map = communityService.getMap(wrapper);

        //将数据存到redis中
        redisTemplate.opsForValue().set("STATIC_INFO", Objects.requireNonNull(JsonUtils.objectToJson(map)));


        return Resp.success();
    }

    /**
     * 首页图片
     * @return
     */
    @GetMapping("/banner")
    public Resp banner(){
        return Resp.success();
    }


    /**
     * 小区人数
     * @return
     */
   @Cacheable
    @GetMapping("/member")
    public int member(){
        return memberService.count();
    }

}
