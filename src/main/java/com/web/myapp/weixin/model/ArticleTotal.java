package com.web.myapp.weixin.model;

import java.util.List;

/** 
 * 图文群发总数据   
 */
public class ArticleTotal {
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
	// 图文群发总数据详情
	List<ArticleTotalDetail> details;
	
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
	public List<ArticleTotalDetail> getDetails() {
		return details;
	}
	public void setDetails(List<ArticleTotalDetail> details) {
		this.details = details;
	}

}
