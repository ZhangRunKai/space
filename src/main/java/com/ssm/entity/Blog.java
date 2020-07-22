package com.ssm.entity;

import java.time.LocalDateTime;

/**
 * @author ZhangRunKai
 * @date 2020/7/21 9:53
 */
public class Blog {

    private Integer Id;
    private String title;//标题
    private String description;//摘要
    private String content;//内容
    private LocalDateTime created;//创建时间，最后编辑时间

    public Blog() {

    }

    public Blog(Integer id, String title, String description, String content, LocalDateTime created) {
        Id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.created = created;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
