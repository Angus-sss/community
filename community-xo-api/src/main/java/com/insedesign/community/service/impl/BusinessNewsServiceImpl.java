package com.insedesign.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.mapper.BusinessNewsMapper;
import com.insedesign.community.model.entity.BusinessNews;
import com.insedesign.community.service.BusinessNewsService;
import org.springframework.stereotype.Service;
/**
 * @author NALHOUG
 */
@Service
public class BusinessNewsServiceImpl extends ServiceImpl<BusinessNewsMapper, BusinessNews> implements BusinessNewsService{

}
