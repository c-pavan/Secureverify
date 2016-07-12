package com.secureVerify.action;

import org.apache.log4j.Logger;

import com.secureVerify.model.Agent;
import com.secureVerify.model.Candidate;
import com.secureVerify.model.CandidateScheduleTiming;
import com.secureVerify.model.Employer;
import com.secureVerify.model.Interviewer;
import com.secureVerify.model.Location;
import com.secureVerify.model.SkillSet;


public class HomeAction extends MasterAction{
	
	private static final long serialVersionUID = 4360864400986718475L;

	private static final Logger log = Logger.getLogger(HomeAction.class);
	
	private String key;
	private String key2;
	private String key3;
	
	private String candidateUniqueId;
	private Candidate candidate;
	private Agent agent;
	private Interviewer interviewer;
	private Employer employer;
	private CandidateScheduleTiming candidateScheduleTiming;
	private SkillSet skillSet;
	private Location location;
	
	@SuppressWarnings("unchecked")
	public String getHomePage(){
		try{
			getGlobalContent();
			urlPage = "home";
			user = null;
			agent = null;
			interviewer = null;
			employer = null;
			candidate = null;
			session.put("user", user);
			session.put("agent", agent);
			session.put("interviewer", interviewer);
			session.put("employer", employer);
			session.put("candidate", candidate);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getContactusPage(){
		try{
			getGlobalContent();
			urlPage = "contactus";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String whySecureVerify(){
		try{
			getGlobalContent();
			urlPage = "whySecureVerify";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String verifyCandidateSearch(){
		try{
			getGlobalContent();
			urlPage = "verifyCandidate";
			if(!isEmpty(getCandidateUniqueId())){
				candidateScheduleTiming = candidateScheduleTimingBo.getByCandidateUniqueId(candidateUniqueId);
				if(candidateScheduleTiming==null){
					return "notForund";
				}else{
					candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
					feedbackList = feedbackBo.getFeedbacksByCandidateScheduleTimingId(candidateScheduleTiming.getCandidateScheduleTimingId());
					skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
					location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
				}
			}else{
				addActionError("Verification Id Can't be Empty !!");
				return "failure";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public String getKey3() {
		return key3;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public String getCandidateUniqueId() {
		return candidateUniqueId;
	}

	public void setCandidateUniqueId(String candidateUniqueId) {
		this.candidateUniqueId = candidateUniqueId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public CandidateScheduleTiming getCandidateScheduleTiming() {
		return candidateScheduleTiming;
	}

	public void setCandidateScheduleTiming(
			CandidateScheduleTiming candidateScheduleTiming) {
		this.candidateScheduleTiming = candidateScheduleTiming;
	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(SkillSet skillSet) {
		this.skillSet = skillSet;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	
}
