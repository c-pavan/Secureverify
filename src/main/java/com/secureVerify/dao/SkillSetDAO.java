package com.secureVerify.dao;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.SkillSet;

public interface SkillSetDAO {

	void addSkillSet(SkillSet skillSet);
	
	void updateSkillSet(SkillSet skillSet);
	
	void deleteSkillSet(SkillSet skillSet);
	
	void deleteSkillSetList(List<SkillSet> skillSetList);
	
	List<SkillSet> listSkillSet();
	
	List<SkillSet> listActiveSkillSet();
	
	List<SkillSet> searchSkillSet(Integer skillSetId, String primarySkillSet, String skillSetCategory, 
			Integer createdBy, Integer lastModifiedBy, Date creationDate, Date fromDate, Date toDate, 
			Integer status, Integer startRecord, Integer endRecord);
	
	SkillSet getSkillSetBySkillSetId(Integer skillSetId);
	
	SkillSet getSkillSet(String primarySkillSet);
	
	List<SkillSet> getSkillSetsBySkillSetCategory(String skillSetCategory);
	
	List<SkillSet> getSkillSetListByPage(final int startRecord, final int endRecord);
	
	Integer getSkillSetListCount();
	
	Integer getSkillSetListCount(String primarySkillSet, String skillSetCategory);
	
}
