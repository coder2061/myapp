package com.web.myapp.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.web.myapp.core.exception.BizExpDictionary;
import com.web.myapp.core.exception.BizException;

public class VoUtil {

	private static Logger logger = Logger.getLogger(VoUtil.class);

	/**
	 * 将数据库中查询的对象转换为参数对象 （隐藏部分不需要参数的字段）
	 * 
	 * @param voClazz 转换后的参数对象模Class
	 * @param entityObject 转换前的实体类对象
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <E> E convertToVo(Class voClazz, Object entityObject) {
		Object vo = null;
		try {
			vo = voClazz.newInstance();
			
			Field[] entityFields = entityObject.getClass().getDeclaredFields();
			List<String> entityFiledNames = new ArrayList<String>();
			for(Field entityField : entityFields){
				entityFiledNames.add(entityField.getName());
			}
			
			Field[] voFields = voClazz.getDeclaredFields();
			List<Field> voFieldList = new ArrayList<Field>();
			for(Field voField : voFields){
				if(entityFiledNames.contains(voField.getName())){
					voFieldList.add(voField);
				}
			}
			
			for (Field voField : voFieldList) {
				// 查询到的entity对象的属性
				Field entityField = entityObject.getClass()
						.getDeclaredField(voField.getName());
				// 私有变量必须先设置Accessible为true
				voField.setAccessible(true);
				entityField.setAccessible(true);

				// 判断实体对象属性值是否存在，是，则放入参数对象属性中
				if (entityField.get(entityObject) != null) {
					voField.set(vo, entityField.get(entityObject));
				}
			}
		} catch (InstantiationException e) {
			logger.error(BizExpDictionary.CONVERTTOVOERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.CONVERTTOVOERROR);
		} catch (IllegalAccessException e) {
			logger.error(BizExpDictionary.CONVERTTOVOERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.CONVERTTOVOERROR);
		} catch (NoSuchFieldException e) {
			logger.error(BizExpDictionary.CONVERTTOVOERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.CONVERTTOVOERROR);
		} catch (SecurityException e) {
			logger.error(BizExpDictionary.CONVERTTOVOERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.CONVERTTOVOERROR);
		}
		return (E) vo;
	}
	
	/**
	 * 将request中的参数封装成 vo
	 * 
	 * @param voClazz
	 * @param request
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <E> E convertToVo(Class voClazz, HttpServletRequest request) {
		Object vo = null;
		try {
			vo = voClazz.newInstance();
			Enumeration<String> params = request.getParameterNames();
			while (params.hasMoreElements()) {
				String paramName = params.nextElement();
				if("action".equals(paramName) || "pageNo".equals(paramName) 
						|| "pageSize".equals(paramName)) {
					continue;
				}
				Field voField = voClazz.getDeclaredField(paramName);
				voField.setAccessible(true);
				String type = voField.getGenericType().toString();
				String paramValue = request.getParameter(paramName);
				if (CommonUtil.isNotEmpty(paramValue)) {
					if (type.equals("class java.util.Date")) {
						voField.set(vo, CommonUtil.toDate(paramValue));
					} else if (type.equals("class java.math.BigDecimal")) {
						voField.set(vo, new BigDecimal(paramValue));
					} else if (type.equals("class java.lang.Integer")) {
						voField.set(vo, new Integer(paramValue));
					} else if (type.equals("class java.lang.Boolean")) {
						if ("1".equals(paramValue)) {
							voField.set(vo, true);
						} else{
							voField.set(vo, false);
						}
					} else if (type.equals("class java.lang.Byte")) {
						voField.set(vo, new Byte(paramValue));
					} else if (type.equals("class java.lang.Long")) {
						voField.set(vo, new Long(paramValue));
					} else if (type.equals("class java.lang.Float")) {
						voField.set(vo, new Float(paramValue));
					} else if (type.equals("class java.lang.Double")) {
						voField.set(vo, new Double(paramValue));
					}
				} else {
					voField.set(vo, paramValue);
				}
			}
		} catch (InstantiationException e) {
			logger.error(BizExpDictionary.CONVERTTOVOERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.CONVERTTOVOERROR);
		} catch (IllegalAccessException e) {
			logger.error(BizExpDictionary.CONVERTTOVOERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.CONVERTTOVOERROR);
		} catch (NoSuchFieldException e) {
			logger.error(BizExpDictionary.CONVERTTOVOERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.CONVERTTOVOERROR);
		} catch (SecurityException e) {
			logger.error(BizExpDictionary.CONVERTTOVOERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.CONVERTTOVOERROR);
		}
		return (E) vo;
	}

	/**
	 * 将参数对象相关属性值放入对应的实体对象属性中
	 * 
	 * @param voObj 参数对象（用来与用户交互的对象）
	 * @param entityObj 实体对象（用来与数据库交互的对象）
	 * @return Object
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public static <E> E injectVoToEntity(Object voObj, Object entityObj) {
		Field[] entityFields = entityObj.getClass().getDeclaredFields();
		List<String> entityFiledNames = new ArrayList<String>();
		for(Field entityField :entityFields){
			entityFiledNames.add(entityField.getName());
		}
		
		Field[] voFields = voObj.getClass().getDeclaredFields();
		List<Field> voFieldList = new ArrayList<Field>();
		for(Field voField :voFields){
			if(entityFiledNames.contains(voField.getName())){
				voFieldList.add(voField);
			}
		}
		
		try {
			for (Field voField:voFieldList) {
				// vo属性
				voField.setAccessible(true);
				Object fieldValue;
				
				fieldValue = voField.get(voObj);

				if (fieldValue != null) {
					Field entityField = entityObj.getClass()
							.getDeclaredField(voField.getName());
					entityField.setAccessible(true);
					entityField.set(entityObj, fieldValue);
				}
			}
		} catch (IllegalArgumentException e) {
			logger.error(BizExpDictionary.INJECTVOTOENTITYERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.INJECTVOTOENTITYERROR);
		} catch (IllegalAccessException e) {
			logger.error(BizExpDictionary.INJECTVOTOENTITYERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.INJECTVOTOENTITYERROR);
		} catch (NoSuchFieldException e) {
			logger.error(BizExpDictionary.INJECTVOTOENTITYERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.INJECTVOTOENTITYERROR);
		} catch (SecurityException e) {
			logger.error(BizExpDictionary.INJECTVOTOENTITYERROR + "\n"
					+ e.getStackTrace());
			e.printStackTrace();
			throw new BizException(BizExpDictionary.INJECTVOTOENTITYERROR);
		}
		return (E) entityObj;
	}
}
