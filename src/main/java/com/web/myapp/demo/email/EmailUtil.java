package com.web.myapp.demo.email;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.web.myapp.core.config.CommonConfig;
import com.web.myapp.util.RegexUtil;

/**   
 * 电子邮件  
 */
public class EmailUtil {
	private static String host;
	private static String username;
	private static String password;
	
	static {
		host = CommonConfig.getValue("host");
		username = CommonConfig.getValue("username");
		password = CommonConfig.getValue("password");
	}
	
	public static void sendFileMail(String[] toUsers, String fromUser, String subject, 
			String content, Map<String, String> attachments) throws MessagingException {     
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();     
		// 设定mail server     
		senderImpl.setHost(host);    
		senderImpl.setUsername(username);    
		senderImpl.setPassword(password);    
		// 建立HTML邮件消息     
		MimeMessage mailMessage = senderImpl.createMimeMessage();     
		// true表示开始附件模式     
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");     
		// 设置收件人
		messageHelper.setTo(toUsers);
//		InternetAddress[] addresses = new InternetAddress[toUsers.length];
//		for (int i = 0; i < toUsers.length; i++) {
//			addresses[i] = new InternetAddress(toUsers[i]);
//		}
//		messageHelper.setTo(addresses);
		messageHelper.setFrom(fromUser);
		messageHelper.setSubject(subject);     
		// true表示启动HTML格式的邮件     
		messageHelper.setText(content, true);
		messageHelper.setSentDate(new Date());
		// 添加附件
		try {
			for (Map.Entry<String, String> entry : attachments.entrySet()) {
				String fileName = entry.getKey();
				String filePath = entry.getValue();
				FileSystemResource file = new FileSystemResource(new File(filePath));
				//附件名有中文可能出现乱码     
				if (RegexUtil.isContainChinese(fileName)) {
					messageHelper.addAttachment(MimeUtility.encodeWord(fileName), file);     
				} else {
					messageHelper.addAttachment(fileName, file);
				}
			}
		} catch (UnsupportedEncodingException e) {     
		    e.printStackTrace();     
		    throw new MessagingException();     
		}     
		// 发送邮件     
		senderImpl.send(mailMessage);     
		System.out.println("邮件发送成功.....");     
	}
	
//	public static void main(String[] args) throws MessagingException {
//		String content = "<html><head></head><body><h1>你好：附件！！</h1></body></html>";
//		Map<String, String> attachments = new HashMap<String, String>();
//		attachments.put("test.png", "d:/temp/test.png");
//		attachments.put("读书.txt", "d:/temp/读书.txt");
//		String[] toUsers = new String[]{"625337923@qq.com", "625337923@qq.com"};
//		sendFileMail(toUsers, "jyf20112061@163.com", "测试邮件！", 
//				content, attachments);
//	}

}
