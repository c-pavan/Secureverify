package com.secureVerify.model;

import java.util.Date;

public class SkillSet implements java.io.Serializable {

	private static final long serialVersionUID = 879455619444848734L;

	private Integer skillSetId;
	private String primarySkillSet;
	private String skillSetCategory;
	private String createdByName;
	private Integer createdBy;
	private String lastModifiedByName;
	private Integer lastModifiedBy;
	private Date creationDate;
	private Date lastModifiedTime;
	private Integer status;
	
	public SkillSet(){
		
	}

	public SkillSet(Integer skillSetId, String primarySkillSet, String skillSetCategory, Integer createdBy, Integer lastModifiedBy, 
			Date creationDate, Date lastModifiedTime, Integer status){
		this.skillSetId = skillSetId;
		this.primarySkillSet = primarySkillSet;
		this.skillSetCategory = skillSetCategory;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public SkillSet(String primarySkillSet, String skillSetCategory, Integer createdBy, Integer lastModifiedBy, 
			Date creationDate, Date lastModifiedTime, Integer status){
		this.primarySkillSet = primarySkillSet;
		this.skillSetCategory = skillSetCategory;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public Integer getSkillSetId() {
		return skillSetId;
	}

	public void setSkillSetId(Integer skillSetId) {
		this.skillSetId = skillSetId;
	}

	public String getPrimarySkillSet() {
		return primarySkillSet;
	}

	public void setPrimarySkillSet(String primarySkillSet) {
		this.primarySkillSet = primarySkillSet;
	}

	public String getSkillSetCategory() {
		return skillSetCategory;
	}

	public void setSkillSetCategory(String skillSetCategory) {
		this.skillSetCategory = skillSetCategory;
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
