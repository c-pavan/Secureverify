<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Agent Update Password | Secure Verify</title>
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
       <%@include file="includes/adminLeftMenu.jsp"%>
      	<!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Update Password</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="updateAgentPasswordForm" name="updateAgentPasswordForm" action="agentUpdatePassword" method="post" onsubmit="return false;">
              <div class="row">
                <div class="col-sm-4">
                  <h6 class="label">Current Password</h6>
                  <input type="password" class="form-control" id="currentPassword" name="currentPassword" value="" placeholder="Current Password" />
                  <h6 class="label">New Password</h6>
                  <input type="password" class="form-control" id="agentPassword" name="agentPassword" value="" placeholder="New Password" />
                  <h6 class="label">Re Enter New Password</h6>
                  <input type="password" class="form-control" id="retypePassword" name="retypePassword" value="" placeholder="Re Enter New Password" />
                  <button type="button" class="btn btn-success btn-large mt10" id="agentUpdatePasswordButton" name="agentUpdatePasswordButton" >Change Password &nbsp;<i class="fa fa-caret-right"></i></button></div>
                </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>