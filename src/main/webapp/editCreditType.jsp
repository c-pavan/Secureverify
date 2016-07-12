<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Edit Credit Type | Secure Verify</title>
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
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Edit Details</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="editCreditTypeForm" name="editCreditTypeForm" action="updateCreditType" method="post" onsubmit="return false;">
               <div class="row">
                  <div class="col-sm-4">
                   <h6 class="label">Credit Type ID</h6>
                    <input type="text" class="form-control" id="creditTypesId" name="creditTypesId" value="<s:property value="creditTypes.creditTypesId" />" disabled="disabled" />
                    <input type="hidden" id="creditTypesId" name="creditTypesId" value="<s:property value="creditTypes.creditTypesId" />" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-4">
                    <h6 class="label">Description</h6>
                    <input type="text" class="form-control" id="description" name="description" value="<s:property value="creditTypes.description" />" placeholder="Description" />
                  </div>
                  <div class="col-sm-4">
               		 <h6 class="label">Amount Per Credit</h6>
                   	 <input type="text" class="form-control" id="amount" name="amount" value="<s:property value="creditTypes.amount" />" placeholder="Amount Per Credit" onkeypress="return keyRestrict(event,'dotint');"/>
                  </div>
                </div>                
                <hr class="mt10" />
              <div class="clearfix">
             <button type="button" class="btn btn-success btn-large" id="editCreditTypeButton" name="editCreditTypeButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
             
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>