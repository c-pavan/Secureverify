package com.secureVerify.action;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.secureVerify.bo.AgentBo;
import com.secureVerify.bo.CandidateBo;
import com.secureVerify.bo.CandidateCouponMapBo;
import com.secureVerify.bo.CandidateEmployerSkillSetMapBo;
import com.secureVerify.bo.CandidateScheduleTimingBo;
import com.secureVerify.bo.CouponBo;
import com.secureVerify.bo.CreditTypesBo;
import com.secureVerify.bo.CreditsAvailableBo;
import com.secureVerify.bo.EmployerBo;
import com.secureVerify.bo.FeedbackBo;
import com.secureVerify.bo.InterviewerBo;
import com.secureVerify.bo.LocationBo;
import com.secureVerify.bo.LocationScheduleTimingBo;
import com.secureVerify.bo.PaymentDetailBo;
import com.secureVerify.bo.PropertieBo;
import com.secureVerify.bo.SecureVerifyEmailSubjectBodyBo;
import com.secureVerify.bo.SkillSetBo;
import com.secureVerify.bo.UserBo;
import com.secureVerify.model.Feedback;
import com.secureVerify.model.Propertie;
import com.secureVerify.model.SecureVerifyEmailSubjectBody;
import com.secureVerify.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAction extends ActionSupport{
	
	private static final long serialVersionUID = -5613304104802534382L;
	
	public static final int ACTIVE = 1;
	public static final int INACTIVE = 0;
	public static final Integer EMPLOYER = 1;
	public static final Integer CANDIDATE = 2;
	
	@SuppressWarnings("rawtypes")
	public Map session;
	protected String urlPage = "";
	
	protected Integer startNo;
	protected Integer endNo;
	protected Integer noOfPages;
	protected Integer pageNo = 1;
	protected Integer pageSize = 10;
	protected Integer totalSize = 0;
	
	protected Integer uniqueId;
	
	protected SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody;
	
	protected AgentBo agentBo;
	protected CandidateBo candidateBo;
	protected CandidateCouponMapBo candidateCouponMapBo;
	protected CandidateEmployerSkillSetMapBo candidateEmployerSkillSetMapBo;
	protected CandidateScheduleTimingBo candidateScheduleTimingBo;
	protected CouponBo couponBo;
	protected CreditsAvailableBo creditsAvailableBo;
	protected CreditTypesBo creditTypesBo;
	protected EmployerBo employerBo;
	protected FeedbackBo feedbackBo;
	protected InterviewerBo interviewerBo;
	protected LocationBo locationBo;
	protected LocationScheduleTimingBo locationScheduleTimingBo;
	protected PropertieBo propertieBo;
	protected PaymentDetailBo paymentDetailBo;
	protected SecureVerifyEmailSubjectBodyBo secureVerifyEmailSubjectBodyBo;
	protected SkillSetBo skillSetBo;
	protected UserBo userBo;
	
	protected User user;
	protected List<Feedback> feedbackList;
	protected String redirection;
	protected String securitycode;
	protected Propertie propertie;
	
	@SuppressWarnings("unchecked")
	public void getGlobalContent(){
		try{
			session = ActionContext.getContext().getSession();
			user = (User) session.get("user");
			if(redirection!=null && redirection.equals("disabled")){
				session.put("redirection", "disabled");
			}else if(session.get("redirection")!=null && session.get("redirection").equals("disabled")){
				session.put("redirection", "disabled");
			}else{
				session.put("redirection", "enabled");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    protected boolean isEmpty(String str) {
        return str == null ? true:(str.trim().equals("") ? true:false);
    }

    protected boolean isNumberNullOrZero(Integer num) {
        return num == null ? true:( num == 0 ? true:false);
    }

    protected boolean isNumberNull(Integer num) {
        return num == null ? true:false;
    }

    protected boolean isDoubleNullOrZero(Double num) {
        return num == null ? true:( num == 0 ? true:false);
    }

    protected boolean isDoubleNull(Double num) {
        return num == null ? true:false;
    }

    protected boolean isBigDecimalNullOrZero(BigDecimal num) {
        return num == null ? true:( num == new BigDecimal(0) ? true:false);
    }

    protected boolean isBigDecimalNull(BigDecimal num) {
        return num == null ? true:false;
    }

    protected boolean isFileNull(File file) {
        return file == null ? true:false;
    }

    protected boolean isDateNull(Date file) {
        return file == null ? true:false;
    }
	

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	public String getUrlPage() {
		return urlPage;
	}

	public void setUrlPage(String urlPage) {
		this.urlPage = urlPage;
	}

	public Integer getStartNo() {
		return startNo;
	}

	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}

	public Integer getEndNo() {
		return endNo;
	}

	public void setEndNo(Integer endNo) {
		this.endNo = endNo;
	}

	public Integer getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public PropertieBo getPropertieBo() {
		return propertieBo;
	}

	public void setPropertieBo(PropertieBo propertieBo) {
		this.propertieBo = propertieBo;
	}

	public String getRedirection() {
		return redirection;
	}

	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}

	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AgentBo getAgentBo() {
		return agentBo;
	}

	public void setAgentBo(AgentBo agentBo) {
		this.agentBo = agentBo;
	}

	public CandidateBo getCandidateBo() {
		return candidateBo;
	}

	public void setCandidateBo(CandidateBo candidateBo) {
		this.candidateBo = candidateBo;
	}

	public CouponBo getCouponBo() {
		return couponBo;
	}

	public void setCouponBo(CouponBo couponBo) {
		this.couponBo = couponBo;
	}

	public EmployerBo getEmployerBo() {
		return employerBo;
	}

	public void setEmployerBo(EmployerBo employerBo) {
		this.employerBo = employerBo;
	}

	public InterviewerBo getInterviewerBo() {
		return interviewerBo;
	}

	public void setInterviewerBo(InterviewerBo interviewerBo) {
		this.interviewerBo = interviewerBo;
	}

	public LocationBo getLocationBo() {
		return locationBo;
	}

	public void setLocationBo(LocationBo locationBo) {
		this.locationBo = locationBo;
	}

	public SkillSetBo getSkillSetBo() {
		return skillSetBo;
	}

	public void setSkillSetBo(SkillSetBo skillSetBo) {
		this.skillSetBo = skillSetBo;
	}

	public LocationScheduleTimingBo getLocationScheduleTimingBo() {
		return locationScheduleTimingBo;
	}

	public void setLocationScheduleTimingBo(LocationScheduleTimingBo locationScheduleTimingBo) {
		this.locationScheduleTimingBo = locationScheduleTimingBo;
	}

	public CandidateScheduleTimingBo getCandidateScheduleTimingBo() {
		return candidateScheduleTimingBo;
	}

	public void setCandidateScheduleTimingBo(
			CandidateScheduleTimingBo candidateScheduleTimingBo) {
		this.candidateScheduleTimingBo = candidateScheduleTimingBo;
	}

	public Integer getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(Integer uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}

	public FeedbackBo getFeedbackBo() {
		return feedbackBo;
	}

	public void setFeedbackBo(FeedbackBo feedbackBo) {
		this.feedbackBo = feedbackBo;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public Propertie getPropertie() {
		return propertie;
	}

	public void setPropertie(Propertie propertie) {
		this.propertie = propertie;
	}

	public CandidateCouponMapBo getCandidateCouponMapBo() {
		return candidateCouponMapBo;
	}

	public void setCandidateCouponMapBo(CandidateCouponMapBo candidateCouponMapBo) {
		this.candidateCouponMapBo = candidateCouponMapBo;
	}

	public CandidateEmployerSkillSetMapBo getCandidateEmployerSkillSetMapBo() {
		return candidateEmployerSkillSetMapBo;
	}

	public void setCandidateEmployerSkillSetMapBo(
			CandidateEmployerSkillSetMapBo candidateEmployerSkillSetMapBo) {
		this.candidateEmployerSkillSetMapBo = candidateEmployerSkillSetMapBo;
	}

	public SecureVerifyEmailSubjectBodyBo getSecureVerifyEmailSubjectBodyBo() {
		return secureVerifyEmailSubjectBodyBo;
	}

	public void setSecureVerifyEmailSubjectBodyBo(
			SecureVerifyEmailSubjectBodyBo secureVerifyEmailSubjectBodyBo) {
		this.secureVerifyEmailSubjectBodyBo = secureVerifyEmailSubjectBodyBo;
	}

	public SecureVerifyEmailSubjectBody getSecureVerifyEmailSubjectBody() {
		return secureVerifyEmailSubjectBody;
	}

	public void setSecureVerifyEmailSubjectBody(
			SecureVerifyEmailSubjectBody secureVerifyEmailSubjectBody) {
		this.secureVerifyEmailSubjectBody = secureVerifyEmailSubjectBody;
	}

	public CreditsAvailableBo getCreditsAvailableBo() {
		return creditsAvailableBo;
	}

	public void setCreditsAvailableBo(CreditsAvailableBo creditsAvailableBo) {
		this.creditsAvailableBo = creditsAvailableBo;
	}

	public CreditTypesBo getCreditTypesBo() {
		return creditTypesBo;
	}

	public void setCreditTypesBo(CreditTypesBo creditTypesBo) {
		this.creditTypesBo = creditTypesBo;
	}

	public PaymentDetailBo getPaymentDetailBo() {
		return paymentDetailBo;
	}

	public void setPaymentDetailBo(PaymentDetailBo paymentDetailBo) {
		this.paymentDetailBo = paymentDetailBo;
	}

}
