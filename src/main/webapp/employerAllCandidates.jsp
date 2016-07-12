<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Manage Candidates | Secure Verify</title>
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
        <%@include file="includes/employerLeftMenu.jsp"%>
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="green-bg ">
            <div class="col-xs-12 green-bg-padding">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white">All Candidates</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
            <form id="" class="green-bg-padding"  name="" action="#" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Candidate Name" id="" name=""/>
              </div>
              <div class="col-sm-2 search-padding">
                    <select name="candidateSkillSet" id="candidateSkillSet" >
                    	<option value="">Primary Skill</option>
                    	<option value="">Primary Skill 1</option>
                    	<option value="">Primary Skill 2</option>
                    	<option value="">Primary Skill 3</option>
                    	<option value="">Primary Skill 4</option>
                    	<option value="">Primary Skill 5</option>
                    </select>
              </div>
                 <div class="col-sm-2 search-padding">
                    <select id="candidatePerformance" name="candidatePerformance">
                      <option value="">Performance</option>
                      <option value="1">Best</option>
                      <option value="2">Good</option>
                      <option value="3">Average</option>
                      <option value="4">Not Qualified</option>
                    </select>
                 </div>
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Interviewer Name" id="" name=""/>
              </div>
              <div class="col-sm-1 search-padding">
                    <input type="text" class="datetimepicker form-control" placeholder="Time From" id="scheduleFromTime" name="scheduleFromTime"/>
              </div>
              <div class="col-sm-1 search-padding">
                    <input type="text" class="datetimepicker form-control" placeholder="Time To" id="scheduleToTime" name="scheduleToTime"/>
              </div>
              <div class="col-sm-2 search-padding">
                <button type="submit" class="btn btn-default height40 black-search-button" id="" name=""><i class="fa fa-search"></i>Search</button>
              </div>
            </form>
            <div id="employerinterviewedcandidatesajax" class="table-responsive clear default-bg">
            <h6><strong>No. of Interviewed Candidates : <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Skill Set</th>
                    <th>Location</th>
                    <th>From Time</th>
                    <th>To Time</th>
                    <th>Status</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                  <td><s:property value="candidateId" /></td>
                  <td><s:property value="candidate.candidateFirstName" /> <s:property value="candidate.candidateLastName" /></td>
                  <td><s:property value="skillSet.primarySkillSet" /></td>
                  <td><s:property value="location.locationName" /></td>
                  <td><s:date name="candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td><s:date name="candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td>Applied</td>
                  <td><a href="#" class="btn btn-success" data-toggle="modal" data-target="#viewEmployerAllCandidates" onclick="javascript:callAjx('eViewAllCandidates',<s:property value="candidateScheduleTimingId" />);" ><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="view" data-toggle="tooltip"  title="view" /></a><!-- eViewAllCandidates.jsp -->
                  </tr>
                
                
                <%-- <s:if test="candidateScheduleTimingList!=null && candidateScheduleTimingList.size>0">
	      		  <s:iterator var="candidateScheduleTiming" value="candidateScheduleTimingList">
                  <tr>
                  <td><s:property value="candidateId" /></td>
                  <td><s:property value="candidate.candidateFirstName" /> <s:property value="candidate.candidateLastName" /></td>
                  <td><s:property value="skillSet.primarySkillSet" /></td>
                  <td><s:property value="location.locationName" /></td>
                  <td><s:date name="candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td><s:date name="candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td>Applied</td>
                  <td><button type="button" class="btn btn-success" data-toggle="modal" data-target="#viewEmployerAllCandidates" onclick="javascript:callAjx('eViewAllCandidates',<s:property value="candidateScheduleTimingId" />);" ><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="view" title="view" /></button><!-- eViewAllCandidates.jsp -->
                  </tr>
                  </s:iterator>
                </s:if>
                <s:else><tr><td colspan="9">No Data to Display</td></tr></s:else> --%>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#">Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="modal fade" id="viewEmployerAllCandidates" role="dialog"></div>
<%@include file="includes/footer.jsp"%>