package com.social.dev.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.social.dev.model.dto.CommentDTO;
import com.social.dev.model.entity.Comment;
import com.social.dev.model.entity.UmsUser;
import com.social.dev.model.vo.CommentVO;

import java.util.List;


public interface CommentService extends IService<Comment> {
    /**
     *
     *
     * @param topicid
     * @return {@link Comment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    Comment create(CommentDTO dto, UmsUser principal);
}
