package com.secureVerify.bo;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.CreditsAvailable;

public interface CreditsAvailableBo {

	void addCreditsAvailable(CreditsAvailable creditsAvailable);
	
	void updateCreditsAvailable(CreditsAvailable creditsAvailable);
	
	void deleteCreditsAvailable(CreditsAvailable creditsAvailable);
	
	void deleteCreditsAvailableList(List<CreditsAvailable> creditsAvailableList);
	
	List<CreditsAvailable> listCreditsAvailable();
	
	List<CreditsAvailable> listActiveCreditsAvailable();
	
	List<CreditsAvailable> searchCreditsAvailable(Integer creditsAvailableId, Integer partyId, Integer partyTypeId, 
			Integer totalNoOfCreditsPurchased, Integer noOfCreditsAvailable, Date fromDate, Date toDate, Integer status, 
			Integer startRecord, Integer endRecord);
	
	CreditsAvailable getCreditsAvailableByCreditsAvailableId(Integer creditsAvailableId);
	
	CreditsAvailable getCreditsAvailable(Integer partyId, Integer partyTypeId);
	
	Integer getCreditsAvailableListCount();

	Integer getCreditsAvailableActiveListCount();
	
	Integer searchCreditsAvailable(Integer creditsAvailableId, Integer partyId, Integer partyTypeId, 
			Integer totalNoOfCreditsPurchased, Integer noOfCreditsAvailable, Date fromDate, Date toDate, Integer status);
	
	
}
