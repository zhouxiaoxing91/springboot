package com.shenma.mapper;

import com.quick.mybatis.mapper.CommonMapper;
import com.shenma.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by sh00912 on 2017/7/19.
 */
public interface UserMapper extends CommonMapper<User> {
    @Select("select aa.*, bb.detail from user aa left outer join items bb on aa.id=bb.id where aa.age < ${age} ")
    public List<Map<String, Object>>  getUserPageList(@Param("age") int age) ;
}
