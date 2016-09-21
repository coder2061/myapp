package com.web.myapp.weixin.entity;

/**
 * 微信用户分析数据
 */
public class WeixinUser {
	// 微信ID
	private String weixinId;
	// 数据日期
	private String refDate;
	// 用户关注渠道
	private String userSource;
	// 新增用户数量
	private int newUser;
	// 取消关注用户数量
	private int cancelUser;
	// 累计总用户数量
	private long cumulateUser;
	
	public String getWeixinId() {
		return weixinId;
	}
	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}
	public String getRefDate() {
		return refDate;
	}
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}
	public String getUserSource() {
		return userSource;
	}
	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}
	public int getNewUser() {
		return newUser;
	}
	public void setNewUser(int newUser) {
		this.newUser = newUser;
	}
	public int getCancelUser() {
		return cancelUser;
	}
	public void setCancelUser(int cancelUser) {
		this.cancelUser = cancelUser;
	}
	public long getCumulateUser() {
		return cumulateUser;
	}
	public void setCumulateUser(long cumulateUser) {
		this.cumulateUser = cumulateUser;
	}
	
}
