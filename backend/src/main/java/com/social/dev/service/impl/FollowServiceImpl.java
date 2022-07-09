package com.social.dev.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.social.dev.mapper.FollowMapper;
import com.social.dev.model.entity.Follow;
import com.social.dev.service.FollowService;
import org.springframework.stereotype.Service;


@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {
}
