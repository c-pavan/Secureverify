package com.secureVerify.dao;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.CandidateScheduleTiming;

public interface CandidateScheduleTimingDAO {

	void addCandidateScheduleTiming(CandidateScheduleTiming candidateScheduleTiming);
	
	void updateCandidateScheduleTiming(CandidateScheduleTiming candidateScheduleTiming);
	
	void deleteCandidateScheduleTiming(CandidateScheduleTiming candidateScheduleTiming);
	
	void deleteCandidateScheduleTimingList(List<CandidateScheduleTiming> candidateScheduleTimingList);
	
	List<CandidateScheduleTiming> listCandidateScheduleTiming();
	
	List<CandidateScheduleTiming> listActiveCandidateScheduleTiming();
	
	List<CandidateScheduleTiming> searchCandidateScheduleTiming(Integer candidateScheduleTimingId, Integer candidateId, Integer locationId, Integer interviewerId, 
			Integer locationScheduleTimingId, Integer skillSetId, Integer interviewerSkillSet1, Integer interviewerSkillSet2, Integer interviewerSkillSet3, 
			Date candidateScheduleFromTime, Date candidateScheduleToTime, String candidateFeedback, Integer candidatePerformance, 
			Integer interviewStatus, String candidateUniqueId, Integer employerId, Integer createdBy, Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, Integer startRecord, Integer endRecord);

	List<CandidateScheduleTiming> searchCandidateScheduleTiming(Integer candidateScheduleTimingId, Integer candidateId, Integer locationId, List<Integer> locationIdList, Integer interviewerId, 
			Integer locationScheduleTimingId, Integer skillSetId, Integer interviewerSkillSet1, Integer interviewerSkillSet2, Integer interviewerSkillSet3, 
			Date candidateScheduleFromTime, Date candidateScheduleToTime, String candidateFeedback, Integer candidatePerformance, 
			Integer interviewStatus, String candidateUniqueId, Integer employerId, Integer createdBy, Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, Integer startRecord, Integer endRecord);
	
	CandidateScheduleTiming getCandidateScheduleTiming(Integer candidateScheduleTimingId);
	
	CandidateScheduleTiming getByCandidateUniqueId(String candidateUniqueId);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingsByCandidateId(Integer candidateId);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingsByLocationId(Integer locationId);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingsBySkillSetId(Integer skillSetId);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingsByInterviewerId(Integer interviewerId);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingsByLocationScheduleTimingId(Integer locationScheduleTimingId);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingsByCandidatePerformance(Integer candidatePerformance);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingsByInterviewStatus(Integer interviewStatus);

	List<CandidateScheduleTiming> getCandidateScheduleTimingsByEmployerId(Integer employerId, final int startRecord, final int endRecord);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingsByEmployerIdAndNotInterviewed(Integer employerId, final int startRecord, final int endRecord);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingsByEmployerIdAndInterviewed(Integer employerId, final int startRecord, final int endRecord);

	List<CandidateScheduleTiming> getCandidateScheduleTimingByCandidateIdEmployerScheduled(Integer candidateId, Integer startRecord, Integer endRecord);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingListByPage(final int startRecord, final int endRecord);
	
	List<CandidateScheduleTiming> getCandidateScheduleTimingListByInterviewStatusPage(Integer interviewStatus, final int startRecord, final int endRecord);
	
	Integer getCandidateScheduleTimingListCount();
	
	Integer getCandidateScheduleTimingByInterviewStatusListCount(Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByCandidateIdEmployerScheduledListCount(Integer candidateId);
	
	Integer getCandidateScheduleTimingByEmployerIdListCount(Integer employerId);
	
	Integer getCandidateScheduleTimingByEmployerIdAndNotInterviewedListCount(Integer employerId);
	
	Integer getCandidateScheduleTimingByEmployerIdAndInterviewedListCount(Integer employerId);
	
	Integer getCandidateScheduleTimingByEmployerIdAndInterviewStatusListCount(Integer employerId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByCandidateIdInterviewStatusListCount(Integer candidateId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByLocationIdInterviewStatusListCount(Integer locationId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByLocationIdListInterviewStatusListCount(List<Integer> locationIdList, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByInterviewerIdInterviewStatusListCount(Integer interviewerId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingBySkillSetIdInterviewStatusListCount(Integer skillSetId, Integer interviewStatus);

	Integer getCandidateScheduleTimingByInterviewerInterviewStatusListCount(Integer interviewerSkillSet1, Integer interviewerSkillSet2, Integer interviewerSkillSet3, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByLocationScheduleTimingIdInterviewStatusListCount(Integer locationScheduleTimingId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByCandidateIdLocationIdInterviewStatusListCount(Integer candidateId, Integer locationId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByCandidateIdInterviewerIdInterviewStatusListCount(Integer candidateId, Integer interviewerId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByCandidateIdSkillSetIdInterviewStatusListCount(Integer candidateId, Integer skillSetId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByLocationIdInterviewerIdInterviewStatusListCount(Integer locationId, Integer interviewerId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByLocationIdskillSetIdInterviewStatusListCount(Integer locationId, Integer skillSetId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByInterviewerIdskillSetIdInterviewStatusListCount(Integer interviewerId, Integer skillSetId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByLocationScheduleTimingIdSkillSetIdInterviewStatusListCount(Integer locationScheduleTimingId, Integer skillSetId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByCandidateIdLocationIdInterviewerIdInterviewStatusListCount(Integer candidateId, Integer locationId, Integer interviewerId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByCandidateIdLocationIdSkillSetIdInterviewStatusListCount(Integer candidateId, Integer locationId, Integer skillSetId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByLocationIdInterviewerIdSkillSetIdInterviewStatusListCount(Integer locationId, Integer interviewerId, Integer skillSetId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByCandidateIdLocationIdInterviewerIdSkillSetIdInterviewStatusListCount(Integer candidateId, Integer locationId, Integer interviewerId, Integer skillSetId, Integer interviewStatus);
	
	Integer getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(Integer interviewerId, Integer skillSetId, Integer interviewStatus, Date candidateScheduleFromTime, Date candidateScheduleToTime);
	
	Integer getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(Integer interviewerId, Integer skillSetId, Integer interviewStatus, Date candidateScheduleFromTime, Date candidateScheduleToTime, Integer candidatePerformance);
	
	Integer searchCandidateScheduleTimingListCount(Integer candidateScheduleTimingId, Integer candidateId, Integer locationId, Integer interviewerId, 
			Integer locationScheduleTimingId, Integer skillSetId, Integer interviewerSkillSet1, Integer interviewerSkillSet2, Integer interviewerSkillSet3, 
			Date candidateScheduleFromTime, Date candidateScheduleToTime, String candidateFeedback, Integer candidatePerformance, 
			Integer interviewStatus, String candidateUniqueId, Integer employerId, Integer createdBy, Integer lastModifiedBy, Date fromDate, Date toDate, Integer status);

	Integer searchCandidateScheduleTimingListCount(Integer candidateScheduleTimingId, Integer candidateId, Integer locationId, List<Integer> locationIdList, Integer interviewerId, 
			Integer locationScheduleTimingId, Integer skillSetId, Integer interviewerSkillSet1, Integer interviewerSkillSet2, Integer interviewerSkillSet3, 
			Date candidateScheduleFromTime, Date candidateScheduleToTime, String candidateFeedback, Integer candidatePerformance, 
			Integer interviewStatus, String candidateUniqueId, Integer employerId, Integer createdBy, Integer lastModifiedBy, Date fromDate, Date toDate, Integer status);
	
}
