<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Employer Add Candidates | Secure Verify</title>
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
        <%@include file="includes/employerLeftMenu.jsp"%>
        
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container ">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">ADD Candidate</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="employerAddCandidateForm" name="employerAddCandidateForm" action="saveEmployerCandidate" method="post" onsubmit="return false;">
              <h6 class="label">Name</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateFirstName" name="candidateFirstName" value="<s:property value="candidateFirstName" />" placeholder="First Name of Candidate" onkeypress="return keyRestrict(event,'char');"/>
                </div>
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateLastName" name="candidateLastName" value="<s:property value="candidateLastName" />" placeholder="Last Name of Candidate" onkeypress="return keyRestrict(event,'char');"/>
                </div>
              </div>
              <h6 class="label">Email</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateEmailId" name="candidateEmailId" value="<s:property value="candidateEmailId" />" placeholder="Email" onkeypress="return keyRestrict(event,'emailchar');"/>
                </div>
              </div>
              <h6 class="label">Phone Number</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidatePhoneNo" name="candidatePhoneNo" value="<s:property value="candidatePhoneNo" />" placeholder="Mobile" onkeypress="return keyRestrict(event,'phone');" />
                </div>
                <div class="col-sm-2">
                  <input type="text" class="form-control" id="candidatePhoneNoExtension" name="candidatePhoneNoExtension" value="<s:property value="candidatePhoneNoExtension" />" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                </div>
              </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="candidateAlternatePhone" name="candidateAlternatePhone" value="<s:property value="candidateAlternatePhone" />" placeholder="Mobile" onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="candidateAlternatePhoneNoExtension" name="candidateAlternatePhoneNoExtension" value="<s:property value="candidateAlternatePhoneNoExtension" />" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
              <h6 class="label">Primary Skill Set</h6>
              <div class="row">
                <div class="col-sm-4">
                  <select id="fskillSetId" name="fskillSetId">
                    <option value="">Select Skill Set</option>
                    <s:if test="skillSetList!=null && skillSetList.size>0">
	      			<s:iterator var="skillSet" value="skillSetList">
                    <option value="<s:property value="skillSetId" />" <s:if test="fskillSetId.equals(#skillSet.skillSetId)">selected="selected"</s:if> ><s:property value="primarySkillSet" /></option>
                    </s:iterator>
                    </s:if>
                  </select>
                </div>
              </div>
              <hr class="mt10" />
              <div class="clearfix">
                <button type="button" class="btn btn-success btn-large" id="employerAddCandidateButton" name="employerAddCandidateButton" >Submit</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="deletescheduleverification" role="dialog"></div>
<div class="modal fade" id="viewscheduleverification" role="dialog"></div>
<%@include file="includes/footer.jsp"%>