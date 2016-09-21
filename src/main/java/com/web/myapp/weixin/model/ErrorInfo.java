package com.web.myapp.weixin.model;
/**   
 * Function: 请求出错响应信息
 * @author jiangyf   
 * @since 2016年9月21日 上午11:51:36 
 * @version V1.0   
 */
public class ErrorInfo {
	// 错误编码
	private String errcode;
	// 错误提示
    private String errmsg;
    
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
