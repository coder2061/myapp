package com.web.myapp.demo.inheritance;
/**   
 * Function: java类关于继承的执行顺序（子类） 
 * @author jiangyf   
 * @since 2016年9月6日 上午9:49:50 
 * @version V1.0   
 */
public class TestSon extends TestFather {
	/*
	private int a = 5;
	
	int b = 6;
	
	protected int c = 7;
	
	public int d = 8;
	*/
	{
		System.out.println("1、Son-代码块初始化");
	}
	
	static {
		System.out.println("2、Son-静态代码块初始化");
	}
	
	public TestSon() {
		System.out.println("3、Son-构造方法初始化");
	}
	
	private void method1() {
		System.out.println("4、Son-私有方法初始化");
	}
	
	void method2() {
		System.out.println("5、Son-友好方法初始化");
	}
	
	protected void method3() {
		System.out.println("6、Son-保护方法初始化");
	}
	
	public void method4() {
		System.out.println("7、Son-公共方法初始化");
	}
	
	public static void main(String[] args) {
		TestSon son = new TestSon();
		
		son.method1();
		
//		System.out.println("私有型成员变量a：" + son.a);
		System.out.println("友好型成员变量b：" + son.b);
		System.out.println("保护型成员变量c：" + son.c);
		System.out.println("公共型成员变量d：" + son.d);
		
		/*
		 * 最终执行结果

			2、Father-静态代码块初始化
			2、Son-静态代码块初始化
			1、Father-代码块初始化
			3、Father-构造方法初始化
			1、Son-代码块初始化
			3、Son-构造方法初始化
			4、Son-私有方法初始化
			
			执行逻辑：
				先静态初始化，然后普通初始化，然后构造函数，先父后子。
				特殊情况，子类的静态初始化会紧跟父类的静态初始化
		 * 
		 */
	}
}
