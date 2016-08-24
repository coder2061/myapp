package com.web.myapp.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.web.myapp.core.exception.BizExpDictionary;
import com.web.myapp.core.exception.BizException;

/**
 *常用工具类
 * @author lipengfei
 * date：2015-08-01
 */
public class CommonUtil {
	private static Logger logger = Logger.getLogger(CommonUtil.class);

	/**
	 * 判断变量是否为空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		if (null == s || "".equals(s) || "".equals(s.trim())
				|| "null".equalsIgnoreCase(s)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 判断变量是否为非空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNotEmpty(String s) {
		if (null == s || "".equals(s) || "".equals(s.trim()) || "null".equalsIgnoreCase(s)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 返回当前时间　格式：yyyy-MM-dd hh:mm:ss
	 * 
	 * @return String
	 */
	public static String fromDateH() {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(getNowTime());
	}
	
	/**
	 * 返回当前时间　格式：yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String fromDateY() {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(getNowTime());
	}
	
	/**
	 * 返回当前时间　格式：yyyy-MM-dd hh:mm:ss 或  yyyy-MM-dd
	 * 
	 * @return date
	 */
	public static Date toDate(String dateStr) {
		String datetimeEx="^\\d{4}\\-\\d{1,2}\\-\\d{1,2} \\d{2}:\\d{2}:\\d{2}$";
		String dateEx="^\\d{4}\\-\\d{1,2}\\-\\d{1,2}$";
		Pattern datetimePattern = Pattern.compile(datetimeEx); 
		Pattern datePattern = Pattern.compile(dateEx); 
		
		Matcher datetimeMatcher = datetimePattern.matcher(dateStr);
		Matcher dateMatcher = datePattern.matcher(dateStr);
		Date date = null;
		
		try {
			if(datetimeMatcher.find()){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				date = sdf.parse(dateStr);
			} else if(dateMatcher.find()){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				date = sdf.parse(dateStr);
			} else{
				throw new BizException(BizExpDictionary.DATEPATTERNERROR);
			}
		} catch (ParseException e) {
			logger.error(BizExpDictionary.DATEFORMATERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.DATEFORMATERROR);
		}
		return date;
	}
	
	/**
	 * 日期和天数加法计算
	 * @param date 日期
	 * @param days 天数
	 * @return Date
	 */
	public static Date calculateDate(Date date, Integer days){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		date = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return toDate(format.format(date));
	}
	
	/**
	 * 用来去掉List中空值和相同项的。
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> removeSameItem(List<String> list) {
		List<String> difList = new ArrayList<String>();
		for (String t : list) {
			if (t != null && !difList.contains(t)) {
				difList.add(t);
			}
		}
		return difList;
	}
	
	/*
	 * 将数据库字段  xx_xx_xx 转换成驼峰命名形式
	 */
	public static String toCamelCaseString(String inputString,
            boolean firstCharacterUppercase) {
        StringBuilder sb = new StringBuilder();

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            switch (c) {
            case '_':
            case '-':
            case '@':
            case '$':
            case '#':
            case ' ':
            case '/':
            case '&':
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }
                break;

            default:
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                break;
            }
        }

        if (firstCharacterUppercase) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        return sb.toString();
    }
	
	/**
	 * 将驼峰命名的字段转换成 xx_xx_xx类型的数据库字段
	 * @param inputString
	 * @param firstCharacterUppercase
	 * @return
	 */
	public static String fromCamelCaseString(String inputString,
            boolean firstCharacterUppercase) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            
            if(Character.isUpperCase(c)){
            	sb.append("_");
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
	
	/**
	 * 将返回结果封装到map中
	 * @param ifSuccess 处理是否成功
	 * @param message   描述信息
	 * @param data      返回数据
	 * @return
	 */
	public static Map<String, Object> toRecordMap(String ifSuccess,String message,Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", ifSuccess);
		map.put("message", message);
		map.put("data", data);
		return map;
    }
	
	/**
	 * 将String转换成integer
	 * @return
	 */
	public static Integer StringToInt(String str) {
		return Integer.valueOf(str);
    }
	
	/**
	 * 将json转换成Map<String, String>
	 * @return
	 */
	public static Map<String, Integer> jsonToMap(String data) {
		GsonBuilder gb = new GsonBuilder();
		Gson g = gb.create();
		Map<String, Integer> map = g.fromJson(data,
				new TypeToken<Map<String, Integer>>() {}.getType());
		return map;
	}
	/**
	 * 获取当前时间
	 * @return Date
	 */
	public static Date getNowTime() {
		return new Date();
	}
	
    /** 
     * 获取日期（月/日）
     * @param date 当前日期   
     * @param gap 时间差，天数
     * @return String
     */ 
    public static String getMonthDay(Date date, int gap) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, gap);  
        
        return (calendar.get(Calendar.MONTH)+1)+"月"+calendar.get(Calendar.DAY_OF_MONTH)+"号";  
    }
}
