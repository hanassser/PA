package com.social.dev.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@TableName("bms_promotion")
@Accessors(chain = true)
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * main key
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * ads title
     */
    @TableField("title")
    private String title;

    /**
     * ads link
     */
    @TableField("link")
    private String link;

    /**
     * description
     */
    @TableField("`description`")
    private String description;

    public Promotion() {
    }

}
