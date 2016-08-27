package com.web.myapp.demo.schedule;

import java.util.Date;

import com.web.myapp.util.DateUtils;

/** 
 * Function: quartz作业调度配置实现
 * @author jiangyf   
 * @date 2016年8月10日 下午6:28:50 
 * @version V1.0   
 */
public class ConfigureSchedule {
	
	public void testConfigure(){
		System.out.println("定时任务：quartz123配置实现，时间：" + DateUtils.getDateStrByPattern(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}

}
