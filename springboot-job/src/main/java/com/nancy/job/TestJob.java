package com.nancy.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: springboot
 * @Package: com.nancy.job
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/9/26 13:46
 */
@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
@Slf4j
public class TestJob {

    public void sayHello(){
        log.info("Hello world, i'm the king of the world!!!");
    }

}
