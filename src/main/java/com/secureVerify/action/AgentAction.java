package com.secureVerify.action;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.secureVerify.model.Agent;
import com.secureVerify.model.Candidate;
import com.secureVerify.model.CandidateScheduleTiming;
import com.secureVerify.model.Employer;
import com.secureVerify.model.InterviewStatus;
import com.secureVerify.model.Interviewer;
import com.secureVerify.model.Location;
import com.secureVerify.model.LocationScheduleTiming;
import com.secureVerify.model.Propertie;
import com.secureVerify.model.SecureVerifyEmailType;
import com.secureVerify.model.SkillSet;
import com.secureVerify.model.User;
import com.secureVerify.util.DateHelper;
import com.secureVerify.util.SecureVerifyMail;

public class AgentAction extends MasterAction {

	private static final long serialVersionUID = 9197120911064999578L;
	
	private static final Logger log = Logger.getLogger(AgentAction.class);
	private static final String AGENT_LOGIN_MSG = "Please Login into Agent !!";
	private static final String URL_PAGE_AGENT_LOGIN = "adminLogin";

	// Agent
	private Integer agentId;
	private String agentEmailId;
	private String agentPassword;
	private String currentPassword;
	private String retypePassword;

	private Integer locationId;

	// LocationScheduleTiming
	private Integer locationScheduleTimingId;
	private Date locationScheduleFromTime;
	private Date locationScheduleToTime;
	
	// CandidateScheduleTiming
	private Integer candidateScheduleTimingId;
	private Integer candidateId;
	private Integer interviewerId;
	private Date candidateScheduleFromTime;
	private Date candidateScheduleToTime;
	private String candidateFeedback;
	private Integer candidatePerformance;
	private Integer interviewStatus;
	
	// Agent
	private String agentFirstName;
	private String agentLastName;
	private String agentPhoneNo;
	private String agentPhoneNoExtension;
	private String agentAlternatePhone;
	private String agentAlternatePhoneNoExtension;
	private String agentMarket1;
	private String agentMarket2;
	private String agentMarket3;
	private String agentAddressLine1;
	private String agentAddressLine2;
	private String agentCity;
	private String agentState;
	private String agentCountry;
	private String agentZipcode;
		
	// Classes
	private Agent agent;
	private Agent vAgent;
	private Location location;
	private Candidate candidate;
	private SkillSet skillSet;
	private List<SkillSet> skillSetList;
	private Interviewer interviewer;
	private LocationScheduleTiming locationScheduleTiming;
	private CandidateScheduleTiming candidateScheduleTiming;
	private User vUser;

	private String scheduleFromTime;
	private String scheduleToTime;
		
	// List
	private List<Agent> agentList;
	private List<Location> locationList;
	private List<Employer> employerList;
	private List<LocationScheduleTiming> locationScheduleTimingList;
	private List<CandidateScheduleTiming> candidateScheduleTimingList;
	
	
	// Agent Login
	
	@SuppressWarnings("unchecked")
	public String authenticateAgent(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_AGENT_LOGIN;
			
			authenticateAgentValidator();
			if(!hasActionErrors()){
				agent = agentBo.getAgent(agentEmailId, agentPassword);
				if(agent!=null){
					session.put("agent", agent);
				}else{
					addActionError("Agent doen't found with given Email Id and Password!!");
					return "failure";
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

    public void authenticateAgentValidator(){
        if(isEmpty(getAgentEmailId())){
    		addActionError("Agent Email Id can't be empty !!");
    	}
    	if(isEmpty(getAgentPassword())){
    		addActionError("Agent Password can't be empty !!");
    	}
    }
	
	
	// Agent Location
	
	public String getAgentLocationPage(){
		try{
			getGlobalContent();
			urlPage = "agentLocation";
			agent = (Agent) session.get("agent");
			if(agent!=null){
				locationList = locationBo.getLocationByAgentId(agent.getAgentId());
				if(locationList!=null && !locationList.isEmpty()){
					totalSize = locationList.size();
					for(Location tmpLocation : locationList){
						vAgent = agentBo.getAgentByAgentId(tmpLocation.getLocationPrimaryAgentId());
						if(vAgent!=null){
							tmpLocation.setLocationPrimaryAgentName(vAgent.getAgentFirstName()+" "+vAgent.getAgentLastName());
						}
						if(tmpLocation.getLocationSecondaryAgentId()!=null && tmpLocation.getLocationSecondaryAgentId()!=0){
							vAgent = agentBo.getAgentByAgentId(tmpLocation.getLocationSecondaryAgentId());
							if(vAgent!=null){
								tmpLocation.setLocationSecondaryAgentName(vAgent.getAgentFirstName()+" "+vAgent.getAgentLastName());
							}
						}
						vUser = userBo.getUser(tmpLocation.getCreatedBy());
						if(vUser!=null){
							tmpLocation.setCreatedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
						vUser = userBo.getUser(tmpLocation.getLastModifiedBy());
						if(vUser!=null){
							tmpLocation.setLastModifiedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
					}
				}else{
					totalSize = 0;
					addActionError("No Location is Mapped to the Agent !!");
					return "failure";
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewLocationDetails(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentLocation";
				if(isNumberNullOrZero(getLocationId())){
					addActionError("Location Id can't be Empty / Zero !!");
					return ERROR;
				}else{
					location = locationBo.getLocationByLocationId(locationId);
					if(location!=null){
						vAgent = agentBo.getAgentByAgentId(location.getLocationPrimaryAgentId());
						if(vAgent!=null){
							location.setLocationPrimaryAgentName(vAgent.getAgentFirstName()+" "+vAgent.getAgentLastName());
						}
						if(location.getLocationSecondaryAgentId()!=null && location.getLocationSecondaryAgentId()!=0){
							vAgent = agentBo.getAgentByAgentId(location.getLocationSecondaryAgentId());
							if(vAgent!=null){
								location.setLocationSecondaryAgentName(vAgent.getAgentFirstName()+" "+vAgent.getAgentLastName());
							}
						}
						vUser = userBo.getUser(location.getCreatedBy());
						if(vUser!=null){
							location.setCreatedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
						vUser = userBo.getUser(location.getLastModifiedBy());
						if(vUser!=null){
							location.setLastModifiedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
					}else{
						totalSize = 0;
						addActionError("Location is not present with the given Location Id !!");
						return ERROR;
					}
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Agent Schedule Timings
	
	public String getAgentScheduleTimingsPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentScheduleTimings";
				List<Integer> locationIds = locationBo.getLocationIdsByAgentId(agent.getAgentId());
				if(locationIds!=null && !locationIds.isEmpty()){
					totalSize = locationScheduleTimingBo.getLocationScheduleTimingListCountByLocationIds(locationIds);
				
					if(pageNo==null || pageNo==0){
						pageNo = 1;
					}
					
					noOfPages = totalSize/pageSize;
					if((totalSize%pageSize) > 0){
						noOfPages++;
					}
					
					final Integer startRecord = (pageNo-1)*pageSize;
					
					locationScheduleTimingList = locationScheduleTimingBo.getLocationScheduleTimingListByLocationIdListPage(locationIds, startRecord, pageSize);
					
					if(locationScheduleTimingList!=null && !locationScheduleTimingList.isEmpty()){
						for(LocationScheduleTiming locationScheduleTiming : locationScheduleTimingList){
							location = locationBo.getLocationByLocationId(locationScheduleTiming.getLocationId());
							locationScheduleTiming.setLocation(location);
						}
					}
				}else{
					totalSize = 0;
				}
				
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAgentAddScheduleTimingsPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentScheduleTimings";
				locationList = locationBo.getLocationByAgentId(agent.getAgentId());
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String saveAgentScheduleTimings(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentScheduleTimings";
				
				saveAgentScheduleTimingsValidator();
				if(!hasActionErrors()){
					
					locationScheduleFromTime = DateHelper.getUtilDateTimeFromString(scheduleFromTime);
					locationScheduleToTime = DateHelper.getUtilDateTimeFromString(scheduleToTime);
					
					if(locationScheduleFromTime==null){
						addActionError("Can't get Date from Schedule From Time !!");
			    	}
					if(locationScheduleToTime==null){
						addActionError("Can't get Date from Schedule To Time !!");
			    	}
					
					if(!hasActionErrors()){
						locationScheduleTiming = new LocationScheduleTiming();
						locationScheduleTiming.setLocationId(locationId);
						locationScheduleTiming.setLocationScheduleFromTime(locationScheduleFromTime);
						locationScheduleTiming.setLocationScheduleToTime(locationScheduleToTime);
						locationScheduleTiming.setCreatedBy(agent.getAgentId());
						locationScheduleTiming.setLastModifiedBy(agent.getAgentId());
						locationScheduleTiming.setCreationDate(new Date());
						locationScheduleTiming.setLastModifiedTime(new Date());
						locationScheduleTiming.setStatus(ACTIVE);
						locationScheduleTimingBo.addLocationScheduleTiming(locationScheduleTiming);
					}else{
		            	return "scheduleTimings";
		            }
				}else{
					return "scheduleTimings";
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveAgentScheduleTimingsValidator(){
    	if(isNumberNullOrZero(getLocationId())){
			addActionError("Location Id can't be Empty / Zero !!");
    	}
        if(isEmpty(getScheduleFromTime())){
    		addActionError("Schedule From Time can't be empty !!");
    	}
    	if(isEmpty(getScheduleToTime())){
    		addActionError("Schedule To Time can't be empty !!");
    	}
    }
	
	public String getAgentEditScheduleTimingsPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null && locationScheduleTimingId!=null && locationScheduleTimingId!=0){
				urlPage = "agentScheduleTimings";
				if(!isNumberNullOrZero(getLocationId())){
					addActionError("Location Schedule Timing Id can't be Empty / Zero !!");
					return INPUT;
				}else{
					locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(locationScheduleTimingId);
					if(locationScheduleTiming==null){
						addActionError("Location Schedule Timing Does Not Exist with the Given Location Schedule Timing Id !!");
					}
					locationList = locationBo.getLocationByAgentId(locationScheduleTiming.getLastModifiedBy());
					location = locationBo.getLocationByLocationId(locationScheduleTiming.getLocationId());
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateAgentScheduleTimings(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentScheduleTimings";
				
				updateAgentScheduleTimingsValidator();
				if(!hasActionErrors()){
					locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(locationScheduleTimingId);
					if(locationScheduleTiming==null){
						addActionError("Location Schedule Timing Does Not Exist with the Given Location Schedule Timing Id !!");
						return "scheduleTimings";
					}else{
						locationScheduleFromTime = DateHelper.getUtilDateTimeFromString(scheduleFromTime);
						locationScheduleToTime = DateHelper.getUtilDateTimeFromString(scheduleToTime);

						if(locationScheduleFromTime==null){
							addActionError("Can't get Date from Schedule From Time !!");
				    	}
						if(locationScheduleToTime==null){
							addActionError("Can't get Date from Schedule To Time !!");
				    	}
						
						if(!hasActionErrors()){
			            	locationScheduleTiming.setLocationId(locationId);
			            	locationScheduleTiming.setLocationScheduleFromTime(locationScheduleFromTime);
			            	locationScheduleTiming.setLocationScheduleToTime(locationScheduleToTime);
			            	locationScheduleTiming.setLastModifiedBy(agent.getAgentId());
			            	locationScheduleTiming.setLastModifiedTime(new Date());
			            	locationScheduleTiming.setStatus(ACTIVE);
			            	locationScheduleTimingBo.updateLocationScheduleTiming(locationScheduleTiming);
							
			            }else{
			            	
			            	locationList = locationBo.getLocationByAgentId(agent.getAgentId());
			            	return "scheduleTimings";
			            }
			            
					}
				}else{
					return "scheduleTimings";
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateAgentScheduleTimingsValidator(){
    	if(isNumberNullOrZero(getLocationScheduleTimingId())){
			addActionError("Location Schedule Timing Id can't be Empty / Zero !!");
    	}
        if(isEmpty(getScheduleFromTime())){
    		addActionError("Schedule From Time can't be empty !!");
    	}
    	if(isEmpty(getScheduleToTime())){
    		addActionError("Schedule To Time can't be empty !!");
    	}
    }
	
	public String viewAgentScheduleTiming(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null && locationScheduleTimingId!=null && locationScheduleTimingId!=0){
				urlPage = "agentScheduleTimings";
				
				if(isNumberNullOrZero(getLocationScheduleTimingId())){
					addActionError("Location Schedule Timing Id can't be Empty / Zero !!");
		    	}else{
					locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(locationScheduleTimingId);
					if(locationScheduleTiming==null){
						addActionError("Location Schedule Timing Does Not Exist with the Given Location Schedule Timing Id !!");
					}else{
						vAgent = agentBo.getAgentByAgentId(locationScheduleTiming.getCreatedBy());
						if(vAgent!=null){
							locationScheduleTiming.setCreatedByName(vAgent.getAgentFirstName()+" "+ vAgent.getAgentLastName());
						}
						vAgent = agentBo.getAgentByAgentId(locationScheduleTiming.getLastModifiedBy());
						if(vAgent!=null){
							locationScheduleTiming.setLastModifiedByName(vAgent.getAgentFirstName()+" "+ vAgent.getAgentLastName());
						}
						locationList = locationBo.getLocationByAgentId(locationScheduleTiming.getLastModifiedBy());
						location = locationBo.getLocationByLocationId(locationScheduleTiming.getLocationId());						
					}
		    	}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteAgentScheduleTiming(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentScheduleTimings";
				if(isNumberNullOrZero(getUniqueId())){
					addActionError("Location Schedule Timing Id can't be Empty / Zero !!");
				}else{
					locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(uniqueId);
					if(locationScheduleTiming==null){
						addActionError("Location Schedule Timing Does Not Exist with the Given Location Schedule Timing Id !!");
					}else{
						locationScheduleTimingBo.deleteLocationScheduleTiming(locationScheduleTiming);
					}
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Agent Interview Applied Candidates

	public String getAgentInterviewAppliedCandidatesPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewAppliedCandidates";
				List<Integer> locationIds = locationBo.getLocationIdsByAgentId(agent.getAgentId());
				if(locationIds!=null && !locationIds.isEmpty()){
					totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByLocationIdListInterviewStatusListCount(locationIds, InterviewStatus.APPLIED.getValue());
					if(pageNo==null || pageNo==0){
						pageNo = 1;
					}
					
					noOfPages = totalSize/pageSize;
					if((totalSize%pageSize) > 0){
						noOfPages++;
					}
					
					final Integer startRecord = (pageNo-1)*pageSize;
					skillSetList = skillSetBo.listActiveSkillSet();
					
					candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, locationIds, 
							null, null, null, null, null, null, null, null, null, null, InterviewStatus.APPLIED.getValue(), null, null, 
							null, null, null, null, null, startRecord, pageSize);
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
					totalSize = 0;
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAgentEditInterviewAppliedCandidatesPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewAppliedCandidates";
				
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
					}else{
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
						}
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						locationScheduleTimingList = locationScheduleTimingBo.searchLocationScheduleTiming(null, candidateScheduleTiming.getLocationId(), DateHelper.getCurrentUtilDate(), DateHelper.addTwoDaysToDate(), null, null, null, null, ACTIVE, 0, 10);
						for(LocationScheduleTiming locationScheduleTiming : locationScheduleTimingList){
							if(locationScheduleTiming.getLocationScheduleTimingId().equals(candidateScheduleTiming.getLocationScheduleTimingId())){
								locationScheduleTimingList.remove(locationScheduleTiming);
								break;
							}
						}
					}
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateAgentInterviewAppliedCandidates(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewAppliedCandidates";
				
				updateAgentInterviewAppliedCandidatesValidator();
				if(!hasActionErrors()){
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return "agentInterviewAppliedCandidate";
					}else{
						locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(locationScheduleTimingId);
						if(locationScheduleTiming==null){
							addActionError("Invalid Schedule Time. No Location Schedule Timing Exist with the Location Schedule Timing Id !!");
							return "agentInterviewAppliedCandidate";
						}
						candidateScheduleTiming.setLocationScheduleTimingId(locationScheduleTimingId);
						candidateScheduleTiming.setCandidateScheduleFromTime(locationScheduleTiming.getLocationScheduleFromTime());
						candidateScheduleTiming.setCandidateScheduleToTime(locationScheduleTiming.getLocationScheduleToTime());
						candidateScheduleTimingBo.updateCandidateScheduleTiming(candidateScheduleTiming);
					}
				}else{
					return "agentInterviewAppliedCandidate";
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateAgentInterviewAppliedCandidatesValidator(){
        if(isNumberNullOrZero(getCandidateScheduleTimingId())){
    		addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
    	}
    	if(isNumberNullOrZero(getLocationScheduleTimingId())){
			addActionError("Location Schedule Timing Id can't be Empty / Zero !!");
    	}
    }
	
	public String viewAgentInterviewAppliedCandidates(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewAppliedCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
					}else{
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
						}
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
					}
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Agent Interview Scheduled Candidates

	public String getAgentInterviewerScheduledCandidatesPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewerScheduledCandidates";
				List<Integer> locationIds = locationBo.getLocationIdsByAgentId(agent.getAgentId());
				if(locationIds!=null && !locationIds.isEmpty()){
					totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByLocationIdListInterviewStatusListCount(locationIds, InterviewStatus.SCHEDULED.getValue());
					if(pageNo==null || pageNo==0){
						pageNo = 1;
					}
					
					noOfPages = totalSize/pageSize;
					if((totalSize%pageSize) > 0){
						noOfPages++;
					}
					
					final Integer startRecord = (pageNo-1)*pageSize;
					skillSetList = skillSetBo.listActiveSkillSet();
					
					candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, locationIds, 
							null, null, null, null, null, null, null, null, null, null, InterviewStatus.SCHEDULED.getValue(), null, null, 
							null, null, null, null, null, startRecord, pageSize);
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
							interviewer = interviewerBo.getInterviewerByInterviewerId(tmpCandidateScheduleTiming.getInterviewerId());
							if(interviewer!=null){
								tmpCandidateScheduleTiming.setInterviewer(interviewer);
							}
						}
					}
				}else{
					totalSize = 0;
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewAgentInterviewerScheduledCandidates(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewerScheduledCandidates";
				
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
					}else{
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
						}
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						skillSetList = skillSetBo.listActiveSkillSet();
					}
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAgentEditInterviewerScheduledCandidatesPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewerScheduledCandidates";
				
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
					}else{
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						if(candidate!=null){
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
						}
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						locationScheduleTimingList = locationScheduleTimingBo.searchLocationScheduleTiming(null, candidateScheduleTiming.getLocationId(), DateHelper.getCurrentUtilDate(), DateHelper.addTwoDaysToDate(), null, null, null, null, ACTIVE, 0, 10);
						for(LocationScheduleTiming locationScheduleTiming : locationScheduleTimingList){
							if(locationScheduleTiming.getLocationScheduleTimingId().equals(candidateScheduleTiming.getLocationScheduleTimingId())){
								locationScheduleTimingList.remove(locationScheduleTiming);
								break;
							}
						}
					}
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateAgentInterviewerScheduledCandidates(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewerScheduledCandidates";
				
				updateAgentInterviewerScheduledCandidatesValidator();
				if(!hasActionErrors()){
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return "agentInterviewerScheduledCandidates";
					}else{
						
						locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(locationScheduleTimingId);
						if(locationScheduleTiming==null){
							addActionError("Invalid Schedule Time. No Location Schedule Timing Exist with the Location Schedule Timing Id !!");
							return "agentInterviewerScheduledCandidates";
						}
						candidateScheduleTiming.setLocationId(locationScheduleTiming.getLocationId());
						candidateScheduleTiming.setLocationScheduleTimingId(locationScheduleTimingId);
						candidateScheduleTiming.setCandidateScheduleFromTime(locationScheduleTiming.getLocationScheduleFromTime());
						candidateScheduleTiming.setCandidateScheduleToTime(locationScheduleTiming.getLocationScheduleToTime());
						candidateScheduleTimingBo.updateCandidateScheduleTiming(candidateScheduleTiming);
								            
					}
				}else{
					return "agentInterviewerScheduledCandidates";
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateAgentInterviewerScheduledCandidatesValidator(){
        if(isNumberNullOrZero(getCandidateScheduleTimingId())){
    		addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
    	}
    	if(isNumberNullOrZero(getLocationScheduleTimingId())){
			addActionError("Location Schedule Timing Id can't be Empty / Zero !!");
    	}
    }
	
	
	// Agent Interviewed Candidates

	public String getAgentInterviewedCandidatesPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewedCandidates";
				List<Integer> locationIds = locationBo.getLocationIdsByAgentId(agent.getAgentId());
				if(locationIds!=null && !locationIds.isEmpty()){
					totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByLocationIdListInterviewStatusListCount(locationIds, InterviewStatus.INTERVIEWED.getValue());
					if(pageNo==null || pageNo==0){
						pageNo = 1;
					}
					
					noOfPages = totalSize/pageSize;
					if((totalSize%pageSize) > 0){
						noOfPages++;
					}
					
					final Integer startRecord = (pageNo-1)*pageSize;
					skillSetList = skillSetBo.listActiveSkillSet();
					
					candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, locationIds, 
							null, null, null, null, null, null, null, null, null, null, InterviewStatus.INTERVIEWED.getValue(), null, null, 
							null, null, null, null, null, startRecord, pageSize);
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
							interviewer = interviewerBo.getInterviewerByInterviewerId(tmpCandidateScheduleTiming.getInterviewerId());
							if(interviewer!=null){
								tmpCandidateScheduleTiming.setInterviewer(interviewer);
							}
						}
					}
				}else{
					totalSize = 0;
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewAgentInterviewedCandidates(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentInterviewedCandidates";
				
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
					return ERROR;
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming==null){
						addActionError("Candidate Schedule Timing Does Not Exist with the Given Candidate Schedule Timing Id !!");
						return ERROR;
					}else{
						
						feedbackList = feedbackBo.getFeedbacksByCandidateScheduleTimingId(candidateScheduleTimingId);
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						
						if(candidate!=null){
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
						}
						
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						skillSetList = skillSetBo.listActiveSkillSet();
						
					}
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Agent Profile
	
	public String getEditAgentPasswordPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentPassword";
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String agentUpdatePassword(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentPassword";
				
				agentUpdatePasswordValidator();
				if(!hasActionErrors()){
					if(agent.getAgentPassword().equals(currentPassword)){
						agent.setAgentPassword(agentPassword);
						agentBo.updateAgent(agent);
						session.put("agent", agent);
						
						addActionMessage("Updated Password Successfully !!");
					}else{
						addActionError("Your Current Password is Invalid !!");
						return "failure";
					}
				}else{
					addActionError("Invalid Form Fields !!");
					return "failure";
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void agentUpdatePasswordValidator(){
        if(isEmpty(getCurrentPassword())){
    		addActionError("Current Password can't be empty !!");
    	}
    	if(isEmpty(getAgentPassword())){
			addActionError("New Password can't be empty !!");
    	}
    	if(isEmpty(getRetypePassword())){
			addActionError("Retype Password can't be empty !!");
    	}
    	if(!isEmpty(getAgentPassword()) && !isEmpty(getRetypePassword()) && !getAgentPassword().equals(getRetypePassword())){
			addActionError("New Password and Retype Password Must be Same !!");
    	}
    }
	
	public String getEditAgentProfilePage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentProfile";
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String agentUpdateProfile(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "agentProfile";
				
				agentUpdateProfileValidator();
				if(!hasActionErrors()){
					
					agent.setAgentFirstName(agentFirstName);
					agent.setAgentLastName(agentLastName);
					agent.setAgentPhoneNo(agentPhoneNo);
					agent.setAgentPhoneNoExtension(agentPhoneNoExtension);
					agent.setAgentAlternatePhone(agentAlternatePhone);
					agent.setAgentAlternatePhoneNoExtension(agentAlternatePhoneNoExtension);
					agent.setAgentMarket1(agentMarket1);
					agent.setAgentMarket2(agentMarket2);
					agent.setAgentMarket3(agentMarket3);
					agent.setAgentAddressLine1(agentAddressLine1);
					agent.setAgentAddressLine2(agentAddressLine2);
					agent.setAgentCity(agentCity);
					agent.setAgentState(agentState);
					agent.setAgentCountry(agentCountry);
					agent.setAgentZipcode(agentZipcode);
					agent.setLastModifiedTime(new Date());
					agentBo.updateAgent(agent);
					
					addActionMessage("Profile Updated Successfully !!");
					
				}else{
					return "agent";
				}
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void agentUpdateProfileValidator(){
        if(isEmpty(getAgentFirstName())){
            addActionError("Agent First Name can't be empty !!");
        }
    	if(isEmpty(getAgentLastName())){
    		addActionError("Agent Last Name can't be empty !!");
    	}
        if(isEmpty(getAgentPhoneNo())){
            addActionError("Agent Phone No can't be empty !!");
        }
        if(isEmpty(getAgentMarket1())){
            addActionError("Agent Market 1 can't be empty !!");
        }
        if(isEmpty(getAgentAddressLine1())){
            addActionError("Agent Address Line 1 can't be empty !!");
        }
        if(isEmpty(getAgentCity())){
            addActionError("Agent City can't be empty !!");
        }
        if(isEmpty(getAgentState())){
            addActionError("Agent State can't be empty !!");
        }
        if(isEmpty(getAgentCountry())){
            addActionError("Agent Country can't be empty !!");
        }
        if(isEmpty(getAgentZipcode())){
            addActionError("Agent Zipcode can't be empty  !!");
        }
    }
	
	@SuppressWarnings("unchecked")
	public String getAgentLogoutPage(){
		try{
			getGlobalContent();
			agent = (Agent) session.get("agent");
			if(agent!=null){
				urlPage = "adminLogout";
				agent = null;
				session.put("agent", agent);
			}else{
				urlPage = URL_PAGE_AGENT_LOGIN;
				addActionError(AGENT_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getForgotAgentPassword(){
		try{
			getGlobalContent();
			urlPage = "forgotAgentPassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getResetAgentPassword(){
		try{
			getGlobalContent();
			urlPage = "forgotAgentPassword";
			if(isEmpty(getAgentEmailId())){
	    		addActionError("Agent Email Id can't be empty !!");
	    		return "failure";
	    	}else{
				agent = agentBo.getAgentByEmailId(agentEmailId);
				if(agent==null){
					addActionError("Invalid E-mail Id!!");
					return "failure";
				}else{
					urlPage = "resetAgentPassword";
					UUID uuid = UUID.randomUUID();
					String verificationCode = uuid.toString().substring(0, 6);
					agentBo.updateAgent(agent.getAgentId(), verificationCode);
					Propertie propertie = propertieBo.getPropertie();
					secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.AGENT_PASSWORD_RECOVERY.getValue());
					if(propertie!=null && secureVerifyEmailSubjectBody!=null){
						
						String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", agentEmailId);
						String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", agentEmailId).replaceAll("#password#", verificationCode);
						
						SecureVerifyMail.postMail(agentEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
								propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
								propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
								propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
						
					}
					addActionMessage("An E-mail has been sent to your Email Id: "+agentEmailId+" with Verification Code and a Link to Reset Your Password!!");
				}
	    	}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getUpdateAgentPasswordPage(){
		try{
			getGlobalContent();
			urlPage = "updateAgentPassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String changeAgentPassword(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_AGENT_LOGIN;
			
			changeAgentPasswordValidator();
			if(!hasActionErrors()){
				agent = agentBo.getAgentByEmailId(agentEmailId);
				if(agent==null){
					addActionError("Agent does not Exist with this Email Id !!");
					return "failure";
				}else{
					if(agent.getVerificationCode()==null){
						addActionError("Please Go To the Forgot Password Page !!");
					}else{
						if(securitycode.equals(agent.getVerificationCode())){
							agentBo.updateAgent(agent.getAgentId(), null, agentPassword);
							addActionMessage("Password Updated Successfully!!");
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

    public void changeAgentPasswordValidator(){
        if(isEmpty(getAgentEmailId())){
            addActionError("Agent Email Id can't be empty !!");
        }
    	if(isEmpty(getSecuritycode())){
    		addActionError("Security code can't be empty !!");
    	}
    }
	
	
	
	
	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getAgentEmailId() {
		return agentEmailId;
	}

	public void setAgentEmailId(String agentEmailId) {
		this.agentEmailId = agentEmailId;
	}

	public String getAgentPassword() {
		return agentPassword;
	}

	public void setAgentPassword(String agentPassword) {
		this.agentPassword = agentPassword;
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

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Agent getvAgent() {
		return vAgent;
	}

	public void setvAgent(Agent vAgent) {
		this.vAgent = vAgent;
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

	public void setLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming) {
		this.locationScheduleTiming = locationScheduleTiming;
	}

	public User getvUser() {
		return vUser;
	}

	public void setvUser(User vUser) {
		this.vUser = vUser;
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

	public List<Agent> getAgentList() {
		return agentList;
	}

	public void setAgentList(List<Agent> agentList) {
		this.agentList = agentList;
	}

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	public List<LocationScheduleTiming> getLocationScheduleTimingList() {
		return locationScheduleTimingList;
	}

	public void setLocationScheduleTimingList(List<LocationScheduleTiming> locationScheduleTimingList) {
		this.locationScheduleTimingList = locationScheduleTimingList;
	}

	public CandidateScheduleTiming getCandidateScheduleTiming() {
		return candidateScheduleTiming;
	}

	public void setCandidateScheduleTiming(
			CandidateScheduleTiming candidateScheduleTiming) {
		this.candidateScheduleTiming = candidateScheduleTiming;
	}

	public List<CandidateScheduleTiming> getCandidateScheduleTimingList() {
		return candidateScheduleTimingList;
	}

	public void setCandidateScheduleTimingList(
			List<CandidateScheduleTiming> candidateScheduleTimingList) {
		this.candidateScheduleTimingList = candidateScheduleTimingList;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(SkillSet skillSet) {
		this.skillSet = skillSet;
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

	public Integer getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
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

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getAgentFirstName() {
		return agentFirstName;
	}

	public void setAgentFirstName(String agentFirstName) {
		this.agentFirstName = agentFirstName;
	}

	public String getAgentLastName() {
		return agentLastName;
	}

	public void setAgentLastName(String agentLastName) {
		this.agentLastName = agentLastName;
	}

	public String getAgentPhoneNo() {
		return agentPhoneNo;
	}

	public void setAgentPhoneNo(String agentPhoneNo) {
		this.agentPhoneNo = agentPhoneNo;
	}

	public String getAgentPhoneNoExtension() {
		return agentPhoneNoExtension;
	}

	public void setAgentPhoneNoExtension(String agentPhoneNoExtension) {
		this.agentPhoneNoExtension = agentPhoneNoExtension;
	}

	public String getAgentAlternatePhone() {
		return agentAlternatePhone;
	}

	public void setAgentAlternatePhone(String agentAlternatePhone) {
		this.agentAlternatePhone = agentAlternatePhone;
	}

	public String getAgentAlternatePhoneNoExtension() {
		return agentAlternatePhoneNoExtension;
	}

	public void setAgentAlternatePhoneNoExtension(
			String agentAlternatePhoneNoExtension) {
		this.agentAlternatePhoneNoExtension = agentAlternatePhoneNoExtension;
	}

	public String getAgentMarket1() {
		return agentMarket1;
	}

	public void setAgentMarket1(String agentMarket1) {
		this.agentMarket1 = agentMarket1;
	}

	public String getAgentMarket2() {
		return agentMarket2;
	}

	public void setAgentMarket2(String agentMarket2) {
		this.agentMarket2 = agentMarket2;
	}

	public String getAgentMarket3() {
		return agentMarket3;
	}

	public void setAgentMarket3(String agentMarket3) {
		this.agentMarket3 = agentMarket3;
	}

	public String getAgentAddressLine1() {
		return agentAddressLine1;
	}

	public void setAgentAddressLine1(String agentAddressLine1) {
		this.agentAddressLine1 = agentAddressLine1;
	}

	public String getAgentAddressLine2() {
		return agentAddressLine2;
	}

	public void setAgentAddressLine2(String agentAddressLine2) {
		this.agentAddressLine2 = agentAddressLine2;
	}

	public String getAgentCity() {
		return agentCity;
	}

	public void setAgentCity(String agentCity) {
		this.agentCity = agentCity;
	}

	public String getAgentState() {
		return agentState;
	}

	public void setAgentState(String agentState) {
		this.agentState = agentState;
	}

	public String getAgentCountry() {
		return agentCountry;
	}

	public void setAgentCountry(String agentCountry) {
		this.agentCountry = agentCountry;
	}

	public String getAgentZipcode() {
		return agentZipcode;
	}

	public void setAgentZipcode(String agentZipcode) {
		this.agentZipcode = agentZipcode;
	}

	public List<SkillSet> getSkillSetList() {
		return skillSetList;
	}

	public void setSkillSetList(List<SkillSet> skillSetList) {
		this.skillSetList = skillSetList;
	}

	public List<Employer> getEmployerList() {
		return employerList;
	}

	public void setEmployerList(List<Employer> employerList) {
		this.employerList = employerList;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	
}
