package com.social.dev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.social.dev.model.entity.Tip;
import org.springframework.stereotype.Repository;

@Repository
public interface TipMapper extends BaseMapper<Tip> {
    Tip getRandomTip();
}
