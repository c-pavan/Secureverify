<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Update Profile | Secure Verify</title>
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
        <%@include file="includes/candidateLeftMenu.jsp"%>
        
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Update Profile Details</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="updateCandidateProfileForm" name="updateCandidateProfileForm" action="updateCandidateProfile" method="post" onsubmit="return false;"  enctype="multipart/form-data">
          <h6 class="label">Candidate Id</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                  <input type="text" class="form-control" id="hcandidateId" name="hcandidateId" value="<s:property value="candidate.candidateId" />" disabled />
                  </div>
                  </div>
                <h6 class="label">Name</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="candidateFirstName" name="candidateFirstName" value="<s:property value="candidate.candidateFirstName" />" onkeypress="return keyRestrict(event,'char');"/>
                  </div>
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="candidateLastName" name="candidateLastName" value="<s:property value="candidate.candidateLastName" />"  onkeypress="return keyRestrict(event,'char');"/>
                  </div>
                </div>
                <h6 class="label">Email</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="candidateEmailId" name="candidateEmailId" value="<s:property value="candidate.candidateEmailId" />" disabled />
                  </div>
                </div>
                <h6 class="label">Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="candidatePhoneNo" name="candidatePhoneNo" value="<s:property value="candidate.candidatePhoneNo" />" onkeypress="return keyRestrict(event,'phone');"/>
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="candidatePhoneNoExtension" name="candidatePhoneNoExtension" value="<s:property value="candidate.candidatePhoneNoExtension" />"  onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="candidateAlternatePhone" name="candidateAlternatePhone" value="<s:property value="candidate.candidateAlternatePhone" />"  onkeypress="return keyRestrict(event,'phone');"/>
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="candidateAlternatePhoneNoExtension" name="candidateAlternatePhoneNoExtension" value="<s:property value="candidate.candidateAlternatePhoneNoExtension" />" onkeypress="return keyRestrict(event,'int');"/>
                  </div>
                </div>
                <h6 class="label">View Resume</h6>
                <div class="row">
                <div class="col-sm-12">
                <textarea rows="13"  id="candidateResume" name="candidateResume" disabled><s:property value="candidate.candidateResume" /></textarea>
                </div>
                </div>
                <s:if test="candidate.candidateResume!=null && !candidate.candidateResume.equals('')">
                <div class="row">
                <div class="col-sm-12">
                  <s:url id="candidateResumeDownload" namespace="/" action="downloadCandidateResume" >
                		<s:param name="candidateId" value="candidate.candidateId"/>
                	</s:url>
                  	<s:a href="%{candidateResumeDownload}"  cssClass="btn btn-success mt10">Download Resume of <s:property value="candidate.candidateFirstName" /> <i class="fa fa-download"></i></s:a>
                </div>
                </div>
              	</s:if>
                <h6 class="label">Update Resume</h6>
                 <div class="row">
                <div class="col-sm-4 pr0">
                    <input type="file" class="form-control" id="resume" name="resume" >
                  </div>
                  </div>
                <h6 class="label">Address</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="candidateAddressLine1" name="candidateAddressLine1" value="<s:property value="candidate.candidateAddressLine1" />" />
                  </div>
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="candidateAddressLine2" name="candidateAddressLine2" value="<s:property value="candidate.candidateAddressLine2" />" />
                  </div>
                </div>
                <div class="row pt15">
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="candidateCity" name="candidateCity" value="<s:property value="candidate.candidateCity" />" />
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="candidateState" name="candidateState" value="<s:property value="candidate.candidateState" />" />
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="candidateCountry" name="candidateCountry" value="<s:property value="candidate.candidateCountry" />" />
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="candidateZipcode" name="candidateZipcode" value="<s:property value="candidate.candidateZipcode" />" />
                  </div>
                </div>
                <h6 class="label">Preffed Location</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="candidatePrefferedLocation" name="candidatePrefferedLocation" value="<s:property value="candidate.candidatePrefferedLocation" />"/>
                  </div>
                  </div>
                  <h6 class="label">Expected Salary</h6>
                   <div class="row">
                  <div class="col-sm-4 pr0">
                  <select id="candidateExpectedSalary" name="candidateExpectedSalary">
                    	<option value="">Preferred Salary</option>
                    	<option value="No Preference" <s:if test="candidate.candidateExpectedSalary.equals('No Preference')">selected="selected"</s:if> >No Preference</option>
                    	<option value="below 25000" <s:if test="candidate.candidateExpectedSalary.equals('below 25000')">selected="selected"</s:if> >below 25000</option>
                    	<option value="25000 to 50000" <s:if test="candidate.candidateExpectedSalary.equals('25000 to 50000')">selected="selected"</s:if> >25000 to 50000</option>
                    	<option value="50000 to 75000" <s:if test="candidate.candidateExpectedSalary.equals('50000 to 75000')">selected="selected"</s:if> >50000 to 75000</option>
                    	<option value="75000 to 100000" <s:if test="candidate.candidateExpectedSalary.equals('75000 to 100000')">selected="selected"</s:if> >75000 to 100000</option>
                    	<option value="100000 to 1250000" <s:if test="candidate.candidateExpectedSalary.equals('100000 to 1250000')">selected="selected"</s:if> >100000 to 1250000</option>
                    	<option value="above 125000" <s:if test="candidate.candidateExpectedSalary.equals('above 125000')">selected="selected"</s:if> >above 125000</option>
                    </select>
                  </div>
                </div>
             <div class="clearfix"> 
            <hr class="mt10" />
            <button type="button" class="btn btn-success btn-large" id="candidateUpdateProfileButton" name="candidateUpdateProfileButton" >Update Profile</button>
            </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>