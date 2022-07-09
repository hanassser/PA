package com.social.dev.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.social.dev.model.entity.Tag;
import com.social.dev.model.entity.BmsTopicTag;

import java.util.List;
import java.util.Set;

public interface TopicTagService extends IService<BmsTopicTag> {

    /**
     * get Topic Tag associated record
     *
     * @param topicId TopicId
     * @return
     */
    List<BmsTopicTag> selectByTopicId(String topicId);
    /**
     * Create an intermediate relationship
     *
     * @param id
     * @param tags
     * @return
     */
    void createTopicTag(String id, List<Tag> tags);
    /**
     * Get the collection of tag face swap topic IDs
     *
     * @param id
     * @return
     */
    Set<String> selectTopicIdsByTagId(String id);

}
