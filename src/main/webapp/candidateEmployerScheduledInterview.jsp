<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Employer Scheduled Interview | Secure Verify</title>
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
                  <h5 class="m0 clr-white">Employer Scheduled Interview</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="" class="green-bg-padding"  name="" action="#" method="post" onsubmit="return false;">
          <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="employerName" name="employerName" placeholder="Employer Name" onkeypress="return keyRestrict(event,'char');">
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="employerTitle" name="employerTitle" placeholder="Employer Title">
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="employerCompanyName" name="employerCompanyName" placeholder="Company Name">
              </div>
               <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" id="" name="candidateEmployerScheduledInterviewSearchButton" onclick = "javascript:searchAjx('candidateSearchEmployerScheduledInterviewAjax',1);">Search</button>
              </div>
            </form>
            <div id="candidatesearchemployerscheduledinterviewajax" class="table-responsive clear default-bg">
            <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>Employer Name</th>
                    <th>Employer Title</th>
                    <th>Employer Company Name</th>
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
                  <td><s:property value="employer.employerFirstName"/><s:property value="employer.employerLastName" /></td>
                  <td><s:property value="employer.employerTitle"/></td>
                  <td><s:property value="employer.employerCompanyName"/></td>
                  <td><s:property value="skillSet.primarySkillSet" /></td>
                  <td><s:date name="candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td><s:date name="candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></td>
                  <td>
                 <a href="#" class="btn btn-success" data-toggle="modal" data-target="#viewEmployerScheduledInterview"  onclick="javascript:callAjx('cViewEmployerScheduledInterview',<s:property value="candidateScheduleTimingId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a><!-- cViewEmployerScheduledInterview.jsp -->
                  </tr>
                </s:iterator>
                </s:if>
                <s:else><tr><td colspan="5">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
   <div class="modal fade" id="viewEmployerScheduledInterview" role="dialog"></div>
<%@include file="includes/footer.jsp"%>