<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Login | Secure Verify</title>
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
        
      <div class="col-md-4 col-sm-6  block-center">
        <ul class="one-step one clearfix">
          <li class="active">Candidate Login</li>
        </ul>
        <div class="white-container ">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div>
            <section>
               <div class="login-blocks">
                  <%-- <h4 class="bottom-line clr-blue"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/candidate-icon.png" alt="Candidate" /> Candidate Login :</h4> --%>
                  <form id="candidateLoginForm" name="candidateLoginForm" action="authenticateCandidate" method="post" onsubmit="return false;">
                    <div class="row">
                      <div class="col-sm-12">
                        <h6 class="label">Candidate Email</h6>
                        <input type="text" class="form-control" id="candidateEmailId" name="candidateEmailId" value="<s:property value="candidateEmailId" />" placeholder="Candidate Email" />
                        <h6 class="label">Password</h6>
                        <input type="password" class="form-control" id="candidatePassword" name="candidatePassword" value="<s:property value="candidatePassword" />" placeholder="Password" />
                        <button type="button" class="btn btn-default btn-large mt5 pull-left" id="candidateLoginButton" name="candidateLoginButton" >Login</button>
                        <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>forgotCandidatePassword" class="forget-password-link pt10 pb10 clr-red">Forgot Password?</a>
                        <div class="clear "></div>
                        <hr class="mt5 mb10"/>
                        <p class="mt10">Not a member Yet? <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateRegistration" class=" clr-green"><strong>Register Now</strong></a></p>
                      </div>
                    </div>
                  </form>
              </div>
              <div class="clearfix"> </div>
            </section>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<%@include file="includes/footer.jsp"%>
