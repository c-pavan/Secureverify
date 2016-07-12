<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Agent Interview Scheduled Candidates | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body class="form-block-page">
<div id="main-wrapper">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
       <%@include file="includes/adminLeftMenu.jsp"%>
		<!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Update Details</h5>
                </div>
                
              </div>
            </div>
            <div class="clear"></div>
            <form id="updateInterviewerScheduledCandidatesForm" name="updateInterviewerScheduledCandidatesForm" action="updateAgentInterviewerScheduledCandidates" method="post" onsubmit="return false;">
            
	        	<input type="hidden" id="candidateScheduleTimingId" name="candidateScheduleTimingId" value="<s:property value="candidateScheduleTiming.candidateScheduleTimingId" />" />
	        	
	            <h5>Schedule Details</h5>
              <div class="row">
                <div class="col-sm-4">
              		<h6 class="label">Zip Code</h6>
                    <div class="input-group">
	                  <input type="text" class="form-control" id="locationZipcode" name="locationZipcode" value="<s:property value="location.locationZipcode" />" placeholder="Zip" disabled="disabled"/>	                  
	                </div>                    
                </div>
              </div>
              	<div class="row">
                <div class="col-sm-4">
              	<h6 class="label">Scheduled Location</h6>
                <select name="locationId" id="locationId" disabled="disabled">
                	<option value="<s:property value="location.locationId"/>" selected="selected" ><s:property value="location.locationName"/></option>
                </select> 
                </div>
                <div class="col-sm-4">
              	<h6 class="label">Scheduled on</h6>
                  <select name="locationScheduleTimingId" id="locationScheduleTimingId" >
                    	<option value="">Select Schedule Time</option>
                    	<option value="<s:property value="candidateScheduleTiming.locationScheduleTimingId"/>" selected="selected"><s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /> - <s:date name="candidateScheduleTiming.candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></option>
                    	<s:if test="locationScheduleTimingList!=null && locationScheduleTimingList.size>0">
	      				<s:iterator var="locationScheduleTiming" value="locationScheduleTimingList">
                    	<option value="<s:property value="#locationScheduleTiming.locationScheduleTimingId"/>" ><s:date name="#locationScheduleTiming.locationScheduleFromTime" format="MM/dd/yyyy hh:mm a" /> - <s:date name="#locationScheduleTiming.locationScheduleToTime" format="MM/dd/yyyy hh:mm a" /></option>
                    	</s:iterator>
                    	</s:if>
                  </select>
                </div>
               </div>
               
            <h5>Interviewer Details</h5>
			<h6 class="label">Interviewer Id</h6>
                <div class="row">
               <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerId" name="interviewerId" value="<s:property value="interviewer.interviewerId" />" disabled />
                    
                  </div>
             </div>
              <h6 class="label">Name</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="interviewerFirstName" name="interviewerFirstName" value="<s:property value="interviewer.interviewerFirstName" />"  disabled />
                </div>
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="interviewerLastName" name="interviewerLastName" value="<s:property value="interviewer.interviewerLastName" />" disabled />
                </div>
              </div>
              <h6 class="label">Email</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="interviewerEmailId" name="interviewerEmailId" value="<s:property value="interviewer.interviewerEmailId" />"  disabled />
                </div>
              </div>
              <h6 class="label">Phone Number</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="interviewerPhoneNo" name="interviewerPhoneNo" value="<s:property value="interviewer.interviewerPhoneNo" />"  disabled />
                </div>
                <div class="col-sm-2">
                  <input type="text" class="form-control" id="interviewerPhoneNoExtension" name="interviewerPhoneNoExtension" value="<s:property value="interviewer.interviewerPhoneNoExtension" />"  disabled />
                </div>
              </div>
              <h6 class="label">Alternate Phone Number</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="interviewerAlternatePhone" name="interviewerAlternatePhone" value="<s:property value="interviewer.interviewerAlternatePhone" />"  disabled />
                </div>
                <div class="col-sm-2">
                  <input type="text" class="form-control" id="interviewerAlternatePhoneNoExtension" name="interviewerAlternatePhoneNoExtension" value="<s:property value="interviewer.interviewerAlternatePhoneNoExtension" />"  disabled />
                </div>
              </div>
              <h6 class="label">Skill Set</h6>
              <div class="row">
                <div class="col-sm-4">
                  <select id="" name="" disabled>
                    <option value="<s:property value="interviewer.interviewerSkillSet1"/>" selected="selected"><s:property value="interviewer.interviewerSkillSet1"/></option>
                  </select>
                </div>
                <div class="col-sm-4">
                  <select id="" name="" disabled>
                    <option value="<s:property value="interviewer.interviewerSkillSet2"/>" selected="selected"><s:property value="interviewer.interviewerSkillSet2"/></option>
                </select>
                </div>
                <div class="col-sm-4">
                  <select id="" name="" disabled>
                    <option value="<s:property value="interviewer.interviewerSkillSet3"/>" selected="selected"><s:property value="interviewer.interviewerSkillSet3"/></option>
                  </select>
                </div>
              </div>
            
            
            <h5>Candidate Details</h5>
            
            <h6 class="label">Candidate Id</h6>
                <div class="row">
               <div class="col-sm-4">
                    <input type="text" class="form-control" id="candidateId" name="candidateId" value="<s:property value="candidate.candidateId" />" disabled />
                  </div>
             </div>
              <h6 class="label">Name</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateFirstName" name="candidateFirstName" value="<s:property value="candidate.candidateFirstName" />"  disabled />
                </div>
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateLastName" name="candidateLastName" value="<s:property value="candidate.candidateLastName" />" disabled />
                </div>
              </div>
              <h6 class="label">Email</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateEmailId" name="candidateEmailId" value="<s:property value="candidate.candidateEmailId" />"  disabled />
                </div>
              </div>
              <h6 class="label">Phone Number</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidatePhoneNo" name="candidatePhoneNo" value="<s:property value="candidate.candidatePhoneNo" />"  disabled />
                </div>
                <div class="col-sm-2">
                  <input type="text" class="form-control" id="candidatePhoneNoExtension" name="candidatePhoneNoExtension" value="<s:property value="candidate.candidatePhoneNoExtension" />"  disabled />
                </div>
              </div>
              <h6 class="label">Alternate Phone Number</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateAlternatePhone" name="candidateAlternatePhone" value="<s:property value="candidate.candidateAlternatePhone" />"  disabled />
                </div>
                <div class="col-sm-2">
                  <input type="text" class="form-control" id="candidateAlternatePhoneNoExtension" name="candidateAlternatePhoneNoExtension" value="<s:property value="candidate.candidateAlternatePhoneNoExtension" />"  disabled />
                </div>
              </div>
              <h6 class="label">Skill Set</h6>
              <div class="row">
                <div class="col-sm-4">
                  <select id="" name="" disabled>
                    <option value="<s:property value="skillSet.primarySkillSet"/>" selected="selected"><s:property value="skillSet.primarySkillSet"/></option>
                  </select>
                </div>
               </div>
            
                <hr class="mt10" />
              <div class="clearfix">
             <button type="button" class="btn btn-success btn-large" id="updateInterviewerScheduledCandidatesButton" name="updateInterviewerScheduledCandidatesButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
             
              
              
		   </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>