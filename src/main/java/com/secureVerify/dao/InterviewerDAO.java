package com.secureVerify.dao;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.Interviewer;

public interface InterviewerDAO {

	void addInterviewer(Interviewer interviewer);
	
	void updateInterviewer(Interviewer interviewer);
	
	void updateInterviewer(Integer interviewerId, String verificationCode);
	
	void updateInterviewer(Integer interviewerId, String verificationCode, String interviewerPassword);
	
	void deleteInterviewer(Interviewer interviewer);
	
	void deleteInterviewerList(List<Interviewer> interviewerList);
	
	List<Interviewer> listInterviewer();
	
	List<Interviewer> listActiveInterviewer();
	
	List<Interviewer> searchInterviewer(Integer interviewerId, String interviewerFirstName, String interviewerLastName, 
			String interviewerEmailId, String interviewerPhoneNo, Integer interviewerSkillSet1, Integer interviewerSkillSet2, 
			Integer interviewerSkillSet3, Integer createdBy, Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, 
			Integer startRecord, Integer endRecord);

	List<Interviewer> searchInterviewer(String interviewerName, String interviewerEmailId, String interviewerPhoneNo, 
			Integer interviewerSkillSet, Integer status, Integer startRecord, Integer endRecord);
	
	Interviewer getInterviewerByInterviewerId(Integer interviewerId);
	
	Interviewer getInterviewer(String interviewerEmailId, String interviewerPassword);
	
	Interviewer getInterviewerByEmailId(String interviewerEmailId);
	
	List<Interviewer> getInterviewerListByPage(final int startRecord, final int endRecord);
	
	List<Interviewer> getInterviewerListBySkillSet(Integer interviewerSkillSet);
	
	Integer getInterviewerListCount();

	Integer getInterviewerListCount(String interviewerName, String interviewerEmailId, String interviewerPhoneNo, 
			Integer interviewerSkillSet, Integer status);
	
}
