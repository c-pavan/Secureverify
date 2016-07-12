<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
        <h4 class="modal-title">Coupon Details</h4>
      </div>
      <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Coupon Id : </p> <p class="viewlabeldetails"> <s:property value="coupon.couponId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Coupon Code : </p> <p class="viewlabeldetails"> <s:property value="coupon.couponCode" /></p></div>
       <div class="viewlabel"><p class="labelspan">Coupon Name : </p> <p class="viewlabeldetails"> <s:property value="coupon.couponName"/></p></div>
       <div class="viewlabel"><p class="labelspan">Discount Percentage : </p> <p class="viewlabeldetails"> <s:property value="coupon.discountPercentage" /></p></div>
       <div class="viewlabel"><p class="labelspan">Discount Amount : </p> <p class="viewlabeldetails"> <s:property value="coupon.discountAmount" /></p></div>
       <div class="viewlabel"><p class="labelspan">Expiry Date : </p> <p class="viewlabeldetails"> <s:date name="coupon.expiryDate" format="MM/dd/yyyy"/></p></div>
       <div class="viewlabel"><p class="labelspan">Created By : </p> <p class="viewlabeldetails"> <s:property value="coupon.createdByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="coupon.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified By : </p> <p class="viewlabeldetails"> <s:property value="coupon.lastModifiedByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="coupon.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
      </div>
    </div>
  </div>