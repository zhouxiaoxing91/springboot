package com.nancy.mapper;

import com.nancy.model.User;
import com.nancy.util.MybatisMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by sh00912 on 2017/7/19.
*/
@Repository("userMapper")
public interface UserMapper extends MybatisMapper<User> {
    @Select("select aa.*, bb.detail from user aa where aa.age < ${age} ")
    public List<Map<String, Object>>  getUserPageList(@Param("age") int age) ;
}
