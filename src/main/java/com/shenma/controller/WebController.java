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
import com.shenma.service.UserService;
import com.shenma.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class WebController {

//    @Autowired
//    private UserService mapper;
//
//    @RequestMapping("/index")
//    @ResponseBody
//    public String selectAge(int page, int pageSize){
//        ModelAndView modelAndView = new ModelAndView("index");
//
//        // PageHelper.startPage(page, pageSize, true);
//        Page<?> page21 = PageHelper.startPage(page, pageSize);
//        List<User> user = mapper.getUserPageList(50);
//        try {
//             // PageInfo<User> pageInfo = new PageInfo<User>( MapUtil.convertListMap2ListBean(user, User.class) );
//            PageInfo<?> pageInfo = page21.toPageInfo() ;
//            System.out.println("pageInfo.getTotal() "+pageInfo.getTotal() );
//            System.out.println("pageInfo.getPages() "+pageInfo.getPages());
//            System.out.println("pageInfo.getPageSize() "+pageInfo.getPageSize());
//            System.out.println("pageInfo.getPageNum() "+pageInfo.getPageNum());
//        }catch (Exception e){
//        }
//
//
////        PageModel<User> var1 = new PageModel<>();
////        var1.setPageSize(10);
////        var1.setMaxPage(1);
////
////        List<Map<String, Object>> user = com.mapper.com.base.mapper.getPageList(var1) ;
//        for(User u : user){
//            System.out.println(u);
//        }
//        return "index";
//    }
}
