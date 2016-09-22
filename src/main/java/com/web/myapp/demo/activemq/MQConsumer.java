package com.web.myapp.demo.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MQConsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER ;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD ;
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL ;

    public static void startMQ(String queueName) {
    	// 创建会话工厂
    	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);
    	Connection connection = null;
    	try {
        	// 创建连接
        	connection = connectionFactory.createConnection();
        	// 启动连接
            connection.start();
            // 创建会话 AUTO_ACKNOWLEDGE，常用的接收方式
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE) ;
            // 消息的目的地——创建消息队列
            Destination destination= session.createQueue(queueName); 
            // 消息的生产者
            MessageConsumer messageConsumer = session.createConsumer(destination) ;
            // 设置消息队列监听器
            messageConsumer.setMessageListener(new MQListener());
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
    
    public static void main(String[] args) {
		startMQ("quenedemo");
	}
}
