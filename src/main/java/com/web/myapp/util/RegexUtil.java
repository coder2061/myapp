package com.web.myapp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**   
 * 正则判断
 */
public class RegexUtil {
	/**
	* 验证邮箱
	* 
	* @param 待验证的字符串
	* @return 如果是符合的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean isEmail(String str) {
		String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		return match(regex, str);
	}
	
	/**
	* 验证IP地址
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean isIP(String str) {
		String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
		String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
		return match(regex, str);
	}
	
	/**
	* 验证网址Url
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsUrl(String str) {
		String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
		return match(regex, str);
	}
	
	/**
	* 验证电话号码
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsTelephone(String str) {
		String regex = "^(\\d{3,4}-)?\\d{6,8}$";
		return match(regex, str);
	}
	/**
	 * 验证手机号码
	 *  
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isMobile(String str) {   
		if(str==null)
			return false;
		String regex = "^[1][0,1,2,3,4,5,6,7,8,9][0-9]{9}$";
		return match(regex, str);
    }	
	/**
	 * 短信验证码校验
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isCheckCode(String str) {   
		if(str==null)
			return false;
		String regex = "\\d{6}";
		return match(regex, str);
    }
	/**
	* 验证输入密码条件(7-16位单独数字、字母、字符或组合)
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsPassword(String str) {
		if(str==null)
			return false;
		String regex = "[\\w~!@#$%^&*();'.,/]{7,16}$";
		return match(regex, str);
	}
	/**
	* 验证支付密码条件(6位数字)
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsPayPassword(String str) {
		if(str==null)
			return false;
		String regex = "\\d{6}";
		return match(regex, str);
	}
	/**
	* 验证输入密码条件(6位不相同的数字)
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsPayPassword2(String str) {
		if(str==null)
			return false;
		String regex = "^([\\d])\\1{5}$";
		return match(regex, str);
	}
	/**
	* 验证输入密码长度 (6-18位)
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsPasswLength(String str) {
		String regex = "^\\d{6,18}$";
		return match(regex, str);
	}
	
	/**
	* 验证输入邮政编号
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsPostalcode(String str) {
		String regex = "^\\d{6}$";
		return match(regex, str);
	}
	
	/**
	* 验证输入手机号码
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsHandset(String str) {
		String regex = "^[1]+[3,5]+\\d{9}$";
		return match(regex, str);
	}
	
	/**
	* 验证输入身份证号
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsIDcard(String str) {
		String regex = "(^\\d{18}$)|(^\\d{15}$)";
		return match(regex, str);
	}
	
	/**
	* 验证输入两位小数
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsDecimal(String str) {
		String regex = "^[0-9]+(.[0-9]{2})?$";
		return match(regex, str);
	}
	
	/**
	* 验证输入一年的12个月
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsMonth(String str) {
		String regex = "^(0?[[1-9]|1[0-2])$";
		return match(regex, str);
	}
	
	/**
	* 验证输入一个月的31天
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsDay(String str) {
		String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
		return match(regex, str);
	}
	
	/**
	* 验证日期时间
	* 
	* @param 待验证的字符串
	* @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean isDate(String str) {
	// 严格验证时间格式的(匹配[2002-01-31], [1997-04-30],
	// [2004-01-01])不匹配([2002-01-32], [2003-02-29], [04-01-01])
	// String regex =
	// "^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((01,3-9])|(1[0-2]))-(29|30)))))$";
	// 没加时间验证的YYYY-MM-DD
	// String regex =
	// "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$";
	// 加了时间验证的YYYY-MM-DD 00:00:00
	String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
	return match(regex, str);
	}
	
	/**
	* 验证数字输入
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsNumber(String str) {
		String regex = "^[0-9]*$";
		return match(regex, str);
	}
	
	/**
	* 验证非零的正整数
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsIntNumber(String str) {
		String regex = "^\\+?[1-9][0-9]*$";
		return match(regex, str);
	}
	
	/**
	* 验证大写字母
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsUpChar(String str) {
		String regex = "^[A-Z]+$";
		return match(regex, str);
	}
	
	/**
	* 验证小写字母
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsLowChar(String str) {
		String regex = "^[a-z]+$";
		return match(regex, str);
	}
	
	/**
	* 验证输入字母
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsLetter(String str) {
		String regex = "^[A-Za-z]+$";
		return match(regex, str);
	}
	
	/**
	* 验证验证输入汉字
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsChinese(String str) {
		String regex = "^[\u4e00-\u9fa5],{0,}$";
		return match(regex, str);
	}
	
	/**
	* 验证验证输入字符串
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsLength(String str) {
		String regex = "^.{8,}$";
		return match(regex, str);
	}
	
	/**
	* @param regex 正则表达式字符串
	* @param str 要匹配的字符串
	* @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	*/
	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	/**  
	* 判断是否含中文字符 
	* 
	* @param str 需要校验的字符串
	* @return boolean 
	*/
	public static boolean isContainChinese(String str) {
        return checkRegex(str, "[\u4e00-\u9fa5]");
    }
	
	/**  
	* 正则校验
	* 
	* @param str 需要校验的字符串
	* @param regex 正则表达式
	* @return boolean 
	*/
	public static boolean checkRegex(String str, String regex) {
		boolean flag = false;
		Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        if (m.find()) {
        	flag = true;
        }
        return flag;
	}

}
