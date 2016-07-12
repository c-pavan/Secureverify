<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Edit Schedule Verification | Secure Verify</title>
<meta name="description" content="Secure Verify is a technology screening and testing agency with presence all across of USA, Canada and India. Secure Verify will help you identify the best resource, screen them and present them to you in a efficient and timely manner" />
<meta name="keywords" content="Secure Verify" />
<%@include file="includes/links.jsp"%>
</head>
<body class="form-block-page">
<div id="main-wrapper">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
        <%@include file="includes/candidateLeftMenu.jsp"%>
        
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Edit Schedule Verification</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="updateCandidateScheduleVerificationForm" name="updateCandidateScheduleVerificationForm" action="updateCandidateScheduleVerification" method="post" onsubmit="return false;">
          
          <input type="hidden" id="candidateScheduleTimingId" name="candidateScheduleTimingId" value="<s:property value="candidateScheduleTiming.candidateScheduleTimingId" />" />
          <h6 class="label">Candidate Id</h6>
                <div class="row">
               <div class="col-sm-4">
                    <input type="text" class="form-control" id="candidateId" name="candidateId" value="<s:property value="candidate.candidateId" />" disabled />
                  </div>
             </div>
                <h6 class="label">Zip Code</h6>
                <div class="row">
                <div class="col-sm-4">
              	<div class="input-group">
	                  <input type="text" class="form-control" id="locationZipcode" name="locationZipcode" value="<s:property value="location.locationZipcode" />" placeholder="Zip" />
	                  <span class="input-group-btn">
	                  <button class="btn btn-success zipsearch-btn" type="button" id="locationZipcodeSearch" name="locationZipcodeSearch"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/go-icon.png" alt="Go" title="Go" /></button>
	                  </span> 
	                </div>                    
                </div>
              </div>
                <h6 class="label">Locations Near to you</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <select name="locationId" id="locationId" onchange="if($('#locationId').val()==''){ $('#locationScheduleTimingId').html(''); }else{ getLocationScheduleTimings(); }">
                    	<option value="">Near Locations</option>
                    	<option value="<s:property value="location.locationId" />" selected="selected"><s:property value="location.locationName" /></option>
                    </select>                    
                  </div>
                </div>
                <h6 class="label">Available Timimgs</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <select name="locationScheduleTimingId" id="locationScheduleTimingId" >
                    	<option value="">Select Schedule Time</option>
                    	<s:if test="locationScheduleTimingList!=null && locationScheduleTimingList.size>0">
	      				<s:iterator var="locationScheduleTiming" value="locationScheduleTimingList">
                    	<option value="<s:property value="#locationScheduleTiming.locationScheduleTimingId"/>" <s:if test="#locationScheduleTiming.locationScheduleTimingId.equals(candidateScheduleTiming.locationScheduleTimingId)">selected="selected"</s:if> ><s:date name="#locationScheduleTiming.locationScheduleFromTime" format="MM/dd/yyyy hh:mm a" /> - <s:date name="#locationScheduleTiming.locationScheduleToTime" format="MM/dd/yyyy hh:mm a" /></option>
                    	</s:iterator>
                    	</s:if>
                  </select>                
                  </div>
                </div>
                <hr class="mt10" />
            <div class="clearfix"> <button type="button" class="btn btn-success btn-large" id="candidateScheduleVerificationButton" name="candidateScheduleVerificationButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<%@include file="includes/footer.jsp"%>