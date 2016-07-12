package com.secureVerify.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.EmployerDAO;
import com.secureVerify.model.Employer;

public class EmployerDAOImpl extends HibernateDaoSupport implements EmployerDAO {

	public void addEmployer(Employer employer) {
		getHibernateTemplate().save(employer);
	}

	public void updateEmployer(Employer employer) {
		getHibernateTemplate().update(employer);
	}

	public void updateEmployer(Integer employerId, String verificationCode) {
		Employer employer = getEmployerByEmployerId(employerId);
		if(employer!=null){
			employer.setVerificationCode(verificationCode);
			getHibernateTemplate().update(employer);
		}
	}

	public void updateEmployer(Integer employerId, String verificationCode, String employerPassword) {
		Employer employer = getEmployerByEmployerId(employerId);
		if(employer!=null){
			employer.setVerificationCode(verificationCode);
			employer.setEmployerPassword(employerPassword);
			getHibernateTemplate().update(employer);
		}
	}

	public void deleteEmployer(Employer employer) {
		getHibernateTemplate().delete(employer);
	}

	public void deleteEmployerList(List<Employer> employerList) {
		getHibernateTemplate().deleteAll(employerList);
	}

	@SuppressWarnings("unchecked")
	public List<Employer> listEmployer() {
		return getHibernateTemplate().find("from Employer e order by e.employerId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Employer> listActiveEmployer() {
		return getHibernateTemplate().find("from Employer e where e.status = 1 order by e.employerId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Employer> searchEmployer(Integer employerId,
			String employerFirstName, String employerLastName,
			String employerEmailId, String employerPhoneNo,
			String employerCompanyName, String employerTitle,
			String employerCity, String employerState, String employerCountry,
			String employerZipcode, Date creationDate, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employer.class);
		if(employerId!=null){
			criteria.add(Restrictions.eq("employerId", employerId));
		}
		if(employerFirstName!=null && !employerFirstName.trim().equals("")){
			criteria.add(Restrictions.ilike("employerFirstName", "%"+ employerFirstName +"%"));
		}
		if(employerLastName!=null && !employerLastName.trim().equals("")){
			criteria.add(Restrictions.ilike("employerLastName", "%"+ employerLastName +"%"));
		}
		if(employerEmailId!=null && !employerEmailId.trim().equals("")){
			criteria.add(Restrictions.ilike("employerEmailId", "%"+ employerEmailId +"%"));
		}
		if(employerPhoneNo!=null && !employerPhoneNo.trim().equals("")){
			criteria.add(Restrictions.ilike("employerPhoneNo", "%"+ employerPhoneNo +"%"));
		}
		if(employerCompanyName!=null && !employerCompanyName.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCompanyName", "%"+ employerCompanyName +"%"));
		}
		if(employerTitle!=null && !employerTitle.trim().equals("")){
			criteria.add(Restrictions.ilike("employerTitle", "%"+ employerTitle +"%"));
		}
		if(employerCity!=null && !employerCity.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCity", "%"+ employerCity +"%"));
		}
		if(employerState!=null && !employerState.trim().equals("")){
			criteria.add(Restrictions.ilike("employerState", "%"+ employerState +"%"));
		}
		if(employerCountry!=null && !employerCountry.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCountry", "%"+ employerCountry +"%"));
		}
		if(employerZipcode!=null && !employerZipcode.trim().equals("")){
			criteria.add(Restrictions.ilike("employerZipcode", "%"+ employerZipcode +"%"));
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
		criteria.addOrder(Order.desc("employerId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employer> searchEmployer(String employerName, String employerEmailId, String employerPhoneNo,
			String employerCompanyName, String employerTitle, String employerCity, String employerState,
			String employerCountry,	String employerZipcode, Date creationDate, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord){
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Employer.class);
		if(employerName!=null && !employerName.trim().equals("")){
			Criterion c1 = Restrictions.ilike("employerFirstName", "%"+ employerName +"%");
			Criterion c2 = Restrictions.ilike("employerLastName", "%"+ employerName +"%");
			LogicalExpression logicOr=Restrictions.or(c1, c2);
			criteria.add(logicOr);
		}
		if(employerEmailId!=null && !employerEmailId.trim().equals("")){
			criteria.add(Restrictions.ilike("employerEmailId", "%"+ employerEmailId +"%"));
		}
		if(employerPhoneNo!=null && !employerPhoneNo.trim().equals("")){
			criteria.add(Restrictions.ilike("employerPhoneNo", "%"+ employerPhoneNo +"%"));
		}
		if(employerCompanyName!=null && !employerCompanyName.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCompanyName", "%"+ employerCompanyName +"%"));
		}
		if(employerTitle!=null && !employerTitle.trim().equals("")){
			criteria.add(Restrictions.ilike("employerTitle", "%"+ employerTitle +"%"));
		}
		if(employerCity!=null && !employerCity.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCity", "%"+ employerCity +"%"));
		}
		if(employerState!=null && !employerState.trim().equals("")){
			criteria.add(Restrictions.ilike("employerState", "%"+ employerState +"%"));
		}
		if(employerCountry!=null && !employerCountry.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCountry", "%"+ employerCountry +"%"));
		}
		if(employerZipcode!=null && !employerZipcode.trim().equals("")){
			criteria.add(Restrictions.ilike("employerZipcode", "%"+ employerZipcode +"%"));
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
		criteria.addOrder(Order.desc("employerId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}
	public Employer getEmployerByEmployerId(Integer employerId) {
		@SuppressWarnings("unchecked")
		List<Employer> employerList = getHibernateTemplate().find("from Employer where employerId = ?", employerId);
		if(employerList!=null && !employerList.isEmpty()){ return employerList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Employer getEmployer(String employerEmailId, String employerPassword) {
		Object[] values = {employerEmailId, employerPassword};
		List<Employer> employerList = getHibernateTemplate().find("from Employer where employerEmailId = ? and employerPassword = ?", values);
		if(employerList!=null && !employerList.isEmpty()){ return employerList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Employer getEmployerByEmailId(String employerEmailId) {
		List<Employer> employerList = getHibernateTemplate().find("from Employer where employerEmailId = ?", employerEmailId);
		if(employerList!=null && !employerList.isEmpty()){ return employerList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<Employer> getEmployersByZipcode(String employerZipcode) {
		return getHibernateTemplate().find("from Employer where employerZipcode = ?", employerZipcode);
	}

	@SuppressWarnings("unchecked")
	public List<Employer> getEmployersByCity(String employerCity) {
		return getHibernateTemplate().find("from Employer where employerCity = ?", employerCity);
	}

	@SuppressWarnings("unchecked")
	public List<Employer> getEmployerListByPage(final int startRecord, final int endRecord) {
		return (List<Employer>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Employer e order by e.employerId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<Employer> list = query.list();
				return list;
			}
		});
	}

	public Integer getEmployerListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Employer"));
	}

	@SuppressWarnings("unchecked")
	public Employer getActiveEmployer(String employerEmailId, String employerPassword) {
		Object[] values = {employerEmailId, employerPassword};
		List<Employer> employerList = getHibernateTemplate().find("from Employer where employerEmailId = ? and employerPassword = ? and status = 1", values);
		if(employerList!=null && !employerList.isEmpty()){ return employerList.get(0); }else{ return null; }
	}

	public Integer getEmployerListCount(String employerFirstName,
			String employerLastName, String employerEmailId,
			String employerPhoneNo, String employerCompanyName,
			String employerTitle, String employerCity, String employerState,
			String employerCountry, String employerZipcode, Integer status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employer.class);
		if(employerFirstName!=null && !employerFirstName.trim().equals("")){
			criteria.add(Restrictions.ilike("employerFirstName", "%"+ employerFirstName +"%"));
		}
		if(employerLastName!=null && !employerLastName.trim().equals("")){
			criteria.add(Restrictions.ilike("employerLastName", "%"+ employerLastName +"%"));
		}
		if(employerEmailId!=null && !employerEmailId.trim().equals("")){
			criteria.add(Restrictions.ilike("employerEmailId", "%"+ employerEmailId +"%"));
		}
		if(employerPhoneNo!=null && !employerPhoneNo.trim().equals("")){
			criteria.add(Restrictions.ilike("employerPhoneNo", "%"+ employerPhoneNo +"%"));
		}
		if(employerCompanyName!=null && !employerCompanyName.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCompanyName", "%"+ employerCompanyName +"%"));
		}
		if(employerTitle!=null && !employerTitle.trim().equals("")){
			criteria.add(Restrictions.ilike("employerTitle", "%"+ employerTitle +"%"));
		}
		if(employerCity!=null && !employerCity.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCity", "%"+ employerCity +"%"));
		}
		if(employerState!=null && !employerState.trim().equals("")){
			criteria.add(Restrictions.ilike("employerState", "%"+ employerState +"%"));
		}
		if(employerCountry!=null && !employerCountry.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCountry", "%"+ employerCountry +"%"));
		}
		if(employerZipcode!=null && !employerZipcode.trim().equals("")){
			criteria.add(Restrictions.ilike("employerZipcode", "%"+ employerZipcode +"%"));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}
	
	public Integer getEmployerListCount(String employerName, String employerEmailId,
			String employerPhoneNo, String employerCompanyName, String employerTitle,
			String employerCity, String employerState, String employerCountry, String employerZipcode, Integer status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employer.class);
		if(employerName!=null && !employerName.trim().equals("")){
			Criterion c1 = Restrictions.ilike("employerFirstName", "%"+ employerName +"%");
			Criterion c2 = Restrictions.ilike("employerLastName", "%"+ employerName +"%");
			LogicalExpression logicOr=Restrictions.or(c1, c2);
			criteria.add(logicOr);
		}
		if(employerEmailId!=null && !employerEmailId.trim().equals("")){
			criteria.add(Restrictions.ilike("employerEmailId", "%"+ employerEmailId +"%"));
		}
		if(employerPhoneNo!=null && !employerPhoneNo.trim().equals("")){
			criteria.add(Restrictions.ilike("employerPhoneNo", "%"+ employerPhoneNo +"%"));
		}
		if(employerCompanyName!=null && !employerCompanyName.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCompanyName", "%"+ employerCompanyName +"%"));
		}
		if(employerTitle!=null && !employerTitle.trim().equals("")){
			criteria.add(Restrictions.ilike("employerTitle", "%"+ employerTitle +"%"));
		}
		if(employerCity!=null && !employerCity.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCity", "%"+ employerCity +"%"));
		}
		if(employerState!=null && !employerState.trim().equals("")){
			criteria.add(Restrictions.ilike("employerState", "%"+ employerState +"%"));
		}
		if(employerCountry!=null && !employerCountry.trim().equals("")){
			criteria.add(Restrictions.ilike("employerCountry", "%"+ employerCountry +"%"));
		}
		if(employerZipcode!=null && !employerZipcode.trim().equals("")){
			criteria.add(Restrictions.ilike("employerZipcode", "%"+ employerZipcode +"%"));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

}
