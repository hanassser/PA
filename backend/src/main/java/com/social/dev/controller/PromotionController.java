package com.social.dev.controller;

import com.social.dev.common.api.ApiResult;
import com.social.dev.model.entity.Promotion;
import com.social.dev.service.PromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/promotion")
public class PromotionController extends BaseController {

    @Resource
    private PromotionService bmsPromotionService;

    @GetMapping("/all")
    public ApiResult<List<Promotion>> list() {
        List<Promotion> list = bmsPromotionService.list();
        return ApiResult.success(list);
    }

}
