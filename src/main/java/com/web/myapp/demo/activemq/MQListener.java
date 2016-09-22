package com.web.myapp.demo.activemq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息队列监听器
 */
public class MQListener implements MessageListener {
	private static final Logger log = LoggerFactory.getLogger(MQListener.class);
	
    @Override
    public void onMessage(Message message) {
        try {
            String text = ((TextMessage) message).getText();
            log.info("收到的信息是:" + text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
