package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: springboot
 * @Package: quartz
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/9/30 10:00
 */
public class JobImpl implements Job {
    public void execute(JobExecutionContext context) {
        System.out.println("job impl running");
    }
}

