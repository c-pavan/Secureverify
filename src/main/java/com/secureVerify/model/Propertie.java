package com.secureVerify.model;

public class Propertie implements java.io.Serializable {
	
	private static final long serialVersionUID = 5445971381774799930L;
	
	private Integer id;
	private String smtpHost;
	private String smtpPort1;
	private String smtpPort2;
	private String smtpSocketFactory;
	private String smtpSocketFactoryport;
	private String smtpAuth;
	private String smtpUserid;
	private String smtpPassword;
	private String adminId;
	

	public Propertie() {
	}

	public Propertie(String smtpHost, String smtpPort1, String smtpPort2, String smtpSocketFactory, String smtpSocketFactoryport,
			String smtpAuth, String smtpUserid, String smtpPassword, String adminId) {
		this.smtpHost = smtpHost;
		this.smtpPort1 = smtpPort1;
		this.smtpPort2 = smtpPort2;
		this.smtpSocketFactory = smtpSocketFactory;
		this.smtpSocketFactoryport = smtpSocketFactoryport;
		this.smtpAuth = smtpAuth;
		this.smtpUserid = smtpUserid;
		this.smtpPassword = smtpPassword;
		this.adminId = adminId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpPort1() {
		return smtpPort1;
	}

	public void setSmtpPort1(String smtpPort1) {
		this.smtpPort1 = smtpPort1;
	}

	public String getSmtpPort2() {
		return smtpPort2;
	}

	public void setSmtpPort2(String smtpPort2) {
		this.smtpPort2 = smtpPort2;
	}

	public String getSmtpSocketFactory() {
		return smtpSocketFactory;
	}

	public void setSmtpSocketFactory(String smtpSocketFactory) {
		this.smtpSocketFactory = smtpSocketFactory;
	}

	public String getSmtpSocketFactoryport() {
		return smtpSocketFactoryport;
	}

	public void setSmtpSocketFactoryport(String smtpSocketFactoryport) {
		this.smtpSocketFactoryport = smtpSocketFactoryport;
	}

	public String getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getSmtpUserid() {
		return smtpUserid;
	}

	public void setSmtpUserid(String smtpUserid) {
		this.smtpUserid = smtpUserid;
	}

	public String getSmtpPassword() {
		return smtpPassword;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

}
