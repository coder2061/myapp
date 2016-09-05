package com.web.myapp.base;
/**   
 * Function: Junit测试使用类
 * @author jiangyf   
 * @since 2016年9月5日 下午2:54:23 
 * @version V1.0   
 */
public class Calculator {
	public int add(int one, int another) {
        return one + another;
    }
	
	public int subtract(int one, int another) {
        return one - another;
    }

    public int multiply(int one, int another) {
        return one * another;
    }
    
    public double divide(double divident, double dividor) {
        if (dividor == 0) throw new IllegalArgumentException("Dividor cannot be 0");
        return divident / dividor;
    }
}
