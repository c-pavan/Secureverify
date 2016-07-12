<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Employer Candidates | Secure Verify</title>
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
          <div class="green-bg">
            <div class="col-xs-12 green-bg-padding">
              <div class="bottom-admin-line">
                <div class="col-sm-9 no-padding">
                  <h5 class="m0 clr-white">Candidates</h5>
                </div>
                <div class="col-sm-3 p0 text-right mt5 mtnegative25 add-button-left">
                  <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAddCandidate" class="btn btn-danger"> Add Candidate </a>
                </div>
              </div>
            </div>
            <div class="clear"></div>
            <form id=""  class="green-bg-padding" name="" action="#" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Candidate Name" id="candidateName" name="candidateName" onkeypress="return keyRestrict(event,'char');"/>
              </div>
              <div class="col-sm-2 search-padding">
               <select id="skillSetId" name="skillSetId">
                      <s:if test="skillSetList!=null && skillSetList.size>0">
                  		<option value="" >Select Skill Set</option>
	      		 	  <s:iterator var="skillSet" value="skillSetList">
                      	<option value="<s:property value="skillSetId"/>" ><s:property value="primarySkillSet"/></option>
                      </s:iterator>
                      </s:if>
               </select>
              </div>
                 
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Phone no" id="phoneNo" name="phoneNo" onkeypress="return keyRestrict(event,'phone');"/>
              </div>
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Email Id" id="emailId" name="emailId" onkeypress="return keyRestrict(event,'emailchar');"/>
              </div>
              <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" id="" name="employerCandidatesSearchButton" onclick = "javascript:searchAjx('employerSearchCandidatesAjax', 1);"><i class="fa fa-search"></i>Search</button>
              </div>
        </form>
            <div id="employercandidatesajax" class="table-responsive clear default-bg">
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone No</th>
                    <th>SkillSet</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                <s:if test="candidateEmployerSkillSetMapList!=null && candidateEmployerSkillSetMapList.size>0">
	      		<s:iterator var="candidateEmployerSkillSetMap" value="candidateEmployerSkillSetMapList">
                  <tr>
                    <td><s:property value="candidateId"/></td>
                    <td><s:property value="candidate.candidateFirstName"/> <s:property value="candidate.candidateLastName"/></td>
                    <td><s:property value="candidate.candidateEmailId"/></td>
                    <td><s:property value="candidate.candidatePhoneNo"/></td>
                    <td><s:property value="skillSet.primarySkillSet"/></td>
                    <td>
                    <a href="#" class="btn btn-success" data-toggle="modal" data-target="#viewEmployerCandidate" onclick="javascript:callAjx('eViewCandidate',<s:property value="candidateEmployerSkillSetMapId" />);" ><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a><!-- eViewCandidate.jsp -->
                    <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>editEmployerCandidate?candidateEmployerSkillSetMapId=<s:property value="candidateEmployerSkillSetMapId" />" class="btn btn-success boxed-float-btn"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/edit-btn-img.png" alt="Edit" data-toggle="tooltip" title="Edit" /></a><!-- employerEditCandidate.jsp--></td>
                  </tr>
                </s:iterator>
                </s:if>
                <s:else><tr><td colspan="6">No Data To Display. Please Add Candidates</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates?pageNo=<s:property value="(pageNo+1)" />">Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="viewEmployerCandidate" role="dialog"></div>
<%@include file="includes/footer.jsp"%>