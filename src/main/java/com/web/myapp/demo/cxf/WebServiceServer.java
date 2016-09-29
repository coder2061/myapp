package com.web.myapp.demo.cxf;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**   
 * 启动WebService
 * @author jiangyf   
 * @since 2016年9月22日 上午10:11:04 
 * @version V1.0   
 */
public class WebServiceServer {
	
	/**  
	* 手动启动WebService接口
	* @param address 接口地址
	* @param service 接口类
	* @param serviceImpl 实现类对象
	*/
	public static void startWebService(String address, Class<?> service, 
			Object serviceImpl) {
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		factoryBean.setAddress(address); // 设置接口地址
		factoryBean.setServiceClass(service); // 设置接口类
		factoryBean.setServiceBean(serviceImpl); // 设置接口实现类
		factoryBean.create(); // 创建WebService接口
	}
	
	public static void main(String[] args) {
		System.out.println("WebService启动中。。。");
		
		String address="http://127.0.0.1:8080/myapp/webservice/cxf";
		startWebService(address, CxfService.class, new CxfServiceImpl());
		
		System.out.println("WebService启动成功。。。");
	}
}
