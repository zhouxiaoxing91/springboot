package com.shenma.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shenma.model.User;
import com.shenma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by pandayeung on 2017/7/22.
 */
@RestController
public class PageInfoController {

//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/show")
//    @ResponseBody
//    public ModelAndView show(int page, int pageSize){
//        ModelAndView modelAndView = new ModelAndView("show");
//
//        Page<?> page21 = PageHelper.startPage(page, pageSize);
//        List<User> user = userService.getUserPageList(50);
//
//        PageInfo<?> pageInfo = page21.toPageInfo() ;
//        try {
//            System.out.println("pageInfo.getTotal() "+pageInfo.getTotal() );
//            System.out.println("pageInfo.getPages() "+pageInfo.getPages());
//            System.out.println("pageInfo.getPageSize() "+pageInfo.getPageSize());
//            System.out.println("pageInfo.getPageNum() "+pageInfo.getPageNum());
//        }catch (Exception e){
//        }
//        modelAndView.addObject("total", pageInfo.getTotal() ) ;
//        modelAndView.addObject("pages", pageInfo.getPages()) ;
//        modelAndView.addObject("pageNum", pageInfo.getPageNum()) ;
//        modelAndView.addObject("pageSize", pageInfo.getPageSize()) ;
//        modelAndView.addObject("result", pageInfo.getList()) ;
//
//
//        return modelAndView ;
//    }

}
