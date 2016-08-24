package com.web.myapp.core.config;

import com.web.myapp.util.CommonUtil;

public class BizDictionary {
	/*###################################    定义业务编码常量    #######################################*/
	public static final String CODE_CARWASH = "COCW";
	public static final String CODE_PAYMENT = "COPM";
	
	/*###################################    定义通用常用常量    #######################################*/
	public static final String FAILURE = "failure";
	public static final String SUCESS = "success";
	public static final String MISS_PARAMETER = "缺少参数";
	public static final String NULL_DATA = "查询结果为空，查询参数为：";
	public static final String FILE_ROOT_DIR = CommonUtil.isEmpty(System.getProperty("catalina.home")) ? "" : System.getProperty("catalina.home");
	
	/*###################################    定义订单常量    #######################################*/
	//订单状态
	public static final Integer ORDER_UNCONFIRMED = 0;//订单未确认
	public static final Integer ORDER_CANCELLED= 1;//订单被取消
	public static final Integer ORDER_CONFIRMED = 2;//订单已确认，待支付
	public static final Integer ORDER_PAID_OFF = 3;//订单已支付，待发货
	public static final Integer ORDER_DELIVERED = 4;//订单已发货
	public static final Integer ORDER_RETURNED = 5;//订单退单
	public static final Integer ORDER_REFUNDED = 6;//订单退款
	public static final Integer ORDER_FINISHED = 7;//订单完成
	//支付状态
	public static final Integer PAYMENT_UNPAID = 0;//未支付
	public static final Integer PAYMENT_PAID= 1;//已支付
	
	//配送状态
	public static final Integer SHIPPING_NULL = 0;//没有物流状态（订单尚未支付）
	public static final Integer SHIPPING_IN_PREPARATION = 1;//准备中
	public static final Integer PAYMENT_OUTED= 2;//已出发
	/*##################################    定义激光推送申请的常量     #######################################*/
	public static final String masterSecret = "9c522a800aba11c42f22eb20";
	public static final String appKey = "51df38344a81449955ecc400";
	/*##################################    定义支付宝申请的常量     #######################################*/
	public static final String partner = "2088911887012780";
	/*##################################    定义微信支付申请的常量     #######################################*/
	public static final String IOS_APPKEY = "715d75b6f88d8a837fed487e46186d6b";
	public static final String ANDROID_APPKEY = "aop0KyEaI2hJK0Gc9bqcocJX46IKIvNF";
	//商户号
	public static final String ANDROID_PARTNERKEY = "1247812301";
	
	public static final String IOS_APPSECRET = "715d75b6f88d8a837fed487e46186d6b";
	public static final String ANDROID_APPSECRET = "9ddf371688f951f01f2b7828262867c1";
	public static final String IOS_PARTNERKEY = "1247808201";
}
