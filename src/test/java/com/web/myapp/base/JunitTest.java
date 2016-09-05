package com.web.myapp.base;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**   
 * Function: 一个测试方法主要包括三个部分：setup，执行操作，验证结果
 * @author jiangyf   
 * @since 2016年9月5日 上午11:57:26 
 * @version V1.0   
 */
public class JunitTest extends BaseJunitTest {
	Calculator calculator;

    @Before
    public void setup() {
    	calculator = new Calculator();
    }
	
	@Test
	public void testAdd(){
		Assert.assertEquals(5, calculator.add(2, 3));
	}
	
	@Test
    @Ignore("not implemented yet") // 忽略该测试方法
    public void testMultiply() {
		Assert.assertEquals(4, calculator.multiply(2, 2));
    }
	
	@Test(expected = IllegalArgumentException.class) // 验证方法会抛出某些异常
    public void testDivide() {
		calculator.divide(4, 0);
    }

}
