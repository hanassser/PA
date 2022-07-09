package com.social.dev.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.social.dev.mapper.TipMapper;
import com.social.dev.model.entity.Tip;
import com.social.dev.service.TipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TipServiceImpl extends ServiceImpl<TipMapper
        , Tip> implements TipService {

    @Override
    public Tip getRandomTip() {
        Tip todayTip = null;
        try {
            todayTip = this.baseMapper.getRandomTip();
        } catch (Exception e) {
            log.info("tip tranform failed");
        }
        return todayTip;
    }
}
