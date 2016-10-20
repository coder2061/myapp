package com.web.myapp.core.config;

import com.web.myapp.util.CommonUtil;

public class BizDictionary {
	/*###################################  定义通用常用常量    #######################################*/
	public static final String FAILURE = "failure";
	public static final String SUCESS = "success";
	public static final String MISS_PARAMETER = "缺少参数";
	public static final String NULL_DATA = "查询结果为空，查询参数为：";
	public static final String FILE_ROOT_DIR = CommonUtil.isEmpty(System.getProperty("catalina.home")) ? "" : System.getProperty("catalina.home");
	
	/*##################################  定义极光推送申请的常量     #######################################*/
	public static final String masterSecret = "9c522a800aba11c42f22eb20";
	public static final String appKey = "51df38344a81449955ecc400";
	
}
