<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Employer Register | Secure Verify</title>
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
        
        <div class="col-sm-6 col-md-8  block-center">
          <ul class="one-step one clearfix">
            <li class="active">Employer Registration</li>
          </ul>
          <div class="white-container ">
          <%@include file="includes/alertBoxSuccessError.jsp"%>
            <div>
              <section>
                <form id="employerRegistrationForm" name="employerRegistrationForm" action="saveEmployerRegistration" method="post" onsubmit="return false;"  enctype="multipart/form-data">
                
                <div class="row">
                  <div class="col-sm-6">
                  <h6 class="label">First Name</h6>
                    <input type="text" class="form-control" id="employerFirstName" name="employerFirstName" value="<s:property value="employerFirstName" />" placeholder="First Name" onkeypress="return keyRestrict(event,'char');"/>
                  </div>
                  <div class="col-sm-6">
                  <h6 class="label">Last Name</h6>
                    <input type="text" class="form-control" id="employerLastName" name="employerLastName" value="<s:property value="employerLastName" />" placeholder="Last Name" onkeypress="return keyRestrict(event,'char');"/>
                  </div>
                </div>
                <h6 class="label">Email ID</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerEmailId" name="employerEmailId" value="<s:property value="employerEmailId" />" placeholder="Email" onkeypress="return keyRestrict(event,'emailchar');"/>
                  </div>
                </div>
                <h6 class="label">Phone Number</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerPhoneNo" name="employerPhoneNo" value="<s:property value="employerPhoneNo" />" placeholder="Mobile"  onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="employerPhoneNoExtension" name="employerPhoneNoExtension" value="<s:property value="employerPhoneNoExtension" />" placeholder="Ext"  onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerAlternatePhone" name="employerAlternatePhone" value="<s:property value="employerAlternatePhone" />" placeholder="Mobile"  onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="employerAlternatePhoneNoExtension" name="employerAlternatePhoneNoExtension" value="<s:property value="employerAlternatePhoneNoExtension" />" placeholder="Ext"  onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-6">
                <h6 class="label">Password</h6>
                    <input type="password" class="form-control" id="employerPassword" name="employerPassword" value="<s:property value="employerPassword" />" placeholder="Password" />
                  </div>
                  <div class="col-sm-6">
                <h6 class="label">Verify Password</h6>
                    <input type="password" class="form-control" id="verifyPassword" name="verifyPassword" value="<s:property value="verifyPassword" />" placeholder="Verify Password" />
                  </div>
                </div>
                	<h6 class="label">Company Name</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerCompanyName" name="employerCompanyName" value="<s:property value="employerCompanyName" />" placeholder="Company Name" />
                  </div>
                </div>
                <h6 class="label">Title</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerTitle" name="employerTitle" value="<s:property value="employerTitle" />" placeholder="Title" />
                  </div>
                </div>
                <h6 class="label">Address</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerAddressLine1" name="employerAddressLine1" value="<s:property value="employerAddressLine1" />" placeholder="Address Line 1"  />
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerAddressLine2" name="employerAddressLine2" value="<s:property value="employerAddressLine2" />" placeholder="Address Line 2"  />
                  </div>
                </div>
                <div class="row pt15">
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="employerCity" name="employerCity" value="<s:property value="employerCity" />" placeholder="City"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="employerState" name="employerState" value="<s:property value="employerState" />" placeholder="State"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="employerCountry" name="employerCountry" value="<s:property value="employerCountry" />" placeholder="Country"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="employerZipcode" name="employerZipcode" value="<s:property value="employerZipcode" />" placeholder="Zip"  />
                  </div>
                </div>         
            <button type="button" class="btn btn-default btn-large mt10" id="employerRegistrationFormButton" name="employerRegistrationFormButton" >Register</button>
            
            </form>
              </section>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>