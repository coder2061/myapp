package com.web.myapp.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**   
 * 反射 
 */
public class ReflectUtil {
	
	/**  
	* 获取类的属性集合
	* 
	* @param clazzName "com.web.myapp.module.model.Area"
	* @throws ClassNotFoundException
	* @return List<String> 
	*/
	public static List<String> getClassFields(String clazzName) 
			throws ClassNotFoundException{
		List<String> fieldList = new ArrayList<String>();
		Class<?> classType = Class.forName(clazzName);
		Field[] fields = classType.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
			fieldList.add(field.getName());
		}
		return fieldList;
	}
	
//	public static void main(String[] args) throws ClassNotFoundException {
//		getClassFields("com.web.myapp.module.model.Area");
//	}

}
