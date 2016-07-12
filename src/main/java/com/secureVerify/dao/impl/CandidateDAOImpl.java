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

import com.secureVerify.dao.CandidateDAO;
import com.secureVerify.model.Candidate;

public class CandidateDAOImpl extends HibernateDaoSupport implements CandidateDAO {

	public void addCandidate(Candidate candidate) {
		getHibernateTemplate().save(candidate);
	}

	public void updateCandidate(Candidate candidate) {
		getHibernateTemplate().update(candidate);
	}

	public void updateCandidate(Integer candidateId, String verificationCode) {
		Candidate candidate = getCandidateByCandidateId(candidateId);
		if(candidate!=null){
			candidate.setVerificationCode(verificationCode);
			getHibernateTemplate().update(candidate);
		}
	}

	public void updateCandidate(Integer candidateId, String verificationCode, String candidatePassword) {
		Candidate candidate = getCandidateByCandidateId(candidateId);
		if(candidate!=null){
			candidate.setVerificationCode(verificationCode);
			candidate.setCandidatePassword(candidatePassword);
			getHibernateTemplate().update(candidate);
		}
	}

	public void deleteCandidate(Candidate candidate) {
		getHibernateTemplate().delete(candidate);
	}

	public void deleteCandidateList(List<Candidate> candidateList) {
		getHibernateTemplate().deleteAll(candidateList);
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> listCandidate() {
		return getHibernateTemplate().find("from Candidate c order by c.candidateId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> listActiveCandidate() {
		return getHibernateTemplate().find("from Candidate c where c.status = 1 order by c.candidateId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> searchCandidate(Integer candidateId, 
			String candidateFirstName, String candidateLastName,
			String candidateEmailId, String candidatePhoneNo,
			String candidateCity, String candidateState,
			String candidateCountry, String candidateZipcode, Integer skillSetId, 
			String candidatePrefferedLocation, String candidateExpectedSalary, 
			Date creationDate, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Candidate.class);
		if(candidateId!=null && candidateId!=0){
			criteria.add(Restrictions.eq("candidateId", candidateId));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(candidateFirstName!=null && !candidateFirstName.trim().equals("")){
			criteria.add(Restrictions.like("candidateFirstName", "%"+ candidateFirstName +"%"));
		}
		if(candidateLastName!=null && !candidateLastName.trim().equals("")){
			criteria.add(Restrictions.like("candidateLastName", "%"+ candidateLastName +"%"));
		}
		if(candidateEmailId!=null && !candidateEmailId.trim().equals("")){
			criteria.add(Restrictions.like("candidateEmailId", "%"+ candidateEmailId +"%"));
		}
		if(candidatePhoneNo!=null && !candidatePhoneNo.trim().equals("")){
			criteria.add(Restrictions.like("candidatePhoneNo", "%"+ candidatePhoneNo +"%"));
		}
		if(candidateCity!=null && !candidateCity.trim().equals("")){
			criteria.add(Restrictions.like("candidateCity", "%"+ candidateCity +"%"));
		}
		if(candidateState!=null && !candidateState.trim().equals("")){
			criteria.add(Restrictions.like("candidateState", "%"+ candidateState +"%"));
		}
		if(candidateCountry!=null && !candidateCountry.trim().equals("")){
			criteria.add(Restrictions.like("candidateCountry", "%"+ candidateCountry +"%"));
		}
		if(candidateZipcode!=null && !candidateZipcode.trim().equals("")){
			criteria.add(Restrictions.like("candidateZipcode", "%"+ candidateZipcode +"%"));
		}
		if(candidatePrefferedLocation!=null && !candidatePrefferedLocation.trim().equals("")){
			criteria.add(Restrictions.like("candidatePrefferedLocation", "%"+ candidatePrefferedLocation +"%"));
		}
		if(candidateExpectedSalary!=null && !candidateExpectedSalary.trim().equals("")){
			criteria.add(Restrictions.eq("candidateExpectedSalary", candidateExpectedSalary));
		}
		if(creationDate!=null){
			criteria.add(Restrictions.eq("creationDate", creationDate));
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
		criteria.addOrder(Order.desc("candidateId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public Candidate getCandidateByCandidateId(Integer candidateId) {
		List<Candidate> candidateList = getHibernateTemplate().find("from Candidate where candidateId = ?", candidateId);
		if(candidateList!=null && !candidateList.isEmpty()){ return candidateList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Candidate getCandidate(String candidateEmailId, String candidatePassword) {
		Object[] values = {candidateEmailId, candidatePassword};
		List<Candidate> candidateList = getHibernateTemplate().find("from Candidate where candidateEmailId = ? and candidatePassword = ?", values);
		if(candidateList!=null && !candidateList.isEmpty()){ return candidateList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Candidate getCandidateByEmailId(String candidateEmailId) {
		List<Candidate> candidateList = getHibernateTemplate().find("from Candidate where candidateEmailId = ?", candidateEmailId);
		if(candidateList!=null && !candidateList.isEmpty()){ return candidateList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> getCandidatesByZipcode(String candidateZipcode) {
		return getHibernateTemplate().find("from Candidate where candidateZipcode = ?", candidateZipcode);
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> getCandidatesByCity(String candidateCity) {
		return getHibernateTemplate().find("from Candidate where candidateCity = ?", candidateCity);
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> getCandidateListByPage(final int startRecord, final int endRecord) {
		return (List<Candidate>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Candidate c order by c.candidateId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<Candidate> list = query.list();
				return list;
			}
		});
	}

	public Integer getCandidateListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Candidate"));
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> getCandidatesBySkillSet(Integer skillsetId) {
		return getHibernateTemplate().find("from Candidate where skillsetId = ?", skillsetId);
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> getCandidatesByEmployer(Integer employerId) {
		return getHibernateTemplate().find("from Candidate where employerId = ?", employerId);
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> getCandidatesByEmployerAndSkillSet(Integer employerId, Integer skillsetId) {
		Object[] values = {employerId, skillsetId};
		return getHibernateTemplate().find("from Candidate where employerId = ? and skillsetId = ?", values);
	}

	public Integer getCandidateListCountByEmployer(Integer employerId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Candidate where employerId = ?", employerId));
	}
	
	public Integer getCandidateListCountByEmployer(Integer employerId, String candidateFirstName, String candidateEmailId, String candidatePhoneNo, Integer skillSetId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Candidate.class);
		if(employerId!=null && employerId!=0){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		if(candidateFirstName!=null && !candidateFirstName.trim().equals("")){
			criteria.add(Restrictions.like("candidateFirstName", "%"+ candidateFirstName +"%"));
		}
		if(candidateEmailId!=null && !candidateEmailId.trim().equals("")){
			criteria.add(Restrictions.like("candidateEmailId", "%"+ candidateEmailId +"%"));
		}
		if(candidatePhoneNo!=null && !candidatePhoneNo.trim().equals("")){
			criteria.add(Restrictions.like("candidatePhoneNo", "%"+ candidatePhoneNo +"%"));
		}
		if(skillSetId!=null && skillSetId!=0){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}
	
	public Integer getCandidateListCountBySkillSet(Integer skillsetId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Candidate where skillsetId = ?", skillsetId));
	}

}
