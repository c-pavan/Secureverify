package com.secureVerify.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.CandidateEmployerSkillSetMapDAO;
import com.secureVerify.model.CandidateEmployerSkillSetMap;

public class CandidateEmployerSkillSetMapDAOImpl extends HibernateDaoSupport implements CandidateEmployerSkillSetMapDAO {

	public void addCandidateEmployerSkillSetMap(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap) {
		getHibernateTemplate().save(candidateEmployerSkillSetMap);
	}

	public void updateCandidateEmployerSkillSetMap(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap) {
		getHibernateTemplate().update(candidateEmployerSkillSetMap);
	}

	public void deleteCandidateEmployerSkillSetMap(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap) {
		getHibernateTemplate().delete(candidateEmployerSkillSetMap);
	}

	public void deleteCandidateEmployerSkillSetMapList(List<CandidateEmployerSkillSetMap> candidateEmployerSkillSetMapList) {
		getHibernateTemplate().deleteAll(candidateEmployerSkillSetMapList);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateEmployerSkillSetMap> listCandidateEmployerSkillSetMap() {
		return getHibernateTemplate().find("from CandidateEmployerSkillSetMap");
	}

	@SuppressWarnings("unchecked")
	public List<CandidateEmployerSkillSetMap> searchCandidateEmployerSkillSetMap(
			Integer candidateEmployerSkillSetMapId, Integer candidateId,
			Integer employerId, Integer skillSetId, Integer isScheduled,
			Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateEmployerSkillSetMap.class);
		if(candidateEmployerSkillSetMapId!=null && candidateEmployerSkillSetMapId!=0){
			criteria.add(Restrictions.eq("candidateEmployerSkillSetMapId", candidateEmployerSkillSetMapId));
		}
		if(candidateId!=null && candidateId!=0){
			criteria.add(Restrictions.eq("candidateId", candidateId));
		}
		if(employerId!=null && employerId!=0){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(isScheduled!=null){
			criteria.add(Restrictions.eq("isScheduled", isScheduled));
		}
		criteria.addOrder(Order.desc("candidateEmployerSkillSetMapId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public CandidateEmployerSkillSetMap getCandidateEmployerSkillSetMap(Integer candidateEmployerSkillSetMapId) {
		List<CandidateEmployerSkillSetMap> candidateEmployerSkillSetMapList = getHibernateTemplate().find("from CandidateEmployerSkillSetMap where candidateEmployerSkillSetMapId = ?", candidateEmployerSkillSetMapId);
		if(candidateEmployerSkillSetMapList!=null && !candidateEmployerSkillSetMapList.isEmpty()){ return candidateEmployerSkillSetMapList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public CandidateEmployerSkillSetMap getCandidateEmployerSkillSetMap(Integer candidateId, Integer employerId, Integer skillSetId) {
		Object[] values= {candidateId, employerId, skillSetId};
		List<CandidateEmployerSkillSetMap> candidateEmployerSkillSetMapList = getHibernateTemplate().find("from CandidateEmployerSkillSetMap where candidateId = ? and employerId = ? and skillSetId = ?", values);
		if(candidateEmployerSkillSetMapList!=null && !candidateEmployerSkillSetMapList.isEmpty()){ return candidateEmployerSkillSetMapList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapByCandidateId(Integer candidateId) {
		return getHibernateTemplate().find("from CandidateEmployerSkillSetMap where candidateId = ?", candidateId);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapByEmployerId(Integer employerId) {
		return getHibernateTemplate().find("from CandidateEmployerSkillSetMap where candidateId = ?", employerId);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapBySkillSetId(Integer skillSetId) {
		return getHibernateTemplate().find("from CandidateEmployerSkillSetMap where candidateId = ?", skillSetId);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapByIsScheduled(Integer isScheduled) {
		return getHibernateTemplate().find("from CandidateEmployerSkillSetMap where candidateId = ?", isScheduled);
	}

	public Integer getCandidateEmployerSkillSetMapListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateEmployerSkillSetMap"));
	}

	public Integer getCandidateEmployerSkillSetMapByCandidateIdListCount(Integer candidateId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateEmployerSkillSetMap where candidateId = ?", candidateId));
	}

	public Integer getCandidateEmployerSkillSetMapByEmployerIdListCount(Integer employerId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateEmployerSkillSetMap where employerId = ?", employerId));
	}

	public Integer getCandidateEmployerSkillSetMapBySkillSetIdListCount(Integer skillSetId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateEmployerSkillSetMap where skillSetId = ?", skillSetId));
	}

	public Integer getCandidateEmployerSkillSetMapByIsScheduledListCount(Integer isScheduled) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateEmployerSkillSetMap where isScheduled = ?", isScheduled));
	}

	public Integer getCandidateEmployerSkillSetMapByCandidateIdEmployerIdSkillSetIdIsScheduledListCount(
			Integer candidateId, Integer employerId, Integer skillSetId,
			Integer isScheduled) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateEmployerSkillSetMap.class);
		if(candidateId!=null && candidateId!=0){
			criteria.add(Restrictions.eq("candidateId", candidateId));
		}
		if(employerId!=null && employerId!=0){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(isScheduled!=null){
			criteria.add(Restrictions.eq("isScheduled", isScheduled));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getEmployerIdsListByCandidateIdIsScheduled(
			Integer candidateId, Integer isScheduled) {
		Object[] values = {candidateId, isScheduled};
		return getHibernateTemplate().find("select distinct(employerId) from CandidateEmployerSkillSetMap where candidateId = ? and isScheduled = ?", values);
	}

}
