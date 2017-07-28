package com.shenma.mapper;

import com.quick.mybatis.mapper.CommonMapper;
import com.shenma.model.User;
import com.shenma.util.MybatisMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by sh00912 on 2017/7/19.
*/
@Qualifier("userMapper")
@Repository("userMapper")
public interface UserMapper extends MybatisMapper<User> {
    @Select("select aa.*, bb.detail from user aa left outer join items bb on aa.id=bb.id where aa.age < ${age} ")
    public List<Map<String, Object>>  getUserPageList(@Param("age") int age) ;
}
