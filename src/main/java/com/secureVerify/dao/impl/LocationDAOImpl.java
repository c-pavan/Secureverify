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

import com.secureVerify.dao.LocationDAO;
import com.secureVerify.model.Location;

public class LocationDAOImpl extends HibernateDaoSupport implements LocationDAO {

	public void addLocation(Location location) {
		getHibernateTemplate().save(location);
	}

	public void updateLocation(Location location) {
		getHibernateTemplate().update(location);
	}

	public void deleteLocation(Location location) {
		getHibernateTemplate().delete(location);
	}

	public void deleteLocationList(List<Location> locationList) {
		getHibernateTemplate().deleteAll(locationList);
	}

	@SuppressWarnings("unchecked")
	public List<Location> listLocation() {
		return getHibernateTemplate().find("from Location l order by l.locationId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Location> listActiveLocation() {
		return getHibernateTemplate().find("from Location l where l.status = 1 order by l.locationId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Location> searchLocation(Integer locationId,
			String locationName, String locationBusinessName,
			String locationAddressLine1, String locationAddressLine2,
			String locationCity, String locationState, String locationCountry,
			String locationZipcode, String locationPhoneNo,
			Integer locationPrimaryAgentId, Integer locationSecondaryAgentId,
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Location.class);
		if(locationId!=null){
			criteria.add(Restrictions.eq("locationId", locationId));
		}
		if(locationName!=null && !locationName.trim().equals("")){
			criteria.add(Restrictions.ilike("locationName", "%"+ locationName +"%"));
		}
		if(locationBusinessName!=null && !locationBusinessName.trim().equals("")){
			criteria.add(Restrictions.ilike("locationBusinessName", "%"+ locationBusinessName +"%"));
		}
		if(locationAddressLine1!=null && !locationAddressLine1.trim().equals("")){
			criteria.add(Restrictions.ilike("locationAddressLine1", "%"+ locationAddressLine1 +"%"));
		}
		if(locationAddressLine2!=null && !locationAddressLine2.trim().equals("")){
			criteria.add(Restrictions.ilike("locationAddressLine2", "%"+ locationAddressLine2 +"%"));
		}
		if(locationCity!=null && !locationCity.trim().equals("")){
			criteria.add(Restrictions.ilike("locationCity", "%"+ locationCity +"%"));
		}
		if(locationState!=null && !locationState.trim().equals("")){
			criteria.add(Restrictions.ilike("locationState", "%"+ locationState +"%"));
		}
		if(locationCountry!=null && !locationCountry.trim().equals("")){
			criteria.add(Restrictions.ilike("locationCountry", "%"+ locationCountry +"%"));
		}
		if(locationZipcode!=null && !locationZipcode.trim().equals("")){
			criteria.add(Restrictions.ilike("locationZipcode", "%"+ locationZipcode +"%"));
		}
		if(locationPhoneNo!=null && !locationPhoneNo.trim().equals("")){
			criteria.add(Restrictions.ilike("locationPhoneNo", "%"+ locationPhoneNo +"%"));
		}
		if(locationPrimaryAgentId!=null){
			criteria.add(Restrictions.eq("locationPrimaryAgentId", locationPrimaryAgentId));
		}
		if(locationSecondaryAgentId!=null){
			criteria.add(Restrictions.eq("locationSecondaryAgentId", locationSecondaryAgentId));
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
		criteria.addOrder(Order.desc("locationId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public Location getLocationByLocationId(Integer locationId) {
		List<Location> locationList = getHibernateTemplate().find("from Location where locationId = ?", locationId);
		if(locationList!=null && !locationList.isEmpty()){ return locationList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Location getLocation(String locationEmailId, String locationPassword) {
		Object[] values = {locationEmailId, locationPassword};
		List<Location> locationList = getHibernateTemplate().find("from Location where locationEmailId = ? and locationPassword = ?", values);
		if(locationList!=null && !locationList.isEmpty()){ return locationList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Location getLocationByEmailId(String locationEmailId) {
		List<Location> locationList = getHibernateTemplate().find("from Location where locationEmailId = ?", locationEmailId);
		if(locationList!=null && !locationList.isEmpty()){ return locationList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<Location> getLocationsByZipcode(String locationZipcode) {
		return getHibernateTemplate().find("from Location where locationZipcode = ?", locationZipcode);
	}

	@SuppressWarnings("unchecked")
	public List<Location> getLocationsByCity(String locationCity) {
		return getHibernateTemplate().find("from Location where locationCity = ?", locationCity);
	}

	@SuppressWarnings("unchecked")
	public List<Location> getLocationListByPage(final int startRecord, final int endRecord) {
		return (List<Location>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Location l order by l.locationId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<Location> list = query.list();
				return list;
			}
		});
	}

	public Integer getLocationListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Location"));
	}
	
	public Integer getLocationListCount(String locationName, String locationBusinessName, String locationCity, String locationCountry){
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Location.class);
		if(locationName!=null && !locationName.trim().equals("")){
			criteria.add(Restrictions.ilike("locationName", "%"+ locationName +"%"));
		}
		if(locationBusinessName!=null && !locationBusinessName.trim().equals("")){
			criteria.add(Restrictions.ilike("locationBusinessName", "%"+ locationBusinessName +"%"));
		}
		if(locationCity!=null && !locationCity.trim().equals("")){
			criteria.add(Restrictions.ilike("locationCity", "%"+ locationCity +"%"));
		}
		if(locationCountry!=null && !locationCountry.trim().equals("")){
			criteria.add(Restrictions.ilike("locationCountry", "%"+ locationCountry +"%"));
		}
		criteria.addOrder(Order.desc("locationId"));
		return getHibernateTemplate().findByCriteria(criteria).size();
		
		/* To Do Which one is better
		if(locationName!=null && !locationName.equals("")){locationName = "%" + locationName.toUpperCase() + "%"; }
		if(locationBusinessName!=null && !locationBusinessName.equals("")){locationBusinessName = "%" + locationBusinessName.toUpperCase()+ "%"; }
		if(locationCity!=null && !locationCity.equals("")){locationName = "%" + locationCity.toUpperCase()+ "%"; }
		if(locationCountry!=null && !locationCountry.equals("")){locationCountry = "%" + locationCountry.toUpperCase()+ "%"; }
		
		if(locationName!=null && !locationName.equals("") && locationBusinessName!=null && !locationBusinessName.equals("") && 
				locationCity!=null && !locationCity.equals("") && locationCountry!=null && !locationCountry.equals("")){
			
			Object[] values = {locationName,locationBusinessName,locationCity,locationCountry};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Location where upper(locationName) like ? and upper(locationBusinessName) like ? and upper(locationCity) like ? and upper(locationCountry) like ?" + values));
		}	else if(locationName!=null && !locationName.equals("")){
			
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Location where upper(locationName) like ?", locationName ));			
		}  else if(locationBusinessName!=null && !locationBusinessName.equals("")){
			
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Location where upper(locationBusinessName) like ?", locationBusinessName ));			
		}  else if(locationCity!=null && !locationCity.equals("")){
			
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Location where upper(locationCity) like ?", locationCity ));			
		}  else if(locationCountry!=null && !locationCountry.equals("")){
			
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Location where upper(locationCountry) like ?", locationCountry ));			
		}
		
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Location "));*/
	}

	@SuppressWarnings("unchecked")
	public List<Location> getLocationByAgentId(Integer locationAgentId) {
		Object[] values= {locationAgentId, locationAgentId};
		return getHibernateTemplate().find("from Location where locationPrimaryAgentId = ? or locationSecondaryAgentId = ?", values);
	}

	@SuppressWarnings("unchecked")
	public List<Location> listLocationByLatitudeAndLongitude(Double latitude, Double longitude) {
		Session session = getSession();
		Query query = session.createSQLQuery("SELECT *, ((ACOS(SIN(:latitude * PI() / 180) * SIN(latitude * PI() / 180) + COS(:latitude * PI() / 180)" +
				" * COS(latitude * PI() / 180) * COS((:longitude - longitude) * PI() / 180)) * 180 / PI()) * 60 * 1.1515) AS distance FROM location a " +
				"HAVING distance<=1000 ORDER BY distance ASC").addEntity(Location.class)
				.setParameter("latitude", latitude).setParameter("longitude", longitude);
		List<Location> locationList = (List<Location>) query.list();
		releaseSession(session);
		return locationList;
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getLocationIdsByAgentId(Integer locationAgentId) {
		Object[] values= {locationAgentId, locationAgentId};
		return getHibernateTemplate().find("select locationId from Location where locationPrimaryAgentId = ? or locationSecondaryAgentId = ?", values);
	}

}
