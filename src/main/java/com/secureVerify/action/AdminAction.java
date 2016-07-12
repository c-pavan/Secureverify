package com.secureVerify.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.secureVerify.model.Agent;
import com.secureVerify.model.Candidate;
import com.secureVerify.model.CandidateScheduleTiming;
import com.secureVerify.model.Coupon;
import com.secureVerify.model.CreditTypes;
import com.secureVerify.model.Employer;
import com.secureVerify.model.Interviewer;
import com.secureVerify.model.Location;
import com.secureVerify.model.LocationScheduleTiming;
import com.secureVerify.model.PaymentDetail;
import com.secureVerify.model.SecureVerifyEmailType;
import com.secureVerify.model.SkillSet;
import com.secureVerify.model.User;
import com.secureVerify.util.DateHelper;
import com.secureVerify.util.SecureVerifyMail;

public class AdminAction extends MasterAction {

	private static final long serialVersionUID = -3258323330913960346L;

	private static final Logger log = Logger.getLogger(AdminAction.class);
	private static final String ADMIN_LOGIN_MSG = "Please Login into Admin !!";
	private static final String URL_PAGE_ADMIN_LOGIN = "adminLogin";
	
	private InputStream inputStream;
	
	private File resume;
		
	private String scheduleFromTime;
	private String scheduleToTime;
	
	private Integer candidateScheduleTimingId;
	private CandidateScheduleTiming candidateScheduleTiming;

	
	// Employer
	private Integer employerId;
	private String employerFirstName;
	private String employerLastName;
	private String employerEmailId;
	private String employerPassword;
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
	private String verificationCode;
	private String verifyPassword;
	private Integer status;
	
	// Candidate
	private Integer candidateId;
	private String candidateFirstName;
	private String candidateLastName;
	private String candidateEmailId;
	private String candidatePassword;
	private String candidatePhoneNo;
	private String candidatePhoneNoExtension;
	private String candidateAlternatePhone;
	private String candidateAlternatePhoneNoExtension;
	private String candidateResume;
	private String candidateAddressLine1;
	private String candidateAddressLine2;
	private String candidateCity;
	private String candidateState;
	private String candidateCountry;
	private String candidateZipcode;
	private String candidatePrefferedLocation;
	private String candidateExpectedSalary;
	
	// Agent
	private Integer agentId;
	private String agentFirstName;
	private String agentLastName;
	private String agentEmailId;
	private String agentPassword;
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
	
	// User
	private Integer userId;
	private String userEmailId;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userPhoneNo;
	private String userAddressLine1;
	private String userAddressLine2;
	private String userCity;
	private String userState;
	private String userCountry;
	private String userZipcode;
	private String userDesignation;
	
	// Skill Set
	private Integer skillSetId;
	private String primarySkillSet;
	private String skillSetCategory;
	
	// LocationScheduleTiming
	private Integer locationScheduleTimingId;
	private Date locationScheduleFromTime;
	private Date locationScheduleToTime;
	
	private Date candidateScheduleFromTime;
	private Date candidateScheduleToTime;
	private Integer interviewStatus;
	private String candidateUniqueId;
		
	// Location
	private Integer locationId;
	private String locationName;
	private String locationBusinessName;
	private String locationAddressLine1;
	private String locationAddressLine2;
	private String locationCity;
	private String locationState;
	private String locationCountry;
	private String locationZipcode;
	private String locationPhoneNo;
	private String locationPhoneNoExtension;
	private String locationAlternatePhone;
	private String locationAlternatePhoneNoExtension;
	private Integer locationPrimaryAgentId;
	private Integer locationSecondaryAgentId;
	private Double latitude;
	private Double longitude;
	
	// Coupon
	private Integer couponId;
	private String couponCode;
	private String couponName;
	private BigDecimal discountPercentage;
	private BigDecimal discountAmount;
	private Date expiryDate;
	private Date expiryFromDate;
	private Date expirytoDate;
	private String sexpiryDate;
	
	private String fromDate;
	private String toDate;

	
	private Candidate candidate;
	private Candidate vCandidate;
	private Employer employer;
	private Employer vEmployer;
	private Agent agent;
	private Agent vAgent;
	private Interviewer interviewer;
	private Interviewer vInterviewer;
	private SkillSet skillSet;
	private SkillSet vSkillSet;
	private Location location;
	private LocationScheduleTiming locationScheduleTiming;
	private Location vLocation;
	private Coupon coupon;
	private Coupon vCoupon;
	private User vUser;
	
	private List<Interviewer> interviewerList;
	private List<SkillSet> skillSetList;
	private List<Location> locationList;
	private List<LocationScheduleTiming> locationScheduleTimingList;
	private List<CandidateScheduleTiming> candidateScheduleTimingList;
	private List<Agent> agentList;
	private List<Coupon> couponList;
	private List<Candidate> candidateList;
	private List<Employer> employerList;
	
	//Credit Types
	private Integer creditTypesId;
	private Integer creditType;
	private String description;
	private BigDecimal amount;
	private CreditTypes creditTypes;
	private List<CreditTypes> creditTypesList;
	
	// Payment Details
	private Integer paymentDetailsId;
	private Integer partyId;
	private Integer partyTypeId;
	private String transactionNumber;
	private BigDecimal priceOfCredit;
	private Integer noOfCreditsBought;
	private BigDecimal totalAmount;
	private Date paymentDate;
	private String authResponse;
	private String avsResponse;
	private String approved;
	private String invoiceNumber;
	private String firstName;
	private String lastName;
	private String expMonth;
	private String expYear;
	private String address;
	private String zip;
	private String emailId;
	private String phone;
	private Date lastModified;
	private List<PaymentDetail> paymentDetailList;
	private PaymentDetail paymentDetail;

	// Admin Login

	@SuppressWarnings("unchecked")
	public String authenticateAdmin(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_ADMIN_LOGIN;
			authenticateAdminValidator();
			if(!hasActionErrors()){
				user = userBo.getUser(userEmailId, userPassword);
				if(user!=null){
					session.put("user", user);
				}else{
					addActionError("Admin doen't found with given Email Id and Password !!");
					return "failure";
				}
			}else{
				addActionError("Email Id / Password can't be Empty !!");
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void authenticateAdminValidator(){
        if(isEmpty(getUserEmailId())){
            addActionError("Email Id can't be empty !!");
        }
        if(isEmpty(getUserPassword())){
            addActionError("Password can't be empty !!");
        }
    }
	
	@SuppressWarnings("unchecked")
	public String getAdminLogoutPage(){
		try{
			getGlobalContent();
			urlPage = "adminLogout";
			user = null;
			session.put("user", user);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String getAdminPage(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_ADMIN_LOGIN;
			session.put("user", null);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

		
	// Interviewer
	
	public String getAdminInterviewerPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			urlPage = "adminInterviewer";
			if(user!=null){
				totalSize = interviewerBo.getInterviewerListCount();
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				interviewerList = interviewerBo.getInterviewerListByPage(startRecord, pageSize);
				skillSetList = skillSetBo.listActiveSkillSet();
				
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAdminInterviewerSearchPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			urlPage = "adminInterviewer";
			if(user!=null){
				
				totalSize = interviewerBo.getInterviewerListCount(interviewerFirstName, interviewerEmailId, interviewerPhoneNo, skillSetId, ACTIVE);
				
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				interviewerList = interviewerBo.searchInterviewer(interviewerFirstName, interviewerEmailId, interviewerPhoneNo, skillSetId, ACTIVE, startRecord, pageSize);
				
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void getAdminInterviewerSearchPageValidator(){
        if(isEmpty(getInterviewerFirstName()) && isEmpty(getInterviewerEmailId()) && isEmpty(getInterviewerPhoneNo()) && isNumberNullOrZero(getSkillSetId())){
            addActionError("Please Provide at least one value to Search !!");
        }
    }
	
	public String getAddInterviewerPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminInterviewer";
				skillSetList = skillSetBo.listActiveSkillSet();
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
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
	public String saveInterviewer(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminInterviewer";
				
				saveInterviewerValidator();
	            if(!hasActionErrors()){

	            	interviewer = interviewerBo.getInterviewerByEmailId(interviewerEmailId);
	            	if(interviewer!=null){
	            		addActionError("Interviewer All ready Registered with the Given Email Id : "+interviewerEmailId+" !!");
						return "interviewer";
					}
	            	
					InputStream in = new FileInputStream(resume.getAbsolutePath());
					XWPFDocument docIn = new XWPFDocument(in);  
		            XWPFWordExtractor extractor = new XWPFWordExtractor(docIn);  
		            String docText = extractor.getText();
		            
					interviewer = new Interviewer();
					interviewer.setInterviewerFirstName(interviewerFirstName);
					interviewer.setInterviewerLastName(interviewerLastName);
					interviewer.setInterviewerEmailId(interviewerEmailId);
					interviewer.setInterviewerPassword(interviewerPassword);
					interviewer.setInterviewerPhoneNo(interviewerPhoneNo);
					interviewer.setInterviewerPhoneNoExtension(interviewerPhoneNoExtension);
					interviewer.setInterviewerAlternatePhone(interviewerAlternatePhone);
					interviewer.setInterviewerAlternatePhoneNoExtension(interviewerAlternatePhoneNoExtension);
					interviewer.setInterviewerSkillSet1(interviewerSkillSet1);
					interviewer.setInterviewerSkillSet2(interviewerSkillSet2);
					interviewer.setInterviewerSkillSet3(interviewerSkillSet3);
					interviewer.setInterviewerResume(docText);
					interviewer.setInterviewerResumeBlob(IOUtils.toByteArray(new FileInputStream(resume.getAbsolutePath())));
					interviewer.setCreatedBy(user.getUserId());
					interviewer.setLastModifiedBy(user.getUserId());
					interviewer.setCreationDate(new Date());
					interviewer.setLastModifiedTime(new Date());
					interviewer.setStatus(ACTIVE);
					interviewerBo.addInterviewer(interviewer);
					
					propertie = propertieBo.getPropertie();
					// Email To Admin
					secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.ADMIN_SAVE_INTERVIEWER_EMAIL_TO_ADMIN.getValue());
					if(propertie!=null && secureVerifyEmailSubjectBody!=null){									

						String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", interviewerEmailId);
						String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", interviewerEmailId).replaceAll("#password#", interviewerPassword);
						
						SecureVerifyMail.postMail(user.getUserEmailId(), propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
								propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
								propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
								propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
						
					}

					// Email To Interviewer
					secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.ADMIN_SAVE_INTERVIEWER_EMAIL_TO_INTERVIEWER.getValue());
					if(propertie!=null && secureVerifyEmailSubjectBody!=null){									

						String subject = secureVerifyEmailSubjectBody.getEmailSubject();
						String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", interviewerEmailId).replaceAll("#password#", interviewerPassword);
						
						SecureVerifyMail.postMail(interviewerEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
								propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
								propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
								propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
						
					}

	            }else{
	            	skillSetList = skillSetBo.listActiveSkillSet();
	            	return "interviewer";
	            }
	            
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveInterviewerValidator(){
        if(isEmpty(getInterviewerFirstName())){
            addActionError("Interviewer First Name can't be empty !!");
        }
        if(isEmpty(getInterviewerLastName())){
            addActionError("Interviewer Last Name can't be empty !!");
        }
        if(isEmpty(getInterviewerEmailId())){
            addActionError("Interviewer Email Id can't be empty !!");
        }
        if(isEmpty(getInterviewerPassword())){
            addActionError("Interviewer Password can't be empty !!");
        }
        if(isEmpty(getInterviewerPhoneNo())){
            addActionError("Interviewer Phone Number can't be empty !!");
        }
        if(isNumberNullOrZero(getInterviewerSkillSet1())){
            addActionError("Interviewer Skill Set 1 can't be empty !!");
        }
        if(isFileNull(getResume())){
            addActionError("Resume can't be empty !!");
        }
    }
	
	public String getEditInterviewerPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){ 
				if(!isNumberNullOrZero(getInterviewerId())){
					urlPage = "adminInterviewer";
					interviewer = interviewerBo.getInterviewerByInterviewerId(interviewerId);
					if(interviewer==null){
						addActionError("Interviewer Does Not Exist with the Given Interviewer Id !!");
						return INPUT;
					}
					skillSetList = skillSetBo.listActiveSkillSet();
				}else{
					addActionError("Interviewer Id can't be Empty / Zero !!");
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
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
	public String updateInterviewer(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminInterviewer";
				
				if(!isNumberNullOrZero(getInterviewerId())){
					interviewer = interviewerBo.getInterviewerByInterviewerId(interviewerId);
					if(interviewer==null){
						addActionError("Interviewer Does Not Exist with the Given Interviewer Id !!");
						return "interviewer";
					}else{
						
						updateInterviewerValidator();
						
			            if(!hasActionErrors()){
			            
							interviewer.setInterviewerFirstName(interviewerFirstName);
							interviewer.setInterviewerLastName(interviewerLastName);
							interviewer.setInterviewerEmailId(interviewerEmailId);
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
							
							interviewer.setLastModifiedBy(user.getUserId());
							interviewer.setLastModifiedTime(new Date());
							interviewer.setStatus(ACTIVE);
							interviewerBo.updateInterviewer(interviewer);
							
							propertie = propertieBo.getPropertie();
							
							// Email To Admin
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.ADMIN_UPDATE_INTERVIEWER_EMAIL_TO_ADMIN.getValue());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null){									
	
								String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", interviewer.getInterviewerEmailId());
								String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", interviewer.getInterviewerEmailId()).replaceAll("#password#", interviewer.getInterviewerPassword());
								
								SecureVerifyMail.postMail(user.getUserEmailId(), propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
										propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
										propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
										propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
								
							}
	
							// Email To Interviewer
							secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.ADMIN_UPDATE_INTERVIEWER_EMAIL_TO_INTERVIEWER.getValue());
							if(propertie!=null && secureVerifyEmailSubjectBody!=null){									
	
								String subject = secureVerifyEmailSubjectBody.getEmailSubject();
								String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", interviewer.getInterviewerEmailId()).replaceAll("#password#", interviewer.getInterviewerPassword());
								
								SecureVerifyMail.postMail(interviewer.getInterviewerEmailId(), propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
										propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
										propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
										propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
								
							}
							
			            }else{
			            	interviewer = interviewerBo.getInterviewerByInterviewerId(interviewerId);
			            	skillSetList = skillSetBo.listActiveSkillSet();
			            	return "interviewer";
			            }
			            
					}
				}else{
					addActionError("Interviewer Id can't be Empty / Zero !!");
					return "interviewer";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateInterviewerValidator(){
        if(isEmpty(getInterviewerFirstName())){
            addActionError("Interviewer First Name can't be empty !!");
        }
        if(isEmpty(getInterviewerLastName())){
            addActionError("Interviewer Last Name can't be empty !!");
        }
        if(isEmpty(getInterviewerEmailId())){
            addActionError("Interviewer Email Id can't be empty !!");
        }
        if(isEmpty(getInterviewerPhoneNo())){
            addActionError("Interviewer Phone Number can't be empty !!");
        }
        if(isNumberNullOrZero(getInterviewerSkillSet1())){
            addActionError("Interviewer Skill Set 1 can't be empty !!");
        }
    }
	
	public String viewInterviewer(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminInterviewer";
				if(!isNumberNullOrZero(getInterviewerId())){
					interviewer = interviewerBo.getInterviewerByInterviewerId(interviewerId);
					if(interviewer==null){
						addActionError("Interviewer Does Not Exist with the Given Interviewer Id !!");
						return ERROR;
					}else{
						vUser = userBo.getUser(interviewer.getCreatedBy());
						if(vUser!=null){
							interviewer.setCreatedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
						vUser = userBo.getUser(interviewer.getLastModifiedBy());
						if(vUser!=null){
							interviewer.setLastModifiedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
						skillSetList = skillSetBo.listActiveSkillSet();
					}
				}else{
					addActionError("Interviewer Id can't be Empty / Zero !!");
					return ERROR;
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteInterviewer(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminInterviewer";
				if(isNumberNullOrZero(getUniqueId())){
					addActionError("Interviewer Id can't be Empty / Zero !!");
					return ERROR;
				}else{
					interviewer = interviewerBo.getInterviewerByInterviewerId(uniqueId);
					if(interviewer==null){
						addActionError("Interviewer Does Not Exist with the Given Interviewer Id !!");
						return ERROR;
					}else{
						interviewerBo.deleteInterviewer(interviewer);
					}
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	//Candidate

	public String getAdminCandidatePage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			
			if(user!=null){
				urlPage = "adminCandidate";
				totalSize = candidateScheduleTimingBo.getCandidateScheduleTimingListCount();
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				candidateScheduleTimingList = candidateScheduleTimingBo.getCandidateScheduleTimingListByPage(startRecord, pageSize);
				skillSetList = skillSetBo.listActiveSkillSet();
				locationList = locationBo.listActiveLocation();
				interviewerList = interviewerBo.listActiveInterviewer();
				
				Map<Integer, SkillSet> skillsetMap = new HashMap<Integer, SkillSet>();
				if(skillSetList!=null && !skillSetList.isEmpty()){
					for(SkillSet skillSet : skillSetList){
						skillsetMap.put(skillSet.getSkillSetId(), skillSet);
					}
				}
				
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming tmpCandidateScheduleTiming : candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(tmpCandidateScheduleTiming.getCandidateId());
						tmpCandidateScheduleTiming.setCandidate(candidate);
						tmpCandidateScheduleTiming.setSkillSet(skillsetMap.get(tmpCandidateScheduleTiming.getSkillSetId()));
						interviewer = interviewerBo.getInterviewerByInterviewerId(tmpCandidateScheduleTiming.getInterviewerId());
						tmpCandidateScheduleTiming.setInterviewer(interviewer);
						location = locationBo.getLocationByLocationId(tmpCandidateScheduleTiming.getLocationId());
						tmpCandidateScheduleTiming.setLocation(location);
						agent = agentBo.getAgentByAgentId(location.getLocationPrimaryAgentId());
						tmpCandidateScheduleTiming.setAgent(agent);
					}
				}
				
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAdminCandidateSearchPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			
			if(user!=null){
				urlPage = "adminCandidate";
				if(scheduleFromTime!=null && !scheduleFromTime.equals("")){
					candidateScheduleFromTime = DateHelper.getUtilDateTimeFromString(scheduleFromTime);
				}
				if(scheduleToTime!=null && !scheduleToTime.equals("")){
					candidateScheduleToTime = DateHelper.getUtilDateTimeFromString(scheduleToTime);
				}
				totalSize = candidateScheduleTimingBo.searchCandidateScheduleTimingListCount(null, null, locationId, interviewerId, null, skillSetId, 
						null, null, null, candidateScheduleFromTime, candidateScheduleToTime, null, null, interviewStatus, candidateUniqueId, null, null, null, null, null, ACTIVE);
				
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				candidateScheduleTimingList = candidateScheduleTimingBo.searchCandidateScheduleTiming(null, null, locationId, interviewerId, null, skillSetId, 
						null, null, null, candidateScheduleFromTime, candidateScheduleToTime, null, null, interviewStatus, candidateUniqueId, null, null, null, null, null, ACTIVE, startRecord, pageSize);
				
				skillSetList = skillSetBo.listActiveSkillSet();
				locationList = locationBo.listActiveLocation();
				interviewerList = interviewerBo.listActiveInterviewer();
				
				Map<Integer, SkillSet> skillsetMap = new HashMap<Integer, SkillSet>();
				if(skillSetList!=null && !skillSetList.isEmpty()){
					for(SkillSet skillSet : skillSetList){
						skillsetMap.put(skillSet.getSkillSetId(), skillSet);
					}
				}
				
				if(candidateScheduleTimingList!=null && !candidateScheduleTimingList.isEmpty()){
					for(CandidateScheduleTiming tmpCandidateScheduleTiming : candidateScheduleTimingList){
						candidate = candidateBo.getCandidateByCandidateId(tmpCandidateScheduleTiming.getCandidateId());
						tmpCandidateScheduleTiming.setCandidate(candidate);
						tmpCandidateScheduleTiming.setSkillSet(skillsetMap.get(tmpCandidateScheduleTiming.getSkillSetId()));
						interviewer = interviewerBo.getInterviewerByInterviewerId(tmpCandidateScheduleTiming.getInterviewerId());
						tmpCandidateScheduleTiming.setInterviewer(interviewer);
						location = locationBo.getLocationByLocationId(tmpCandidateScheduleTiming.getLocationId());
						tmpCandidateScheduleTiming.setLocation(location);
						agent = agentBo.getAgentByAgentId(location.getLocationPrimaryAgentId());
						tmpCandidateScheduleTiming.setAgent(agent);
					}
				}
				
			}
			
			else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewAdminCandidate(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCandidate";
				if(!isNumberNullOrZero(getCandidateScheduleTimingId())){
					candidateScheduleTiming = candidateScheduleTimingBo.getCandidateScheduleTiming(candidateScheduleTimingId);
					if(candidateScheduleTiming!=null){
						skillSetList = skillSetBo.listActiveSkillSet();
						candidate = candidateBo.getCandidateByCandidateId(candidateScheduleTiming.getCandidateId());
						skillSet = skillSetBo.getSkillSetBySkillSetId(candidateScheduleTiming.getSkillSetId());
						interviewer = interviewerBo.getInterviewerByInterviewerId(candidateScheduleTiming.getInterviewerId());
						location = locationBo.getLocationByLocationId(candidateScheduleTiming.getLocationId());
						agent = agentBo.getAgentByAgentId(location.getLocationPrimaryAgentId());
						feedbackList = feedbackBo.getFeedbacksByCandidateScheduleTimingId(candidateScheduleTimingId);
					}else{
						addActionError("Candidate Schedule Timing Does not Exist withe the Given Candidate Schedule Timing Id !!");
						return ERROR;
					}
				}else{
					addActionError("Candidate Schedule Timing Id can't be Empty / Zero !!");
					return ERROR;
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	
	// Skill Set
	
	public String getAdminSkillSetPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminSkillSet";

				totalSize = skillSetBo.getSkillSetListCount();
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				skillSetList = skillSetBo.getSkillSetListByPage(startRecord, pageSize);
				
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAdminSkillSetSearchPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminSkillSet";

				totalSize = skillSetBo.getSkillSetListCount(primarySkillSet, skillSetCategory);
				
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				skillSetList = skillSetBo.searchSkillSet(null, primarySkillSet, skillSetCategory, null, null, null, null, null, null, startRecord, pageSize);
				
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAddSkillSetPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminSkillSet";
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String saveSkillSet(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminSkillSet";
				
				saveSkillSetValidator();
				if(!hasActionErrors()){
					skillSet = new SkillSet();
					skillSet.setPrimarySkillSet(primarySkillSet);
					skillSet.setSkillSetCategory(skillSetCategory);
					skillSet.setCreatedBy(user.getUserId());
					skillSet.setLastModifiedBy(user.getUserId());
					skillSet.setCreationDate(new Date());
					skillSet.setLastModifiedTime(new Date());
					skillSet.setStatus(ACTIVE);
					skillSetBo.addSkillSet(skillSet);
					
				}else{
					return "skillSet";
				}
				
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveSkillSetValidator(){
        if(isEmpty(getPrimarySkillSet())){
            addActionError("Primary Skill Set can't be empty !!");
        }
        if(isEmpty(getSkillSetCategory())){
            addActionError("Skill Set Category can't be empty !!");
        }
    }
	
	public String getEditSkillSetPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminSkillSet";
				if(!isNumberNullOrZero(getSkillSetId())){
					skillSet = skillSetBo.getSkillSetBySkillSetId(skillSetId);
					if(skillSet==null){
						addActionError("SkillSet Does Not Exist with the Given SkillSet Id !!");
					}
				}else{
					addActionError("SkillSet Id can't be Empty / Zero !!");
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateSkillSet(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminSkillSet";
				
				updateSkillSetValidator();
				if(!hasActionErrors()){
					skillSet = skillSetBo.getSkillSetBySkillSetId(skillSetId);
					if(skillSet==null){
						addActionError("Skill Set Does Not Exist with the Given Skill Set Id !!");
						return "skillSet";
					}else{
						skillSet.setPrimarySkillSet(primarySkillSet);
						skillSet.setSkillSetCategory(skillSetCategory);
						skillSet.setLastModifiedBy(user.getUserId());
						skillSet.setLastModifiedTime(new Date());
						skillSetBo.updateSkillSet(skillSet);
					}
				}else{
					return "skillSet";
				}

			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateSkillSetValidator(){
    	if(isNumberNullOrZero(getSkillSetId())){
    		addActionError("SkillSet Id can't be Empty / Zero !!");
    	}
        if(isEmpty(getPrimarySkillSet())){
            addActionError("Primary Skill Set can't be empty !!");
        }
        if(isEmpty(getSkillSetCategory())){
            addActionError("Skill Set Category can't be empty !!");
        }
    }
	
	public String viewSkillSet(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminSkillSet";
				if(!isNumberNullOrZero(getSkillSetId())){
					skillSet = skillSetBo.getSkillSetBySkillSetId(skillSetId);
					if(skillSet==null){
						addActionError("SkillSet Does Not Exist with the Given SkillSet Id !!");
					}else{
						vUser = userBo.getUser(skillSet.getCreatedBy());
						if(vUser!=null){
							skillSet.setCreatedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
						vUser = userBo.getUser(skillSet.getLastModifiedBy());
						if(vUser!=null){
							skillSet.setLastModifiedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
					}
				}else{
					addActionError("SkillSet Id can't be Empty / Zero !!");
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteSkillSet(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminSkillSet";
				if(isNumberNullOrZero(getUniqueId())){
					addActionError("SkillSet Id can't be Empty / Zero !!");
				}else{
					skillSet = skillSetBo.getSkillSetBySkillSetId(uniqueId);
					if(skillSet==null){
						addActionError("SkillSet Does Not Exist with the Given SkillSet Id !!");
					}else{
						skillSetBo.deleteSkillSet(skillSet);
					}
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Location
	
	public String getAdminLocationPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminLocation";
				
				totalSize = locationBo.getLocationListCount();
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				locationList = locationBo.getLocationListByPage(startRecord, pageSize);
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAdminLocationSearchPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminLocation";
				
				totalSize = locationBo.getLocationListCount(locationName, locationBusinessName, locationCity, locationCountry);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				locationList = locationBo.searchLocation(null, locationName, locationBusinessName, null, null, locationCity, null, locationCountry,
						null, null, null, null, null, null, null, null,null, startRecord, pageSize);
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAddLocationPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminLocation";
				agentList = agentBo.listActiveAgent();
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String saveLocation(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminLocation";
				
				saveLocationValidator();
				if(!hasActionErrors()){
					location = new Location();
					location.setLocationName(locationName);
					location.setLocationBusinessName(locationBusinessName);
					location.setLocationAddressLine1(locationAddressLine1);
					location.setLocationAddressLine2(locationAddressLine2);
					location.setLocationCity(locationCity);
					location.setLocationState(locationState);
					location.setLocationState(locationState);
					location.setLocationCountry(locationCountry);
					location.setLocationZipcode(locationZipcode);
					location.setLocationPhoneNo(locationPhoneNo);
					location.setLocationPhoneNoExtension(locationPhoneNoExtension);
					location.setLocationAlternatePhone(locationAlternatePhone);
					location.setLocationAlternatePhoneNoExtension(locationAlternatePhoneNoExtension);
					location.setLocationPrimaryAgentId(locationPrimaryAgentId);
					if(locationSecondaryAgentId!=null){
						location.setLocationSecondaryAgentId(locationSecondaryAgentId);
					}else{
						location.setLocationSecondaryAgentId(INACTIVE);
					}
					location.setLatitude(latitude);
					location.setLongitude(longitude);
					location.setCreatedBy(user.getUserId());
					location.setLastModifiedBy(user.getUserId());
					location.setCreationDate(new Date());
					location.setLastModifiedTime(new Date());
					location.setStatus(ACTIVE);
					locationBo.addLocation(location);
					
				}else{
					agentList = agentBo.listActiveAgent();
					return "location";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveLocationValidator(){
    	if(isEmpty(getLocationName())){
    		addActionError("Location Name can't be empty !!");
    	}
        if(isEmpty(getLocationBusinessName())){
            addActionError("Location Business Name can't be empty !!");
        }
        if(isEmpty(getLocationAddressLine1())){
            addActionError("Location Address Line 1 can't be empty !!");
        }
        if(isEmpty(getLocationCity())){
            addActionError("Location City can't be empty !!");
        }
        if(isEmpty(getLocationState())){
            addActionError("Location State can't be empty !!");
        }
        if(isEmpty(getLocationZipcode())){
            addActionError("Location Zipcode can't be empty !!");
        }
        if(isEmpty(getLocationPhoneNo())){
            addActionError("Location Phone No can't be empty !!");
        }
        if(isNumberNullOrZero(getLocationPrimaryAgentId())){
            addActionError("Location Primary Agent can't be empty !!");
        }
        if(isDoubleNullOrZero(getLatitude())){
            addActionError("Latitude can't be Empty / Zero !!");
        }
        if(isDoubleNullOrZero(getLongitude())){
            addActionError("Longitude can't be Empty / Zero  !!");
        }
    }
	
	public String getEditLocationPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null && locationId!=null && locationId!=0){
				urlPage = "adminLocation";
				if(!isNumberNullOrZero(getLocationId())){
					location = locationBo.getLocationByLocationId(locationId);
					if(location==null){
						addActionError("Location Does Not Exist with the Given Location Id !!");
					}
					agentList = agentBo.listActiveAgent();
				}else{
					addActionError("Latitude can't be Empty / Zero !!");
					return INPUT;
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateLocation(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminLocation";
				
				updateLocationValidator();
				if(!hasActionErrors()){
					location = locationBo.getLocationByLocationId(locationId);
					if(location==null){
						addActionError("Location Set Does Not Exist with the Given Location Id !!");
						return "location";
					}else{
						location.setLocationName(locationName);
						location.setLocationBusinessName(locationBusinessName);
						location.setLocationAddressLine1(locationAddressLine1);
						location.setLocationAddressLine2(locationAddressLine2);
						location.setLocationCity(locationCity);
						location.setLocationState(locationState);
						location.setLocationState(locationState);
						location.setLocationCountry(locationCountry);
						location.setLocationZipcode(locationZipcode);
						location.setLocationPhoneNo(locationPhoneNo);
						location.setLocationPhoneNoExtension(locationPhoneNoExtension);
						location.setLocationAlternatePhone(locationAlternatePhone);
						location.setLocationAlternatePhoneNoExtension(locationAlternatePhoneNoExtension);
						location.setLocationPrimaryAgentId(locationPrimaryAgentId);
						if(locationSecondaryAgentId!=null){
							location.setLocationSecondaryAgentId(locationSecondaryAgentId);
						}else{
							location.setLocationSecondaryAgentId(INACTIVE);
						}
						location.setLatitude(latitude);
						location.setLongitude(longitude);
						location.setLastModifiedBy(user.getUserId());
						location.setLastModifiedTime(new Date());
						locationBo.updateLocation(location);
					}
				}else{
					return "location";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateLocationValidator(){
        if(isNumberNullOrZero(getLocationId())){
            addActionError("Location Id can't be Empty / Zero !!");
        }
    	if(isEmpty(getLocationName())){
    		addActionError("Location Name can't be empty !!");
    	}
        if(isEmpty(getLocationBusinessName())){
            addActionError("Location Business Name can't be empty !!");
        }
        if(isEmpty(getLocationAddressLine1())){
            addActionError("Location Address Line 1 can't be empty !!");
        }
        if(isEmpty(getLocationCity())){
            addActionError("Location City can't be empty !!");
        }
        if(isEmpty(getLocationState())){
            addActionError("Location State can't be empty !!");
        }
        if(isEmpty(getLocationZipcode())){
            addActionError("Location Zipcode can't be empty !!");
        }
        if(isEmpty(getLocationPhoneNo())){
            addActionError("Location Phone No can't be empty !!");
        }
        if(isNumberNullOrZero(getLocationPrimaryAgentId())){
            addActionError("Location Primary Agent can't be empty !!");
        }
        if(isDoubleNullOrZero(getLatitude())){
            addActionError("Latitude can't be Empty / Zero !!");
        }
        if(isDoubleNullOrZero(getLongitude())){
            addActionError("Longitude can't be Empty / Zero  !!");
        }
    }
	
	public String viewLocation(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminLocation";
				if(!isNumberNullOrZero(getLocationId())){
					location = locationBo.getLocationByLocationId(locationId);
					if(location==null){
						addActionError("Location Does Not Exist with the Given Location Id !!");
					}else{
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
					}
				}else{
					addActionError("Location Id can't be Empty / Zero !!");
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteLocation(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminLocation";
				if(isNumberNullOrZero(getUniqueId())){
					addActionError("Location Id can't be Empty / Zero !!");
				}else{
					location = locationBo.getLocationByLocationId(uniqueId);
					if(location==null){
						addActionError("Location Does Not Exist with the Given Location Id !!");
					}else{
						locationBo.deleteLocation(location);
					}
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Agent
	
	public String getAdminAgentPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminAgent";
				totalSize = agentBo.getAgentListCount();
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				agentList = agentBo.getAgentListByPage(startRecord, pageSize);
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAdminAgentSearchPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminAgent";
				totalSize = agentBo.getAgentListCount(agentEmailId,agentPhoneNo,agentCountry);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				agentList = agentBo.searchAgent(null, null, null, agentEmailId, agentPhoneNo, null, null, agentCountry, null, null, null, null, null, null, startRecord, pageSize);
				
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAddAgentPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminAgent";
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String saveAgent(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminAgent";
				
				saveAgentValidator();
				if(!hasActionErrors()){

					agent = agentBo.getAgentByEmailId(agentEmailId);
	            	if(agent!=null){
						addActionError("Agent All ready Registered with the Given Email Id : "+agentEmailId+" !!");
						return "agent";
					}else{
	            	
						agent = new Agent();
						agent.setAgentFirstName(agentFirstName);
						agent.setAgentLastName(agentLastName);
						agent.setAgentEmailId(agentEmailId);
						agent.setAgentPassword(agentPassword);
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
						agent.setCreatedBy(user.getUserId());
						agent.setLastModifiedBy(user.getUserId());
						agent.setCreationDate(new Date());
						agent.setLastModifiedTime(new Date());
						agent.setStatus(ACTIVE);
						agentBo.addAgent(agent);
						
						propertie = propertieBo.getPropertie();
						// Email To Admin
						secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.ADMIN_SAVE_AGENT_EMAIL_TO_ADMIN.getValue());
						if(propertie!=null && secureVerifyEmailSubjectBody!=null){									
	
							String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", agentEmailId);
							String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", agentEmailId).replaceAll("#password#", agentPassword);
							
							SecureVerifyMail.postMail(user.getUserEmailId(), propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
									propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
									propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
									propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
							
						}
	
						// Email To Agent
						secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.ADMIN_SAVE_AGENT_EMAIL_TO_AGENT.getValue());
						if(propertie!=null && secureVerifyEmailSubjectBody!=null){									
	
							String subject = secureVerifyEmailSubjectBody.getEmailSubject();
							String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", agentEmailId).replaceAll("#password#", agentPassword);
							
							SecureVerifyMail.postMail(agentEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
									propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
									propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
									propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
							
						}
					}
				}else{
					return "agent";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveAgentValidator(){
        if(isEmpty(getAgentFirstName())){
            addActionError("Agent First Name can't be empty !!");
        }
    	if(isEmpty(getAgentLastName())){
    		addActionError("Agent Last Name can't be empty !!");
    	}
        if(isEmpty(getAgentEmailId())){
            addActionError("Agent Email Id can't be empty !!");
        }
        if(isEmpty(getAgentPassword())){
            addActionError("Agent Password can't be empty !!");
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
	
	public String getEditAgentPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminAgent";
				if(!isNumberNullOrZero(getAgentId())){
					agent = agentBo.getAgentByAgentId(agentId);
					if(agent==null){
						addActionError("Agent Does Not Exist with the Given Agent Id !!");
					}
				}else{
					addActionError("Agent Id can't be Empty / Zero !!");
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateAgent(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminAgent";
				
				updateAgentValidator();
				if(!hasActionErrors()){
					agent = agentBo.getAgentByAgentId(agentId);
					if(agent==null){
						addActionError("Agent Does Not Exist with the Given Agent Id !!");
						return "agent";
					}else{
						agent.setAgentFirstName(agentFirstName);
						agent.setAgentLastName(agentLastName);
						agent.setAgentEmailId(agentEmailId);
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
						agent.setLastModifiedBy(user.getUserId());
						agent.setLastModifiedTime(new Date());
						agentBo.updateAgent(agent);

						propertie = propertieBo.getPropertie();
						// Email To Admin
						secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.ADMIN_UPDATE_AGENT_EMAIL_TO_ADMIN.getValue());
						if(propertie!=null && secureVerifyEmailSubjectBody!=null){									

							String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", agent.getAgentEmailId());
							String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", agent.getAgentEmailId()).replaceAll("#password#", agent.getAgentPassword());
							
							SecureVerifyMail.postMail(user.getUserEmailId(), propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
									propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
									propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
									propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
							
						}

						// Email To Agent
						secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.ADMIN_UPDATE_AGENT_EMAIL_TO_AGENT.getValue());
						if(propertie!=null && secureVerifyEmailSubjectBody!=null){									

							String subject = secureVerifyEmailSubjectBody.getEmailSubject();
							String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", agent.getAgentEmailId()).replaceAll("#password#", agent.getAgentPassword());
							
							SecureVerifyMail.postMail(agent.getAgentEmailId(), propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
									propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
									propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
									propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
							
						}

					}				
				}else{
					return "agent";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateAgentValidator(){
        if(isNumberNullOrZero(getAgentId())){
            addActionError("Agent Id can't be Empty / Zero !!");
        }
        if(isEmpty(getAgentFirstName())){
            addActionError("Agent First Name can't be empty !!");
        }
    	if(isEmpty(getAgentLastName())){
    		addActionError("Agent Last Name can't be empty !!");
    	}
        if(isEmpty(getAgentEmailId())){
            addActionError("Agent Email Id can't be empty !!");
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
	
	public String viewAgent(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminAgent";
				if(!isNumberNullOrZero(getAgentId())){
					agent = agentBo.getAgentByAgentId(agentId);
					if(agent==null){
						addActionError("Agent Does Not Exist with the Given Agent Id !!");
					}else{
						vUser = userBo.getUser(agent.getCreatedBy());
						if(vUser!=null){
							agent.setCreatedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
						vUser = userBo.getUser(agent.getLastModifiedBy());
						if(vUser!=null){
							agent.setLastModifiedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
						}
					}
				}else{
					addActionError("Agent Id can't be Empty / Zero !!");
				}
			}else{
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteAgent(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminAgent";
				if(isNumberNullOrZero(getUniqueId())){
					addActionError("Agent Id can't be Empty / Zero !!");
				}else{
					agent = agentBo.getAgentByAgentId(uniqueId);
					if(agent==null){
						addActionError("Agent Does Not Exist with the Given Agent Id !!");
					}else{
						agentBo.deleteAgent(agent);
					}
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Employer
	
	public String getAdminEmployerPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminEmployer";
				totalSize = employerBo.getEmployerListCount();
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				employerList = employerBo.getEmployerListByPage(startRecord, pageSize);
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAdminEmployerSearchPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminEmployer";
				
				totalSize = employerBo.getEmployerListCount(employerFirstName, employerEmailId, employerPhoneNo, null,
						null, null, null, null, null, status);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				employerList = employerBo.searchEmployer(employerFirstName, employerEmailId,
						employerPhoneNo, null, null, null, null, null, null, null, null, null, status, startRecord, pageSize);
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError("Error Occured in Search operation !!");
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String viewEmployer(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminEmployer";
				if(!isNumberNullOrZero(getEmployerId())){
					employer = employerBo.getEmployerByEmployerId(employerId);
					if(employer==null){
						addActionError("Employer Does Not Exist with the Given Employer Id !!");
					}
				}else{
					addActionError("Employer Id can't be Empty / Zero !!");
				}
			}else{
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String activateEmployer(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminEmployer";
				if(isNumberNullOrZero(getUniqueId())){
					addActionError("Employer Id can't be Empty / Zero !!");
					return "failure";
				}else{
					employer = employerBo.getEmployerByEmployerId(uniqueId);
					if(employer==null){
						addActionError("Employer Does Not Exist with the Given Employer Id !!");
						return "failure";
					}else{
						employer.setStatus(ACTIVE);
						employerBo.updateEmployer(employer);
					}
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String inActivateEmployer(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminEmployer";
				if(isNumberNullOrZero(getUniqueId())){
					addActionError("Employer Id can't be Empty / Zero !!");
					return "failure";
				}else{
					employer = employerBo.getEmployerByEmployerId(uniqueId);
					if(employer==null){
						addActionError("Employer Does Not Exist with the Given Employer Id !!");
						return "failure";
					}else{
						employer.setStatus(INACTIVE);
						employerBo.updateEmployer(employer);
					}
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	// Coupon
	
	public String getAdminCouponPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCoupon";
				totalSize = couponBo.getCouponListCount();
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				couponList = couponBo.getCouponListByPage(startRecord, pageSize);
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getAdminCouponSearchPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCoupon";

				if(fromDate!=null && !fromDate.equals("")){
					expiryFromDate = DateHelper.getUtilDateFromString(fromDate);
				}
				if(toDate!=null && !toDate.equals("")){
					expirytoDate = DateHelper.getUtilDateFromString(toDate);
				}
				
				totalSize = couponBo.getCouponListCount(couponCode, couponName, expiryFromDate, expirytoDate );
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				couponList = couponBo.searchCoupon(null, couponCode, couponName, null, null, null, null,
								null, null, expiryFromDate, expirytoDate,null, startRecord, pageSize);
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAddCouponPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCoupon";
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String saveCoupon(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCoupon";
				
				saveCouponValidator();
				if(!hasActionErrors()){
					coupon = new Coupon();
					coupon.setCouponCode(couponCode);
					coupon.setCouponName(couponName);
					coupon.setDiscountPercentage(discountPercentage);
					coupon.setDiscountAmount(discountAmount);
					coupon.setExpiryDate(DateHelper.getUtilDateFromString(sexpiryDate));
					coupon.setCreatedBy(user.getUserId());
					coupon.setLastModifiedBy(user.getUserId());
					coupon.setCreationDate(new Date());
					coupon.setLastModifiedTime(new Date());
					coupon.setStatus(ACTIVE);
					couponBo.addCoupon(coupon);
				}else{
					addActionError("Invalid Form Fields !!");
					return "coupon";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveCouponValidator(){
        if(isEmpty(getCouponCode())){
            addActionError("Coupon Code can't be empty !!");
        }
    	if(isEmpty(getCouponName())){
    		addActionError("Coupon Name can't be empty !!");
    	}
        if(isBigDecimalNullOrZero(getDiscountPercentage())){
            addActionError("Discount Percentage can't be empty !!");
        }
        if(isBigDecimalNullOrZero(getDiscountAmount())){
            addActionError("Discount Amount can't be empty !!");
        }
        if(isEmpty(getSexpiryDate())){
            addActionError("Expiry Date can't be empty !!");
        }
    }
	
	public String getEditCouponPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCoupon";
				if(!isNumberNullOrZero(getCouponId())){
					coupon = couponBo.getCouponByCouponId(couponId);
					if(coupon==null){
						addActionError("Coupon Does Not Exist with the Given Coupon Id !!");
						return "coupon";
					}
				}else{
					addActionError("Coupon Id can't be Empty / Zero !!");
					return "coupon";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String updateCoupon(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCoupon";
				
				updateCouponValidator();
				if(!hasActionErrors()){
					coupon = couponBo.getCouponByCouponId(couponId);
					if(coupon==null){
						addActionError("Coupon Set Does Not Exist with the Given Coupon Id !!");
						return "coupon";
					}else{
						coupon.setCouponCode(couponCode);
						coupon.setCouponName(couponName);
						coupon.setDiscountPercentage(discountPercentage);
						coupon.setDiscountAmount(discountAmount);
						coupon.setExpiryDate(expiryDate);
						coupon.setLastModifiedBy(user.getUserId());
						coupon.setLastModifiedTime(new Date());
						couponBo.updateCoupon(coupon);
					}				
				}else{
					return "coupon";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateCouponValidator(){
        if(isNumberNullOrZero(getCouponId())){
            addActionError("Coupon Id can't be Empty / Zero !!");
        }
        if(isEmpty(getCouponCode())){
            addActionError("Coupon Code can't be empty !!");
        }
    	if(isEmpty(getCouponName())){
    		addActionError("Coupon Name can't be empty !!");
    	}
        if(isBigDecimalNullOrZero(getDiscountPercentage())){
            addActionError("Discount Percentage can't be empty !!");
        }
        if(isBigDecimalNullOrZero(getDiscountAmount())){
            addActionError("Discount Amount can't be empty !!");
        }
        if(isDateNull(getExpiryDate())){
            addActionError("Expiry Date can't be empty !!");
        }
    }
	
	public String viewCoupon(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCoupon";
				if(!isNumberNullOrZero(getCouponId())){
					coupon = couponBo.getCouponByCouponId(couponId);
					if(coupon==null){
						addActionError("Coupon Does Not Exist with the Given Coupon Id !!");
					}
					vUser = userBo.getUser(coupon.getCreatedBy());
					if(vUser!=null){
						coupon.setCreatedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
					}
					vUser = userBo.getUser(coupon.getLastModifiedBy());
					if(vUser!=null){
						coupon.setLastModifiedByName(vUser.getUserFirstName()+" "+ vUser.getUserLastName());
					}
				}else{
					addActionError("Coupon Id can't be Empty / Zero !!");
				}
			}else{
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteCoupon(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCoupon";
				if(isNumberNullOrZero(getUniqueId())){
					addActionError("Coupon Id can't be Empty / Zero !!");
				}else{
					coupon = couponBo.getCouponByCouponId(uniqueId);
					if(coupon==null){
						addActionError("Coupon Does Not Exist with the Given Coupon Id !!");
					}else{
						couponBo.deleteCoupon(coupon);
					}
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	
	
	// Admin Credit Types
	
	public String getAdminCreditTypesPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCreditTypes";
				creditTypesList = creditTypesBo.listActiveCreditTypes();
				if(creditTypesList!=null && !creditTypesList.isEmpty()){
					totalSize = creditTypesList.size();
				}else{
					totalSize = 0;
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getAddCreditTypePage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCreditTypes";
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		} catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String saveCreditType(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCreditTypes";
				
				saveCreditTypeValidator();
				if(!hasActionErrors()){
					creditTypes = new CreditTypes();
					creditTypes.setCreditType(creditType);
					creditTypes.setDescription(description);
					creditTypes.setAmount(amount);
					creditTypes.setStatus(ACTIVE);
					creditTypesBo.addCreditTypes(creditTypes);
				}else{
					return "creditTypes";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void saveCreditTypeValidator(){
        if(isNumberNullOrZero(getCreditType())){
            addActionError("Credit Type can't be Empty / Zero !!");
        }
    	if(isEmpty(getDescription())){
    		addActionError("Description can't be empty !!");
    	}
        if(isBigDecimalNullOrZero(getAmount())){
            addActionError("Amount can't be Empty / Zero !!");
        }
    }
	
	public String getEditCreditTypePage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null && creditTypesId!=null && creditTypesId!=0){
				urlPage = "adminCreditTypes";
				if(!isNumberNullOrZero(getCreditTypesId())){
					creditTypes = creditTypesBo.getCreditTypesByCreditTypesId(creditTypesId);
					if(creditTypes==null){
						addActionError("No such kind of Credit Type !!");
					}
				}else{
					addActionError("Credit Type Id can't be Empty / Zero !!");
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String updateCreditType(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminCreditTypes";
				
				updateCreditTypeValidator();
				if(!hasActionErrors()){
					creditTypes = creditTypesBo.getCreditTypesByCreditTypesId(creditTypesId);
					if(creditTypes==null){
						addActionError("No such kind of Credit Type !!");
						return "creditTypes";
					}else{
						creditTypes.setDescription(description);
						creditTypes.setAmount(amount);
						creditTypesBo.updateCreditTypes(creditTypes);
					}				
				}else{
					return "creditTypes";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateCreditTypeValidator(){
        if(isNumberNullOrZero(getCreditTypesId())){
            addActionError("Credit Type Id can't be Empty / Zero !!");
        }
    	if(isEmpty(getDescription())){
    		addActionError("Description can't be empty !!");
    	}
        if(isBigDecimalNullOrZero(getAmount())){
            addActionError("Amount can't be Empty / Zero !!");
        }
    }
	
	
	// Admin Payment
	
	public String getAdminPaymentsPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminPayments";
				totalSize = paymentDetailBo.getPaymentDetailListCount();
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				paymentDetailList = paymentDetailBo.getPaymentDetailListByPage(startRecord, pageSize);
				if(paymentDetailList!=null && !paymentDetailList.isEmpty()){
					
					for(PaymentDetail paymentDetail : paymentDetailList){
						coupon = couponBo.getCouponByCouponId(paymentDetail.getCouponId());
						paymentDetail.setCoupon(coupon);
					}
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getAdminPaymentDetailSearchPage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminPayments";
				
				if(fromDate!=null && !fromDate.equals("")){
					expiryFromDate = DateHelper.getUtilDateFromString(fromDate);
				}
				if(toDate!=null && !toDate.equals("")){
					expirytoDate = DateHelper.getUtilDateFromString(toDate);
				}
				
				totalSize = paymentDetailBo.searchPaymentDetail(null, null, partyTypeId, transactionNumber, null, 
						noOfCreditsBought, totalAmount, null, null, paymentDate, null, null, null, invoiceNumber, 
						firstName, null, null, null, null, zip, emailId, phone, couponId, expiryFromDate, expirytoDate);
				if(pageNo==null || pageNo==0){
					pageNo = 1;
				}
				noOfPages = totalSize/pageSize;
				if((totalSize%pageSize) > 0){
					noOfPages++;
				}
				
				final Integer startRecord = (pageNo-1)*pageSize;
				
				paymentDetailList = paymentDetailBo.searchPaymentDetail(null, null, partyTypeId, transactionNumber, null, 
						noOfCreditsBought, totalAmount, null, null, paymentDate, null, null, null, invoiceNumber, firstName, 
						null, null, null, null, zip, emailId, phone, couponId, expiryFromDate, expirytoDate, startRecord, pageSize);
				if(paymentDetailList!=null && !paymentDetailList.isEmpty()){
					for(PaymentDetail paymentDetail : paymentDetailList){
						coupon = couponBo.getCouponByCouponId(paymentDetail.getCouponId());
						paymentDetail.setCoupon(coupon);
					}
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String viewAdminPayments(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminPayments";
				if(!isNumberNullOrZero(getPaymentDetailsId())){
					paymentDetail = paymentDetailBo.getPaymentDetail(paymentDetailsId);
					if(paymentDetail==null){
						addActionError("Payment Details Doesn't Exist with the Given Payment Details Id !!");
					}
					coupon = couponBo.getCouponByCouponId(paymentDetail.getCouponId());
					if(coupon!=null){
						coupon.getCouponCode();
					}
				}else{
					addActionError("Payment Details Id can't be Empty / Zero !!");
				}
			}else{
				addActionError(ADMIN_LOGIN_MSG);
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	// Admin Profile
	
	public String getAdminViewProfilePage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminViewProfile";
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getAdminEditProfilePage(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminEditProfile";
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
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
	public String updateAdmin(){
		try{
			getGlobalContent();
			user = (User) session.get("user");
			if(user!=null){
				urlPage = "adminViewProfile";
				
				updateAdminValidator();
				if(!hasActionErrors()){
					user = userBo.getUser(userId);
					if(user==null){
						addActionError("User Set Does Not Exist with the Given User Id !!");
						return "admin";
					}else{
						user.setUserEmailId(userEmailId);
						user.setUserFirstName(userFirstName);
						user.setUserLastName(userLastName);
						user.setUserPhoneNo(userPhoneNo);
						user.setUserAddressLine1(userAddressLine1);
						user.setUserAddressLine2(userAddressLine2);
						user.setUserCity(userCity);
						user.setUserState(userState);
						user.setUserCountry(userCountry);
						user.setUserZipcode(userZipcode);
						user.setUserDesignation(userDesignation);
						user.setLastModifiedTime(new Date());
						userBo.updateUser(user);
						
						session.put("user", user);
					}				
				}else{
					return "admin";
				}
			}else{
				urlPage = URL_PAGE_ADMIN_LOGIN;
				addActionError(ADMIN_LOGIN_MSG);
				return "failure";
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void updateAdminValidator(){
        if(isNumberNullOrZero(getUserId())){
            addActionError("Admin Id can't be Empty / Zero !!");
        }
    	if(isEmpty(getUserEmailId())){
    		addActionError("Admin Email Id can't be empty !!");
    	}
    	if(isEmpty(getUserFirstName())){
    		addActionError("Admin First Name can't be empty !!");
    	}
    	if(isEmpty(getUserLastName())){
    		addActionError("Admin Last Name can't be empty !!");
    	}
    	if(isEmpty(getUserPhoneNo())){
    		addActionError("Admin Phone No can't be empty !!");
    	}
    	if(isEmpty(getUserAddressLine1())){
    		addActionError("Admin Address Line 1 can't be empty !!");
    	}
    	if(isEmpty(getUserAddressLine2())){
    		addActionError("Admin Address Line 2 can't be empty !!");
    	}
    	if(isEmpty(getUserCity())){
    		addActionError("Admin City can't be empty !!");
    	}
    	if(isEmpty(getUserState())){
    		addActionError("Admin State can't be empty !!");
    	}
    	if(isEmpty(getUserCountry())){
    		addActionError("Admin Country can't be empty !!");
    	}
    	if(isEmpty(getUserZipcode())){
    		addActionError("Admin Zipcode can't be empty !!");
    	}
    	if(isEmpty(getUserDesignation())){
    		addActionError("Admin Designation can't be empty !!");
    	}
    }
	
	public String getForgotAdminPassword(){
		try{
			getGlobalContent();
			urlPage = "forgotAdminPassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getResetAdminPassword(){
		try{
			getGlobalContent();
			urlPage = "forgotAdminPassword";
			if(isEmpty(getUserEmailId())){
	    		addActionError("Admin Email Id can't be empty !!");
	    		return "failure";
	    	}else{
				user = userBo.getUser(userEmailId);
				if(user==null){
					addActionError("Admin Doesn't Exist with the Given E-mail Id!!");
					return "failure";
				}else{
					urlPage = "resetAdminPassword";
					UUID uuid = UUID.randomUUID();
					String verificationCode = uuid.toString().substring(0, 6);
					userBo.updateUser(user.getUserId(), verificationCode);
					propertie = propertieBo.getPropertie();
					secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBodyBo.getSecureVerifyEmailSubjectBodyByEmailSendingType(SecureVerifyEmailType.ADMIN_PASSWORD_RECOVERY.getValue());
					if(propertie!=null && secureVerifyEmailSubjectBody!=null){
						
						String subject = secureVerifyEmailSubjectBody.getEmailSubject().replaceAll("#email#", userEmailId);
						String body = secureVerifyEmailSubjectBody.getEmailBody().replaceAll("#email#", userEmailId).replaceAll("#password#", verificationCode);
						
						SecureVerifyMail.postMail(userEmailId, propertie.getAdminId(), subject, body, propertie.getSmtpHost(), 
								propertie.getSmtpPort1(), propertie.getSmtpPort2(), propertie.getSmtpSocketFactory(), 
								propertie.getSmtpSocketFactoryport(), propertie.getSmtpAuth(), 
								propertie.getSmtpUserid(), propertie.getSmtpPassword(), propertie.getAdminId());
						
					}
					addActionMessage("An E-mail has been sent to your Email Id: "+userEmailId+" with Verification Code and a Link to Reset Your Password!!");
				}
	    	}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getUpdateAdminPasswordPage(){
		try{
			getGlobalContent();
			urlPage = "updateAdminPassword";
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String changeAdminPassword(){
		try{
			getGlobalContent();
			urlPage = URL_PAGE_ADMIN_LOGIN;
			
			changeAdminPasswordValidator();
			if(!hasActionErrors()){
				user = userBo.getUser(userEmailId);
				if(user==null){
					addActionError("Admin doesn't Exist with the Given Email Id !!");
					return "failure";
				}else{
					if(user.getVerificationCode()==null){
						addActionError("Please Go To the Forgot Password Page !!");
					}else{
						if(securitycode.equals(user.getVerificationCode())){
							userBo.updateUser(user.getUserId(), null, userPassword);
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

    public void changeAdminPasswordValidator(){
        if(isEmpty(getUserEmailId())){
            addActionError("Admin Email Id can't be empty !!");
        }
    	if(isEmpty(getSecuritycode())){
    		addActionError("Security code can't be empty !!");
    	}
    }
	
	
	// DownloadResume
	
	public String downloadCandidateResume() throws Exception {
		if(candidateId!=null && candidateId!=0){
			candidate = candidateBo.getCandidateByCandidateId(candidateId);
			candidateResume = candidate.getCandidateFirstName()+" "+candidate.getCandidateLastName()+".docx";
			inputStream = new ByteArrayInputStream(candidate.getCandidateResumeBlob());
		}
	    return SUCCESS;	  
	}

	public String downloadInterviewerResume() throws Exception {
		if(interviewerId!=null && interviewerId!=0){
			interviewer = interviewerBo.getInterviewerByInterviewerId(interviewerId);
			interviewerResume = interviewer.getInterviewerFirstName()+" "+interviewer.getInterviewerLastName()+".docx";
			inputStream = new ByteArrayInputStream(interviewer.getInterviewerResumeBlob());
		}
	    return SUCCESS;	  
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

	public String getEmployerEmailId() {
		return employerEmailId;
	}

	public void setEmployerEmailId(String employerEmailId) {
		this.employerEmailId = employerEmailId;
	}

	public Integer getCreditTypesId() {
		return creditTypesId;
	}

	public void setCreditTypesId(Integer creditTypesId) {
		this.creditTypesId = creditTypesId;
	}

	public Integer getCreditType() {
		return creditType;
	}

	public void setCreditType(Integer creditType) {
		this.creditType = creditType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getEmployerPassword() {
		return employerPassword;
	}

	public void setEmployerPassword(String employerPassword) {
		this.employerPassword = employerPassword;
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

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
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

	public String getCandidatePassword() {
		return candidatePassword;
	}

	public void setCandidatePassword(String candidatePassword) {
		this.candidatePassword = candidatePassword;
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

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public String getUserAddressLine1() {
		return userAddressLine1;
	}

	public void setUserAddressLine1(String userAddressLine1) {
		this.userAddressLine1 = userAddressLine1;
	}

	public String getUserAddressLine2() {
		return userAddressLine2;
	}

	public void setUserAddressLine2(String userAddressLine2) {
		this.userAddressLine2 = userAddressLine2;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getUserZipcode() {
		return userZipcode;
	}

	public void setUserZipcode(String userZipcode) {
		this.userZipcode = userZipcode;
	}

	public String getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
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

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public List<Interviewer> getInterviewerList() {
		return interviewerList;
	}

	public void setInterviewerList(List<Interviewer> interviewerList) {
		this.interviewerList = interviewerList;
	}

	public List<SkillSet> getSkillSetList() {
		return skillSetList;
	}

	public void setSkillSetList(List<SkillSet> skillSetList) {
		this.skillSetList = skillSetList;
	}

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	public List<Coupon> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<Coupon> couponList) {
		this.couponList = couponList;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public List<Employer> getEmployerList() {
		return employerList;
	}

	public void setEmployerList(List<Employer> employerList) {
		this.employerList = employerList;
	}

	public Integer getSkillSetId() {
		return skillSetId;
	}

	public void setSkillSetId(Integer skillSetId) {
		this.skillSetId = skillSetId;
	}

	public String getPrimarySkillSet() {
		return primarySkillSet;
	}

	public void setPrimarySkillSet(String primarySkillSet) {
		this.primarySkillSet = primarySkillSet;
	}

	public String getSkillSetCategory() {
		return skillSetCategory;
	}

	public void setSkillSetCategory(String skillSetCategory) {
		this.skillSetCategory = skillSetCategory;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

	public Integer getLocationId() {
		return locationId;
	}
	

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	

	public String getLocationName() {
		return locationName;
	}
	

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	

	public String getLocationBusinessName() {
		return locationBusinessName;
	}
	

	public void setLocationBusinessName(String locationBusinessName) {
		this.locationBusinessName = locationBusinessName;
	}
	

	public String getLocationAddressLine1() {
		return locationAddressLine1;
	}
	

	public void setLocationAddressLine1(String locationAddressLine1) {
		this.locationAddressLine1 = locationAddressLine1;
	}
	

	public String getLocationAddressLine2() {
		return locationAddressLine2;
	}
	

	public void setLocationAddressLine2(String locationAddressLine2) {
		this.locationAddressLine2 = locationAddressLine2;
	}
	

	public String getLocationCity() {
		return locationCity;
	}
	

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}
	

	public String getLocationState() {
		return locationState;
	}
	

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}
	

	public String getLocationCountry() {
		return locationCountry;
	}
	

	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}
	

	public String getLocationZipcode() {
		return locationZipcode;
	}
	

	public void setLocationZipcode(String locationZipcode) {
		this.locationZipcode = locationZipcode;
	}
	

	public String getLocationPhoneNo() {
		return locationPhoneNo;
	}
	

	public void setLocationPhoneNo(String locationPhoneNo) {
		this.locationPhoneNo = locationPhoneNo;
	}
	

	public String getLocationPhoneNoExtension() {
		return locationPhoneNoExtension;
	}
	

	public void setLocationPhoneNoExtension(String locationPhoneNoExtension) {
		this.locationPhoneNoExtension = locationPhoneNoExtension;
	}
	

	public String getLocationAlternatePhone() {
		return locationAlternatePhone;
	}
	

	public void setLocationAlternatePhone(String locationAlternatePhone) {
		this.locationAlternatePhone = locationAlternatePhone;
	}
	

	public String getLocationAlternatePhoneNoExtension() {
		return locationAlternatePhoneNoExtension;
	}
	

	public void setLocationAlternatePhoneNoExtension(String locationAlternatePhoneNoExtension) {
		this.locationAlternatePhoneNoExtension = locationAlternatePhoneNoExtension;
	}
	

	public Integer getLocationPrimaryAgentId() {
		return locationPrimaryAgentId;
	}
	

	public void setLocationPrimaryAgentId(Integer locationPrimaryAgentId) {
		this.locationPrimaryAgentId = locationPrimaryAgentId;
	}
	

	public Integer getLocationSecondaryAgentId() {
		return locationSecondaryAgentId;
	}
	

	public void setLocationSecondaryAgentId(Integer locationSecondaryAgentId) {
		this.locationSecondaryAgentId = locationSecondaryAgentId;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public List<Agent> getAgentList() {
		return agentList;
	}

	public void setAgentList(List<Agent> agentList) {
		this.agentList = agentList;
	}

	public Candidate getvCandidate() {
		return vCandidate;
	}

	public void setvCandidate(Candidate vCandidate) {
		this.vCandidate = vCandidate;
	}

	public Employer getvEmployer() {
		return vEmployer;
	}

	public void setvEmployer(Employer vEmployer) {
		this.vEmployer = vEmployer;
	}

	public Agent getvAgent() {
		return vAgent;
	}

	public void setvAgent(Agent vAgent) {
		this.vAgent = vAgent;
	}

	public Interviewer getvInterviewer() {
		return vInterviewer;
	}

	public void setvInterviewer(Interviewer vInterviewer) {
		this.vInterviewer = vInterviewer;
	}

	public SkillSet getvSkillSet() {
		return vSkillSet;
	}

	public void setvSkillSet(SkillSet vSkillSet) {
		this.vSkillSet = vSkillSet;
	}

	public Location getvLocation() {
		return vLocation;
	}

	public void setvLocation(Location vLocation) {
		this.vLocation = vLocation;
	}

	public Coupon getvCoupon() {
		return vCoupon;
	}

	public void setvCoupon(Coupon vCoupon) {
		this.vCoupon = vCoupon;
	}

	public User getvUser() {
		return vUser;
	}

	public void setvUser(User vUser) {
		this.vUser = vUser;
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
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public String getSexpiryDate() {
		return sexpiryDate;
	}

	public void setSexpiryDate(String sexpiryDate) {
		this.sexpiryDate = sexpiryDate;
	}

	public Date getExpiryFromDate() {
		return expiryFromDate;
	}

	public void setExpiryFromDate(Date expiryFromDate) {
		this.expiryFromDate = expiryFromDate;
	}

	public Date getExpirytoDate() {
		return expirytoDate;
	}

	public void setExpirytoDate(Date expirytoDate) {
		this.expirytoDate = expirytoDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	public Integer getCandidateScheduleTimingId() {
		return candidateScheduleTimingId;
	}

	public void setCandidateScheduleTimingId(Integer candidateScheduleTimingId) {
		this.candidateScheduleTimingId = candidateScheduleTimingId;
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

	public String getCandidateUniqueId() {
		return candidateUniqueId;
	}

	public void setCandidateUniqueId(String candidateUniqueId) {
		this.candidateUniqueId = candidateUniqueId;
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

	public Integer getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(Integer interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	
	public List<CreditTypes> getCreditTypesList() {
		return creditTypesList;
	}

	public void setCreditTypesList(List<CreditTypes> creditTypesList) {
		this.creditTypesList = creditTypesList;
	}

	public CreditTypes getCreditTypes() {
		return creditTypes;
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
	

	public Integer getPartyId() {
		return partyId;
	}
	

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	

	public Integer getPartyTypeId() {
		return partyTypeId;
	}
	

	public void setPartyTypeId(Integer partyTypeId) {
		this.partyTypeId = partyTypeId;
	}
	

	public String getTransactionNumber() {
		return transactionNumber;
	}
	

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	

	public BigDecimal getPriceOfCredit() {
		return priceOfCredit;
	}
	

	public void setPriceOfCredit(BigDecimal priceOfCredit) {
		this.priceOfCredit = priceOfCredit;
	}
	

	public Integer getNoOfCreditsBought() {
		return noOfCreditsBought;
	}
	

	public void setNoOfCreditsBought(Integer noOfCreditsBought) {
		this.noOfCreditsBought = noOfCreditsBought;
	}
	

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	

	public Date getPaymentDate() {
		return paymentDate;
	}
	

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	

	public String getAuthResponse() {
		return authResponse;
	}
	

	public void setAuthResponse(String authResponse) {
		this.authResponse = authResponse;
	}
	

	public String getAvsResponse() {
		return avsResponse;
	}
	

	public void setAvsResponse(String avsResponse) {
		this.avsResponse = avsResponse;
	}
	

	public String getApproved() {
		return approved;
	}
	

	public void setApproved(String approved) {
		this.approved = approved;
	}
	

	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	

	public String getFirstName() {
		return firstName;
	}
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public String getLastName() {
		return lastName;
	}
	

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getExpMonth() {
		return expMonth;
	}
	

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	

	public String getExpYear() {
		return expYear;
	}
	

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}
	

	public String getAddress() {
		return address;
	}
	

	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getZip() {
		return zip;
	}
	

	public void setZip(String zip) {
		this.zip = zip;
	}
	

	public String getEmailId() {
		return emailId;
	}
	

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	public String getPhone() {
		return phone;
	}
	

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public Date getLastModified() {
		return lastModified;
	}
	

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public List<PaymentDetail> getPaymentDetailList() {
		return paymentDetailList;
	}

	public void setPaymentDetailList(List<PaymentDetail> paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

}
