<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Forgot Password | Secure Verify</title>
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
        <%@include file="includes/alertBoxSuccessError.jsp"%>
        <div class="col-md-4 col-sm-6 block-center">
          <ul class="one-step one clearfix">
            <li class="active">Reset Admin Password</li>
          </ul>
          <div class="white-container">
            <section>
              <div class="row">
               <div class="login-blocks">
                <form id="changeAdminPasswordForm" name="changeAdminPasswordForm" action="changeAdminPassword" method="post" onsubmit="return false;">
                  <div class="row">
                    <div class="col-sm-12">
                      <h6 class="label">Email Address</h6>
                      <input type="text" class="form-control" id="userEmailId" name="userEmailId" placeholder="Email Address" />
                      <h6 class="label">Code Received</h6>
                      <input type="text" class="form-control" id="securitycode" name="securitycode" placeholder="Code Received" />
                      <h6 class="label">New Password</h6>
                      <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="New Password" />
                      <h6 class="label">Confirm New Password</h6>
                      <input type="password" class="form-control" id="retypePassword" name="retypePassword" placeholder="Confirm New Password" />
                      <button type="button" class="btn btn-default btn-large mt10" id="changeAdminPasswordButton" name="changeAdminPasswordButton" >Reset Password</button>
                    </div>
                  </div>
                </form>
              </div>
              </div>
              <div class="clearfix"> </div>
            </section>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>