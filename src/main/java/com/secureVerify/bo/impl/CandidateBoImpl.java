package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.CandidateBo;
import com.secureVerify.dao.CandidateDAO;
import com.secureVerify.model.Candidate;

public class CandidateBoImpl implements CandidateBo {

	CandidateDAO candidateDAO;
	
	//DI via Spring
	public void setCandidateDAO(CandidateDAO candidateDAO){
		this.candidateDAO = candidateDAO;
	}
	
	public void addCandidate(Candidate candidate) {
		candidateDAO.addCandidate(candidate);
	}

	public void updateCandidate(Candidate candidate) {
		candidateDAO.updateCandidate(candidate);
	}

	public void updateCandidate(Integer candidateId, String verificationCode) {
		candidateDAO.updateCandidate(candidateId, verificationCode);
	}

	public void updateCandidate(Integer candidateId, String verificationCode, String password) {
		candidateDAO.updateCandidate(candidateId, verificationCode, password);
	}

	public void deleteCandidate(Candidate candidate) {
		candidateDAO.deleteCandidate(candidate);
	}

	public void deleteCandidateList(List<Candidate> candidateList) {
		candidateDAO.deleteCandidateList(candidateList);
	}

	public List<Candidate> listCandidate() {
		return candidateDAO.listCandidate();
	}

	public List<Candidate> listActiveCandidate() {
		return candidateDAO.listActiveCandidate();
	}

	public List<Candidate> searchCandidate(Integer candidateId, 
			String candidateFirstName, String candidateLastName,
			String candidateEmailId, String candidatePhoneNo,
			String candidateCity, String candidateState,
			String candidateCountry, String candidateZipcode, Integer skillsetId,
			String candidatePrefferedLocation, String candidateExpectedSalary,
			Date creationDate, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return candidateDAO.searchCandidate(candidateId, candidateFirstName, candidateLastName, candidateEmailId, candidatePhoneNo, 
				candidateCity, candidateState, candidateCountry, candidateZipcode, skillsetId, candidatePrefferedLocation, candidateExpectedSalary, 
				creationDate, fromDate, toDate, status, startRecord, endRecord);
	}

	public Candidate getCandidateByCandidateId(Integer candidateId) {
		return candidateDAO.getCandidateByCandidateId(candidateId);
	}

	public Candidate getCandidate(String candidateEmailId, String candidatePassword) {
		return candidateDAO.getCandidate(candidateEmailId, candidatePassword);
	}

	public Candidate getCandidateByEmailId(String candidateEmailId) {
		return candidateDAO.getCandidateByEmailId(candidateEmailId);
	}

	public List<Candidate> getCandidatesByZipcode(String candidateZipcode) {
		return candidateDAO.getCandidatesByZipcode(candidateZipcode);
	}

	public List<Candidate> getCandidatesByCity(String candidateCity) {
		return candidateDAO.getCandidatesByCity(candidateCity);
	}

	public List<Candidate> getCandidateListByPage(int startRecord, int endRecord) {
		return candidateDAO.getCandidateListByPage(startRecord, endRecord);
	}

	public Integer getCandidateListCount() {
		return candidateDAO.getCandidateListCount();
	}

	public List<Candidate> getCandidatesBySkillSet(Integer skillsetId) {
		return candidateDAO.getCandidatesBySkillSet(skillsetId);
	}

	public Integer getCandidateListCountBySkillSet(Integer skillsetId) {
		return candidateDAO.getCandidateListCountBySkillSet(skillsetId);
	}

}
