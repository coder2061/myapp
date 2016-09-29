package com.web.myapp.demo.inheritance;
/**   
 * java类关于继承的执行顺序（父类） 
 * @author jiangyf   
 * @since 2016年9月6日 上午9:49:11 
 * @version V1.0   
 */
public class TestFather {
	private int a = 1;
	
	int b = 2;
	
	protected int c = 3;
	
	public int d = 4;
	
	{
		System.out.println("1、Father-代码块初始化");
	}
	
	static {
		System.out.println("2、Father-静态代码块初始化");
	}
	
	public TestFather() {
		System.out.println("3、Father-构造方法初始化");
	}
	
	private void method1() {
		System.out.println("4、Father-私有方法初始化");
	}
	
	void method2() {
		System.out.println("5、Father-友好方法初始化");
	}
	
	protected void method3() {
		System.out.println("6、Father-保护方法初始化");
	}
	
	public void method4() {
		System.out.println("7、Father-公共方法初始化");
	}

}
