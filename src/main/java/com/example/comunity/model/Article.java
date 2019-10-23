package com.example.comunity.model;

/**
 * @Auther: An
 * @Date:2019/10/22
 * @Description:com.example.comunity.model
 * @version:1.0
 * 发布的文章 类
 */
public class Article {
    private String title;
    private String description;
    private String tag;
    private String comment;
    private  Integer commentCount;
    private  Integer viewCount;
    private  Long gmtCreate;
    private  Long gmtModified;
    private Integer id;


    public Article() {
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Article(String title, String description, String tag, String comment, Integer commentCount, Integer viewCount, Long gmtCreate, Long gmtModified, Integer id) {
        this.title = title;
        this.description = description;
        this.tag = tag;
        this.comment = comment;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.id = id;
    }

    public Article(String title, String description, String tag, Long gmtCreate, Long gmtModified, Integer id) {
        this.title = title;
        this.description = description;
        this.tag = tag;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", comment='" + comment + '\'' +
                ", commentCount=" + commentCount +
                ", viewCount=" + viewCount +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
