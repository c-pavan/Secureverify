package com.secureVerify.bo.impl;

import java.math.BigDecimal;
import java.util.List;

import com.secureVerify.bo.CreditTypesBo;
import com.secureVerify.dao.CreditTypesDAO;
import com.secureVerify.model.CreditTypes;

public class CreditTypesBoImpl implements CreditTypesBo {

	CreditTypesDAO creditTypesDAO;
	
	//DI via Spring
	public void setCreditTypesDAO(CreditTypesDAO creditTypesDAO){
		this.creditTypesDAO = creditTypesDAO;
	}
	
	public void addCreditTypes(CreditTypes creditTypes) {
		creditTypesDAO.addCreditTypes(creditTypes);
	}

	public void updateCreditTypes(CreditTypes creditTypes) {
		creditTypesDAO.updateCreditTypes(creditTypes);
	}

	public void deleteCreditTypes(CreditTypes creditTypes) {
		creditTypesDAO.deleteCreditTypes(creditTypes);
	}

	public void deleteCreditTypesList(List<CreditTypes> creditTypesList) {
		creditTypesDAO.deleteCreditTypesList(creditTypesList);
	}

	public List<CreditTypes> listCreditTypes() {
		return creditTypesDAO.listCreditTypes();
	}

	public List<CreditTypes> listActiveCreditTypes() {
		return creditTypesDAO.listActiveCreditTypes();
	}

	public List<CreditTypes> searchCreditTypes(Integer creditTypesId,
			Integer creditType, String description, BigDecimal amount,
			Integer status, Integer startRecord, Integer endRecord) {
		return creditTypesDAO.searchCreditTypes(creditTypesId, creditType, description, amount, status, startRecord, endRecord);
	}

	public CreditTypes getCreditTypesByCreditTypesId(Integer creditTypesId) {
		return creditTypesDAO.getCreditTypesByCreditTypesId(creditTypesId);
	}

	public CreditTypes getCreditTypes(Integer creditType) {
		return creditTypesDAO.getCreditTypes(creditType);
	}

	public Integer getCreditTypesListCount() {
		return creditTypesDAO.getCreditTypesListCount();
	}

	public Integer getCreditTypesActiveListCount() {
		return creditTypesDAO.getCreditTypesActiveListCount();
	}

	public Integer searchCreditTypes(Integer creditTypesId, Integer creditType,
			Integer description, BigDecimal amount, Integer status) {
		return creditTypesDAO.searchCreditTypes(creditTypesId, creditType, description, amount, status);
	}

	public List<CreditTypes> getCreditTypesListByPage(final int startRecord, final int endRecord) {
		return creditTypesDAO.getCreditTypesListByPage(startRecord, endRecord);
	}

}
