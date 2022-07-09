package com.social.dev.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.social.dev.mapper.TagMapper;
import com.social.dev.mapper.TopicMapper;
import com.social.dev.mapper.UmsUserMapper;
import com.social.dev.model.dto.CreateTopicDTO;
import com.social.dev.model.entity.Post;
import com.social.dev.model.entity.Tag;
import com.social.dev.model.entity.BmsTopicTag;
import com.social.dev.model.entity.UmsUser;
import com.social.dev.model.vo.PostVO;
import com.social.dev.model.vo.ProfileVO;
import com.social.dev.service.PostService;
import com.social.dev.service.TagService;
import com.social.dev.service.UserService;
import com.social.dev.service.TopicTagService;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl extends ServiceImpl<TopicMapper, Post> implements PostService {
    @Resource
    private TagMapper tagMapper;
    @Resource
    private UmsUserMapper umsUserMapper;

    @Autowired
    @Lazy
    private TagService tagService;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicTagService TopicTagService;
    @Override
    public Page<PostVO> getList(Page<PostVO> page, String tab) {
        // search topic
        Page<PostVO> iPage = this.baseMapper.selectListAndPage(page, tab);
        // search topic tags
        setTopicTags(iPage);
        return iPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Post create(CreateTopicDTO dto, UmsUser user) {
        Post topic1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Post>().eq(Post::getTitle, dto.getTitle()));
        Assert.isNull(topic1, "Topic already exists, please edit");

        // encapsulate
        Post topic = Post.builder()
                .userId(user.getId())
                .title(dto.getTitle())
                .content(EmojiParser.parseToAliases(dto.getContent()))
                .createTime(new Date())
                .build();
        this.baseMapper.insert(topic);

        // User points increase
        int newScore = user.getScore() + 1;
        umsUserMapper.updateById(user.setScore(newScore));

        // tag
        if (!ObjectUtils.isEmpty(dto.getTags())) {
            // save tag
            List<Tag> tags = tagService.insertTags(dto.getTags());
            // Handle tag-to-topic associations
            TopicTagService.createTopicTag(topic.getId(), tags);
        }

        return topic;
    }

    @Override
    public Map<String, Object> viewTopic(String id) {
        Map<String, Object> map = new HashMap<>(16);
        Post topic = this.baseMapper.selectById(id);
        Assert.notNull(topic, "The current topic does not exist, or has been deleted by the author");
        // search topic details
        topic.setView(topic.getView() + 1);
        this.baseMapper.updateById(topic);
        // emoji transcoding
        topic.setContent(EmojiParser.parseToUnicode(topic.getContent()));
        map.put("topic", topic);
        // tag
        QueryWrapper<BmsTopicTag> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BmsTopicTag::getTopicId, topic.getId());
        Set<String> set = new HashSet<>();
        for (BmsTopicTag articleTag : TopicTagService.list(wrapper)) {
            set.add(articleTag.getTagId());
        }
        List<Tag> tags = tagService.listByIds(set);
        map.put("tags", tags);

        // author

        ProfileVO user = userService.getUserProfile(topic.getUserId());
        map.put("user", user);

        return map;
    }

    @Override
    public List<Post> getRecommend(String id) {
        return this.baseMapper.selectRecommend(id);
    }
    @Override
    public Page<PostVO> searchByKey(String keyword, Page<PostVO> page) {
        // search topic
        Page<PostVO> iPage = this.baseMapper.searchByKey(page, keyword);
        // search topic tag
        setTopicTags(iPage);
        return iPage;
    }

    private void setTopicTags(Page<PostVO> iPage) {
        iPage.getRecords().forEach(topic -> {
            List<BmsTopicTag> topicTags = TopicTagService.selectByTopicId(topic.getId());
            if (!topicTags.isEmpty()) {
                List<String> tagIds = topicTags.stream().map(BmsTopicTag::getTagId).collect(Collectors.toList());
                List<Tag> tags = tagMapper.selectBatchIds(tagIds);
                topic.setTags(tags);
            }
        });
    }
}
