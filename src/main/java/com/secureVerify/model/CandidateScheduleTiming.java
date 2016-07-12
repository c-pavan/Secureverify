package com.secureVerify.model;

import java.util.Date;

public class CandidateScheduleTiming implements java.io.Serializable {
	
	private static final long serialVersionUID = 1464037080525522860L;
	
	private Integer candidateScheduleTimingId;
	private Integer candidateId;
	private Integer locationId;
	private Integer interviewerId;
	private Integer skillSetId;
	private Integer locationScheduleTimingId;
	private Date candidateScheduleFromTime;
	private Date candidateScheduleToTime;
	private String candidateFeedback;
	private Integer candidatePerformance;
	private Integer interviewStatus;
	private String candidateUniqueId;
	private Integer employerId;
	private String createdByName;
	private Integer createdBy;
	private String lastModifiedByName;
	private Integer lastModifiedBy;
	private Date creationDate;
	private Date lastModifiedTime;
	private Integer status;
	private Candidate candidate;
	private SkillSet skillSet;
	private Interviewer interviewer;
	private Location location;
	private Coupon coupon;
	private Employer employer;
	private Agent agent;
	
	public CandidateScheduleTiming(){
		
	}

	public CandidateScheduleTiming(Integer candidateScheduleTimingId, Integer candidateId, Integer locationId, Integer interviewerId, 
			Integer locationScheduleTimingId, Integer skillSetId, Date candidateScheduleFromTime, Date candidateScheduleToTime, 
			String candidateFeedback, Integer candidatePerformance, Integer interviewStatus, String candidateUniqueId, Integer employerId, 
			Integer createdBy, Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, Integer status){
		this.candidateScheduleTimingId = candidateScheduleTimingId;
		this.candidateId = candidateId;
		this.locationId = locationId;
		this.interviewerId = interviewerId;
		this.locationScheduleTimingId = locationScheduleTimingId;
		this.skillSetId = skillSetId;
		this.candidateScheduleFromTime = candidateScheduleFromTime;
		this.candidateScheduleToTime = candidateScheduleToTime;
		this.candidateFeedback = candidateFeedback;
		this.candidatePerformance = candidatePerformance;
		this.interviewStatus = interviewStatus;
		this.candidateUniqueId = candidateUniqueId;
		this.employerId = employerId;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public CandidateScheduleTiming(Integer candidateId, Integer locationId, Integer interviewerId, 
			Integer locationScheduleTimingId, Integer skillSetId, Date candidateScheduleFromTime, Date candidateScheduleToTime, 
			String candidateFeedback, Integer candidatePerformance, Integer interviewStatus, String candidateUniqueId, Integer employerId, 
			Integer createdBy, Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, Integer status){
		this.candidateId = candidateId;
		this.locationId = locationId;
		this.interviewerId = interviewerId;
		this.locationScheduleTimingId = locationScheduleTimingId;
		this.skillSetId = skillSetId;
		this.candidateScheduleFromTime = candidateScheduleFromTime;
		this.candidateScheduleToTime = candidateScheduleToTime;
		this.candidateFeedback = candidateFeedback;
		this.candidatePerformance = candidatePerformance;
		this.interviewStatus = interviewStatus;
		this.candidateUniqueId = candidateUniqueId;
		this.employerId = employerId;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public Integer getCandidateScheduleTimingId() {
		return candidateScheduleTimingId;
	}

	public void setCandidateScheduleTimingId(Integer candidateScheduleTimingId) {
		this.candidateScheduleTimingId = candidateScheduleTimingId;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getLocationScheduleTimingId() {
		return locationScheduleTimingId;
	}

	public void setLocationScheduleTimingId(Integer locationScheduleTimingId) {
		this.locationScheduleTimingId = locationScheduleTimingId;
	}

	public Date getCandidateScheduleFromTime() {
		return candidateScheduleFromTime;
	}

	public void setCandidateScheduleFromTime(Date candidateScheduleFromTime) {
		this.candidateScheduleFromTime = candidateScheduleFromTime;
	}

	public Date getCandidateScheduleToTime() {
		return candidateScheduleToTime;
	}

	public void setCandidateScheduleToTime(Date candidateScheduleToTime) {
		this.candidateScheduleToTime = candidateScheduleToTime;
	}

	public String getCandidateFeedback() {
		return candidateFeedback;
	}

	public void setCandidateFeedback(String candidateFeedback) {
		this.candidateFeedback = candidateFeedback;
	}

	public Integer getCandidatePerformance() {
		return candidatePerformance;
	}

	public void setCandidatePerformance(Integer candidatePerformance) {
		this.candidatePerformance = candidatePerformance;
	}

	public Integer getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(Integer interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedByName() {
		return lastModifiedByName;
	}

	public void setLastModifiedByName(String lastModifiedByName) {
		this.lastModifiedByName = lastModifiedByName;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(SkillSet skillSet) {
		this.skillSet = skillSet;
	}

	public Integer getSkillSetId() {
		return skillSetId;
	}

	public void setSkillSetId(Integer skillSetId) {
		this.skillSetId = skillSetId;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Integer getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getCandidateUniqueId() {
		return candidateUniqueId;
	}

	public void setCandidateUniqueId(String candidateUniqueId) {
		this.candidateUniqueId = candidateUniqueId;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}


}
