package com.social.dev.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.social.dev.model.entity.Post;
import com.social.dev.model.entity.Tag;

import java.util.List;


public interface TagService extends IService<Tag> {
    /**
     * insert label
     *
     * @param tags
     * @return
     */
    List<Tag> insertTags(List<String> tags);
    /**
     * Get the associated topic of the tag
     *
     * @param topicPage
     * @param id
     * @return
     */
    Page<Post> selectTopicsByTagId(Page<Post> topicPage, String id);
}
