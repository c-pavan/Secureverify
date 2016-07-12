package com.secureVerify.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.CandidateScheduleTimingDAO;
import com.secureVerify.model.CandidateScheduleTiming;

public class CandidateScheduleTimingDAOImpl extends HibernateDaoSupport implements CandidateScheduleTimingDAO {

	public void addCandidateScheduleTiming(CandidateScheduleTiming candidateScheduleTiming) {
		getHibernateTemplate().save(candidateScheduleTiming);
	}

	public void updateCandidateScheduleTiming(CandidateScheduleTiming candidateScheduleTiming) {
		getHibernateTemplate().update(candidateScheduleTiming);
	}

	public void deleteCandidateScheduleTiming(CandidateScheduleTiming candidateScheduleTiming) {
		getHibernateTemplate().delete(candidateScheduleTiming);
	}

	public void deleteCandidateScheduleTimingList(List<CandidateScheduleTiming> candidateScheduleTimingList) {
		getHibernateTemplate().deleteAll(candidateScheduleTimingList);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> listCandidateScheduleTiming() {
		return getHibernateTemplate().find("from CandidateScheduleTiming");
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> listActiveCandidateScheduleTiming() {
		return getHibernateTemplate().find("from CandidateScheduleTiming where status = 1");
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> searchCandidateScheduleTiming(
			Integer candidateScheduleTimingId, Integer candidateId,
			Integer locationId, Integer interviewerId,
			Integer locationScheduleTimingId, Integer skillSetId, Integer interviewerSkillSet1, 
			Integer interviewerSkillSet2, Integer interviewerSkillSet3, Date candidateScheduleFromTime,
			Date candidateScheduleToTime, String candidateFeedback,
			Integer candidatePerformance, Integer interviewStatus, String candidateUniqueId, Integer employerId, 
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateScheduleTiming.class);
		if(candidateScheduleTimingId!=null && candidateScheduleTimingId!=0){
			criteria.add(Restrictions.eq("candidateScheduleTimingId", candidateScheduleTimingId));
		}
		if(candidateId!=null && candidateId!=0){
			criteria.add(Restrictions.eq("candidateId", candidateId));
		}
		if(locationId!=null && locationId!=0){
			criteria.add(Restrictions.eq("locationId", locationId));
		}
		if(interviewerId!=null && interviewerId!=0){
			criteria.add(Restrictions.eq("interviewerId", interviewerId));
		}
		if(locationScheduleTimingId!=null && locationScheduleTimingId!=0){
			criteria.add(Restrictions.eq("locationScheduleTimingId", locationScheduleTimingId));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet1));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet2));
		}else if(interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet3));
		}
		if(candidateScheduleFromTime!=null){
			criteria.add(Restrictions.ge("candidateScheduleFromTime", candidateScheduleFromTime));
		}
		if(candidateScheduleToTime!=null){
			criteria.add(Restrictions.le("candidateScheduleToTime", candidateScheduleToTime));
		}
		if(candidateFeedback!=null && !candidateFeedback.trim().equals("")){
			criteria.add(Restrictions.like("candidateFeedback", "%"+ candidateFeedback +"%"));
		}
		if(candidatePerformance!=null && candidatePerformance!=0){
			criteria.add(Restrictions.eq("candidatePerformance", candidatePerformance));
		}
		if(interviewStatus!=null){
			criteria.add(Restrictions.eq("interviewStatus", interviewStatus));
		}
		if(candidateUniqueId!=null && !candidateUniqueId.equals("")){
			criteria.add(Restrictions.ilike("candidateUniqueId", candidateUniqueId));
		}
		if(employerId!=null){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		if(createdBy!=null && createdBy!=0){
			criteria.add(Restrictions.eq("createdBy", createdBy));
		}
		if(lastModifiedBy!=null && lastModifiedBy!=0){
			criteria.add(Restrictions.eq("lastModifiedBy", lastModifiedBy));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("lastModifiedTime", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("lastModifiedTime", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("lastModifiedTime", toDate));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		criteria.addOrder(Order.desc("candidateScheduleTimingId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> searchCandidateScheduleTiming(
			Integer candidateScheduleTimingId, Integer candidateId,
			Integer locationId, List<Integer> locationIdList,
			Integer interviewerId, Integer locationScheduleTimingId,
			Integer skillSetId, Integer interviewerSkillSet1,
			Integer interviewerSkillSet2, Integer interviewerSkillSet3,
			Date candidateScheduleFromTime, Date candidateScheduleToTime,
			String candidateFeedback, Integer candidatePerformance,
			Integer interviewStatus, String candidateUniqueId, Integer employerId, 
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateScheduleTiming.class);
		if(candidateScheduleTimingId!=null && candidateScheduleTimingId!=0){
			criteria.add(Restrictions.eq("candidateScheduleTimingId", candidateScheduleTimingId));
		}
		if(candidateId!=null && candidateId!=0){
			criteria.add(Restrictions.eq("candidateId", candidateId));
		}
		if(locationId!=null && locationId!=0){
			criteria.add(Restrictions.eq("locationId", locationId));
		}
		if(locationIdList!=null && !locationIdList.isEmpty()){
			criteria.add(Restrictions.in("locationId", locationIdList));
		}
		if(interviewerId!=null && interviewerId!=0){
			criteria.add(Restrictions.eq("interviewerId", interviewerId));
		}
		if(locationScheduleTimingId!=null && locationScheduleTimingId!=0){
			criteria.add(Restrictions.eq("locationScheduleTimingId", locationScheduleTimingId));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet1));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet2));
		}else if(interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet3));
		}
		if(candidateScheduleFromTime!=null){
			criteria.add(Restrictions.ge("candidateScheduleFromTime", candidateScheduleFromTime));
		}
		if(candidateScheduleToTime!=null){
			criteria.add(Restrictions.le("candidateScheduleToTime", candidateScheduleToTime));
		}
		if(candidateFeedback!=null && !candidateFeedback.trim().equals("")){
			criteria.add(Restrictions.like("candidateFeedback", "%"+ candidateFeedback +"%"));
		}
		if(candidatePerformance!=null && candidatePerformance!=0){
			criteria.add(Restrictions.eq("candidatePerformance", candidatePerformance));
		}
		if(interviewStatus!=null){
			criteria.add(Restrictions.eq("interviewStatus", interviewStatus));
		}
		if(candidateUniqueId!=null && !candidateUniqueId.equals("")){
			criteria.add(Restrictions.ilike("candidateUniqueId", candidateUniqueId));
		}
		if(employerId!=null){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		if(createdBy!=null && createdBy!=0){
			criteria.add(Restrictions.eq("createdBy", createdBy));
		}
		if(lastModifiedBy!=null && lastModifiedBy!=0){
			criteria.add(Restrictions.eq("lastModifiedBy", lastModifiedBy));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("lastModifiedTime", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("lastModifiedTime", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("lastModifiedTime", toDate));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		criteria.addOrder(Order.desc("candidateScheduleTimingId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public CandidateScheduleTiming getCandidateScheduleTiming(Integer candidateScheduleTimingId) {
		List<CandidateScheduleTiming> candidateScheduleTimingList = getHibernateTemplate().find("from CandidateScheduleTiming where candidateScheduleTimingId = ?", candidateScheduleTimingId);
		if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){ return candidateScheduleTimingList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByCandidateId(Integer candidateId) {
		return getHibernateTemplate().find("from CandidateScheduleTiming where candidateId = ?", candidateId);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByLocationId(Integer locationId) {
		return getHibernateTemplate().find("from CandidateScheduleTiming where locationId = ?", locationId);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByInterviewerId(Integer interviewerId) {
		return getHibernateTemplate().find("from CandidateScheduleTiming where interviewerId = ?", interviewerId);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByLocationScheduleTimingId(Integer locationScheduleTimingId) {
		return getHibernateTemplate().find("from CandidateScheduleTiming where locationScheduleTimingId = ?", locationScheduleTimingId);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByCandidatePerformance(Integer candidatePerformance) {
		return getHibernateTemplate().find("from CandidateScheduleTiming where candidatePerformance = ?", candidatePerformance);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByInterviewStatus(Integer interviewStatus) {
		return getHibernateTemplate().find("from CandidateScheduleTiming where interviewStatus = ?", interviewStatus);
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingListByPage(final int startRecord, final int endRecord) {
		return (List<CandidateScheduleTiming>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from CandidateScheduleTiming cst order by cst.candidateScheduleTimingId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<CandidateScheduleTiming> list = query.list();
				return list;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingListByInterviewStatusPage(final Integer interviewStatus, final int startRecord, final int endRecord) {
		return (List<CandidateScheduleTiming>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from CandidateScheduleTiming cst where cst.interviewStatus = ? order by cst.candidateScheduleTimingId desc");
				query.setParameter(0, interviewStatus);
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<CandidateScheduleTiming> list = query.list();
				return list;
			}
		});
	}

	public Integer getCandidateScheduleTimingListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming"));
	}

	public Integer getCandidateScheduleTimingByInterviewStatusListCount(
			Integer interviewStatus) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming cst where cst.interviewStatus = ?", interviewStatus));
	}

	public Integer getCandidateScheduleTimingByCandidateIdInterviewStatusListCount(
			Integer candidateId, Integer interviewStatus) {
		Object[] values = {candidateId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming cst where cst.candidateId = ? and cst.interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByLocationIdInterviewStatusListCount(
			Integer locationId, Integer interviewStatus) {
		Object[] values = {locationId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming cst where cst.locationId = ? and cst.interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByInterviewerIdInterviewStatusListCount(
			Integer interviewerId, Integer interviewStatus) {
		Object[] values = {interviewerId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByCandidateIdLocationIdInterviewStatusListCount(
			Integer candidateId, Integer locationId, Integer interviewStatus) {
		Object[] values = {candidateId, locationId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where candidateId = ? and locationId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByCandidateIdInterviewerIdInterviewStatusListCount(
			Integer candidateId, Integer interviewerId, Integer interviewStatus) {
		Object[] values = {candidateId, interviewerId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where candidateId = ? and interviewerId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByLocationIdInterviewerIdInterviewStatusListCount(
			Integer locationId, Integer interviewerId, Integer interviewStatus) {
		Object[] values = {locationId, interviewerId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where locationId = ? and interviewerId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByCandidateIdLocationIdInterviewerIdInterviewStatusListCount(
			Integer candidateId, Integer locationId, Integer interviewerId,
			Integer interviewStatus) {
		Object[] values = {candidateId, locationId, interviewerId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where candidateId = ? and locationId = ? and interviewerId = ? and interviewStatus = ?", values));
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsBySkillSetId(
			Integer skillSetId) {
		return getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where skillSetId = ?", skillSetId);
	}

	public Integer getCandidateScheduleTimingBySkillSetIdInterviewStatusListCount(
			Integer skillSetId, Integer interviewStatus) {
		Object[] values = {skillSetId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where skillSetId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByLocationScheduleTimingIdInterviewStatusListCount(
			Integer locationScheduleTimingId, Integer interviewStatus) {
		Object[] values = {locationScheduleTimingId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where locationScheduleTimingId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByCandidateIdSkillSetIdInterviewStatusListCount(
			Integer candidateId, Integer skillSetId, Integer interviewStatus) {
		Object[] values = {candidateId, skillSetId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where candidateId = ? and skillSetId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByLocationIdskillSetIdInterviewStatusListCount(
			Integer locationId, Integer skillSetId, Integer interviewStatus) {
		Object[] values = {locationId, skillSetId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where locationId = ? and skillSetId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByInterviewerIdskillSetIdInterviewStatusListCount(
			Integer interviewerId, Integer skillSetId, Integer interviewStatus) {
		Object[] values = {interviewerId, skillSetId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and skillSetId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByLocationScheduleTimingIdSkillSetIdInterviewStatusListCount(
			Integer locationScheduleTimingId, Integer skillSetId, Integer interviewStatus) {
		Object[] values = {locationScheduleTimingId, skillSetId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where locationScheduleTimingId = ? and skillSetId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByCandidateIdLocationIdSkillSetIdInterviewStatusListCount(
			Integer candidateId, Integer locationId, Integer skillSetId, Integer interviewStatus) {
		Object[] values = {candidateId, locationId, skillSetId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where candidateId =? and locationId = ?  and skillSetId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByLocationIdInterviewerIdSkillSetIdInterviewStatusListCount(
			Integer locationId, Integer interviewerId, Integer skillSetId, Integer interviewStatus) {
		Object[] values = {locationId, interviewerId, skillSetId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where locationId = ? and interviewerId = ? and skillSetId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByCandidateIdLocationIdInterviewerIdSkillSetIdInterviewStatusListCount(
			Integer candidateId, Integer locationId, Integer interviewerId, Integer skillSetId, Integer interviewStatus) {
		Object[] values = {candidateId, locationId, interviewerId, skillSetId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where candidateId = ? and locationId = ? and interviewerId = ? and skillSetId = ? and interviewStatus = ?", values));
	}

	public Integer getCandidateScheduleTimingByInterviewerInterviewStatusListCount(
			Integer interviewerSkillSet1, Integer interviewerSkillSet2,
			Integer interviewerSkillSet3, Integer interviewStatus) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateScheduleTiming.class);
		if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet1));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet2));
		}else if(interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet3));
		}
		if(interviewStatus!=null && interviewStatus!=0){
			criteria.add(Restrictions.eq("interviewStatus", interviewStatus));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByEmployerId(final Integer employerId, final int startRecord, final int endRecord) {
		return (List<CandidateScheduleTiming>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from CandidateScheduleTiming cst where cst.employerId = ? order by cst.candidateScheduleTimingId desc");
				query.setParameter(0, employerId);
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<CandidateScheduleTiming> list = query.list();
				return list;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingByCandidateIdEmployerScheduled(final Integer candidateId, final Integer startRecord, final Integer endRecord) {
		return (List<CandidateScheduleTiming>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from CandidateScheduleTiming cst where cst.candidateId = ? and cst.employerId !=0 order by cst.candidateScheduleTimingId desc");
				query.setParameter(0, candidateId);
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<CandidateScheduleTiming> list = query.list();
				return list;
			}
		});
	}

	public Integer getCandidateScheduleTimingByCandidateIdEmployerScheduledListCount(Integer candidateId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where candidateId = ? and employerId !=0 ", candidateId));
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByEmployerIdAndNotInterviewed(final Integer employerId, final int startRecord, final int endRecord) {
		return (List<CandidateScheduleTiming>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from CandidateScheduleTiming cst where cst.employerId = ? and cst.interviewStatus != 3 order by cst.candidateScheduleTimingId desc");
				query.setParameter(0, employerId);
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<CandidateScheduleTiming> list = query.list();
				return list;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByEmployerIdAndInterviewed(final Integer employerId, final int startRecord, final int endRecord) {
		return (List<CandidateScheduleTiming>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from CandidateScheduleTiming cst where cst.employerId = ? and cst.interviewStatus = 3 order by cst.candidateScheduleTimingId desc");
				query.setParameter(0, employerId);
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<CandidateScheduleTiming> list = query.list();
				return list;
			}
		});
	}

	public Integer getCandidateScheduleTimingByEmployerIdListCount(Integer employerId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where employerId = ?", employerId));
	}

	public Integer getCandidateScheduleTimingByEmployerIdAndNotInterviewedListCount(Integer employerId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where employerId = ? and interviewStatus != 3 ", employerId));
	}

	public Integer getCandidateScheduleTimingByEmployerIdAndInterviewedListCount(Integer employerId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where employerId = ? and interviewStatus = 3 ", employerId));
	}

	public Integer getCandidateScheduleTimingByEmployerIdAndInterviewStatusListCount(Integer employerId, Integer interviewStatus) {
		Object values[] = {employerId, interviewStatus};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where employerId = ? and interviewStatus = ? ", values));
	}

	public Integer getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(
			Integer interviewerId, Integer skillSetId, Integer interviewStatus, Date candidateScheduleFromTime, Date candidateScheduleToTime) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateScheduleTiming.class);
		if(interviewerId!=null && interviewerId!=0){
			criteria.add(Restrictions.eq("interviewerId", interviewerId));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(interviewStatus!=null && interviewStatus!=0){
			criteria.add(Restrictions.eq("interviewStatus", interviewStatus));
		}
		if(candidateScheduleFromTime!=null){
			criteria.add(Restrictions.ge("candidateScheduleFromTime", candidateScheduleFromTime));
		}
		if(candidateScheduleToTime!=null){
			criteria.add(Restrictions.le("candidateScheduleToTime", candidateScheduleToTime));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
		
		/* // To Do check the Efficiency  
		if(interviewerId!=null && interviewerId!=0 && skillSetId!=null && skillSetId!=0 && interviewStatus!=null && interviewStatus!=0 && candidateScheduleFromTime!=null && candidateScheduleToTime!=null){
			
			// All Values Given
			Object values[] = {interviewerId, skillSetId, interviewStatus, candidateScheduleFromTime, candidateScheduleToTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and skillSetId = ? and interviewStatus = ? and candidateScheduleFromTime >= ? and candidateScheduleToTime <= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && interviewStatus!=null && interviewStatus!=0 && candidateScheduleFromTime!=null && candidateScheduleToTime!=null){
			
			// skillSetId missing
			Object values[] = {interviewerId, interviewStatus, candidateScheduleFromTime, candidateScheduleToTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and interviewStatus = ? and candidateScheduleFromTime >= ? and candidateScheduleToTime <= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && skillSetId!=null && skillSetId!=0 && candidateScheduleFromTime!=null && candidateScheduleToTime!=null){
			
			// interviewStatus missing
			Object values[] = {interviewerId, skillSetId, candidateScheduleFromTime, candidateScheduleToTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and skillSetId = ? and candidateScheduleFromTime >= ? and candidateScheduleToTime <= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && skillSetId!=null && skillSetId!=0 && interviewStatus!=null && interviewStatus!=0 && candidateScheduleToTime!=null){

			// candidateScheduleFromTime missing
			Object values[] = {interviewerId, skillSetId, interviewStatus, candidateScheduleToTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and skillSetId = ? and interviewStatus = ? and candidateScheduleToTime <= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && skillSetId!=null && skillSetId!=0 && interviewStatus!=null && interviewStatus!=0 && candidateScheduleFromTime!=null){

			// candidateScheduleToTime missing
			Object values[] = {interviewerId, skillSetId, interviewStatus, candidateScheduleFromTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and skillSetId = ? and interviewStatus = ? and candidateScheduleFromTime >= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && candidateScheduleFromTime!=null && candidateScheduleToTime!=null){

			// skillSetId and interviewStatus missing
			Object values[] = {interviewerId, candidateScheduleFromTime, candidateScheduleToTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and candidateScheduleFromTime >= ? and candidateScheduleToTime <= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && interviewStatus!=null && interviewStatus!=0 && candidateScheduleToTime!=null){

			// skillSetId and candidateScheduleFromTime missing
			Object values[] = {interviewerId, interviewStatus, candidateScheduleToTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and interviewStatus = ? and candidateScheduleToTime <= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && interviewStatus!=null && interviewStatus!=0 && candidateScheduleFromTime!=null){

			// skillSetId and candidateScheduleToTime missing
			Object values[] = {interviewerId, interviewStatus, candidateScheduleFromTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and interviewStatus = ? and candidateScheduleFromTime >= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && skillSetId!=null && skillSetId!=0 && candidateScheduleToTime!=null){

			// interviewStatus and candidateScheduleFromTime missing
			Object values[] = {interviewerId, skillSetId, candidateScheduleToTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and skillSetId = ? and candidateScheduleToTime <= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && skillSetId!=null && skillSetId!=0 && candidateScheduleFromTime!=null){

			// interviewStatus and candidateScheduleToTime missing
			Object values[] = {interviewerId, skillSetId, candidateScheduleFromTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and skillSetId = ? and candidateScheduleFromTime >= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && skillSetId!=null && skillSetId!=0 && interviewStatus!=null && interviewStatus!=0){

			// candidateScheduleFromTime and candidateScheduleToTime missing
			Object values[] = {interviewerId, skillSetId, interviewStatus};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and skillSetId = ? and interviewStatus = ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && skillSetId!=null && skillSetId!=0){

			// interviewerId and skillSetId given
			Object values[] = {interviewerId, skillSetId};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and skillSetId = ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && interviewStatus!=null && interviewStatus!=0){

			// interviewerId and interviewStatus given
			Object values[] = {interviewerId, interviewStatus};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and interviewStatus = ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && candidateScheduleFromTime!=null){

			// interviewerId and candidateScheduleFromTime given
			Object values[] = {interviewerId, candidateScheduleFromTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and candidateScheduleFromTime >= ? ", values));
			
		}else if(interviewerId!=null && interviewerId!=0 && candidateScheduleToTime!=null){

			// interviewerId and candidateScheduleToTime given
			Object values[] = {interviewerId, candidateScheduleToTime};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ? and candidateScheduleToTime <= ? ", values));
			
		}else if(skillSetId!=null && skillSetId!=0){

			// skillSetId given
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where skillSetId = ?", skillSetId));
			
		}else if(interviewStatus!=null && interviewStatus!=0){

			// interviewStatus given
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewStatus = ? ", interviewStatus));
			
		}else if(candidateScheduleFromTime!=null){

			// candidateScheduleFromTime given
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where candidateScheduleFromTime >= ? ", candidateScheduleFromTime));
			
		}else if(candidateScheduleToTime!=null){

			// candidateScheduleToTime given
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where candidateScheduleToTime <= ? ", candidateScheduleToTime));
			
		}else if(interviewerId!=null && interviewerId!=0){

			// interviewerId given
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CandidateScheduleTiming where interviewerId = ?", interviewerId));
			
		}else{
			// All are zeros and null
			return 0;
		}
		*/
	}
	
	public Integer getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(
			Integer interviewerId, Integer skillSetId, Integer interviewStatus, Date candidateScheduleFromTime, Date candidateScheduleToTime,Integer candidatePerformance) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateScheduleTiming.class);
		if(interviewerId!=null && interviewerId!=0){
			criteria.add(Restrictions.eq("interviewerId", interviewerId));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(interviewStatus!=null && interviewStatus!=0){
			criteria.add(Restrictions.eq("interviewStatus", interviewStatus));
		}
		if(candidateScheduleFromTime!=null){
			criteria.add(Restrictions.ge("candidateScheduleFromTime", candidateScheduleFromTime));
		}
		if(candidateScheduleToTime!=null){
			criteria.add(Restrictions.le("candidateScheduleToTime", candidateScheduleToTime));
		}
		if(candidatePerformance!=null && candidatePerformance!=0){
			criteria.add(Restrictions.le("candidatePerformance", candidatePerformance));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}
	
	public Integer getCandidateScheduleTimingByLocationIdListInterviewStatusListCount(
			List<Integer> locationIdList, Integer interviewStatus) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateScheduleTiming.class);
		if(locationIdList!=null && !locationIdList.isEmpty()){
			criteria.add(Restrictions.in("locationId", locationIdList));
		}
		if(interviewStatus!=null){
			criteria.add(Restrictions.eq("interviewStatus", interviewStatus));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

	@SuppressWarnings("unchecked")
	public CandidateScheduleTiming getByCandidateUniqueId(String candidateUniqueId) {
		List<CandidateScheduleTiming> candidateScheduleTimingList = getHibernateTemplate().find("from CandidateScheduleTiming where upper(candidateUniqueId) = upper(?)", candidateUniqueId);
		if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){ return candidateScheduleTimingList.get(0); }else{ return null; }
	}

	public Integer searchCandidateScheduleTimingListCount(
			Integer candidateScheduleTimingId, Integer candidateId,
			Integer locationId, Integer interviewerId,
			Integer locationScheduleTimingId, Integer skillSetId,
			Integer interviewerSkillSet1, Integer interviewerSkillSet2,
			Integer interviewerSkillSet3, Date candidateScheduleFromTime,
			Date candidateScheduleToTime, String candidateFeedback,
			Integer candidatePerformance, Integer interviewStatus,
			String candidateUniqueId, Integer employerId, 
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateScheduleTiming.class);
		if(candidateScheduleTimingId!=null && candidateScheduleTimingId!=0){
			criteria.add(Restrictions.eq("candidateScheduleTimingId", candidateScheduleTimingId));
		}
		if(candidateId!=null && candidateId!=0){
			criteria.add(Restrictions.eq("candidateId", candidateId));
		}
		if(locationId!=null && locationId!=0){
			criteria.add(Restrictions.eq("locationId", locationId));
		}
		if(interviewerId!=null && interviewerId!=0){
			criteria.add(Restrictions.eq("interviewerId", interviewerId));
		}
		if(locationScheduleTimingId!=null && locationScheduleTimingId!=0){
			criteria.add(Restrictions.eq("locationScheduleTimingId", locationScheduleTimingId));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet1));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet2));
		}else if(interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet3));
		}
		if(candidateScheduleFromTime!=null){
			criteria.add(Restrictions.ge("candidateScheduleFromTime", candidateScheduleFromTime));
		}
		if(candidateScheduleToTime!=null){
			criteria.add(Restrictions.le("candidateScheduleToTime", candidateScheduleToTime));
		}
		if(candidateFeedback!=null && !candidateFeedback.trim().equals("")){
			criteria.add(Restrictions.like("candidateFeedback", "%"+ candidateFeedback +"%"));
		}
		if(candidatePerformance!=null && candidatePerformance!=0){
			criteria.add(Restrictions.eq("candidatePerformance", candidatePerformance));
		}
		if(interviewStatus!=null){
			criteria.add(Restrictions.eq("interviewStatus", interviewStatus));
		}
		if(candidateUniqueId!=null && !candidateUniqueId.equals("")){
			criteria.add(Restrictions.ilike("candidateUniqueId", candidateUniqueId));
		}
		if(employerId!=null){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		if(createdBy!=null && createdBy!=0){
			criteria.add(Restrictions.eq("createdBy", createdBy));
		}
		if(lastModifiedBy!=null && lastModifiedBy!=0){
			criteria.add(Restrictions.eq("lastModifiedBy", lastModifiedBy));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("lastModifiedTime", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("lastModifiedTime", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("lastModifiedTime", toDate));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

	public Integer searchCandidateScheduleTimingListCount(
			Integer candidateScheduleTimingId, Integer candidateId,
			Integer locationId, List<Integer> locationIdList,
			Integer interviewerId, Integer locationScheduleTimingId,
			Integer skillSetId, Integer interviewerSkillSet1,
			Integer interviewerSkillSet2, Integer interviewerSkillSet3,
			Date candidateScheduleFromTime, Date candidateScheduleToTime,
			String candidateFeedback, Integer candidatePerformance,
			Integer interviewStatus, String candidateUniqueId,
			Integer employerId, Integer createdBy,
			Integer lastModifiedBy, Date fromDate, Date toDate, Integer status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CandidateScheduleTiming.class);
		if(candidateScheduleTimingId!=null && candidateScheduleTimingId!=0){
			criteria.add(Restrictions.eq("candidateScheduleTimingId", candidateScheduleTimingId));
		}
		if(candidateId!=null && candidateId!=0){
			criteria.add(Restrictions.eq("candidateId", candidateId));
		}
		if(locationId!=null && locationId!=0){
			criteria.add(Restrictions.eq("locationId", locationId));
		}
		if(locationIdList!=null && !locationIdList.isEmpty()){
			criteria.add(Restrictions.in("locationId", locationIdList));
		}
		if(interviewerId!=null && interviewerId!=0){
			criteria.add(Restrictions.eq("interviewerId", interviewerId));
		}
		if(locationScheduleTimingId!=null && locationScheduleTimingId!=0){
			criteria.add(Restrictions.eq("locationScheduleTimingId", locationScheduleTimingId));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet2};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet1, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0 && interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			Object[] values = {interviewerSkillSet2, interviewerSkillSet3};
			criteria.add(Restrictions.in("skillSetId", values));
		}else if(interviewerSkillSet1!=null && interviewerSkillSet1!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet1));
		}else if(interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet2));
		}else if(interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			criteria.add(Restrictions.eq("skillSetId", interviewerSkillSet3));
		}
		if(candidateScheduleFromTime!=null){
			criteria.add(Restrictions.ge("candidateScheduleFromTime", candidateScheduleFromTime));
		}
		if(candidateScheduleToTime!=null){
			criteria.add(Restrictions.le("candidateScheduleToTime", candidateScheduleToTime));
		}
		if(candidateFeedback!=null && !candidateFeedback.trim().equals("")){
			criteria.add(Restrictions.like("candidateFeedback", "%"+ candidateFeedback +"%"));
		}
		if(candidatePerformance!=null && candidatePerformance!=0){
			criteria.add(Restrictions.eq("candidatePerformance", candidatePerformance));
		}
		if(interviewStatus!=null){
			criteria.add(Restrictions.eq("interviewStatus", interviewStatus));
		}
		if(candidateUniqueId!=null && !candidateUniqueId.equals("")){
			criteria.add(Restrictions.ilike("candidateUniqueId", candidateUniqueId));
		}
		if(employerId!=null){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		if(createdBy!=null && createdBy!=0){
			criteria.add(Restrictions.eq("createdBy", createdBy));
		}
		if(lastModifiedBy!=null && lastModifiedBy!=0){
			criteria.add(Restrictions.eq("lastModifiedBy", lastModifiedBy));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("lastModifiedTime", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("lastModifiedTime", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("lastModifiedTime", toDate));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}


}
