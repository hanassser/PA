package com.social.dev.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@Accessors(chain = true)
@TableName("bms_billboard")
@NoArgsConstructor
@AllArgsConstructor
public class Billboard implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * main key
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * billboard
     */
    @TableField("content")
    private String content;

    /**
     * create time
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 1：showing，0：expired
     */
    @Builder.Default
    @TableField("`show`")
    private boolean show = false;

}
