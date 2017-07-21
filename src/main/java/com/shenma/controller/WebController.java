package com.shenma.controller;

/**
 * Created by sh00912 on 2017/7/17.
 */
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.quick.mybatis.model.PageModel;
import com.shenma.mapper.UserMapper;
import com.shenma.model.User;
import com.shenma.util.MapUtil;
import com.shenma.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class WebController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping("/index")
    @ResponseBody
    public String selectAge(int page, int pageSize){
        ModelAndView modelAndView = new ModelAndView("index");

        PageHelper.startPage(page, pageSize, true);
        List<Map<String, Object>> user = mapper.getUserPageList(50);
        try {
            PageInfo<User> pageInfo = new PageInfo<User>( MapUtil.convertListMap2ListBean(user, User.class) );
            System.out.println("pageInfo.getTotal() "+pageInfo.getTotal());
            System.out.println("pageInfo.getPages() "+pageInfo.getPages());
            System.out.println("pageInfo.getPageSize() "+pageInfo.getPageSize());
        }catch (Exception e){
        }


//        PageModel<User> var1 = new PageModel<>();
//        var1.setPageSize(10);
//        var1.setMaxPage(1);
//
//        List<Map<String, Object>> user = mapper.getPageList(var1) ;
        for(Map u : user){
            System.out.println(u);
        }
        return "index";
    }
}
