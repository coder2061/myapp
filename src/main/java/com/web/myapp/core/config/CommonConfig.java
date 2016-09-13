package com.web.myapp.core.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.web.myapp.core.exception.BizExpDictionary;
import com.web.myapp.core.exception.BizException;

public class CommonConfig {
	private static Properties properties = new Properties();
	private static Logger logger = Logger.getLogger(CommonConfig.class);
	
	/**
	 * 初始化操作
	 */
    static{
		loadProperties("common.properties");
	}
    
    /**  
    * 加载配置文件 
    * 
    * @param propertiesName 配置文件全名
    */
    public static void loadProperties(String propertiesName) {
    	try {
    		InputStream is = CommonConfig.class.getClassLoader()
    				.getResourceAsStream(propertiesName);
			properties.load(new InputStreamReader(is, "UTF-8"));
		} catch (FileNotFoundException e) {
			logger.error(BizExpDictionary.COMMONSETTINGERROR + "\n" + e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.COMMONSETTINGERROR);
		}catch (IOException e) {
            logger.error(BizExpDictionary.COMMONSETTINGERROR + "\n" + e.getStackTrace());
            e.printStackTrace();
            throw new BizException(BizExpDictionary.COMMONSETTINGERROR);
        }
    }
    
    /**
     * 读取通用配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @return String properties中的配置信息
     */
    public static String getValue(String key){
    	return properties.getProperty(key);
    }
    
    /**
     * 读取通用配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @param propertiesName 配置文件全名
     * @return String properties中的配置信息
     */
    public static String getValue(String key, String propertiesName){
    	loadProperties(propertiesName);
    	return properties.getProperty(key);
    }
}
