package com.web.myapp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**   
 * 正则判断
 */
public class RegexUtil {
	
	/**  
	* 判断是否含中文字符 
	* @param str 需要校验的字符串
	* @return boolean 
	*/
	public static boolean isContainChinese(String str) {
        return checkRegex(str, "[\u4e00-\u9fa5]");
    }
	
	/**  
	* 正则校验
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
