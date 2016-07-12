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

import com.secureVerify.dao.SkillSetDAO;
import com.secureVerify.model.SkillSet;

public class SkillSetDAOImpl extends HibernateDaoSupport implements SkillSetDAO {

	public void addSkillSet(SkillSet skillSet) {
		getHibernateTemplate().save(skillSet);
	}

	public void updateSkillSet(SkillSet skillSet) {
		getHibernateTemplate().update(skillSet);
	}

	public void deleteSkillSet(SkillSet skillSet) {
		getHibernateTemplate().delete(skillSet);
	}

	public void deleteSkillSetList(List<SkillSet> skillSetList) {
		getHibernateTemplate().deleteAll(skillSetList);
	}

	@SuppressWarnings("unchecked")
	public List<SkillSet> listSkillSet() {
		return getHibernateTemplate().find("from SkillSet ss order by ss.skillSetId desc");
	}

	@SuppressWarnings("unchecked")
	public List<SkillSet> listActiveSkillSet() {
		return getHibernateTemplate().find("from SkillSet ss where ss.status = 1 order by ss.skillSetId desc");
	}

	@SuppressWarnings("unchecked")
	public List<SkillSet> searchSkillSet(Integer skillSetId,
			String primarySkillSet, String skillSetCategory, Integer createdBy,
			Integer lastModifiedBy, Date creationDate, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SkillSet.class);
		if(skillSetId!=null){
			criteria.add(Restrictions.eq("skillSetId", skillSetId));
		}
		if(primarySkillSet!=null && !primarySkillSet.trim().equals("")){
			criteria.add(Restrictions.ilike("primarySkillSet", "%"+ primarySkillSet +"%"));
		}
		if(skillSetCategory!=null && !skillSetCategory.trim().equals("")){
			criteria.add(Restrictions.ilike("skillSetCategory", "%"+ skillSetCategory +"%"));
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
		}criteria.addOrder(Order.desc("skillSetId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public SkillSet getSkillSetBySkillSetId(Integer skillSetId) {
		List<SkillSet> skillSetList = getHibernateTemplate().find("from SkillSet where skillSetId = ?", skillSetId);
		if(skillSetList!=null && !skillSetList.isEmpty()){ return skillSetList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public SkillSet getSkillSet(String primarySkillSet) {
		List<SkillSet> skillSetList = getHibernateTemplate().find("from SkillSet where primarySkillSet = ?", primarySkillSet);
		if(skillSetList!=null && !skillSetList.isEmpty()){ return skillSetList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<SkillSet> getSkillSetsBySkillSetCategory(String skillSetCategory) {
		return getHibernateTemplate().find("from SkillSet where skillSetCategory = ?", skillSetCategory);
	}

	@SuppressWarnings("unchecked")
	public List<SkillSet> getSkillSetListByPage(final int startRecord, final int endRecord) {
		return (List<SkillSet>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from SkillSet ss order by ss.skillSetId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<SkillSet> list = query.list();
				return list;
			}
		});
	}

	public Integer getSkillSetListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from SkillSet"));
	}

	public Integer getSkillSetListCount(String primarySkillSet, String skillSetCategory) {
		
		if(primarySkillSet!=null && !primarySkillSet.equals("")){ primarySkillSet = "%"+primarySkillSet.toUpperCase()+"%"; }
		if(skillSetCategory!=null && !skillSetCategory.equals("")){ skillSetCategory = "%"+skillSetCategory.toUpperCase()+"%"; }
		
		if(primarySkillSet!=null && !primarySkillSet.equals("") && skillSetCategory!=null && !skillSetCategory.equals("")){
			Object[] values = {primarySkillSet, skillSetCategory};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from SkillSet where upper(primarySkillSet) like ? and upper(skillSetCategory) like ?", values));
		}else if(primarySkillSet!=null && !primarySkillSet.equals("")){
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from SkillSet where upper(primarySkillSet) like ?", primarySkillSet));
		}else if(skillSetCategory!=null && !skillSetCategory.equals("")){
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from SkillSet where upper(skillSetCategory) like ?", skillSetCategory));
		}else{
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from SkillSet"));
		}
	}

}
