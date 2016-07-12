package com.secureVerify.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.CreditsAvailableDAO;
import com.secureVerify.model.CreditsAvailable;

public class CreditsAvailableDAOImpl extends HibernateDaoSupport implements CreditsAvailableDAO {

	public void addCreditsAvailable(CreditsAvailable creditsAvailable) {
		getHibernateTemplate().save(creditsAvailable);
	}

	public void updateCreditsAvailable(CreditsAvailable creditsAvailable) {
		getHibernateTemplate().update(creditsAvailable);
	}

	public void deleteCreditsAvailable(CreditsAvailable creditsAvailable) {
		getHibernateTemplate().delete(creditsAvailable);
	}

	public void deleteCreditsAvailableList(List<CreditsAvailable> creditsAvailableList) {
		getHibernateTemplate().deleteAll(creditsAvailableList);
	}

	@SuppressWarnings("unchecked")
	public List<CreditsAvailable> listCreditsAvailable() {
		return getHibernateTemplate().find("from CreditsAvailable");
	}

	@SuppressWarnings("unchecked")
	public List<CreditsAvailable> listActiveCreditsAvailable() {
		return getHibernateTemplate().find("from CreditsAvailable where status = 1");
	}

	@SuppressWarnings("unchecked")
	public List<CreditsAvailable> searchCreditsAvailable(
			Integer creditsAvailableId, Integer partyId, Integer partyTypeId,
			Integer totalNoOfCreditsPurchased, Integer noOfCreditsAvailable,
			Date fromDate, Date toDate, Integer status, Integer startRecord,
			Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CreditsAvailable.class);
		if(creditsAvailableId!=null){
			criteria.add(Restrictions.eq("creditsAvailableId", creditsAvailableId));
		}
		if(partyId!=null && partyId!=0){
			criteria.add(Restrictions.eq("partyId", partyId));
		}
		if(partyTypeId!=null && partyTypeId!=0){
			criteria.add(Restrictions.eq("partyTypeId", partyTypeId));
		}
		if(totalNoOfCreditsPurchased!=null){
			criteria.add(Restrictions.eq("totalNoOfCreditsPurchased", totalNoOfCreditsPurchased));
		}
		if(noOfCreditsAvailable!=null){
			criteria.add(Restrictions.eq("noOfCreditsAvailable", noOfCreditsAvailable));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("lastModified", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("lastModified", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("lastModified", toDate));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		criteria.addOrder(Order.desc("creditsAvailableId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public CreditsAvailable getCreditsAvailableByCreditsAvailableId(Integer creditsAvailableId) {
		List<CreditsAvailable> creditsAvailableList = getHibernateTemplate().find("from CreditsAvailable where creditsAvailableId = ?", creditsAvailableId);
		if(creditsAvailableList!=null && !creditsAvailableList.isEmpty()){ return creditsAvailableList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public CreditsAvailable getCreditsAvailable(Integer partyId, Integer partyTypeId) {
		Object[] values= {partyId, partyTypeId};
		List<CreditsAvailable> creditsAvailableList = getHibernateTemplate().find("from CreditsAvailable where partyId = ? and partyTypeId = ?", values);
		if(creditsAvailableList!=null && !creditsAvailableList.isEmpty()){ return creditsAvailableList.get(0); }else{ return null; }
	}

	public Integer getCreditsAvailableListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CreditsAvailable"));
	}

	public Integer getCreditsAvailableActiveListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CreditsAvailable where status = 1"));
	}

	public Integer searchCreditsAvailable(Integer creditsAvailableId,
			Integer partyId, Integer partyTypeId,
			Integer totalNoOfCreditsPurchased, Integer noOfCreditsAvailable,
			Date fromDate, Date toDate, Integer status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CreditsAvailable.class);
		if(creditsAvailableId!=null){
			criteria.add(Restrictions.eq("creditsAvailableId", creditsAvailableId));
		}
		if(partyId!=null && partyId!=0){
			criteria.add(Restrictions.eq("partyId", partyId));
		}
		if(partyTypeId!=null && partyTypeId!=0){
			criteria.add(Restrictions.eq("partyTypeId", partyTypeId));
		}
		if(totalNoOfCreditsPurchased!=null){
			criteria.add(Restrictions.eq("totalNoOfCreditsPurchased", totalNoOfCreditsPurchased));
		}
		if(noOfCreditsAvailable!=null){
			criteria.add(Restrictions.eq("noOfCreditsAvailable", noOfCreditsAvailable));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("lastModified", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("lastModified", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("lastModified", toDate));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

}
