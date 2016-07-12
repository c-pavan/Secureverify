<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
        <h4 class="modal-title">Payment Details</h4>
      </div>
      <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Transaction Number : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.transactionNumber" /></p></div>
       <div class="viewlabel"><p class="labelspan">Invoice Number : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.invoiceNumber" /></p></div>
       <div class="viewlabel"><p class="labelspan">Party ID : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.partyId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Party Type ID : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.partyTypeId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.firstName" /> <s:property value="paymentDetail.lastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Phone : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.phone" /></p></div>
       <div class="viewlabel"><p class="labelspan">Email ID : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.emailId" /></p></div>
       <div class="viewlabel"><p class="labelspan">No. of Credits : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.noOfCreditsBought" /></p></div>
       <div class="viewlabel"><p class="labelspan">Coupon Code : </p> <p class="viewlabeldetails"> <s:property value="coupon.couponCode" /></p></div>
       <div class="viewlabel"><p class="labelspan">Price/Credit : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.priceOfCredit" /></p></div>
       <div class="viewlabel"><p class="labelspan">Amount : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.amount" /></p></div>
       <div class="viewlabel"><p class="labelspan">Discount Amount : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.discountAmount" /></p></div>
       <div class="viewlabel"><p class="labelspan">Paid Amount : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.totalAmount" /></p></div>
       <div class="viewlabel"><p class="labelspan">Payment Date : </p> <p class="viewlabeldetails"> <s:date name="paymentDetail.paymentDate" format="MM/dd/yyyy hh:mm:ss" /></p></div>
       
       <div class="viewlabel"><p class="labelspan">Payment Details ID : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.paymentDetailsId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Coupon ID : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.couponId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Auth Response : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.authResponse" /></p></div>
       <div class="viewlabel"><p class="labelspan">Avs Response : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.avsResponse" /></p></div>
       <div class="viewlabel"><p class="labelspan">Approved : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.approved" /></p></div>
       <div class="viewlabel"><p class="labelspan">Expiry Date : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.expMonth" /> / <s:property value="paymentDetail.expYear" /></p></div>
       <div class="viewlabel"><p class="labelspan">Address : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.address" /></p></div>
       <div class="viewlabel"><p class="labelspan">Zip : </p> <p class="viewlabeldetails"> <s:property value="paymentDetail.zip" /></p></div>
       </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
      </div>
    </div>
  </div>