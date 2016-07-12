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

import com.secureVerify.dao.LocationScheduleTimingDAO;
import com.secureVerify.model.LocationScheduleTiming;

public class LocationScheduleTimingDAOImpl extends HibernateDaoSupport implements LocationScheduleTimingDAO {

	public void addLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming) {
		getHibernateTemplate().save(locationScheduleTiming);
	}

	public void updateLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming) {
		getHibernateTemplate().update(locationScheduleTiming);
	}

	public void deleteLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming) {
		getHibernateTemplate().delete(locationScheduleTiming);
	}

	public void deleteLocationScheduleTimingList(List<LocationScheduleTiming> locationScheduleTimingList) {
		getHibernateTemplate().deleteAll(locationScheduleTimingList);
	}

	@SuppressWarnings("unchecked")
	public List<LocationScheduleTiming> listLocationScheduleTiming() {
		return getHibernateTemplate().find("from LocationScheduleTiming");
	}

	@SuppressWarnings("unchecked")
	public List<LocationScheduleTiming> listActiveLocationScheduleTiming() {
		return getHibernateTemplate().find("from LocationScheduleTiming where status = 1");
	}

	@SuppressWarnings("unchecked")
	public LocationScheduleTiming getLocationScheduleTimingByLocationScheduleTimingId(Integer locationScheduleTimingId) {
		List<LocationScheduleTiming> locationScheduleTimingList = getHibernateTemplate().find("from LocationScheduleTiming where locationScheduleTimingId = ?", locationScheduleTimingId);
		if(locationScheduleTimingList!=null && !locationScheduleTimingList.isEmpty()){ return locationScheduleTimingList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<LocationScheduleTiming> getLocationScheduleTimingByLocationId(Integer locationId) {
		return getHibernateTemplate().find("from LocationScheduleTiming where locationId = ?", locationId);
	}

	@SuppressWarnings("unchecked")
	public List<LocationScheduleTiming> getLocationScheduleTimingByAgentId(Integer agentId) {
		Object[] values = {agentId, agentId};
		return getHibernateTemplate().find("from LocationScheduleTiming where createdBy = ? or lastModifiedBy = ?", values);
	}

	@SuppressWarnings("unchecked")
	public List<LocationScheduleTiming> searchLocationScheduleTiming(
			Integer locationScheduleTimingId, Integer locationId,
			Date locationScheduleFromTime, Date locationScheduleToTime,
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LocationScheduleTiming.class);
		if(locationScheduleTimingId!=null){
			criteria.add(Restrictions.eq("locationScheduleTimingId", locationScheduleTimingId));
		}
		if(locationId!=null && locationId!=0){
			criteria.add(Restrictions.eq("locationId", locationId));
		}
		if(locationScheduleFromTime!=null && locationScheduleToTime!=null){
			criteria.add(Restrictions.ge("locationScheduleFromTime", locationScheduleFromTime));
			criteria.add(Restrictions.le("locationScheduleToTime", locationScheduleToTime));
		}else if(locationScheduleFromTime!=null){
			criteria.add(Restrictions.ge("locationScheduleFromTime", locationScheduleFromTime));
		}else if(locationScheduleToTime!=null){
			criteria.add(Restrictions.le("locationScheduleToTime", locationScheduleToTime));
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
		criteria.addOrder(Order.desc("locationScheduleTimingId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public List<LocationScheduleTiming> getLocationScheduleTimingListByPage(final int startRecord, final int endRecord) {
		return (List<LocationScheduleTiming>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from LocationScheduleTiming lst order by lst.locationScheduleTimingId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<LocationScheduleTiming> list = query.list();
				return list;
			}
		});
	}

	public Integer getLocationScheduleTimingListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from LocationScheduleTiming"));
	}

	public Integer getLocationScheduleTimingListCountByLocationId(Integer locationId) {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from LocationScheduleTiming where locationId = ?", locationId));
	}

	@SuppressWarnings("unchecked")
	public List<LocationScheduleTiming> getLocationScheduleTimingListByLocationIdPage(
			final Integer locationId, final int startRecord, final int endRecord) {
		return (List<LocationScheduleTiming>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from LocationScheduleTiming lst where lst.locationId = ? order by lst.locationScheduleTimingId desc");
				query.setParameter(0, locationId);
				query.setMaxResults(endRecord);
				query.setMaxResults(endRecord);
				List<LocationScheduleTiming> list = query.list();
				return list;
			}
		});
	}

	public Integer getLocationScheduleTimingListCountByLocationIds(List<Integer> locationIdList) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LocationScheduleTiming.class);
		if(locationIdList!=null && !locationIdList.isEmpty()){
			criteria.add(Restrictions.in("locationId", locationIdList));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

	@SuppressWarnings("unchecked")
	public List<LocationScheduleTiming> getLocationScheduleTimingListByLocationIdListPage(
			List<Integer> locationIdList, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LocationScheduleTiming.class);
		if(locationIdList!=null && !locationIdList.isEmpty()){
			criteria.add(Restrictions.in("locationId", locationIdList));
		}
		criteria.addOrder(Order.desc("locationScheduleTimingId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

}
