package com.web.myapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StringUtils {

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
	
	@SuppressWarnings("unchecked")
	public static List<String> getClassFields(String clazzName) throws ClassNotFoundException{
		List<String> fieldList = new ArrayList<String>();
		Class classType = Class.forName("java.lang.String");

		Field[] fields = classType.getDeclaredFields();

		for (Field field : fields) {

			System.out.println(field);
			System.out.println(field.getName());

		}
		return fieldList;
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
	    public static String formatNumber(String formatStr, int length, boolean leftPadding, char paddingCharacter)
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
	    
	    public static Map<String, String> parseString(String content, String level1Delimiter, String level2Delimiter)
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
	    public static final String readToString(InputStream in)
	            throws UnsupportedEncodingException, IOException {
	        if (in == null)
	            return "";

	      //已HTTP请求输入流建立一个BufferedReader对象
			 BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			 //读取HTTP请求内容
			String buffer = null;
			StringBuffer sb = new StringBuffer();
			while ((buffer = br.readLine()) != null) {
			//在页面中显示读取到的请求参数
			sb.append(buffer+"\n"); 
			}
			String params = sb.toString().trim();
	        return params;
	   }
}
