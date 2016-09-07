package com.web.myapp.module.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.myapp.base.BaseJunitTest;
import com.web.myapp.module.entity.Member;

/**   
 * Function: 业务层单元测试
 * @author jiangyf   
 * @since 2016年9月7日 上午11:18:23 
 * @version V1.0   
 */
public class MemberServiceTest extends BaseJunitTest {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceTest.class);
	
	@Resource
	private MemberService memberService;

	@Test
	public void testGetMemberList() {
		List<Member> list = this.memberService.getMemberList();
		if (list != null) {
			log.info("----------" + list.size());
			assertEquals(0, list.size());
		}
	}

}
