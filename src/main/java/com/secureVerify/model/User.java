package com.secureVerify.model;

import java.util.Date;

public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 8755247933779025808L;
	
	private Integer userId;
	private String userEmailId;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userPhoneNo;
	private String userAddressLine1;
	private String userAddressLine2;
	private String userCity;
	private String userState;
	private String userCountry;
	private String userZipcode;
	private String userDesignation;
	private String verificationCode;
	private Date creationDate;
	private Date lastModifiedTime;
	private int status;
	
	public User(){
	}

	public User(Integer userId, String userEmailId, String userPassword, String userFirstName, 
			String userLastName, String userPhoneNo, String userAddressLine1, String userAddressLine2, 
			String userCity, String userState, String userCountry, String userZipcode, String userDesignation, 
			String verificationCode, Date creationDate, Date lastModifiedTime, int status){
		this.userId = userId;
		this.userEmailId = userEmailId;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPhoneNo = userPhoneNo;
		this.userAddressLine1 = userAddressLine1;
		this.userAddressLine2 = userAddressLine2;
		this.userCity = userCity;
		this.userState = userState;
		this.userCountry = userCountry;
		this.userZipcode = userZipcode;
		this.userDesignation = userDesignation;
		this.verificationCode = verificationCode;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}
	
	public User(String userEmailId, String userPassword, String userFirstName, 
			String userLastName, String userPhoneNo, String userAddressLine1, String userAddressLine2, 
			String userCity, String userState, String userCountry, String userZipcode, String userDesignation, 
			String verificationCode, Date creationDate, Date lastModifiedTime, int status){
		this.userEmailId = userEmailId;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPhoneNo = userPhoneNo;
		this.userAddressLine1 = userAddressLine1;
		this.userAddressLine2 = userAddressLine2;
		this.userCity = userCity;
		this.userState = userState;
		this.userCountry = userCountry;
		this.userZipcode = userZipcode;
		this.userDesignation = userDesignation;
		this.verificationCode = verificationCode;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public String getUserAddressLine1() {
		return userAddressLine1;
	}

	public void setUserAddressLine1(String userAddressLine1) {
		this.userAddressLine1 = userAddressLine1;
	}

	public String getUserAddressLine2() {
		return userAddressLine2;
	}

	public void setUserAddressLine2(String userAddressLine2) {
		this.userAddressLine2 = userAddressLine2;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getUserZipcode() {
		return userZipcode;
	}

	public void setUserZipcode(String userZipcode) {
		this.userZipcode = userZipcode;
	}

	public String getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
