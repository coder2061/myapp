package com.web.myapp.weixin.model;
/** 
 * 累计用户数据
 */
public class CumulateUser {
	// 数据的日期 
	private String ref_date;
	// 总用户量
	private long cumulate_user;
	
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}
	public long getCumulate_user() {
		return cumulate_user;
	}
	public void setCumulate_user(long cumulate_user) {
		this.cumulate_user = cumulate_user;
	}
}
