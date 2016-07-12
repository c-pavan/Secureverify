package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.CreditsAvailableBo;
import com.secureVerify.dao.CreditsAvailableDAO;
import com.secureVerify.model.CreditsAvailable;

public class CreditsAvailableBoImpl implements CreditsAvailableBo {

	CreditsAvailableDAO creditsAvailableDAO;
	
	//DI via Spring
	public void setCreditsAvailableDAO(CreditsAvailableDAO creditsAvailableDAO){
		this.creditsAvailableDAO = creditsAvailableDAO;
	}
	
	public void addCreditsAvailable(CreditsAvailable creditsAvailable) {
		creditsAvailableDAO.addCreditsAvailable(creditsAvailable);
	}

	public void updateCreditsAvailable(CreditsAvailable creditsAvailable) {
		creditsAvailableDAO.updateCreditsAvailable(creditsAvailable);
	}

	public void deleteCreditsAvailable(CreditsAvailable creditsAvailable) {
		creditsAvailableDAO.deleteCreditsAvailable(creditsAvailable);
	}

	public void deleteCreditsAvailableList(List<CreditsAvailable> creditsAvailableList) {
		creditsAvailableDAO.deleteCreditsAvailableList(creditsAvailableList);
	}

	public List<CreditsAvailable> listCreditsAvailable() {
		return creditsAvailableDAO.listCreditsAvailable();
	}

	public List<CreditsAvailable> listActiveCreditsAvailable() {
		return creditsAvailableDAO.listActiveCreditsAvailable();
	}

	public List<CreditsAvailable> searchCreditsAvailable(Integer creditsAvailableId, Integer partyId, Integer partyTypeId,
			Integer totalNoOfCreditsPurchased, Integer noOfCreditsAvailable, Date fromDate, Date toDate, Integer status, 
			Integer startRecord, Integer endRecord) {
		return creditsAvailableDAO.searchCreditsAvailable(creditsAvailableId, partyId, partyTypeId, totalNoOfCreditsPurchased, 
				noOfCreditsAvailable, fromDate, toDate, status, startRecord, endRecord);
	}

	public CreditsAvailable getCreditsAvailableByCreditsAvailableId(Integer creditsAvailableId) {
		return creditsAvailableDAO.getCreditsAvailableByCreditsAvailableId(creditsAvailableId);
	}

	public CreditsAvailable getCreditsAvailable(Integer partyId, Integer partyTypeId) {
		return creditsAvailableDAO.getCreditsAvailable(partyId, partyTypeId);
	}

	public Integer getCreditsAvailableListCount() {
		return creditsAvailableDAO.getCreditsAvailableListCount();
	}

	public Integer getCreditsAvailableActiveListCount() {
		return creditsAvailableDAO.getCreditsAvailableActiveListCount();
	}

	public Integer searchCreditsAvailable(Integer creditsAvailableId, Integer partyId, Integer partyTypeId,
			Integer totalNoOfCreditsPurchased, Integer noOfCreditsAvailable, Date fromDate, Date toDate, Integer status) {
		return creditsAvailableDAO.searchCreditsAvailable(creditsAvailableId, partyId, partyTypeId, totalNoOfCreditsPurchased, 
				noOfCreditsAvailable, fromDate, toDate, status);
	}

}
