package com.web.myapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**   
 * 处理IO流   
 */
public class IOStreamUtil {
	
	/**  
	* 输入流转字符串
	* 
	* @param in
	* @throws UnsupportedEncodingException
	* @throws IOException
	* @return String 
	*/
	public static String inputStream2String(InputStream in) 
			throws UnsupportedEncodingException, IOException{
        if(in == null){
        	return "";
        }
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            out.append(new String(b, 0, n, "UTF-8"));
        }
        return out.toString();
    }
	
	/**  
	* 输入流转字符串
	* 
	* @param in
	* @throws UnsupportedEncodingException
	* @throws IOException
	* @return String 
	*/
	public static final String inputStreamToString(InputStream in)
	        throws UnsupportedEncodingException, IOException {
	    if (in == null){
	    	return "";
	    }
	    //已HTTP请求输入流建立一个BufferedReader对象
	    BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
	    //读取HTTP请求内容
	    String buffer = null;
	    StringBuffer sb = new StringBuffer();
	    while ((buffer = br.readLine()) != null) {
	    	//在页面中显示读取到的请求参数
	    	sb.append(buffer+"\n"); 
		}
        return sb.toString().trim();
	}

}
