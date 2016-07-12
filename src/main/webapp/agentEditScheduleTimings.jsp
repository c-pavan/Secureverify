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
                  <h5 class="m0 clr-white pl25">Update Timing Details</h5>
                </div>
                
              </div>
            </div>
            <div class="clear"></div>
            <form id="updateAgentScheduleTimingsForm" name="updateAgentScheduleTimingsForm" action="updateAgentScheduleTimings" method="post" onsubmit="return false;">
              <h6 class="label">Location Name</h6>
                <div class="row">
               <div class="col-sm-4">
                    <input type="text" class="form-control" id="locationName" name="locationName" value="<s:property value="location.locationName" />" disabled />
                    <input type="hidden" id="locationId" name="locationId" value="<s:property value="locationScheduleTiming.locationId" />" />
                    <input type="hidden" id="locationScheduleTimingId" name="locationScheduleTimingId" value="<s:property value="locationScheduleTiming.locationScheduleTimingId" />" />
                  </div>
             </div>
                <div class="row">
                  <div class="col-sm-4">
                <h6 class="label">From</h6>
                    <input type="text" class="datetimepicker form-control" value="<s:date name="locationScheduleTiming.locationScheduleFromTime" format="MM/dd/yyyy hh:mm a"/>" id="scheduleFromTime" name="scheduleFromTime"/>                
                  </div>
                  <div class="col-sm-4">
                <h6 class="label">To</h6>
                    <input type="text" class="datetimepicker form-control" value="<s:date name="locationScheduleTiming.locationScheduleToTime" format="MM/dd/yyyy hh:mm a"/>" id="scheduleToTime" name="scheduleToTime"/>
                  </div>
                </div>
                <hr class="mt10" />
              <div class="clearfix">
             <button type="button" class="btn btn-success btn-large" id="updateAgentScheduleTimingsButton" name="updateAgentScheduleTimingsButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
                               
             </form> 
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>