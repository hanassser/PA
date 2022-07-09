package com.social.dev.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@TableName("bms_tip")
public class Tip implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * main key
     */
    private Integer id;

    /**
     * content
     */
    @TableField("`content`")
    private String content;

    /**
     * author
     */
    private String author;

    /**
     * 1：using，0：expired
     */
    private boolean type;

}
