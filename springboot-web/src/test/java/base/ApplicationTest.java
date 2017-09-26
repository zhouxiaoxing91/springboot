//package base;
//
//import com.nancy.Application;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
///**
// * All rights Reserved, Designed By guangfeng.zhou
// *
// * @version V1.0
// * @Project: springboot
// * @Package: com
// * @Description: springboot测试类
// *  1、SpringJUnit支持，由此引入Spring-Test框架支持
// *  2、SpringBoot工程的Application启动类 1.5以后， @SpringApplicationConfiguration(classes = .class) -- 1.4使用
// *  3、Web项目，Junit需要模拟ServletContext，因此需要测试类加上@WebAppConfiguration。
// * @author: guangfeng.zhou
// * @date: 2017/7/25 14:21
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
//public class ApplicationTest {
//    public Logger logger = LoggerFactory.getLogger(getClass());
//
//}
