package com.secureVerify.dao;

import java.util.List;

import com.secureVerify.model.SecureVerifyEmailSubjectBody;

public interface SecureVerifyEmailSubjectBodyDAO {

	void addSecureVerifyEmailSubjectBody(SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody);
	
	void updateSecureVerifyEmailSubjectBody(SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody);
	
	void deleteSecureVerifyEmailSubjectBody(SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody);
	
	void deleteSecureVerifyEmailSubjectBodyList(List<SecureVerifyEmailSubjectBody> secureVerifyEmailSubjectBodyList);
	
	List<SecureVerifyEmailSubjectBody> listSecureVerifyEmailSubjectBody();
	
	SecureVerifyEmailSubjectBody getSecureVerifyEmailSubjectBody(Integer emailUniqueId);
	
	SecureVerifyEmailSubjectBody getSecureVerifyEmailSubjectBodyByEmailSendingType(Integer emailSendingType);
	
}
