<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Generate Certificate | Secure Verify</title>
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
        <%@include file="includes/adminLeftMenu.jsp"%>
        
        <div class="col-sm-9 page-content">
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0">
              <div class="bottom-admin-line">
                <div class="col-sm-10 no-padding">
                  <h5 class="m0 clr-blue">Generate Certificate</h5>
                </div>
              </div>
            </div>
            <div class="col-xs-12 p0">
            <div>
            	<canvas id="myCanvas" width="500" height="386"></canvas>
				<script>
				     window.onload = function(){
				     var canvas = document.getElementById("myCanvas");
				     var context = canvas.getContext("2d");
					 var txt_p1 = "Java Developer";
					 var txt_p2 = "123456789";
				     var imageObj = new Image();
				     imageObj.onload = function(){
						context.drawImage(imageObj, 0, 0);
				        context.font = '35pt Arial ';
						context.fillStyle = "#fff";
						context.textAlign = 'center';
						context.fillText(txt_p1,250,319);
								
						context.font = '30pt Arial';
						context.fillStyle = "#fff";
						context.textAlign = 'left';
						context.fillText(txt_p2,190,374);		
				     };
				     imageObj.src = "img/certification-img.jpg"; 
					};	  
				</script>
            </div>
            <h4>Enter Certification Details</h4>
            <form id="" name="" action="#" method="post" onsubmit="return false;">
              <div class="col-sm-5 search-padding">
                <input type="text" class="form-control" id="" name="" placeholder="Enter Skillset of candidate">
              </div>
              <div class="col-sm-5 search-padding">
                <input type="text" class="form-control" id="" name="" placeholder="Enter ID">
              </div>
              <div class="col-sm-2 search-padding">
                <button type="submit" class="btn btn-default height40" id="" name="">Generate</button>
              </div>
            </form>
            </div>
            <div class="clear"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>