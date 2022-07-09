package com.social.dev.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateTopicDTO implements Serializable {
    private static final long serialVersionUID = -5957433707110390852L;

    /**
     * topic
     */
    private String title;

    /**
     * content
     */
    private String content;

    /**
     * tags
     */
    private List<String> tags;

}
