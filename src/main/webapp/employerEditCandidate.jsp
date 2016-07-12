<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Employer Edit Candidate| Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body  class="form-block-page">
<div id="main-wrapper">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
        <%@include file="includes/employerLeftMenu.jsp"%>
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container ">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Edit Candidate</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="employerEditCandidateForm" name="employerEditCandidateForm" action="updateEmployerCandidate" method="post" onsubmit="return false;">
          
          <input type="hidden" id="candidateEmployerSkillSetMapId" name="candidateEmployerSkillSetMapId" value="<s:property value="candidateEmployerSkillSetMap.candidateId" />" />
           <h6 class="label">Candidate Id</h6>
                <div class="row">
               <div class="col-sm-4">
                    <input type="text" class="form-control" id="hcandidateId" name="hcandidateId" value="<s:property value="candidate.candidateId" />" disabled />
                    <input type="hidden" id="candidateId" name="candidateId" value="<s:property value="candidate.candidateId" />" />
                  </div>
             </div>
              <h6 class="label">Name</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateFirstName" name="candidateFirstName" value="<s:property value="candidate.candidateFirstName" />" placeholder="First Name of Candidate" />
                </div>
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateLastName" name="candidateLastName" value="<s:property value="candidate.candidateLastName" />" placeholder="Last Name of Candidate" />
                </div>
              </div>
              <h6 class="label">Email</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateEmailId" name="candidateEmailId" value="<s:property value="candidate.candidateEmailId" />" placeholder="Email" disabled/>
                </div>
              </div>
              <h6 class="label">Phone Number</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidatePhoneNo" name="candidatePhoneNo" value="<s:property value="candidate.candidatePhoneNo" />" placeholder="Mobile" onkeypress="return keyRestrict(event,'phone');" />
                </div>
                <div class="col-sm-2">
                  <input type="text" class="form-control" id="candidatePhoneNoExtension" name="candidatePhoneNoExtension" value="<s:property value="candidate.candidatePhoneNoExtension" />" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                </div>
              </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="candidateAlternatePhone" name="candidateAlternatePhone" value="<s:property value="candidate.candidateAlternatePhone" />" placeholder="Mobile" onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="candidateAlternatePhoneNoExtension" name="candidateAlternatePhoneNoExtension"  value="<s:property value="candidate.candidateAlternatePhoneNoExtension" />" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
              <h6 class="label">Primary Skill Set</h6>
              <div class="row">
                <div class="col-sm-4">
                  <select id="skillSetId" name="skillSetId">
                    <s:if test="skillSetList!=null && skillSetList.size>0">
	      			<s:iterator var="skillSet" value="skillSetList">
	      				<s:if test="candidate.skillSetId==skillSetId" >
                    	<option value="<s:property value="skillSetId" />" selected="selected"  ><s:property value="primarySkillSet" /></option>
                    	</s:if>
                    </s:iterator>
                    </s:if>
                  </select>
                </div>
              </div>
              <hr class="mt10" />
              <div class="clearfix">
                <button type="button" class="btn btn-success btn-large" id="employerEditCandidateButton" name="employerEditCandidateButton" >Update</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>