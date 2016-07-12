package com.secureVerify.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.PropertieDAO;
import com.secureVerify.model.Propertie;

public class PropertieDAOImpl extends HibernateDaoSupport implements PropertieDAO {

	
	public void addPropertie(Propertie propertie) {
		getHibernateTemplate().save(propertie);
	}

	
	public void updatePropertie(Propertie propertie) {
		getHibernateTemplate().update(propertie);
	}

	
	public void deletePropertie(Propertie propertie) {
		getHibernateTemplate().delete(propertie);
	}

	
	public void deletePropertieList(List<Propertie> propertieList) {
		getHibernateTemplate().deleteAll(propertieList);
	}

	
	@SuppressWarnings("unchecked")
	public List<Propertie> listPropertie() {
		return getHibernateTemplate().find("from Propertie");
	}

	@SuppressWarnings("unchecked")
	public Propertie getPropertie() {
		List<Propertie> properties = getHibernateTemplate().find("from Propertie");
		if(properties!=null && !properties.isEmpty()){
			return properties.get(0);
		}
		return null;
	}

}
