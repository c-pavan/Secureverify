package com.secureVerify.model;

import java.util.Date;

public class Agent implements java.io.Serializable {

	private static final long serialVersionUID = 5863855431209393579L;
	
	private Integer agentId;
	private String agentFirstName;
	private String agentLastName;
	private String agentEmailId;
	private String agentPassword;
	private String agentPhoneNo;
	private String agentPhoneNoExtension;
	private String agentAlternatePhone;
	private String agentAlternatePhoneNoExtension;
	private String agentMarket1;
	private String agentMarket2;
	private String agentMarket3;
	private String agentAddressLine1;
	private String agentAddressLine2;
	private String agentCity;
	private String agentState;
	private String agentCountry;
	private String agentZipcode;
	private String createdByName;
	private Integer createdBy;
	private String lastModifiedByName;
	private Integer lastModifiedBy;
	private Date creationDate;
	private Date lastModifiedTime;
	private String verificationCode;
	private Integer status;
	
	public Agent(){
		
	}

	public Agent(Integer agentId, String agentFirstName, String agentLastName, String agentEmailId, 
			String agentPassword, String agentPhoneNo, String agentPhoneNoExtension, String agentAlternatePhone, 
			String agentAlternatePhoneNoExtension, String agentMarket1, String agentMarket2, String agentMarket3, 
			String agentAddressLine1, String agentAddressLine2, String agentCity, String agentState, 
			String agentCountry, String agentZipcode, Integer createdBy, Integer lastModifiedBy, 
			Date creationDate, Date lastModifiedTime, String verificationCode, Integer status){
		this.agentId = agentId;
		this.agentFirstName = agentFirstName;
		this.agentLastName = agentLastName;
		this.agentEmailId = agentEmailId;
		this.agentPassword = agentPassword;
		this.agentPhoneNo = agentPhoneNo;
		this.agentPhoneNoExtension = agentPhoneNoExtension;
		this.agentAlternatePhone = agentAlternatePhone;
		this.agentAlternatePhoneNoExtension = agentAlternatePhoneNoExtension;
		this.agentMarket1 = agentMarket1;
		this.agentMarket2 = agentMarket2;
		this.agentMarket3 = agentMarket3;
		this.agentAddressLine1 = agentAddressLine1;
		this.agentAddressLine2 = agentAddressLine2;
		this.agentCity = agentCity;
		this.agentState = agentState;
		this.agentCountry = agentCountry;
		this.agentZipcode = agentZipcode;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.verificationCode = verificationCode;
		this.status = status;
	}

	public Agent(String agentFirstName, String agentLastName, String agentEmailId, 
			String agentPassword, String agentPhoneNo, String agentPhoneNoExtension, String agentAlternatePhone, 
			String agentAlternatePhoneNoExtension, String agentMarket1, String agentMarket2, String agentMarket3, 
			String agentAddressLine1, String agentAddressLine2, String agentCity, String agentState, 
			String agentCountry, String agentZipcode, Integer createdBy, Integer lastModifiedBy, 
			Date creationDate, Date lastModifiedTime, String verificationCode, Integer status){
		this.agentFirstName = agentFirstName;
		this.agentLastName = agentLastName;
		this.agentEmailId = agentEmailId;
		this.agentPassword = agentPassword;
		this.agentPhoneNo = agentPhoneNo;
		this.agentPhoneNoExtension = agentPhoneNoExtension;
		this.agentAlternatePhone = agentAlternatePhone;
		this.agentAlternatePhoneNoExtension = agentAlternatePhoneNoExtension;
		this.agentMarket1 = agentMarket1;
		this.agentMarket2 = agentMarket2;
		this.agentMarket3 = agentMarket3;
		this.agentAddressLine1 = agentAddressLine1;
		this.agentAddressLine2 = agentAddressLine2;
		this.agentCity = agentCity;
		this.agentState = agentState;
		this.agentCountry = agentCountry;
		this.agentZipcode = agentZipcode;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.verificationCode = verificationCode;
		this.status = status;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getAgentFirstName() {
		return agentFirstName;
	}

	public void setAgentFirstName(String agentFirstName) {
		this.agentFirstName = agentFirstName;
	}

	public String getAgentLastName() {
		return agentLastName;
	}

	public void setAgentLastName(String agentLastName) {
		this.agentLastName = agentLastName;
	}

	public String getAgentEmailId() {
		return agentEmailId;
	}

	public void setAgentEmailId(String agentEmailId) {
		this.agentEmailId = agentEmailId;
	}

	public String getAgentPassword() {
		return agentPassword;
	}

	public void setAgentPassword(String agentPassword) {
		this.agentPassword = agentPassword;
	}

	public String getAgentPhoneNo() {
		return agentPhoneNo;
	}

	public void setAgentPhoneNo(String agentPhoneNo) {
		this.agentPhoneNo = agentPhoneNo;
	}

	public String getAgentPhoneNoExtension() {
		return agentPhoneNoExtension;
	}

	public void setAgentPhoneNoExtension(String agentPhoneNoExtension) {
		this.agentPhoneNoExtension = agentPhoneNoExtension;
	}

	public String getAgentAlternatePhone() {
		return agentAlternatePhone;
	}

	public void setAgentAlternatePhone(String agentAlternatePhone) {
		this.agentAlternatePhone = agentAlternatePhone;
	}

	public String getAgentAlternatePhoneNoExtension() {
		return agentAlternatePhoneNoExtension;
	}

	public void setAgentAlternatePhoneNoExtension(
			String agentAlternatePhoneNoExtension) {
		this.agentAlternatePhoneNoExtension = agentAlternatePhoneNoExtension;
	}

	public String getAgentMarket1() {
		return agentMarket1;
	}

	public void setAgentMarket1(String agentMarket1) {
		this.agentMarket1 = agentMarket1;
	}

	public String getAgentMarket2() {
		return agentMarket2;
	}

	public void setAgentMarket2(String agentMarket2) {
		this.agentMarket2 = agentMarket2;
	}

	public String getAgentMarket3() {
		return agentMarket3;
	}

	public void setAgentMarket3(String agentMarket3) {
		this.agentMarket3 = agentMarket3;
	}

	public String getAgentAddressLine1() {
		return agentAddressLine1;
	}

	public void setAgentAddressLine1(String agentAddressLine1) {
		this.agentAddressLine1 = agentAddressLine1;
	}

	public String getAgentAddressLine2() {
		return agentAddressLine2;
	}

	public void setAgentAddressLine2(String agentAddressLine2) {
		this.agentAddressLine2 = agentAddressLine2;
	}

	public String getAgentCity() {
		return agentCity;
	}

	public void setAgentCity(String agentCity) {
		this.agentCity = agentCity;
	}

	public String getAgentState() {
		return agentState;
	}

	public void setAgentState(String agentState) {
		this.agentState = agentState;
	}

	public String getAgentCountry() {
		return agentCountry;
	}

	public void setAgentCountry(String agentCountry) {
		this.agentCountry = agentCountry;
	}

	public String getAgentZipcode() {
		return agentZipcode;
	}

	public void setAgentZipcode(String agentZipcode) {
		this.agentZipcode = agentZipcode;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
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

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public String getLastModifiedByName() {
		return lastModifiedByName;
	}

	public void setLastModifiedByName(String lastModifiedByName) {
		this.lastModifiedByName = lastModifiedByName;
	}
	
	
}
