package com.nancy.handle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * All rights Reserved, Designed By sh00925
 *
 * @version V1.0
 * @Package: com.nancy.ccms.handle
 * @Description: (定时任务之间并行)
 * @author:
 * @date: 2017/7/25 14:36
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(100);
    }
}
