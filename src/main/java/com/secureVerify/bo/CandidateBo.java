package com.secureVerify.bo;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.Candidate;

public interface CandidateBo {

	void addCandidate(Candidate candidate);
	
	void updateCandidate(Candidate candidate);
	
	void updateCandidate(Integer candidateId, String verificationCode);
	
	void updateCandidate(Integer candidateId, String verificationCode, String password);
	
	void deleteCandidate(Candidate candidate);
	
	void deleteCandidateList(List<Candidate> candidateList);
	
	List<Candidate> listCandidate();
	
	List<Candidate> listActiveCandidate();
	
	List<Candidate> searchCandidate(Integer candidateId, String candidateFirstName, String candidateLastName, String candidateEmailId, String candidatePhoneNo, 
			String candidateCity, String candidateState, String candidateCountry, String candidateZipcode, Integer skillsetId, String candidatePrefferedLocation, String candidateExpectedSalary, 
			Date creationDate, Date fromDate, Date toDate, Integer status, Integer startRecord, Integer endRecord);
	
	Candidate getCandidateByCandidateId(Integer candidateId);
	
	List<Candidate> getCandidatesBySkillSet(Integer skillsetId);
	
	Candidate getCandidate(String candidateEmailId, String candidatePassword);
	
	Candidate getCandidateByEmailId(String candidateEmailId);
	
	List<Candidate> getCandidatesByZipcode(String candidateZipcode);
	
	List<Candidate> getCandidatesByCity(String candidateCity);
	
	List<Candidate> getCandidateListByPage(final int startRecord, final int endRecord);
	
	Integer getCandidateListCount();
	
	Integer getCandidateListCountBySkillSet(Integer skillsetId);
	
}
