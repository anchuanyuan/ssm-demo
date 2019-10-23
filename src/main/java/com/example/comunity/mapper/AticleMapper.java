package com.example.comunity.mapper;

import com.example.comunity.model.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: An
 * @Date:2019/10/22
 * @Description:com.example.comunity.mapper
 * @version:1.0
 *
 * 文章mapper
 */
@Mapper
public interface AticleMapper {
    @Insert("insert into Aticle (id,title,description,tag,gmt_Create,gmt_Modified,comment,comment_count,view_count) values(#{id},#{title},#{description},#{tag},#{gmtCreate},#{gmtModified},#{comment},#{commentCount},#{viewCount})")
    void addAticle(Article article);


}
