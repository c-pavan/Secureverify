package com.secureVerify.bo;

import java.util.List;

import com.secureVerify.model.User;

public interface UserBo {

	void addUser(User user);
	
	void updateUser(User user);
	
	void updateUser(Integer userId, String verificationCode);
	
	void updateUser(Integer userId, String verificationCode, String userPassword);
	
	void deleteUser(User user);
	
	void deleteUserList(List<User> userList);
	
	List<User> listUser();
	
	List<User> listActiveUser();
	
	List<User> getUsersByDesignation(int designation);
	
	List<User> searchUser(Integer userId, String userFirstName, String userLastName);
	
	User getUser(Integer userId);
	
	User getUser(String userEmailId, String userPassword);
	
	User getUser(String userEmailId);
	
	void updateUser(Integer userId, String userFirstName, String userLastName, String userPhoneNo);
	
}
