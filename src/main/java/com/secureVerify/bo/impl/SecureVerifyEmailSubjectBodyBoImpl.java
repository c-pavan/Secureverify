package com.secureVerify.bo.impl;

import java.util.List;

import com.secureVerify.bo.SecureVerifyEmailSubjectBodyBo;
import com.secureVerify.dao.SecureVerifyEmailSubjectBodyDAO;
import com.secureVerify.model.SecureVerifyEmailSubjectBody;

public class SecureVerifyEmailSubjectBodyBoImpl implements SecureVerifyEmailSubjectBodyBo {

	SecureVerifyEmailSubjectBodyDAO secureVerifyEmailSubjectBodyDAO;
	
	//DI via Spring
	public void setSecureVerifyEmailSubjectBodyDAO(SecureVerifyEmailSubjectBodyDAO secureVerifyEmailSubjectBodyDAO){
		this.secureVerifyEmailSubjectBodyDAO = secureVerifyEmailSubjectBodyDAO;
	}	
	
	public void addSecureVerifyEmailSubjectBody(
			SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody) {
		secureVerifyEmailSubjectBodyDAO.addSecureVerifyEmailSubjectBody(secureVerifyEmailSubjectBody);
	}

	public void updateSecureVerifyEmailSubjectBody(
			SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody) {
		secureVerifyEmailSubjectBodyDAO.updateSecureVerifyEmailSubjectBody(secureVerifyEmailSubjectBody);
	}

	public void deleteSecureVerifyEmailSubjectBody(
			SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody) {
		secureVerifyEmailSubjectBodyDAO.deleteSecureVerifyEmailSubjectBody(secureVerifyEmailSubjectBody);
	}

	public void deleteSecureVerifyEmailSubjectBodyList(
			List<SecureVerifyEmailSubjectBody> secureVerifyEmailSubjectBodyList) {
		secureVerifyEmailSubjectBodyDAO.deleteSecureVerifyEmailSubjectBodyList(secureVerifyEmailSubjectBodyList);
	}

	public List<SecureVerifyEmailSubjectBody> listSecureVerifyEmailSubjectBody() {
		return secureVerifyEmailSubjectBodyDAO.listSecureVerifyEmailSubjectBody();
	}

	public SecureVerifyEmailSubjectBody getSecureVerifyEmailSubjectBody(
			Integer emailUniqueId) {
		return secureVerifyEmailSubjectBodyDAO.getSecureVerifyEmailSubjectBody(emailUniqueId);
	}

	public SecureVerifyEmailSubjectBody getSecureVerifyEmailSubjectBodyByEmailSendingType(
			Integer emailSendingType) {
		return secureVerifyEmailSubjectBodyDAO.getSecureVerifyEmailSubjectBodyByEmailSendingType(emailSendingType);
	}

}
