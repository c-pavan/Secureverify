package com.secureVerify.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.SecureVerifyEmailSubjectBodyDAO;
import com.secureVerify.model.SecureVerifyEmailSubjectBody;

public class SecureVerifyEmailSubjectBodyDAOImpl extends HibernateDaoSupport implements SecureVerifyEmailSubjectBodyDAO {

	public void addSecureVerifyEmailSubjectBody(SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody) {
		getHibernateTemplate().save(secureVerifyEmailSubjectBody);
	}

	public void updateSecureVerifyEmailSubjectBody(SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody) {
		getHibernateTemplate().update(secureVerifyEmailSubjectBody);
	}

	public void deleteSecureVerifyEmailSubjectBody(SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody) {
		getHibernateTemplate().delete(secureVerifyEmailSubjectBody);
	}

	public void deleteSecureVerifyEmailSubjectBodyList(List<SecureVerifyEmailSubjectBody> secureVerifyEmailSubjectBodyList) {
		getHibernateTemplate().deleteAll(secureVerifyEmailSubjectBodyList);
	}

	@SuppressWarnings("unchecked")
	public List<SecureVerifyEmailSubjectBody> listSecureVerifyEmailSubjectBody() {
		return getHibernateTemplate().find("from SecureVerifyEmailSubjectBody");
	}

	@SuppressWarnings("unchecked")
	public SecureVerifyEmailSubjectBody getSecureVerifyEmailSubjectBody(Integer emailUniqueId) {
		List<SecureVerifyEmailSubjectBody> secureVerifyEmailSubjectBodyList = getHibernateTemplate().find("from SecureVerifyEmailSubjectBody where emailUniqueId = ?", emailUniqueId);
		if(secureVerifyEmailSubjectBodyList!=null && !secureVerifyEmailSubjectBodyList.isEmpty()){ return secureVerifyEmailSubjectBodyList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public SecureVerifyEmailSubjectBody getSecureVerifyEmailSubjectBodyByEmailSendingType(Integer emailSendingType) {
		List<SecureVerifyEmailSubjectBody> secureVerifyEmailSubjectBodyList = getHibernateTemplate().find("from SecureVerifyEmailSubjectBody where emailSendingType = ?", emailSendingType);
		if(secureVerifyEmailSubjectBodyList!=null && !secureVerifyEmailSubjectBodyList.isEmpty()){ return secureVerifyEmailSubjectBodyList.get(0); }else{ return null; }
	}

}
