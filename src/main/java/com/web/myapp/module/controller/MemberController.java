package com.web.myapp.module.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.myapp.core.cache.RedisCacheUtil;
import com.web.myapp.module.entity.Member;

/**   
 * 
 * @author jiangyf   
 * @since 2016年10月10日 下午7:11:37 
 * @version V1.0   
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
    private RedisCacheUtil<Member> redisCache;

    @RequestMapping("testGetCache")
    public void testGetCache() {
        Map<Object, Object> members = redisCache.getCacheIntegerMap("members");
        
        for(Object key : members.keySet()) {
            System.out.println("key = " + key + ",value=" + members.get(key));
        }
        
    }

}
