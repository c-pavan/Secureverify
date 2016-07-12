<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);
%>
<header id="header" class="header-style-1">
  <div class="header-nav-bar">
    <div class="container"> 
      <div class="css-table logo">
        <div class="css-table-cell"> 
        	<h1 class="logo-h1">
        		<s:if test="user!=null || agent!=null || interviewer!=null || employer!=null || candidate!=null"><a href="#"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/logo.png" alt="Secureverify" /></a></s:if>
        		<s:else><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>home"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/logo.png" alt="Secureverify" /></a></s:else>
        	</h1>
        </div>
      </div>
      <s:if test="user!=null && urlPage!=null && (urlPage.equals('adminInterviewer') || urlPage.equals('adminCandidate') || urlPage.equals('adminSkillSet') || urlPage.equals('adminLocation') || urlPage.equals('adminAgent') || urlPage.equals('adminEmployer') || urlPage.equals('adminCoupon') || urlPage.equals('adminCreditTypes') || urlPage.equals('adminPayments') || urlPage.equals('adminViewProfile') || urlPage.equals('adminEditProfile') )">
      <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLogout" class="logout-btn">Logout</a>
      </s:if>
      <s:elseif test="agent!=null && urlPage!=null && (urlPage.equals('agentLocation') || urlPage.equals('agentScheduleTimings') || urlPage.equals('agentInterviewAppliedCandidates') || urlPage.equals('agentInterviewerScheduledCandidates') || urlPage.equals('agentInterviewedCandidates') || urlPage.equals('agentPassword') || urlPage.equals('agentProfile') )">
      <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLogout" class="logout-btn">Logout</a>
      </s:elseif>
      <s:elseif test="interviewer!=null && urlPage!=null && (urlPage.equals('interviewerAppliedCandidates') || urlPage.equals('interviewerScheduledCandidates') || urlPage.equals('interviewerInterviewedCandidates') || urlPage.equals('interviewerEditPassword') || urlPage.equals('interviewerEditProfile') )">
      <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerLogout" class="logout-btn">Logout</a>
      </s:elseif>
      <s:elseif test="employer!=null && urlPage!=null && (urlPage.equals('employerCandidates') || urlPage.equals('employerAppliedCandidates') || urlPage.equals('employerScheduledCandidates') || urlPage.equals('employerInterviewedCandidates') || urlPage.equals('employerCreditsManagment') || urlPage.equals('employerChangePassword') || urlPage.equals('employerUpdateProfile') || urlPage.equals('updateCompanyInfo') )">
      <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerLogout" class="logout-btn">Logout</a>
      </s:elseif>
      <s:elseif test="candidate!=null && urlPage!=null && (urlPage.equals('candidateScheduleVerification') || urlPage.equals('candidateScheduleVerification') || urlPage.equals('candidateScheduledTimeSlots') || urlPage.equals('candidateScheduledInterviews') || urlPage.equals('candidateInterviewFeedback') || urlPage.equals('candidateManageCertifications') || urlPage.equals('candidateEmployerScheduledInterview') || urlPage.equals('candidateUpdatePassword') || urlPage.equals('candidateUpdateProfile') || urlPage.equals('employerDetails') || urlPage.equals('candidateResumesHistory') || urlPage.equals('visaDetails') || urlPage.equals('candidateCredits') )">
      <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateLogout" class="logout-btn">Logout</a>
      </s:elseif>
      <s:else>
      	<a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#" id="mobile-menu-toggle"><span></span></a> 
      	<nav>
	      <ul class="primary-nav">
	        <li <s:if test="urlPage!=null && urlPage.equals('home')">class="active"</s:if> > <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>home">Home</a></li>
	        <li class="has-submenu <s:if test="urlPage!=null && (urlPage.equals('employerLogin') || urlPage.equals('employerRegistration') || urlPage.equals('employerFaq') )">active</s:if>" > 
	        	<a href="javascript:void(0)">For Employers</a>
	        	<ul>
	              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerLogin">Login</a></li>
	              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerRegistration">Register</a></li>
	              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerFaq">FAQ</a></li>
	          </ul>
	        </li>
	        <li class="has-submenu <s:if test="urlPage!=null && (urlPage.equals('candidateLogin') || urlPage.equals('candidateRegistration') || urlPage.equals('candidateFaq') )">active</s:if>" > 
	        	<a href="javascript:void(0)">For Candidates</a>
	        	<ul>
	              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateLogin">Login</a></li>
	              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateRegistration">Register</a></li>
	              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateFaq">FAQ</a></li>
	          </ul>
	        </li>
	        <li <s:if test="urlPage!=null && urlPage.equals('whySecureVerify')">class="active"</s:if> ><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>whySecureVerify">Why SecureVerify</a></li>
	        <li <s:if test="urlPage!=null && urlPage.equals('contactus')">class="active"</s:if> ><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>contactus">Contact</a></li>
	      </ul>
	    </nav>
      </s:else>
    </div>
    <div id="mobile-menu-container" class="container">
      <div class="login-register"></div>
      <div class="menu"></div>
    </div>
  </div>
  <div class="header-page-title">
    <div class="container">
    	<s:if test="urlPage!=null && urlPage.equals('employerLogin')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/login-icon.png" alt="login" /> Employer Login</h2></s:if>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerFaq')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/faq-icon.png" alt="faq" /> Employer FAQ</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateLogin')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/login-icon.png" alt="login" /> Candidate Login</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateFaq')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/faq-icon.png" alt="faq" /> Candidate FAQ</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerRegistration')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/register-icon.png" alt="Register" /> Employer Register</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateRegistration')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/register-icon.png" alt="Register" /> Candidate Register</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('whySecureVerify')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/whyus-icon.png" alt="Why Secure Verify" /> Why Secure Verify</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('contactus')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/contactus-icon.png" alt="contactus" /> Contact Us</h2></s:elseif>    	
    	<s:elseif test="urlPage!=null && urlPage.equals('verifyCandidate')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/candidate-icon.png" alt="Candidate Details" /> Candidate Details</h2></s:elseif>
    	<s:elseif test="urlPage!=null && (urlPage.equals('adminLogin') || urlPage.equals('adminLogout') || urlPage.equals('agentLogout') || urlPage.equals('interviewerLogout'))"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/login-icon.png" alt="login" />Login</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('resetPassword')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/login-icon.png" alt="Reset Password" /> Reset Password</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('forgotAdminPassword')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/forgot-password.png" alt="forgot Admin password" /> Forgot Admin Password</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('forgotInterviewerPassword')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/forgot-password.png" alt="forgot Interviewer password" /> Forgot Interviewer Password</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('forgotAgentPassword')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/forgot-password.png" alt="forgot Agent password" /> Forgot Agent Password</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('forgotCandidatePassword')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/forgot-password.png" alt="forgot Candidate password" /> Forgot Candidate Password</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('forgotEmployerPassword')"><h2><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/forgot-password.png" alt="forgot Employer password" /> Forgot Employer Password</h2></s:elseif>
    	
    	<!-- Employer Headers -->
    	<s:elseif test="urlPage!=null && urlPage.equals('addCredits')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Add Credits</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('manageCandidates')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Manage Candidates</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerCreditsManagment')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Credits Management</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerChangePassword')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Change Password</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerUpdateProfile')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Update Profile</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('updateCompanyInfo')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Update Company Info</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerCandidates')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Candidates</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerAppliedCandidates')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Applied Candidates</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerScheduledCandidates')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Scheduled Candidates</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerInterviewedCandidates')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Interviewed Candidates</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerAllCandidates')"><h2><span>Employer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; All Candidates</h2></s:elseif>
    	
    	
    	
    	<!-- Candidate Headers -->
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateScheduleVerification')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Schedule Verification </h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateManageCertifications')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Manage Certifications</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateUpdatePassword')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Update Password</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateResumesHistory')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Resumes History</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateUpdateProfile')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Update Profile</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('employerDetails')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Employer Details</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('visaDetails')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Visa Details</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateScheduledTimeSlots')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Scheduled Time Slots</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateScheduledInterviews')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Scheduled Interviews</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateInterviewFeedback')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Interview Feedback</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateEmployerScheduledInterview')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Employer Scheduled Interview</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('candidateCredits')"><h2><span>Candidate</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Total Credits</h2></s:elseif>
    	
    	<!-- Admin Headers -->
    	<s:elseif test="urlPage!=null && urlPage.equals('adminInterviewer')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Interviewers</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminCandidate')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Candidates</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminSkillSet')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; SkillSets</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminLocation')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Locations</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminAgent')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Agents</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminEmployer')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Employers</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminCoupon')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Coupons</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminCreditTypes')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Credit Types</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminPayments')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Payments</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminViewProfile')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; View Profile</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('adminEditProfile')"><h2><span>Admin</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Edit Profile</h2></s:elseif>
    	
    	<!-- Interviewer Headers -->
    	<s:elseif test="urlPage!=null && urlPage.equals('interviewerAppliedCandidates')"><h2><span>Interviewer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Applied Candidates</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('interviewerScheduledCandidates')"><h2><span>Interviewer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Scheduled Candidates</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('interviewerInterviewedCandidates')"><h2><span>Interviewer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Interviewed Candidates</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('interviewerEditPassword')"><h2><span>Interviewer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Update Password</h2></s:elseif>
    	<s:elseif test="urlPage!=null && urlPage.equals('interviewerEditProfile')"><h2><span>Interviewer</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Update Profile</h2></s:elseif>
    	
    	<!-- Agent Headers -->
       <s:elseif test="urlPage!=null && urlPage.equals('agentLocation')"><h2><span>Agent</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Location</h2></s:elseif>
       <s:elseif test="urlPage!=null && urlPage.equals('agentScheduleTimings')"><h2><span>Agent</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Add Schedule Timings</h2></s:elseif>
       <s:elseif test="urlPage!=null && urlPage.equals('agentInterviewAppliedCandidates')"><h2><span>Agent</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Applied Candidates </h2></s:elseif>
       <s:elseif test="urlPage!=null && urlPage.equals('agentInterviewerScheduledCandidates')"><h2><span>Agent</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Scheduled Candidates </h2></s:elseif>
       <s:elseif test="urlPage!=null && urlPage.equals('agentInterviewedCandidates')"><h2><span>Agent</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Interviewed Candidates </h2></s:elseif>
       <s:elseif test="urlPage!=null && urlPage.equals('agentPassword')"><h2><span>Agent</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Update Password </h2></s:elseif>
       <s:elseif test="urlPage!=null && urlPage.equals('agentProfile')"><h2><span>Agent</span> &nbsp;<i class="fa fa-chevron-right"></i>&nbsp; Update Profile </h2></s:elseif>
       
    </div>
  </div>
</header>