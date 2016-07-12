<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Edit Coupon | Secure Verify</title>
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
                  <h5 class="m0 clr-white pl25"><span>Coupon Name</span> - Edit Details</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="updateCouponForm" name="updateCouponForm" action="updateCoupon" method="post" onsubmit="return false;">
               
                <div class="row">
                  <div class="col-sm-4">
                   <h6 class="label">Coupon ID</h6>
                    <input type="text" class="form-control" id="hcouponId" name="hcouponId" value="<s:property value="coupon.couponId" />" disabled="disabled" />
                    <input type="hidden" id="couponId" name="couponId" value="<s:property value="coupon.couponId" />" />
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-4">
                   <h6 class="label">Coupon Code</h6>
                    <input type="text" class="form-control" id="couponCode" name="couponCode" value="<s:property value="coupon.couponCode" />" placeholder="Coupon Code" />
                  </div>
                  <div class="col-sm-4">
                <h6 class="label">Coupon Name</h6>
                    <input type="text" class="form-control" id="couponName" name="couponName" value="<s:property value="coupon.couponName"/>" placeholder="Coupon Name" />
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-4">
                	<h6 class="label">Discount Percentage</h6>
                    <input type="text" class="form-control" id="discountPercentage" name="discountPercentage" value="<s:property value="coupon.discountPercentage" />" placeholder="Discount Percentage" onkeypress="return keyRestrict(event,'dotint');"/>
                  </div>
                  <div class="col-sm-4">
                <h6 class="label">Discount Amount</h6>
                    <input type="text" class="form-control" id="discountAmount" name="discountAmount" value="<s:property value="coupon.discountAmount" />" placeholder="Discount Amount" onkeypress="return keyRestrict(event,'dotint');"/>
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-4">
                <h6 class="label">Expiry Date</h6>
                    <input type="text" class="form-control datepicker" id="expiryDate" name="expiryDate" value="<s:date name="coupon.expiryDate" format="MM/dd/yyyy"/>" placeholder="Expiry Date" />
                  </div>
                </div>
                <hr class="mt10" />
            <div class="clearfix"> <button type="button" class="btn btn-success btn-large" id="updateCouponButton" name="updateCouponButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>