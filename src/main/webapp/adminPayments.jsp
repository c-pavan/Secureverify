<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>All Payments | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body>
<div id="main-wrapper" class="admin-payment-list">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
        <%@include file="includes/adminLeftMenu.jsp"%>
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="green-bg">
            <div class="col-xs-12 green-bg-padding">
              <div class="bottom-admin-line">
                <div class="col-sm-9 no-padding">
                  <h5 class="m0 clr-white">Payment Details</h5>
                </div>                
              </div>
            </div>
            <div class="clear"></div>
            <form id="adminPaymentSearchForm" class="green-bg-padding" name="adminPaymentSearchForm" action="#" method="post" onsubmit="return false;">
              <div class="search-padding">
                <select id="partyTypeId" name="partyTypeId">
                   <option value="">Type of user</option>
                   <option value="1">Employer</option>
                   <option value="2">Candidate</option>                  	
               </select>
              </div>
              <div class="search-padding">
                <input type="text" class="form-control" id="transactionNumber" name="transactionNumber" placeholder="Transaction no." onkeypress="return keyRestrict(event,'int');">
              </div>
              <div class="search-padding">
                <input type="text" class="form-control" id="invoiceNumber" name="invoiceNumber" placeholder="Invoice no.">
              </div>
              <div class="search-padding">
                <input type="text" class="form-control datepicker" id="paymentDate" name="paymentDate" placeholder="Payment Date">
              </div>
              <div class="search-padding">
                <select id="noOfCreditsBought" name="noOfCreditsBought">
                  <option value="" selected="selected">No. of Credits</option>
                  <%for(int i=1; i <=30; i++){ %>
                  <option value="<%=i %>"><%=i %></option>
                  <%} %>
                </select>
              </div>     
              <div class="search-padding">
                <input type="text" class="form-control" id="couponId" name="couponId" placeholder="Enter Coupon Id" onkeypress="return keyRestrict(event,'int');">
              </div>
              <div class="search-padding">
                <input type="text" class="form-control" id="totalAmount" name="totalAmount" placeholder="Total Amount" onkeypress="return keyRestrict(event,'dotint');">
              </div>
              <div class="search-padding">
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" onkeypress="return keyRestrict(event,'char');">
              </div>
              <div class="search-padding">
                <input type="text" class="form-control" id="emailId" name="emailId" placeholder="Email ID" onkeypress="return keyRestrict(event,'emailchar');">
              </div>
              <div class="search-padding">
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone No" onkeypress="return keyRestrict(event,'phone');">
              </div>
              <div class="search-padding">
                <input type="text" class="form-control" id="zip" name="zip" placeholder="Zip Code">
              </div>
              <div class="search-padding">
                <input type="text" class="form-control datepicker" id="fromDate" name="fromDate" placeholder="From Date">
              </div>
              <div class="search-padding">
                <input type="text" class="form-control datepicker" id="toDate" name="toDate" placeholder="To Date">
              </div> 
              <div class="search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" id="adminSearchPaymentButton" name="adminSearchPaymentButton" onclick="javascript:searchAjx('adminSearchPaymentDeatilAjax', 1);" ><i class="fa fa-search"></i>Search</button>
              </div>
            </form>
            
            <!-- aAdminSearchPayment.jsp -->
            
            <div id="adminSearchPaymentAjax" class="table-responsive clear default-bg">
            <h6><strong>No. of Payments Done: <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped payment-table">
                <thead>
                  <tr>
                    <th>View</th>
                    <th>User ID</th>
                    <th>User</th>
                    <th>Transaction No</th>
                    <th>Invoice No</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Price/Credit</th>
                    <th>Credits</th>
                    <th>Coupon ID</th>
                    <th>Coupon Code</th>
                    <!-- <th>Amount</th>
                    <th>Discount<br/>Amount</th> -->
                    <th>Paid Amount</th>
                    <th>Paid On</th>
                    <th>Email ID</th>
                    <th>Zip</th>
                  </tr>
                </thead>
                <tbody>
                 <s:if test="paymentDetailList!=null && paymentDetailList.size>0">
	      		<s:iterator var="paymentDetail" value="paymentDetailList">
                <tr>
                    <td>
                    	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewpayment"  onclick="javascript:callAjx('vAdminPayment',<s:property value="paymentDetailsId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a> <!-- aViewPaymentDetails.jsp -->
                    </td>
                    <td><s:property value="paymentDetailsId" /></td>
                   <td><s:if test="%{partyTypeId==1}"> Employer </s:if><s:elseif test="%{partyTypeId==2}"> Candidate </s:elseif></td>                 
                    <td><s:property value="transactionNumber" /></td>
                    <td><s:property value="invoiceNumber" /></td>
                    <td><s:property value="firstName" /> <s:property value="lastName" /></td>
                    <td><s:property value="phone" /></td>
                    <td>$<s:property value="priceOfCredit" /></td>
                    <td><s:property value="noOfCreditsBought" /></td>
                    <td><s:property value="coupon.couponId" /></td>
                    <td><s:property value="coupon.couponCode" /></td>
                    <%-- <td>$<s:property value="amount" /></td>
                    <td>$<s:property value="discountAmount" /></td> --%>
                    <td>$<s:property value="totalAmount" /></td>
                    <td><s:date name="paymentDate" format = "MM/dd/yyyy"/></td>
                    <td><s:property value="emailId" /></td>
                    <td><s:property value="zip" /></td>
               </tr>
                  </s:iterator>
                  </s:if>
                  <s:else><tr><td colspan="19">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayment?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="modal fade" id="viewpayment" role="dialog"></div>
<%@include file="includes/footer.jsp"%>