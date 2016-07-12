<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Admin Profile | Secure Verify</title>
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
                <div class="col-sm-10 no-padding">
                  <h5 class="m0 clr-white pl25">Profile Details</h5>
                </div>
              </div>
            </div>
            <div class=" viewform pl25">
       			<div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="user.userFirstName" /> <s:property value="user.userLastName" /></p></div>
       			<div class="viewlabel"><p class="labelspan">Email : </p> <p class="viewlabeldetails"> <s:property value="user.userEmailId" /></p></div>
       			<div class="viewlabel"><p class="labelspan">Phone Number : </p> <p class="viewlabeldetails"> <s:property value="user.userPhoneNo" /></p></div>
       			<div class="viewlabel"><p class="labelspan">Address : </p> <p class="viewlabeldetails"> <s:property value="user.userAddressLine1" />, <s:property value="user.userAddressLine2" />, <s:property value="user.userCity" />, <s:property value="user.userState" />, <s:property value="user.userCountry" />, <s:property value="user.userZipcode" /></p></div>
       			<div class="viewlabel"><p class="labelspan">Designation : </p> <p class="viewlabeldetails"> <s:property value="user.userDesignation" /></p></div>
       			<a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEditProfile" class="btn btn-success btn-large mt10" >Update Details &nbsp;<i class="fa fa-caret-right"></i></a>
            </div>
            
                
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>