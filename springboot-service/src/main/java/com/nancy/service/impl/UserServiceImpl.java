package com.nancy.service.impl;

import com.github.pagehelper.PageHelper;
import com.nancy.mapper.UserMapper;
import com.nancy.model.User;
import com.nancy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pandayeung on 2017/7/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserPageList(int age) {

//        List<Map<String, Object>> list = userMapper.getUserPageList(age) ;

        PageHelper.startPage(1, 3) ;
        List<User> users = userMapper.selectAll() ;
//        try {
//            users = MapUtil.convertListMap2ListBean(list, User.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return users ;

    }
}
