package com.secureVerify.bo;

import java.math.BigDecimal;
import java.util.List;

import com.secureVerify.model.CreditTypes;

public interface CreditTypesBo {

	void addCreditTypes(CreditTypes creditTypes);
	
	void updateCreditTypes(CreditTypes creditTypes);
	
	void deleteCreditTypes(CreditTypes creditTypes);
	
	void deleteCreditTypesList(List<CreditTypes> creditTypesList);
	
	List<CreditTypes> listCreditTypes();
	
	List<CreditTypes> listActiveCreditTypes();
	
	List<CreditTypes> searchCreditTypes(Integer creditTypesId, Integer creditType, String description, 
			BigDecimal amount, Integer status, Integer startRecord, Integer endRecord);
	
	List<CreditTypes> getCreditTypesListByPage(final int startRecord, final int endRecord);
	
	CreditTypes getCreditTypesByCreditTypesId(Integer creditTypesId);
	
	CreditTypes getCreditTypes(Integer creditType);
	
	Integer getCreditTypesListCount();

	Integer getCreditTypesActiveListCount();
	
	Integer searchCreditTypes(Integer creditTypesId, Integer creditType, Integer description, BigDecimal amount, Integer status);
	
}
