package com.secureVerify.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.UserDAO;
import com.secureVerify.model.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	public void updateUser(User user) {
		getHibernateTemplate().update(user);
	}

	public void deleteUser(User user) {
		getHibernateTemplate().delete(user);
	}

	public void deleteUserList(List<User> userList) {
		getHibernateTemplate().deleteAll(userList);
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		return getHibernateTemplate().find("from User");
	}

	@SuppressWarnings("unchecked")
	public List<User> listActiveUser() {
		return getHibernateTemplate().find("from User where status = 1");
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsersByDesignation(int designation) {
		return getHibernateTemplate().find("from User where designation = ?", designation);
	}

	@SuppressWarnings("unchecked")
	public List<User> searchUser(Integer userId, String userFirstName, String userLastName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		if(userId!=null){
			criteria.add(Restrictions.eq("userId", userId));
		}
		if(userFirstName!=null && !userFirstName.trim().equals("")){
			criteria.add(Restrictions.like("userFirstName", "%"+ userFirstName +"%"));
		}
		if(userLastName!=null && !userLastName.trim().equals("")){
			criteria.add(Restrictions.like("userLastName", "%"+ userLastName +"%"));
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public User getUser(Integer userId) {
		List<User> userList = getHibernateTemplate().find("from User where userId = ?", userId);
		if(userList!=null && !userList.isEmpty()){ return userList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public User getUser(String userEmailId, String userPassword) {
		Object[] values = { userEmailId, userPassword };
		List<User> userList = getHibernateTemplate().find("from User where userEmailId = ? and userPassword = ?", values);
		if(userList!=null && !userList.isEmpty()){ return userList.get(0); }else{ return null; }
	}
	
	@SuppressWarnings("unchecked")
	public User getUser(String userEmailId) {
		List<User> userList = getHibernateTemplate().find("from User where userEmailId = ?", userEmailId);
		if(userList!=null && !userList.isEmpty()){ return userList.get(0); }else{ return null; }
	}
	
	public void updateUser(Integer userId, String userFirstName, String userLastName, String userPhoneNo){
		User user = getUser(userId);
		user.setUserFirstName(userFirstName);
		user.setUserLastName(userLastName);
		user.setUserPhoneNo(userPhoneNo);
		getHibernateTemplate().update(user);
	}
	
	public void updateUser(Integer userId, String verificationCode){
		User user = getUser(userId);
		user.setVerificationCode(verificationCode);
		getHibernateTemplate().update(user);
	}
	
	public void updateUser(Integer userId, String verificationCode, String userPassword){
		User user = getUser(userId);
		user.setVerificationCode(verificationCode);
		user.setUserPassword(userPassword);
		getHibernateTemplate().update(user);
	}

}
