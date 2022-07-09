package com.social.dev.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.social.dev.mapper.PromotionMapper;
import com.social.dev.model.entity.Promotion;
import com.social.dev.service.PromotionService;
import org.springframework.stereotype.Service;


@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionMapper, Promotion> implements PromotionService {

}
