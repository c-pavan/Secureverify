package com.secureVerify.model;

public class CandidateEmployerSkillSetMap implements java.io.Serializable {

	private static final long serialVersionUID = -8633792985525536768L;
	
	private Integer candidateEmployerSkillSetMapId;
	private Integer candidateId;
	private Integer employerId;
	private Integer skillSetId;
	private Integer isScheduled;
	
	private Candidate candidate;
	private Employer employer;
	private SkillSet skillSet;
	
	public CandidateEmployerSkillSetMap(){
		
	}

	public CandidateEmployerSkillSetMap(Integer candidateEmployerSkillSetMapId, Integer candidateId, Integer employerId, Integer skillSetId, Integer isScheduled){
		this.candidateEmployerSkillSetMapId = candidateEmployerSkillSetMapId;
		this.candidateId = candidateId;
		this.employerId = employerId;
		this.skillSetId = skillSetId;
		this.isScheduled = isScheduled;
	}

	public CandidateEmployerSkillSetMap(Integer candidateId, Integer employerId, Integer skillSetId, Integer isScheduled){
		this.candidateId = candidateId;
		this.employerId = employerId;
		this.skillSetId = skillSetId;
		this.isScheduled = isScheduled;
	}

	public Integer getCandidateEmployerSkillSetMapId() {
		return candidateEmployerSkillSetMapId;
	}

	public void setCandidateEmployerSkillSetMapId(Integer candidateEmployerSkillSetMapId) {
		this.candidateEmployerSkillSetMapId = candidateEmployerSkillSetMapId;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public Integer getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}

	public Integer getSkillSetId() {
		return skillSetId;
	}

	public void setSkillSetId(Integer skillSetId) {
		this.skillSetId = skillSetId;
	}

	public Integer getIsScheduled() {
		return isScheduled;
	}

	public void setIsScheduled(Integer isScheduled) {
		this.isScheduled = isScheduled;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(SkillSet skillSet) {
		this.skillSet = skillSet;
	}
	
}
