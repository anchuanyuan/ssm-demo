package com.example.comunity.model;

import lombok.Data;

/**
 * @Auther: An
 * @Date:2019/10/22
 * @Description:com.example.comunity.model
 * @version:1.0
 * 发布的文章 类
 */
@Data
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



}
