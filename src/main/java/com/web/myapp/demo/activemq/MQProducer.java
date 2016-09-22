package com.web.myapp.demo.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class MQProducer {
	private static final Logger log = LoggerFactory.getLogger(MQProducer.class);
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER ;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD ;
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL ;
    private static final int NUM = 10 ;
    
    /**  
     * Function: 发送消息
     * @param msg
     * @param queueName
     */
    public static void sendMsg(String msg, String queueName) {
    	// 创建会话工厂
    	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);
    	Connection connection = null;
    	try {
        	// 创建连接
        	connection = connectionFactory.createConnection();
        	// 启动连接
            connection.start();
            // 创建会话 AUTO_ACKNOWLEDGE，常用的接收方式
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 消息的目的地——创建消息队列
            Destination destination = session.createQueue(queueName);
            MessageProducer messageProducer = session.createProducer(destination);
            // 发送消息
            sendMsg(msg, session, messageProducer);
            //提交事务
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**  
    * Function: 发送消息
    * @param msg
    * @param session
    * @param messageProducer
    */
    public static void sendMsg(String msg, Session session, MessageProducer messageProducer) {
        for (int i = 0; i < NUM; i++){
            try {
                TextMessage textMessage = session.createTextMessage("发送消息" + msg + "，第:" + i + "条");
                log.info("发送消息" + msg + "，第" + i + "条");
                messageProducer.send(textMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
