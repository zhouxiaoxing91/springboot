package com.shenma.controller;

/**
 * Created by sh00912 on 2017/7/17.
 */
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.shenma.mapper.UserMapper;
import com.shenma.model.User;
import com.shenma.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class WebController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping("/index")
    @ResponseBody
    public String selectAge(int page, int pageSize){
        ModelAndView modelAndView = new ModelAndView("index");

        // PageHelper.startPage(page, pageSize, true);
        Page<?> page21 = PageHelper.startPage(page, pageSize);
        List<Map<String, Object>> user = mapper.getUserPageList(50);

        try {
             // PageInfo<User> pageInfo = new PageInfo<User>( MapUtil.convertListMap2ListBean(user, User.class) );
             PageInfo<?> pageInfo = page21.toPageInfo() ;
            System.out.println("page21.getTotal() "+pageInfo.getTotal() );
            System.out.println("page21.getPages() "+pageInfo.getPages());
            System.out.println("page21.getPageSize() "+pageInfo.getPageSize());
            System.out.println("page21.getPageNum() "+pageInfo.getPageNum());
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
