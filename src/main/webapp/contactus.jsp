<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Contact Us | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body>
<div id="main-wrapper" class="nonlogin-page">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
      	<%@include file="includes/alertBoxSuccessError.jsp"%>
        <div class="col-md-12 col-sm-12 block-center">
          <div class="mt10">
           <div class="col-sm-6 cfpl0">
               <h5 class="clr-green m0">Get in Touch </h5>
              <form id="" name="" action="" method="post" class="contact-us-form-bg">
              <div class="row">
                  <div class="col-sm-6">
                  <h6 class="label">First Name</h6>
                    <input type="text" class="form-control" id="" name="" placeholder="First Name" />
                  </div>
                  <div class="col-sm-6">
                  <h6 class="label">Last Name</h6>
                    <input type="text" class="form-control" id="" name="" placeholder="Last Name" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-6">
                  <h6 class="label">Email</h6>
                    <input type="text" class="form-control" id="" name="" placeholder="Email Id" />
                  </div>
                  <div class="col-sm-6">
                  <h6 class="label">Company</h6>
                    <input type="text" class="form-control" id="" name="" placeholder="Company Name" />
                  </div>
                </div>
                <div class="row">
                 <div class="col-sm-12">
                 <h6 class="label">Message</h6>
                 <textarea class="form-control" rows="6" id="" name="" placeholder="Message"></textarea>
                 </div>
               </div>
               <button type="button" class="btn btn-success btn-large mt10" id="contactusFormButton" name="contactusFormButton" >Submit</button>
               </form>
               </div><!-- form end -->
               <div class="col-sm-6 p0">
              <h5 class="clr-green m0">Corporate Head Office </h5>
             <address class="pt10"> 
             <b>SECURE VERIFY</b><br/>
             Chicago, IL,1099 Brown Street, Suite 205,Wauconda, IL 60084<br/>
             Phone: 800-817-1025<br/>
             email: info@secureverify.com
             </address>
            <h5 class="clr-green m0">Location Map </h5>
             <div id="map-canvas"></div>
             </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>