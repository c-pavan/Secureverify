package com.secureVerify.util;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class SecureVerifyMail {

	private static Logger log = Logger.getLogger(SecureVerifyMail.class);
	
	public static void postMail(String touser, String frmuser, String subject, String body, String smtpHost, String smtpPort1, 
			String smtpPort2, String smtpSocketFactory, String smtpSocketFactoryPort, String smtpAuth, String smtpUserId,
			String smtpPassword, String adminId){				
		
		Properties props = new Properties();
    	props.put("mail.smtp.host", smtpHost);
    	props.put("mail.smtp.socketFactory.port", smtpSocketFactoryPort);
    	props.put("mail.smtp.socketFactory.class", smtpSocketFactory);
    	props.put("mail.smtp.auth", smtpAuth);
    	props.put("mail.smtp.port", smtpPort1);
 
    	final String userId = smtpUserId, password = smtpPassword; 
    	
		Session session = Session.getInstance(props,
		new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{ return new PasswordAuthentication(userId, password);	}
		});		
 
    	try {
 
	        Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(frmuser));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(touser));
		    message.setSubject(subject);
		    message.setContent(body, "text/html");
	 
		    Transport.send(message);
  
    	} catch (MessagingException e) {
    		String host = smtpHost;
        	int port = Integer.parseInt(smtpPort2);
        	
        	try{
	    		Message message2 = new MimeMessage(session);
	    	    message2.setFrom(new InternetAddress(frmuser));
	    	    message2.setRecipients(Message.RecipientType.TO, InternetAddress.parse(touser));
	    	    message2.setSubject(subject);
	    	    message2.setContent(body, "text/html");
	    	    Transport transport = session.getTransport("smtp");
	    	    transport.connect(host, port, userId, password);
	     
	    	    Transport.send(message2);
        	}catch (MessagingException me) {log.error(me.getMessage()); }
    	    throw new RuntimeException(e);
    	}
	}
	
	public static void postMailWithCCEMail(String touser, String ccuser, String frmuser, String subject, String body, String smtpHost, String smtpPort1, 
			String smtpPort2, String smtpSocketFactory, String smtpSocketFactoryPort, String smtpAuth, String smtpUserId,
			String smtpPassword, String adminId){				
		
		Properties props = new Properties();
    	props.put("mail.smtp.host", smtpHost);
    	props.put("mail.smtp.socketFactory.port", smtpSocketFactoryPort);
    	props.put("mail.smtp.socketFactory.class", smtpSocketFactory);
    	props.put("mail.smtp.auth", smtpAuth);
    	props.put("mail.smtp.port", smtpPort1);
 
    	final String userId = smtpUserId, password = smtpPassword; 
    	
		Session session = Session.getInstance(props,
		new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{ return new PasswordAuthentication(userId, password);	}
		});		
 
    	try {
 
	        Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(frmuser));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(touser));
		    message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccuser));
		    message.setSubject(subject);
		    message.setContent(body, "text/html");
	 
		    Transport.send(message);
  
    	} catch (MessagingException e) {
    		String host = smtpHost;
        	int port = Integer.parseInt(smtpPort2);
        	
        	try{
	    		Message message2 = new MimeMessage(session);
	    	    message2.setFrom(new InternetAddress(frmuser));
	    	    message2.setRecipients(Message.RecipientType.TO, InternetAddress.parse(touser));
	    	    message2.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccuser));
	    	    message2.setSubject(subject);
	    	    message2.setContent(body, "text/html");
	    	    Transport transport = session.getTransport("smtp");
	    	    transport.connect(host, port, userId, password);
	     
	    	    Transport.send(message2);
        	}catch (MessagingException me) {log.error(me.getMessage()); }
    	    throw new RuntimeException(e);
    	}
	}
	
	public static void postMailWithAttachemnt(String touser, String frmuser, String subject, String body, String smtpHost, String smtpPort1, 
			String smtpPort2, String smtpSocketFactory, String smtpSocketFactoryPort, String smtpAuth, String smtpUserId,
			String smtpPassword, String adminId, File file, String fileName){				
		
		Properties props = new Properties();
    	props.put("mail.smtp.host", smtpHost);
    	props.put("mail.smtp.socketFactory.port", smtpSocketFactoryPort);
    	props.put("mail.smtp.socketFactory.class", smtpSocketFactory);
    	props.put("mail.smtp.auth", smtpAuth);
    	props.put("mail.smtp.port", smtpPort1);
 
    	final String userId = smtpUserId, password = smtpPassword; 
    	
		Session session = Session.getInstance(props,
		new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{ return new PasswordAuthentication(userId, password);	}
		});		
 
    	try {
 
	        Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(frmuser));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(touser));
		    message.setSubject(subject);
		    message.setContent(body, "text/html");
		    MimeBodyPart messageBodyPart =  new MimeBodyPart();

		    //fill message
		    messageBodyPart.setText(body);

		    Multipart multipart = new MimeMultipart();
		    multipart.addBodyPart(messageBodyPart);

		    // Part two is attachment
		    messageBodyPart = new MimeBodyPart();
		    DataSource source = new FileDataSource(file);
		    messageBodyPart.setDataHandler( new DataHandler(source));
		    messageBodyPart.setFileName(fileName);
		    multipart.addBodyPart(messageBodyPart);

		    // Put parts in message
		    message.setContent(multipart);
	 
		    Transport.send(message);
  
    	} catch (MessagingException e) {
    		String host = smtpHost;
        	int port = Integer.parseInt(smtpPort2);
        	
        	try{
	    		Message message2 = new MimeMessage(session);
	    	    message2.setFrom(new InternetAddress(frmuser));
	    	    message2.setRecipients(Message.RecipientType.TO, InternetAddress.parse(touser));
	    	    message2.setSubject(subject);
	    	    message2.setContent(body, "text/html");
	    	    
	    	    MimeBodyPart messageBodyPart =  new MimeBodyPart();

			    //fill message
			    messageBodyPart.setText(body);

			    Multipart multipart = new MimeMultipart();
			    multipart.addBodyPart(messageBodyPart);

			    // Part two is attachment
			    messageBodyPart = new MimeBodyPart();
			    DataSource source = new FileDataSource(file);
			    messageBodyPart.setDataHandler( new DataHandler(source));
			    messageBodyPart.setFileName(fileName);
			    multipart.addBodyPart(messageBodyPart);

			    // Put parts in message
			    message2.setContent(multipart);
			    
	    	    Transport transport = session.getTransport("smtp");
	    	    transport.connect(host, port, userId, password);
	     
	    	    Transport.send(message2);
        	}catch (MessagingException me) {log.error(me.getMessage()); }
    	    throw new RuntimeException(e);
    	}
	}
}
