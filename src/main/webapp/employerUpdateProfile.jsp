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
        <%@include file="includes/employerLeftMenu.jsp"%>
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container ">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Update Profile</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
            <form id="employerUpdateProfileForm" name="employerUpdateProfileForm" action="updateEmployerProfile" method="post" onsubmit="return false;">
              <h6 class="label">Name</h6>
              <div class="row">
                <div class="col-sm-3">
                  <input type="text" class="form-control" id="employerFirstName" name="employerFirstName" value="<s:property value="employer.employerFirstName" />" placeholder="First Name" onkeypress="return keyRestrict(event,'char');" />
                </div>
                <div class="col-sm-3">
                  <input type="text" class="form-control" id="employerLastName" name="employerLastName" value="<s:property value="employer.employerLastName" />" placeholder="Last Name" onkeypress="return keyRestrict(event,'char');"/>
                </div>
              </div>
              <h6 class="label">Email</h6>
              <div class="row">
                <div class="col-sm-3">
                  <input type="text" class="form-control" id="employerEmailId" name="employerEmailId" value="<s:property value="employer.employerEmailId" />" placeholder="Email" onkeypress="return keyRestrict(event,'emailchar');"/>
                </div>
              </div>
              <h6 class="label">Phone Number</h6>
              <div class="row">
                <div class="col-sm-3">
                  <input type="text" class="form-control" id="employerPhoneNo" name="employerPhoneNo" value="<s:property value="employer.employerPhoneNo" />" placeholder="Phone Number" onkeypress="return keyRestrict(event,'phone');" />
                </div>
                <div class="col-sm-2">
                  <input type="text" class="form-control" id="employerPhoneNoExtension" name="employerPhoneNoExtension" value="<s:property value="employer.employerPhoneNoExtension" />" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                </div>
              </div>
              <h6 class="label">Alternate Phone Number</h6>
              <div class="row">
                <div class="col-sm-3">
                  <input type="text" class="form-control" id="employerAlternatePhone" name="employerAlternatePhone" value="<s:property value="employer.employerAlternatePhone" />" placeholder="Alternate Phone Number" onkeypress="return keyRestrict(event,'phone');" />
                </div>
                <div class="col-sm-2">
                  <input type="text" class="form-control" id="employerAlternatePhoneNoExtension" name="employerAlternatePhoneNoExtension" value="<s:property value="employer.employerAlternatePhoneNoExtension" />" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                </div>
              </div>
             <div class="clearfix">
                <button type="button" class="btn btn-success btn-large pull-left mt20" id="employerUpdateProfileButton" name="employerUpdateProfileButton" >Update Profile</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>        
<%@include file="includes/footer.jsp"%>