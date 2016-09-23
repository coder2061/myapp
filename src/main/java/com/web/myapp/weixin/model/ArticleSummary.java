package com.web.myapp.weixin.model;
/** 
 * 图文群发每日数据   
 */
public class ArticleSummary {
	// 数据的日期，需在begin_date和end_date之间
	private String ref_date;
	/*
	 * 请注意：
	 * 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 
	 * 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 
	 * 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 */
	private String msgid;
	// 图文消息的标题
	private String title;
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
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
