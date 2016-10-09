package com.web.myapp.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StringUtils {
	/*
	 * URL编码(Freemarker)
	 */
	public static String encode(String e_string,String method){
		String r_string = "";
		try {
			if("POST".equalsIgnoreCase(method))
				r_string =  URLEncoder.encode(e_string, "UTF-8");
			else
				r_string = URLEncoder.encode(URLEncoder.encode(e_string, "UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return r_string;
	}
	/*
	 * URL解码(Freemarker)
	 */
	public static String decode(String d_string,String method){
		String r_string = "";
		try {
			r_string = URLDecoder.decode(d_string, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return r_string;
	}
	
	/** 
	* @Title: formateRate 
	* @Description: 保留小数点后两位 
	* @param rateDouble
	* @return String
	*/
	public static String formateRate(double rateDouble){  
    	String rateStr = String.valueOf(rateDouble);
        if(rateStr.indexOf(".") != -1){  
            //获取小数点的位置  
            int num = rateStr.indexOf(".");  
            //获取小数点后面的数字 是否有两位 不足两位补足两位  
            String dianAfter = rateStr.substring(0,num+1);  
            String afterData = rateStr.replace(dianAfter, "");  
            if(afterData.length() < 2){  
               afterData = afterData + "0" ;  
            } 
            return rateStr.substring(0,num) + "." + afterData.substring(0,2);  
         }else{  
           if(rateStr == "1"){  
              return "100";  
           }else{  
               return rateStr;  
           }  
         }  
	}
	
	private static Map<Integer, String> numberStringMap = new HashMap<Integer, String>();
    private static Map<Integer, String> base10StringMap = new HashMap<Integer, String>();
	static {  
        numberStringMap.put(0, "零");  
        numberStringMap.put(1, "一");  
        numberStringMap.put(2, "二");  
        numberStringMap.put(3, "三");  
        numberStringMap.put(4, "四");  
        numberStringMap.put(5, "五");  
        numberStringMap.put(6, "六");  
        numberStringMap.put(7, "七");  
        numberStringMap.put(8, "八");  
        numberStringMap.put(9, "九");  
  
        base10StringMap.put(1, "");  
        base10StringMap.put(2, "十");  
        base10StringMap.put(3, "百");  
        base10StringMap.put(4, "千");  
        base10StringMap.put(5, "万");  
    }  
    
    /** 
    * @Title: processSplitedNumber 
    * @Description: 转换成大写
    * @param num
    * @param time
    * @return String
    */
    private static String processSplitedNumber(char[] num, int time) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = num.length - 1; i >= 0; i--) {  
            if (num[i] == '0') {  
                /** 
                 * 当前数字是0.并且是最后一位，直接不读 
                 */  
                if (i == 0) {  
                    continue;  
                }  
                /** 
                 * 当前数字是0，下一个数字不是0，补一个0上去读 
                 */  
                if (num[i - 1] != '0') {  
                    sb.append(numberStringMap.get(Integer.valueOf(num[i] + "")));  
                } else {  
                    continue;  
                }  
            } else {  
                /** 
                 * 如果当前位数不是0，那就正常的读出数字和位 
                 */  
                sb.append(numberStringMap.get(Integer.valueOf(num[i] + "")));  
                sb.append(base10StringMap.get(i + 1));  
            }  
        }  
  
        if (time == 0) {  
        } else if (time == 1) {  
            sb.append("万");  
        } else if (time == 2) {  
            sb.append("亿");  
        }  
        return sb.toString();  
    }

	/**
	 * 将数字转化为大写  
	 * @param num
	 * @return String
	 */
	public static String numToUpper(int num) {   
		String u[] = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };  
		char[] str = String.valueOf(num).toCharArray();  
		String rstr = "";  
		for (int i = 0; i < str.length; i++) {  
			rstr = rstr + u[Integer.parseInt(str[i] + "")];  
		 }  
		return rstr;  
	}
    
	static final Writer result = new StringWriter();
	static final PrintWriter printWriter = new PrintWriter(result);
	/**
     * 将异常堆栈转换为字符串
     * @param aThrowable 异常
     * @return String
     */
    public static String getStackTrace(Throwable aThrowable) {
	    aThrowable.printStackTrace(printWriter);
	    return result.toString();
	}
    
	/** 
	* @Title: revertCharArray 
	* @Description: 将得到的数组倒排,这样做原因是因为读的时候从前往后读， 位数前面的高 
	* @param array
	* @return char[]
	*/
	private char[] revertCharArray(char[] array) {  
        char arrayNew[] = new char[array.length];  
        for (int i = array.length - 1, j = 0; i >= 0 && j < array.length; i--, j++) {  
            arrayNew[j] = array[i];  
        }  
        return arrayNew;  
    } 
	
	/**
	 * 生成min至max之间的随机数
	 * @param min
	 * @param max
	 * @return int
	 */
	public int makeRanNumN(final int min, final int max){
		Random rand = new Random(); 
		int tmp = Math.abs(rand.nextInt());
		return tmp % (max - min + 1) + min;
	}
	
	/**
	 * 得到n位长度的随机数
	 * @param n 随机数的长度
	 * @return int 返回 n位的随机整数
	 */
	public static int getRandomNumber(int n){
		int temp = 0;
		int min = (int) Math.pow(10, n-1);
		int max = (int) Math.pow(10, n);
		Random rand = new Random();
		while(true){
			temp = rand.nextInt(max);
			if(temp >= min)
				break;
		}
		return temp;
	}

	public static String replace(String str){
		if(str == null){
			return "";
		}
		String value = "";
		try {
			byte[] b_text = str.getBytes("utf-8");
			for (int i = 0; i < b_text.length; i++)  
			{  
			    if((b_text[i] & 0xF8)== 0xF0){  
			        for (int j = 0; j < 4; j++) {                          
			        	b_text[i+j]=0x30;                     
			        }  
			        i+=3;  
			    }  
			}  
			value = new String(b_text,"utf-8").replace("0", "");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static String CreateNoncestr() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < 16; i++) {
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
	}
	
	public static String CreateNoncestr(int size) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < size; i++) {
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
	}
	
	public static String getPassword(int length) {
		String chars = "0123456789";
		String res = "";
		for (int i = 0; i < length; i++) {
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
	}
	
	public static String mapToGetParams(Map<String,String> params){
		if(params == null){
			return "";
		}
		StringBuilder sbuilder = new StringBuilder();
		
		for (Map.Entry<String, String> entry : params.entrySet()) {
			sbuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		return sbuilder.substring(0, sbuilder.length()-1);
	}
	
	public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
	public static boolean isEmpty(String str)
    {
        if (str == null || str.trim().length() == 0)
        {
            return true;
        }
        return false;
    }
    
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }
    
    public static boolean isValue(String str)
    {
        return !isEmpty(str);
    }
    
    /**
	 * 判断是否有值，如果有，返回值，否则返回""
	 */
	public static String hasValue(String value)
	{
	    return isEmpty(value) ? "" : value;
	}
	
	/**
	 * 
	 * 避免null字符串，如果是null则转换成空字符串。
	 *
	 * @param value 需要检查的字符串
	 * @return String
	 * @since eSDK Solutions Platform V100R003C00
	 */
	public static String avoidNull(String value)
	{
	    if (null != value)
	    {
	        return value;
	    }
	    return "";
	}
	
	public static boolean isNumber(String str)
	{
	    if (null == str)
	    {
	        return false;
	    }
	    return str.matches("\\d+");
	}
	
	public static boolean isEmptyWihthoutTrim(String str)
	{
	    if (str == null || str.length() == 0)
	    {
	        return true;
	    }
	    return false;
	}
	
	public static boolean isUintNumber(String str)
	{
	    try
	    {
	        long uInt = Long.parseLong(str);
	        if (4294967295L < uInt)
	        {
	            return false;
	        }
	        return true;
	    }
	    catch (NumberFormatException e)
	    {
	        return false;
	    }
	}
	
	/**
	 * 
	 * 截掉指定长度的错误码
	 * @param errCode 错误码
	 * @param length 保留长度
	 * @param isRight 从右侧开始截掉
	 * @return 截掉之后返回的错误码
	 */
	public static String truncateString(String errCode, int length, boolean isRight)
	{
	    if (!isEmpty(errCode))
	    {
	        if (length >= errCode.length())
	        {
	            return errCode;
	        }
	        else
	        {
	            String subString = "";
	            if (isRight)
	            {
	                subString = errCode.substring(0, length);
	                return subString;
	            }
	            else
	            {
	                subString = errCode.substring(errCode.length() - length, errCode.length());
	                return subString;
	            }
	        }
	    }
	    return errCode;
	}
	
	/**
	 * 
	 * 将传入的字符串格式成指定的长度的字符串，如果长度不足指定的长度可以在左边或者右边填补指定的字符。
	 *
	 * @param formatStr 需要格式化字符串
	 * @param length 需要格式化后的长度
	 * @param leftPadding 是否是在左边填充
	 * @param paddingCharacter 填充的字符
	 * @return 格式化后的字符串
	 * @since eSDK Solutions Platform V100R003C00
	 */
	public static String formatNumber(String formatStr, int length, 
			boolean leftPadding, char paddingCharacter)
	{
	    StringBuilder result = new StringBuilder(formatStr);
	    String paddingStr = String.valueOf(paddingCharacter);
	    
	    while (result.length() < length)
	    {
	        if (leftPadding)
	        {
	            result = (new StringBuilder(paddingStr)).append(result);
	        }
	        else
	        {
	            result.append(paddingCharacter);
	        }
	    }
	    
	    return result.toString();
	}
	
	public static Map<String, String> parseString(String content, 
			String level1Delimiter, String level2Delimiter)
	{
	    Map<String, String> result = new HashMap<String, String>();
	    if (isEmpty(content))
	    {
	        return result;
	    }
	    
	    String[] tempArray = content.split(level1Delimiter);
	    String[] tempArray4Item;
	    for (String item : tempArray)
	    {
	        tempArray4Item = item.trim().split(level2Delimiter);
	        if (tempArray4Item.length > 1)
	        {
	            result.put(tempArray4Item[0].trim(), tempArray4Item[1].trim());
	        }
	    }
	    return result;
	}
	
	public static String escapeXMLSymbols(String xmlContent)
	{
	    if (StringUtils.isEmpty(xmlContent))
	    {
	        return xmlContent;
	    }
	    
	    xmlContent = xmlContent.replaceAll("&", "&amp;");
		xmlContent = xmlContent.replaceAll("<", "&lt;");
		xmlContent = xmlContent.replaceAll(">", "&gt;");
		xmlContent = xmlContent.replaceAll("\"", "&quot;");
		xmlContent = xmlContent.replaceAll("'", "&apos;");
	    
	    return xmlContent;
	}
	
	public static String unescapeXML(String xmlContent)
	{
	    if (!StringUtils.isEmpty(xmlContent))
	    {
	        xmlContent =
	            xmlContent.replaceAll("&amp;", "&")
	        .replaceAll("&lt;", "<")
	        .replaceAll("&gt;", ">")
	        .replaceAll("&quot;", "\"")
	        .replaceAll("&apos;", "'");
	    }
	    return xmlContent;
	}
	
	public static String upperCaseFirstLetter(String srcStr)
	{
	    if (isEmpty(srcStr))
	    {
	        return srcStr;
	    }
	    
	    return Character.toUpperCase(srcStr.charAt(0)) + srcStr.substring(1);
	}
	
	public static String lowerCaseFirstLetter(String srcStr)
	{
	    if (isEmpty(srcStr))
	    {
	        return srcStr;
	    }
	    
	    return Character.toLowerCase(srcStr.charAt(0)) + srcStr.substring(1);
	}
	
	public static String trim(String str)
	{
	    if (null == str)
	    {
	        return str;
	    }
	    else
	    {
	        return str.trim();
	    }
	}
	
	public static boolean strsEquals(String str1, String str2)
	{
	    if (null != str1)
	    {
	        return str1.equals(str2);
	    }
	    else
	    {
	        if (null == str2)
	        {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static boolean strsEqualsIgnoreCase(String str1, String str2)
	{
	    if (null != str1)
	    {
	        return str1.equalsIgnoreCase(str2);
	    }
	    else
	    {
	        if (null == str2)
	        {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static String retrieveMachineAddr(String url)
	{
	    int begin;
	    if (url.startsWith("http"))
		{
		    begin = url.indexOf("//") + 2;
		}
		else
		{
		    begin = 0;
		}
	
		String address;
		if (url.indexOf(":", begin) > 0)
		{
		    address = url.substring(begin, url.indexOf(":", begin));
		}
		else
		{
			address = url.substring(begin, url.indexOf("/", begin));
	    }
	    return address;
	}
	
	/**
	* 隐藏手机号中间四位 
	* $1、$2、……表示正则表达式里面第一个、第二个、……括号里面的匹配内容
	* 
	* @param mobile
	* @return String 
	*/
	public static String mobileHide(String mobile) {
		if (mobile!=null && mobile!="") {
			return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
		} else {
			return "";
		}
	}

}
