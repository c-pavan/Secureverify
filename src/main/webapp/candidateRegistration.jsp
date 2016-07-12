<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Candidate Register | Secure Verify</title>
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
        
        <div class="col-md-6 col-sm-9 block-center">
          <ul class="one-step one clearfix">
            <li class="active">Candidate Registration</li>
          </ul>
          <div class="white-container ">
          <%@include file="includes/alertBoxSuccessError.jsp"%>
            <div>
              <section>
                <form id="candidateRegistrationForm" name="candidateRegistrationForm" action="saveCandidateRegistration" method="post" onsubmit="return false;"  enctype="multipart/form-data">
                <div class="row">
                  <div class="col-sm-6">
                  <h6 class="label">First Name</h6>
                    <input type="text" class="form-control" id="candidateFirstName" name="candidateFirstName" value="<s:property value="candidateFirstName" />" placeholder="First Name" />
                  </div>
                  <div class="col-sm-6">
                  <h6 class="label">Last Name</h6>
                    <input type="text" class="form-control" id="candidateLastName" name="candidateLastName" value="<s:property value="candidateLastName" />" placeholder="Last Name" />
                  </div>
                </div>
                <h6 class="label">Email ID</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateEmailId" name="candidateEmailId" value="<s:property value="candidateEmailId" />" placeholder="Email" />
                  </div>
                </div>
                <h6 class="label">Phone Number</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidatePhoneNo" name="candidatePhoneNo" value="<s:property value="candidatePhoneNo" />" placeholder="Mobile"  onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="candidatePhoneNoExtension" name="candidatePhoneNoExtension" value="<s:property value="candidatePhoneNoExtension" />" placeholder="Ext"  onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateAlternatePhone" name="candidateAlternatePhone" value="<s:property value="candidateAlternatePhone" />" placeholder="Mobile"  onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="candidateAlternatePhoneNoExtension" name="candidateAlternatePhoneNoExtension" value="<s:property value="candidateAlternatePhoneNoExtension" />" placeholder="Ext"  onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-6">
                <h6 class="label">Password</h6>
                    <input type="password" class="form-control" id="candidatePassword" name="candidatePassword" value="<s:property value="candidatePassword" />" placeholder="Password" />
                  </div>
                  <div class="col-sm-6">
                <h6 class="label">Verify Password</h6>
                    <input type="password" class="form-control" id="verifyPassword" name="verifyPassword" value="<s:property value="verifyPassword" />" placeholder="Verify Password" />
                  </div>
                </div>
                	<h6 class="label">Skill Set</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <select id=fskillSetId name="fskillSetId">
                      <option value="">Select</option>
                      <s:if test="skillSetList!=null && skillSetList.size>0">
	      				<s:iterator var="skillSet" value="skillSetList">
                      		<option value="<s:property value="#skillSet.skillSetId" />" <s:if test="fskillSetId.equals(#skillSet.skillSetId)">selected="selected"</s:if> ><s:property value="#skillSet.primarySkillSet" /></option>
                      	</s:iterator>
                      </s:if>
                    </select>
                  </div>
                </div>
                <h6 class="label">Upload Resume</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="file" class="form-control" id="resume" name="resume" value="<s:property value="resume" />"  />
                  </div>
                </div>
                <h6 class="label">Address</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateAddressLine1" name="candidateAddressLine1" value="<s:property value="candidateAddressLine1" />" placeholder="Address Line 1"  />
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateAddressLine2" name="candidateAddressLine2" value="<s:property value="candidateAddressLine2" />" placeholder="Address Line 2"  />
                  </div>
                </div>
                <div class="row pt15">
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="candidateCity" name="candidateCity" value="<s:property value="candidateCity" />" placeholder="City"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="candidateState" name="candidateState" value="<s:property value="candidateState" />" placeholder="State"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="candidateCountry" name="candidateCountry" value="<s:property value="candidateCountry" />" placeholder="Country"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="candidateZipcode" name="candidateZipcode" value="<s:property value="candidateZipcode" />" placeholder="Zip"  />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-6">
                <h6 class="label">Preferred Location</h6>
                    <input type="text" class="form-control" id="candidatePrefferedLocation" name="candidatePrefferedLocation" value="<s:property value="candidatePrefferedLocation" />" placeholder="Location"  />
                  </div>
                  <div class="col-sm-6">
                <h6 class="label" >Expected Salary</h6>
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
            <button type="button" class="btn btn-default btn-large mt10" id="candidateRegistrationFormButton" name="candidateRegistrationFormButton" >Register</button>
            
            </form>
              </section>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>