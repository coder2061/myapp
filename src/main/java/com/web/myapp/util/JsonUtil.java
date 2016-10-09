package com.web.myapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.PropertyFilter;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**   
 * Json工具类 
 * @author jiangyf   
 * @since 2016年9月12日 下午12:00:02 
 * @version V1.0   
 */
public class JsonUtil {

    /**  
    * 封装执行结果为json对象
    * @param code
    * @param msg
    * @param data
    * @return JSONObject 
    */
    public static JSONObject parseJson(String code, String msg, Object data){
        JSONObject json = new JSONObject();
        //返回码，0表示成功，其他表示失败
        json.put("result", code);
        //中文提示
        json.put("msg", msg);
        //返回数据
        json.put("data", data);
        return json;
    }


    /**  
    * 封装请求响应数据为json对象输出
    * @param response
    * @param jo
    * @return void 
    */
    public static void responseBuildJson(HttpServletResponse response, Object obj){
        String json = "";
        if(obj instanceof JSONObject){
            json = JSONUtils.valueToString(obj);
        }else{
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                json = objectMapper.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        response.setContentType("text/javascript; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 将json对象转成Java对象
     * @param json
     * @param obj
     * @return
     */
    public static Object toBean(String json, Class<?> obj){
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setRootClass(obj);
        //将数组作为LIST处理
        jsonConfig.setArrayMode(JsonConfig.MODE_LIST);
        //处理日期类型的域
        jsonConfig.setJavaPropertyFilter(new PropertyFilter() {
            public boolean apply(Object source, String name, Object value) {
                try {
                    Field field = source.getClass().getDeclaredField(name);
                    if (field.getType() == Date.class) {
                        String formats[] = {"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd"};
                        for( String format : formats ){
                            Date tempDate = getDateFormat((String)value, format);
                            source.getClass().getMethod("set"+name.substring(0, 1).toUpperCase()+name.substring(1), Date.class).invoke(source, tempDate);
                            if (tempDate != null) {
                                break;
                            }
                        }
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
        Field[] fields = obj.getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            if (!JsonUtil.isBaseType(type)) {
                if ("java.util.List".equals(type.getName())) {
                    classMap.put(field.getName(), (Class<?>)((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0]);
                }else{
                    classMap.put(field.getName(), type);
                }
            }
        }
        //建立复杂域的映射关系
        jsonConfig.setClassMap(classMap);
        JSONObject jsonObject = JSONObject.fromObject(json);
        return JSONObject.toBean(jsonObject, jsonConfig);
    }
     
    /**
     * @Description: 判断是否是基本类型（去掉不用加进classMap的类型）
     * @param type
     * @return boolean
     */
    private static boolean isBaseType(Class<?> type){
        if (type == Byte.TYPE || "java.lang.Byte".equals(type.getName())){
            return true;
        }else if (type == Short.TYPE || "java.lang.Short".equals(type.getName())){
            return true;
        }else if (type == Integer.TYPE || "java.lang.Integer".equals(type.getName())){
            return true;
        }else if (type == Long.TYPE || "java.lang.Long".equals(type.getName())) {
            return true;
        }else if (type == Float.TYPE || "java.lang.Float".equals(type.getName())) {
            return true;
        }else if (type == Double.TYPE || "java.lang.Double".equals(type.getName())) {
            return true;
        }else if (type == Boolean.TYPE || "java.lang.Boolean".equals(type.getName())) {
            return true;
        }else if (type == Character.TYPE || "java.lang.Character".equals(type.getName())) {
            return true;
        }else if (type == String.class) {
            return true;
        }else if (type == Date.class) {
            return true;
        }else {
            return false;
        }
    }
     
    /** 
    * @Description: 字符串转类型日期类型
    * @param dateString
    * @param format
    * @return Date
    */
    private static Date getDateFormat(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}
