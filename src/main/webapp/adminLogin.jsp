<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Admin Login | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body>
<div id="main-wrapper" class="admin-login-page">
<%@include file="includes/header.jsp"%>
<div id="page-content">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 block-center">
          <ul class="one-step one clearfix">
            <li class="active">Login to your Account</li>
          </ul>
          <div class="white-container sign-up-form">
            <div>
              <section>
                <div class="row">
                <div class="col-xs-12 col-sm-3">
                <h5 class="clr-blue">Type of Login</h5>
                  <div class="radio-inline">
                    <input type="radio" id="admin" name="loginType" value="1" checked>
                    <label for="admin">Admin</label>
                    <br/>
                    <input type="radio" id="interviewer" name="loginType" value="2">
                    <label for="interviewer">Interviewer</label>
                    <br/>
                    <input type="radio" id="agent" name="loginType" value="3">
                    <label for="agent">Agent</label>
                  </div>
                </div>
                <div class="col-xs-12 col-sm-9 login-blocks">
                <%@include file="includes/alertBoxSuccessError.jsp"%>
                <div class="admin-login">
                  <section class="col-sm-6">
                    <h4 class="bottom-line clr-blue"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/admin-icon.png" alt="Admin" /> Admin Login :</h4>
                    <form id="adminLoginForm" name="adminLoginForm" action="authenticateAdmin" method="post" onsubmit="return false;">
                      <div class="row">
                        <div class="col-sm-12">
                          <h6 class="label">Admin Email</h6>
                          <input type="text" class="form-control" id="userEmailId" name="userEmailId" value="<s:property value="userEmailId" />" placeholder="Admin Email" />
                          <h6 class="label">Password</h6>
                          <input type="password" class="form-control" id="userPassword" name="userPassword" value="<s:property value="userPassword" />" placeholder="Password" />
                          <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>forgotAdminPassword" class="forget-password-link pt10 pb10 clr-red">Forgot Password?</a>
                          <hr class="clear"/>
                          <button type="button" class="btn btn-default btn-large" id="adminLoginButton" name="adminLoginButton"  >Login</button>
                        </div>
                      </div>
                    </form>
                  </section>
                </div>
                <div class="interviewer-login">
                  <section class="col-sm-6">
                    <h4 class="bottom-line clr-blue"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/interviewer-icon.png" alt="Interviewer" /> Interviewer Login :</h4>
                    <form id="interviewerLoginForm" name="interviewerLoginForm" action="authenticateInterviewer" method="post" onsubmit="return false;">
                      <div class="row">
                        <div class="col-sm-12">
                          <h6 class="label">Interviewer Email</h6>
                          <input type="text" class="form-control" id="interviewerEmailId" name="interviewerEmailId" value="<s:property value="interviewerEmailId" />" placeholder="Interviewer Email" />
                          <h6 class="label">Password</h6>
                          <input type="password" class="form-control" id="interviewerPassword" name="interviewerPassword" value="<s:property value="interviewerPassword" />" placeholder="Password" />
                          <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>forgotInterviewerPassword" class="forget-password-link pt10 pb10 clr-red">Forgot Password?</a>
                          <hr class="clear"/>
                          <button type="button" class="btn btn-default btn-large" id="interviewerLoginButton" name="interviewerLoginButton">Login</button>
                        </div>
                      </div>
                    </form>
                  </section>
                </div>
                <div class="agent-login">
                  <section class="col-sm-6">
                    <h4 class="bottom-line clr-blue"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/agent-icon.png" alt="Agent" /> Agent Login :</h4>
                    <form id="agentLoginForm" name="agentLoginForm" action="authenticateAgent" method="post" onsubmit="return false;">
                      <div class="row">
                        <div class="col-sm-12">
                          <h6 class="label">Agent Email</h6>
                          <input type="text" class="form-control" id="agentEmailId" name="agentEmailId" value="<s:property value="agentEmailId" />" placeholder="Agent Email" />
                          <h6 class="label">Password</h6>
                          <input type="password" class="form-control" id="agentPassword" name="agentPassword" value="<s:property value="agentPassword" />" placeholder="Password" />
                          <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>forgotAgentPassword" class="forget-password-link pt10 pb10 clr-red">Forgot Password?</a>
                          <hr class="clear"/>
                          <button type="button" class="btn btn-default btn-large" id="agentLoginButton" name="agentLoginButton">Login</button>
                        </div>
                      </div>
                    </form>
                  </section>
                </div>
                </div>
                </div>
                <div class="clearfix"></div>
              </section>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>