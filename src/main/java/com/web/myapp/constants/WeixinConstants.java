package com.web.myapp.constants;
/**   
 * weixin api interface url
 * @author jiangyf   
 * @since 2016年9月19日 上午11:57:49 
 * @version V1.0   
 */
public class WeixinConstants {
	
	/***************************** weixin constants *****************************/
	
	public static final String APP_ID = "wx1c1d0d9792eb7335";
	
	public static final String APP_SRCRET = "0afbebf42d9ba9e8d46ba75ba337a091";
	

	/***************************** access_token *****************************/
	// 获取 access_token,GET方式
	public static final String HTTPS_GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// access_token有效期，单位:秒
	public static final int ACCESS_TOKEN_VALIDITY = 7200;
	// 获取js_access_token,GET方式
	public static final String HTTPS_GET_JS_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN"; 
	// 获取api_ticket
	public static final String HTTPS_GET_API_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=wx_card";
	// 获取jsapi_ticket
	public static final String HTTPS_GET_JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

	public static final String YANZHENG_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=weixin_appid&redirect_uri=weixin_url&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
	
	// 上传图文消息内图片
	public static final String HTTPS_UPLOAD_IMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

    // 创建菜单,POST方式
    public static final String HTTPS_POST_ACCESS_TOKEN_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    // 查询菜单
    public static final String HTTPS_POST_ACCESS_TOKEN_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    // 删除菜单
    public static final String HTTPS_POST_ACCESS_TOKEN_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    // 获取关注者列表
    public static final String HTTPS_POST_ACCESS_TOKEN_USERGET = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";

    // 用户信息
    public static final String HTTPS_POST_ACCESS_TOKEN_USERINFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN";

    // 查询所有分组
    public static final String HTTPS_POST_ACCESS_TOKEN_GROUPS = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";

    // 查询用户分组情况
    public static final String HTTPS_POST_ACCESS_TOKEN_GROUPSGETID = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";

    // 创建分组
    public static final String HTTPS_POST_ACCESS_TOKEN_GROUPSCREATE = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";

    // 修改分组
    public static final String HTTPS_POST_ACCESS_TOKEN_GROUPSUPDATE = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";

    // 移动用户分组
    public static final String HTTPS_POST_ACCESS_TOKEN_GROUPSMEMBERSUPDATE = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";

    // 创建临时二维码ticket
    public static final String HTTPS_POST_ACCESS_QRCODECREATE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";

    // 通过ticket换取二维码
    public static final String HTTPS_POST_ACCESS_SHOWQRCODE = "http://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
    
    // 上传临时图文消息素材
    public static final String HTTPS_POST_ACCESS_TOKEN_UPLOADNEWS = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
    														   
    // 上传永久图文消息素材
    public static final String HTTPS_POST_ACCESS_TOKEN_ADDNEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
    
    // 删除永久素材
    public static final String HTTPS_POST_DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
    
    // 根据分组进行群发 
    public static final String HTTPS_POST_ACCESS_TOKEN_MASS_DALL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
    
    // 根据OpenID列表群发 
    public static final String HTTPS_POST_ACCESS_TOKEN_MASSSEND = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
    
    public static final String IMAGE_PATH = "C:/teemlink/apache-tomcat-6.0.37/webapps";
    
    // 发送客服信息
    public static final String HTTPS_POST_ACCESS_TOKEN_CUSTOM = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    
    // 长链接转短链接
    public static final String HTTPS_POST_SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
    
    // 发送模板消息
    public static final String HTTPS_POST_MESSAGE_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    // 退款申请接口
    public static final String HTTPS_POST_REFUND = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    
    // 退款查询接口
    public static final String HTTPS_POST_REFUND_QUERY = "https://api.mch.weixin.qq.com/pay/refundquery";
    
    // 统一支付接口
    public static final String HTTPS_POST_UNIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    
    // 接收微信支付成功链接
    public static final String WX_PAY_SUCCESS_LINK ="http://location/baseName/pay/paySuccess.action";
    
    // 群发信息
    public static final String HTTPS_POST_MASS_SEND = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
    
    // 上传群发图文消息素材
    public static final String HTTPS_POST_MASS_UPLOADNEWS = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
    
    // 群发预览接口
    public static final String HTTPS_POST_MASS_PREVIEW = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
    
    // 删除群发接口
    public static final String HTTPS_POST_MASS_DELETE = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
    
    // 上传临时素材
    public static final String HTTP_POST_MEDIA_UPDATE = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    public static final String HTTPS_POST_MEDIA_UPDATE = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN";
    
    // 上传永久其他素材
    public static final String HTTP_POST_MEDIA_ADD = "http://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
    public static final String HTTPS_POST_MEDIA_ADD = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
    
    // 修改永久素材
    public static final String HTTPS_POST_UPDATE_NEWS = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
    
    // 获取永久素材列表
    public static final String HTTPS_POST_BATCHGET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
    
    // 获取临时素材https
    public static final String HTTPS_GET_MEDIA_GET = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
    
    // 获取临时素材http
    public static final String HTTP_GET_MEDIA_GET = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
    
    // 获取永久素材
    public static final String HTTPS_POST_GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
    
    // 获取素材总数
    public static final String HTTPS_GET_MATERIAL_COUNT = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
    
    // 查询群发消息推送状态
    public static final String HTTPS_POST_GET_MATMESSAGE = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";
    
    // 提交被扫支付
    public static final String HTTPS_POST_MICROPAY = "https://api.mch.weixin.qq.com/pay/micropay";
    
    // 查询订单
    public static final String HTTPS_POST_ORDER_QUERY = "https://api.mch.weixin.qq.com/pay/orderquery";
    
    // 撤销订单
    public static final String HTTPS_POST_PAY_RECERSE = "https://api.mch.weixin.qq.com/secapi/pay/reverse";
    
    // 下载对账单
    public static final String HTTPS_POST_PAY_DOWNLOADBILL = "https://api.mch.weixin.qq.com/pay/downloadbill";
    
    // 微信摇一摇
    // 申请设备id
    public static final String HTTPS_POST_DEVICE_APPLYID = "https://api.weixin.qq.com/shakearound/device/applyid?access_token=ACCESS_TOKEN";
    
    // 现金红包
    public static final String hTTPS_POST_MMPAY_SENDREDPACK = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

    // 现金红包查询
    public static final String HTTPS_POST_MMPAY_GETHBINFO = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";

    // 创建卡券
    public static final String HTTPS_POST_CARD_CREATE = "https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN";
    
    // 卡券二维码
    public static final String HTTPS_POST_QRCODE_CREATE = "https://api.weixin.qq.com/card/qrcode/create?access_token=TOKEN";

    // 卡券Code查询
    public static final String HTTPS_POST_CARD_CODE = "https://api.weixin.qq.com/card/code/get?access_token=TOKEN";
    
    // 卡券核销
    public static final String HTTPS_POST_CARD_CONSUME = "https://api.weixin.qq.com/card/code/consume?access_token=TOKEN";
    
    /***************************** 用户分析数据接口 *****************************/
    // 微信接口查询有效时间起点
    public static final String BEGIN_DATE = "2014-12-01";
    
    // 用户分析数据接口获取数据的最大时间跨度(Maximum Time Interval - MTI)
    public static final int MTI_GETUSER = 7;
    // 获取用户增减数据
    public static String HTTPS_POST_GETUSERSUMMARY = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
    // 获取累计用户数据
    public static String HTTPS_POST_GETUSERCUMULATE = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";
    
    /***************************** 图文分析数据接口 *****************************/
    // 获取图文群发每日数据 获取数据的最大时间跨度
    public static int MTI__GETARTICLESUMMARY = 1;
    // 获取图文群发总数据 获取数据的最大时间跨度
    public static int MTI__GETARTICLETOTAL = 1;
    // 获取图文统计数据 获取数据的最大时间跨度
    public static int MTI__GETUSERREAD = 3;
    // 获取图文统计分时数据 获取数据的最大时间跨度
    public static int MTI__GETUSERREADHOUR = 1;
    // 获取图文分享转发数据 获取数据的最大时间跨度
    public static int MTI__GETUSERSHARE = 7;
    // 获取图文分享转发分时数据 获取数据的最大时间跨度
    public static int MTI__GETUSERSHAREHOUR = 1;
    // 获取图文群发每日数据
    public static String HTTPS_POST_GETARTICLESUMMARY = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN";
    // 获取图文群发总数据
    public static String HTTPS_POST_GETARTICLETOTAL = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN";
    // 获取图文统计数据
    public static String HTTPS_POST_GETUSERREAD = "https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN";
    // 获取图文统计分时数据
    public static String HTTPS_POST_GETUSERREADHOUR = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN";
    // 获取图文分享转发数据
    public static String HTTPS_POST_GETUSERSHARE = "https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN";
    // 获取图文分享转发分时数据
    public static String HTTPS_POST_GETUSERSHAREHOUR = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN";
    
    /***************************** 消息分析数据接口 *****************************/
    // 获取消息发送概况数据 获取数据的最大时间跨度
    public static int MTI__GETUPSTREAMMSG = 7;
    // 获取消息分送分时数据 获取数据的最大时间跨度
    public static int MTI__GETUPSTREAMMSGHOUR = 1;
    // 获取消息发送周数据 获取数据的最大时间跨度
    public static int MTI__GETUPSTREAMMSGWEEK = 30;
    // 获取消息发送月数据 获取数据的最大时间跨度
    public static int MTI__GETUPSTREAMMSGMONTH = 30;
    // 获取消息发送分布数据 获取数据的最大时间跨度
    public static int MTI__GETUPSTREAMMSGDIST = 15;
    // 获取消息发送分布周数据 获取数据的最大时间跨度
    public static int MTI__GETUPSTREAMMSGDISTWEEK = 30;
    // 获取消息发送分布月数据 获取数据的最大时间跨度
    public static int MTI__GETUPSTREAMMSGDISTMONTH = 30;
    // 获取消息发送概况数据
    public static String HTTPS_POST_GETUPSTREAMMSG = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN";
    // 获取消息分送分时数据
    public static String HTTPS_POST_GETUPSTREAMMSGHOUR = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN";
    // 获取消息发送周数据
    public static String HTTPS_POST_GETUPSTREAMMSGWEEK = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN";
    // 获取消息发送月数据
    public static String HTTPS_POST_GETUPSTREAMMSGMONTH = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN";
    // 获取消息发送分布数据
    public static String HTTPS_POST_GETUPSTREAMMSGDIST = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN";
    // 获取消息发送分布周数据
    public static String HTTPS_POST_GETUPSTREAMMSGDISTWEEK = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN";
    // 获取消息发送分布月数据
    public static String HTTPS_POST_GETUPSTREAMMSGDISTMONTH = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN";
    
    /***************************** 接口分析数据接口 *****************************/
    // 获取接口分析数据接口 获取数据的最大时间跨度
    public static int MTI_GETINTERFACESUMMARY = 30;
    // 获取接口分析分时数据接口 获取数据的最大时间跨度
    public static int MTI_GETINTERFACESUMMARYHOUR = 1;
    // 获取接口分析数据
    public static String HTTPS_POST_GETINTERFACESUMMARY = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN";
    // 获取接口分析分时数据
    public static String HTTPS_POST_GETINTERFACESUMMARYHOUR = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN";

}
