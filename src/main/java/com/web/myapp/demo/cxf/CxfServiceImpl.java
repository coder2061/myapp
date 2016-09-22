package com.web.myapp.demo.cxf;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

/**   
 * Function: WebService接口实现
 * @author jiangyf   
 * @since 2016年9月22日 上午10:02:33 
 * @version V1.0   
 */
@Component("cxfService")
@WebService
public class CxfServiceImpl implements CxfService {
	/**  
	* @see http://127.0.0.1:8080/myapp/webservice/cxf/sayHi?wsdl
	*/
	@Override
	public String sayHi(String name) {
		return "Hello " + name;
	}

	/**  
	* @see http://127.0.0.1:8080/myapp/webservice/cxf/sayHello?wsdl
	*/
	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
