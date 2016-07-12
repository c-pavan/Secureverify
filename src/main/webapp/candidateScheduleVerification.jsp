<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Schedule Verification | Secure Verify</title>
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
        <%@include file="includes/candidateLeftMenu.jsp"%>
        
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Fill the form to Schedule your Verification</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="candSchedVerForm" name="candSchedVerForm" action="saveCandidateScheduleVerification" method="post" onsubmit="return false;">
          		<s:if test="candidateEmployerSkillSetMapList!=null && candidateEmployerSkillSetMapList.size>0">
          		<h6 class="label">Employer</h6>
          		<div class="row">
                  <div class="col-sm-4">
	          		<select name="candidateEmployerSkillSetMapId" id="candidateEmployerSkillSetMapId" >
	                	<option value="0">Select Employer</option>
		          		<s:iterator value="candidateEmployerSkillSetMapList" var="candidateEmployerSkillSetMap">
		          		<option value="<s:property value="candidateEmployerSkillSetMapId"/>"><s:property value="employer.employerCompanyName"/></option>
		          		</s:iterator>
	                </select>
	              </div>
                </div>
          		</s:if>
                <h6 class="label">Zip Code</h6>
                <div class="row">
                <div class="col-sm-4">
              	<div class="input-group">
	                  <input type="text" class="form-control" id="locationZipcode" name="locationZipcode" value="" placeholder="Zip" />
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
                    </select>
                  </div>
                  <div class="col-sm-1 p0"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/loader.gif" alt="locations loading" id="locationLoader" class="loading"/></div>
                </div>
                <h6 class="label">Available Timings</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <select name="locationScheduleTimingId" id="locationScheduleTimingId" >
                    	<option value="">Select Schedule Time</option>
                  	</select>
                  </div>
                  <div class="col-sm-1 p0"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/loader.gif" alt="Timings loading" id="locationScheduleTimingLoader" class="loading" /></div>
                </div>
                <hr class="mt10" />
            <div class="clearfix"> <button type="button" class="btn btn-success btn-large" id="candSchedVerifButton" name="candSchedVerifButton" >Submit</button></div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<%@include file="includes/footer.jsp"%>