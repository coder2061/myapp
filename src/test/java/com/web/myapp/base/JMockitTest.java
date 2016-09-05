package com.web.myapp.base;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;

/**   
 * Function: JMockit单元测试  
 * @author jiangyf   
 * @since 2016年9月5日 下午4:12:39 
 * @version V1.0   
 */
public class JMockitTest {
	@Mocked // 用@Mocked标注的对象，不需要赋值，jmockit自动mock
	Calculator calculator;
	
	/*
	 * JMockit也可以分类为非局部模拟与局部模拟，区分在于Expectations块是否有参数，有参数的是局部模拟，反之是非局部模拟。
	 */
	
	@Test
	public void testNonLocalMock(){ // 非局部模拟
		// 录制预期Mock行为
		new NonStrictExpectations() {
			{
				calculator.add(1, 2);
				returns(3); // 预期执行结果
//				result = 3;
			}
		};
		
		// 调用测试方法
		Assert.assertEquals(3, calculator.add(1, 2));
		
		// 验证预期Mock行为被调用
		new Verifications() {
			{
				calculator.add(1, 1);
				times = 1;
			}
		};
	}
	
	@Test
	public void testLocalMock(){ // 非局部模拟
		final Calculator cal = new Calculator();
		// 录制预期Mock行为
		new NonStrictExpectations(cal) {
			{
				cal.add(1, 2);
				returns(3); // 预期执行结果
//				result = 3;
			}
		};
		
		// 调用测试方法
		Assert.assertEquals(3, cal.add(1, 2));
		
		// 验证预期Mock行为被调用
		new Verifications() {
			{
				cal.add(1, 1);
				times = 1;
			}
		};
	}
	
	/*
	 * 1） Behavior-oriented(Expectations & Verifications) 
	 */
	
	@Test
	public void testMockStaticMethod() { // 模拟静态方法
	    new NonStrictExpectations(JMockitCase.class) {
	        {
	            JMockitCase.getDouble(1);
	            result = 3;
	        }
	    };

	    Assert.assertEquals(3, JMockitCase.getDouble(1));

	    new Verifications() {
	        {
	            JMockitCase.getDouble(2);
	            times = 1;
	        }
	    };
	}
	
    @Test  
    public void testMockPrivateMethod() throws Exception { // 模拟私有方法
        final JMockitCase obj = new JMockitCase();  
        new NonStrictExpectations(obj) {  
            {
            	obj.getTripleString(1);  
                result = "3";  
            }  
        };  
      
        Assert.assertEquals("3", obj.getTripleString(1));  
      
        new Verifications() {  
            {  
            	obj.getTripleString(1);  
                times = 1;  
            }  
        };  
    }
    
    /*
    @Test  
    public void testMockPrivateProperty() throws IOException { // 使用JMockit设置私有属性
        final ClassMocked obj = new ClassMocked();  
        new NonStrictExpectations(obj) {  
            {  
                this.setField(obj, "name", "name has bean change!");  
            }  
        };  
      
        Assert.assertEquals("name has bean change!", obj.getName());  
    }
    
    @Test  
    public void testMockPrivateStaticProperty() throws IOException { // 使用JMockit设置静态私有属性
        new NonStrictExpectations(ClassMocked.class) {
            {  
                this.setField(ClassMocked.class, "className", "className has bean change!");  
            }  
        };  
      
        Assert.assertEquals("className has bean change!", ClassMocked.getClassName());  
    }
    */
    
    /*
	 * 2）State-oriented(MockUp<GenericType>)  
	 */
    
    @Test  
    public void testMockNormalMethodContent() throws IOException { // 修改普通方法 
    	JMockitCase obj = new JMockitCase();
    	//使用MockUp修改被测试方法内部逻辑 
        new MockUp<JMockitCase>() {
        	@Mock  
            public int getTriple(int i) {  
                  return i * 30;  
            }
        };  
        Assert.assertEquals(30, obj.getTriple(1));  
        //注意：在JMockit1.5之后已经没有Mockit这个类，使用MockUp代替，mockUp和tearDown方法在MockUp类中
//        Mockit.tearDownMocks();
    }
    
    @Test  
    public void testMockStaticMethodContent() { // 修改静态方法 
        new MockUp<JMockitCase>() {
        	//注意:在MockUp中的方法除了不包含static关键字以外，其他都和被Mock的方法签名相同，并且使用@Mock标注
            @Mock    
            public int getDouble(int i){    
                return i*20;    
            }  
        };
        Assert.assertEquals(20, JMockitCase.getDouble(1));    
    }  

}
