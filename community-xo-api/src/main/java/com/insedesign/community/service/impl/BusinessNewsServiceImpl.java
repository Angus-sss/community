package com.insedesign.community.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.insedesign.community.model.entity.BusinessNews;
import com.insedesign.community.mapper.BusinessNewsMapper;
import com.insedesign.community.service.BusinessNewsService;
@Service
public class BusinessNewsServiceImpl extends ServiceImpl<BusinessNewsMapper, BusinessNews> implements BusinessNewsService{

}
