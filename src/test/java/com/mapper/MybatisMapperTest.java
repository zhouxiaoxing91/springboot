package com.mapper;

import com.base.ApplicationTest;
import com.shenma.mapper.UserMapper;
import com.shenma.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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

//    @Autowired
//    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMapper(){
        logger.info("userMapper.selectByPrimaryKey(1) {}", userMapper.selectByPrimaryKey(12));
    }

}
