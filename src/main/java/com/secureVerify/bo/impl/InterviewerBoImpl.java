package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.InterviewerBo;
import com.secureVerify.dao.InterviewerDAO;
import com.secureVerify.model.Interviewer;

public class InterviewerBoImpl implements InterviewerBo {
	
	InterviewerDAO interviewerDAO;
	
	//DI via Spring
	public void setInterviewerDAO(InterviewerDAO interviewerDAO){
		this.interviewerDAO = interviewerDAO;
	}

	public void addInterviewer(Interviewer interviewer) {
		interviewerDAO.addInterviewer(interviewer);
	}

	public void updateInterviewer(Interviewer interviewer) {
		interviewerDAO.updateInterviewer(interviewer);
	}

	public void updateInterviewer(Integer interviewerId, String verificationCode) {
		interviewerDAO.updateInterviewer(interviewerId, verificationCode);
	}

	public void updateInterviewer(Integer interviewerId, String verificationCode, String interviewerPassword) {
		interviewerDAO.updateInterviewer(interviewerId, verificationCode, interviewerPassword);
	}

	public void deleteInterviewer(Interviewer interviewer) {
		interviewerDAO.deleteInterviewer(interviewer);
	}

	public void deleteInterviewerList(List<Interviewer> interviewerList) {
		interviewerDAO.deleteInterviewerList(interviewerList);
	}
	
	public List<Interviewer> listInterviewer() {
		return interviewerDAO.listInterviewer();
	}

	public List<Interviewer> listActiveInterviewer() {
		return interviewerDAO.listActiveInterviewer();
	}

	public List<Interviewer> searchInterviewer(Integer interviewerId,
			String interviewerFirstName, String interviewerLastName,
			String interviewerEmailId, String interviewerPhoneNo,
			Integer interviewerSkillSet1, Integer interviewerSkillSet2,
			Integer interviewerSkillSet3, Integer createdBy,
			Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return interviewerDAO.searchInterviewer(interviewerId, interviewerFirstName, interviewerLastName, interviewerEmailId, 
				interviewerPhoneNo, interviewerSkillSet1, interviewerSkillSet2, interviewerSkillSet3, createdBy, lastModifiedBy, 
				fromDate, toDate, status, startRecord, endRecord);
	}

	public List<Interviewer> searchInterviewer(String interviewerName,
			String interviewerEmailId, String interviewerPhoneNo,
			Integer interviewerSkillSet, Integer status, Integer startRecord,
			Integer endRecord) {
		return interviewerDAO.searchInterviewer(interviewerName, interviewerEmailId, interviewerPhoneNo, interviewerSkillSet, 
				status, startRecord, endRecord);
	}

	public Interviewer getInterviewerByInterviewerId(Integer interviewerId) {
		return interviewerDAO.getInterviewerByInterviewerId(interviewerId);
	}

	public Interviewer getInterviewer(String interviewerEmailId, String interviewerPassword) {
		return interviewerDAO.getInterviewer(interviewerEmailId, interviewerPassword);
	}

	public Interviewer getInterviewerByEmailId(String interviewerEmailId) {
		return interviewerDAO.getInterviewerByEmailId(interviewerEmailId);
	}

	public List<Interviewer> getInterviewerListByPage(int startRecord, int endRecord) {
		return interviewerDAO.getInterviewerListByPage(startRecord, endRecord);
	}

	public Integer getInterviewerListCount() {
		return interviewerDAO.getInterviewerListCount();
	}

	public List<Interviewer> getInterviewerListBySkillSet( Integer interviewerSkillSet) {
		return interviewerDAO.getInterviewerListBySkillSet(interviewerSkillSet);
	}

	public Integer getInterviewerListCount(String interviewerName,
			String interviewerEmailId, String interviewerPhoneNo,
			Integer interviewerSkillSet, Integer status) {
		return interviewerDAO.getInterviewerListCount(interviewerName, interviewerEmailId, interviewerPhoneNo, interviewerSkillSet, status);
	}

}
