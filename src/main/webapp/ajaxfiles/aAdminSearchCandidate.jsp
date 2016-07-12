<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Properties, com.secureVerify.util.Helper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% Properties properties = Helper.getPropertiesFromFile(); %>
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
	<s:else><li><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo-1)" />);" > <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
	<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo-4)" />);" ><s:property value="(pageNo-4)" /></a></li></s:if>
	<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo-3)" />);" ><s:property value="(pageNo-3)" /></a></li></s:if>
	<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo-2)" />);" ><s:property value="(pageNo-2)" /></a></li></s:if>
	<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo-1)" />);" ><s:property value="(pageNo-1)" /></a></li></s:if>
	<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
	<s:if test="(pageNo+1)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo+1)" />);" ><s:property value="(pageNo+1)" /></a></li></s:if>
	<s:if test="(pageNo+2)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo+2)" />);" ><s:property value="(pageNo+2)" /></a></li></s:if>
	<s:if test="(pageNo+3)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo+3)" />);" ><s:property value="(pageNo+3)" /></a></li></s:if>
	<s:if test="(pageNo+4)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo+4)" />);" ><s:property value="(pageNo+4)" /></a></li></s:if>
	<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#">  Next <i class="fa fa-arrow-right"></i></a></li></s:if>
	<s:else><li class="next"><a href="#" onclick="javascript: searchAjx('adminSearchCandidateAjax',<s:property value="(pageNo+1)" />);" >  Next <i class="fa fa-arrow-right"></i></a></li></s:else>
 </ul>