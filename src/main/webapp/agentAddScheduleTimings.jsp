<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Agent Schedule Timings | Secure Verify</title>
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
                  <h5 class="m0 clr-white pl25">Add Timing Details</h5>
                </div>
                
              </div>
            </div>
            <div class="clear"></div>
            <form id="addAgentScheduleTimingsForm" name="addAgentScheduleTimingsForm" action="saveAgentScheduleTimings" method="post" onsubmit="return false;">
              <h6 class="label">Location Name</h6>
                <div class="row">
                  <div class="col-sm-3">
                    <select name="locationId" id="locationId">
                    	<option value="">Locations</option>
                    	<s:if test="locationList!=null && locationList.size>0">
                    	<s:iterator value="locationList" var="location">
                    		<option value="<s:property value="locationId" />"><s:property value="locationName" /></option>
                    	</s:iterator>
                    	</s:if>
                    </select>
                  </div>
             </div>
                
                <div class="row">
                  <div class="col-sm-3">
                <h6 class="label">From</h6>
                    <input type="text" class="datetimepicker form-control" value="" id="scheduleFromTime" name="scheduleFromTime" placeholder="From Time"/>                
                  </div>
                  <div class="col-sm-3">
                <h6 class="label">To</h6>
                    <input type="text" class="datetimepicker form-control" value="" id="scheduleToTime" name="scheduleToTime" placeholder="To Time"/>
                  </div>
                </div>
              <div class="clearfix">
             <button type="button" class="btn btn-success btn-large mt10" id="addAgentScheduleTimingsButton" name="addAgentScheduleTimingsButton" >Add Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
                               
             </form> 
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>