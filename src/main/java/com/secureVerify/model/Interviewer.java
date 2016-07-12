package com.secureVerify.model;

import java.util.Date;
import java.util.List;

public class Interviewer implements java.io.Serializable {

	private static final long serialVersionUID = -8431004532038484329L;
	
	private Integer interviewerId;
	private String interviewerFirstName;
	private String interviewerLastName;
	private String interviewerEmailId;
	private String interviewerPassword;
	private String interviewerPhoneNo;
	private String interviewerPhoneNoExtension;
	private String interviewerAlternatePhone;
	private String interviewerAlternatePhoneNoExtension;
	private Integer interviewerSkillSet1;
	private Integer interviewerSkillSet2;
	private Integer interviewerSkillSet3;
	private String interviewerResume;
	private byte[] interviewerResumeBlob;
	private String createdByName;
	private Integer createdBy;
	private String lastModifiedByName;
	private Integer lastModifiedBy;
	private Date creationDate;
	private Date lastModifiedTime;
	private String verificationCode;
	private Integer status;
	
	private List<SkillSet> skillSetList;
	
	public Interviewer(){
		
	}

	public Interviewer(Integer interviewerId, String interviewerFirstName, String interviewerLastName, String interviewerEmailId, 
			String interviewerPassword, String interviewerPhoneNo, String interviewerPhoneNoExtension, String interviewerAlternatePhone, 
			String interviewerAlternatePhoneNoExtension, Integer interviewerSkillSet1, Integer interviewerSkillSet2, 
			Integer interviewerSkillSet3, String interviewerResume, byte[] interviewerResumeBlob, Integer createdBy, 
			Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, String verificationCode, Integer status){
		this.interviewerId = interviewerId;
		this.interviewerFirstName = interviewerFirstName;
		this.interviewerLastName = interviewerLastName;
		this.interviewerEmailId = interviewerEmailId;
		this.interviewerPassword = interviewerPassword;
		this.interviewerPhoneNo = interviewerPhoneNo;
		this.interviewerPhoneNoExtension = interviewerPhoneNoExtension;
		this.interviewerAlternatePhone = interviewerAlternatePhone;
		this.interviewerAlternatePhoneNoExtension = interviewerAlternatePhoneNoExtension;
		this.interviewerSkillSet1 = interviewerSkillSet1;
		this.interviewerSkillSet2 = interviewerSkillSet2;
		this.interviewerSkillSet3 = interviewerSkillSet3;
		this.interviewerResume = interviewerResume;
		this.interviewerResumeBlob = interviewerResumeBlob;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.verificationCode = verificationCode;
		this.status = status;
	}

	public Interviewer(String interviewerFirstName, String interviewerLastName, String interviewerEmailId, 
			String interviewerPassword, String interviewerPhoneNo, String interviewerPhoneNoExtension, String interviewerAlternatePhone, 
			String interviewerAlternatePhoneNoExtension, Integer interviewerSkillSet1, Integer interviewerSkillSet2, 
			Integer interviewerSkillSet3, String interviewerResume, byte[] interviewerResumeBlob, Integer createdBy, 
			Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, String verificationCode, Integer status){
		this.interviewerFirstName = interviewerFirstName;
		this.interviewerLastName = interviewerLastName;
		this.interviewerEmailId = interviewerEmailId;
		this.interviewerPassword = interviewerPassword;
		this.interviewerPhoneNo = interviewerPhoneNo;
		this.interviewerPhoneNoExtension = interviewerPhoneNoExtension;
		this.interviewerAlternatePhone = interviewerAlternatePhone;
		this.interviewerAlternatePhoneNoExtension = interviewerAlternatePhoneNoExtension;
		this.interviewerSkillSet1 = interviewerSkillSet1;
		this.interviewerSkillSet2 = interviewerSkillSet2;
		this.interviewerSkillSet3 = interviewerSkillSet3;
		this.interviewerResume = interviewerResume;
		this.interviewerResumeBlob = interviewerResumeBlob;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.verificationCode = verificationCode;
		this.status = status;
	}

	public Integer getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
	}

	public String getInterviewerFirstName() {
		return interviewerFirstName;
	}

	public void setInterviewerFirstName(String interviewerFirstName) {
		this.interviewerFirstName = interviewerFirstName;
	}

	public String getInterviewerLastName() {
		return interviewerLastName;
	}

	public void setInterviewerLastName(String interviewerLastName) {
		this.interviewerLastName = interviewerLastName;
	}

	public String getInterviewerEmailId() {
		return interviewerEmailId;
	}

	public void setInterviewerEmailId(String interviewerEmailId) {
		this.interviewerEmailId = interviewerEmailId;
	}

	public String getInterviewerPassword() {
		return interviewerPassword;
	}

	public void setInterviewerPassword(String interviewerPassword) {
		this.interviewerPassword = interviewerPassword;
	}

	public String getInterviewerPhoneNo() {
		return interviewerPhoneNo;
	}

	public void setInterviewerPhoneNo(String interviewerPhoneNo) {
		this.interviewerPhoneNo = interviewerPhoneNo;
	}

	public String getInterviewerPhoneNoExtension() {
		return interviewerPhoneNoExtension;
	}

	public void setInterviewerPhoneNoExtension(String interviewerPhoneNoExtension) {
		this.interviewerPhoneNoExtension = interviewerPhoneNoExtension;
	}

	public String getInterviewerAlternatePhone() {
		return interviewerAlternatePhone;
	}

	public void setInterviewerAlternatePhone(String interviewerAlternatePhone) {
		this.interviewerAlternatePhone = interviewerAlternatePhone;
	}

	public String getInterviewerAlternatePhoneNoExtension() {
		return interviewerAlternatePhoneNoExtension;
	}

	public void setInterviewerAlternatePhoneNoExtension(
			String interviewerAlternatePhoneNoExtension) {
		this.interviewerAlternatePhoneNoExtension = interviewerAlternatePhoneNoExtension;
	}

	public Integer getInterviewerSkillSet1() {
		return interviewerSkillSet1;
	}

	public void setInterviewerSkillSet1(Integer interviewerSkillSet1) {
		this.interviewerSkillSet1 = interviewerSkillSet1;
	}

	public Integer getInterviewerSkillSet2() {
		return interviewerSkillSet2;
	}

	public void setInterviewerSkillSet2(Integer interviewerSkillSet2) {
		this.interviewerSkillSet2 = interviewerSkillSet2;
	}

	public Integer getInterviewerSkillSet3() {
		return interviewerSkillSet3;
	}

	public void setInterviewerSkillSet3(Integer interviewerSkillSet3) {
		this.interviewerSkillSet3 = interviewerSkillSet3;
	}

	public String getInterviewerResume() {
		return interviewerResume;
	}

	public void setInterviewerResume(String interviewerResume) {
		this.interviewerResume = interviewerResume;
	}

	public byte[] getInterviewerResumeBlob() {
		return interviewerResumeBlob;
	}

	public void setInterviewerResumeBlob(byte[] interviewerResumeBlob) {
		this.interviewerResumeBlob = interviewerResumeBlob;
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

	public List<SkillSet> getSkillSetList() {
		return skillSetList;
	}

	public void setSkillSetList(List<SkillSet> skillSetList) {
		this.skillSetList = skillSetList;
	}
	
	
	
}
