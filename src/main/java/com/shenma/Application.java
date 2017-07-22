package com.shenma;
/**
 * Created by sh00912 on 2017/6/13.
 */

import com.quick.mybatis.model.PageModel;
import com.shenma.mapper.UserMapper;
import com.shenma.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.List;
import java.util.Map;

@SpringBootApplication
//@SpringBootApplication 等价于使用@Configuration, @EnableAutoConfiguration 和 @ComponentScan默认属性的情况。
@ComponentScan(basePackages = { "com.shenma" })
//@ImportResource(value={"classpath:SqlMapConfig.xml"})
//@RestController
@EnableAutoConfiguration(exclude=WebMvcAutoConfiguration.class)
//@RequestMapping("/home")
public class Application extends WebMvcConfigurerAdapter {
    private static Logger log = LoggerFactory.getLogger(Application.class);

//    @Autowired
//    private UserMapper commonMapper ;
//
//    @RequestMapping("/home")
////    @RequestMapping("/home/{username}")
//    void home(@RequestParam("username") String username) {
//        log.info("username:**********************************" + username);
////        PageHelper.startPage(3, 5);
////        List<Map<String, Object>> user = commonMapper.getUserPageList(50);
////        PageModel<User> var1 = new PageModel<>();
////        var1.setPageSize(10);
////        var1.setMaxPage(1);
////
////        List<Map<String, Object>> user1 = commonMapper.getPageList(var1) ;
////        for(Map u : user){
////            System.out.println(u);
////        }
//
//        return ;
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
