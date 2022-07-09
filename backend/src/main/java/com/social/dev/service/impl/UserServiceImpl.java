package com.social.dev.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.social.dev.common.exception.ApiAsserts;
import com.social.dev.jwt.JwtUtil;
import com.social.dev.mapper.FollowMapper;
import com.social.dev.mapper.TopicMapper;
import com.social.dev.mapper.UmsUserMapper;
import com.social.dev.model.dto.LoginDTO;
import com.social.dev.model.dto.RegisterDTO;
import com.social.dev.model.entity.Follow;
import com.social.dev.model.entity.Post;
import com.social.dev.model.entity.UmsUser;
import com.social.dev.model.vo.ProfileVO;
import com.social.dev.service.UserService;
import com.social.dev.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import java.util.Date;



@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser> implements UserService {

    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private FollowMapper followMapper;

    @Override
    public UmsUser executeRegister(RegisterDTO dto) {
        //Check if there is a user with the same username
        LambdaQueryWrapper<UmsUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsUser::getUsername, dto.getName()).or().eq(UmsUser::getEmail, dto.getEmail());
        UmsUser umsUser = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(umsUser)) {
            ApiAsserts.fail("Account or email already exists!");
        }
        UmsUser addUser = UmsUser.builder()
                .username(dto.getName())
                .alias(dto.getName())
                .password(MD5Utils.getPwd(dto.getPass()))
                .email(dto.getEmail())
                .createTime(new Date())
                .status(true)
                .build();
        baseMapper.insert(addUser);

        return addUser;
    }
    @Override
    public UmsUser getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<UmsUser>().eq(UmsUser::getUsername, username));
    }
    @Override
    public String executeLogin(LoginDTO dto) {
        String token = null;
        try {
            UmsUser user = getUserByUsername(dto.getUsername());
            String encodePwd = MD5Utils.getPwd(dto.getPassword());
            if(!encodePwd.equals(user.getPassword()))
            {
                throw new Exception("wrong password");
            }
            token = JwtUtil.generateToken(String.valueOf(user.getUsername()));
        } catch (Exception e) {
            log.warn("User does not exist or password authentication failed=======>{}", dto.getUsername());
        }
        return token;
    }
    @Override
    public ProfileVO getUserProfile(String id) {
        ProfileVO profile = new ProfileVO();
        UmsUser user = baseMapper.selectById(id);
        BeanUtils.copyProperties(user, profile);
        // user post count
        int count = topicMapper.selectCount(new LambdaQueryWrapper<Post>().eq(Post::getUserId, id));
        profile.setTopicCount(count);

        // follower count
        int followers = followMapper.selectCount((new LambdaQueryWrapper<Follow>().eq(Follow::getParentId, id)));
        profile.setFollowerCount(followers);

        return profile;
    }
}
