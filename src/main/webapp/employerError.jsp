<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Properties, com.secureVerify.util.Helper"%>
<% Properties properties = Helper.getPropertiesFromFile(); %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Secure Verify : Error Page</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="icon" href="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/favicon.png">
<link href='<%=properties.getProperty("CONTEXT_PATH").toString() %>css/css_20db3bcc.css' rel='stylesheet' type='text/css' />
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
        	<h1 class="logo-h1">
        		<a href="#"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/logo.png" alt="Secureverify" /></a>
        	</h1>
        </div>
      </div>
      <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#" id="mobile-menu-toggle"><span></span></a> 
      <nav>
        <ul class="primary-nav">
          <li class="active"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerLogout">Logout</a></li>
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
        <div class="col-sm-3 page-sidebar left-navigation-block">
  <aside>
    <div class="inner-left-menu mb0">
      <div class="widget sidebar-widget jobs-filter-widget">
        <h5 class="widget-title clr-red">Employer Menu</h5>
        <div class="widget-content">
          <div>
            <ul class="filter-list">
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates" >Candidates</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAppliedCandidates">Applied Candidates</a></li><!-- employerAppliedCandidates.jsp -->
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerScheduledCandidates">Scheduled Candidates</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerInterviewedCandidates">Interviewed Candidates</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment">Credits Management</a></li>
              <li> <a href="#" >My Account <i class="fa fa-caret-down"></i></a>
                <ul>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerChangePassword">Change Password</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerUpdateProfile">Update Profile</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>updateCompanyInfo">Update Company Info</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerLogout">Logout</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </aside>
</div>
        <div class="col-sm-9">
          <div class="container">
      <div class="row">
        <div class="block-center">
          <div class="white-container no-boxshadow ">
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
          <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#" class="fa fa-pinterest"></a></li>
          <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>#" class="fa fa-dribbble"></a></li>
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

