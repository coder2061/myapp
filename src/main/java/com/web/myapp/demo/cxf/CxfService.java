package com.web.myapp.demo.cxf;

import javax.jws.WebService;

/**   
 * WebService接口 
 * @author jiangyf   
 * @since 2016年9月22日 上午10:02:16 
 * @version V1.0   
 */
@WebService
public interface CxfService {
	String sayHi(String name);
	
	String sayHello(String name);

}
