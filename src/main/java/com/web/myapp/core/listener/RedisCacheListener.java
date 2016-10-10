package com.web.myapp.core.listener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.web.myapp.core.cache.RedisCacheUtil;
import com.web.myapp.module.entity.Member;
import com.web.myapp.module.service.MemberService;

/**   
 * 监听器，用于项目启动的时候初始化信息
 * @author jiangyf   
 * @since 2016年10月10日 下午4:59:44 
 * @version V1.0   
 */
@Service
public class RedisCacheListener implements ApplicationListener<ContextRefreshedEvent> {
    //日志
    private final Logger log= Logger.getLogger(RedisCacheListener.class);
    
    @Autowired
    private RedisCacheUtil<Object> redisCache;
    
    @Autowired
    private MemberService memberService;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //spring 启动的时候缓存城市和国家等信息
        if(event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")) {
        	log.info("-----------缓存数据-----------");
            List<Member> memberList = memberService.getMemberList();
            Map<Integer, Object> members = new HashMap<Integer, Object>();
            for(int i = 0 ; i < memberList.size() ; i ++ ) {
            	members.put(memberList.get(i).getId(), memberList.get(i));
            }
            
            redisCache.setCacheIntegerMap("members", members);
        }
    }
    
}