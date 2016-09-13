package com.web.myapp.core.exception;

/**
 * 系统业务异常处理机制（自定义异常字典）
 */
public class BizExpDictionary {
	/*###################################  定义异常编码开始     #######################################*/
	
	/**
	 * 所有配置相关的异常  都是1开头的4位数字  eg: 1xxx
	 */
	public static final String COMMONSETTINGERROR = "[ErrorCode: 1001,ErrorInfo:Can not Init The Properties Or Error!]";
	
	/**
	 * 所有参数相关的异常   都是 2开头的4位数字  eg：2xxx
	 */
	public static final String MISSPARAMETERERROR = "[ErrorCode: 2001,ErrorInfo:Missing Parameter Error!] Missing Parameters : ";
	
	/**
	 * 通用方法异常  为3开头的4位数字   eg：3xxx
	 */
	public static final String CONVERTTOVOERROR = "[ErrorCode: 3001,ErrorInfo:ConvertToVo Error!]";
	
	public static final String INJECTVOTOENTITYERROR = "[ErrorCode: 3002,ErrorInfo:InjectVoToEntity Error!]";
	
	public static final String FILEUPLOADERROR = "[ErrorCode: 3003,ErrorInfo:FileUpload Error!]";
	
	public static final String DATEFORMATERROR = "[ErrorCode: 3004,ErrorInfo:Fate Format Error!]";
	
	public static final String ENCRYPTBYPUBLICKEYERROR = "[ErrorCode: 3005,ErrorInfo:Encrypt By PublicKey Error!]";
	
	public static final String GETPUBLICKEYERROR = "[ErrorCode: 3006,ErrorInfo:Read PublicKey Error!]";
	
	public static final String INTERNALDAOERROR = "[ErrorCode: 3007,ErrorInfo:Execute SQL Error!]";
	
	public static final String NOTUSEPAGINATIONRROR = "[ErrorCode: 3008,ErrorInfo:DATA Count Is Too More, Please Use Pagination!]";
	
	public static final String DATEPATTERNERROR = "[ErrorCode: 3009,ErrorInfo:Date String Pattern Error, Correct Pattern Is 'yyyy-MM-dd hh:mm:ss' Or 'yyyy-MM-dd'!]";
	
	/**
	 * 业务方法异常  为4开头的4位数字   eg：4xxx
	 */
	public static final String MEMBERLOGINERROR = "[ErrorCode: 4001,ErrorInfo:Member Login Error!]";
	
}
