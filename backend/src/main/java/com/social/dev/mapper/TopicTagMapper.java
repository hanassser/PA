package com.social.dev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.social.dev.model.entity.BmsTopicTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface TopicTagMapper extends BaseMapper<BmsTopicTag> {
    /**
     * Get a collection of topic IDs based on tags
     *
     * @param id
     * @return
     */
    Set<String> getTopicIdsByTagId(@Param("id") String id);
}
