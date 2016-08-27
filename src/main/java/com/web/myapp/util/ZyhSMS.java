package com.web.myapp.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class ZyhSMS{

	protected static  Logger log =  Logger.getLogger(ZyhSMS.class);
	private final static String SMS_URL = "http://www.jc-chn.cn/smsSend.do";

	
	public String sendMsg(String phone, String content, String account, String pwd) {
		log.info("===================短信发送开始======================");
		StringBuffer params = new StringBuffer();
		params.append("username=").append(account);
		params.append("&password=").append(MD5Utils.String2MD5(account+MD5Utils.String2MD5(pwd)));
		params.append("&mobile=").append(phone);
		long result = 0;
		try {
			params.append("&content="+URLEncoder.encode(content,"utf-8"));
			params.append("&dstime=");
			log.info("短信地址："+ SMS_URL);
			log.info("短信参数："+params.toString());
			result = Long.parseLong(HTTPUtils.sendPost(SMS_URL, params.toString()));
			log.info("短信返回信息："+result);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("短信出现问题："+ e);
		}
		String msg = "failed";
		if(result >= 0){
			msg = "100";
		}
		log.info("接口返回值：" + msg);
		return msg;
	}

}
