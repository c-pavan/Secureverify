<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Candidate Interview Feedback | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body>
<div id="main-wrapper">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
        <%@include file="includes/candidateLeftMenu.jsp"%>
        
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="green-bg">
            <div class="col-xs-12 green-bg-padding">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white">Candidate Interview Feedback</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="candidateSearchInterviewFeedbackForm" class="green-bg-padding" name="" action="#" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
              	<select id="candidatePerformance" name="candidatePerformance">
                  	<option value="" >Candidate Performance</option>
	      		 	<option value="1" >BEST</option>
	      		 	<option value="2" >GOOD</option>
	      		 	<option value="3" >AVERAGE</option>
	      		 	<option value="4" >NOT QUALIFIED</option>
               </select>
               </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="datetimepicker form-control" value="" id="scheduleFromTime" name="scheduleFromTime"  placeholder="From Date"/>
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="datetimepicker form-control" value="" id="scheduleToTime" name="scheduleToTime"  placeholder="To Date"/>
              </div>
              <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" id="" name="candidateInterviewFeedbackSearchButton" onclick = "javascript:searchAjx('candidateSearchInterviewFeedbackAjax', 1);">Search</button>
              </div>
            </form>
            <div id="candidatesearchinterviewfeedbackajax" class="table-responsive clear default-bg">
            <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Interviewer Name</th>
                    <th>Skill Set</th>
                    <th>From Time</th>
                    <th>To Time</th>
                    <th>Performance</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
               <s:if test="candidateScheduleTimingList!=null && candidateScheduleTimingList.size>0">
	      		<s:iterator var="candidateScheduleTiming" value="candidateScheduleTimingList">
               	  <tr>
                  <td><s:property value="candidateScheduleTimingId" /></td>
                  <td><s:property value="interviewer.interviewerFirstName" /> <s:property value="interviewer.interviewerLastName" /></td>
                   <td><s:property value="skillSet.primarySkillSet" /></td>
                  <td><s:date name="candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td><s:date name="candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></td>
                   <td>
                   		<s:if test="candidatePerformance==1" >Best</s:if>
                   		<s:elseif test="candidatePerformance==2" >Good</s:elseif>
                   		<s:elseif test="candidatePerformance==3" >Average</s:elseif>
                   		<s:elseif test="candidatePerformance==4" >Not Qualified</s:elseif>
                   		
                   </td>
                  <td>
                  <a href="#" class="btn btn-success" data-toggle="modal" data-target="#viewInterviewFeedback"  onclick="javascript:callAjx('cViewInterviewFeedback',<s:property value="candidateScheduleTimingId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a><!-- cViewInterviewFeedback.jsp -->
                  </tr>
                </s:iterator>
                </s:if>
                <s:else><tr><td colspan="6">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous</a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
   <div class="modal fade" id="viewInterviewFeedback" role="dialog"></div>
<%@include file="includes/footer.jsp"%>