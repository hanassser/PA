package com.social.dev.controller;

import com.social.dev.common.api.ApiResult;
import com.social.dev.model.entity.Tip;
import com.social.dev.service.TipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tip")
public class TipController extends BaseController {
    @Resource
    private TipService bmsTipService;

    @GetMapping("/today")
    public ApiResult<Tip> getRandomTip() {
        Tip tip = bmsTipService.getRandomTip();
        return ApiResult.success(tip);
    }
}
