package com.social.dev.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.social.dev.model.entity.Tip;

public interface TipService extends IService<Tip> {
    Tip getRandomTip();
}
