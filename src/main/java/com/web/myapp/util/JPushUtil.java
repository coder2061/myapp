package com.web.myapp.util;

import org.apache.log4j.Logger;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import com.web.myapp.core.config.BizDictionary;

/**
 * 极光推送工具类
 * 
 * https://github.com/jpush/jpush-api-java-client ---参考文档
 */
public class JPushUtil {
	private static Logger logger = Logger.getLogger(JPushUtil.class);
	private static JPushClient jpushClient = null;
	private static PushPayload payload = null;
	
	static {
		jpushClient = new JPushClient(BizDictionary.masterSecret, BizDictionary.appKey, 1);
	}

	/**
	 * 构建推送对象：所有平台，推送目标是别名为 "alias"，通知内容为 ALERT。
	 * 
	 * @param alias
	 * @param alert
	 */
	public static PushResult buildPushObject_all_alias_alert(String alias,
			String alert) {
		payload = PushPayload.newBuilder().setPlatform(Platform.all())
				.setAudience(Audience.alias(alias))
				.setNotification(Notification.alert(alert)).build();
		return push(payload);
	}
	
	/**
	 * 构建推送对象：所有平台，推送目标是registerId为 "registerId"，通知内容为 ALERT。
	 * 
	 * @param registerId
	 * @param alert
	 */
	public static PushResult buildPushObject_all_registerId_alert(String registerId,
			String alert) {
		payload = PushPayload.newBuilder().setPlatform(Platform.all())
				.setAudience(Audience.alias(registerId))
				.setNotification(Notification.alert(alert)).build();
		return push(payload);
	}

	/**
	 * 快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知。
	 * 
	 * @param alert
	 */
	public static PushResult buildPushObject_all_all_alert(String alert) {
		payload = PushPayload.alertAll(alert);
		return push(payload);
	}

	/**  
	* 构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE。
	*  
	* @param tag
	* @param alert
	* @param title
	* @return PushResult 
	*/
	public static PushResult buildPushObject_android_tag_alertWithTitle(
			String tag, String alert, String title) {
		payload = PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(Audience.tag(tag))
				.setNotification(Notification.android(alert, title, null))
				.build();
		return push(payload);
	}

	/**  
	* 推送消息
	* 
	* @param payload
	* @return PushResult 
	*/
	public static PushResult push(PushPayload payload) {
		PushResult result = null;
		try {
			result = jpushClient.sendPush(payload);
		} catch (APIConnectionException e) {
			logger.error("Connection error, should retry later", e);
		} catch (APIRequestException e) {
			logger.error("Should review the error, and fix the request", e);
			logger.info("HTTP Status: " + e.getStatus());
			logger.info("Error Code: " + e.getErrorCode());
			logger.info("Error Message: " + e.getErrorMessage());
		}
		return result;
	}

}
