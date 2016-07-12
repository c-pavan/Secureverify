package com.secureVerify.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;

import com.secureVerify.model.Propertie;

public class Helper {
	
	private static Properties properties;
	
	@SuppressWarnings("rawtypes")
	public static Properties getPropertiesFromFile(){	
		if(properties == null){
			ResourceBundle bundle = ResourceBundle.getBundle("com.secureVerify.properties.resource");				
			properties = new Properties();
	        for (Enumeration keys = bundle.getKeys (); keys.hasMoreElements ();){
	            String key = (String) keys.nextElement ();
	            String value = bundle.getString (key);
	            properties.put (key, value);
	        } 
		}
		return properties;
	}
	
	@SuppressWarnings("rawtypes")
	public static List<?> pagedList(List<?> currentList, Integer pageNo, Integer  pageSize){
		List<?> tmpList = null;
		if(currentList!=null && currentList.size()>=((pageNo-1)*pageSize) && pageNo>0 && pageSize>0){
			if(currentList.size()>=((pageNo)*pageSize)){
				tmpList = currentList.subList((pageNo-1)*pageSize, (pageNo)*pageSize); 
			}else{
				tmpList = currentList.subList((pageNo-1)*pageSize, currentList.size()); 
			}
		}else{
			tmpList = new ArrayList();
		}
		return tmpList;
	}	

	@SuppressWarnings("unused")
	public static String nextUniqueId ( String s ) { 
		int Num1 = 0, Num2 = 0, Num3 = 0, Num4 = 0, Num5 = 0, Num6 = 0, Num7 = 0, Ltr1 = 0, Ltr2 = 0; 
		int add1, add2, add3, add4, add5, add6, add7, add8, add9, carry1, carry2, carry3, carry4, carry5, carry6, carry7, carry8, carry9;

		String inputString ="";
		String nextUniqueId = "";
		inputString = s;
		
		// Process the first digit 
		Num1 = (int)inputString.charAt(8) - 48; 
		add1 = (char)(48 +(Num1+1)%10); 
		carry1 = (char)(48 + (Num1 + 1)/10); 


		// Process the second digit 
		Num2 = (int)inputString.charAt(7) - 48; 
		add2 = (char)(48 +(Num2+ (carry1 - 48))%10); 
		carry2 = (char)(48 + (Num2 + (carry1 - 48))/10); 


		// Process the third digit 
		Num3 = (int)inputString.charAt(6) - 48; 
		add3 = (char)(48 +(Num3+ (carry2 - 48))%10); 
		carry3 = (char)(48 + (Num3 + (carry2 - 48))/10); 

		// Process the fourth digit 
		Num4 = (int)inputString.charAt(5)- 48; 
		add4 = (char)(48 +(Num4+ (carry3 - 48))%10); 
		carry4 = (char)(48 + (Num4 + (carry3 - 48))/10); 

		// Process the fifth digit 
		Num5 = (int)inputString.charAt(4)- 48; 
		add5 = (char)(48 +(Num5+ (carry4 - 48))%10); 
		carry5 = (char)(48 + (Num5 + (carry4 - 48))/10); 

		// Process the sixth digit 
		Num6 = (int)inputString.charAt(3)- 48; 
		add6 = (char)(48 +(Num6+ (carry5 - 48))%10); 
		carry6 = (char)(48 + (Num6 + (carry5 - 48))/10); 

		// Process the seventh digit 
		Num7 = (int)inputString.charAt(2)- 48; 
		add7 = (char)(48 +(Num7+ (carry6 - 48))%10); 
		carry7 = (char)(48 + (Num7 + (carry6 - 48))/10); 

		// Process the first character 
		Ltr1 =(char)inputString.charAt(1) - 65;
		add8 = (char)(65 + (Ltr1 + (carry7 - 48))%26);
		carry8 = (char)(65 + (Ltr1 + (carry7 - 48))/26); 


		// Process the second character 
		Ltr2 =(char)inputString.charAt(0) - 65; 
		add9 = (char)(65 + (Ltr2 + (carry8 - 65))%26); 
		carry9 = (char)(65 + (Ltr2 + (carry8 - 65))/26); 


		nextUniqueId = ("" + (char)add9 + (char)add8 + (char)add7 + (char)add6 + (char)add5 + (char)add4 + (char)add3 + (char)add2 + (char) add1);

		return nextUniqueId; 
	}
	
	public static String getRandomString() { 
		return RandomStringUtils.randomAlphanumeric(9).toUpperCase();
	}

	public static String getRandomCouponCode() { 
		return RandomStringUtils.randomAlphanumeric(6).toUpperCase();
	}
	

	public static void candidateTimeSlotSelectedEmails(Propertie propertie, String subject, String body, String emailId, String skillSet, String location, String address, String phone, Date fromTime, Date toTime) {
		
		subject = subject.replaceAll("#skillset#", skillSet).replaceAll("#candidate#", emailId).replaceAll("#location#", location);
		
		body = body.replaceAll("#candidate#", emailId).	replaceAll("#skillset#", skillSet).replaceAll("#location#", location).replaceAll("#address#", address).
				replaceAll("#phone#", phone).replaceAll("#fromtime#", ""+fromTime).replaceAll("#totime#", ""+toTime);
		
		SecureVerifyMail.postMail(emailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
				propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
				propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
				propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
	}

	public static void candidateTimeSlotPickedByInterviewerEmails(Propertie propertie, String subject, String body, String emailId, String skillSet, String location, String address, String phone, Date fromTime, Date toTime) {
		
		subject = subject.replaceAll("#skillset#", skillSet).replaceAll("#candidate#", emailId).replaceAll("#location#", location);
		
		body = body.replaceAll("#candidate#", emailId).	replaceAll("#skillset#", skillSet).replaceAll("#location#", location).replaceAll("#address#", address).
				replaceAll("#phone#", phone).replaceAll("#fromtime#", ""+fromTime).replaceAll("#totime#", ""+toTime);
		
		SecureVerifyMail.postMail(emailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
				propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
				propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
				propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
	}

	public static void candidateTimeSlotFeedbackByInterviewerEmails(Propertie propertie, String subject, String body, String emailId, String skillSet, String location, String address, String phone, Date fromTime, Date toTime, String verificationId, String performance, String feedback) {
		
		subject = subject.replaceAll("#skillset#", skillSet).replaceAll("#candidate#", emailId).replaceAll("#location#", location);
		
		body = body.replaceAll("#candidate#", emailId).	replaceAll("#skillset#", skillSet).replaceAll("#location#", location).replaceAll("#address#", address).
				replaceAll("#phone#", phone).replaceAll("#fromtime#", ""+fromTime).replaceAll("#totime#", ""+toTime).replaceAll("#verificationid#", verificationId).replaceAll("#performance#", performance).replaceAll("#feedback#", feedback);
		
		SecureVerifyMail.postMail(emailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
				propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
				propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
				propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
	}

	
	

}
