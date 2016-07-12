<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Register Candidate | Secure Verify</title>
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
        <div class="col-sm-12 page-content">
       
          <ul class="one-step one clearfix">
            <li class="active">Candidate Register</li>
          </ul>
          <div class="white-container ">
           <%@include file="includes/alertBoxSuccessError.jsp"%>
            <div>
              <section>
                <form id="candidateRegisterForm" name="candidateRegisterForm" action="saveCandidateRegister" method="post" onsubmit="return false;"  enctype="multipart/form-data">
                
                <input type="hidden" id="candidateId" name="candidateId" value="<s:property value="candidate.candidateId" />" />
                <input type="hidden" id="candidateEmailId" name="candidateEmailId" value="<s:property value="candidate.candidateEmailId" />" />
                <h6 class="label">Name</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateFirstName" name="candidateFirstName" value="<s:property value="candidate.candidateFirstName" />" placeholder="First Name" />
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateLastName" name="candidateLastName" value="<s:property value="candidate.candidateLastName" />" placeholder="Last Name" />
                  </div>
                </div>
                <h6 class="label">Email</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="hcandidateEmailId" name="hcandidateEmailId" value="<s:property value="candidate.candidateEmailId" />" placeholder="Email" disabled />
                  </div>
                </div>
                <h6 class="label">Phone Number</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidatePhoneNo" name="candidatePhoneNo" value="<s:property value="candidate.candidatePhoneNo" />" placeholder="Mobile"  onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="candidatePhoneNoExtension" name="candidatePhoneNoExtension" value="<s:property value="candidate.candidatePhoneNoExtension" />" placeholder="Ext"  onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateAlternatePhone" name="candidateAlternatePhone" value="<s:property value="candidate.candidateAlternatePhone" />" placeholder="Mobile"  onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="candidateAlternatePhoneNoExtension" name="candidateAlternatePhoneNoExtension" value="<s:property value="candidate.candidateAlternatePhoneNoExtension" />" placeholder="Ext"  onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-6">
                <h6 class="label">Password</h6>
                    <input type="password" class="form-control" id="candidatePassword" name="candidatePassword" value="<s:property value="candidate.candidatePassword" />" placeholder="Password" />
                  </div>
                  <div class="col-sm-6">
                <h6 class="label">Verify Password</h6>
                    <input type="password" class="form-control" id="verifyPassword" name="verifyPassword" value="<s:property value="candidate.verifyPassword" />" placeholder="Verify Password" />
                  </div>
                </div>
                <h4 class="clr-darkblue">Step 2 :</h4>
                <div class="row">
                  <div class="col-sm-6">
                	<h6 class="label">Skill Set</h6>
                    <select id="skillSetId" name="skillSetId">
                      <s:if test="skillSetList!=null && skillSetList.size>0">
                      		<option value="" >Select Skill Set</option>
	      				<s:iterator var="skillSet" value="skillSetList">
                      		<option value="<s:property value="skillSetId" />" ><s:property value="primarySkillSet" /></option>
                      	</s:iterator>
                      </s:if>
                    </select>
                  </div>
                  <div class="col-sm-6">
                <h6 class="label">Upload Resume</h6>
                    <input type="file" class="form-control" id="resume" name="resume"  />
                  </div>
                </div>
                <h6 class="label">Address</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateAddressLine1" name="candidateAddressLine1" value="<s:property value="candidate.candidateAddressLine1" />" placeholder="Address Line 1"  />
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateAddressLine2" name="candidateAddressLine2" value="<s:property value="candidate.candidateAddressLine2" />" placeholder="Address Line 2"  />
                  </div>
                </div>
                <div class="row pt15">
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="candidateCity" name="candidateCity" value="<s:property value="candidate.candidateCity" />" placeholder="City"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="candidateState" name="candidateState" value="<s:property value="candidate.candidateState" />" placeholder="State"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="candidateCountry" name="candidateCountry" value="<s:property value="candidate.candidateCountry" />" placeholder="Country"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="candidateZipcode" name="candidateZipcode" value="<s:property value="candidate.candidateZipcode" />" placeholder="Zip"  />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-6">
                <h6 class="label">Preffed Location</h6>
                    <input type="text" class="form-control" id="candidatePrefferedLocation" name="candidatePrefferedLocation" value="<s:property value="candidate.candidatePrefferedLocation" />" placeholder="Location"  />
                  </div>
                  <div class="col-sm-6">
                <h6 class="label">Expected Salary</h6>
                	<select id="candidateExpectedSalary" name="candidateExpectedSalary">
                    	<option value="">Preferred Salary</option>
                    	<option value="No Preference" <s:if test="candidateExpectedSalary.equals('No Preference')">selected="selected"</s:if> >No Preference</option>
                    	<option value="below 25000" <s:if test="candidateExpectedSalary.equals('below 25000')">selected="selected"</s:if> >below 25000</option>
                    	<option value="25000 to 50000" <s:if test="candidateExpectedSalary.equals('25000 to 50000')">selected="selected"</s:if> >25000 to 50000</option>
                    	<option value="50000 to 75000" <s:if test="candidateExpectedSalary.equals('50000 to 75000')">selected="selected"</s:if> >50000 to 75000</option>
                    	<option value="75000 to 100000" <s:if test="candidateExpectedSalary.equals('75000 to 100000')">selected="selected"</s:if> >75000 to 100000</option>
                    	<option value="100000 to 1250000" <s:if test="candidateExpectedSalary.equals('100000 to 1250000')">selected="selected"</s:if> >100000 to 1250000</option>
                    	<option value="above 125000" <s:if test="candidateExpectedSalary.equals('above 125000')">selected="selected"</s:if> >above 125000</option>
                    </select>
                  </div>
                </div>
            <hr class="mt20" />
            <button type="button" class="btn btn-default btn-large" id="candidateRegisterFormButton" name="candidateRegisterFormButton" >Register</button>
                
                              
            </form>
              </section>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>