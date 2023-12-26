package com.x.blog.model;

import lombok.Data;

@Data
public class Content {
    private String id;
    private String story;
    private Integer articleId;
    private String createTime;
    private String updateTime;
    private Boolean isDeleted;
    private Boolean isPublished;
    private Boolean isEdited;
    private String title;
    private String summary;
    private String author;
    private String category;
    private String tags;
    private String cover;
}
