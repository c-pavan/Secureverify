package com.secureVerify.model;

import java.util.Date;


public class Employer implements java.io.Serializable {

	private static final long serialVersionUID = 4139190707165124186L;
	
	private Integer employerId;
	private String employerFirstName;
	private String employerLastName;
	private String employerEmailId;
	private String employerPassword;
	private String employerPhoneNo;
	private String employerPhoneNoExtension;
	private String employerAlternatePhone;
	private String employerAlternatePhoneNoExtension;
	private String employerCompanyName;
	private String employerTitle;
	private String employerAddressLine1;
	private String employerAddressLine2;
	private String employerCity;
	private String employerState;
	private String employerCountry;
	private String employerZipcode;
	private Date creationDate;
	private Date lastModifiedTime;
	private String verificationCode;
	private Integer status;
	
	public Employer(){
		
	}

	public Employer(Integer employerId, String employerFirstName, String employerLastName, String employerEmailId, 
			String employerPassword, String employerPhoneNo, String employerPhoneNoExtension, String employerAlternatePhone, 
			String employerAlternatePhoneNoExtension, String employerCompanyName, String employerTitle, String employerAddressLine1, 
			String employerAddressLine2, String employerCity, String employerState, String employerCountry, String employerZipcode, 
			Date creationDate, Date lastModifiedTime, String verificationCode, Integer status){
		this.employerId = employerId;
		this.employerFirstName = employerFirstName;
		this.employerLastName = employerLastName;
		this.employerEmailId = employerEmailId;
		this.employerPassword = employerPassword;
		this.employerPhoneNo = employerPhoneNo;
		this.employerPhoneNoExtension = employerPhoneNoExtension;
		this.employerAlternatePhone = employerAlternatePhone;
		this.employerAlternatePhoneNoExtension = employerAlternatePhoneNoExtension;
		this.employerCompanyName = employerCompanyName;
		this.employerTitle = employerTitle;
		this.employerAddressLine1 = employerAddressLine1;
		this.employerAddressLine2 = employerAddressLine2;
		this.employerCity = employerCity;
		this.employerState = employerState;
		this.employerCountry = employerCountry;
		this.employerZipcode = employerZipcode;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.verificationCode = verificationCode;
		this.status = status;
	}

	public Employer(String employerFirstName, String employerLastName, String employerEmailId, 
			String employerPassword, String employerPhoneNo, String employerPhoneNoExtension, String employerAlternatePhone, 
			String employerAlternatePhoneNoExtension, String employerCompanyName, String employerTitle, String employerAddressLine1, 
			String employerAddressLine2, String employerCity, String employerState, String employerCountry, String employerZipcode, 
			Date creationDate, Date lastModifiedTime, String verificationCode, Integer status){
		this.employerFirstName = employerFirstName;
		this.employerLastName = employerLastName;
		this.employerEmailId = employerEmailId;
		this.employerPassword = employerPassword;
		this.employerPhoneNo = employerPhoneNo;
		this.employerPhoneNoExtension = employerPhoneNoExtension;
		this.employerAlternatePhone = employerAlternatePhone;
		this.employerAlternatePhoneNoExtension = employerAlternatePhoneNoExtension;
		this.employerCompanyName = employerCompanyName;
		this.employerTitle = employerTitle;
		this.employerAddressLine1 = employerAddressLine1;
		this.employerAddressLine2 = employerAddressLine2;
		this.employerCity = employerCity;
		this.employerState = employerState;
		this.employerCountry = employerCountry;
		this.employerZipcode = employerZipcode;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.verificationCode = verificationCode;
		this.status = status;
	}

	public Integer getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}

	public String getEmployerFirstName() {
		return employerFirstName;
	}

	public void setEmployerFirstName(String employerFirstName) {
		this.employerFirstName = employerFirstName;
	}

	public String getEmployerLastName() {
		return employerLastName;
	}

	public void setEmployerLastName(String employerLastName) {
		this.employerLastName = employerLastName;
	}

	public String getEmployerEmailId() {
		return employerEmailId;
	}

	public void setEmployerEmailId(String employerEmailId) {
		this.employerEmailId = employerEmailId;
	}

	public String getEmployerPassword() {
		return employerPassword;
	}

	public void setEmployerPassword(String employerPassword) {
		this.employerPassword = employerPassword;
	}

	public String getEmployerPhoneNo() {
		return employerPhoneNo;
	}

	public void setEmployerPhoneNo(String employerPhoneNo) {
		this.employerPhoneNo = employerPhoneNo;
	}

	public String getEmployerPhoneNoExtension() {
		return employerPhoneNoExtension;
	}

	public void setEmployerPhoneNoExtension(String employerPhoneNoExtension) {
		this.employerPhoneNoExtension = employerPhoneNoExtension;
	}

	public String getEmployerAlternatePhone() {
		return employerAlternatePhone;
	}

	public void setEmployerAlternatePhone(String employerAlternatePhone) {
		this.employerAlternatePhone = employerAlternatePhone;
	}

	public String getEmployerAlternatePhoneNoExtension() {
		return employerAlternatePhoneNoExtension;
	}

	public void setEmployerAlternatePhoneNoExtension(
			String employerAlternatePhoneNoExtension) {
		this.employerAlternatePhoneNoExtension = employerAlternatePhoneNoExtension;
	}

	public String getEmployerCompanyName() {
		return employerCompanyName;
	}

	public void setEmployerCompanyName(String employerCompanyName) {
		this.employerCompanyName = employerCompanyName;
	}

	public String getEmployerTitle() {
		return employerTitle;
	}

	public void setEmployerTitle(String employerTitle) {
		this.employerTitle = employerTitle;
	}

	public String getEmployerAddressLine1() {
		return employerAddressLine1;
	}

	public void setEmployerAddressLine1(String employerAddressLine1) {
		this.employerAddressLine1 = employerAddressLine1;
	}

	public String getEmployerAddressLine2() {
		return employerAddressLine2;
	}

	public void setEmployerAddressLine2(String employerAddressLine2) {
		this.employerAddressLine2 = employerAddressLine2;
	}

	public String getEmployerCity() {
		return employerCity;
	}

	public void setEmployerCity(String employerCity) {
		this.employerCity = employerCity;
	}

	public String getEmployerState() {
		return employerState;
	}

	public void setEmployerState(String employerState) {
		this.employerState = employerState;
	}

	public String getEmployerCountry() {
		return employerCountry;
	}

	public void setEmployerCountry(String employerCountry) {
		this.employerCountry = employerCountry;
	}

	public String getEmployerZipcode() {
		return employerZipcode;
	}

	public void setEmployerZipcode(String employerZipcode) {
		this.employerZipcode = employerZipcode;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
}
