package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.EmployerBo;
import com.secureVerify.dao.EmployerDAO;
import com.secureVerify.model.Employer;

public class EmployerBoImpl implements EmployerBo {

	EmployerDAO employerDAO;
	
	//DI via Spring
	public void setEmployerDAO(EmployerDAO employerDAO){
		this.employerDAO = employerDAO;
	}
	
	public void addEmployer(Employer employer) {
		employerDAO.addEmployer(employer);
	}

	public void updateEmployer(Employer employer) {
		employerDAO.updateEmployer(employer);
	}

	public void updateEmployer(Integer employerId, String verificationCode) {
		employerDAO.updateEmployer(employerId, verificationCode);
	}

	public void updateEmployer(Integer employerId, String verificationCode, String employerPassword) {
		employerDAO.updateEmployer(employerId, verificationCode, employerPassword);
	}

	public void deleteEmployer(Employer employer) {
		employerDAO.deleteEmployer(employer);
	}

	public void deleteEmployerList(List<Employer> employerList) {
		employerDAO.deleteEmployerList(employerList);
	}

	public List<Employer> listEmployer() {
		return employerDAO.listEmployer();
	}

	public List<Employer> listActiveEmployer() {
		return employerDAO.listActiveEmployer();
	}

	public List<Employer> searchEmployer(Integer employerId,
			String employerFirstName, String employerLastName,
			String employerEmailId, String employerPhoneNo,
			String employerCompanyName, String employerTitle,
			String employerCity, String employerState, String employerCountry,
			String employerZipcode, Date creationDate, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return employerDAO.searchEmployer(employerId, employerFirstName, employerLastName, employerEmailId, employerPhoneNo, 
				employerCompanyName, employerTitle, employerCity, employerState, employerCountry, employerZipcode, creationDate, 
				fromDate, toDate, status, startRecord, endRecord);
	}
	
	public List<Employer> searchEmployer(String employerName, String employerEmailId, String employerPhoneNo,
			String employerCompanyName, String employerTitle, String employerCity, String employerState,
			String employerCountry,	String employerZipcode, Date creationDate, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord){
		return employerDAO.searchEmployer(employerName, employerEmailId, employerPhoneNo, employerCompanyName, employerTitle, employerCity,
				employerState, employerCountry, employerZipcode, creationDate, fromDate, toDate, status, startRecord, endRecord);
	}

	@Override
	public Employer getEmployerByEmployerId(Integer employerId) {
		return employerDAO.getEmployerByEmployerId(employerId);
	}

	public Employer getEmployer(String employerEmailId, String employerPassword) {
		return employerDAO.getEmployer(employerEmailId, employerPassword);
	}

	public Employer getEmployerByEmailId(String employerEmailId) {
		return employerDAO.getEmployerByEmailId(employerEmailId);
	}

	public List<Employer> getEmployersByZipcode(String employerZipcode) {
		return employerDAO.getEmployersByZipcode(employerZipcode);
	}

	public List<Employer> getEmployersByCity(String employerCity) {
		return employerDAO.getEmployersByCity(employerCity);
	}

	public List<Employer> getEmployerListByPage(int startRecord, int endRecord) {
		return employerDAO.getEmployerListByPage(startRecord, endRecord);
	}

	public Integer getEmployerListCount() {
		return employerDAO.getEmployerListCount();
	}

	public Employer getActiveEmployer(String employerEmailId, String employerPassword) {
		return employerDAO.getActiveEmployer(employerEmailId, employerPassword);
	}

	public Integer getEmployerListCount(String employerFirstName,
			String employerLastName, String employerEmailId,
			String employerPhoneNo, String employerCompanyName,
			String employerTitle, String employerCity, String employerState,
			String employerCountry, String employerZipcode, Integer status) {
		return employerDAO.getEmployerListCount(employerFirstName, employerLastName, employerEmailId, employerPhoneNo, 
				employerCompanyName, employerTitle, employerCity, employerState, employerCountry, employerZipcode, status);
	}
	
	public Integer getEmployerListCount(String employerName, String employerEmailId,
			String employerPhoneNo, String employerCompanyName, String employerTitle,
			String employerCity, String employerState, String employerCountry, String employerZipcode, Integer status){
		return employerDAO.getEmployerListCount(employerName, employerEmailId, employerPhoneNo, employerCompanyName, employerTitle,
				employerCity, employerState, employerCountry, employerZipcode, status);
	}

}
