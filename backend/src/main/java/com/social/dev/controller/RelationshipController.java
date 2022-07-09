package com.social.dev.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.social.dev.common.api.ApiResult;
import com.social.dev.common.exception.ApiAsserts;
import com.social.dev.model.entity.Follow;
import com.social.dev.model.entity.UmsUser;
import com.social.dev.service.FollowService;
import com.social.dev.service.UserService;
import com.social.dev.jwt.JwtUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/relationship")
public class RelationshipController extends BaseController {

    @Resource
    private FollowService bmsFollowService;

    @Resource
    private UserService umsUserService;

    @GetMapping("/subscribe/{userId}")
    public ApiResult<Object> handleFollow(@RequestHeader(value = JwtUtil.USER_NAME) String userName
            , @PathVariable("userId") String parentId) {
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        if (parentId.equals(umsUser.getId())) {
            ApiAsserts.fail("您脸皮太厚了，怎么可以关注自己呢 😮");
        }
        Follow one = bmsFollowService.getOne(
                new LambdaQueryWrapper<Follow>()
                        .eq(Follow::getParentId, parentId)
                        .eq(Follow::getFollowerId, umsUser.getId()));
        if (!ObjectUtils.isEmpty(one)) {
            ApiAsserts.fail("已关注");
        }

        Follow follow = new Follow();
        follow.setParentId(parentId);
        follow.setFollowerId(umsUser.getId());
        bmsFollowService.save(follow);
        return ApiResult.success(null, "关注成功");
    }

    @GetMapping("/unsubscribe/{userId}")
    public ApiResult<Object> handleUnFollow(@RequestHeader(value = JwtUtil.USER_NAME) String userName
            , @PathVariable("userId") String parentId) {
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        Follow one = bmsFollowService.getOne(
                new LambdaQueryWrapper<Follow>()
                        .eq(Follow::getParentId, parentId)
                        .eq(Follow::getFollowerId, umsUser.getId()));
        if (ObjectUtils.isEmpty(one)) {
            ApiAsserts.fail("未关注！");
        }
        bmsFollowService.remove(new LambdaQueryWrapper<Follow>().eq(Follow::getParentId, parentId)
                .eq(Follow::getFollowerId, umsUser.getId()));
        return ApiResult.success(null, "取关成功");
    }

    @GetMapping("/validate/{topicUserId}")
    public ApiResult<Map<String, Object>> isFollow(@RequestHeader(value = JwtUtil.USER_NAME) String userName
            , @PathVariable("topicUserId") String topicUserId) {
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        Map<String, Object> map = new HashMap<>(16);
        map.put("hasFollow", false);
        if (!ObjectUtils.isEmpty(umsUser)) {
            Follow one = bmsFollowService.getOne(new LambdaQueryWrapper<Follow>()
                    .eq(Follow::getParentId, topicUserId)
                    .eq(Follow::getFollowerId, umsUser.getId()));
            if (!ObjectUtils.isEmpty(one)) {
                map.put("hasFollow", true);
            }
        }
        return ApiResult.success(map);
    }
}
