<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Admin Candidate | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body>
<div id="main-wrapper" class="admin-candidate-list">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
        <%@include file="includes/adminLeftMenu.jsp"%>
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="green-bg">
            <div class="col-xs-12 green-bg-padding">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white">Candidate Details</h5>
                </div>
               </div>
            </div>
            <div class="clear"></div>
            <form id="adminCandidateSearchForm" class="green-bg-padding" name="adminCandidateSearchForm" action="adminCandidateSearch" method="post" onsubmit="return false;">
              <div class="col-sm-13 search-padding">
                <select id="skillSetId" name="skillSetId">
                  	<s:if test="skillSetList!=null && skillSetList.size>0">
                  		<option value="" >Skill Set</option>
	      		 	  <s:iterator var="skillSet" value="skillSetList">
                      	<option value="<s:property value="skillSetId"/>" ><s:property value="primarySkillSet"/></option>
                      </s:iterator>
                    </s:if>
               </select>
              </div>
              <div class="col-sm-13 search-padding">
                <input type="text" class="datetimepicker form-control" id="scheduleFromTime" name="scheduleFromTime" placeholder="Schedule From Time">
              </div>
              <div class="col-sm-13 search-padding">
                <input type="text" class="datetimepicker form-control" id="scheduleToTime" name="scheduleToTime" placeholder="Schedule To Time">
              </div>
              <div class="col-sm-13 search-padding">
                <select id="interviewerId" name="interviewerId">
                  	<s:if test="interviewerList!=null && interviewerList.size>0">
                  		<option value="" >Interviewer</option>
	      		 	  <s:iterator var="interviewer" value="interviewerList">
                      	<option value="<s:property value="interviewerId"/>" ><s:property value="interviewerFirstName" /> <s:property value="interviewerLastName" /></option>
                      </s:iterator>
                    </s:if>
               </select>
              </div>
              <div class="col-sm-13 search-padding">
                <select id="interviewStatus" name="interviewStatus">
                  	<option value="" >Interview Status</option>
	      		 	<option value="1" >APPLIED</option>
	      		 	<option value="2" >SCHEDULED</option>
	      		 	<option value="3" >INTERVIEWED</option>
               </select>
              </div>
              <div class="col-sm-13 search-padding">
                <input type="text" class="form-control" id="candidateUniqueId" name="candidateUniqueId" placeholder="Veification Id">
              </div>
              <div class="col-sm-13 search-padding">
                <select id="locationId" name="locationId">
                  	<s:if test="locationList!=null && locationList.size>0">
                  		<option value="" >Location</option>
	      		 	  <s:iterator var="location" value="locationList">
                      	<option value="<s:property value="locationId"/>" ><s:property value="locationName"/></option>
                      </s:iterator>
                    </s:if>
               </select>
              </div>
              <div class="col-sm-13 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" id="adminCandidateSearchButton" name="adminCandidateSearchButton" onclick="javascript:searchAjx('adminSearchCandidateAjax', 1);" ><i class="fa fa-search"></i>Search</button>
              </div>
            </form>
            <div id="adminSearchCandidateAjax" class="table-responsive clear default-bg">
            <h6><strong>No. of Schedule Candidates: <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>View</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone No</th>
                    <th>Skill Set</th>
                    <th>Registered On</th>
                    <th>Schedule From</th>
                    <th>Schedule To</th>
                    <th>Interviewer Pickup Time</th>
                    <th>Interviewer</th>
                    <th>Interview Status</th>
                    <th>Verification Id</th>
                    <th>Agent</th>
                    <th>Location</th>
                  </tr>
                </thead>
                <tbody>
                <s:if test="candidateScheduleTimingList!=null && candidateScheduleTimingList.size>0">
	      		<s:iterator var="candidateScheduleTiming" value="candidateScheduleTimingList">
                  <tr>
                    <td>
                    	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewcandidate"  onclick="javascript:callAjx('vAdminCandidate',<s:property value="candidateScheduleTimingId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a><!-- aAdminViewCandidate.jsp -->
                    </td>
                    <td><s:property value="candidate.candidateId"/></td>
                    <td><s:property value="candidate.candidateFirstName" /> <s:property value="candidate.candidateLastName" /></td>
                    <td><s:property value="candidate.candidateEmailId" /></td>
                    <td><s:property value="candidate.candidatePhoneNo" /></td>
                    <td><s:property value="skillSet.primarySkillSet" /></td>
                    <td><s:date name="candidate.creationDate" format="MM/dd/yyyy"/></td>
                    <td><s:date name="candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></td>
                    <td><s:date name="candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></td>
                    <td><s:if test="interviewStatus!=null && interviewStatus!=0 && interviewStatus!=1"><s:date name="lastModifiedTime" format="MM/dd/yyyy hh:mm a" /></s:if></td>
                    <td><s:property value="interviewer.interviewerFirstName" /> <s:property value="interviewer.interviewerLastName" /></td>
                    <td><s:if test="interviewStatus!=null && interviewStatus==1">APPLIED</s:if><s:elseif test="interviewStatus!=null && interviewStatus==2">SCHEDULED</s:elseif><s:elseif test="interviewStatus!=null && interviewStatus==3">INTERVIEWED</s:elseif></td>
                    <td><s:if test="interviewStatus!=null && interviewStatus==3"><s:property value="candidateUniqueId" /></s:if></td>
                    <td><s:property value="agent.agentFirstName" /> <s:property value="agent.agentLastName" /></td>
                    <td><s:property value="location.locationName" /></td>
                  </tr>
                  </s:iterator>
                  </s:if>
                  <s:else><tr><td colspan="15">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
 <div class="modal fade" id="viewcandidate" role="dialog"></div>
<%@include file="includes/footer.jsp"%>