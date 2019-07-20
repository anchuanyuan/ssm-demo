package com.example.comunity.mapper;

import com.example.comunity.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account,token,gmt_Create,gmt_Modified) values (#{name},#{account},#{token},#{gmtCreate},#{gmtModified} )")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(String token);

}
