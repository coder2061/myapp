/**
 * 判断页面访问方式PC&电脑
 */
//最简洁版
function browserRedirect(type) { 
	var sUserAgent= navigator.userAgent.toLowerCase(); 
	var bIsIpad= sUserAgent.match(/ipad/i) == "ipad"; 
	var bIsIphoneOs= sUserAgent.match(/iphone os/i) == "iphone os"; 
	var bIsMidp= sUserAgent.match(/midp/i) == "midp"; 
	var bIsUc7= sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4"; 
	var bIsUc= sUserAgent.match(/ucweb/i) == "ucweb"; 
	var bIsAndroid= sUserAgent.match(/android/i) == "android"; 
	var bIsCE= sUserAgent.match(/windows ce/i) == "windows ce"; 
	var bIsWM= sUserAgent.match(/windows mobile/i) == "windows mobile"; 
	 
	if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) { 
		window.location.href= '/ctcshop/m/rhylogin.shtml'; 
		//alert("这是手机");
	} else { 
		window.location= '/etrade/login.shtml?ref_url=/rhy/index.html'; 
		//alert("这是电脑");
	} 
} 

//方法1：
function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = ["Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod"];
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}


//方法2：
function browserRedirect() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if (!(bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) ){
        window.location.href=B页面;
    }
}
browserRedirect();

//方法3：
var browser = {
    versions : function() {
        var u = navigator.userAgent, app = navigator.appVersion;
        return {//移动终端浏览器版本信息                                 
	        trident : u.indexOf('Trident') > -1, //IE内核                                 
	        presto : u.indexOf('Presto') > -1, //opera内核                                 
	        webKit : u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核                                 
	        gecko : u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核                                
	        mobile : !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/), //是否为移动终端                                 
	        ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端                 
	        android : u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器                                 
	        iPhone : u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器                    
	        iPad: u.indexOf('iPad') > -1, //是否iPad       
	        webApp : u.indexOf('Safari') == -1,//是否web应该程序，没有头部与底部
	        google: u.indexOf('Chrome') > -1
	    };
    }(),language : (navigator.browserLanguage || navigator.language).toLowerCase()
}
document.writeln("语言版本: "+browser.language);
document.writeln(" 是否为移动终端: "+browser.versions.mobile);