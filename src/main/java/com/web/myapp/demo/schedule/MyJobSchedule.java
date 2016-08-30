package com.web.myapp.demo.schedule;

import java.util.concurrent.TimeUnit;

import org.quartz.CronScheduleBuilder;
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

/**   
 * Function: quartz作业调度接口实现  
 * @author jiangyf   
 * @since 2016年8月30日 上午11:51:56 
 * @version V1.0   
 */
public class MyJobSchedule {
	private static final Logger logger = LoggerFactory.getLogger(MyJobSchedule.class);
	
	/**  
	* Function: 执行quartz作业调度
	* @return void 
	* @author jiangyf 
	* @since 2016年8月30日 下午12:02:36 
	*/
	private static void runCronSchedule() {
		try {
			// 获取Scheduler实例
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			// 具体任务
			JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
			// 触发时间点
			CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ? *");
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
					.startNow().withSchedule(cronScheduleBuilder).build();
			// 交由Scheduler安排触发
			scheduler.scheduleJob(job, trigger);
			/* 为观察程序运行，此设置主程序睡眠1分钟才继续往下运行（因下一个步骤是“关闭Scheduler”） */
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 关闭Scheduler
			scheduler.shutdown();
		} catch (SchedulerException se) {
			logger.error(se.getMessage(), se);
		}
	}
	
	/**  
	* Function: 执行quartz作业调度
	* @return void 
	* @author jiangyf 
	* @since 2016年8月30日 下午12:02:36 
	*/
	private static void runSimpleSchedule() {
		try {
			// 获取Scheduler实例
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			// 具体任务
			JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job2", "group2").build();
			// 触发时间点
			SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(5).repeatForever();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
					.startNow().withSchedule(simpleScheduleBuilder).build();
			// 交由Scheduler安排触发
			scheduler.scheduleJob(job, trigger);
			/* 为观察程序运行，此设置主程序睡眠1分钟才继续往下运行（因下一个步骤是“关闭Scheduler”） */
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 关闭Scheduler
			scheduler.shutdown();
		} catch (SchedulerException se) {
			logger.error(se.getMessage(), se);
		}
	}
	
	public static void main(String[] args) {
		runCronSchedule();
//		runSimpleSchedule();
    }

}
