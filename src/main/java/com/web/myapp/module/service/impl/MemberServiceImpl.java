package com.web.myapp.module.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.myapp.module.dao.MemberDao;
import com.web.myapp.module.entity.Member;
import com.web.myapp.module.entity.MemberExample;
import com.web.myapp.module.service.MemberService;

/**   
 * Function: member接口实现 
 * @author jiangyf   
 * @since 2016年9月7日 上午10:54:40 
 * @version V1.0   
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDao memberDao;

	/**  
	* Function: 查询用户列表
	* @author jiangyf 
	* @since 2016年9月7日 上午11:06:25 
	*/
	@Override
	public List<Member> getMemberList() {
		return this.memberDao.selectByExample(new MemberExample());
	}
	
}
