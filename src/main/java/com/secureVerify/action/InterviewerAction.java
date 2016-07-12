package com.secureVerify.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.secureVerify.model.Agent;
import com.secureVerify.model.Candidate;
import com.secureVerify.model.CandidateScheduleTiming;
import com.secureVerify.model.Employer;
import com.secureVerify.model.Feedback;
import com.secureVerify.model.InterviewStatus;
import com.secureVerify.model.Interviewer;
import com.secureVerify.model.Location;
import com.secureVerify.model.LocationScheduleTiming;
import com.secureVerify.model.Propertie;
import com.secureVerify.model.SecureVerifyEmailType;
import com.secureVerify.model.SkillSet;
import com.secureVerify.util.DateHelper;
import com.secureVerify.util.Helper;
import com.secureVerify.util.SecureVerifyMail;

public class InterviewerAction extends MasterAction {

	private static final long serialVersionUID = 3658650824131159422L;

	private static final Logger log = Logger.getLogger(InterviewerAction.class);
	private static final String INTERVIEWER_LOGIN_MSG = "Please Login into Interviewer !!";
	private static final String URL_PAGE_INTERVIEWER_LOGIN = "adminLogin";

	private File resume;
	
	// Interviewer
	private Integer interviewerId;
	private String interviewerFirstName;
	private String interviewerLastName;
	private String interviewerEmailId;
	private String interviewerPassword;
	private String interviewerPhoneNo;
	private String interviewerPhoneNoExtension;
	private String interviewerAlternatePhone;
	private String interviewerAlternatePhoneNoExtension;
	private Integer interviewerSkillSet1;
	private Integer interviewerSkillSet2;
	private Integer interviewerSkillSet3;
	private String interviewerResume;
	
	private Integer skillSetId;
	private String scheduleFromTime;
	private String scheduleToTime;
	
	private String retypePassword;
		
	
	// Candidate
	private Integer candidateId;
	
	// LocationScheduleTiming
	private Integer locationScheduleTimingId;
	private Date locationScheduleFromTime;
	private Date locationScheduleToTime;
	
	// CandidateScheduleTiming
	private Integer candidateScheduleTimingId;
	private Date candidateScheduleFromTime;
	private Date candidateScheduleToTime;
	private String candidateFeedback;
	private Integer candidatePerformance;
	private Integer interviewStatus;
	

	private String currentPassword;
	
	// Classes
	private Agent agent;
	private Candidate candidate;
	private CandidateScheduleTiming candidateScheduleTiming;
	private Employer employer;
	private Feedback feedback;
	private Interviewer interviewer;
	private Location location;
	private LocationScheduleTiming locationScheduleTiming;
	private SkillSet skillSet;
	private List<SkillSet> skillSetList;
	
	private List<LocationScheduleTiming> locationScheduleTimingList;
	private List<CandidateScheduleTiming> candidateScheduleTimingList;
	
	
	// Interviewer Login
	
	@SuppressWarnings("unchecked")
	public String authenticateInterviewer(){
		try{
			getGlobalContent();
			user = null;
			
			authenticateInterviewerValidator();
			if(!hasActionErrors()){
				interviewer = interviewerBo.getInterviewer(interviewerEmailId, interviewerPassword);
				if(interviewer!=null){
					skillSetList = new ArrayList<SkillSet>();
					if(interviewer.getInterviewerSkillSet1()!=null && interviewer.getInterviewerSkillSet1()!=0){
						skillSet = skillSetBo.getSkillSetBySkillSetId(interviewer.getInterviewerSkillSet1());
						if(skillSet!=null){ skillSetList.add(skillSet); }
					}else{
						addActionError("Interviewer doen't Mapped to any Skill Set!!");
						return "failure";
					}
					if(interviewer.getInterviewerSkillSet2()!=null && interviewer.getInterviewerSkillSet2()!=0){
						skillSet = skillSetBo.getSkillSetBySkillSetId(interviewer.getInterviewerSkillSet2());
						if(skillSet!=null){ skillSetList.add(skillSet); }
					}
					if(interviewer.getInterviewerSkillSet3()!=null && interviewer.getInterviewerSkillSet3()!=0){
						skillSet = skillSetBo.getSkillSetBySkillSetId(interviewer.getInterviewerSkillSet3());
						if(skillSet!=null){ skillSetList.add(skillSet); }
					}
					interviewer.setSkillSetList(skillSetList);
					session.put("interviewer", interviewer);
				}else{
					urlPage = URL_PAGE_INTERVIEWER_LOGIN;
					addActionError("Interviewer doen't found with given Email Id and Password!!");
					return "failure";
				}
			}else{
				urlPage = URL_PAGE_INTERVIEWER_LOGIN;
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void authenticateInterviewerValidator(){
        if(isEmpty(getInterviewerEmailId())){
    		addActionError("Interviewer Email Id can't be empty !!");
    	}
    	if(isEmpty(getInterviewerPassword())){
    		addActionError("Interviewer Password can't be empty !!");
    	}
    }
	
	
	// Applied Candidates
	
	public String getInterviewerAppliedCandidatesPage(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerAppliedCandidates";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByInterviewerInterviewStatusListCount(
						interviewer.getInterviewerSkillSet1(), interviewer.getInterviewerSkillSet2(), 
						interviewer.getInterviewerSkillSet3(), InterviewStatus.APPLIED.getValue());
				
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, 
						null, null, null, null, interviewer.getInterviewerSkillSet1(), interviewer.getInterviewerSkillSet2(), interviewer.getInterviewerSkillSet3(), 
						null, null, null, null, InterviewStatus.APPLIED.getValue(), null, null, null, null, null, null, null, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming tmpCandidateScheduleTiming: candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(tmpCandidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							tmpCandidateScheduleTiming.setCandidate(candidate);
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							if(skillSet!=null){
								tmpCandidateScheduleTiming.setSkillSet(skillSet); 
							}
						}
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getInterviewerAppliedCandidatesSearchPage(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerAppliedCandidates";
				
				if(scheduleFromTime!=null && !scheduleFromTime.equals("")){
					locationScheduleFromTime = DateHelper.getUtilDateTimeFromString(scheduleFromTime);
				}
				if(scheduleToTime!=null && !scheduleToTime.equals("")){
					locationScheduleToTime = DateHelper.getUtilDateTimeFromString(scheduleToTime);
				}
				
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(
						null, skillSetId, InterviewStatus.APPLIED.getValue(), locationScheduleFromTime, locationScheduleToTime);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, 
						null, null, skillSetId, null, null, null, locationScheduleFromTime, locationScheduleToTime, null, null, 
						InterviewStatus.APPLIED.getValue(), null, null, null, null, null, null, null, startRecord, pageSize);
				
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming tmpCandidateScheduleTiming: candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(tmpCandidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							tmpCandidateScheduleTiming.setCandidate(candidate);
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							if(skillSet!=null){
								tmpCandidateScheduleTiming.setSkillSet(skillSet); 
							}
						}
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError("Error Occured During the Search !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewInterviewerAppliedCandidate(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerAppliedCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return ERROR;
					}
					location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
					candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
					if(candidate!=null){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
					}
				}
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String pickInterviewerAppliedCandidate(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerAppliedCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
					}
				}
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateInterviewerAppliedCandidate(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerAppliedCandidates";
				if(isNumberNullOrZero(getUniqueId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(uniqueId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return "interviewerAppliedCandidates";
					}else{
						candidateScheduleTiming.setInterviewerId(interviewer.getInterviewerId());
						candidateScheduleTiming.setInterviewStatus(InterviewStatus.SCHEDULED.getValue());
						candidateScheduleTiming.setLastModifiedTime(new Date());
						candidateScheduleTimingBo.updateCandidateScheduleTiming(candidateScheduleTiming);
						
						propertie = propertieBo.getPropertie();
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						
						secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_PICKUP_EMAIL_TO_CANDIDATE.getValue());
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						
						if(candidate!=null && propertie!=null && secureVerifyEmailSubjectBody!=null && location!=null && skillSet!=null){
							Helper.candidateTimeSlotPickedByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
									candidate.getCandidateEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
									location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
									location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime());
						}
						
						if(candidateScheduleTiming.getEmployerId()!=0){
							employer = employerBo.getEmployerByEmployerId(candidateScheduleTiming.getEmployerId());
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_PICKUP_EMAIL_TO_EMPLOYER.getValue());
							if(employer!=null && propertie!=null && secureVerifyEmailSubjectBody!=null && location!=null && skillSet!=null){
								Helper.candidateTimeSlotPickedByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
										employer.getEmployerEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
										location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
										location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime());
							}
						}
	
						secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_PICKUP_EMAIL_TO_INTERVIEWER.getValue());
						if(propertie!=null && secureVerifyEmailSubjectBody!=null && location!=null && skillSet!=null){
							Helper.candidateTimeSlotPickedByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
									interviewer.getInterviewerEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
									location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
									location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime());
						}
	
						secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_PICKUP_EMAIL_TO_AGENT.getValue());
						agent = agentBo.getAgentByAgentId(location.getLocationSecondaryAgentId());
						if(propertie!=null && secureVerifyEmailSubjectBody!=null && agent!=null && agent.getAgentEmailId()!=null && !agent.getAgentEmailId().equals("") && skillSet!=null){
							Helper.candidateTimeSlotPickedByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
									agent.getAgentEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
									location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
									location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime());
						}
						if(location.getLocationSecondaryAgentId()!=null && location.getLocationSecondaryAgentId()!=0){
							agent = agentBo.getAgentByAgentId(location.getLocationSecondaryAgentId());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null && agent!=null && agent.getAgentEmailId()!=null && !agent.getAgentEmailId().equals("") && skillSet!=null){
								Helper.candidateTimeSlotPickedByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
										agent.getAgentEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
										location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
										location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime());
							}
						}
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Scheduled Candidates
	
	public String getInterviewerScheduledCandidatesPage(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerScheduledCandidates";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByInterviewerIdInterviewStatusListCount(
						interviewer.getInterviewerId(), InterviewStatus.SCHEDULED.getValue());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, 
						interviewer.getInterviewerId(), null, null, null, null, null, 
						null, null, null, null, InterviewStatus.SCHEDULED.getValue(), null, null, null, null, null, null, null, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming tmpCandidateScheduleTiming: candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(tmpCandidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							tmpCandidateScheduleTiming.setCandidate(candidate);
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							if(skillSet!=null){
								tmpCandidateScheduleTiming.setSkillSet(skillSet); 
							}
						}
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getInterviewerScheduledCandidatesSearchPage(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerScheduledCandidates";
				
				if(scheduleFromTime!=null && !scheduleFromTime.equals("")){
					locationScheduleFromTime = DateHelper.getUtilDateTimeFromString(scheduleFromTime);
				}
				if(scheduleToTime!=null && !scheduleToTime.equals("")){
					locationScheduleToTime = DateHelper.getUtilDateTimeFromString(scheduleToTime);
				}
				
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(
						null, skillSetId, InterviewStatus.SCHEDULED.getValue(), locationScheduleFromTime, locationScheduleToTime);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, 
						null, null, skillSetId, null, null, null, locationScheduleFromTime, locationScheduleToTime, null, null, 
						InterviewStatus.SCHEDULED.getValue(), null, null, null, null, null, null, null, startRecord, pageSize);
				
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming tmpCandidateScheduleTiming: candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(tmpCandidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							tmpCandidateScheduleTiming.setCandidate(candidate);
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							if(skillSet!=null){
								tmpCandidateScheduleTiming.setSkillSet(skillSet); 
							}
						}
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError("Error Occured During the Search !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewInterviewerScheduledCandidate(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerScheduledCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
					}
					candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
					if(candidate!=null){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
					}
				}
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String editInterviewerScheduledCandidate(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerScheduledCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
					return "input";
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return "input";
					}
					location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
					candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
					if(candidate!=null){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
					}
					locationScheduleTimingList = locationScheduleTimingBo.searchLocationScheduleTiming(null, candidateScheduleTiming.getLocationId(), DateHelper.getCurrentUtilDate(), DateHelper.addTwoDaysToDate(), null, null, null, null, ACTIVE, 0, 50);
					for(LocationScheduleTiming locationScheduleTiming : locationScheduleTimingList){
						if(locationScheduleTiming.getLocationScheduleTimingId().equals(candidateScheduleTiming.getLocationScheduleTimingId())){
							locationScheduleTimingList.remove(locationScheduleTiming);
							break;
						}
					}
				}
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateInterviewerScheduledCandidate(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerScheduledCandidates";
				updateInterviewerScheduledCandidateValidator();
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
					return "interviewerScheduledCandidates";
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return "interviewerScheduledCandidates";
					}else{
						if(!hasActionErrors()){
							locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(locationScheduleTimingId);
							if(locationScheduleTiming==null){
								addActionError("Invalid Schedule Time. No Location Schedule Timing Exist with the Location Schedule Timing Id !!");
								return "interviewerScheduledCandidates";
							}
							candidateScheduleTiming.setLocationScheduleTimingId(locationScheduleTimingId);
							candidateScheduleTiming.setCandidateScheduleFromTime(locationScheduleTiming.getLocationScheduleFromTime());
							candidateScheduleTiming.setCandidateScheduleToTime(locationScheduleTiming.getLocationScheduleToTime());
							candidateScheduleTiming.setLastModifiedTime(new Date());
							candidateScheduleTimingBo.updateCandidateScheduleTiming(candidateScheduleTiming);
							
			            }else{
			            	candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
							if(candidate!=null){
								skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							}
							locationScheduleTimingList = locationScheduleTimingBo.searchLocationScheduleTiming(null, candidateScheduleTiming.getLocationId(), DateHelper.getCurrentUtilDate(), DateHelper.addTwoDaysToDate(), null, null, null, null, ACTIVE, 0, 10);
							for(LocationScheduleTiming locationScheduleTiming : locationScheduleTimingList){
								if(locationScheduleTiming.getLocationScheduleTimingId().equals(candidateScheduleTiming.getLocationScheduleTimingId())){
									locationScheduleTimingList.remove(locationScheduleTiming);
									break;
								}
							}
			            	return "interviewerScheduledCandidates";
			            }
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateInterviewerScheduledCandidateValidator(){
        if(isNumberNullOrZero(getCandidateScheduleTimingId())){
        	addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
    	}
    	if(isNumberNullOrZero(getLocationScheduleTimingId())){
    		addActionError("Location Schedule Timing Id can't be Empty / Zero !!");
    	}
    }
	
	public String reportCandidatesfeedback(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerScheduledCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
					}
					candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
					if(candidate!=null){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
					}
				}
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateInterviewerCandidatesfeedback(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerScheduledCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
					return "interviewerScheduledCandidates";
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return "interviewerScheduledCandidates";
					}else{
						if(candidatePerformance!=null && candidatePerformance!=0 && candidateFeedback!=null && !candidateFeedback.equals("")){
							String verificationId = Helper.getRandomString();
							candidateScheduleTiming.setCandidatePerformance(candidatePerformance);
							candidateScheduleTiming.setCandidateFeedback(candidateFeedback);
							candidateScheduleTiming.setInterviewStatus(InterviewStatus.INTERVIEWED.getValue());
							candidateScheduleTiming.setCandidateUniqueId(verificationId);
							candidateScheduleTiming.setLastModifiedTime(new Date());
							candidateScheduleTimingBo.updateCandidateScheduleTiming(candidateScheduleTiming);
							
							feedback = new Feedback(candidateScheduleTimingId, candidateFeedback, candidatePerformance, new Date(), ACTIVE);
							feedbackBo.addFeedback(feedback);
							
							String tmpCandidatePerformance = "";
							if(candidatePerformance==0){ tmpCandidatePerformance = "Under Process"; }
							else if(candidatePerformance==1){ tmpCandidatePerformance = "Best"; }
							else if(candidatePerformance==2){ tmpCandidatePerformance = "Good"; }
							else if(candidatePerformance==3){ tmpCandidatePerformance = "Average"; }
							else if(candidatePerformance==4){ tmpCandidatePerformance = "Not Qualified"; }
							
							propertie = propertieBo.getPropertie();
							location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
							
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_FEEDBACK_EMAIL_TO_CANDIDATE.getValue());
							candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
							if(candidate!=null && propertie!=null && secureVerifyEmailSubjectBody!=null && location!=null && skillSet!=null){
								Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
										candidate.getCandidateEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
										location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
										location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), verificationId, tmpCandidatePerformance, candidateFeedback);
							}
							
							if(candidateScheduleTiming.getEmployerId()!=0){
								employer = employerBo.getEmployerByEmployerId(candidateScheduleTiming.getEmployerId());
								secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_FEEDBACK_EMAIL_TO_EMPLOYER.getValue());
								if(employer!=null && propertie!=null && secureVerifyEmailSubjectBody!=null && location!=null && skillSet!=null){
									Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
											employer.getEmployerEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
											location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
											location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), verificationId, tmpCandidatePerformance, candidateFeedback);
								}
							}
	
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_FEEDBACK_EMAIL_TO_INTERVIEWER.getValue());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null && location!=null && skillSet!=null){
								Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
										interviewer.getInterviewerEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
										location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
										location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), verificationId, tmpCandidatePerformance, candidateFeedback);
							}
	
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_FEEDBACK_EMAIL_TO_AGENT.getValue());
							agent = agentBo.getAgentByAgentId(location.getLocationSecondaryAgentId());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null && agent!=null && agent.getAgentEmailId()!=null && !agent.getAgentEmailId().equals("") && skillSet!=null){
								Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
										agent.getAgentEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
										location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
										location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), verificationId, tmpCandidatePerformance, candidateFeedback);
							}
							if(location.getLocationSecondaryAgentId()!=null && location.getLocationSecondaryAgentId()!=0){
								agent = agentBo.getAgentByAgentId(location.getLocationSecondaryAgentId());
								if(propertie!=null && secureVerifyEmailSubjectBody!=null && agent!=null && agent.getAgentEmailId()!=null && !agent.getAgentEmailId().equals("") && skillSet!=null){
									Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
											agent.getAgentEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
											location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
											location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), verificationId, tmpCandidatePerformance, candidateFeedback);
								}
							}
							
													
						}else{
							candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
							if(candidate!=null){
								skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							}
							addActionError("Invalid Form Fields !!");
			            	return "interviewerScheduledCandidates";
						}
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Interviewed Candidates

	public String getInterviewerInterviewedCandidatesPage(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerInterviewedCandidates";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByInterviewerIdInterviewStatusListCount(
						interviewer.getInterviewerId(), InterviewStatus.INTERVIEWED.getValue());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, 
						interviewer.getInterviewerId(), null, null, null, null, null, 
						null, null, null, null, InterviewStatus.INTERVIEWED.getValue(), null, null, null, null, null, null, null, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming tmpCandidateScheduleTiming: candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(tmpCandidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							tmpCandidateScheduleTiming.setCandidate(candidate);
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							if(skillSet!=null){
								tmpCandidateScheduleTiming.setSkillSet(skillSet); 
							}
						}
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getInterviewerInterviewedCandidatesSearchPage(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerInterviewedCandidates";

				if(scheduleFromTime!=null && !scheduleFromTime.equals("")){
					locationScheduleFromTime = DateHelper.getUtilDateTimeFromString(scheduleFromTime);
				}
				if(scheduleToTime!=null && !scheduleToTime.equals("")){
					locationScheduleToTime = DateHelper.getUtilDateTimeFromString(scheduleToTime);
				}
				
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(
						null, skillSetId, InterviewStatus.INTERVIEWED.getValue(), locationScheduleFromTime, locationScheduleToTime);
				
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				

				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, 
						null, null, skillSetId, null, null, null, locationScheduleFromTime, locationScheduleToTime, null, null, 
						InterviewStatus.INTERVIEWED.getValue(), null, null, null, null, null, null, null, startRecord, pageSize);
				
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming tmpCandidateScheduleTiming: candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(tmpCandidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							tmpCandidateScheduleTiming.setCandidate(candidate);
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							if(skillSet!=null){
								tmpCandidateScheduleTiming.setSkillSet(skillSet); 
							}
						}
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError("Error Occured During the Search !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewInterviewerInterviewedCandidate(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerInterviewedCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return ERROR;
					}
					feedbackList = feedbackBo.getFeedbacksByCandidateScheduleTimingId(candidateScheduleTimingId);
					location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
					candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
					if(candidate!=null){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
					}
				}
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String editInterviewerCandidatesfeedback(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerInterviewedCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
					return INPUT;
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
					}
					candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
					if(candidate!=null){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
					}
				}
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateInterviewerInterviewedCandidate(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerInterviewedCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
					return "interviewerInterviewedCandidates";
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return "interviewerInterviewedCandidates";
					}else{
						if(candidatePerformance!=null && candidatePerformance!=0 && candidateFeedback!=null && !candidateFeedback.equals("")){
							candidateScheduleTiming.setCandidatePerformance(candidatePerformance);
							candidateScheduleTiming.setCandidateFeedback(candidateFeedback);
							candidateScheduleTiming.setLastModifiedTime(new Date());
							candidateScheduleTimingBo.updateCandidateScheduleTiming(candidateScheduleTiming);
							
							feedback = new Feedback(candidateScheduleTimingId, candidateFeedback, candidatePerformance, new Date(), ACTIVE);
							feedbackBo.addFeedback(feedback);
							
	
							String tmpCandidatePerformance = "";
							if(candidatePerformance==0){ tmpCandidatePerformance = "Under Process"; }
							else if(candidatePerformance==1){ tmpCandidatePerformance = "Best"; }
							else if(candidatePerformance==2){ tmpCandidatePerformance = "Good"; }
							else if(candidatePerformance==3){ tmpCandidatePerformance = "Average"; }
							else if(candidatePerformance==4){ tmpCandidatePerformance = "Not Qualified"; }
							
							propertie = propertieBo.getPropertie();
							location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
							
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_FEEDBACK_EMAIL_TO_CANDIDATE.getValue());
							candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
							if(candidate!=null && propertie!=null && secureVerifyEmailSubjectBody!=null && location!=null && skillSet!=null){
								Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
										candidate.getCandidateEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
										location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
										location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), candidateScheduleTiming.getCandidateUniqueId(), tmpCandidatePerformance, candidateFeedback);
							}
							
							if(candidateScheduleTiming.getEmployerId()!=0){
								employer = employerBo.getEmployerByEmployerId(candidateScheduleTiming.getEmployerId());
								secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_FEEDBACK_EMAIL_TO_EMPLOYER.getValue());
								if(employer!=null && propertie!=null && secureVerifyEmailSubjectBody!=null && location!=null && skillSet!=null){
									Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
											employer.getEmployerEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
											location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
											location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), candidateScheduleTiming.getCandidateUniqueId(), tmpCandidatePerformance, candidateFeedback);
								}
							}
	
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_FEEDBACK_EMAIL_TO_INTERVIEWER.getValue());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null && location!=null && skillSet!=null){
								Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
										interviewer.getInterviewerEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
										location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
										location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), candidateScheduleTiming.getCandidateUniqueId(), tmpCandidatePerformance, candidateFeedback);
							}
	
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_CANDIDATE_FEEDBACK_EMAIL_TO_AGENT.getValue());
							agent = agentBo.getAgentByAgentId(location.getLocationSecondaryAgentId());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null && agent!=null && agent.getAgentEmailId()!=null && !agent.getAgentEmailId().equals("") && skillSet!=null){
								Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
										agent.getAgentEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
										location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
										location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), candidateScheduleTiming.getCandidateUniqueId(), tmpCandidatePerformance, candidateFeedback);
							}
							if(location.getLocationSecondaryAgentId()!=null && location.getLocationSecondaryAgentId()!=0){
								agent = agentBo.getAgentByAgentId(location.getLocationSecondaryAgentId());
								if(propertie!=null && secureVerifyEmailSubjectBody!=null && agent!=null && agent.getAgentEmailId()!=null && !agent.getAgentEmailId().equals("") && skillSet!=null){
									Helper.candidateTimeSlotFeedbackByInterviewerEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
											agent.getAgentEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
											location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
											location.getLocationPhoneNo(), candidateScheduleTiming.getCandidateScheduleFromTime(), candidateScheduleTiming.getCandidateScheduleToTime(), candidateScheduleTiming.getCandidateUniqueId(), tmpCandidatePerformance, candidateFeedback);
								}
							}
							
						}else{
							candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
							if(candidate!=null){
								skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							}
							addActionError("Invalid Form Fields !!");
			            	return "interviewerInterviewedCandidates";
						}
					}
				}
			}else{
				urlPage = INTERVIEWER_LOGIN_MSG;
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Interviewer Profile

	public String getInterviewerEditPasswordPage(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerEditPassword";
				
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String interviewerUpdatePassword(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerEditPassword";
				
				interviewerUpdatePasswordValidator();
				if(!hasActionErrors()){
					if(interviewer.getInterviewerPassword().equals(currentPassword)){
						interviewer.setInterviewerPassword(interviewerPassword);
						interviewerBo.updateInterviewer(interviewer);
						session.put("interviewer", interviewer);
						
						addActionMessage("Updated Password Successfully !!");
					}else{
						addActionError("Your Current Password is Invalid !!");
						return "failure";
					}
				}
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void interviewerUpdatePasswordValidator(){
        if(isEmpty(getCurrentPassword())){
    		addActionError("Current Password can't be empty !!");
    	}
    	if(isEmpty(getInterviewerPassword())){
			addActionError("New Password can't be empty !!");
    	}
    	if(isEmpty(getRetypePassword())){
			addActionError("Retype Password can't be empty !!");
    	}
    	if(!isEmpty(getInterviewerPassword()) && !isEmpty(getRetypePassword()) && !getInterviewerPassword().equals(getRetypePassword())){
			addActionError("New Password and Retype Password Must be Same !!");
    	}
    }
	
	public String getInterviewerEditProfilePage(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerEditProfile";
				skillSetList = skillSetBo.listActiveSkillSet();
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@SuppressWarnings("resource")
	public String interviewerUpdateProfile(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "interviewerEditProfile";
				
				interviewerUpdateProfileValidator();
				if(!hasActionErrors()){
	            
					interviewer.setInterviewerFirstName(interviewerFirstName);
					interviewer.setInterviewerLastName(interviewerLastName);
					interviewer.setInterviewerPhoneNo(interviewerPhoneNo);
					interviewer.setInterviewerPhoneNoExtension(interviewerPhoneNoExtension);
					interviewer.setInterviewerAlternatePhone(interviewerAlternatePhone);
					interviewer.setInterviewerAlternatePhoneNoExtension(interviewerAlternatePhoneNoExtension);
					interviewer.setInterviewerSkillSet1(interviewerSkillSet1);
					interviewer.setInterviewerSkillSet2(interviewerSkillSet2);
					interviewer.setInterviewerSkillSet3(interviewerSkillSet3);
					if(resume!=null){
						InputStream in = new FileInputStream(resume.getAbsolutePath());
						XWPFDocument docIn = new XWPFDocument(in);  
			            XWPFWordExtractor extractor = new XWPFWordExtractor(docIn);  
			            String docText = extractor.getText();
						interviewer.setInterviewerResume(docText);
						interviewer.setInterviewerResumeBlob(IOUtils.toByteArray(new FileInputStream(resume.getAbsolutePath())));
					}
					interviewer.setLastModifiedTime(new Date());
					interviewerBo.updateInterviewer(interviewer);
					
	            }else{
	            	skillSetList = skillSetBo.listActiveSkillSet();
	            	return "input";
	            }	
			}else{
				addActionError(INTERVIEWER_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void interviewerUpdateProfileValidator(){
        if(isEmpty(getInterviewerFirstName())){
            addActionError("Interviewer First Name can't be empty !!");
        }
        if(isEmpty(getInterviewerLastName())){
            addActionError("Interviewer Last Name can't be empty !!");
        }
        if(isEmpty(getInterviewerPhoneNo())){
            addActionError("Interviewer Phone Number can't be empty !!");
        }
        if(isNumberNullOrZero(getInterviewerSkillSet1())){
            addActionError("Interviewer Skill Set 1 can't be empty !!");
        }
    }
	
	@SuppressWarnings("unchecked")
	public String getInterviewerLogoutPage(){
		try{
			getGlobalContent();
			interviewer = (Interviewer) session.get("interviewer");
			if(interviewer!=null){
				urlPage = "adminLogout";
				interviewer = null;
				session.put("interviewer", interviewer);
			}else{
				urlPage = URL_PAGE_INTERVIEWER_LOGIN;
				addActionError(INTERVIEWER_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getForgotInterviewerPassword(){
		try{
			getGlobalContent();
			urlPage = "forgotInterviewerPassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getResetInterviewerPassword(){
		try{
			getGlobalContent();
			urlPage = "forgotInterviewerPassword";
			if(isEmpty(getInterviewerEmailId())){
	    		addActionError("Interviewer Email Id can't be empty !!");
	    		return "failure";
	    	}else{
				interviewer = interviewerBo.getInterviewerByEmailId(interviewerEmailId);
				if(interviewer==null){
					addActionError("interviewer not found with the Given E-mail Id!!");
					return "failure";
				}else{
					urlPage = "resetInterviewerPassword";
					UUID uuid = UUID.randomUUID();
					String verificationCode = uuid.toString().substring(0, 6);
					interviewerBo.updateInterviewer(interviewer.getInterviewerId(), verificationCode);
					Propertie propertie = propertieBo.getPropertie();
					secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.INTERVIEWER_PASSWORD_RECOVERY.getValue());
					if(propertie!=null && secureVerifyEmailSubjectBody!=null){
						
						String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", interviewerEmailId);
						String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", interviewerEmailId).replaceAll("#password#", verificationCode);
						
						SecureVerifyMail.postMail(interviewerEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
								propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
								propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
								propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
						
					}
					addActionMessage("An E-mail has been sent to your EMail Id: "+interviewerEmailId+" with Verification Code and a Link to Reset Your Password!!");
				}
	    	}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getUpdateInterviewerPasswordPage(){
		try{
			getGlobalContent();
			urlPage = "updateInterviewerPassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String changeInterviewerPassword(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_INTERVIEWER_LOGIN;
			
			changeInterviewerPasswordValidator();
			if(!hasActionErrors()){
				interviewer = interviewerBo.getInterviewerByEmailId(interviewerEmailId);
				if(interviewer==null){
					addActionError("Interviewer does not Exist with this Email Id !!");
					return "failure";
				}else{
					if(interviewer.getVerificationCode()==null){
						addActionError("Please Go To the Forgot Password Page !!");
					}else{
						if(securitycode.equals(interviewer.getVerificationCode())){
							interviewerBo.updateInterviewer(interviewer.getInterviewerId(), null, interviewerPassword);
							addActionMessage("Password Updated Successfully !!");
						}else{
							addActionError("Please Go To the Forgot Password Page !!");
							return "failure";
						}
					}
				}
			}else{
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void changeInterviewerPasswordValidator(){
        if(isEmpty(getInterviewerEmailId())){
            addActionError("Interviewer Email Id can't be empty !!");
        }
    	if(isEmpty(getSecuritycode())){
    		addActionError("Security code can't be empty !!");
    	}
    }
	
	
	
	
	

	public File getResume() {
		return resume;
	}

	public void setResume(File resume) {
		this.resume = resume;
	}

	public Integer getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
	}

	public String getInterviewerFirstName() {
		return interviewerFirstName;
	}

	public void setInterviewerFirstName(String interviewerFirstName) {
		this.interviewerFirstName = interviewerFirstName;
	}

	public String getInterviewerLastName() {
		return interviewerLastName;
	}

	public void setInterviewerLastName(String interviewerLastName) {
		this.interviewerLastName = interviewerLastName;
	}

	public String getInterviewerEmailId() {
		return interviewerEmailId;
	}

	public void setInterviewerEmailId(String interviewerEmailId) {
		this.interviewerEmailId = interviewerEmailId;
	}

	public String getInterviewerPassword() {
		return interviewerPassword;
	}

	public void setInterviewerPassword(String interviewerPassword) {
		this.interviewerPassword = interviewerPassword;
	}

	public String getInterviewerPhoneNo() {
		return interviewerPhoneNo;
	}

	public void setInterviewerPhoneNo(String interviewerPhoneNo) {
		this.interviewerPhoneNo = interviewerPhoneNo;
	}

	public String getInterviewerPhoneNoExtension() {
		return interviewerPhoneNoExtension;
	}

	public void setInterviewerPhoneNoExtension(String interviewerPhoneNoExtension) {
		this.interviewerPhoneNoExtension = interviewerPhoneNoExtension;
	}

	public String getInterviewerAlternatePhone() {
		return interviewerAlternatePhone;
	}

	public void setInterviewerAlternatePhone(String interviewerAlternatePhone) {
		this.interviewerAlternatePhone = interviewerAlternatePhone;
	}

	public String getInterviewerAlternatePhoneNoExtension() {
		return interviewerAlternatePhoneNoExtension;
	}

	public void setInterviewerAlternatePhoneNoExtension(
			String interviewerAlternatePhoneNoExtension) {
		this.interviewerAlternatePhoneNoExtension = interviewerAlternatePhoneNoExtension;
	}

	public Integer getInterviewerSkillSet1() {
		return interviewerSkillSet1;
	}

	public void setInterviewerSkillSet1(Integer interviewerSkillSet1) {
		this.interviewerSkillSet1 = interviewerSkillSet1;
	}

	public Integer getInterviewerSkillSet2() {
		return interviewerSkillSet2;
	}

	public void setInterviewerSkillSet2(Integer interviewerSkillSet2) {
		this.interviewerSkillSet2 = interviewerSkillSet2;
	}

	public Integer getInterviewerSkillSet3() {
		return interviewerSkillSet3;
	}

	public void setInterviewerSkillSet3(Integer interviewerSkillSet3) {
		this.interviewerSkillSet3 = interviewerSkillSet3;
	}

	public String getInterviewerResume() {
		return interviewerResume;
	}

	public void setInterviewerResume(String interviewerResume) {
		this.interviewerResume = interviewerResume;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public Integer getLocationScheduleTimingId() {
		return locationScheduleTimingId;
	}

	public void setLocationScheduleTimingId(Integer locationScheduleTimingId) {
		this.locationScheduleTimingId = locationScheduleTimingId;
	}

	public Date getLocationScheduleFromTime() {
		return locationScheduleFromTime;
	}

	public void setLocationScheduleFromTime(Date locationScheduleFromTime) {
		this.locationScheduleFromTime = locationScheduleFromTime;
	}

	public Date getLocationScheduleToTime() {
		return locationScheduleToTime;
	}

	public void setLocationScheduleToTime(Date locationScheduleToTime) {
		this.locationScheduleToTime = locationScheduleToTime;
	}

	public Integer getCandidateScheduleTimingId() {
		return candidateScheduleTimingId;
	}

	public void setCandidateScheduleTimingId(Integer candidateScheduleTimingId) {
		this.candidateScheduleTimingId = candidateScheduleTimingId;
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

	public LocationScheduleTiming getLocationScheduleTiming() {
		return locationScheduleTiming;
	}

	public void setLocationScheduleTiming(
			LocationScheduleTiming locationScheduleTiming) {
		this.locationScheduleTiming = locationScheduleTiming;
	}

	public CandidateScheduleTiming getCandidateScheduleTiming() {
		return candidateScheduleTiming;
	}

	public void setCandidateScheduleTiming(
			CandidateScheduleTiming candidateScheduleTiming) {
		this.candidateScheduleTiming = candidateScheduleTiming;
	}

	public List<LocationScheduleTiming> getLocationScheduleTimingList() {
		return locationScheduleTimingList;
	}

	public void setLocationScheduleTimingList(
			List<LocationScheduleTiming> locationScheduleTimingList) {
		this.locationScheduleTimingList = locationScheduleTimingList;
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingList() {
		return candidateScheduleTimingList;
	}

	public void setCandidateScheduleTimingList(
			List<CandidateScheduleTiming> candidateScheduleTimingList) {
		this.candidateScheduleTimingList = candidateScheduleTimingList;
	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(SkillSet skillSet) {
		this.skillSet = skillSet;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public List<SkillSet> getSkillSetList() {
		return skillSetList;
	}

	public void setSkillSetList(List<SkillSet> skillSetList) {
		this.skillSetList = skillSetList;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public String getScheduleFromTime() {
		return scheduleFromTime;
	}

	public void setScheduleFromTime(String scheduleFromTime) {
		this.scheduleFromTime = scheduleFromTime;
	}

	public String getScheduleToTime() {
		return scheduleToTime;
	}

	public void setScheduleToTime(String scheduleToTime) {
		this.scheduleToTime = scheduleToTime;
	}

	public Integer getSkillSetId() {
		return skillSetId;
	}

	public void setSkillSetId(Integer skillSetId) {
		this.skillSetId = skillSetId;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	
	
	
}
