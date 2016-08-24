package com.web.myapp.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.web.myapp.core.exception.BizExpDictionary;
import com.web.myapp.core.exception.BizException;

public class MessageUtil {
	private static Logger logger = Logger.getLogger(MessageUtil.class);
	
	private static Properties carMessage = new Properties();
	private static Properties memberMessage = new Properties();
	private static Properties storeMessage = new Properties();
	private static Properties orderMessage = new Properties();
	private static Properties paymentMessage = new Properties();
	private static Properties areaMessage = new Properties();
	private static Properties currencyMessage = new Properties();
	

	/**
	 * 初始化操作
	 */
	static {
		try {
			carMessage.load(new InputStreamReader(MessageUtil.class
					.getClassLoader().getResourceAsStream(
							"messages/carMessage.properties"), "UTF-8"));
			memberMessage.load(new InputStreamReader(MessageUtil.class
					.getClassLoader().getResourceAsStream(
							"messages/memberMessage.properties"), "UTF-8"));
			storeMessage.load(new InputStreamReader(MessageUtil.class
					.getClassLoader().getResourceAsStream(
							"messages/storeMessage.properties"), "UTF-8"));
			paymentMessage.load(new InputStreamReader(MessageUtil.class
					.getClassLoader().getResourceAsStream(
							"messages/paymentMessage.properties"), "UTF-8"));
			orderMessage.load(new InputStreamReader(MessageUtil.class
					.getClassLoader().getResourceAsStream(
							"messages/orderMessage.properties"), "UTF-8"));
			areaMessage.load(new InputStreamReader(MessageUtil.class
					.getClassLoader().getResourceAsStream(
							"messages/areaMessage.properties"), "UTF-8"));
			currencyMessage.load(new InputStreamReader(MessageUtil.class
					.getClassLoader().getResourceAsStream(
							"messages/currencyMessage.properties"), "UTF-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(BizExpDictionary.COMMONSETTINGERROR + "\n"
					+ e.getStackTrace());
			throw new BizException(BizExpDictionary.COMMONSETTINGERROR);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(BizExpDictionary.COMMONSETTINGERROR + "\n"
					+ e.getStackTrace());
			throw new BizException(BizExpDictionary.COMMONSETTINGERROR);
		}
	}
	
	/**
     * 读取车辆信息配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @return properties中的文字信息
     */
    public static String getCarMessage(String key){
    	return carMessage.getProperty(key);
    }
    
    /**
     * 读取用户信息配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @return properties中的文字信息
     */
    public static String getMemberMessage(String key){
    	return memberMessage.getProperty(key);
    }
    
    /**
     * 读取商铺信息配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @return properties中的文字信息
     */
    public static String getStoreMessage(String key){
    	return storeMessage.getProperty(key);
    }
    
    
    /**
     * 读取订单信息配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @return properties中的文字信息
     */
    public static String getOrderMessage(String key){
    	return orderMessage.getProperty(key);
    }
    /**
     * 读取支付配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @return properties中的文字信息
     */
    public static String getPaymentMessage(String key){
    	return paymentMessage.getProperty(key);
    }
    /**
     * 读取区域配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @return properties中的文字信息
     */
    public static String getAreaMessage(String key){
    	return areaMessage.getProperty(key);
    }
    /**
     * 读取钱包配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @return properties中的文字信息
     */
    public static String getCurrencyMessage(String key){
    	return currencyMessage.getProperty(key);
    }
}
