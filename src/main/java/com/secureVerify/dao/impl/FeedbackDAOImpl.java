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
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.FeedbackDAO;
import com.secureVerify.model.Feedback;

public class FeedbackDAOImpl extends HibernateDaoSupport implements FeedbackDAO {

	public void addFeedback(Feedback feedback) {
		getHibernateTemplate().save(feedback);
	}

	public void updateFeedback(Feedback feedback) {
		getHibernateTemplate().update(feedback);
	}

	public void deleteFeedback(Feedback feedback) {
		getHibernateTemplate().delete(feedback);
	}
	
	public void deleteFeedbackList(List<Feedback> feedbackList) {
		getHibernateTemplate().deleteAll(feedbackList);
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> listFeedback() {
		return getHibernateTemplate().find("from Feedback");
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> listActiveFeedback() {
		return getHibernateTemplate().find("from Feedback where status = 1 order by createdTime desc");
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> searchFeedback(Integer feedbackId,
			Integer candidateScheduleTimingId, String feedbackText,
			Integer performance, Date fromDate, Date toDate, Integer status,
			Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Feedback.class);
		if(feedbackId!=null){
			criteria.add(Restrictions.eq("feedbackId", feedbackId));
		}
		if(candidateScheduleTimingId!=null){
			criteria.add(Restrictions.eq("candidateScheduleTimingId", candidateScheduleTimingId));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("createdTime", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("createdTime", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("createdTime", toDate));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		criteria.addOrder(Order.desc("createdTime"));
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public Feedback getFeedbackByFeedbackId(Integer feedbackId) {
		@SuppressWarnings("unchecked")
		List<Feedback> feedbackList = getHibernateTemplate().find("from Feedback where feedbackId = ? order by createdTime desc", feedbackId);
		if(feedbackList!=null && !feedbackList.isEmpty()){ return feedbackList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> getFeedbacksByCandidateScheduleTimingId(Integer candidateScheduleTimingId) {
		return getHibernateTemplate().find("from Feedback where candidateScheduleTimingId = ? order by createdTime desc", candidateScheduleTimingId);
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> getFeedbacksByPerformance(Integer performance) {
		return getHibernateTemplate().find("from Feedback where performance = ? order by createdTime desc", performance);
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> getFeedbackListByPage(final int startRecord, final int endRecord) {
		return (List<Feedback>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Feedback f order by f.createdTime desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<Feedback> list = query.list();
				return list;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> getFeedbackListByPage(final Integer candidateScheduleTimingId, final int startRecord, final int endRecord) {
		return (List<Feedback>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Feedback f where f.candidateScheduleTimingId = ? order by f.createdTime desc");
				query.setParameter(0, candidateScheduleTimingId);
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<Feedback> list = query.list();
				return list;
			}
		});
	}

}
