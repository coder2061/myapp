package com.web.myapp.weixin.model;
/** 
 * 消息发送分布数据  
 */
public class UpstreamMsgDist {
	// 数据的日期
	private String ref_date;
	// 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
	private int count_interval;
	// 上行发送了（向公众号发送了）消息的用户数
	private int msg_user;
	
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}
	public int getCount_interval() {
		return count_interval;
	}
	public void setCount_interval(int count_interval) {
		this.count_interval = count_interval;
	}
	public int getMsg_user() {
		return msg_user;
	}
	public void setMsg_user(int msg_user) {
		this.msg_user = msg_user;
	}
	
}
