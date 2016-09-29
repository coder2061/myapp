package com.web.myapp.base;
/**   
 * JMockit单元测试 
 * @author jiangyf   
 * @since 2016年9月5日 下午5:27:13 
 * @version V1.0   
 */
public class JMockitCase {
    private String name = "name_init";

    public String getName() {
        return name;
    }
    
    private static String className="className_init";
    
    public static String getClassName(){
        return className;
    }
    
    public static int getDouble(int i){  
        return i*2;  
    }  
      
    public int getTriple(int i){  
        return i*3;  
    }
    
    String getTripleString(int i) {
    	return i*3 + "";
    }
    
}
