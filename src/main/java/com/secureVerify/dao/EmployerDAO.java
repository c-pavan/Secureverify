package com.secureVerify.dao;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.Employer;

public interface EmployerDAO {

	void addEmployer(Employer employer);
	
	void updateEmployer(Employer employer);
	
	void updateEmployer(Integer employerId, String verificationCode);
	
	void updateEmployer(Integer employerId, String verificationCode, String employerPassword);
	
	void deleteEmployer(Employer employer);
	
	void deleteEmployerList(List<Employer> employerList);
	
	List<Employer> listEmployer();
	
	List<Employer> listActiveEmployer();
	
	List<Employer> searchEmployer(Integer employerId, String employerFirstName, String employerLastName, String employerEmailId, 
			String employerPhoneNo, String employerCompanyName, String employerTitle, String employerCity, String employerState, 
			String employerCountry, String employerZipcode, Date creationDate, Date fromDate, Date toDate, Integer status, 
			Integer startRecord, Integer endRecord);
	
	List<Employer> searchEmployer(String employerName, String employerEmailId, String employerPhoneNo,
			String employerCompanyName, String employerTitle, String employerCity, String employerState,
			String employerCountry,	String employerZipcode, Date creationDate, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord);
	
	Employer getEmployerByEmployerId(Integer employerId);
	
	Employer getEmployer(String employerEmailId, String employerPassword);
	
	Employer getActiveEmployer(String employerEmailId, String employerPassword);
	
	Employer getEmployerByEmailId(String employerEmailId);
	
	List<Employer> getEmployersByZipcode(String employerZipcode);
	
	List<Employer> getEmployersByCity(String employerCity);
	
	List<Employer> getEmployerListByPage(final int startRecord, final int endRecord);
	
	Integer getEmployerListCount();

	Integer getEmployerListCount(String employerFirstName, String employerLastName, String employerEmailId, 
			String employerPhoneNo, String employerCompanyName, String employerTitle, String employerCity, String employerState, 
			String employerCountry, String employerZipcode, Integer status);
	
	Integer getEmployerListCount(String employerName, String employerEmailId,
			String employerPhoneNo, String employerCompanyName, String employerTitle,
			String employerCity, String employerState, String employerCountry, String employerZipcode, Integer status);
}
