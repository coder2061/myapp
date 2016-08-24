package com.web.myapp.util;

import org.apache.log4j.Logger;

import com.web.myapp.core.config.CommonSetting;
import com.web.myapp.core.factory.IdFactory;

public class IdFactoryUtil {
	private static Logger logger = Logger.getLogger(IdFactoryUtil.class);
	
	private static IdFactory idFactory = null;
	static{
		idFactory = new IdFactory(Long.parseLong(CommonSetting.getSetting("worker_id")), 
				Long.parseLong(CommonSetting.getSetting("datacenter_id")));
	}
	/** 
	*@param worker_id 模块id
	*@param datacenter_id	组合id
	*@return  newId	新生成的id
	*@throws  FileNotFoundException
	*/
	public static String getNewId(){
		String newId =Long.toString( idFactory.nextId());
		logger.info("newId :"+newId);
		return newId;
	}

}
