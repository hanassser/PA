package com.social.dev.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.social.dev.model.dto.CreateTopicDTO;
import com.social.dev.model.entity.Post;
import com.social.dev.model.entity.UmsUser;
import com.social.dev.model.vo.PostVO;

import java.util.List;
import java.util.Map;


public interface PostService extends IService<Post> {

    /**
     * Get a list of topics on the home page
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> getList(Page<PostVO> page, String tab);
    /**
     * release
     *
     * @param dto
     * @param principal
     * @return
     */
    Post create(CreateTopicDTO dto, UmsUser principal);

    /**
     * View topic details
     *
     * @param id
     * @return
     */
    Map<String, Object> viewTopic(String id);
    /**
     * Get 10 random recommendations
     *
     * @param id
     * @return
     */
    List<Post> getRecommend(String id);
    /**
     * keyword search
     *
     * @param keyword
     * @param page
     * @return
     */
    Page<PostVO> searchByKey(String keyword, Page<PostVO> page);
}
