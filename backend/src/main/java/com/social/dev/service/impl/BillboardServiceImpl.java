package com.social.dev.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.social.dev.mapper.BillboardMapper;
import com.social.dev.model.entity.Billboard;
import com.social.dev.service.BillboardService;
import org.springframework.stereotype.Service;

@Service
public class BillboardServiceImpl extends ServiceImpl<BillboardMapper
        , Billboard> implements BillboardService {

}
