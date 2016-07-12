<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Agent Interview Applied Candidates | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body  class="form-block-page">
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
            <form id="updateAgentIntAppliedCandidateForm" name="updateAgentIntAppliedCandidateForm" action="updateAgentInterviewAppliedCandidates" method="post" onsubmit="return false;">
            <h6 class="label">Candidate Id</h6>
                <div class="row">
               <div class="col-sm-4">
                    <input type="text" class="form-control" id="hcandidateId" name="hcandidateId" value="<s:property value="candidateScheduleTiming.candidateId" />" disabled />
                    <input type="hidden" id="candidateScheduleTimingId" name="candidateScheduleTimingId" value="<s:property value="candidateScheduleTiming.candidateScheduleTimingId" />" />
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
              <div class="row">
                <div class="col-sm-4">
              <h6 class="label">Email</h6>
                  <input type="text" class="form-control" id="candidateEmailId" name="candidateEmailId" value="<s:property value="candidate.candidateEmailId" />"  disabled />
                </div>
                <div class="col-sm-4">
              <h6 class="label">Skill Set</h6>
                  <select id="" name="" disabled>
                    <option value="<s:property value="skillSet.primarySkillSet"/>" selected="selected"><s:property value="skillSet.primarySkillSet"/></option>
                  </select>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-4">
              		<h6 class="label">Zip Code</h6>
                   <input type="text" class="form-control" id="locationZipcode" name="locationZipcode" value="<s:property value="location.locationZipcode" />" placeholder="Zip" disabled="disabled"/>
	             </div>
              </div>
              <div class="row">
                <div class="col-sm-4">
              <h6 class="label">Scheduled Location</h6>
                    <select name="locationId" id="locationId" disabled="disabled">
                    	<option value="<s:property value="location.locationId"/>" selected="selected" ><s:property value="location.locationName"/></option>
                    </select>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-4">
              <h6 class="label">Selected Schedule Time</h6>
              	  <select name="locationScheduleTimingId" id="locationScheduleTimingId" >
                    	<option value="">Select Schedule Time</option>
                    	<option value="<s:property value="candidateScheduleTiming.locationScheduleTimingId"/>" selected="selected"><s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /> - <s:date name="candidateScheduleTiming.candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></option>
                    	<s:if test="locationScheduleTimingList!=null && locationScheduleTimingList.size>0">
	      				<s:iterator var="locationScheduleTiming" value="locationScheduleTimingList">
                    	<option value="<s:property value="#locationScheduleTiming.locationScheduleTimingId"/>" <s:if test="#locationScheduleTiming.locationScheduleTimingId.equals(candidateScheduleTiming.locationScheduleTimingId)">selected="selected"</s:if> ><s:date name="#locationScheduleTiming.locationScheduleFromTime" format="MM/dd/yyyy hh:mm a" /> - <s:date name="#locationScheduleTiming.locationScheduleToTime" format="MM/dd/yyyy hh:mm a" /></option>
                    	</s:iterator>
                    	</s:if>
                    </select>
                </div>
               </div>
                <hr class="mt10" />
              <div class="clearfix">
             <button type="button" class="btn btn-success btn-large" id="updateAgentIntAppliedCandidateButton" name="updateAgentIntAppliedCandidateButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>