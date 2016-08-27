package com.web.myapp.util;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class WxInterfaceUtils {
	/**
	 * 根据参数对象，解析成List<String>并进行参数名ASCII码从小到大排序（字典序）
	 * @param obj 参数对象
	 * @return
	 */
	public static List<String> sortFields(Object obj){
		List<String> fieldList = new ArrayList<String>();
		Class classType = obj.getClass();
		
		for(; classType != Object.class ; classType = classType.getSuperclass()) {  
            try {  
            	Field[] fields = classType.getDeclaredFields();
            	for (Field field : fields) {
        			field.setAccessible(true);  
        			String fieldName = field.getName();
        			String fieldValue = "";
        			try {
        				Object value = field.get(obj);
        				if(!(value instanceof Collection)){
        					fieldValue = String.valueOf(field.get(obj));
        				}
        			} catch (IllegalArgumentException e) {
        				e.printStackTrace();
        			} catch (IllegalAccessException e) {
        				e.printStackTrace();
        			}
        			if(!"sign".equals(fieldName) && fieldValue != null  && fieldValue.length() > 0 && fieldValue != "null"){
        				fieldList.add(fieldName + "=" + fieldValue);
        			}
        		}
            } catch (Exception e) {  
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。  
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了  
                  
            }   
		}
		
		Collections.sort(fieldList);
		return fieldList;
	}
	/**
	 * 根据解析后的List<String>进行特殊字符拼接
	 * @param obj lists
	 * @param sep 分割字符
	 * @return
	 */
	public static String join(List<String> lists,String sep){
		
		StringBuilder sign = new StringBuilder();
		for(String kv : lists){
			sign.append(kv).append(sep);
		}
		String result = sign.toString();
		return result.substring(0, result.length() - 1);
	}
	/**
	 * 获取加密的sign值
	 * @param obj 参数java类对象
	 * @param key 加密秘钥
	 * @return 加密后的sign值
	 */
	public static String getSign(Object obj,String key){
		String signA = WxInterfaceUtils.join(WxInterfaceUtils.sortFields(obj), "&");
		String signValue = MD5Utils.String2MD5(signA + "&key="+key).toUpperCase();
		return signValue;
	}
	
	public static String setNotifyXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code
                + "]]></return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
	}
	

	public static boolean checkSign(Object obj,String key) throws Exception{
		String sign = getSign(obj,key);
		Class classType = obj.getClass();
		Field  signField = null;
		for(; classType != Object.class ; classType = classType.getSuperclass()) {  
            try {  
            	signField = classType.getDeclaredField("sign") ;  
                break; 
            } catch (Exception e) {  
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。  
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了  
                  
            }   
		}
		signField.setAccessible(true);
		if(sign.equals(String.valueOf(signField.get(obj)))){
			return true;
		}else{
			return false;
		}
	}
	
	public static Timestamp getByString(String time,String format) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat(format);
		
		Timestamp ts = new Timestamp(dateFormat.parse(time).getTime());
		return ts;
	}
	
	public static void main(String[] args) throws ParseException{
		Timestamp ts = getByString("20141030133525","yyyyMMddHHmmss");
		System.out.println(ts.toString());
	}
}
