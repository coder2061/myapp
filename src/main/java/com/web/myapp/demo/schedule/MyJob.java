package com.web.myapp.demo.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**   
 * Function: quartz作业调度接口实现 
 * @author jiangyf   
 * @since 2016年8月30日 上午11:45:01 
 * @version V1.0   
 */
public class MyJob implements Job {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("定时任务：quartz接口实现");
	}

}
