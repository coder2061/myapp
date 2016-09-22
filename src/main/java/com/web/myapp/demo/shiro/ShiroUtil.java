package com.web.myapp.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.crypto.hash.Md5Hash;

/**   
 * Function: Shiro工具
 * @author jiangyf   
 * @since 2016年9月22日 下午12:00:00 
 * @version V1.0   
 */
public class ShiroUtil {
	
	public static void test() {
		//读取配置文件，初始化工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini") ;
        //获取SecurityManager的实例对象
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        //得到当前的用户
        Subject curentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("jade","123456") ;
        try {
            curentUser.login(token);
            System.out.println("认证成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("认证失败");
        }
        curentUser.logout();
	}
	
	/**  
	* Function: 基于Shiro的MD5加密 
	* @param str 加密的字符串
	* @param salt 盐值
	* @return String 
	*/
	public static String md5Hash(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }
	
	public static void main(String[] args) {
		test();
//		System.out.println(md5Hash("hello", "jade"));
	}

}
