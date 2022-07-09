package com.social.dev.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@TableName("bms_post")
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * main key
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * title
     */
    @NotBlank(message = "title can't be empty")
    @TableField(value = "title")
    private String title;
    /**
     * markdown
     */
    @NotBlank(message = "content can't be empty")
    @TableField("`content`")
    private String content;

    /**
     * author ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * comments number
     */
    @TableField("comments")
    @Builder.Default
    private Integer comments = 0;

    /**
     * collect number
     */
    @TableField("collects")
    @Builder.Default
    private Integer collects = 0;

    /**
     * view number
     */
    @TableField("view")
    @Builder.Default
    private Integer view = 0;

    /**
     * Column ID, no columns by default
     */
    @TableField("section_id")
    @Builder.Default
    private Integer sectionId = 0;

    /**
     * pin on top
     */
    @TableField("top")
    @Builder.Default
    private Boolean top = false;

    /**
     * add to essence
     */
    @TableField("essence")
    @Builder.Default
    private Boolean essence = false;

    /**
     * create time
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**Column ID, no columns by default
     * modily time
     */
    @TableField(value = "modify_time", fill = FieldFill.UPDATE)
    private Date modifyTime;
}
