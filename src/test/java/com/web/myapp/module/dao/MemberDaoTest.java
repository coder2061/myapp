package com.web.myapp.module.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.myapp.base.BaseJunitTest;
import com.web.myapp.module.entity.Member;

/**   
 * Function: Dao层单元测试
 * @author jiangyf   
 * @since 2016年9月7日 上午11:39:23 
 * @version V1.0   
 */
public class MemberDaoTest extends BaseJunitTest {
	private static final Logger log = LoggerFactory.getLogger(MemberDaoTest.class);
	
	@Resource
	private MemberDao memberDao;

	@Test
	public void testSelectByPrimaryKey() {
		Member member = this.memberDao.selectByPrimaryKey(1);
		if (member != null) {
			log.info("----------" + member.getName());
		}
		Assert.assertNotNull(member);
	}

}
