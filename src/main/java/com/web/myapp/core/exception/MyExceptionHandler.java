package com.web.myapp.core.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Status value 
 * 1001 业务异常返回 
 * 1002 参数异常返回 
 * 1000 其他异常返回
 * 
 * @author LiPengfei
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

	private static Logger logger = Logger.getLogger(MyExceptionHandler.class);
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		response.setContentType("application/json;charset=UTF-8");
		try {
			if (ex instanceof BizException) {
				response.setStatus(1001);// 业务异常返回 1001
				PrintWriter writer = response.getWriter();
				writer.write(ex.getMessage());
				writer.flush();
			} else if (ex instanceof ParameterException) {
				response.setStatus(1002);// 参数异常返回 1002
				PrintWriter writer = response.getWriter();
				writer.write(ex.getMessage());
				writer.flush();
			} else {
				response.setStatus(1000);// 其他异常返回 1000
				ex.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			logger.error("errorCode："+response.getStatus()+"\n errorMessage:"+ex.getMessage());
		}
		return null;

	}

}
