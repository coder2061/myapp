package com.web.myapp.weixin.tools;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.web.myapp.constants.WeixinConstants;
import com.web.myapp.core.cache.CacheEntity;
import com.web.myapp.core.cache.CacheManager;
import com.web.myapp.util.HTTPUtils;
import com.web.myapp.weixin.model.AccessToken;

/**   
 * Function: 微信通用接口
 * @author jiangyf   
 * @since 2016年9月21日 上午11:37:22 
 * @version V1.0   
 */
public class WeixinCommon {
	
	private static final Gson gson = new Gson();
	
	/**
	 * 获取access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;
		CacheEntity cache = CacheManager.getCacheInfo(appid);
		if (cache == null || cache.isExpired()) {
			accessToken = resetAccessToken(appid, appsecret);
		} else {
			accessToken = (AccessToken) cache.getValue();
		}
		return accessToken;
	}
	
	/**
	 * 重置access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 */
	public static AccessToken resetAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;
		String requestUrl = WeixinConstants.HTTPS_GET_ACCESS_TOKEN
				.replace("APPID", appid).replace("APPSECRET", appsecret);
//		String result = HTTPUtils.postClient(requestUrl, "GET", null);
		String result = HTTPUtils.sendGet(requestUrl);
		if (result != null && !result.equals("")) {
			accessToken = gson.fromJson(result, AccessToken.class);
			String access_token = accessToken.getAccess_token();
			if (access_token != null && !access_token.equals("")) {
				CacheManager.putCacheInfo(appid, accessToken, 
						(accessToken.getExpires_in() - 1000) * 1000);
			}
		}
		return accessToken;
	}
	
	/**
	 * 获取js_access_token
	 * 
	 * @param appid 凭证
	 */
	public static String getJsAccessToken(String appid) {
		String accessToken = null;
		CacheEntity cache = CacheManager.getCacheInfo("js_"+appid);
		if (cache == null || cache.isExpired()) {
			String requestUrl = WeixinConstants.HTTPS_GET_JS_ACCESS_TOKEN
					.replace("APPID", appid);
			String result = HTTPUtils.postClient(requestUrl, "GET", null);
			if (result != null && !result.equals("")&& result.indexOf("errcode")<0) {
				JSONObject accesstoken = JSONObject.fromObject(result);
				CacheManager.putCacheInfo("js_"+appid, result, 
						(accesstoken.getLong("expires_in") - 1000) * 1000);
			}
		} else {
			accessToken = (String)cache.getValue();
		}
		return accessToken;
	}
	
	/**
	 * 获取api_ticket
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 */
	public static String getApiTicket(String appid, String appsecret) {
		CacheEntity cache = CacheManager.getCacheInfo("wxcapi"+appid);
		String result = "";
		if (cache == null ||cache.isExpired()) {
			result = resetApiTicket(appid, appsecret);
		} else {
			result = cache.getValue().toString();
		}
		return result;
	}
	
	/**
	 * 重置api_ticket
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 */
	public static String resetApiTicket(String appid, String appsecret) {
		String result = "";
		AccessToken accessToken = getAccessToken(appid, appsecret);
		String requestUrl = WeixinConstants.HTTPS_GET_API_TICKET
				.replace("ACCESS_TOKEN", accessToken.getAccess_token());
		result = HTTPUtils.postClient(requestUrl, "GET", null);
		if(result.indexOf("40001") > 0) {
			accessToken = resetAccessToken(appid, appsecret);
			result = HTTPUtils.postClient(requestUrl, "GET", null);
		}
		JSONObject json = JSONObject.fromObject(result);
		if (json.getInt("errcode") == 0) {
			CacheManager.putCacheInfo("wxcapi"+appid, result, 
					(json.getInt("expires_in") - 1000) * 1000);
		}
		return result;
	}
	
	/**
	 * 获取jsapi_ticket
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 */
	public static String getJsapiTicket(String appid, String appsecret) {
		CacheEntity cache = CacheManager.getCacheInfo("jsapi"+appid);
		String result = "";
		if (cache == null ||cache.isExpired() ) {
			result = resetJsapiTicket(appid, appsecret);
		} else {
			result = cache.getValue().toString();
		}
		return result;
	}
	
	/**
	 * 重置jsapi_ticket
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 */
	public static String resetJsapiTicket(String appid, String appsecret) {
		String result = "";
		AccessToken accessToken = getAccessToken(appid, appsecret);
		String requestUrl = WeixinConstants.HTTPS_GET_JSAPI_TICKET
				.replace("ACCESS_TOKEN", accessToken.getAccess_token());
		result = HTTPUtils.postClient(requestUrl, "GET", null);
		if(result.indexOf("40001") > 0) {
			accessToken = resetAccessToken(appid, appsecret);
			result = HTTPUtils.postClient(requestUrl, "GET", null);
		}
		JSONObject json = JSONObject.fromObject(result);
		if (json.getInt("errcode") == 0) {
			CacheManager.putCacheInfo("jsapi"+appid, result, 
					(json.getInt("expires_in") - 1000) * 1000);
		}
		return result;
	}
	
	/**
	 * 文件上传到微信服务器
	 * 
	 * @param uploadType 0临时上传；1永久上传
     * @param fileType 文件类型
     * @param filePath 文件路径
     * @param accessToken
	 * @return JSONObject
	 * @throws Exception
	 */
	public String upload(String uploadType, String fileType, String filePath, 
			String accessToken) throws Exception {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}
		String url = WeixinConstants.HTTP_POST_MEDIA_ADD.replace("ACCESS_TOKEN",
				accessToken).replace("TYPE", fileType);
		if ("0".equals(uploadType)) {
			url = WeixinConstants.HTTP_POST_MEDIA_UPDATE.replace("ACCESS_TOKEN",
					accessToken).replace("TYPE", fileType);
		}
		String result = HTTPUtils.httpPost(file, url);
		return result;
	}
	
	/**
     * 文件上传到微信服务器
     * 
     * @param uploadType 0临时上传；1永久上传
     * @param fileType 文件类型
     * @param filePath 文件路径
     * @param accessToken
     * @return JSONObject
     * @throws Exception
     */
	public static String send(String uploadType, String fileType, String filePath, 
			String accessToken) throws Exception {  
        File file = new File(filePath);  
        if (!file.exists() || !file.isFile()) {  
            throw new IOException("文件不存在");  
        }  
		String url = WeixinConstants.HTTPS_POST_MEDIA_ADD.replace("ACCESS_TOKEN", accessToken);
		if("0".equals(uploadType)){
			url = WeixinConstants.HTTPS_POST_MEDIA_UPDATE.replace("ACCESS_TOKEN", accessToken);
		}
		String BOUNDARY = "----------" + System.currentTimeMillis();  
		// 设置边界  
        String contentType = "multipart/form-data; boundary=" + BOUNDARY;  
        String filename = file.getName();
        long filelength = file.length();
        String params = "{'type':'"+fileType+"','media':['filename':'"+filename+"','filelength':"+filelength+",'content-type':'"+contentType+"']}";
        return HTTPUtils.postClient(url, file, params, fileType) ; 
    }
	
	public static void main(String[] args) throws Exception {
//		String str = "{\"expires_in\":0,\"errcode\":\"4001\",\"errmsg\":\"error\"}";
//		AccessToken accessToken = gson.fromJson(str, AccessToken.class);
//		System.out.println(gson.toJson(accessToken));
//		System.out.println(send("1","image","C:/d8163c4f-f09d-442e-87a7-f6d86ef80af3.jpg","bcmgHL98-KELsOhoPLlER2_C_AiZCd3F3QLvm7v-XtoIog-RFPQpGVT9K9e6S2SQMwMIdqfND6L5IvejLnQSIPstMQxWP9hlqiylHErv_3I"));
		System.out.println(WeixinCommon.getAccessToken(WeixinConstants.APP_ID, WeixinConstants.APP_SRCRET).getAccess_token());
	}

}
