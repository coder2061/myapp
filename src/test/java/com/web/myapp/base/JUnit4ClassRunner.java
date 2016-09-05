package com.web.myapp.base;

import java.io.FileNotFoundException;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

/**   
 * Function: Junit测试基类 
 * @author jiangyf   
 * @since 2016年9月5日 上午11:50:03 
 * @version V1.0   
 */
@SuppressWarnings("deprecation")
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {
	
	static {
		try {
			Log4jConfigurer.initLogging("classpath:log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
	}

	public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}

}
