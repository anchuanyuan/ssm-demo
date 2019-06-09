package com.example.hello2.mapper;

import com.example.hello2.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;




@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account,token,gmt_Create,gmt_Modified) values (#{name},#{account},#{token},#{gmtCreate},#{gmtModified} )")
    void insert(User user);



}
