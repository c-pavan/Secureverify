<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Edit Candidate Feedback | Secure Verify</title>
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
                  <h5 class="m0 clr-white pl25">Edit Candidate Feedback</h5>
                </div>
              </div>
            </div>
            <form class="clear pt5" id="updateCandidatefeedbackForm" name="updateCandidatefeedbackForm" action="updateInterviewerInterviewedCandidate" method="post" onsubmit="return false;">
            	<input type="hidden" id="candidateScheduleTimingId" name="candidateScheduleTimingId" value="<s:property value="candidateScheduleTiming.candidateScheduleTimingId" />" />
                <br/>
                <h6 class="label">Candidate Id</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="candidateId" name="candidateId" value="<s:property value="candidate.candidateId" />"  disabled />
                  </div>
                 </div>
               <h6 class="label">Name</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="candidateFirstName" name="candidateFirstName" value="<s:property value="candidate.candidateFirstName" />"  placeholder="First Name" disabled />
                  </div>
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="candidateLastName" name="candidateLastName" value="<s:property value="candidate.candidateLastName" />" placeholder="Last Name" disabled />
                  </div>
                </div>
                <div class="row">
                 <div class="col-sm-4">
                 <h6 class="label">Candidate Performance</h6>
                    <select id="candidatePerformance" name="candidatePerformance">
                      <option value="">Select</option>
                      <option value="1" <s:if test="candidateScheduleTiming.candidatePerformance==1">selected="selected"</s:if> >Best</option>
                      <option value="2" <s:if test="candidateScheduleTiming.candidatePerformance==2">selected="selected"</s:if> >Good</option>
                      <option value="3" <s:if test="candidateScheduleTiming.candidatePerformance==3">selected="selected"</s:if> >Average</option>
                      <option value="4" <s:if test="candidateScheduleTiming.candidatePerformance==4">selected="selected"</s:if> >Not Qualified</option>
                    </select>
                 </div>
               </div>
                <div class="row">
                 <div class="col-sm-8">
                 <h6 class="label">Candidate Feedback</h6>
                 <textarea class="form-control" rows="8" id="candidateFeedback" name="candidateFeedback" placeholder="Candidate Feedback"><s:property value="candidateScheduleTiming.candidateFeedback" /></textarea>
                 </div>
               </div>
               <hr class="mt30" />
            <div class="clearfix">
              <button type="button" class="btn btn-success btn-large" id="updateCandidatefeedbackButton" name="updateCandidatefeedbackButton">Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
            </form>   
          </div>
        </div>
      </div>
    </div>
  </div>
 <%@include file="includes/footer.jsp"%>