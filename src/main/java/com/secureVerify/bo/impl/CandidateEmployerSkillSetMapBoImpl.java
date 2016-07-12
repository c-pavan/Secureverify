package com.secureVerify.bo.impl;

import java.util.List;

import com.secureVerify.bo.CandidateEmployerSkillSetMapBo;
import com.secureVerify.dao.CandidateEmployerSkillSetMapDAO;
import com.secureVerify.model.CandidateEmployerSkillSetMap;

public class CandidateEmployerSkillSetMapBoImpl implements CandidateEmployerSkillSetMapBo {

	CandidateEmployerSkillSetMapDAO candidateEmployerSkillSetMapDAO;
	
	//DI via Spring
	public void setCandidateEmployerSkillSetMapDAO(CandidateEmployerSkillSetMapDAO candidateEmployerSkillSetMapDAO){
		this.candidateEmployerSkillSetMapDAO = candidateEmployerSkillSetMapDAO;
	}
	
	public void addCandidateEmployerSkillSetMap(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap) {
		candidateEmployerSkillSetMapDAO.addCandidateEmployerSkillSetMap(candidateEmployerSkillSetMap);
	}

	public void updateCandidateEmployerSkillSetMap(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap) {
		candidateEmployerSkillSetMapDAO.updateCandidateEmployerSkillSetMap(candidateEmployerSkillSetMap);
	}

	public void deleteCandidateEmployerSkillSetMap(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap) {
		candidateEmployerSkillSetMapDAO.deleteCandidateEmployerSkillSetMap(candidateEmployerSkillSetMap);
	}

	public void deleteCandidateEmployerSkillSetMapList(List<CandidateEmployerSkillSetMap> candidateEmployerSkillSetMapList) {
		candidateEmployerSkillSetMapDAO.deleteCandidateEmployerSkillSetMapList(candidateEmployerSkillSetMapList);
	}

	public List<CandidateEmployerSkillSetMap> listCandidateEmployerSkillSetMap() {
		return candidateEmployerSkillSetMapDAO.listCandidateEmployerSkillSetMap();
	}

	public List<CandidateEmployerSkillSetMap> searchCandidateEmployerSkillSetMap(
			Integer candidateEmployerSkillSetMapId, Integer candidateId,
			Integer employerId, Integer skillSetId, Integer isScheduled,
			Integer startRecord, Integer endRecord) {
		return candidateEmployerSkillSetMapDAO.searchCandidateEmployerSkillSetMap(candidateEmployerSkillSetMapId, candidateId, employerId, 
				skillSetId, isScheduled, startRecord, endRecord);
	}

	public CandidateEmployerSkillSetMap getCandidateEmployerSkillSetMap(Integer candidateEmployerSkillSetMapId) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMap(candidateEmployerSkillSetMapId);
	}

	public CandidateEmployerSkillSetMap getCandidateEmployerSkillSetMap(Integer candidateId, Integer employerId, Integer skillSetId) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMap(candidateId, employerId, skillSetId);
	}

	public List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapByCandidateId(Integer candidateId) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapByCandidateId(candidateId);
	}

	public List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapByEmployerId(Integer employerId) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapByEmployerId(employerId);
	}

	public List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapBySkillSetId(Integer skillSetId) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapBySkillSetId(skillSetId);
	}

	public List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapByIsScheduled(Integer isScheduled) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapByIsScheduled(isScheduled);
	}

	public Integer getCandidateEmployerSkillSetMapListCount() {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapListCount();
	}

	public Integer getCandidateEmployerSkillSetMapByCandidateIdListCount(Integer candidateId) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapByCandidateIdListCount(candidateId);
	}

	public Integer getCandidateEmployerSkillSetMapByEmployerIdListCount(Integer employerId) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapByEmployerIdListCount(employerId);
	}

	public Integer getCandidateEmployerSkillSetMapBySkillSetIdListCount(Integer skillSetId) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapBySkillSetIdListCount(skillSetId);
	}

	public Integer getCandidateEmployerSkillSetMapByIsScheduledListCount(Integer isScheduled) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapByIsScheduledListCount(isScheduled);
	}

	public Integer getCandidateEmployerSkillSetMapByCandidateIdEmployerIdSkillSetIdIsScheduledListCount(
			Integer candidateId, Integer employerId, Integer skillSetId,
			Integer isScheduled) {
		return candidateEmployerSkillSetMapDAO.getCandidateEmployerSkillSetMapByCandidateIdEmployerIdSkillSetIdIsScheduledListCount(candidateId, employerId, skillSetId, isScheduled);
	}

	public List<Integer> getEmployerIdsListByCandidateIdIsScheduled(Integer candidateId, Integer isScheduled) {
		return candidateEmployerSkillSetMapDAO.getEmployerIdsListByCandidateIdIsScheduled(candidateId, isScheduled);
	}

}
