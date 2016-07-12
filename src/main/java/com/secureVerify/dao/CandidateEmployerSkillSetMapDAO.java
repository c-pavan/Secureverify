package com.secureVerify.dao;

import java.util.List;

import com.secureVerify.model.CandidateEmployerSkillSetMap;

public interface CandidateEmployerSkillSetMapDAO {

	void addCandidateEmployerSkillSetMap(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap);
	
	void updateCandidateEmployerSkillSetMap(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap);
	
	void deleteCandidateEmployerSkillSetMap(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap);
	
	void deleteCandidateEmployerSkillSetMapList(List<CandidateEmployerSkillSetMap> candidateEmployerSkillSetMapList);
	
	List<CandidateEmployerSkillSetMap> listCandidateEmployerSkillSetMap();
	
	List<CandidateEmployerSkillSetMap> searchCandidateEmployerSkillSetMap(Integer candidateEmployerSkillSetMapId, Integer candidateId, Integer employerId, 
			Integer skillSetId, Integer isScheduled, Integer startRecord, Integer endRecord);
	
	CandidateEmployerSkillSetMap getCandidateEmployerSkillSetMap(Integer candidateEmployerSkillSetMapId);
	
	CandidateEmployerSkillSetMap getCandidateEmployerSkillSetMap(Integer candidateId, Integer employerId, Integer skillSetId);
	
	List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapByCandidateId(Integer candidateId);
	
	List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapByEmployerId(Integer employerId);
	
	List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapBySkillSetId(Integer skillSetId);
	
	List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapByIsScheduled(Integer isScheduled);
	
	List<Integer> getEmployerIdsListByCandidateIdIsScheduled(Integer candidateId, Integer isScheduled);
	
	Integer getCandidateEmployerSkillSetMapListCount();
	
	Integer getCandidateEmployerSkillSetMapByCandidateIdListCount(Integer candidateId);
	
	Integer getCandidateEmployerSkillSetMapByEmployerIdListCount(Integer employerId);
	
	Integer getCandidateEmployerSkillSetMapBySkillSetIdListCount(Integer skillSetId);
	
	Integer getCandidateEmployerSkillSetMapByIsScheduledListCount(Integer isScheduled);
	
	Integer getCandidateEmployerSkillSetMapByCandidateIdEmployerIdSkillSetIdIsScheduledListCount(Integer candidateId, Integer employerId, Integer skillSetId, Integer isScheduled);
	
}
