<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Interview Schedule Candidates | Secure Verify</title>
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
       <%@include file="includes/adminLeftMenu.jsp"%>
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="green-bg">
            <div class="col-xs-12 green-bg-padding">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white">Interview Schedule Candidates</h5>
                </div>
              </div>
            </div>
            <form id="interviewerScheduledCandidateSearchForm" name="interviewerScheduledCandidateSearchForm" class="green-bg-padding" action="interviewerScheduledCandidatesSearch" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
               <select id="skillSetId" name="skillSetId" >
                      <option value="">Skill Set</option>
                      <s:if test="interviewer.skillSetList!=null && interviewer.skillSetList.size>0">
	      				<s:iterator var="skillSet" value="interviewer.skillSetList">
                      		<option value="<s:property value="skillSetId" />"><s:property value="primarySkillSet" /></option>
                      	</s:iterator>
                      </s:if>
               </select>
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="datetimepicker form-control" value="" id="scheduleFromTime" name="scheduleFromTime"  placeholder="From Date"/>
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="datetimepicker form-control" value="" id="scheduleToTime" name="scheduleToTime" placeholder=" To Date"/>
              </div>
              <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" onclick="javascript:searchAjx('interviewerScheduledCandidateSearchAjax', 1);" ><i class="fa fa-search"></i>Search</button>
              </div>
            </form>
            <div id="interviewersearchscheduledcandidatesajax" class="table-responsive clear default-bg">
            <h6><strong>No. of Schedule Candidates : <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Skill Set</th>
                    <th>Scheduled From</th>
                    <th>Scheduled To</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
               <tr>
                <s:if test="candidateScheduleTimingList!=null && candidateScheduleTimingList.size>0">
	      		<s:iterator var="candidateScheduleTiming" value="candidateScheduleTimingList">
               	  <tr>
                  <td><s:property value="candidateScheduleTimingId" /></td>
                  <td><s:property value="candidate.candidateFirstName" /> <s:property value="candidate.candidateLastName" /></td>
                   <td><s:property value="skillSet.primarySkillSet" /></td>
                  <td><s:date name="candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td><s:date name="candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td>
                  <a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewScheduleCandidate"  onclick="javascript:callAjx('vInterviewerScheduleCandidates',<s:property value="candidateScheduleTimingId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a><!-- iViewInterviewScheduleCandidates.jsp -->
                  <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>editInterviewerScheduledCandidate?candidateScheduleTimingId=<s:property value="candidateScheduleTimingId" />" class="btn btn-success boxed-float-btn"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/edit-btn-img.png" alt="Edit" data-toggle="tooltip" title="Edit" /></a>
                  <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>reportCandidatesfeedback?candidateScheduleTimingId=<s:property value="candidateScheduleTimingId" />" class="btn btn-success boxed-float-btn"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/report-btn-img.png" alt="Report" data-toggle="tooltip" title="Report" /></a>
                  </td>
                  </tr>
                </s:iterator>
                </s:if>
                <s:else><tr><td colspan="6">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#">Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="viewScheduleCandidate" role="dialog"></div>
<%@include file="includes/footer.jsp"%>