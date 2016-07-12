<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Payment Declined | Secure Verify</title>
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
      <%@include file="includes/candidateLeftMenu.jsp"%>
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container text-center">
            <h4>Sorry, your transaction is declined.</h4>
            <h5><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>buyCandidateCredits" class="btn btn-default btn-large mt10">Try again</a></h5>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>