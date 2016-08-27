package com.web.myapp.util;

import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class GsonUtil {
	
	static Gson gson = null;
	static{
		gson = new GsonBuilder()
	    .setPrettyPrinting()
	    .disableHtmlEscaping()
	    .create();
	}
	
	public static  Gson getGson(){
		return gson;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object json2Bean(String json,Class cls) throws JsonSyntaxException, UnsupportedEncodingException{
		Object obj = gson.fromJson(java.net.URLDecoder.decode(json,"utf-8"),cls);
		return obj;
	}
	
	public static String bean2Json(Object obj){
		String json = gson.toJson(obj);
		return json;
	}
}
