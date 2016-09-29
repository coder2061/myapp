package com.web.myapp.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**   
 * Junit测试基类（需要配置事务，可实现数据回滚，即测试执行完成，数据库数据与测试前一致）
 * @author jiangyf   
 * @since 2016年9月5日 上午11:18:22 
 * @version V1.0   
 */
@RunWith(SpringJUnit4ClassRunner.class) // 运行Spring测试环境
@ContextConfiguration(locations = {
		"classpath:spring-mybatis/spring-mybatis.xml", 
		"classpath:spring-mvc/spring-mvc.xml", 
		"classpath:spring-mvc/spring-context.xml",}) // 加载Spring的配置文件
public class BaseTranscationJunitTest extends AbstractTransactionalJUnit4SpringContextTests {

}
