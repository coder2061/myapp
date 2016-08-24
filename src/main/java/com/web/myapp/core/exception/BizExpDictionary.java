package com.web.myapp.core.exception;

public class BizExpDictionary {
	/*###################################    定义异常编码开始     #######################################*/
	
	/*
	 * 所有参数相关的异常   都是 1开头的4位数字  ex：1xxx
	 */
	public static final String MISSPARAMETERERROR = "[ErrorCode: 1001,ErrorInfo:Missing Parameter Error!] Missing Parameters : ";
	
	/*
	 * 所有业务相关的异常  都是 2开头的4位数字 ex:2xxx
	 * 通用方法异常  为20开头的4位数字   20xx 如 2001 CONVERTTOVOERROR
	 * 业务方法异常  为21开头的4位数字   21xx 如 2101 
	 */
	/**
	 * 通用异常
	 */
	public static final String CONVERTTOVOERROR = "[ErrorCode: 2001,ErrorInfo:ConvertToVo Error!]";
	
	public static final String INJECTVOTOENTITYERROR = "[ErrorCode: 2002,ErrorInfo:InjectVoToEntity Error!]";
	
	public static final String FILEUPLOADERROR = "[ErrorCode: 2003,ErrorInfo:FileUpload Error!]";
	
	public static final String DATEFORMATERROR = "[ErrorCode: 2004,ErrorInfo:Fate Format Error!]";
	
	public static final String ENCRYPTBYPUBLICKEYERROR = "[ErrorCode: 2005,ErrorInfo:Encrypt By PublicKey Error!]";
	
	public static final String GETPUBLICKEYERROR = "[ErrorCode: 2006,ErrorInfo:Read PublicKey Error!]";
	
	public static final String INTERNALDAOERROR = "[ErrorCode: 2007,ErrorInfo:Execute SQL Error!]";
	
	public static final String NOTUSEPAGINATIONRROR = "[ErrorCode: 2008,ErrorInfo:DATA Count Is Too More, Please Use Pagination!]";
	
	public static final String DATEPATTERNERROR = "[ErrorCode: 2009,ErrorInfo:Date String Pattern Error, Correct Pattern is 'yyyy-MM-dd hh:mm:ss' or 'yyyy-MM-dd'!]";
	/**
	 * 业务异常
	 */
	public static final String MEMBERLOGINERROR = "[ErrorCode: 2101,ErrorInfo:member Login Error!]";
	/*
	 * 所有配置相关的异常  都是 3开头的4位数字 ex:3xxx
	 */
	public static final String COMMONSETTINGERROR = "[ErrorCode: 3001,ErrorInfo:Can not init common-setting.properties Error!]";
	
	
	
	
}
