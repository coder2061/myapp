package com.web.myapp.weixin.model;
/**   
 * 微信公众号
 * @author jiangyf   
 * @since 2016年9月23日 上午9:29:08 
 * @version V1.0   
 */
public class WeixinPublic {
	private String id;
	// 编号
	private String weixinId;
	// 名称
	private String weixinName;
	// 微信号
	private String weixinNo;
	// 原始id
	private String weixinOldId;
	// 微信凭证
	private String weixinAppId;
	// 微信凭证密钥
	private String weixinAppsecret;
	
	private String weixinUrl;
	
	private String weixinToken;
	
	private String weixinLogo;
	// 二维码
	private String weixinEwm;
	// 介绍
	private String remark;
	// 关键字
	private String gjc;
	// 网站地址
	private String website;
	// 微信安全识别ID
	private String openid;
	// 多公众号和应用绑定同一平台ID
	private String UnionID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWeixinId() {
		return weixinId;
	}

	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}

	public String getWeixinName() {
		return weixinName;
	}

	public void setWeixinName(String weixinName) {
		this.weixinName = weixinName;
	}

	public String getWeixinNo() {
		return weixinNo;
	}

	public void setWeixinNo(String weixinNo) {
		this.weixinNo = weixinNo;
	}

	public String getWeixinOldId() {
		return weixinOldId;
	}

	public void setWeixinOldId(String weixinOldId) {
		this.weixinOldId = weixinOldId;
	}

	public String getWeixinAppId() {
		return weixinAppId;
	}

	public void setWeixinAppId(String weixinAppId) {
		this.weixinAppId = weixinAppId;
	}

	public String getWeixinAppsecret() {
		return weixinAppsecret;
	}

	public void setWeixinAppsecret(String weixinAppsecret) {
		this.weixinAppsecret = weixinAppsecret;
	}

	public String getWeixinUrl() {
		return weixinUrl;
	}

	public void setWeixinUrl(String weixinUrl) {
		this.weixinUrl = weixinUrl;
	}

	public String getWeixinToken() {
		return weixinToken;
	}

	public void setWeixinToken(String weixinToken) {
		this.weixinToken = weixinToken;
	}

	public String getWeixinLogo() {
		return weixinLogo;
	}

	public void setWeixinLogo(String weixinLogo) {
		this.weixinLogo = weixinLogo;
	}

	public String getWeixinEwm() {
		return weixinEwm;
	}

	public void setWeixinEwm(String weixinEwm) {
		this.weixinEwm = weixinEwm;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGjc() {
		return gjc;
	}

	public void setGjc(String gjc) {
		this.gjc = gjc;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUnionID() {
		return UnionID;
	}

	public void setUnionID(String unionID) {
		UnionID = unionID;
	}

}
