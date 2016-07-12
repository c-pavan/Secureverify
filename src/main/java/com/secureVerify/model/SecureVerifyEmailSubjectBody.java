package com.secureVerify.model;

public class SecureVerifyEmailSubjectBody implements java.io.Serializable {
	
	private static final long serialVersionUID = 7247932013728613561L;
	
	private Integer emailUniqueId;
	private Integer emailSendingType;
	private String emailSubject;
	private String emailBody;
	
	public SecureVerifyEmailSubjectBody(){
		
	}

	public SecureVerifyEmailSubjectBody(Integer emailUniqueId, Integer emailSendingType, String emailSubject, String emailBody){
		this.emailUniqueId = emailUniqueId;
		this.emailSendingType = emailSendingType;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}

	public SecureVerifyEmailSubjectBody(Integer emailSendingType, String emailSubject, String emailBody){
		this.emailSendingType = emailSendingType;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}

	public Integer getEmailUniqueId() {
		return emailUniqueId;
	}

	public void setEmailUniqueId(Integer emailUniqueId) {
		this.emailUniqueId = emailUniqueId;
	}

	public Integer getEmailSendingType() {
		return emailSendingType;
	}

	public void setEmailSendingType(Integer emailSendingType) {
		this.emailSendingType = emailSendingType;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

}
