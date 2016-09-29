package com.web.myapp.module.service;

import java.util.List;

import com.web.myapp.module.entity.Member;

/**   
 * member接口
 * @author jiangyf   
 * @since 2016年9月7日 上午10:54:01 
 * @version V1.0   
 */
public interface MemberService {
	
	List<Member> getMemberList();
	
	Member getMember(String account);
	
	String getRolesByName(String name);
	
	String getPermissionsByName(String name);

}
