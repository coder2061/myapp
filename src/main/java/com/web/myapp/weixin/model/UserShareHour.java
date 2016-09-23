package com.web.myapp.weixin.model;
/** 
 * 图文分享转发分时数据  
 */
public class UserShareHour {
	// 数据的日期，需在begin_date和end_date之间
	private String ref_date;
	// 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	private int ref_hour;
	// 分享的场景 1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	private String share_scene;
	// 分享的人数
	private int share_user;
	// 分享的次数
	private int share_count;
	
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
	public String getShare_scene() {
		return share_scene;
	}
	public void setShare_scene(String share_scene) {
		this.share_scene = share_scene;
	}
	public int getShare_user() {
		return share_user;
	}
	public void setShare_user(int share_user) {
		this.share_user = share_user;
	}
	public int getShare_count() {
		return share_count;
	}
	public void setShare_count(int share_count) {
		this.share_count = share_count;
	}

}
