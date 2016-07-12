<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Update Company Info | Secure Verify</title>
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
        <%@include file="includes/employerLeftMenu.jsp"%>
        
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container ">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Update Company Info</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
            <form id="updateCompanyInfoForm" name="updateCompanyInfoForm" action="updateEmployerCompanyInfo" method="post" onsubmit="return false;">
                <h6 class="label">Company Name</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="employerCompanyName" name="employerCompanyName" value="<s:property value="employer.employerCompanyName" />" placeholder="Company Name" />
                  </div>
                </div>
                <h6 class="label">Title</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="employerTitle" name="employerTitle" value="<s:property value="employer.employerTitle" />" placeholder="Title" />
                  </div>
                </div>
                <h6 class="label">Address</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="employerAddressLine1" name="employerAddressLine1" value="<s:property value="employer.employerAddressLine1" />" placeholder="Address Line 1"  />
                  </div>
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="employerAddressLine2" name="employerAddressLine2" value="<s:property value="employer.employerAddressLine2" />" placeholder="Address Line 2"  />
                  </div>
                </div>
                <div class="row  pt15">
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="employerCity" name="employerCity" value="<s:property value="employer.employerCity" />" placeholder="City"  />
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="employerState" name="employerState" value="<s:property value="employer.employerState" />" placeholder="State"  />
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="employerCountry" name="employerCountry" value="<s:property value="employer.employerCountry" />" placeholder="Country"  />
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="employerZipcode" name="employerZipcode" value="<s:property value="employer.employerZipcode" />" placeholder="Zip"  />
                  </div>
                </div>
              <div class="clearfix">
                <hr class="mt20" />
                <button type="button" class="btn btn-success btn-large pull-left" id="updateCompanyInfoButton" name="updateCompanyInfoButton" >Update Info</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
 <%@include file="includes/footer.jsp"%>