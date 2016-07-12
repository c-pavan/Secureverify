package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.CandidateScheduleTimingBo;
import com.secureVerify.dao.CandidateScheduleTimingDAO;
import com.secureVerify.model.CandidateScheduleTiming;

public class CandidateScheduleTimingBoImpl implements CandidateScheduleTimingBo {
	
	CandidateScheduleTimingDAO candidateScheduleTimingDAO;
	
	//DI via Spring
	public void setCandidateScheduleTimingDAO(CandidateScheduleTimingDAO candidateScheduleTimingDAO){
		this.candidateScheduleTimingDAO = candidateScheduleTimingDAO;
	}

	public void addCandidateScheduleTiming(CandidateScheduleTiming candidateScheduleTiming) {
		candidateScheduleTimingDAO.addCandidateScheduleTiming(candidateScheduleTiming);
	}

	public void updateCandidateScheduleTiming(CandidateScheduleTiming candidateScheduleTiming) {
		candidateScheduleTimingDAO.updateCandidateScheduleTiming(candidateScheduleTiming);
	}

	public void deleteCandidateScheduleTiming(CandidateScheduleTiming candidateScheduleTiming) {
		candidateScheduleTimingDAO.deleteCandidateScheduleTiming(candidateScheduleTiming);
	}

	public void deleteCandidateScheduleTimingList(List<CandidateScheduleTiming> candidateScheduleTimingList) {
		candidateScheduleTimingDAO.deleteCandidateScheduleTimingList(candidateScheduleTimingList);
	}

	public List<CandidateScheduleTiming> listCandidateScheduleTiming() {
		return candidateScheduleTimingDAO.listCandidateScheduleTiming();
	}

	public List<CandidateScheduleTiming> listActiveCandidateScheduleTiming() {
		return candidateScheduleTimingDAO.listActiveCandidateScheduleTiming();
	}

	public List<CandidateScheduleTiming> searchCandidateScheduleTiming(
			Integer candidateScheduleTimingId, Integer candidateId,
			Integer locationId, Integer interviewerId,
			Integer locationScheduleTimingId, Integer skillSetId, Integer interviewerSkillSet1, 
			Integer interviewerSkillSet2, Integer interviewerSkillSet3, Date candidateScheduleFromTime,
			Date candidateScheduleToTime, String candidateFeedback,
			Integer candidatePerformance, Integer interviewStatus, String candidateUniqueId, Integer employerId, 
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return candidateScheduleTimingDAO.searchCandidateScheduleTiming(candidateScheduleTimingId, candidateId, locationId, 
				interviewerId, locationScheduleTimingId, skillSetId, interviewerSkillSet1, interviewerSkillSet2, interviewerSkillSet3, candidateScheduleFromTime, candidateScheduleToTime, candidateFeedback, 
				candidatePerformance, interviewStatus, candidateUniqueId, employerId, createdBy, lastModifiedBy, fromDate, toDate, status, startRecord, endRecord);
	}

	public List<CandidateScheduleTiming> searchCandidateScheduleTiming(
			Integer candidateScheduleTimingId, Integer candidateId,
			Integer locationId, List<Integer> locationIdList,
			Integer interviewerId, Integer locationScheduleTimingId,
			Integer skillSetId, Integer interviewerSkillSet1,
			Integer interviewerSkillSet2, Integer interviewerSkillSet3,
			Date candidateScheduleFromTime, Date candidateScheduleToTime,
			String candidateFeedback, Integer candidatePerformance,
			Integer interviewStatus, String candidateUniqueId, Integer employerId, 
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return candidateScheduleTimingDAO.searchCandidateScheduleTiming(candidateScheduleTimingId, candidateId, locationId, locationIdList, 
				interviewerId, locationScheduleTimingId, skillSetId, interviewerSkillSet1, interviewerSkillSet2, interviewerSkillSet3, candidateScheduleFromTime, candidateScheduleToTime, candidateFeedback, 
				candidatePerformance, interviewStatus, candidateUniqueId, employerId, createdBy, lastModifiedBy, fromDate, toDate, status, startRecord, endRecord);
	}

	public CandidateScheduleTiming getCandidateScheduleTiming(Integer candidateScheduleTimingId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTiming(candidateScheduleTimingId);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByCandidateId(Integer candidateId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsByCandidateId(candidateId);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByLocationId(Integer locationId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsByLocationId(locationId);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByInterviewerId(Integer interviewerId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsByInterviewerId(interviewerId);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByLocationScheduleTimingId(Integer locationScheduleTimingId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsByLocationScheduleTimingId(locationScheduleTimingId);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByCandidatePerformance(Integer candidatePerformance) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsByCandidatePerformance(candidatePerformance);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByInterviewStatus(Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsByInterviewStatus(interviewStatus);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingListByPage(int startRecord, int endRecord) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingListByPage(startRecord, endRecord);
	}
	public List<CandidateScheduleTiming> getCandidateScheduleTimingListByInterviewStatusPage(
			Integer interviewStatus, int startRecord, int endRecord) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingListByInterviewStatusPage(interviewStatus, startRecord, endRecord);
	}
	
	public Integer getCandidateScheduleTimingListCount() {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingListCount();
	}

	public Integer getCandidateScheduleTimingByInterviewStatusListCount(Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByInterviewStatusListCount(interviewStatus);
	}

	public Integer getCandidateScheduleTimingByCandidateIdInterviewStatusListCount(
			Integer candidateId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByCandidateIdInterviewStatusListCount(candidateId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByLocationIdInterviewStatusListCount(
			Integer locationId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByLocationIdInterviewStatusListCount(locationId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByInterviewerIdInterviewStatusListCount(
			Integer interviewerId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByInterviewerIdInterviewStatusListCount(interviewerId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByCandidateIdLocationIdInterviewStatusListCount(
			Integer candidateId, Integer locationId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByCandidateIdLocationIdInterviewStatusListCount(candidateId, locationId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByCandidateIdInterviewerIdInterviewStatusListCount(
			Integer candidateId, Integer interviewerId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByCandidateIdInterviewerIdInterviewStatusListCount(candidateId, interviewerId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByLocationIdInterviewerIdInterviewStatusListCount(
			Integer locationId, Integer interviewerId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByLocationIdInterviewerIdInterviewStatusListCount(locationId, interviewerId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByCandidateIdLocationIdInterviewerIdInterviewStatusListCount(
			Integer candidateId, Integer locationId, Integer interviewerId,
			Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByCandidateIdLocationIdInterviewerIdInterviewStatusListCount(candidateId, locationId, interviewerId, interviewStatus);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsBySkillSetId(
			Integer skillSetId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsBySkillSetId(skillSetId);
	}

	public Integer getCandidateScheduleTimingBySkillSetIdInterviewStatusListCount(
			Integer skillSetId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingBySkillSetIdInterviewStatusListCount(skillSetId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByLocationScheduleTimingIdInterviewStatusListCount(
			Integer locationScheduleTimingId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByLocationScheduleTimingIdInterviewStatusListCount(
				locationScheduleTimingId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByCandidateIdSkillSetIdInterviewStatusListCount(
			Integer candidateId, Integer skillSetId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByCandidateIdSkillSetIdInterviewStatusListCount(
				candidateId, skillSetId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByLocationIdskillSetIdInterviewStatusListCount(
			Integer locationId, Integer skillSetId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByLocationIdskillSetIdInterviewStatusListCount(
				locationId, skillSetId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByInterviewerIdskillSetIdInterviewStatusListCount(
			Integer interviewerId, Integer skillSetId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByInterviewerIdskillSetIdInterviewStatusListCount(
				interviewerId, skillSetId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByLocationScheduleTimingIdSkillSetIdInterviewStatusListCount(
			Integer locationScheduleTimingId, Integer skillSetId,
			Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByLocationScheduleTimingIdSkillSetIdInterviewStatusListCount(
				locationScheduleTimingId, skillSetId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByCandidateIdLocationIdSkillSetIdInterviewStatusListCount(
			Integer candidateId, Integer locationId, Integer skillSetId,
			Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByCandidateIdLocationIdSkillSetIdInterviewStatusListCount(
				candidateId, locationId, skillSetId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByLocationIdInterviewerIdSkillSetIdInterviewStatusListCount(
			Integer locationId, Integer interviewerId, Integer skillSetId,
			Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByLocationIdInterviewerIdSkillSetIdInterviewStatusListCount(
				locationId, interviewerId, skillSetId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByCandidateIdLocationIdInterviewerIdSkillSetIdInterviewStatusListCount(
			Integer candidateId, Integer locationId, Integer interviewerId,
			Integer skillSetId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByCandidateIdLocationIdInterviewerIdSkillSetIdInterviewStatusListCount(
				candidateId, locationId, interviewerId, skillSetId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByInterviewerInterviewStatusListCount(
			Integer interviewerSkillSet1, Integer interviewerSkillSet2,
			Integer interviewerSkillSet3, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByInterviewerInterviewStatusListCount(interviewerSkillSet1, 
				interviewerSkillSet2, interviewerSkillSet3, interviewStatus);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByEmployerId(Integer employerId, final int startRecord, final int endRecord) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsByEmployerId(employerId, startRecord, endRecord);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingByCandidateIdEmployerScheduled(Integer candidateId, Integer startRecord, Integer endRecord) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByCandidateIdEmployerScheduled(candidateId, startRecord, endRecord);
	}

	public Integer getCandidateScheduleTimingByCandidateIdEmployerScheduledListCount(Integer candidateId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByCandidateIdEmployerScheduledListCount(candidateId);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByEmployerIdAndNotInterviewed(Integer employerId, final int startRecord, final int endRecord) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsByEmployerIdAndNotInterviewed(employerId, startRecord, endRecord);
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingsByEmployerIdAndInterviewed(Integer employerId, final int startRecord, final int endRecord) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingsByEmployerIdAndInterviewed(employerId, startRecord, endRecord);
	}

	public Integer getCandidateScheduleTimingByEmployerIdListCount(Integer employerId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByEmployerIdListCount(employerId);
	}

	public Integer getCandidateScheduleTimingByEmployerIdAndNotInterviewedListCount(Integer employerId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByEmployerIdAndNotInterviewedListCount(employerId);
	}

	public Integer getCandidateScheduleTimingByEmployerIdAndInterviewedListCount(Integer employerId) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByEmployerIdAndInterviewedListCount(employerId);
	}

	public Integer getCandidateScheduleTimingByEmployerIdAndInterviewStatusListCount(Integer employerId, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByEmployerIdAndInterviewStatusListCount(employerId, interviewStatus);
	}

	public Integer getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(Integer interviewerId, Integer skillSetId, Integer interviewStatus,
			Date candidateScheduleFromTime, Date candidateScheduleToTime) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(interviewerId, skillSetId, interviewStatus, candidateScheduleFromTime, candidateScheduleToTime);
	}

	public Integer getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(Integer interviewerId, Integer skillSetId, Integer interviewStatus,
			Date candidateScheduleFromTime, Date candidateScheduleToTime, Integer candidatePerformance) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(interviewerId, skillSetId, interviewStatus, candidateScheduleFromTime, candidateScheduleToTime, candidatePerformance);
	}
	
	public Integer getCandidateScheduleTimingByLocationIdListInterviewStatusListCount(
			List<Integer> locationIdList, Integer interviewStatus) {
		return candidateScheduleTimingDAO.getCandidateScheduleTimingByLocationIdListInterviewStatusListCount(locationIdList, interviewStatus);
	}

	public CandidateScheduleTiming getByCandidateUniqueId(String candidateUniqueId) {
		return candidateScheduleTimingDAO.getByCandidateUniqueId(candidateUniqueId);
	}

	public Integer searchCandidateScheduleTimingListCount(
			Integer candidateScheduleTimingId, Integer candidateId,
			Integer locationId, Integer interviewerId,
			Integer locationScheduleTimingId, Integer skillSetId,
			Integer interviewerSkillSet1, Integer interviewerSkillSet2,
			Integer interviewerSkillSet3, Date candidateScheduleFromTime,
			Date candidateScheduleToTime, String candidateFeedback,
			Integer candidatePerformance, Integer interviewStatus,
			String candidateUniqueId, Integer employerId, 
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status) {
		return candidateScheduleTimingDAO.searchCandidateScheduleTimingListCount(candidateScheduleTimingId, candidateId, locationId, 
				interviewerId, locationScheduleTimingId, skillSetId, interviewerSkillSet1, interviewerSkillSet2, interviewerSkillSet3, 
				candidateScheduleFromTime, candidateScheduleToTime, candidateFeedback, candidatePerformance, interviewStatus, 
				candidateUniqueId, employerId, createdBy, lastModifiedBy, fromDate, toDate, status);
	}

	public Integer searchCandidateScheduleTimingListCount(
			Integer candidateScheduleTimingId, Integer candidateId,
			Integer locationId, List<Integer> locationIdList,
			Integer interviewerId, Integer locationScheduleTimingId,
			Integer skillSetId, Integer interviewerSkillSet1,
			Integer interviewerSkillSet2, Integer interviewerSkillSet3,
			Date candidateScheduleFromTime, Date candidateScheduleToTime,
			String candidateFeedback, Integer candidatePerformance,
			Integer interviewStatus, String candidateUniqueId,
			Integer employerId, Integer createdBy,
			Integer lastModifiedBy, Date fromDate, Date toDate, Integer status) {
		return candidateScheduleTimingDAO.searchCandidateScheduleTimingListCount(candidateScheduleTimingId, candidateId, locationId, 
				locationIdList, interviewerId, locationScheduleTimingId, skillSetId, interviewerSkillSet1, interviewerSkillSet2, 
				interviewerSkillSet3, candidateScheduleFromTime, candidateScheduleToTime, candidateFeedback, candidatePerformance, 
				interviewStatus, candidateUniqueId, employerId, createdBy, lastModifiedBy, fromDate, toDate, status);
	}

}
