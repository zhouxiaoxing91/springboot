package com.nancy.controller;

/**
 * Created by sh00912 on 2017/7/17.
 */

import com.nancy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
public class WebController {

    @Autowired
    private UserService userService;
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


    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index() {

        log.info("*************开始************");
        List list = userService.getUserPageList(30) ;
        log.info("*************{}************", list);

        return "show";
    }
}
