package com.social.dev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.social.dev.model.entity.Post;
import com.social.dev.model.vo.PostVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicMapper extends BaseMapper<Post> {
    /**
     * Query the topic list of the home page by paging
     * <p>
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> selectListAndPage(@Param("page") Page<PostVO> page, @Param("tab") String tab);

    /**
     * Get details page recommendation
     *
     * @param id
     * @return
     */
    List<Post> selectRecommend(@Param("id") String id);
    /**
     * Full Text Search
     *
     * @param page
     * @param keyword
     * @return
     */
    Page<PostVO> searchByKey(@Param("page") Page<PostVO> page, @Param("keyword") String keyword);
}
