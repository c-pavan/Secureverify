package com.secureVerify.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.InterviewerDAO;
import com.secureVerify.model.Interviewer;

public class InterviewerDAOImpl extends HibernateDaoSupport implements InterviewerDAO {

	public void addInterviewer(Interviewer interviewer) {
		getHibernateTemplate().save(interviewer);
	}

	public void updateInterviewer(Interviewer interviewer) {
		getHibernateTemplate().update(interviewer);
	}

	public void updateInterviewer(Integer interviewerId, String verificationCode) {
		Interviewer interviewer = getInterviewerByInterviewerId(interviewerId);
		if(interviewer!=null){
			interviewer.setVerificationCode(verificationCode);
			getHibernateTemplate().update(interviewer);
		}
	}

	public void updateInterviewer(Integer interviewerId, String verificationCode, String interviewerPassword) {
		Interviewer interviewer = getInterviewerByInterviewerId(interviewerId);
		if(interviewer!=null){
			interviewer.setVerificationCode(verificationCode);
			interviewer.setInterviewerPassword(interviewerPassword);;
			getHibernateTemplate().update(interviewer);
		}
	}

	public void deleteInterviewer(Interviewer interviewer) {
		getHibernateTemplate().delete(interviewer);
	}

	public void deleteInterviewerList(List<Interviewer> interviewerList) {
		getHibernateTemplate().deleteAll(interviewerList);
	}

	@SuppressWarnings("unchecked")
	public List<Interviewer> listInterviewer() {
		return getHibernateTemplate().find("from Interviewer i order by i.interviewerId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Interviewer> listActiveInterviewer() {
		return getHibernateTemplate().find("from Interviewer i where i.status = 1 order by i.interviewerId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Interviewer> searchInterviewer(Integer interviewerId,
			String interviewerFirstName, String interviewerLastName,
			String interviewerEmailId, String interviewerPhoneNo,
			Integer interviewerSkillSet1, Integer interviewerSkillSet2,
			Integer interviewerSkillSet3, Integer createdBy,
			Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, 
			Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Interviewer.class);
		if(interviewerId!=null){
			criteria.add(Restrictions.eq("interviewerId", interviewerId));
		}
		if(interviewerFirstName!=null && !interviewerFirstName.trim().equals("")){
			criteria.add(Restrictions.like("interviewerFirstName", "%"+ interviewerFirstName +"%"));
		}
		if(interviewerLastName!=null && !interviewerLastName.trim().equals("")){
			criteria.add(Restrictions.like("interviewerLastName", "%"+ interviewerLastName +"%"));
		}
		if(interviewerEmailId!=null && !interviewerEmailId.trim().equals("")){
			criteria.add(Restrictions.like("interviewerEmailId", "%"+ interviewerEmailId +"%"));
		}
		if(interviewerPhoneNo!=null && !interviewerPhoneNo.trim().equals("")){
			criteria.add(Restrictions.like("interviewerPhoneNo", "%"+ interviewerPhoneNo +"%"));
		}
		if(interviewerSkillSet1!=null && interviewerSkillSet1!=0){
			criteria.add(Restrictions.eq("interviewerSkillSet1", interviewerSkillSet1));
		}
		if(interviewerSkillSet2!=null && interviewerSkillSet2!=0){
			criteria.add(Restrictions.eq("interviewerSkillSet2", interviewerSkillSet2));
		}
		if(interviewerSkillSet3!=null && interviewerSkillSet3!=0){
			criteria.add(Restrictions.eq("interviewerSkillSet3", interviewerSkillSet3));
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
		criteria.addOrder(Order.desc("interviewerId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public List<Interviewer> searchInterviewer(String interviewerName,
			String interviewerEmailId, String interviewerPhoneNo,
			Integer interviewerSkillSet, Integer status, Integer startRecord,
			Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Interviewer.class);
		if(interviewerName!=null && !interviewerName.trim().equals("")){
			Criterion c1 = Restrictions.ilike("interviewerFirstName", "%"+ interviewerName +"%");
			Criterion c2 = Restrictions.ilike("interviewerLastName", "%"+ interviewerName +"%");
			LogicalExpression logicOr=Restrictions.or(c1, c2);
			criteria.add(logicOr);
		}
		if(interviewerEmailId!=null && !interviewerEmailId.trim().equals("")){
			criteria.add(Restrictions.ilike("interviewerEmailId", "%"+ interviewerEmailId +"%"));
		}
		if(interviewerPhoneNo!=null && !interviewerPhoneNo.trim().equals("")){
			criteria.add(Restrictions.ilike("interviewerPhoneNo", "%"+ interviewerPhoneNo +"%"));
		}
		if(interviewerSkillSet!=null){
			Criterion c1 = Restrictions.eq("interviewerSkillSet1", interviewerSkillSet);
			Criterion c2 = Restrictions.eq("interviewerSkillSet2", interviewerSkillSet);
			Criterion c3 = Restrictions.eq("interviewerSkillSet3", interviewerSkillSet);
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(c1);
			disjunction.add(c2);
			disjunction.add(c3);
			criteria.add(disjunction);
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		criteria.addOrder(Order.desc("interviewerId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public Interviewer getInterviewerByInterviewerId(Integer interviewerId) {
		List<Interviewer> interviewerList = getHibernateTemplate().find("from Interviewer where interviewerId = ?", interviewerId);
		if(interviewerList!=null && !interviewerList.isEmpty()){ return interviewerList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Interviewer getInterviewer(String interviewerEmailId, String interviewerPassword) {
		Object[] values = {interviewerEmailId, interviewerPassword};
		List<Interviewer> interviewerList = getHibernateTemplate().find("from Interviewer where interviewerEmailId = ? and interviewerPassword = ?", values);
		if(interviewerList!=null && !interviewerList.isEmpty()){ return interviewerList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Interviewer getInterviewerByEmailId(String interviewerEmailId) {
		List<Interviewer> interviewerList = getHibernateTemplate().find("from Interviewer where interviewerEmailId = ?", interviewerEmailId);
		if(interviewerList!=null && !interviewerList.isEmpty()){ return interviewerList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<Interviewer> getInterviewerListByPage(final int startRecord, final int endRecord) {
		return (List<Interviewer>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Interviewer i order by i.interviewerId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<Interviewer> list = query.list();
				return list;
			}
		});
	}

	public Integer getInterviewerListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer"));
	}

	@SuppressWarnings("unchecked")
	public List<Interviewer> getInterviewerListBySkillSet(Integer interviewerSkillSet) {
		Object[] values = {interviewerSkillSet, interviewerSkillSet, interviewerSkillSet};
		return getHibernateTemplate().find("from Interviewer where interviewerSkillSet1 = ? or interviewerSkillSet2 = ? or interviewerSkillSet3 = ?", values);
	}

	public Integer getInterviewerListCount(String interviewerName, String interviewerEmailId, String interviewerPhoneNo, Integer interviewerSkillSet, Integer status) {
		
		if(interviewerName!=null && !interviewerName.equals("")){ interviewerName = "%"+interviewerName.toUpperCase()+"%"; }
		if(interviewerEmailId!=null && !interviewerEmailId.equals("")){ interviewerEmailId = "%"+interviewerEmailId.toUpperCase()+"%"; }
		if(interviewerPhoneNo!=null && !interviewerPhoneNo.equals("")){ interviewerPhoneNo = "%"+interviewerPhoneNo+"%"; }
		/*
		DetachedCriteria criteria = DetachedCriteria.forClass(Interviewer.class);
		if(interviewerName!=null && !interviewerName.trim().equals("")){
			Criterion c1 = Restrictions.ilike("interviewerFirstName", "%"+ interviewerName +"%");
			Criterion c2 = Restrictions.ilike("interviewerLastName", "%"+ interviewerName +"%");
			LogicalExpression logicOr=Restrictions.or(c1, c2);
			criteria.add(logicOr);
		}
		if(interviewerEmailId!=null && !interviewerEmailId.trim().equals("")){
			criteria.add(Restrictions.ilike("interviewerEmailId", "%"+ interviewerEmailId +"%"));
		}
		if(interviewerPhoneNo!=null && !interviewerPhoneNo.trim().equals("")){
			criteria.add(Restrictions.ilike("interviewerPhoneNo", "%"+ interviewerPhoneNo +"%"));
		}
		if(interviewerSkillSet!=null){
			Criterion c1 = Restrictions.eq("interviewerSkillSet1", interviewerSkillSet);
			Criterion c2 = Restrictions.eq("interviewerSkillSet2", interviewerSkillSet);
			Criterion c3 = Restrictions.eq("interviewerSkillSet3", interviewerSkillSet);
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(c1);
			disjunction.add(c2);
			disjunction.add(c3);
			criteria.add(disjunction);
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		List<Interviewer> interviewerList = getHibernateTemplate().findByCriteria(criteria);
		if(interviewerList!=null && !interviewerList.isEmpty()){
			return interviewerList.size();
		}else{
			return 0;
		}
		*/
		
		if(interviewerName!=null && !interviewerName.equals("") && interviewerEmailId!=null && !interviewerEmailId.equals("") && interviewerPhoneNo!=null && !interviewerPhoneNo.equals("") && interviewerSkillSet!=null && status!=null){
			
			// All Values Given
			Object[] values= {interviewerName, interviewerName, interviewerEmailId, interviewerPhoneNo, interviewerSkillSet, interviewerSkillSet, interviewerSkillSet, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where (upper(interviewerFirstName) like ? or upper(interviewerLastName) like ?) and upper(interviewerEmailId) like ? and upper(interviewerPhoneNo) like ? and (interviewerSkillSet1 = ? or interviewerSkillSet2 = ? or interviewerSkillSet3 = ?) and status = ?", values));
			
		}else if(interviewerEmailId!=null && !interviewerEmailId.equals("") && interviewerPhoneNo!=null && !interviewerPhoneNo.equals("") && interviewerSkillSet!=null && status!=null){
			
			// interviewerName Missing
			Object[] values= {interviewerEmailId, interviewerPhoneNo, interviewerSkillSet, interviewerSkillSet, interviewerSkillSet, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where upper(interviewerEmailId) like ? and upper(interviewerPhoneNo) like ? and (interviewerSkillSet1 = ? or interviewerSkillSet2 = ? or interviewerSkillSet3 = ?) and status = ?", values));
			
		}else if(interviewerName!=null && !interviewerName.equals("") && interviewerPhoneNo!=null && !interviewerPhoneNo.equals("") && interviewerSkillSet!=null && status!=null){
			
			// interviewerEmailId Missing
			Object[] values= {interviewerName, interviewerName, interviewerPhoneNo, interviewerSkillSet, interviewerSkillSet, interviewerSkillSet, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where (upper(interviewerFirstName) like ? or upper(interviewerLastName) like ?) and upper(interviewerPhoneNo) like ? and (interviewerSkillSet1 = ? or interviewerSkillSet2 = ? or interviewerSkillSet3 = ?) and status = ?", values));
			
		}else if(interviewerName!=null && !interviewerName.equals("") && interviewerEmailId!=null && !interviewerEmailId.equals("") && interviewerSkillSet!=null && status!=null){
			
			// interviewerPhoneNo Missing
			Object[] values= {interviewerName, interviewerName, interviewerEmailId, interviewerSkillSet, interviewerSkillSet, interviewerSkillSet, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where (upper(interviewerFirstName) like ? or upper(interviewerLastName) like ?) and upper(interviewerEmailId) like ? and (interviewerSkillSet1 = ? or interviewerSkillSet2 = ? or interviewerSkillSet3 = ?) and status = ?", values));
			
		}else if(interviewerName!=null && !interviewerName.equals("") && interviewerPhoneNo!=null && !interviewerPhoneNo.equals("") && interviewerSkillSet!=null && status!=null){
			
			// interviewerSkillSet Missing
			Object[] values= {interviewerName, interviewerName, interviewerEmailId, interviewerPhoneNo, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where (upper(interviewerFirstName) like ? or upper(interviewerLastName) like ?) and upper(interviewerEmailId) like ? and upper(interviewerPhoneNo) like ? and status = ?", values));
			
		}else if(interviewerPhoneNo!=null && !interviewerPhoneNo.equals("") && interviewerSkillSet!=null && status!=null){
			
			// interviewerName and interviewerEmailId Missing
			Object[] values= {interviewerPhoneNo, interviewerSkillSet, interviewerSkillSet, interviewerSkillSet, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where upper(interviewerPhoneNo) like ? and (interviewerSkillSet1 = ? or interviewerSkillSet2 = ? or interviewerSkillSet3 = ?) and status = ?", values));
			
		}else if(interviewerEmailId!=null && !interviewerEmailId.equals("") && interviewerSkillSet!=null && status!=null){
			
			// interviewerName and interviewerPhoneNo Missing
			Object[] values= {interviewerEmailId, interviewerSkillSet, interviewerSkillSet, interviewerSkillSet, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where upper(interviewerEmailId) like ? and (interviewerSkillSet1 = ? or interviewerSkillSet2 = ? or interviewerSkillSet3 = ?) and status = ?", values));
			
		}else if(interviewerEmailId!=null && !interviewerEmailId.equals("") && interviewerPhoneNo!=null && !interviewerPhoneNo.equals("") && status!=null){
			
			// interviewerName and interviewerSkillSet Missing
			Object[] values= {interviewerEmailId, interviewerPhoneNo, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where upper(interviewerEmailId) like ? and upper(interviewerPhoneNo) like ? and status = ?", values));
			
		}else if(interviewerName!=null && !interviewerName.equals("") && interviewerSkillSet!=null && status!=null){
			
			// interviewerEmailId and interviewerPhoneNo Missing
			Object[] values= {interviewerName, interviewerName, interviewerSkillSet, interviewerSkillSet, interviewerSkillSet, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where (upper(interviewerFirstName) like ? or upper(interviewerLastName) like ?) and (interviewerSkillSet1 = ? or interviewerSkillSet2 = ? or interviewerSkillSet3 = ?) and status = ?", values));
			
		}else if(interviewerName!=null && !interviewerName.equals("") && interviewerPhoneNo!=null && !interviewerPhoneNo.equals("") && status!=null){
			
			// interviewerEmailId and interviewerSkillSet Missing
			Object[] values= {interviewerName, interviewerName, interviewerPhoneNo, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where (upper(interviewerFirstName) like ? or upper(interviewerLastName) like ?) and upper(interviewerPhoneNo) like ? and status = ?", values));
			
		}else if(interviewerName!=null && !interviewerName.equals("") && interviewerEmailId!=null && !interviewerEmailId.equals("") && status!=null){
			
			// interviewerPhoneNo and interviewerSkillSet Missing
			Object[] values= {interviewerName, interviewerName, interviewerEmailId, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where (upper(interviewerFirstName) like ? or upper(interviewerLastName) like ?) and upper(interviewerEmailId) like upper(? )and status = ?", values));
			
		}else if(interviewerName!=null && !interviewerName.equals("") && status!=null){
			
			// interviewerName and status Given
			Object[] values= {interviewerName, interviewerName, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where (upper(interviewerFirstName) like ? or upper(interviewerLastName) like ?) and status = ?", values));
			
		}else if(interviewerEmailId!=null && !interviewerEmailId.equals("") && status!=null){
			
			// interviewerEmailId and status Given
			Object[] values= {interviewerEmailId, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where upper(interviewerEmailId) like ? and status = ?", values));
			
		}else if(interviewerPhoneNo!=null && !interviewerPhoneNo.equals("") && status!=null){
			
			// interviewerPhoneNo and status Given
			Object[] values= {interviewerPhoneNo, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where upper(interviewerPhoneNo) like ? and status = ?", values));
			
		}else if(interviewerSkillSet!=null && status!=null){
			
			// interviewerSkillSet and status Given
			Object[] values= {interviewerSkillSet, interviewerSkillSet, interviewerSkillSet, status };
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where (interviewerSkillSet1 = ? or interviewerSkillSet2 = ? or interviewerSkillSet3 = ?) and status = ?", values));
			
		}else if(status!=null){
			
			// status Given
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer where status = ?", status));
			
		}else{
			
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Interviewer"));
			
		}
	}

}
