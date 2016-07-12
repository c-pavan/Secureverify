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
import com.secureVerify.model.CandidateCouponMap;
import com.secureVerify.model.CandidateEmployerSkillSetMap;
import com.secureVerify.model.CandidatePerformance;
import com.secureVerify.model.CandidateScheduleTiming;
import com.secureVerify.model.Coupon;
import com.secureVerify.model.CreditTypes;
import com.secureVerify.model.CreditsAvailable;
import com.secureVerify.model.Employer;
import com.secureVerify.model.InterviewStatus;
import com.secureVerify.model.Interviewer;
import com.secureVerify.model.Location;
import com.secureVerify.model.LocationScheduleTiming;
import com.secureVerify.model.PaymentDetail;
import com.secureVerify.model.SecureVerifyEmailType;
import com.secureVerify.model.SkillSet;
import com.secureVerify.util.DateHelper;
import com.secureVerify.util.Helper;
import com.secureVerify.util.SecureVerifyMail;

public class CandidateAction extends MasterAction {

	private static final long serialVersionUID = 4659599967181469225L;
	
	private static final Logger log = Logger.getLogger(CandidateAction.class);
	private static final String CANDIDATE_LOGIN_MSG = "Please Login into Candidate !!";
	private static final String URL_PAGE_CANDIDATE_LOGIN = "candidateLogin";
	

	// Candidate
	private Integer candidateId;
	private String candidateFirstName;
	private String candidateLastName;
	private String candidateEmailId;
	private String candidatePassword;
	private String currentPassword;
	private String retypePassword;
	private String candidatePhoneNo;
	private String candidatePhoneNoExtension;
	private String candidateAlternatePhone;
	private String candidateAlternatePhoneNoExtension;
	private Integer skillSetId;
	private Integer candidatePerformance;
	private Integer fskillSetId;
	private String candidateResume;
	private String candidateAddressLine1;
	private String candidateAddressLine2;
	private String candidateCity;
	private String candidateState;
	private String candidateCountry;
	private String candidateZipcode;
	private String candidatePrefferedLocation;
	private String candidateExpectedSalary;
	private String verifyPassword;
	
	private String scheduleFromTime;
	private String scheduleToTime;
	private Date locationScheduleFromTime;
	private Date locationScheduleToTime;
	
	private Integer employerId;
	private Integer candidateScheduleTimingId;
	private Integer locationId;
	private Integer locationScheduleTimingId;
	private String locationZipcode;
	private String couponCode;
	private Double latitude;
	private Double longitude;
	
	private Integer candidateEmployerSkillSetMapId;
	private Integer paymentDetailsId;
	private Integer partyTypeId;
	
	private Agent agent;
	private Candidate candidate;
	private CandidateCouponMap candidateCouponMap;
	private CandidateEmployerSkillSetMap candidateEmployerSkillSetMap;
	private List<CandidateEmployerSkillSetMap> candidateEmployerSkillSetMapList;
	private CandidateScheduleTiming candidateScheduleTiming;
	private Coupon coupon;
	private CreditsAvailable creditsAvailable;
	private CreditTypes creditTypes;
	private Employer employer;
	private List<Employer> employerList;
	private Interviewer interviewer;
	private List<Interviewer> interviewerList;
	private SkillSet skillSet;
	private List<SkillSet> skillSetList;
	private Location location;
	private LocationScheduleTiming locationScheduleTiming;
	private List<Location> locationList;
	private List<LocationScheduleTiming> locationScheduleTimingList;
	private List<CandidateScheduleTiming> candidateScheduleTimingList;
	private List<PaymentDetail> paymentDetailList;
	private PaymentDetail paymentDetail;
	private File resume;
	private Integer noOfCreditsBought;
	private Date paymentDate;
	private Integer couponId;
	private String transactionNumber;
	private String invoiceNumber;

	// Candidate Login
	
	public String getCandidateLoginPage(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_CANDIDATE_LOGIN;
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS; 
	}

	public String getCandidateFaqPage(){
		try{
			getGlobalContent();
			urlPage = "candidateFaq";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getCandidateRegistrationPage(){
		try{
			getGlobalContent();
			urlPage = "candidateRegistration";
			skillSetList = skillSetBo.listActiveSkillSet();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public String saveCandidateRegistration(){
		try{
			getGlobalContent();
			urlPage = "candidateRegistration";
			user = null;
			session.put("user", user);
			
			saveCandidateRegistrationValidator();
			
			if(!hasActionErrors()){
								
				candidate = candidateBo.getCandidateByEmailId(candidateEmailId);
				if(candidate!=null){
					addActionError("Candidate All ready Registered with the Given Email Id : "+candidateEmailId+" !!");
					skillSetList = skillSetBo.listActiveSkillSet();
					return "failure";
				}
					
				InputStream in = new FileInputStream(resume.getAbsolutePath());
				XWPFDocument docIn = new XWPFDocument(in);  
	            XWPFWordExtractor extractor = new XWPFWordExtractor(docIn);  
	            String docText = extractor.getText();
				
				candidate = new Candidate();
				candidate.setCandidateFirstName(candidateFirstName);
				candidate.setCandidateLastName(candidateLastName);
				candidate.setCandidateEmailId(candidateEmailId);
				candidate.setCandidatePassword(candidatePassword);
				candidate.setCandidatePhoneNo(candidatePhoneNo);
				candidate.setCandidatePhoneNoExtension(candidatePhoneNoExtension);
				candidate.setCandidateAlternatePhone(candidateAlternatePhone);
				candidate.setCandidateAlternatePhoneNoExtension(candidateAlternatePhoneNoExtension);
				candidate.setSkillSetId(fskillSetId);
				candidate.setCandidateResume(docText);
				candidate.setCandidateResumeBlob(IOUtils.toByteArray(new FileInputStream(resume.getAbsolutePath())));
				candidate.setCandidateAddressLine1(candidateAddressLine1);
				candidate.setCandidateAddressLine2(candidateAddressLine2);
				candidate.setCandidateCity(candidateCity);
				candidate.setCandidateState(candidateState);
				candidate.setCandidateCountry(candidateCountry);
				candidate.setCandidateZipcode(candidateZipcode);
				candidate.setCandidatePrefferedLocation(candidatePrefferedLocation);
				candidate.setCandidateExpectedSalary(candidateExpectedSalary);
				candidate.setCreationDate(new Date());
				candidate.setLastModifiedTime(new Date());
				candidate.setStatus(ACTIVE);
				candidateBo.addCandidate(candidate);

				candidate = candidateBo.getCandidate(candidateEmailId, candidatePassword);
				
				// Adding Candidate in Credits Available Table
				creditsAvailable = new CreditsAvailable(candidate.getCandidateId(), CANDIDATE, 0, 0, new Date(), ACTIVE);
				creditsAvailableBo.addCreditsAvailable(creditsAvailable);

				session.put("candidate", candidate);
				
				propertie = propertieBo.getPropertie();
				secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.CANDIDATE_REGISTRATION_EMAIL_TO_CANDIDATE.getValue());
				if(propertie!=null && secureVerifyEmailSubjectBody!=null){
					
					String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", candidateEmailId);
					String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", candidateEmailId).replaceAll("#password#", candidatePassword);
					
					SecureVerifyMail.postMail(candidateEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
							propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
							propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
							propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
					
				}
				
				addActionMessage("Candidate Registered SuccessFully !!");
			
			}else{
				skillSetList = skillSetBo.listActiveSkillSet();
				return "failure";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveCandidateRegistrationValidator(){
        if(isEmpty(getCandidateFirstName())){
            addActionError("Candidate Firs tName can't be empty !!");
        }
    	if(isEmpty(getCandidateLastName())){
    		addActionError("Candidate Last Name can't be empty !!");
    	}
    	if(isEmpty(getCandidateEmailId())){
    		addActionError("Candidate Email Id can't be empty !!");
    	}
    	if(isEmpty(getCandidatePassword())){
    		addActionError("Candidate Password can't be empty !!");
    	}
    	if(isEmpty(getVerifyPassword())){
    		addActionError("Candidate Verify Password can't be empty !!");
    	}
    	if(!isEmpty(getCandidatePassword()) && !isEmpty(getVerifyPassword()) && !getCandidatePassword().equals(getVerifyPassword())){
			addActionError("Password and Verify Password Must be Same !!");
    	}
    	if(isEmpty(getCandidatePhoneNo())){
    		addActionError("Candidate Phone No can't be empty !!");
    	}
    	if(isNumberNullOrZero(getFskillSetId())){
    		addActionError("Candidate Skill Set can't be empty !!");
    	}
    	if(isEmpty(getCandidateAddressLine1())){
    		addActionError("Candidate Address Line 1 can't be empty !!");
    	}
    	if(isEmpty(getCandidateCity())){
    		addActionError("Candidate City can't be empty !!");
    	}
    	if(isEmpty(getCandidateState())){
    		addActionError("Candidate State can't be empty !!");
    	}
    	if(isEmpty(getCandidateCountry())){
    		addActionError("Candidate Country Name can't be empty !!");
    	}
    	if(isEmpty(getCandidateZipcode())){
    		addActionError("Candidate Zipcode can't be empty !!");
    	}
    	if(isEmpty(getCandidatePrefferedLocation())){
    		addActionError("Candidate Preffered Location can't be empty !!");
    	}
    	if(isEmpty(getCandidateExpectedSalary())){
    		addActionError("Candidate Expected Salary can't be empty !!");
    	}
    	if(isFileNull(getResume())){
    		addActionError("Resume can't be empty !!");
    	}
    }
	
	@SuppressWarnings("unchecked")
	public String getCandidateRegisterPage(){
		try{
			getGlobalContent();
			urlPage = "candidateRegistration";
			user = null;
			session.put("user", user);
			if(!isEmpty(getCandidateEmailId())){
				candidate = candidateBo.getCandidateByEmailId(candidateEmailId);
				if(candidate==null){
					addActionError("Candidate Does not Exist With the Given Mail Id !!");
					skillSetList = skillSetBo.listActiveSkillSet();
					return "failure";
				}else if(!candidate.getCandidatePassword().equals("")){
					addActionError("Candidate All ready registered with this Email Id !!");
				}
				skillSetList = skillSetBo.listActiveSkillSet();
			}else{
				addActionError("Candidate Email Id can't be empty !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public String saveCandidateRegister(){
		try{
			getGlobalContent();
			urlPage = "candidateRegistration";
			user = null;
			session.put("user", user);
			
			saveCandidateRegisterValidator();
			if(!hasActionErrors()){
						
				InputStream in = new FileInputStream(resume.getAbsolutePath());
				XWPFDocument docIn = new XWPFDocument(in);
	            XWPFWordExtractor extractor = new XWPFWordExtractor(docIn);  
	            String docText = extractor.getText();
				
				candidate = candidateBo.getCandidateByEmailId(candidateEmailId);
				if(candidate==null){
					addActionError("Candidate Doesn't Exist with the Given Fields");
					skillSetList = skillSetBo.listActiveSkillSet();
					return "failure";
				}else if(!candidate.getCandidatePassword().equals("")){
					addActionError("Candidate All ready registered with this Email Id !!");
					skillSetList = skillSetBo.listActiveSkillSet();
					return "failure";
				}
				candidate.setCandidateFirstName(candidateFirstName);
				candidate.setCandidateLastName(candidateLastName);
				candidate.setCandidatePassword(candidatePassword);
				candidate.setCandidatePhoneNo(candidatePhoneNo);
				candidate.setCandidatePhoneNoExtension(candidatePhoneNoExtension);
				candidate.setCandidateAlternatePhone(candidateAlternatePhone);
				candidate.setCandidateAlternatePhoneNoExtension(candidateAlternatePhoneNoExtension);
				candidate.setSkillSetId(skillSetId);
				candidate.setCandidateResume(docText);
				candidate.setCandidateResumeBlob(IOUtils.toByteArray(new FileInputStream(resume.getAbsolutePath())));
				candidate.setCandidateAddressLine1(candidateAddressLine1);
				candidate.setCandidateAddressLine2(candidateAddressLine2);
				candidate.setCandidateCity(candidateCity);
				candidate.setCandidateState(candidateState);
				candidate.setCandidateCountry(candidateCountry);
				candidate.setCandidateZipcode(candidateZipcode);
				candidate.setCandidatePrefferedLocation(candidatePrefferedLocation);
				candidate.setCandidateExpectedSalary(candidateExpectedSalary);
				candidate.setLastModifiedTime(new Date());
				candidateBo.updateCandidate(candidate);
				
				candidate = candidateBo.getCandidate(candidateEmailId, candidatePassword);
				session.put("candidate", candidate);

				propertie = propertieBo.getPropertie();
				secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.CANDIDATE_REGISTRATION_EMAIL_TO_CANDIDATE.getValue());
				if(propertie!=null && secureVerifyEmailSubjectBody!=null){
					
					String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", candidateEmailId);
					String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", candidateEmailId).replaceAll("#password#", candidatePassword);
					
					SecureVerifyMail.postMail(candidateEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
							propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
							propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
							propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
					
				}
				
				addActionMessage("Candidate Registered SuccessFully !!");
			}else{
				skillSetList = skillSetBo.listActiveSkillSet();
				return "failure";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveCandidateRegisterValidator(){
        if(isEmpty(getCandidateFirstName())){
            addActionError("Candidate Firs tName can't be empty !!");
        }
    	if(isEmpty(getCandidateLastName())){
    		addActionError("Candidate Last Name can't be empty !!");
    	}
    	if(isEmpty(getCandidateEmailId())){
    		addActionError("Candidate Email Id can't be empty !!");
    	}
    	if(isEmpty(getCandidatePassword())){
    		addActionError("Candidate Password can't be empty !!");
    	}
    	if(isEmpty(getVerifyPassword())){
    		addActionError("Candidate Verify Password can't be empty !!");
    	}
    	if(!isEmpty(getCandidatePassword()) && !isEmpty(getVerifyPassword()) && !getCandidatePassword().equals(getVerifyPassword())){
			addActionError("Password and Verify Password Must be Same !!");
    	}
    	if(isEmpty(getCandidatePhoneNo())){
    		addActionError("Candidate Phone No can't be empty !!");
    	}
    	if(isNumberNullOrZero(getSkillSetId())){
    		addActionError("Candidate Skill Set can't be empty !!");
    	}
    	if(isEmpty(getCandidateAddressLine1())){
    		addActionError("Candidate Address Line 1 can't be empty !!");
    	}
    	if(isEmpty(getCandidateCity())){
    		addActionError("Candidate City can't be empty !!");
    	}
    	if(isEmpty(getCandidateState())){
    		addActionError("Candidate State can't be empty !!");
    	}
    	if(isEmpty(getCandidateCountry())){
    		addActionError("Candidate Country Name can't be empty !!");
    	}
    	if(isEmpty(getCandidateZipcode())){
    		addActionError("Candidate Zipcode can't be empty !!");
    	}
    	if(isEmpty(getCandidatePrefferedLocation())){
    		addActionError("Candidate Preffered Location can't be empty !!");
    	}
    	if(isEmpty(getCandidateExpectedSalary())){
    		addActionError("Candidate Expected Salary can't be empty !!");
    	}
    	if(isFileNull(getResume())){
    		addActionError("Resume can't be empty !!");
    	}
    }
	
	@SuppressWarnings("unchecked")
	public String authenticateCandidate(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_CANDIDATE_LOGIN;
			authenticateCandidateValidator();
			if(!hasActionErrors()){
				candidate = candidateBo.getCandidate(candidateEmailId, candidatePassword);
				if(candidate!=null){
					session.put("candidate", candidate);
				}else{
					urlPage = URL_PAGE_CANDIDATE_LOGIN;
					addActionError("Candidate doen't found with given Email Id and Password!!");
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
        if(isEmpty(getCandidateEmailId())){
    		addActionError("Candidate Email Id can't be empty !!");
    	}
    	if(isEmpty(getCandidatePassword())){
    		addActionError("Candidate Password can't be empty !!");
    	}
    }
	
	public String getLocationListByLatitudeLongitude(){
		try{
			getGlobalContent();
			
			getLocationListByLatitudeLongitudeValidator();
			if(!hasActionErrors()){
				locationList = locationBo.listLocationByLatitudeAndLongitude(latitude, longitude);
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void getLocationListByLatitudeLongitudeValidator(){
        if(isEmpty(getLocationZipcode())){
    		addActionError("Zipcode can't be empty !!");
    	}
        if(isDoubleNullOrZero(getLatitude())){
    		addActionError("Latitude can't be Empty / Zero !!");
    	}
    	if(isDoubleNullOrZero(getLongitude())){
    		addActionError("Longitude can't be Empty / Zero !!");
    	}
    }
	
	public String getLocationScheduleTimingListByLocationId(){
		try{
			getGlobalContent();
			if(!isNumberNullOrZero(getLocationId())){
				locationScheduleTimingList = locationScheduleTimingBo.searchLocationScheduleTiming(null, locationId, DateHelper.getCurrentUtilDate(), 
						DateHelper.addTwoDaysToDate(), null, null, null, null, ACTIVE, 0, 50);
			}else{
				addActionError("Location Id can't be Empty / Zero !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}


	// Schedule Verification
	
	public String getCandidateScheduleVerificationPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduleVerification";
				employerList = new ArrayList<Employer>();
				candidateEmployerSkillSetMapList = candidateEmployerSkillSetMapBo.searchCandidateEmployerSkillSetMap(null, candidate.getCandidateId(), null, null, INACTIVE, INACTIVE, pageSize);
				if(candidateEmployerSkillSetMapList!=null && !candidateEmployerSkillSetMapList.isEmpty()){
					for(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap : candidateEmployerSkillSetMapList){
						employer = employerBo.getEmployerByEmployerId(candidateEmployerSkillSetMap.getEmployerId());
						candidateEmployerSkillSetMap.setEmployer(employer);
					}
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String saveCandidateScheduleVerification(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduleVerification";

				saveCandidateScheduleVerificationValidator();
				if(isNumberNullOrZero(getCandidateEmployerSkillSetMapId())){
					employerId = 0;

					// Getting Available Credits of Candidate
					creditsAvailable = creditsAvailableBo.getCreditsAvailable(candidate.getCandidateId(), CANDIDATE);
					
					// Returning Error Page if Candidate Entry is Not Present in the Credits Available Table 
					if(creditsAvailable==null){
						addActionError("Contact Admin to Add Credits for Your Account !!");
						return "noCreditEntry";
					}else if(creditsAvailable.getNoOfCreditsAvailable()<1){
						
						urlPage = "candidateScheduleVerification";
						employerList = new ArrayList<Employer>();
						candidateEmployerSkillSetMapList = candidateEmployerSkillSetMapBo.searchCandidateEmployerSkillSetMap(null, candidate.getCandidateId(), null, null, INACTIVE, INACTIVE, pageSize);
						if(candidateEmployerSkillSetMapList!=null && !candidateEmployerSkillSetMapList.isEmpty()){
							for(CandidateEmployerSkillSetMap candidateEmployerSkillSetMap : candidateEmployerSkillSetMapList){
								employer = employerBo.getEmployerByEmployerId(candidateEmployerSkillSetMap.getEmployerId());
								candidateEmployerSkillSetMap.setEmployer(employer);
							}
						}
						
						addActionError("Please Add Credits To your Account to Schedule Interview !!");
						return "credits";
					}
					
				}else{
					candidateEmployerSkillSetMap = candidateEmployerSkillSetMapBo.getCandidateEmployerSkillSetMap(candidateEmployerSkillSetMapId);
					if(candidateEmployerSkillSetMap!=null){
						employerId = candidateEmployerSkillSetMap.getEmployerId();
						skillSetId = candidateEmployerSkillSetMap.getSkillSetId();
					}else{
						addActionError("Can't find Candidate Employer Skill Set with the Given Form Fields !!");
						return "failure";
					}
				}
					
				if(!hasActionErrors()){
						locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(locationScheduleTimingId);
						if(locationScheduleTiming!=null){

							location = locationBo.getLocationByLocationId(locationScheduleTiming.getLocationId());

							propertie = propertieBo.getPropertie();
							
							if(employerId!=0){
								skillSet = skillSetBo.getSkillSetBySkillSetId(skillSetId);
							}else{
								skillSet = skillSetBo.getSkillSetBySkillSetId(candidate.getSkillSetId());
							}
							
							if(employerId!=0){
								
								candidateScheduleTiming = new CandidateScheduleTiming(candidate.getCandidateId(), locationId, INACTIVE, 
										locationScheduleTimingId, skillSetId, locationScheduleTiming.getLocationScheduleFromTime(), 
										locationScheduleTiming.getLocationScheduleToTime(), "", CandidatePerformance.UNDER_PROCESS.getValue(), InterviewStatus.APPLIED.getValue(), "", 
										employerId, candidate.getCandidateId(), candidate.getCandidateId(), new Date(), new Date(), ACTIVE);
								candidateScheduleTimingBo.addCandidateScheduleTiming(candidateScheduleTiming);
								
								candidateEmployerSkillSetMap.setIsScheduled(ACTIVE);
								candidateEmployerSkillSetMapBo.updateCandidateEmployerSkillSetMap(candidateEmployerSkillSetMap);
								
							}else{
								
								candidateScheduleTiming = new CandidateScheduleTiming(candidate.getCandidateId(), locationId, INACTIVE, 
										locationScheduleTimingId, candidate.getSkillSetId(), locationScheduleTiming.getLocationScheduleFromTime(), 
										locationScheduleTiming.getLocationScheduleToTime(), "", CandidatePerformance.UNDER_PROCESS.getValue(), InterviewStatus.APPLIED.getValue(), "", 
										employerId, candidate.getCandidateId(), candidate.getCandidateId(), new Date(), new Date(), ACTIVE);
								candidateScheduleTimingBo.addCandidateScheduleTiming(candidateScheduleTiming);
								
								// Deducting Credit From Candidate
								int noOfCreditsAvailable = creditsAvailable.getNoOfCreditsAvailable() - 1;
								creditsAvailable.setNoOfCreditsAvailable(noOfCreditsAvailable);
								creditsAvailable.setLastModified(new Date());
								creditsAvailableBo.updateCreditsAvailable(creditsAvailable);
								
							}

							// Email To Candidate
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.CANDIDATE_SCHEDULED_TIME_SLOT_SELECT_BY_CANDIDATE_EMAIL_TO_CANDIDATE.getValue());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null){									
								Helper.candidateTimeSlotSelectedEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
										candidate.getCandidateEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
										location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
										location.getLocationPhoneNo(), locationScheduleTiming.getLocationScheduleFromTime(), locationScheduleTiming.getLocationScheduleToTime());
							}

							// Email To Employer
							if(employerId!=0){
								employer = employerBo.getEmployerByEmployerId(employerId);
								secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.CANDIDATE_SCHEDULED_TIME_SLOT_SELECT_BY_CANDIDATE_EMAIL_TO_EMPLOYER.getValue());
								if(propertie!=null && secureVerifyEmailSubjectBody!=null){									
									Helper.candidateTimeSlotSelectedEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
											employer.getEmployerEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
											location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
											location.getLocationPhoneNo(), locationScheduleTiming.getLocationScheduleFromTime(), locationScheduleTiming.getLocationScheduleToTime());
								}
							}
							
							// Email To Interviewer
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.CANDIDATE_SCHEDULED_TIME_SLOT_SELECT_BY_CANDIDATE_EMAIL_TO_INTERVIEWER.getValue());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null){
								interviewerList = interviewerBo.getInterviewerListBySkillSet(skillSet.getSkillSetId());
								if(interviewerList!=null && !interviewerList.isEmpty()){
									for(Interviewer interviewer : interviewerList){
										Helper.candidateTimeSlotSelectedEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
												interviewer.getInterviewerEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
												location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
												location.getLocationPhoneNo(), locationScheduleTiming.getLocationScheduleFromTime(), locationScheduleTiming.getLocationScheduleToTime());
									}
								}
							}

							// Email To Agent
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.CANDIDATE_SCHEDULED_TIME_SLOT_SELECT_BY_CANDIDATE_EMAIL_TO_AGENT.getValue());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null){
								agent = agentBo.getAgentByAgentId(location.getLocationPrimaryAgentId());
								if(agent!=null && agent.getAgentEmailId()!=null && !agent.getAgentEmailId().equals("")){
									Helper.candidateTimeSlotSelectedEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
											agent.getAgentEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
											location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
											location.getLocationPhoneNo(), locationScheduleTiming.getLocationScheduleFromTime(), locationScheduleTiming.getLocationScheduleToTime());
								}
								if(location.getLocationSecondaryAgentId()!=null && location.getLocationSecondaryAgentId()!=0){
									agent = agentBo.getAgentByAgentId(location.getLocationSecondaryAgentId());
									if(agent!=null && agent.getAgentEmailId()!=null && !agent.getAgentEmailId().equals("")){
										Helper.candidateTimeSlotSelectedEmails(propertie, secureVerifyEmailSubjectBody.getEmailSubject(), secureVerifyEmailSubjectBody.getEmailBody(), 
											agent.getAgentEmailId(), skillSet.getPrimarySkillSet(), location.getLocationName(), 
											location.getLocationAddressLine1()+", "+location.getLocationCity()+", "+location.getLocationCountry()+", "+location.getLocationZipcode(), 
											location.getLocationPhoneNo(), locationScheduleTiming.getLocationScheduleFromTime(), locationScheduleTiming.getLocationScheduleToTime());
									}
								}
							}

							candidateCouponMap = new CandidateCouponMap(candidate.getCandidateId(), coupon.getCouponId(), employerId, new Date());
							candidateCouponMapBo.addCandidateCouponMap(candidateCouponMap);
							
						}else{
							addActionError("Invalid Location Schedule Timing !!");
							return "failure";
						}
				}else{
					addActionError("Invalid Form Fields !!");
					return "failure";
				}
				
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveCandidateScheduleVerificationValidator(){
        if(isNumberNullOrZero(getLocationId())){
    		addActionError("Location Id can't be Empty / Zero !!");
    	}
        if(isNumberNullOrZero(getLocationScheduleTimingId())){
    		addActionError("Location Schedule Timing Id can't be Empty / Zero !!");
    	}
    }
	
	
	// Scheduled Time Slots
	
	public String getCandidateScheduledTimeSlotsPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduledTimeSlots";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByCandidateIdInterviewStatusListCount(
						candidate.getCandidateId(), InterviewStatus.APPLIED.getValue());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(
						null, candidate.getCandidateId(), null, null, null, null, null, null, null, null, null, null, CandidatePerformance.UNDER_PROCESS.getValue(), 
						InterviewStatus.APPLIED.getValue(), null, null, null, null, null, null, ACTIVE, startRecord, pageSize);
				
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						if(skillSet!=null){
							candidateScheduleTiming.setSkillSet(skillSet);
						}
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						if(location!=null){
							candidateScheduleTiming.setLocation(location);
						}
					}
				}
				
						
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getCandidateScheduledTimeSlotsSearchPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduledTimeSlots";
				
				if(scheduleFromTime!=null && !scheduleFromTime.equals("")){
					locationScheduleFromTime = DateHelper.getUtilDateTimeFromString(scheduleFromTime);
				}
				if(scheduleToTime!=null && !scheduleToTime.equals("")){
					locationScheduleToTime = DateHelper.getUtilDateTimeFromString(scheduleToTime);
				}
				
				totalSize = candidateScheduleTimingBo.searchCandidateScheduleTimingListCount(candidateScheduleTimingId, candidateId, null, null, null, null, null, null, null, null, null, null, 
						null, null, InterviewStatus.SCHEDULED.getValue(), null, null, null,	null, locationScheduleFromTime, locationScheduleToTime,null);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(
						null, candidate.getCandidateId(), null, null, null, null, null, null, null, null, null, null, null, 
						InterviewStatus.SCHEDULED.getValue(), null, null, null, null, locationScheduleFromTime, locationScheduleToTime, null, startRecord, pageSize);
				
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						if(skillSet!=null){
							candidateScheduleTiming.setSkillSet(skillSet);
						}
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						if(location!=null){
							candidateScheduleTiming.setLocation(location);
						}
					}
				}
				
			
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String viewCandidateScheduledDetails(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduledTimeSlots";
				if(!isNumberNullOrZero(getCandidateScheduleTimingId())){
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming!=null){
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(candidateScheduleTiming.getLocationScheduleTimingId());
					}else{
						addActionError("Scheduled Time Slot does not Exist !!");
						return ERROR;
					}
				}else{
					addActionError("Candidate Schedule Timing Not Found with the Given Details !!");
					return ERROR;
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String editCandidateScheduleVerification(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduledTimeSlots";
				if(!isNumberNullOrZero(getCandidateScheduleTimingId())){
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
					locationScheduleTimingList = locationScheduleTimingBo.searchLocationScheduleTiming(null, candidateScheduleTiming.getLocationId(), 
						DateHelper.getCurrentUtilDate(), DateHelper.addTwoDaysToDate(), null, null, null, null, ACTIVE, 0, 50);
				}else{
					addActionError("Candidate Schedule Timing Not Found with the Given Details !!");
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateCandidateScheduleVerification(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduledTimeSlots";
				updateCandidateScheduleVerificationValidator();
				if(!hasActionErrors()){
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming!=null){
						locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(locationScheduleTimingId);
						if(locationScheduleTiming!=null){
							candidateScheduleTiming.setLocationId(locationScheduleTiming.getLocationId());
							candidateScheduleTiming.setLocationScheduleTimingId(locationScheduleTimingId);
							candidateScheduleTiming.setCandidateScheduleFromTime(locationScheduleTiming.getLocationScheduleFromTime());
							candidateScheduleTiming.setCandidateScheduleToTime(locationScheduleTiming.getLocationScheduleToTime());
							candidateScheduleTimingBo.updateCandidateScheduleTiming(candidateScheduleTiming);
						}else{
							addActionError("Location Schedule Not Found with the Given Details");
							location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
							locationScheduleTiming = locationScheduleTimingBo.getLocationScheduleTimingByLocationScheduleTimingId(candidateScheduleTiming.getLocationScheduleTimingId());
							return "candidateScheduleVerification";
						}
					}else{
						addActionError("Candidate Schedule Timing not Found with the Given Details");
						return "candidateScheduleVerification";
					}
				}else{
					return "candidateScheduleVerification";
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateCandidateScheduleVerificationValidator(){
        if(isNumberNullOrZero(getLocationId())){
    		addActionError("Location Id can't be Empty / Zero !!");
    	}
        if(isNumberNullOrZero(getLocationScheduleTimingId())){
    		addActionError("Location Schedule Timing Id can't be Empty / Zero !!");
    	}
        if(isNumberNullOrZero(getCandidateScheduleTimingId())){
    		addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
    	}
    }
	
	
	// Scheduled Interviews
	
	public String getCandidateScheduledInterviewsPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduledInterviews";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByCandidateIdInterviewStatusListCount(
						candidate.getCandidateId(), InterviewStatus.SCHEDULED.getValue());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				skillSetList = skillSetBo.listActiveSkillSet();
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(
						null, candidate.getCandidateId(), null, null, null, null, null, null, null, null, null, null, CandidatePerformance.UNDER_PROCESS.getValue(), 
						InterviewStatus.SCHEDULED.getValue(), null, null, null, null, null, null, ACTIVE, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						if(skillSet!=null){
							candidateScheduleTiming.setSkillSet(skillSet);
						}
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						if(interviewer!=null){
							candidateScheduleTiming.setInterviewer(interviewer);
						}
					}
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getCandidateScheduledInterviewsSearchPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduledInterviews";
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
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						if(skillSet!=null){
							candidateScheduleTiming.setSkillSet(skillSet);
						}
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						if(interviewer!=null){
							candidateScheduleTiming.setInterviewer(interviewer);
						}
					}
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewCandidateScheduledInterviews(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateScheduledInterviews";
				if(!isNumberNullOrZero(getCandidateScheduleTimingId())){
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
					location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
					interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
				}else{
					addActionError("Candidate Schedule Timing Not Found withe the Given details !!");
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	//  Interviews Feedback
	
	public String getCandidateInterviewFeedbackPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateInterviewFeedback";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByCandidateIdInterviewStatusListCount(
						candidate.getCandidateId(), InterviewStatus.INTERVIEWED.getValue());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(
						null, candidate.getCandidateId(), null, null, null, null, null, null, null, null, null, null, null, 
						null, InterviewStatus.INTERVIEWED.getValue(), null, null, null, null, null, null, ACTIVE, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						if(skillSet!=null){
							candidateScheduleTiming.setSkillSet(skillSet);
						}
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						if(interviewer!=null){
							candidateScheduleTiming.setInterviewer(interviewer);
						}
					}
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getCandidateInterviewFeedbackSearchPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateInterviewFeedback";
				
				if(scheduleFromTime!=null && !scheduleFromTime.equals("")){
					locationScheduleFromTime = DateHelper.getUtilDateTimeFromString(scheduleFromTime);
				}
				if(scheduleToTime!=null && !scheduleToTime.equals("")){
					locationScheduleToTime = DateHelper.getUtilDateTimeFromString(scheduleToTime);
				}
				
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByInterviewerIdSkillSetIdInterviewStatusFromTimeToTimeListCount(
						null, skillSetId, InterviewStatus.INTERVIEWED.getValue(), locationScheduleFromTime, locationScheduleToTime,candidatePerformance);
				
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(
						null, candidate.getCandidateId(), null, null, null, null, null, null, null, locationScheduleFromTime, locationScheduleToTime, null, candidatePerformance, 
						InterviewStatus.INTERVIEWED.getValue(), null, null, null, null, null, null, null, startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						if(skillSet!=null){
							candidateScheduleTiming.setSkillSet(skillSet);
						}
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						if(interviewer!=null){
							candidateScheduleTiming.setInterviewer(interviewer);
						}
					}
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String viewCandidateInterviewFeedback(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateInterviewFeedback";
				if(!isNumberNullOrZero(getCandidateScheduleTimingId())){
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					feedbackList = feedbackBo.getFeedbacksByCandidateScheduleTimingId(candidateScheduleTimingId);
					skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
					location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
					interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
				}else{
					addActionError("Candidate Schedule Timing Not Found withe the Given details !!");
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getCandidateManageCertificationsPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateManageCertifications";
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, candidate.getCandidateId(), 
						null, null, null, null, null, null, null, null, null, null, null, null, InterviewStatus.INTERVIEWED.getValue(), 
						null, null, null, null, null, null, null, INACTIVE, pageSize);
				
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming tmpCandidateScheduleTiming : candidateScheduleTimingList){
						skillSet = skillSetBo.getSkillSetBySkillSetId(tmpCandidateScheduleTiming.getSkillSetId());
						tmpCandidateScheduleTiming.setSkillSet(skillSet);
					}
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Employer Scheduled Interviews
	
	public String getCandidateEmployerScheduledInterviewPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateEmployerScheduledInterview";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByCandidateIdEmployerScheduledListCount(candidate.getCandidateId());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				candidateScheduleTimingList = candidateScheduleTimingBo.getCandidateScheduleTimingByCandidateIdEmployerScheduled(candidate.getCandidateId(), startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						employer = employerBo.getEmployerByEmployerId(candidateScheduleTiming.getEmployerId());
						candidateScheduleTiming.setEmployer(employer);
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						candidateScheduleTiming.setSkillSet(skillSet);
					}
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getCandidateEmployerScheduledInterviewSearchPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateEmployerScheduledInterview";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingByCandidateIdEmployerScheduledListCount(candidate.getCandidateId());
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				candidateScheduleTimingList = candidateScheduleTimingBo.getCandidateScheduleTimingByCandidateIdEmployerScheduled(candidate.getCandidateId(), startRecord, pageSize);
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming candidateScheduleTiming : candidateScheduleTimingList){
						employer = employerBo.getEmployerByEmployerId(candidateScheduleTiming.getEmployerId());
						candidateScheduleTiming.setEmployer(employer);
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						candidateScheduleTiming.setSkillSet(skillSet);
					}
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String viewEmployerScheduledInterview(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateEmployerScheduledInterview";
				if(!isNumberNullOrZero(getCandidateScheduleTimingId())){
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
					location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
					employer = employerBo.getEmployerByEmployerId(candidateScheduleTiming.getEmployerId());
				}else{
					addActionError("Candidate Schedule Timing Not Found withe the Given details !!");
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Candidate Profile
	
	public String getCandidateUpdatePasswordPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateUpdatePassword";
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
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
	public String updateCandidatePassword(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateUpdatePassword";
				
				agentUpdatePasswordValidator();
				if(!hasActionErrors()){
					if(candidate.getCandidatePassword().equals(currentPassword)){
						candidate.setCandidatePassword(candidatePassword);
						candidateBo.updateCandidate(candidate);
						session.put("interviewer", interviewer);
						
						addActionMessage("Updated Password Successfully !!");
					}else{
						addActionError("Your Current Password is Invalid !!");
						return "failure";
					}
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
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
    	if(isEmpty(getCandidatePassword())){
			addActionError("New Password can't be empty !!");
    	}
    	if(isEmpty(getRetypePassword())){
			addActionError("Retype Password can't be empty !!");
    	}
    	if(!isEmpty(getCandidatePassword()) && !isEmpty(getRetypePassword()) && !getCandidatePassword().equals(getRetypePassword())){
			addActionError("New Password and Retype Password Must be Same !!");
    	}
    }
	
	public String getCandidateUpdateProfilePage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateUpdateProfile";
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public String updateCandidateProfile(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateUpdateProfile";
				
				updateCandidateProfileValidator();
				if(!hasActionErrors()){
					candidate.setCandidateFirstName(candidateFirstName);
					candidate.setCandidateLastName(candidateLastName);
					candidate.setCandidatePhoneNo(candidatePhoneNo);
					candidate.setCandidatePhoneNoExtension(candidatePhoneNoExtension);
					candidate.setCandidateAlternatePhone(candidateAlternatePhone);
					candidate.setCandidateAlternatePhoneNoExtension(candidateAlternatePhoneNoExtension);
					if(resume!=null){
						InputStream in = new FileInputStream(resume.getAbsolutePath());
						XWPFDocument docIn = new XWPFDocument(in);  
			            XWPFWordExtractor extractor = new XWPFWordExtractor(docIn);  
			            String docText = extractor.getText();
						candidate.setCandidateResume(docText);
						candidate.setCandidateResumeBlob(IOUtils.toByteArray(new FileInputStream(resume.getAbsolutePath())));
					}
					candidate.setCandidateAddressLine1(candidateAddressLine1);
					candidate.setCandidateAddressLine2(candidateAddressLine2);
					candidate.setCandidateCity(candidateCity);
					candidate.setCandidateState(candidateState);
					candidate.setCandidateCountry(candidateCountry);
					candidate.setCandidateZipcode(candidateZipcode);
					candidate.setCandidatePrefferedLocation(candidatePrefferedLocation);
					candidate.setCandidateExpectedSalary(candidateExpectedSalary);
					candidateBo.updateCandidate(candidate);
					
					session.put("candidate", candidate);
				}
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateCandidateProfileValidator(){
        if(isEmpty(getCandidateFirstName())){
            addActionError("Candidate Firs tName can't be empty !!");
        }
    	if(isEmpty(getCandidateLastName())){
    		addActionError("Candidate Last Name can't be empty !!");
    	}
    	if(isEmpty(getCandidatePhoneNo())){
    		addActionError("Candidate Phone No can't be empty !!");
    	}
    	if(isEmpty(getCandidateAddressLine1())){
    		addActionError("Candidate Address Line 1 can't be empty !!");
    	}
    	if(isEmpty(getCandidateCity())){
    		addActionError("Candidate City can't be empty !!");
    	}
    	if(isEmpty(getCandidateState())){
    		addActionError("Candidate State can't be empty !!");
    	}
    	if(isEmpty(getCandidateCountry())){
    		addActionError("Candidate Country Name can't be empty !!");
    	}
    	if(isEmpty(getCandidateZipcode())){
    		addActionError("Candidate Zipcode can't be empty !!");
    	}
    	if(isEmpty(getCandidatePrefferedLocation())){
    		addActionError("Candidate Preffered Location can't be empty !!");
    	}
    	if(isEmpty(getCandidateExpectedSalary())){
    		addActionError("Candidate Expected Salary can't be empty !!");
    	}
    }
	
	public String getCandidateResumesHistory(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateResumesHistory";
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getVisaDetailsPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "visaDetails";
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	// Candidate Credits Management
	
	public String getCandidateCreditsPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateCredits";
				
				creditsAvailable = creditsAvailableBo.getCreditsAvailable(candidate.getCandidateId(), CANDIDATE);
				
				totalSize = paymentDetailBo.searchPaymentDetail(null, candidate.getCandidateId(), CANDIDATE, null, null, null, null, 
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				paymentDetailList = paymentDetailBo.searchPaymentDetail(null, candidate.getCandidateId(), CANDIDATE, transactionNumber, null, null, 
						null, null, null, null, null, null, null, invoiceNumber, null, null, null, null, null, null, null, null, couponId, 
						null, null, startRecord, pageSize);
				
				if(paymentDetailList!=null && !paymentDetailList.isEmpty()){
					
					for(PaymentDetail paymentDetail : paymentDetailList){
						coupon = couponBo.getCouponByCouponId(paymentDetail.getCouponId());
						paymentDetail.setCoupon(coupon);
					}
				}
				
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewCandidatePayments(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateCredits";
				if(!isNumberNullOrZero(getPartyTypeId())){
					paymentDetail = paymentDetailBo.getPaymentDetailByPartyTypeId(partyTypeId);
					if(paymentDetail==null){
						addActionError("Payment Details Doesn't Exist with the Given Party Id !!");
					}
					coupon = couponBo.getCouponByCouponId(paymentDetail.getCouponId());
					if(coupon!=null){
						coupon.getCouponCode();
					}
				}else{
					addActionError("Payment Details Id can't be Empty / Zero !!");
				}
			}else{
				addActionError(CANDIDATE_LOGIN_MSG);
				return ERROR;
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
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateCredits";
				
				creditsAvailable = creditsAvailableBo.getCreditsAvailable(candidate.getCandidateId(), CANDIDATE);
				
				totalSize = paymentDetailBo.searchPaymentDetail(null, candidate.getCandidateId(), CANDIDATE, null, null, null, null, 
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				paymentDetailList = paymentDetailBo.searchPaymentDetail(null, candidate.getCandidateId(), CANDIDATE, null, null, noOfCreditsBought, 
						null, null, null, paymentDate, null, null, null, null, null, null, null, null, null, null, null, null, null, 
						null, null, startRecord, pageSize);
			}else{
				urlPage = URL_PAGE_CANDIDATE_LOGIN;
				addActionError(CANDIDATE_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getBuyCandidateCreditsPage(){
		try{
			getGlobalContent();
			candidate = (Candidate) session.get("candidate");
			if(candidate!=null){
				urlPage = "candidateCredits";
				creditTypes = creditTypesBo.getCreditTypes(CANDIDATE);
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
				addActionError(CANDIDATE_LOGIN_MSG);
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
	public String getCandidateLogoutPage(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_CANDIDATE_LOGIN;
			candidate = null;
			session.put("candidate", candidate);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getForgotCandidatePassword(){
		try{
			getGlobalContent();
			urlPage = "forgotCandidatePassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getResetCandidatePassword(){
		try{
			getGlobalContent();
			urlPage = "forgotCandidatePassword";
			if(isEmpty(getCandidateEmailId())){
	    		addActionError("Candidate Email Id can't be empty !!");
	    		return "failure";
	    	}else{
				candidate = candidateBo.getCandidateByEmailId(candidateEmailId);
				if(candidate==null){
					addActionError("Invalid E-mail Id!!");
					return "failure";
				}
				urlPage = "resetCandidatePassword";
				UUID uuid = UUID.randomUUID();
				String verificationCode = uuid.toString().substring(0, 6);
				candidateBo.updateCandidate(candidate.getCandidateId(), verificationCode);
				propertie = propertieBo.getPropertie();
				secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.CANDIDATE_PASSWORD_RECOVERY.getValue());
				if(propertie!=null && secureVerifyEmailSubjectBody!=null){
					
					String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", candidateEmailId);
					String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", candidateEmailId).replaceAll("#password#", verificationCode);
					
					SecureVerifyMail.postMail(candidateEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
							propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
							propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
							propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
					
				}
				addActionMessage("An E-mail has been sent to your Email Id: "+candidateEmailId+" with Verification Code and a Link to Reset Your Password!!");
	    	}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getUpdateCandidatePasswordPage(){
		try{
			getGlobalContent();
			urlPage = "updateCandidatePassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String changeCandidatePassword(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_CANDIDATE_LOGIN;
			changeCandidatePasswordValidator();
			if(!hasActionErrors()){
				candidate = candidateBo.getCandidateByEmailId(candidateEmailId);
				if(candidate==null){
					addActionError("Candidate does not Exist with this Email Id !!");
					return "failure";
				}else{
					if(candidate.getVerificationCode()==null){
						addActionError("Please Go To the Forgot Password Page !!");
					}else{
						if(securitycode.equals(candidate.getVerificationCode())){
							candidateBo.updateCandidate(candidate.getCandidateId(), null, candidatePassword);
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

    public void changeCandidatePasswordValidator(){
        if(isEmpty(getCandidateEmailId())){
            addActionError("Candidate Email Id can't be empty !!");
        }
    	if(isEmpty(getSecuritycode())){
    		addActionError("Security code can't be empty !!");
    	}
    }
	
	
	
	
	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateEmailId() {
		return candidateEmailId;
	}

	public void setCandidateEmailId(String candidateEmailId) {
		this.candidateEmailId = candidateEmailId;
	}

	public String getCandidatePassword() {
		return candidatePassword;
	}

	public void setCandidatePassword(String candidatePassword) {
		this.candidatePassword = candidatePassword;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getLocationZipcode() {
		return locationZipcode;
	}

	public void setLocationZipcode(String locationZipcode) {
		this.locationZipcode = locationZipcode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	public LocationScheduleTiming getLocationScheduleTiming() {
		return locationScheduleTiming;
	}

	public void setLocationScheduleTiming(
			LocationScheduleTiming locationScheduleTiming) {
		this.locationScheduleTiming = locationScheduleTiming;
	}

	public List<LocationScheduleTiming> getLocationScheduleTimingList() {
		return locationScheduleTimingList;
	}

	public void setLocationScheduleTimingList(
			List<LocationScheduleTiming> locationScheduleTimingList) {
		this.locationScheduleTimingList = locationScheduleTimingList;
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

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
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

	public Integer getCandidateScheduleTimingId() {
		return candidateScheduleTimingId;
	}

	public void setCandidateScheduleTimingId(Integer candidateScheduleTimingId) {
		this.candidateScheduleTimingId = candidateScheduleTimingId;
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

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
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

	public String getCandidateResume() {
		return candidateResume;
	}

	public void setCandidateResume(String candidateResume) {
		this.candidateResume = candidateResume;
	}

	public String getCandidateAddressLine1() {
		return candidateAddressLine1;
	}

	public void setCandidateAddressLine1(String candidateAddressLine1) {
		this.candidateAddressLine1 = candidateAddressLine1;
	}

	public String getCandidateAddressLine2() {
		return candidateAddressLine2;
	}

	public void setCandidateAddressLine2(String candidateAddressLine2) {
		this.candidateAddressLine2 = candidateAddressLine2;
	}

	public String getCandidateCity() {
		return candidateCity;
	}

	public void setCandidateCity(String candidateCity) {
		this.candidateCity = candidateCity;
	}

	public String getCandidateState() {
		return candidateState;
	}

	public void setCandidateState(String candidateState) {
		this.candidateState = candidateState;
	}

	public String getCandidateCountry() {
		return candidateCountry;
	}

	public void setCandidateCountry(String candidateCountry) {
		this.candidateCountry = candidateCountry;
	}

	public String getCandidateZipcode() {
		return candidateZipcode;
	}

	public void setCandidateZipcode(String candidateZipcode) {
		this.candidateZipcode = candidateZipcode;
	}

	public String getCandidatePrefferedLocation() {
		return candidatePrefferedLocation;
	}

	public void setCandidatePrefferedLocation(String candidatePrefferedLocation) {
		this.candidatePrefferedLocation = candidatePrefferedLocation;
	}

	public String getCandidateExpectedSalary() {
		return candidateExpectedSalary;
	}

	public void setCandidateExpectedSalary(String candidateExpectedSalary) {
		this.candidateExpectedSalary = candidateExpectedSalary;
	}

	public File getResume() {
		return resume;
	}

	public void setResume(File resume) {
		this.resume = resume;
	}

	public List<SkillSet> getSkillSetList() {
		return skillSetList;
	}

	public void setSkillSetList(List<SkillSet> skillSetList) {
		this.skillSetList = skillSetList;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Integer getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}

	public Integer getFskillSetId() {
		return fskillSetId;
	}

	public void setFskillSetId(Integer fskillSetId) {
		this.fskillSetId = fskillSetId;
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

	public Integer getCandidatePerformance() {
		return candidatePerformance;
	}

	public void setCandidatePerformance(Integer candidatePerformance) {
		this.candidatePerformance = candidatePerformance;
	}
	public List<Employer> getEmployerList() {
		return employerList;
	}

	public void setEmployerList(List<Employer> employerList) {
		this.employerList = employerList;
	}

	public CandidateCouponMap getCandidateCouponMap() {
		return candidateCouponMap;
	}

	public void setCandidateCouponMap(CandidateCouponMap candidateCouponMap) {
		this.candidateCouponMap = candidateCouponMap;
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

	public Integer getCandidateEmployerSkillSetMapId() {
		return candidateEmployerSkillSetMapId;
	}

	public void setCandidateEmployerSkillSetMapId(
			Integer candidateEmployerSkillSetMapId) {
		this.candidateEmployerSkillSetMapId = candidateEmployerSkillSetMapId;
	}

	public List<Interviewer> getInterviewerList() {
		return interviewerList;
	}

	public void setInterviewerList(List<Interviewer> interviewerList) {
		this.interviewerList = interviewerList;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public CreditsAvailable getCreditsAvailable() {
		return creditsAvailable;
	}

	public void setCreditsAvailable(CreditsAvailable creditsAvailable) {
		this.creditsAvailable = creditsAvailable;
	}

	public Integer getPaymentDetailsId() {
		return paymentDetailsId;
	}

	public void setPaymentDetailsId(Integer paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}

	public CreditTypes getCreditTypes() {
		return creditTypes;
	}

	public void setCreditTypes(CreditTypes creditTypes) {
		this.creditTypes = creditTypes;
	}

	public List<PaymentDetail> getPaymentDetailList() {
		return paymentDetailList;
	}

	public void setPaymentDetailList(List<PaymentDetail> paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
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

	
	public Integer getPartyTypeId() {
		return partyTypeId;
	}

	
	public void setPartyTypeId(Integer partyTypeId) {
		this.partyTypeId = partyTypeId;
	}

	
}
