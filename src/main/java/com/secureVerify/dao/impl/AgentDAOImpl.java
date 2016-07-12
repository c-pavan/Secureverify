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

import com.secureVerify.dao.AgentDAO;
import com.secureVerify.model.Agent;

public class AgentDAOImpl extends HibernateDaoSupport implements AgentDAO {

	public void addAgent(Agent agent) {
		getHibernateTemplate().save(agent);
	}

	public void updateAgent(Agent agent) {
		getHibernateTemplate().update(agent);
	}

	public void updateAgent(Integer agentId, String verificationCode) {
		Agent agent = getAgentByAgentId(agentId);
		if(agent!=null){
			agent.setVerificationCode(verificationCode);
			getHibernateTemplate().update(agent);
		}
	}

	public void updateAgent(Integer agentId, String verificationCode, String password) {
		Agent agent = getAgentByAgentId(agentId);
		if(agent!=null){
			agent.setVerificationCode(verificationCode);
			agent.setAgentPassword(password);
			getHibernateTemplate().update(agent);
		}
	}

	public void deleteAgent(Agent agent) {
		getHibernateTemplate().delete(agent);
	}

	public void deleteAgentList(List<Agent> agentList) {
		getHibernateTemplate().deleteAll(agentList);
	}

	@SuppressWarnings("unchecked")
	public List<Agent> listAgent() {
		return getHibernateTemplate().find("from Agent a order by a.agentId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Agent> listActiveAgent() {
		return getHibernateTemplate().find("from Agent a where a.status = 1 order by a.agentId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Agent> searchAgent(Integer agentId, String agentFirstName,
			String agentLastName, String agentEmailId, String agentPhoneNo,
			String agentCity, String agentState, String agentCountry, String agentZipcode,
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Agent.class);
		if(agentId!=null){
			criteria.add(Restrictions.eq("agentId", agentId));
		}
		if(agentFirstName!=null && !agentFirstName.trim().equals("")){
			criteria.add(Restrictions.like("agentFirstName", "%"+ agentFirstName +"%"));
		}
		if(agentLastName!=null && !agentLastName.trim().equals("")){
			criteria.add(Restrictions.like("agentLastName", "%"+ agentLastName +"%"));
		}
		if(agentEmailId!=null && !agentEmailId.trim().equals("")){
			criteria.add(Restrictions.like("agentEmailId", "%"+ agentEmailId +"%"));
		}
		if(agentPhoneNo!=null && !agentPhoneNo.trim().equals("")){
			criteria.add(Restrictions.like("agentPhoneNo", "%"+ agentPhoneNo +"%"));
		}
		if(agentCity!=null && !agentCity.trim().equals("")){
			criteria.add(Restrictions.like("agentCity", "%"+ agentCity +"%"));
		}
		if(agentState!=null && !agentState.trim().equals("")){
			criteria.add(Restrictions.like("agentState", "%"+ agentState +"%"));
		}
		if(agentCountry!=null && !agentCountry.trim().equals("")){
			criteria.add(Restrictions.like("agentCountry", "%"+ agentCountry +"%"));
		}
		if(agentZipcode!=null && !agentZipcode.trim().equals("")){
			criteria.add(Restrictions.like("agentZipcode", "%"+ agentZipcode +"%"));
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
		criteria.addOrder(Order.desc("agentId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public Agent getAgentByAgentId(Integer agentId) {
		List<Agent> agentList = getHibernateTemplate().find("from Agent where agentId = ?", agentId);
		if(agentList!=null && !agentList.isEmpty()){ return agentList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Agent getAgent(String agentEmailId, String agentPassword) {
		Object[] values = {agentEmailId, agentPassword};
		List<Agent> agentList = getHibernateTemplate().find("from Agent where agentEmailId = ? and agentPassword = ?", values);
		if(agentList!=null && !agentList.isEmpty()){ return agentList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Agent getAgentByEmailId(String agentEmailId) {
		List<Agent> agentList = getHibernateTemplate().find("from Agent where agentEmailId = ?", agentEmailId);
		if(agentList!=null && !agentList.isEmpty()){ return agentList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<Agent> getAgentsByZipcode(String agentZipcode) {
		return getHibernateTemplate().find("from Agent where agentZipcode = ?", agentZipcode);
	}

	@SuppressWarnings("unchecked")
	public List<Agent> getAgentsByCity(String agentCity) {
		return getHibernateTemplate().find("from Agent where agentCity = ?", agentCity);
	}

	@SuppressWarnings("unchecked")
	public List<Agent> getAgentListByPage(final int startRecord, final int endRecord) {
		return (List<Agent>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Agent a order by a.agentId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<Agent> list = query.list();
				return list;
			}
		});
	}

	public Integer getAgentListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Agent"));
	}
	
	public Integer getAgentListCount(String agentEmailId, String agentPhoneNo, String agentCountry) {
		
		if(agentEmailId != null && !agentEmailId.equals("")) { agentEmailId = "%" + agentEmailId.toUpperCase()+ "%";   }
		if(agentPhoneNo != null && !agentPhoneNo.equals("")) { agentPhoneNo = "%" + agentPhoneNo.toUpperCase()+ "%";   }
		if(agentCountry != null && !agentCountry.equals("")) { agentCountry = "%" + agentCountry.toUpperCase()+ "%";   }
		
		if(agentEmailId != null && !agentEmailId.equals("") && agentPhoneNo != null && !agentPhoneNo.equals("") && 
				agentCountry != null && !agentCountry.equals("")){
					
			Object[] values = {agentEmailId, agentPhoneNo, agentCountry};
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Agent where upper(agentEmailId) like ? and upper(agentPhoneNo) like ? and upper(agentCountry) like ? " + values));
					
		} else if(agentEmailId != null && !agentEmailId.equals("")){
			
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Agent where upper(agentEmailId) like ?", agentEmailId));
		
		} else if(agentPhoneNo != null && !agentPhoneNo.equals("")){
			
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Agent where upper(agentPhoneNo) like ?", agentPhoneNo));
		
		} else if(agentCountry != null && !agentCountry.equals("")){
			
			return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Agent where upper(agentCountry) like ?", agentCountry));
		
		}
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Agent"));
	}
	

}
