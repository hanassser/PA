package com.social.dev.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("bms_follow")
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * main key
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * followed by person id
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * following person id
     */
    @TableField("follower_id")
    private String followerId;

    public Follow() {
    }

}
