package com.secureVerify.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.CandidateCouponMapDAO;
import com.secureVerify.model.CandidateCouponMap;

public class CandidateCouponMapDAOImpl extends HibernateDaoSupport implements CandidateCouponMapDAO {

	public void addCandidateCouponMap(CandidateCouponMap candidateCouponMap) {
		getHibernateTemplate().save(candidateCouponMap);
	}

	public void updateCandidateCouponMap(CandidateCouponMap candidateCouponMap) {
		getHibernateTemplate().update(candidateCouponMap);
	}

	public void deleteCandidateCouponMap(CandidateCouponMap candidateCouponMap) {
		getHibernateTemplate().delete(candidateCouponMap);
	}
	
	public void deleteCandidateCouponMapList(List<CandidateCouponMap> candidateCouponMapList) {
		getHibernateTemplate().deleteAll(candidateCouponMapList);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateCouponMap> listCandidateCouponMap() {
		return getHibernateTemplate().find("from CandidateCouponMap");
	}

	@SuppressWarnings("unchecked")
	public List<CandidateCouponMap> searchCandidateCouponMap(
			Integer candidateCouponMapId, Integer candidateId,
			Integer couponId, Integer employerId, Date fromDate, Date toDate,
			Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateCouponMap.class);
		if(candidateCouponMapId!=null && candidateCouponMapId!=0){
			criteria.add(Restrictions.eq("candidateCouponMapId", candidateCouponMapId));
		}
		if(candidateId!=null && candidateId!=0){
			criteria.add(Restrictions.eq("candidateId", candidateId));
		}
		if(couponId!=null && couponId!=0){
			criteria.add(Restrictions.eq("couponId", couponId));
		}
		if(employerId!=null && employerId!=0){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("updateTime", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("updateTime", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("updateTime", toDate));
		}
		criteria.addOrder(Order.desc("candidateCouponMapId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public CandidateCouponMap getCandidateCouponMap(Integer candidateCouponMapId) {
		List<CandidateCouponMap> candidateCouponMapList = getHibernateTemplate().find("from CandidateCouponMap where candidateCouponMapId = ?", candidateCouponMapId);
		if(candidateCouponMapList!=null && !candidateCouponMapList.isEmpty()){ return candidateCouponMapList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<CandidateCouponMap> getCandidateCouponMapByCandidateId(Integer candidateId) {
		return getHibernateTemplate().find("from CandidateCouponMap where candidateId = ?", candidateId);
	}

	@SuppressWarnings("unchecked")
	public CandidateCouponMap getCandidateCouponMapByCouponId(Integer couponId) {
		List<CandidateCouponMap> candidateCouponMapList = getHibernateTemplate().find("from CandidateCouponMap where couponId = ?", couponId);
		if(candidateCouponMapList!=null && !candidateCouponMapList.isEmpty()){ return candidateCouponMapList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<CandidateCouponMap> getCandidateCouponMapByEmployerId(Integer employerId) {
		return getHibernateTemplate().find("from CandidateCouponMap where employerId = ?", employerId);
	}

	public Integer getCandidateCouponMapListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateCouponMap"));
	}

	public Integer getCandidateCouponMapByCandidateIdListCount(Integer candidateId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateCouponMap where candidateId = ?", candidateId));
	}

	public Integer getCandidateCouponMapByEmployerIdListCount(Integer employerId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateCouponMap where employerId = ?", employerId));
	}

	public Integer getCandidateCouponMapByCandidateIdEmployerIdCouponStatusListCount(
			Integer candidateId, Integer employerId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateCouponMap.class);
		if(candidateId!=null && candidateId!=0){
			criteria.add(Restrictions.eq("candidateId", candidateId));
		}
		if(employerId!=null && employerId!=0){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

}
