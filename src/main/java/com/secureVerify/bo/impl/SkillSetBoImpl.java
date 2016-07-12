package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.SkillSetBo;
import com.secureVerify.dao.SkillSetDAO;
import com.secureVerify.model.SkillSet;

public class SkillSetBoImpl implements SkillSetBo {
	
	SkillSetDAO skillSetDAO;
	
	//DI via Spring
	public void setSkillSetDAO(SkillSetDAO skillSetDAO){
		this.skillSetDAO = skillSetDAO;
	}

	public void addSkillSet(SkillSet skillSet) {
		skillSetDAO.addSkillSet(skillSet);
	}

	public void updateSkillSet(SkillSet skillSet) {
		skillSetDAO.updateSkillSet(skillSet);
	}

	public void deleteSkillSet(SkillSet skillSet) {
		skillSetDAO.deleteSkillSet(skillSet);
	}

	public void deleteSkillSetList(List<SkillSet> skillSetList) {
		skillSetDAO.deleteSkillSetList(skillSetList);
	}

	public List<SkillSet> listSkillSet() {
		return skillSetDAO.listSkillSet();
	}

	public List<SkillSet> listActiveSkillSet() {
		return skillSetDAO.listActiveSkillSet();
	}

	public List<SkillSet> searchSkillSet(Integer skillSetId,
			String primarySkillSet, String skillSetCategory, Integer createdBy,
			Integer lastModifiedBy, Date creationDate, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return skillSetDAO.searchSkillSet(skillSetId, primarySkillSet, skillSetCategory, createdBy, lastModifiedBy, creationDate, 
				fromDate, toDate, status, startRecord, endRecord);
	}

	public SkillSet getSkillSetBySkillSetId(Integer skillSetId) {
		return skillSetDAO.getSkillSetBySkillSetId(skillSetId);
	}

	public SkillSet getSkillSet(String primarySkillSet) {
		return skillSetDAO.getSkillSet(primarySkillSet);
	}

	public List<SkillSet> getSkillSetsBySkillSetCategory(String skillSetCategory) {
		return skillSetDAO.getSkillSetsBySkillSetCategory(skillSetCategory);
	}

	public List<SkillSet> getSkillSetListByPage(int startRecord, int endRecord) {
		return skillSetDAO.getSkillSetListByPage(startRecord, endRecord);
	}

	public Integer getSkillSetListCount() {
		return skillSetDAO.getSkillSetListCount();
	}

	public Integer getSkillSetListCount(String primarySkillSet, String skillSetCategory) {
		return skillSetDAO.getSkillSetListCount(primarySkillSet, skillSetCategory);
	}

}
