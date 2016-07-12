package com.secureVerify.bo.impl;

import java.util.List;

import com.secureVerify.bo.UserBo;
import com.secureVerify.dao.UserDAO;
import com.secureVerify.model.User;

public class UserBoImpl implements UserBo {

	UserDAO userDAO;
	
	//DI via Spring
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}

	public void addUser(User user) {
		userDAO.addUser(user);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	public void deleteUserList(List<User> userList) {
		userDAO.deleteUserList(userList);
	}

	public List<User> listUser() {
		return userDAO.listUser();
	}

	public List<User> listActiveUser() {
		return userDAO.listActiveUser();
	}

	public List<User> getUsersByDesignation(int designation) {
		return userDAO.getUsersByDesignation(designation);
	}

	public List<User> searchUser(Integer userId, String userFirstName, String userLastName) {
		return userDAO.searchUser(userId, userFirstName, userLastName);
	}

	public User getUser(Integer userId) {
		return userDAO.getUser(userId);
	}

	public User getUser(String userEmailId, String userPassword) {
		return userDAO.getUser(userEmailId, userPassword);
	}
	
	public User getUser(String userEmailId){
		return userDAO.getUser(userEmailId);
	}
	
	public void updateUser(Integer userId, String userFirstName, String userLastName, String userPhoneNo){
		userDAO.updateUser(userId, userFirstName, userLastName, userPhoneNo);
	}
	
	public void updateUser(Integer userId, String verificationCode){
		userDAO.updateUser(userId, verificationCode);
	}

	public void updateUser(Integer userId, String verificationCode, String userPassword){
		userDAO.updateUser(userId, verificationCode, userPassword);
	}
	
}
