package com.web.myapp.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**   
 * Function: Junit测试基类
 * @author jiangyf   
 * @since 2016年9月5日 上午11:18:22 
 * @version V1.0   
 */
@RunWith(SpringJUnit4ClassRunner.class) // 运行Spring测试环境
@ContextConfiguration(locations = {"classpath*:/spring/spring-context.xml"}) // 加载Spring的配置文件
public class BaseJunitTest extends AbstractJUnit4SpringContextTests {

}
