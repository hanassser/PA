package com.social.dev.model.vo;

import com.social.dev.model.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostVO implements Serializable {
    private static final long serialVersionUID = -261082150965211545L;

    /**
     * post ID
     */
    private String id;
    /**
     * user ID
     */
    private String userId;
    /**
     * avatar
     */
    private String avatar;
    /**
     * user alias
     */
    private String alias;
    /**
     * username
     */
    private String username;
    /**
     * post title
     */
    private String title;
    /**
     * comments number
     */
    private Integer comments;
    /**
     * pin on top
     */
    private Boolean top;
    /**
     * add to essence
     */
    private Boolean essence;
    /**
     * collect times
     */
    private Integer collects;
    /**
     * Topic association tags
     */
    private List<Tag> tags;
    /**
     * pageviews
     */
    private Integer view;
    /**
     * create time
     */
    private Date createTime;
    /**
     * modify time
     */
    private Date modifyTime;
}
