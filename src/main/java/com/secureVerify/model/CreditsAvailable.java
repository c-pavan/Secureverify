package com.secureVerify.model;

import java.util.Date;

public class CreditsAvailable implements java.io.Serializable {

	private static final long serialVersionUID = -6948991061268506526L;

	private Integer creditsAvailableId;
	private Integer partyId;
	private Integer partyTypeId;
	private Integer totalNoOfCreditsPurchased;
	private Integer noOfCreditsAvailable;
	private Date lastModified;
	private Integer status;
	
	public CreditsAvailable(){
		
	}

	public CreditsAvailable(Integer creditsAvailableId, Integer partyId, Integer partyTypeId, 
			Integer totalNoOfCreditsPurchased, Integer noOfCreditsAvailable, Date lastModified, Integer status){
		this.creditsAvailableId = creditsAvailableId;
		this.partyId = partyId;
		this.partyTypeId = partyTypeId;
		this.totalNoOfCreditsPurchased = totalNoOfCreditsPurchased;
		this.noOfCreditsAvailable = noOfCreditsAvailable;
		this.lastModified = lastModified;
		this.status = status;
	}

	public CreditsAvailable(Integer partyId, Integer partyTypeId, Integer totalNoOfCreditsPurchased, 
			Integer noOfCreditsAvailable, Date lastModified, Integer status){
		this.partyId = partyId;
		this.partyTypeId = partyTypeId;
		this.totalNoOfCreditsPurchased = totalNoOfCreditsPurchased;
		this.noOfCreditsAvailable = noOfCreditsAvailable;
		this.lastModified = lastModified;
		this.status = status;
	}

	public Integer getCreditsAvailableId() {
		return creditsAvailableId;
	}

	public void setCreditsAvailableId(Integer creditsAvailableId) {
		this.creditsAvailableId = creditsAvailableId;
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public Integer getPartyTypeId() {
		return partyTypeId;
	}

	public void setPartyTypeId(Integer partyTypeId) {
		this.partyTypeId = partyTypeId;
	}

	public Integer getTotalNoOfCreditsPurchased() {
		return totalNoOfCreditsPurchased;
	}

	public void setTotalNoOfCreditsPurchased(Integer totalNoOfCreditsPurchased) {
		this.totalNoOfCreditsPurchased = totalNoOfCreditsPurchased;
	}

	public Integer getNoOfCreditsAvailable() {
		return noOfCreditsAvailable;
	}

	public void setNoOfCreditsAvailable(Integer noOfCreditsAvailable) {
		this.noOfCreditsAvailable = noOfCreditsAvailable;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
