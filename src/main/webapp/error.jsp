<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Properties, com.secureVerify.util.Helper"%>
<% Properties properties = Helper.getPropertiesFromFile(); %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Secure Verify : Error Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="icon" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/favicon.png">
<link rel="stylesheet" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>css/bootstrap.css">
<link rel="stylesheet" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div id="main-wrapper">
<header id="header" class="header-style-1">
  <div class="header-nav-bar">
    <div class="container"> 
      <div class="css-table logo">
        <div class="css-table-cell"> 
        	<h1 class="logo-h1"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>home"> <img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/logo.png" alt="Secureverify" /> </a></h1>
        </div>
      </div>
      <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#" id="mobile-menu-toggle"><span></span></a> 
      <nav>
        <ul class="primary-nav">
          <li> <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>home">Home</a></li>
          <li class="has-submenu"> 
          	<a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#">For Employers</a>
          	<ul>
                <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerLogin">Login</a></li>
                <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerRegistration">Register</a></li>
                <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerFaq">FAQ</a></li>
            </ul>
          </li>
          <li class="has-submenu"> 
          	<a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#">For Candidates</a>
          	<ul>
                <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateLogin">Login</a></li>
                <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateRegistration">Register</a></li>
                <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateFaq">FAQ</a></li>
            </ul>
          </li>
          <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>whySecureVerify">Why SecureVerify</a></li>
          <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>contactus">Contact</a></li>
        </ul>
      </nav>
    </div>
    <div id="mobile-menu-container" class="container">
      <div class="login-register"></div>
      <div class="menu"></div>
    </div>
  </div>
  
</header>
<div id="page-content">
    <div class="container">
      <div class="row">
        <div class="col-sm-9 block-center">
          <div class=" ">
            <div class="col-xs-12 p0">
              <div class="">
                <div class="col-sm-12 no-padding text-center">
                  <h2 class="mt50 clr-darkblue">ERROR 404</h2>
                  <h4 class="mt20 mb50 notexttransform">This page you are looking for does not available. <br/><br/>Please check again.</h4>
                </div>
              </div>
            </div>
            <div class="clear"></div>            
          </div>
        </div>
      </div>
    </div>
  </div>
  <footer id="footer">
    <div class="copyright">
      <div class="container">
        <p>&copy; Copyright 2016 SecureVerify | All Rights Reserved</p>
        <ul class="footer-social">
          <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#" class="fa fa-facebook"></a></li>
          <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#" class="fa fa-twitter"></a></li>
          <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#" class="fa fa-linkedin"></a></li>
          <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#" class="fa fa-google-plus"></a></li>
        </ul>
      </div>
    </div>
  </footer>  
</div>
<script src="<%=properties.getProperty("CONTEXT_PATH").toString() %>js/jquery-1.11.0.min.js"></script> 
<script src="<%=properties.getProperty("CONTEXT_PATH").toString() %>js/bootstrap.js"></script> 
<script src="<%=properties.getProperty("CONTEXT_PATH").toString() %>js/script.js"></script>
</body>
</html>

