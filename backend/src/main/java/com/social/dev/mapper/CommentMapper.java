package com.social.dev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.social.dev.model.entity.Comment;
import com.social.dev.model.vo.CommentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * getCommentsByTopicID
     *
     * @param topicid
     * @return
     */
    List<CommentVO> getCommentsByTopicID(@Param("topicid") String topicid);
}
