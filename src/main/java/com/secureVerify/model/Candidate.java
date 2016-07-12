package com.secureVerify.model;

import java.util.Date;


public class Candidate implements java.io.Serializable {

	private static final long serialVersionUID = 2257837090133761862L;
	
	private Integer candidateId;
	private String candidateFirstName;
	private String candidateLastName;
	private String candidateEmailId;
	private String candidatePassword;
	private String candidatePhoneNo;
	private String candidatePhoneNoExtension;
	private String candidateAlternatePhone;
	private String candidateAlternatePhoneNoExtension;
	private Integer skillSetId;
	private String candidateResume;
	private byte[] candidateResumeBlob;
	private String candidateAddressLine1;
	private String candidateAddressLine2;
	private String candidateCity;
	private String candidateState;
	private String candidateCountry;
	private String candidateZipcode;
	private String candidatePrefferedLocation;
	private String candidateExpectedSalary;
	private Date creationDate;
	private Date lastModifiedTime;
	private String verificationCode;
	private Integer status;
	private SkillSet skillSet;
	private Employer employer;
	
	public Candidate(){
		
	}

	public Candidate(Integer candidateId, String candidateFirstName, String candidateLastName, 
			String candidateEmailId, String candidatePassword, String candidatePhoneNo, 
			String candidatePhoneNoExtension, String candidateAlternatePhone, String candidateAlternatePhoneNoExtension, 
			Integer skillSetId, String candidateResume, byte[] candidateResumeBlob, String candidateAddressLine1, 
			String candidateAddressLine2, String candidateCity, String candidateState, String candidateCountry, 
			String candidateZipcode, String candidatePrefferedLocation, String candidateExpectedSalary,  
			Date creationDate, Date lastModifiedTime, String verificationCode, Integer status){
		this.candidateId = candidateId;
		this.candidateFirstName = candidateFirstName;
		this.candidateLastName = candidateLastName;
		this.candidateEmailId = candidateEmailId;
		this.candidatePassword = candidatePassword;
		this.candidatePhoneNo = candidatePhoneNo;
		this.candidatePhoneNoExtension = candidatePhoneNoExtension;
		this.candidateAlternatePhone = candidateAlternatePhone;
		this.candidateAlternatePhoneNoExtension = candidateAlternatePhoneNoExtension;
		this.skillSetId = skillSetId;
		this.candidateResume = candidateResume;
		this.candidateResumeBlob = candidateResumeBlob;
		this.candidateAddressLine1 = candidateAddressLine1;
		this.candidateAddressLine2 = candidateAddressLine2;
		this.candidateCity = candidateCity;
		this.candidateState = candidateState;
		this.candidateCountry = candidateCountry;
		this.candidateZipcode = candidateZipcode;
		this.candidatePrefferedLocation = candidatePrefferedLocation;
		this.candidateExpectedSalary = candidateExpectedSalary;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.verificationCode = verificationCode;
		this.status = status;
	}

	public Candidate(String candidateFirstName, String candidateLastName, 
			String candidateEmailId, String candidatePassword, String candidatePhoneNo, 
			String candidatePhoneNoExtension, String candidateAlternatePhone, String candidateAlternatePhoneNoExtension, 
			Integer skillSetId, String candidateResume, byte[] candidateResumeBlob, String candidateAddressLine1, 
			String candidateAddressLine2, String candidateCity, String candidateState, String candidateCountry, 
			String candidateZipcode, String candidatePrefferedLocation, String candidateExpectedSalary,  
			Date creationDate, Date lastModifiedTime, String verificationCode, Integer status){
		this.candidateFirstName = candidateFirstName;
		this.candidateLastName = candidateLastName;
		this.candidateEmailId = candidateEmailId;
		this.candidatePassword = candidatePassword;
		this.candidatePhoneNo = candidatePhoneNo;
		this.candidatePhoneNoExtension = candidatePhoneNoExtension;
		this.candidateAlternatePhone = candidateAlternatePhone;
		this.candidateAlternatePhoneNoExtension = candidateAlternatePhoneNoExtension;
		this.skillSetId = skillSetId;
		this.candidateResume = candidateResume;
		this.candidateResumeBlob = candidateResumeBlob;
		this.candidateAddressLine1 = candidateAddressLine1;
		this.candidateAddressLine2 = candidateAddressLine2;
		this.candidateCity = candidateCity;
		this.candidateState = candidateState;
		this.candidateCountry = candidateCountry;
		this.candidateZipcode = candidateZipcode;
		this.candidatePrefferedLocation = candidatePrefferedLocation;
		this.candidateExpectedSalary = candidateExpectedSalary;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.verificationCode = verificationCode;
		this.status = status;
	}

	public Candidate(String candidateFirstName, String candidateLastName, String candidateEmailId, String candidatePhoneNo, 
			String candidatePhoneNoExtension, String candidateAlternatePhone, String candidateAlternatePhoneNoExtension, 
			Integer skillSetId, Date creationDate, Date lastModifiedTime, Integer status){
		this.candidateFirstName = candidateFirstName;
		this.candidateLastName = candidateLastName;
		this.candidateEmailId = candidateEmailId;
		this.candidatePassword = "";
		this.candidatePhoneNo = candidatePhoneNo;
		this.candidatePhoneNoExtension = candidatePhoneNoExtension;
		this.candidateAlternatePhone = candidateAlternatePhone;
		this.candidateAlternatePhoneNoExtension = candidateAlternatePhoneNoExtension;
		this.skillSetId = skillSetId;
		this.candidateResume = "";
		this.candidateResumeBlob = "".getBytes();
		this.candidateAddressLine1 = "";
		this.candidateAddressLine2 = "";
		this.candidateCity = "";
		this.candidateState = "";
		this.candidateCountry = "";
		this.candidateZipcode = "";
		this.candidatePrefferedLocation = "";
		this.candidateExpectedSalary = "";
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.verificationCode = null;
		this.status = status;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateFirstName() {
		return candidateFirstName;
	}

	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName = candidateFirstName;
	}

	public String getCandidateLastName() {
		return candidateLastName;
	}

	public void setCandidateLastName(String candidateLastName) {
		this.candidateLastName = candidateLastName;
	}

	public String getCandidateEmailId() {
		return candidateEmailId;
	}

	public void setCandidateEmailId(String candidateEmailId) {
		this.candidateEmailId = candidateEmailId;
	}

	public String getCandidatePassword() {
		return candidatePassword;
	}

	public void setCandidatePassword(String candidatePassword) {
		this.candidatePassword = candidatePassword;
	}

	public String getCandidatePhoneNo() {
		return candidatePhoneNo;
	}

	public void setCandidatePhoneNo(String candidatePhoneNo) {
		this.candidatePhoneNo = candidatePhoneNo;
	}

	public String getCandidatePhoneNoExtension() {
		return candidatePhoneNoExtension;
	}

	public void setCandidatePhoneNoExtension(String candidatePhoneNoExtension) {
		this.candidatePhoneNoExtension = candidatePhoneNoExtension;
	}

	public String getCandidateAlternatePhone() {
		return candidateAlternatePhone;
	}

	public void setCandidateAlternatePhone(String candidateAlternatePhone) {
		this.candidateAlternatePhone = candidateAlternatePhone;
	}

	public String getCandidateAlternatePhoneNoExtension() {
		return candidateAlternatePhoneNoExtension;
	}

	public void setCandidateAlternatePhoneNoExtension(
			String candidateAlternatePhoneNoExtension) {
		this.candidateAlternatePhoneNoExtension = candidateAlternatePhoneNoExtension;
	}

	public Integer getSkillSetId() {
		return skillSetId;
	}

	public void setSkillSetId(Integer skillSetId) {
		this.skillSetId = skillSetId;
	}

	public String getCandidateResume() {
		return candidateResume;
	}

	public void setCandidateResume(String candidateResume) {
		this.candidateResume = candidateResume;
	}

	public byte[] getCandidateResumeBlob() {
		return candidateResumeBlob;
	}

	public void setCandidateResumeBlob(byte[] candidateResumeBlob) {
		this.candidateResumeBlob = candidateResumeBlob;
	}

	public String getCandidateAddressLine1() {
		return candidateAddressLine1;
	}

	public void setCandidateAddressLine1(String candidateAddressLine1) {
		this.candidateAddressLine1 = candidateAddressLine1;
	}

	public String getCandidateAddressLine2() {
		return candidateAddressLine2;
	}

	public void setCandidateAddressLine2(String candidateAddressLine2) {
		this.candidateAddressLine2 = candidateAddressLine2;
	}

	public String getCandidateCity() {
		return candidateCity;
	}

	public void setCandidateCity(String candidateCity) {
		this.candidateCity = candidateCity;
	}

	public String getCandidateState() {
		return candidateState;
	}

	public void setCandidateState(String candidateState) {
		this.candidateState = candidateState;
	}

	public String getCandidateCountry() {
		return candidateCountry;
	}

	public void setCandidateCountry(String candidateCountry) {
		this.candidateCountry = candidateCountry;
	}

	public String getCandidateZipcode() {
		return candidateZipcode;
	}

	public void setCandidateZipcode(String candidateZipcode) {
		this.candidateZipcode = candidateZipcode;
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

	public String getCandidatePrefferedLocation() {
		return candidatePrefferedLocation;
	}

	public void setCandidatePrefferedLocation(String candidatePrefferedLocation) {
		this.candidatePrefferedLocation = candidatePrefferedLocation;
	}

	public String getCandidateExpectedSalary() {
		return candidateExpectedSalary;
	}

	public void setCandidateExpectedSalary(String candidateExpectedSalary) {
		this.candidateExpectedSalary = candidateExpectedSalary;
	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(SkillSet skillSet) {
		this.skillSet = skillSet;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	
}
