package com.web.myapp.core.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.web.myapp.core.exception.BizExpDictionary;
import com.web.myapp.core.exception.BizException;

public class CommonSetting {
	private static Properties commonSetting = new Properties();
	private static Logger logger = Logger.getLogger(CommonSetting.class);
	
	/**
	 * 初始化操作
	 */
    static{
		try {
			commonSetting.load(new InputStreamReader(CommonSetting.class.getClassLoader().getResourceAsStream(
				"common-setting.properties"), "UTF-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(BizExpDictionary.COMMONSETTINGERROR + "\n"
					+ e.getStackTrace());
			throw new BizException(BizExpDictionary.COMMONSETTINGERROR);
		}catch (IOException e) {
            e.printStackTrace();
            logger.error(BizExpDictionary.COMMONSETTINGERROR + "\n"
					+ e.getStackTrace());
            throw new BizException(BizExpDictionary.COMMONSETTINGERROR);
        }
	}
    
    /**
     * 读取通用配置文件中的信息
     * 
     * @param key 文字信息对应的key
     * @return properties中的文字信息
     * @throws FileNotFoundException
     */
    public static String getSetting(String key){
    	return commonSetting.getProperty(key);
    }
}
