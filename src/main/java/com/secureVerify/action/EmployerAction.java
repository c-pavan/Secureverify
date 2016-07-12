package com.secureVerify.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.secureVerify.model.Candidate;
import com.secureVerify.model.CandidateEmployerSkillSetMap;
import com.secureVerify.model.CandidateScheduleTiming;
import com.secureVerify.model.Coupon;
import com.secureVerify.model.CreditTypes;
import com.secureVerify.model.CreditsAvailable;
import com.secureVerify.model.Employer;
import com.secureVerify.model.InterviewStatus;
import com.secureVerify.model.Interviewer;
import com.secureVerify.model.Location;
import com.secureVerify.model.PaymentDetail;
import com.secureVerify.model.SecureVerifyEmailType;
import com.secureVerify.model.SkillSet;
import com.secureVerify.util.SecureVerifyMail;

public class EmployerAction extends MasterAction {
	
	private static final long serialVersionUID = 229247085355018446L;
	
	private static final Logger log = Logger.getLogger(EmployerAction.class);
	
	private Integer paymentDetailsId;
	
	private String retypePassword;
	
	// Employer
	private Integer employerId;
	private String employerEmailId;
	private String employerPassword;
	private String currentPassword;
	private String employerFirstName;
	private String employerLastName;
	private String employerPhoneNo;
	private String employerPhoneNoExtension;
	private String employerAlternatePhone;
	private String employerAlternatePhoneNoExtension;
	private String employerCompanyName;
	private String employerTitle;
	private String employerAddressLine1;
	private String employerAddressLine2;
	private String employerCity;
	private String employerState;
	private String employerCountry;
	private String employerZipcode;
	
	// Candidate
	private Integer candidateId;
	private String candidateFirstName;
	private String candidateLastName;
	private String candidateEmailId;
	private String candidatePhoneNo;
	private String candidatePhoneNoExtension;
	private String candidateAlternatePhone;
	private String candidateAlternatePhoneNoExtension;
	private Integer skillSetId;
	private Integer fskillSetId;
	private String verifyPassword;
	private Date candidateScheduleFromTime;
	private Date candidateScheduleToTime;
	private Integer locationId;
	
	private Integer candidateScheduleTimingId;
	private Integer candidateEmployerSkillSetMapId;
	
	private Employer employer;
	private Candidate candidate;
	private CreditsAvailable creditsAvailable;
	private CreditsAvailable candidateCreditsAvailable;
	private CreditTypes creditTypes;
	private CandidateEmployerSkillSetMap candidateEmployerSkillSetMap;
	private List<CandidateEmployerSkillSetMap> candidateEmployerSkillSetMapList;
	private SkillSet skillSet;
	private Location location;
	private Interviewer interviewer;
	private CandidateScheduleTiming candidateScheduleTiming;
	private List<SkillSet> skillSetList;
	private List<Location> locationList;
	private List<Candidate> candidateList;
	private List<CandidateScheduleTiming> candidateScheduleTimingList;
	private List<PaymentDetail> paymentDetailList;
	private Integer noOfCreditsBought;
	private Date paymentDate;
	
	private PaymentDetail paymentDetail;
	private Integer partyTypeId;
	
	private Coupon coupon;
	private Integer couponId;
	private String transactionNumber;
	private String invoiceNumber;
	
	// Employer Login
	
	public String getEmployerLoginPage(){
		try{
			getGlobalContent();
			urlPage = "employerLogin";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getEmployerFaqPage(){
		try{
			getGlobalContent();
			urlPage = "employerFaq";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getEmployerRegistrationPage(){
		try{
			getGlobalContent();
			urlPage = "employerRegistration";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String saveEmployerRegistration(){
		try{
			getGlobalContent();
			urlPage = "employerRegistration";
			employer = null;
			session.put("employer", employer);
			
			saveEmployerRegistrationValidator();
			if(!hasActionErrors()){
				
				employer = employerBo.getEmployerByEmailId(employerEmailId);
				if(employer!=null){
					addActionError("Employer All ready Registered with the Given Email Id : "+employerEmailId+" !!");
					return "failure";
				}else{
					
					employer = new Employer();
					employer.setEmployerFirstName(employerFirstName);
					employer.setEmployerLastName(employerLastName);
					employer.setEmployerEmailId(employerEmailId);
					employer.setEmployerPassword(employerPassword);
					employer.setEmployerPhoneNo(employerPhoneNo);
					employer.setEmployerPhoneNoExtension(employerPhoneNoExtension);
					employer.setEmployerAlternatePhone(employerAlternatePhone);
					employer.setEmployerAlternatePhoneNoExtension(employerAlternatePhoneNoExtension);
					employer.setEmployerCompanyName(employerCompanyName);
					employer.setEmployerTitle(employerTitle);
					employer.setEmployerAddressLine1(employerAddressLine1);
					employer.setEmployerAddressLine2(employerAddressLine2);
					employer.setEmployerCity(employerCity);
					employer.setEmployerState(employerState);
					employer.setEmployerCountry(employerCountry);
					employer.setEmployerZipcode(employerZipcode);
					employer.setCreationDate(new Date());
					employer.setLastModifiedTime(new Date());
					employer.setStatus(INACTIVE);
					employerBo.addEmployer(employer);
					
					employer = employerBo.getEmployerByEmailId(employerEmailId);
					
					// Adding Entry of Employer in Credits Available Table
					creditsAvailable = new CreditsAvailable(employer.getEmployerId(), EMPLOYER, 0, 0, new Date(), ACTIVE);
					creditsAvailableBo.addCreditsAvailable(creditsAvailable);
	
					propertie = propertieBo.getPropertie();
					secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.EMPLOYER_REGISTRATION_EMAIL_TO_EMPLOYER.getValue());
					if(propertie!=null && secureVerifyEmailSubjectBody!=null){
						
						String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#employer#", employerEmailId);
						String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#employer#", employerEmailId);
						
						SecureVerifyMail.postMail(employerEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
								propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
								propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
								propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
						
					}
					addActionMessage("Employer Registered SuccessFully !!");
					
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

    public void saveEmployerRegistrationValidator(){
        if(isEmpty(getEmployerFirstName())){
            addActionError("Employer First Name can't be empty !!");
        }
        if(isEmpty(getEmployerLastName())){
            addActionError("Employer Last Name can't be empty !!");
        }
        if(isEmpty(getEmployerEmailId())){
            addActionError("Employer Email Id can't be empty !!");
        }
        if(isEmpty(getEmployerPassword())){
            addActionError("Employer Password can't be empty !!");
        }
        if(isEmpty(getVerifyPassword())){
            addActionError("Employer Verify Password can't be empty !!");
        }
    	if(!isEmpty(getEmployerPassword()) && !isEmpty(getVerifyPassword()) && !getEmployerPassword().equals(getVerifyPassword())){
			addActionError("Password and Verify Password Must be Same !!");
    	}
        if(isEmpty(getEmployerPhoneNo())){
            addActionError("Employer Phone No can't be empty !!");
        }
        if(isEmpty(getEmployerCompanyName())){
            addActionError("Employer Company Name can't be empty !!");
        }
        if(isEmpty(getEmployerTitle())){
            addActionError("Employer Title can't be empty !!");
        }
        if(isEmpty(getEmployerAddressLine1())){
            addActionError("Employer Address Line 1 can't be empty !!");
        }
    	if(isEmpty(getEmployerCity())){
    		addActionError("Employer City can't be empty !!");
    	}
    	if(isEmpty(getEmployerState())){
    		addActionError("Employer State can't be empty !!");
    	}
    	if(isEmpty(getEmployerCountry())){
    		addActionError("Employer Country Name can't be empty !!");
    	}
    	if(isEmpty(getEmployerZipcode())){
    		addActionError("Employer Zipcode can't be empty !!");
    	}
    }
	
	@SuppressWarnings("unchecked")
	public String authenticateEmployer(){
		try{
			getGlobalContent();
			urlPage = "employerLogin";
			
			authenticateCandidateValidator();
			if(!hasActionErrors()){
				employer = employerBo.getActiveEmployer(employerEmailId, employerPassword);
				if(employer!=null){
					session.put("employer", employer);
				}else{
					employer = employerBo.getEmployer(employerEmailId, employerPassword);
					if(employer!=null){
						addActionError("Authorization Process is Pending !!");
					}else{
						urlPage = "employerLogin";
						addActionError("Employer doen't found with given Email Id and Password!!");
					}
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

    public void authenticateCandidateValidator(){
        if(isEmpty(getEmployerEmailId())){
    		addActionError("Employer Email Id can't be empty !!");
    	}
    	if(isEmpty(getEmployerPassword())){
    		addActionError("Employer Password can't be empty !!");
    	}
    }
	
	
	// Employer Candidates
	
	public String getEmployerCandidatesPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCandidates";
				totalSize = candidateEmployerSkillSetMapBo.getCandidateEmployerSkillSetMapByEmployerIdListCount(employer.getEmployerId());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				skillSetList = skillSetBo.listActiveSkillSet();
				
				candidateEmployerSkillSetMapList = candidateEmployerSkillSetMapBo.searchCandidateEmployerSkillSetMap(null, null, employer.getEmployerId(), null, null, startRecord, pageSize);
				
				if(candidateEmployerSkillSetMapList!=null && !candidateEmployerSkillSetMapList.isEmpty()){
					for(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap : candidateEmployerSkillSetMapList){
						candidate = candidateBo.getCandidateByCandidateId(candidateEmployerSkillSetMap.getCandidateId());
						if(candidate!=null){
							candidateEmployerSkillSetMap.setCandidate(candidate);
						}
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateEmployerSkillSetMap.getSkillSetId());
						if(skillSet!=null){
							candidateEmployerSkillSetMap.setSkillSet(skillSet); 
						}
					}
				}
				
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getEmployerCandidatesSearchPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCandidates";
				totalSize = candidateEmployerSkillSetMapBo.getCandidateEmployerSkillSetMapByEmployerIdListCount(employer.getEmployerId());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				skillSetList = skillSetBo.listActiveSkillSet();
				
				candidateEmployerSkillSetMapList = candidateEmployerSkillSetMapBo.searchCandidateEmployerSkillSetMap(null, null, employer.getEmployerId(), null, null, startRecord, pageSize);
				
				if(candidateEmployerSkillSetMapList!=null && !candidateEmployerSkillSetMapList.isEmpty()){
					for(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap : candidateEmployerSkillSetMapList){
						candidate = candidateBo.getCandidateByCandidateId(candidateEmployerSkillSetMap.getCandidateId());
						if(candidate!=null){
							candidateEmployerSkillSetMap.setCandidate(candidate);
						}
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateEmployerSkillSetMap.getSkillSetId());
						if(skillSet!=null){
							candidateEmployerSkillSetMap.setSkillSet(skillSet); 
						}
					}
				}
				
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getEmployerAddCandidatePage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCandidates";
				creditsAvailable = creditsAvailableBo.getCreditsAvailable(employer.getEmployerId(), EMPLOYER);

				// Returning Error Page if Employer Entry is Not Present in the Credits Available Table 
				if(creditsAvailable==null){
					addActionError("Contact Admin to Add Credits for Your Account !!");
					return "failure";
				}
				
				if(creditsAvailable.getNoOfCreditsAvailable()<1){
					
					totalSize = candidateEmployerSkillSetMapBo.getCandidateEmployerSkillSetMapByEmployerIdListCount(employer.getEmployerId());
					if(pageNo==null || pageNo==0){
						pageNo = 1;
					}
					
					noOfPages = totalSize/pageSize;
					if((totalSize%pageSize) > 0){
						noOfPages++;
					}
					
					final Integer startRecord = (pageNo-1)*pageSize;
					skillSetList = skillSetBo.listActiveSkillSet();
					
					candidateEmployerSkillSetMapList = candidateEmployerSkillSetMapBo.searchCandidateEmployerSkillSetMap(null, null, employer.getEmployerId(), null, null, startRecord, pageSize);
					
					if(candidateEmployerSkillSetMapList!=null && !candidateEmployerSkillSetMapList.isEmpty()){
						for(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap : candidateEmployerSkillSetMapList){
							candidate = candidateBo.getCandidateByCandidateId(candidateEmployerSkillSetMap.getCandidateId());
							if(candidate!=null){
								candidateEmployerSkillSetMap.setCandidate(candidate);
							}
							skillSet = skillSetBo.getSkillSetBySkillSetId(candidateEmployerSkillSetMap.getSkillSetId());
							if(skillSet!=null){
								candidateEmployerSkillSetMap.setSkillSet(skillSet); 
							}
						}
					}
					
					addActionError("Please Add Credits To your Account to Add Candidate !!");
					return "credits";
				}
				skillSetList = skillSetBo.listActiveSkillSet();
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String saveEmployerCandidate(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCandidates";
				
				saveEmployerCandidateValidator();
				if(!hasActionErrors()){
					
					// Checking Available Credits of Employer
					creditsAvailable = creditsAvailableBo.getCreditsAvailable(employer.getEmployerId(), EMPLOYER);
					
					// Returning Error Page if Employer Entry is Not Present in the Credits Available Table 
					if(creditsAvailable==null){
						addActionError("Contact Admin to Add Credits for Your Account !!");
						return "failure";
					}else{
					
						if(creditsAvailable.getNoOfCreditsAvailable()<1){
							
							totalSize = candidateEmployerSkillSetMapBo.getCandidateEmployerSkillSetMapByEmployerIdListCount(employer.getEmployerId());
							if(pageNo==null || pageNo==0){
								pageNo = 1;
							}
							
							noOfPages = totalSize/pageSize;
							if((totalSize%pageSize) > 0){
								noOfPages++;
							}
							
							final Integer startRecord = (pageNo-1)*pageSize;
							skillSetList = skillSetBo.listActiveSkillSet();
							
							candidateEmployerSkillSetMapList = candidateEmployerSkillSetMapBo.searchCandidateEmployerSkillSetMap(null, null, employer.getEmployerId(), null, null, startRecord, pageSize);
							
							if(candidateEmployerSkillSetMapList!=null && !candidateEmployerSkillSetMapList.isEmpty()){
								for(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap : candidateEmployerSkillSetMapList){
									candidate = candidateBo.getCandidateByCandidateId(candidateEmployerSkillSetMap.getCandidateId());
									if(candidate!=null){
										candidateEmployerSkillSetMap.setCandidate(candidate);
									}
									skillSet = skillSetBo.getSkillSetBySkillSetId(candidateEmployerSkillSetMap.getSkillSetId());
									if(skillSet!=null){
										candidateEmployerSkillSetMap.setSkillSet(skillSet); 
									}
								}
							}
							
							addActionError("Please Add Credits To your Account to Add Candidate !!");
							return "credits";
						}else{
						
							candidate = candidateBo.getCandidateByEmailId(candidateEmailId);
		
							propertie = propertieBo.getPropertie();
							
							// Candidate Doesn't Exist
							if(candidate==null){
								
								candidate = new Candidate(candidateFirstName, candidateLastName, candidateEmailId, candidatePhoneNo, candidatePhoneNoExtension, 
									candidateAlternatePhone, candidateAlternatePhoneNoExtension, INACTIVE, new Date(), new Date(), ACTIVE);
								candidateBo.addCandidate(candidate);
			
								candidate = candidateBo.getCandidateByEmailId(candidateEmailId);
		
								// Adding Candidate in Credits Available Table
								candidateCreditsAvailable = new CreditsAvailable(candidate.getCandidateId(), CANDIDATE, 0, 0, new Date(), ACTIVE);
								creditsAvailableBo.addCreditsAvailable(candidateCreditsAvailable);
		
								// Deducting Credit From Employer
								int noOfCreditsAvailable = creditsAvailable.getNoOfCreditsAvailable() - 1;
								creditsAvailable.setNoOfCreditsAvailable(noOfCreditsAvailable);
								creditsAvailable.setLastModified(new Date());
								creditsAvailableBo.updateCreditsAvailable(creditsAvailable);
								
								
								candidateEmployerSkillSetMap = new CandidateEmployerSkillSetMap(candidate.getCandidateId(), employer.getEmployerId(), fskillSetId, INACTIVE);
								candidateEmployerSkillSetMapBo.addCandidateEmployerSkillSetMap(candidateEmployerSkillSetMap);
								
								secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.EMPLOYER_ADD_CANDIDATE_EMAIL_TO_CANDIDATE.getValue());
								
								if(propertie!=null && secureVerifyEmailSubjectBody!=null){
									
									String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#employer#", employer.getEmployerTitle());
									String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", candidateEmailId).replaceAll("#employer#", employer.getEmployerTitle());
									
									SecureVerifyMail.postMail(candidateEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
											propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
											propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
											propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
									
								}
								
							}else{
							//// Candidate Exist in Our DB
								
								candidateEmployerSkillSetMap = new CandidateEmployerSkillSetMap(candidate.getCandidateId(), employer.getEmployerId(), fskillSetId, INACTIVE);
								candidateEmployerSkillSetMapBo.addCandidateEmployerSkillSetMap(candidateEmployerSkillSetMap);
								
								secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.EMPLOYER_ADD_EXISTING_CANDIDATE_EMAIL_TO_CANDIDATE.getValue());
								if(propertie!=null && secureVerifyEmailSubjectBody!=null){
		
									String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#employer#", employer.getEmployerTitle());
									String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", candidateEmailId).replaceAll("#employer#", employer.getEmployerTitle());
									
									SecureVerifyMail.postMail(candidateEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
											propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
											propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
											propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
									
								}
		
							}
						}
					}
				}else{
					skillSetList = skillSetBo.listActiveSkillSet();
					return "input";
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveEmployerCandidateValidator(){
        if(isEmpty(getCandidateFirstName())){
            addActionError("Candidate Firs tName can't be empty !!");
        }
    	if(isEmpty(getCandidateLastName())){
    		addActionError("Candidate Last Name can't be empty !!");
    	}
    	if(isEmpty(getCandidateEmailId())){
    		addActionError("Candidate Email Id can't be empty !!");
    	}
    	if(isEmpty(getCandidatePhoneNo())){
    		addActionError("Candidate Phone No can't be empty !!");
    	}
    	if(isNumberNullOrZero(getFskillSetId())){
    		addActionError("Candidate Skill Set can't be empty !!");
    	}
    }
	
	public String viewEmployerCandidateDetails(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCandidates";
				if(isNumberNullOrZero(getCandidateEmployerSkillSetMapId())){
					addActionError("Error Occured in retrieving the Candidate details !!");
				}else{
					candidateEmployerSkillSetMap = candidateEmployerSkillSetMapBo.getCandidateEmployerSkillSetMap(candidateEmployerSkillSetMapId);
					
					if(candidateEmployerSkillSetMap!=null){
						candidate = candidateBo.getCandidateByCandidateId(candidateEmployerSkillSetMap.getCandidateId());
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
					}else{
						addActionError("Candidate does not exist with the Given Details !!");
						return ERROR;
					}
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String editEmployerCandidate(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCandidates";
				if(isNumberNullOrZero(getCandidateEmployerSkillSetMapId())){
					addActionError("Error Occured in retrieving the Candidate details !!");
				}else{
					candidateEmployerSkillSetMap = candidateEmployerSkillSetMapBo.getCandidateEmployerSkillSetMap(candidateEmployerSkillSetMapId);
					candidate = candidateBo.getCandidateByCandidateId(candidateEmployerSkillSetMap.getCandidateId());
					skillSetList = skillSetBo.listActiveSkillSet();
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateEmployerCandidate(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCandidates";
				
				updateEmployerCandidateValidator();
				if(!hasActionErrors()){
					candidate = candidateBo.getCandidateByCandidateId(candidateId);
					if(candidate!=null){
						candidate.setCandidateFirstName(candidateFirstName);
						candidate.setCandidateLastName(candidateLastName);
						candidate.setCandidatePhoneNo(candidatePhoneNo);
						candidate.setCandidatePhoneNoExtension(candidatePhoneNoExtension);
						candidate.setCandidateAlternatePhone(candidateAlternatePhone);
						candidate.setCandidateAlternatePhoneNoExtension(candidateAlternatePhoneNoExtension);
						candidateBo.updateCandidate(candidate);
						
						/*candidateEmployerSkillSetMap = candidateEmployerSkillSetMapBo.getCandidateEmployerSkillSetMap(candidateEmployerSkillSetMapId);
						candidateEmployerSkillSetMap.setSkillSetId(skillSetId);
						candidateEmployerSkillSetMapBo.updateCandidateEmployerSkillSetMap(candidateEmployerSkillSetMap);*/
						
					}
				}else{
					return "employerEditCandidate";
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateEmployerCandidateValidator(){
        if(isNumberNullOrZero(getCandidateEmployerSkillSetMapId())){
            addActionError("Candidate Employer Skill Set Map Id can't be Empty / Zero !!");
        }
        if(isNumberNullOrZero(getCandidateId())){
            addActionError("Candidate Id can't be Empty / Zero !!");
        }
        if(isEmpty(getCandidateFirstName())){
            addActionError("Candidate Firs tName can't be empty !!");
        }
    	if(isEmpty(getCandidateLastName())){
    		addActionError("Candidate Last Name can't be empty !!");
    	}
    	if(isEmpty(getCandidatePhoneNo())){
    		addActionError("Candidate Phone No can't be empty !!");
    	}
    	if(isNumberNullOrZero(getSkillSetId())){
    		addActionError("Candidate Skill Set can't be empty !!");
    	}
    }
	
	
	// Employer Applied Candidates
	
	public String getEmployerAppliedCandidatesPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerAppliedCandidates";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByEmployerIdAndInterviewStatusListCount(
						employer.getEmployerId(), InterviewStatus.APPLIED.getValue());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				skillSetList = skillSetBo.listActiveSkillSet();
				locationList = locationBo.listActiveLocation();
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, null, null, null, null, 
						null, null, null, null, null, null, InterviewStatus.APPLIED.getValue(), null, employer.getEmployerId(), null, null, null, 
						null, ACTIVE, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						candidateScheduleTiming.setCandidate(candidate);
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						candidateScheduleTiming.setSkillSet(skillSet);
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						candidateScheduleTiming.setLocation(location);
					}
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getEmployerAppliedCandidatesSearchPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerAppliedCandidates";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByEmployerIdAndInterviewStatusListCount(
						employer.getEmployerId(), InterviewStatus.APPLIED.getValue());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				skillSetList = skillSetBo.listActiveSkillSet();
				locationList = locationBo.listActiveLocation();
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, locationId, null, null, skillSetId, null, 
						null, null, candidateScheduleFromTime, candidateScheduleToTime, null, null, InterviewStatus.APPLIED.getValue(), null, employer.getEmployerId(), null, null, null, 
						null, ACTIVE, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						candidateScheduleTiming.setCandidate(candidate);
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						candidateScheduleTiming.setSkillSet(skillSet);
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						candidateScheduleTiming.setLocation(location);
					}
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String viewEmployerAppliedCandidateDetails(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerAppliedCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming!=null){
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
					}else{
						addActionError("Candidate does not exist with the Given Candidate Id !!");
						return ERROR;
					}
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Employer Scheduled Candidates
	
	public String getEmployerScheduledCandidatesPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerScheduledCandidates";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByEmployerIdAndInterviewStatusListCount(employer.getEmployerId(), InterviewStatus.SCHEDULED.getValue());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				skillSetList = skillSetBo.listActiveSkillSet();
				locationList = locationBo.listActiveLocation();
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, null, null, null, null, 
						null, null, null, null, null, null, InterviewStatus.SCHEDULED.getValue(), null, employer.getEmployerId(), null, null, null, 
						null, ACTIVE, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						candidateScheduleTiming.setCandidate(candidate);
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						candidateScheduleTiming.setSkillSet(skillSet);
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						candidateScheduleTiming.setLocation(location);
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						candidateScheduleTiming.setInterviewer(interviewer);
					}
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewEmployerScheduledCandidateDetails(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerScheduledCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming!=null){
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						List<SkillSet> skillSetList = new ArrayList<SkillSet>();
						if(interviewer.getInterviewerSkillSet1()!=null && interviewer.getInterviewerSkillSet1()!=0){
							SkillSet tmpSkillSet =  skillSetBo.getSkillSetBySkillSetId(interviewer.getInterviewerSkillSet1());
							skillSetList.add(tmpSkillSet);
						}
						if(interviewer.getInterviewerSkillSet2()!=null && interviewer.getInterviewerSkillSet2()!=0){
							SkillSet tmpSkillSet =  skillSetBo.getSkillSetBySkillSetId(interviewer.getInterviewerSkillSet2());
							skillSetList.add(tmpSkillSet);
						}
						if(interviewer.getInterviewerSkillSet3()!=null && interviewer.getInterviewerSkillSet3()!=0){
							SkillSet tmpSkillSet =  skillSetBo.getSkillSetBySkillSetId(interviewer.getInterviewerSkillSet3());
							skillSetList.add(tmpSkillSet);
						}
						interviewer.setSkillSetList(skillSetList);
					}else{
						addActionError("Candidate does not exist with the Given Candidate Id !!");
						return ERROR;
					}
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Employer Interviewed Candidates
	
	public String getEmployerInterviewedCandidatesPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerInterviewedCandidates";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByEmployerIdAndInterviewStatusListCount(employer.getEmployerId(), InterviewStatus.INTERVIEWED.getValue());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				skillSetList = skillSetBo.listActiveSkillSet();
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, null, null, null, null, null, 
						null, null, null, null, null, null, InterviewStatus.INTERVIEWED.getValue(), null, employer.getEmployerId(), null, null, null, 
						null, ACTIVE, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						candidateScheduleTiming.setCandidate(candidate);
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						candidateScheduleTiming.setSkillSet(skillSet);
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						candidateScheduleTiming.setLocation(location);
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						candidateScheduleTiming.setInterviewer(interviewer);
					}
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewEmployerInterviewedCandidateDetails(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerInterviewedCandidates";
				if(isNumberNullOrZero(getCandidateScheduleTimingId())){
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
				}else{
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming!=null){
						skillSetList = skillSetBo.listActiveSkillSet();
						feedbackList = feedbackBo.getFeedbacksByCandidateScheduleTimingId(candidateScheduleTimingId);
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						List<SkillSet> skillSetList = new ArrayList<SkillSet>();
						if(interviewer.getInterviewerSkillSet1()!=null && interviewer.getInterviewerSkillSet1()!=0){
							SkillSet tmpSkillSet =  skillSetBo.getSkillSetBySkillSetId(interviewer.getInterviewerSkillSet1());
							skillSetList.add(tmpSkillSet);
						}
						if(interviewer.getInterviewerSkillSet2()!=null && interviewer.getInterviewerSkillSet2()!=0){
							SkillSet tmpSkillSet =  skillSetBo.getSkillSetBySkillSetId(interviewer.getInterviewerSkillSet2());
							skillSetList.add(tmpSkillSet);
						}
						if(interviewer.getInterviewerSkillSet3()!=null && interviewer.getInterviewerSkillSet3()!=0){
							SkillSet tmpSkillSet =  skillSetBo.getSkillSetBySkillSetId(interviewer.getInterviewerSkillSet3());
							skillSetList.add(tmpSkillSet);
						}
						interviewer.setSkillSetList(skillSetList);
					}else{
						addActionError("Candidate does not exist with the Given Candidate Id !!");
						return ERROR;
					}
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Employer Credits Management
	
	public String getCreditsManagmentPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCreditsManagment";
				creditsAvailable = creditsAvailableBo.getCreditsAvailable(employer.getEmployerId(), EMPLOYER);
				
				totalSize = paymentDetailBo.searchPaymentDetail(null, employer.getEmployerId(), EMPLOYER, null, null, null, null, 
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				paymentDetailList = paymentDetailBo.searchPaymentDetail(null, employer.getEmployerId(), EMPLOYER,transactionNumber, null, null, 
						null, null, null, null, null, null, null, invoiceNumber, null, null, null, null, null, null, null, null, couponId, 
						null, null, startRecord, pageSize);
					
				if(paymentDetailList!=null && !paymentDetailList.isEmpty()){
					
					for(PaymentDetail paymentDetail : paymentDetailList){
						coupon = couponBo.getCouponByCouponId(paymentDetail.getCouponId());
						paymentDetail.setCoupon(coupon);
					}
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewEmployerPayments(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCreditsManagment";
				paymentDetail = paymentDetailBo.getPaymentDetailByPartyTypeId(partyTypeId);
				if(paymentDetail==null){
					addActionError("Payment Details Doesn't Exist with the Given Party Id !!");
				}
				coupon = couponBo.getCouponByCouponId(paymentDetail.getCouponId());
				if(coupon!=null){
					coupon.getCouponCode();
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getCreditsManagmentSearchPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCreditsManagment";
				creditsAvailable = creditsAvailableBo.getCreditsAvailable(employer.getEmployerId(), EMPLOYER);
				
				totalSize = paymentDetailBo.searchPaymentDetail(null, employer.getEmployerId(), EMPLOYER, null, null, null, null, 
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				paymentDetailList = paymentDetailBo.searchPaymentDetail(null, employer.getEmployerId(), EMPLOYER, null, null, noOfCreditsBought, 
						null, null, null, paymentDate, null, null, null, null, null, null, null, null, null, null, null, null, null, 
						null, null, startRecord, pageSize);
				
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getBuyEmployerCreditsPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerCreditsManagment";
				creditTypes = creditTypesBo.getCreditTypes(EMPLOYER);
				paymentDetailsId = paymentDetailBo.selectMaxPaymentDetailId();
				if(paymentDetailsId==null){
					paymentDetailsId = 48000;
				}
				paymentDetailsId++;
				if(creditTypes==null){
					addActionError("Error Occured in Retrieving Price for Credit");
					return "failure";
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Employer Profile
	
	public String getEmployerChangePasswordPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerChangePassword";
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
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
	public String updateEmployerPassword(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerChangePassword";
				
				agentUpdatePasswordValidator();
				if(!hasActionErrors()){
					if(employer.getEmployerPassword().equals(currentPassword)){
						employer.setEmployerPassword(employerPassword);;
						employerBo.updateEmployer(employer);
						session.put("employer", employer);
						
						addActionMessage("Updated Password Successfully !!");
					}else{
						addActionError("Your Current Password is Invalid !!");
						return "failure";
					}
				}else{
					return "failure";
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
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
    	if(isEmpty(getEmployerPassword())){
			addActionError("New Password can't be empty !!");
    	}
    	if(isEmpty(getRetypePassword())){
			addActionError("Retype Password can't be empty !!");
    	}
    	if(!isEmpty(getEmployerPassword()) && !isEmpty(getRetypePassword()) && !getEmployerPassword().equals(getRetypePassword())){
			addActionError("New Password and Retype Password Must be Same !!");
    	}
    }
	
	public String getEmployerUpdateProfilePage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerUpdateProfile";
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
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
	public String updateEmployerProfile(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "employerUpdateProfile";
				
				updateEmployerProfileValidator();
				if(employerPhoneNo!=null && !employerPhoneNo.equals("")){
					employer.setEmployerFirstName(employerFirstName);
					employer.setEmployerLastName(employerLastName);
					employer.setEmployerEmailId(employerEmailId);
					employer.setEmployerPhoneNo(employerPhoneNo);
					employer.setEmployerPhoneNoExtension(employerPhoneNoExtension);
					employer.setEmployerAlternatePhone(employerAlternatePhone);
					employer.setEmployerAlternatePhoneNoExtension(employerAlternatePhoneNoExtension);
					employerBo.updateEmployer(employer);
					session.put("employer", employer);
					
					addActionMessage("Updated Password Successfully !!");
				}else{
					addActionError("INvalid Form Fields !!");
					return "failure";
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateEmployerProfileValidator(){
        if(isEmpty(getEmployerFirstName())){
            addActionError("Employer First Name can't be empty !!");
        }
        if(isEmpty(getEmployerLastName())){
            addActionError("Employer Last Name can't be empty !!");
        }
        if(isEmpty(getEmployerEmailId())){
            addActionError("Employer Email Id can't be empty !!");
        }
        if(isEmpty(getEmployerPhoneNo())){
            addActionError("Employer Phone No can't be empty !!");
        }
    }
	
	public String getUpdateCompanyInfoPage(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "updateCompanyInfo";
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
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
	public String updateEmployerCompanyInfo(){
		try{
			getGlobalContent();
			employer = (Employer) session.get("employer");
			if(employer!=null){
				urlPage = "updateCompanyInfo";
				
				updateEmployerCompanyInfoValidator();
				if(!hasActionErrors()){
					employer.setEmployerCompanyName(employerCompanyName);
					employer.setEmployerTitle(employerTitle);
					employer.setEmployerAddressLine1(employerAddressLine1);
					employer.setEmployerAddressLine2(employerAddressLine2);
					employer.setEmployerCity(employerCity);
					employer.setEmployerState(employerState);
					employer.setEmployerCountry(employerCountry);
					employer.setEmployerZipcode(employerZipcode);
					employerBo.updateEmployer(employer);
					session.put("employer", employer);
					
					addActionMessage("Updated Password Successfully !!");
				}else{
					return "failure";
				}
			}else{
				urlPage = "employerLogin";
				addActionError("Please Login !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateEmployerCompanyInfoValidator(){
        if(isEmpty(getEmployerCompanyName())){
            addActionError("Employer Company Name can't be empty !!");
        }
        if(isEmpty(getEmployerTitle())){
            addActionError("Employer Title can't be empty !!");
        }
        if(isEmpty(getEmployerAddressLine1())){
            addActionError("Employer Address Line 1 can't be empty !!");
        }
    	if(isEmpty(getEmployerCity())){
    		addActionError("Employer City can't be empty !!");
    	}
    	if(isEmpty(getEmployerState())){
    		addActionError("Employer State can't be empty !!");
    	}
    	if(isEmpty(getEmployerCountry())){
    		addActionError("Employer Country Name can't be empty !!");
    	}
    	if(isEmpty(getEmployerZipcode())){
    		addActionError("Employer Zipcode can't be empty !!");
    	}
    }
	
	@SuppressWarnings("unchecked")
	public String getEmployerLogoutPage(){
		try{
			getGlobalContent();
			urlPage = "employerLogin";
			employer = null;
			session.put("employer", employer);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getForgotEmployerPassword(){
		try{
			getGlobalContent();
			urlPage = "forgotEmployerPassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getResetEmployerPassword(){
		try{
			getGlobalContent();
			urlPage = "forgotEmployerPassword";
			if(isEmpty(getEmployerEmailId())){
	    		addActionError("Employer Email Id can't be empty !!");
	    		return "failure";
	    	}else{
				employer = employerBo.getEmployerByEmailId(employerEmailId);
				if(employer==null){
					addActionError("Invalid E-mail Id.");
					return "failure";
				}else{
					urlPage = "resetEmployerPassword";
					UUID uuid = UUID.randomUUID();
					String verificationCode = uuid.toString().substring(0, 6);
					employerBo.updateEmployer(employer.getEmployerId(), verificationCode);
					propertie = propertieBo.getPropertie();
					secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.EMPLOYER_PASSWORD_RECOVERY.getValue());
					if(propertie!=null && secureVerifyEmailSubjectBody!=null){
						
						String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", employerEmailId);
						String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", employerEmailId).replaceAll("#password#", verificationCode);
						
						SecureVerifyMail.postMail(employerEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
								propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
								propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
								propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
						
					}
					addActionMessage("An E-mail has been sent to your EMail Id: "+employerEmailId+" with Verification Code and a Link to Reset Your Password!!");
				}
	    	}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getUpdateEmployerPasswordPage(){
		try{
			getGlobalContent();
			urlPage = "updateEmployerPassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String changeEmployerPassword(){
		try{
			getGlobalContent();
			urlPage = "employerLogin";
			
			changeEmployerPasswordValidator();
			if(!hasActionErrors()){
				employer = employerBo.getEmployerByEmailId(employerEmailId);
				if(employer==null){
					addActionError("Employer does not Exist with this Email Id");
					return "failure";
				}else{
					if(employer.getVerificationCode()==null){
						addActionError("Please Go To the Forgot Password Page!!");
					}else{
						if(securitycode.equals(employer.getVerificationCode())){
							employerBo.updateEmployer(employer.getEmployerId(), null, employerPassword);
							addActionMessage("Password Updated Successfully!!");
						}else{
							addActionError("Invalid Verification Code !!");
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

    public void changeEmployerPasswordValidator(){
        if(isEmpty(getEmployerEmailId())){
            addActionError("Employer Email Id can't be empty !!");
        }
    	if(isEmpty(getSecuritycode())){
    		addActionError("Security code can't be empty !!");
    	}
    }
	
	
	
	
	
	public Integer getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}

	public String getEmployerEmailId() {
		return employerEmailId;
	}

	public void setEmployerEmailId(String employerEmailId) {
		this.employerEmailId = employerEmailId;
	}

	public String getEmployerPassword() {
		return employerPassword;
	}

	public void setEmployerPassword(String employerPassword) {
		this.employerPassword = employerPassword;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
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

	public List<CandidateScheduleTiming> getCandidateScheduleTimingList() {
		return candidateScheduleTimingList;
	}

	public void setCandidateScheduleTimingList(
			List<CandidateScheduleTiming> candidateScheduleTimingList) {
		this.candidateScheduleTimingList = candidateScheduleTimingList;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateFirstName() {
		return candidateFirstName;
	}

	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName = candidateFirstName;
	}

	public String getCandidateLastName() {
		return candidateLastName;
	}

	public void setCandidateLastName(String candidateLastName) {
		this.candidateLastName = candidateLastName;
	}

	public String getCandidateEmailId() {
		return candidateEmailId;
	}

	public void setCandidateEmailId(String candidateEmailId) {
		this.candidateEmailId = candidateEmailId;
	}

	public String getCandidatePhoneNo() {
		return candidatePhoneNo;
	}

	public void setCandidatePhoneNo(String candidatePhoneNo) {
		this.candidatePhoneNo = candidatePhoneNo;
	}

	public String getCandidatePhoneNoExtension() {
		return candidatePhoneNoExtension;
	}

	public void setCandidatePhoneNoExtension(String candidatePhoneNoExtension) {
		this.candidatePhoneNoExtension = candidatePhoneNoExtension;
	}

	public String getCandidateAlternatePhone() {
		return candidateAlternatePhone;
	}

	public void setCandidateAlternatePhone(String candidateAlternatePhone) {
		this.candidateAlternatePhone = candidateAlternatePhone;
	}

	public String getCandidateAlternatePhoneNoExtension() {
		return candidateAlternatePhoneNoExtension;
	}

	public void setCandidateAlternatePhoneNoExtension(
			String candidateAlternatePhoneNoExtension) {
		this.candidateAlternatePhoneNoExtension = candidateAlternatePhoneNoExtension;
	}

	public Integer getSkillSetId() {
		return skillSetId;
	}

	public void setSkillSetId(Integer skillSetId) {
		this.skillSetId = skillSetId;
	}

	public List<SkillSet> getSkillSetList() {
		return skillSetList;
	}

	public void setSkillSetList(List<SkillSet> skillSetList) {
		this.skillSetList = skillSetList;
	}

	public Integer getCandidateScheduleTimingId() {
		return candidateScheduleTimingId;
	}

	public void setCandidateScheduleTimingId(Integer candidateScheduleTimingId) {
		this.candidateScheduleTimingId = candidateScheduleTimingId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public CandidateScheduleTiming getCandidateScheduleTiming() {
		return candidateScheduleTiming;
	}

	public void setCandidateScheduleTiming(
			CandidateScheduleTiming candidateScheduleTiming) {
		this.candidateScheduleTiming = candidateScheduleTiming;
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

	public String getEmployerFirstName() {
		return employerFirstName;
	}

	public void setEmployerFirstName(String employerFirstName) {
		this.employerFirstName = employerFirstName;
	}

	public String getEmployerLastName() {
		return employerLastName;
	}

	public void setEmployerLastName(String employerLastName) {
		this.employerLastName = employerLastName;
	}

	public String getEmployerPhoneNo() {
		return employerPhoneNo;
	}

	public void setEmployerPhoneNo(String employerPhoneNo) {
		this.employerPhoneNo = employerPhoneNo;
	}

	public String getEmployerPhoneNoExtension() {
		return employerPhoneNoExtension;
	}

	public void setEmployerPhoneNoExtension(String employerPhoneNoExtension) {
		this.employerPhoneNoExtension = employerPhoneNoExtension;
	}

	public String getEmployerAlternatePhone() {
		return employerAlternatePhone;
	}

	public void setEmployerAlternatePhone(String employerAlternatePhone) {
		this.employerAlternatePhone = employerAlternatePhone;
	}

	public String getEmployerAlternatePhoneNoExtension() {
		return employerAlternatePhoneNoExtension;
	}

	public void setEmployerAlternatePhoneNoExtension(
			String employerAlternatePhoneNoExtension) {
		this.employerAlternatePhoneNoExtension = employerAlternatePhoneNoExtension;
	}

	public String getEmployerCompanyName() {
		return employerCompanyName;
	}

	public void setEmployerCompanyName(String employerCompanyName) {
		this.employerCompanyName = employerCompanyName;
	}

	public String getEmployerTitle() {
		return employerTitle;
	}

	public void setEmployerTitle(String employerTitle) {
		this.employerTitle = employerTitle;
	}

	public String getEmployerAddressLine1() {
		return employerAddressLine1;
	}

	public void setEmployerAddressLine1(String employerAddressLine1) {
		this.employerAddressLine1 = employerAddressLine1;
	}

	public String getEmployerAddressLine2() {
		return employerAddressLine2;
	}

	public void setEmployerAddressLine2(String employerAddressLine2) {
		this.employerAddressLine2 = employerAddressLine2;
	}

	public String getEmployerCity() {
		return employerCity;
	}

	public void setEmployerCity(String employerCity) {
		this.employerCity = employerCity;
	}

	public String getEmployerState() {
		return employerState;
	}

	public void setEmployerState(String employerState) {
		this.employerState = employerState;
	}

	public String getEmployerCountry() {
		return employerCountry;
	}

	public void setEmployerCountry(String employerCountry) {
		this.employerCountry = employerCountry;
	}

	public String getEmployerZipcode() {
		return employerZipcode;
	}

	public void setEmployerZipcode(String employerZipcode) {
		this.employerZipcode = employerZipcode;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Integer getFskillSetId() {
		return fskillSetId;
	}

	public void setFskillSetId(Integer fskillSetId) {
		this.fskillSetId = fskillSetId;
	}

	public Integer getCandidateEmployerSkillSetMapId() {
		return candidateEmployerSkillSetMapId;
	}

	public void setCandidateEmployerSkillSetMapId(
			Integer candidateEmployerSkillSetMapId) {
		this.candidateEmployerSkillSetMapId = candidateEmployerSkillSetMapId;
	}

	public CandidateEmployerSkillSetMap getCandidateEmployerSkillSetMap() {
		return candidateEmployerSkillSetMap;
	}

	public void setCandidateEmployerSkillSetMap(
			CandidateEmployerSkillSetMap candidateEmployerSkillSetMap) {
		this.candidateEmployerSkillSetMap = candidateEmployerSkillSetMap;
	}

	public List<CandidateEmployerSkillSetMap> getCandidateEmployerSkillSetMapList() {
		return candidateEmployerSkillSetMapList;
	}

	public void setCandidateEmployerSkillSetMapList(
			List<CandidateEmployerSkillSetMap> candidateEmployerSkillSetMapList) {
		this.candidateEmployerSkillSetMapList = candidateEmployerSkillSetMapList;
	}

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	public CreditTypes getCreditTypes() {
		return creditTypes;
	}

	public List<PaymentDetail> getPaymentDetailList() {
		return paymentDetailList;
	}

	public void setPaymentDetailList(List<PaymentDetail> paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}

	public void setCreditTypes(CreditTypes creditTypes) {
		this.creditTypes = creditTypes;
	}

	public Integer getPaymentDetailsId() {
		return paymentDetailsId;
	}

	public void setPaymentDetailsId(Integer paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}

	public CreditsAvailable getCreditsAvailable() {
		return creditsAvailable;
	}

	public void setCreditsAvailable(CreditsAvailable creditsAvailable) {
		this.creditsAvailable = creditsAvailable;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public CreditsAvailable getCandidateCreditsAvailable() {
		return candidateCreditsAvailable;
	}

	public void setCandidateCreditsAvailable(
			CreditsAvailable candidateCreditsAvailable) {
		this.candidateCreditsAvailable = candidateCreditsAvailable;
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

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getNoOfCreditsBought() {
		return noOfCreditsBought;
	}

	public void setNoOfCreditsBought(Integer noOfCreditsBought) {
		this.noOfCreditsBought = noOfCreditsBought;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	
	public Coupon getCoupon() {
		return coupon;
	}

	
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	
	public Integer getCouponId() {
		return couponId;
	}

	
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	
	public String getTransactionNumber() {
		return transactionNumber;
	}

	
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	
	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	
	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	
	public Integer getPartyTypeId() {
		return partyTypeId;
	}

	
	public void setPartyTypeId(Integer partyTypeId) {
		this.partyTypeId = partyTypeId;
	}

	
}
