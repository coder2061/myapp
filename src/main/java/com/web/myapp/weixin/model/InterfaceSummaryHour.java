package com.web.myapp.weixin.model;
/** 
 * 接口分析分时数据
 */
public class InterfaceSummaryHour {
	// 数据的日期，需在begin_date和end_date之间
	private String ref_date;
	// 数据的小时
	private int ref_hour;
	// 通过服务器配置地址获得消息后，被动回复用户消息的次数
	private long callback_count;
	// 上述动作的失败次数
	private int fail_count;
	// 总耗时，除以callback_count即为平均耗时
	private long total_time_cost;
	// 最大耗时
	private long max_time_cost;
	
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}
	public int getRef_hour() {
		return ref_hour;
	}
	public void setRef_hour(int ref_hour) {
		this.ref_hour = ref_hour;
	}
	public long getCallback_count() {
		return callback_count;
	}
	public void setCallback_count(long callback_count) {
		this.callback_count = callback_count;
	}
	public int getFail_count() {
		return fail_count;
	}
	public void setFail_count(int fail_count) {
		this.fail_count = fail_count;
	}
	public long getTotal_time_cost() {
		return total_time_cost;
	}
	public void setTotal_time_cost(long total_time_cost) {
		this.total_time_cost = total_time_cost;
	}
	public long getMax_time_cost() {
		return max_time_cost;
	}
	public void setMax_time_cost(long max_time_cost) {
		this.max_time_cost = max_time_cost;
	}
	
}
