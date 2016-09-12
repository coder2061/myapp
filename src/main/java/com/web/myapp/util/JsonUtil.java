package com.web.myapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**   
 * Function: Json工具类 
 * @author jiangyf   
 * @since 2016年9月12日 下午12:00:02 
 * @version V1.0   
 */
public class JsonUtil {

    /**  
    * Function: 封装执行结果为json对象
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
    * Function: 封装请求响应数据为json对象输出
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
}
