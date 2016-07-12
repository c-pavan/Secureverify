package com.secureVerify.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
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

import com.secureVerify.dao.CreditTypesDAO;
import com.secureVerify.model.CreditTypes;

public class CreditTypesDAOImpl extends HibernateDaoSupport implements CreditTypesDAO {

	public void addCreditTypes(CreditTypes creditTypes) {
		getHibernateTemplate().save(creditTypes);
	}

	public void updateCreditTypes(CreditTypes creditTypes) {
		getHibernateTemplate().update(creditTypes);
	}

	public void deleteCreditTypes(CreditTypes creditTypes) {
		getHibernateTemplate().delete(creditTypes);
	}

	public void deleteCreditTypesList(List<CreditTypes> creditTypesList) {
		getHibernateTemplate().deleteAll(creditTypesList);
	}

	@SuppressWarnings("unchecked")
	public List<CreditTypes> listCreditTypes() {
		return getHibernateTemplate().find("from CreditTypes");
	}

	@SuppressWarnings("unchecked")
	public List<CreditTypes> listActiveCreditTypes() {
		return getHibernateTemplate().find("from CreditTypes where status = 1");
	}

	@SuppressWarnings("unchecked")
	public List<CreditTypes> searchCreditTypes(Integer creditTypesId,
			Integer creditType, String description, BigDecimal amount,
			Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CreditTypes.class);
		if(creditTypesId!=null){
			criteria.add(Restrictions.eq("creditTypesId", creditTypesId));
		}
		if(creditType!=null && creditType!=0){
			criteria.add(Restrictions.eq("creditType", creditType));
		}
		if(description!=null && !description.equals("")){
			criteria.add(Restrictions.ilike("description", "%"+description+"%"));
		}
		if(amount!=null){
			criteria.add(Restrictions.eq("amount", amount));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		criteria.addOrder(Order.desc("creditTypesId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public CreditTypes getCreditTypesByCreditTypesId(Integer creditTypesId) {
		List<CreditTypes> creditTypesList = getHibernateTemplate().find("from CreditTypes where creditTypesId = ?", creditTypesId);
		if(creditTypesList!=null && !creditTypesList.isEmpty()){ return creditTypesList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public CreditTypes getCreditTypes(Integer creditType) {
		List<CreditTypes> creditTypesList = getHibernateTemplate().find("from CreditTypes where creditType = ?", creditType);
		if(creditTypesList!=null && !creditTypesList.isEmpty()){ return creditTypesList.get(0); }else{ return null; }
	}

	public Integer getCreditTypesListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CreditTypes"));
	}

	public Integer getCreditTypesActiveListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CreditTypes where status = 1"));
	}

	public Integer searchCreditTypes(Integer creditTypesId, Integer creditType,
			Integer description, BigDecimal amount, Integer status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CreditTypes.class);
		if(creditTypesId!=null){
			criteria.add(Restrictions.eq("creditTypesId", creditTypesId));
		}
		if(creditType!=null && creditType!=0){
			criteria.add(Restrictions.eq("creditType", creditType));
		}
		if(description!=null && !description.equals("")){
			criteria.add(Restrictions.ilike("description", "%"+description+"%"));
		}
		if(amount!=null){
			criteria.add(Restrictions.eq("amount", amount));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

	@SuppressWarnings("unchecked")
	public List<CreditTypes> getCreditTypesListByPage(final int startRecord, final int endRecord) {
		return (List<CreditTypes>) getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from CreditTypes ct order by ct.creditTypesId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<CreditTypes> list = query.list();
				return list;
			}
		});
	}

}
