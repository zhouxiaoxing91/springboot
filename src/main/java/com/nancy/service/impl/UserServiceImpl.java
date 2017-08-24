package com.nancy.service.impl;

import com.nancy.mapper.UserMapper;
import com.nancy.model.User;
import com.nancy.service.UserService;
import com.nancy.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by pandayeung on 2017/7/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getUserPageList(int age) {

        List<Map<String, Object>> list = mapper.getUserPageList(age) ;

        List<User> users = null ;
        try {
            users = MapUtil.convertListMap2ListBean(list, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users ;

    }
}