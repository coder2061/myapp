package com.web.myapp.module.service;

import java.util.List;

import com.web.myapp.module.entity.Message;

/**   
 * message接口
 * @author jiangyf   
 * @since 2016年9月7日 下午7:41:42 
 * @version V1.0   
 */
public interface MessageService {
	
	void createMessage(Message message);
	
	List<Message> getMessagelList(Integer pageNum, Integer pageSize);
	
	int getMessageCount(String userName);

}
