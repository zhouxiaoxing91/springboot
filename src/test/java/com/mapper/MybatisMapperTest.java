package com.mapper;

import com.base.ApplicationTest;
import com.nancy.mapper.UserMapper;
import com.nancy.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: springboot
 * @Package: com.mapper
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/7/28 16:57
 */
public class MybatisMapperTest extends ApplicationTest {

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserMapper userMapper;

    @Test
    public void testMapper(){
        logger.info("**************************************");
        userService.getUserPageList(20) ;
        logger.info("**************************************");

    }

}
