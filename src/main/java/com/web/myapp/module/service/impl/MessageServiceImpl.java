package com.web.myapp.module.service.impl;

import javax.annotation.Resource;

import com.web.myapp.module.dao.MessageDao;
import com.web.myapp.module.entity.Message;
import com.web.myapp.module.service.MessageService;

/**   
 * Function: message接口实现 
 * @author jiangyf   
 * @since 2016年9月7日 下午7:42:02 
 * @version V1.0   
 */
public class MessageServiceImpl implements MessageService {
	@Resource
	private MessageDao messageDao;

	@Override
	public void createMessage(Message message) {
		this.messageDao.insertSelective(message);
	}

}
