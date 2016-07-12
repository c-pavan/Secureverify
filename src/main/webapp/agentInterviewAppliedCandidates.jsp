<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Agent Candidates to be Interviewed | Secure Verify</title>
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
                  <h5 class="m0 clr-white">Candidates to be Interviewed</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
            <form id="" name="" class="green-bg-padding" action="#" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="First Name" id="firstName" name="firstName" onkeypress="return keyRestrict(event,'char');"/>
              </div>
              <div class="col-sm-2 search-padding">
                    <select id="skillSetId" name="skillSetId">
                   <option value="">Skill Set</option>
                  	<s:if test="skillSetList!=null && skillSetList.size>0">
                  		<option value="" >Select Skill Set</option>
	      		 	  <s:iterator var="skillSet" value="skillSetList">
                      	<option value="<s:property value="skillSetId"/>" ><s:property value="primarySkillSet"/></option>
                      </s:iterator>
                      </s:if>
               </select>
              </div>
              <div class="col-sm-2 search-padding">
                    <input type="text" class="datetimepicker form-control" placeholder="Time From" id="scheduleFromTime" name="scheduleFromTime"/>
              </div>
              <div class="col-sm-2 search-padding">
                    <input type="text" class="datetimepicker form-control" placeholder="Time To" id="scheduleToTime" name="scheduleToTime"/>
              </div>
              <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" id="" name="agentInterviewAppliedCandidatesSearchButton" onclick = " javascript:searchAjx('agentSearchInterviewAppliedCandidatesAjax', 1);"><i class="fa fa-search"></i>Search</button>
              </div>
           
            </form>
            <div id="agentsearchinterviewappliedcandidatesajax" class="table-responsive clear default-bg">
            <h6><strong>No. of Applied Candidates : <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Skill Set</th>
                    <th>From Time</th>
                    <th>To Time</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                <s:if test="candidateScheduleTimingList!=null && candidateScheduleTimingList.size>0">
	      		<s:iterator var="candidateScheduleTiming" value="candidateScheduleTimingList">
                  <tr>
                  <td><s:property value="candidateScheduleTimingId" /></td>
                  <td><s:property value="candidate.candidateFirstName" /> <s:property value="candidate.candidateLastName" /></td>
                   <td><s:property value="skillSet.primarySkillSet" /></td>
                  <td><s:date name="candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td><s:date name="candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td>
                  	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewinterviewappliedcandidate"  onclick="javascript:callAjx('vInterviewAppliedCandidate',<s:property value="candidateScheduleTimingId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a>
                  	<a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentEditInterviewAppliedCandidates?candidateScheduleTimingId=<s:property value="candidateScheduleTimingId"/>" class="btn btn-success boxed-float-btn"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/edit-btn-img.png" alt="Edit" data-toggle="tooltip" title="Edit" /></a>
                  </td>
                  </tr>
                </s:iterator>
                </s:if>
                <s:else><tr><td colspan="6">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div>  
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="viewinterviewappliedcandidate" role="dialog"></div>
<%@include file="includes/footer.jsp"%>