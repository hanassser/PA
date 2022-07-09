package com.social.dev.model.vo;

import lombok.Data;

@Data
public class ProfileVO {

    /**
     * user ID
     */
    private String id;

    /**
     * username
     */
    private String username;

    /**
     * alias
     */
    private String alias;

    /**
     * avatar
     */
    private String avatar;

    /**
     * follow number
     */
    private Integer followCount;

    /**
     * follower count
     */
    private Integer followerCount;

    /**
     * topic count
     */
    private Integer topicCount;

    /**
     * columns number
     */
    private Integer columns;

    /**
     * comment count
     */
    private Integer commentCount;

}
