package com.web.myapp.weixin.model;

/**   
 * Function: 微信公众号的全局唯一接口调用凭据 
 * @author jiangyf   
 * @since 2016年9月23日 上午10:58:26 
 * @version V1.0   
 */
public class AccessToken extends WXBase {
	private static final long serialVersionUID = 3369959244731561810L;
	
	// 获取到的凭证
    private String access_token;
    // 凭证有效时间，单位：秒
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

}
