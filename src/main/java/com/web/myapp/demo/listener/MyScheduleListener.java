package com.web.myapp.demo.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.myapp.demo.schedule.MyJob;

/**   
 * Function: Application Lifecycle Listener implementation class AListener
 * 一般来说，Web应用启动时，应注册已经确定的定时任务；一些动态的、未确定触发时间的定时任务，后续可通过静态的Scheduler注册。
 * 这里使用监听器在应用启动时注册，记得在web.xml注册这个监听器；在关闭Web应用时，也要相应的注销定时任务。
 * 其他配置文件、Java类与上例子相同，这里只是注册定时任务的地方换成此监听器了。
 * @author jiangyf   
 * @since 2016年8月30日 下午2:51:21 
 * @version V1.0   
 */
public class MyScheduleListener implements ServletContextListener {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public static Scheduler scheduler = null;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        this.logger.info("The application start...");
        
        /* 注册定时任务 */
        try {
            // 获取Scheduler实例
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            // 具体任务
            JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();

            // 触发时间点
            SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5).repeatForever();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                    .startNow().withSchedule(simpleScheduleBuilder).build();

            // 交由Scheduler安排触发
            scheduler.scheduleJob(job, trigger);
            
            this.logger.info("The scheduler register...");
        } catch (SchedulerException se) {
            logger.error(se.getMessage(), se);
        }
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        this.logger.info("The application stop...");
        
        /* 注销定时任务 */
        try {
            // 关闭Scheduler
            scheduler.shutdown();
            
            this.logger.info("The scheduler shutdown...");
        } catch (SchedulerException se) {
            logger.error(se.getMessage(), se);
        }
    }

}
