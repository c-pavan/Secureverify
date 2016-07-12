<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Secure Verify</title>
<meta name="description" content="Secure Verify is a technology screening and testing agency with presence all across of USA, Canada and India. Secure Verify will help you identify the best resource, screen them and present them to you in a efficient and timely manner" />
<meta name="keywords" content="Secure Verify" />
<%@include file="includes/links.jsp"%>
</head>
<body class="landingbg homebg-img homebg-overlay">
<div id="main-wrapper">
<%@include file="includes/header.jsp"%>
  <div id="">
  <div class="header-banner">
      <div class="container">
        <div class="row">
          <div class="home-employer">
                <span class="icon-battery"></span>
                <img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/employer-icon.png" alt="Employer" />
                <h2 class="title">Employer</h2>
                <p class="text">Secure Verify makes sure that the candidates referred by us are 100% genuine by verifying the skill set of the candidate.</p>
            </div>
            <hr class="mobileonly"/>
            <div class="centershieldlogo">
                <img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/centerlogo.png" alt="Secureverify" class="centerlogo" />
                <form id="verifyCandidateSearchForm" name="verifyCandidateSearchForm" method="post" action="verifyCandidateSearch" onsubmit="return false;">
                	<div class="input-group">
	                  <input type="text" class="form-control" id="candidateUniqueId" name="candidateUniqueId" value="" placeholder="Verification ID" />
	                  <span class="input-group-btn">
	             		<button class="btn btn-primary zipsearch-btn" type="button" id="verifyCandidateSearchButton" name="verifyCandidateSearchButton"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/go-icon.png" alt="Go" title="Go" /></button> 
	                  </span> 
	                </div>
                </form>
                <%@include file="includes/alertBoxSuccessError.jsp"%>
            </div>
            <hr class="mobileonly"/>
            <div class="home-candidate">
                <h2 class="title">Candidate</h2>
                <p class="text">Signup for a Secure Verify certification today and skip the hazel of multiple interviews with multiple employers.<!-- Secure Verify makes sure that the Employers registered with us are 100% genuine by verifying the address of the company. --></p>
                <img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/candidate-icon.png" alt="Candidate" />
            </div>
            
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>