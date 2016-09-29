package com.web.myapp.module.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.web.myapp.module.dao.MessageDao;
import com.web.myapp.module.entity.Message;
import com.web.myapp.module.entity.MessageExample;
import com.web.myapp.module.service.MessageService;

/**   
 * message接口实现 
 * @author jiangyf   
 * @since 2016年9月7日 下午7:42:02 
 * @version V1.0   
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Resource
	private MessageDao messageDao;

	@Override
	public void createMessage(Message message) {
		this.messageDao.insertSelective(message);
	}

	@Override
	public List<Message> getMessagelList(Integer pageNum, 
			Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Message> messagelList = this.messageDao
				.selectByExample(new MessageExample());
		return messagelList;
	}

	@Override
	public int getMessageCount(String userName) {
		return this.messageDao.countByExample(new MessageExample());
	}

}
