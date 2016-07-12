<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Employer Details | Secure Verify</title>
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
        
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-blue">Employer Details</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <div class="table-responsive clear">
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>Employer Name</th>
                    <th>Company Name</th>
                    <th>Email</th>
                    <th>PhoneNo</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><s:property value="employerFirstName"/><s:property value="employerLastName" /></td>
                    <td><s:property value="employerCompanyName"/></td>
                    <td><s:property value="employerEmailId"/></td>
                    <td><s:property value="employerPhoneNo"/><s:property value="employerPhoneNoExtension"/></td>
                    <td><a href="#" class="btn btn-default" data-toggle="modal" data-target="#viewEmployerDetails" id="" name=""><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a></td><!-- cViewEmployerDetails.jsp -->
                  </tr>
                </tbody>
              </table>
              <ul class="pagination">
                <li><a href="#" class="fa fa-angle-left"></a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#" class="fa fa-angle-right"></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="viewEmployerDetails" role="dialog"></div>
<%@include file="includes/footer.jsp"%>