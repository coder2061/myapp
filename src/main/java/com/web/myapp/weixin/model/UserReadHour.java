package com.web.myapp.weixin.model;
/** 
 * 图文统计分时数据  
 */
public class UserReadHour {
	// 数据的日期，需在begin_date和end_date之间
	private String ref_date;
	// 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	private int ref_hour;
	// 在获取图文阅读分时数据时才有该字段，代表用户从哪里进入来阅读该图文。0:会话;1.好友;2.朋友圈;3.腾讯微博;4.历史消息页;5.其他
	private String user_source;
	// 图文页（点击群发图文卡片进入的页面）的阅读人数
	private int int_page_read_user;
	// 图文页的阅读次数
	private int int_page_read_count;
	// 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
	private int ori_page_read_user;
	// 原文页的阅读次数
	private int ori_page_read_count;
	// 分享的人数
	private int share_user;
	// 分享的次数
	private int share_count;
	// 收藏的人数
	private int add_to_fav_user;
	// 收藏的次数
	private int add_to_fav_count;
	
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
	public String getUser_source() {
		return user_source;
	}
	public void setUser_source(String user_source) {
		this.user_source = user_source;
	}
	public int getInt_page_read_user() {
		return int_page_read_user;
	}
	public void setInt_page_read_user(int int_page_read_user) {
		this.int_page_read_user = int_page_read_user;
	}
	public int getInt_page_read_count() {
		return int_page_read_count;
	}
	public void setInt_page_read_count(int int_page_read_count) {
		this.int_page_read_count = int_page_read_count;
	}
	public int getOri_page_read_user() {
		return ori_page_read_user;
	}
	public void setOri_page_read_user(int ori_page_read_user) {
		this.ori_page_read_user = ori_page_read_user;
	}
	public int getOri_page_read_count() {
		return ori_page_read_count;
	}
	public void setOri_page_read_count(int ori_page_read_count) {
		this.ori_page_read_count = ori_page_read_count;
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
	public int getAdd_to_fav_user() {
		return add_to_fav_user;
	}
	public void setAdd_to_fav_user(int add_to_fav_user) {
		this.add_to_fav_user = add_to_fav_user;
	}
	public int getAdd_to_fav_count() {
		return add_to_fav_count;
	}
	public void setAdd_to_fav_count(int add_to_fav_count) {
		this.add_to_fav_count = add_to_fav_count;
	}

}
