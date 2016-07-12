<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Credits Management | Secure Verify</title>
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
        <%@include file="includes/employerLeftMenu.jsp"%>
        
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="green-bg">
            <div class="col-xs-12 green-bg-padding">
              <div class="bottom-admin-line">
                <div class="col-sm-9 no-padding">
                  <h5 class="m0 clr-white">Credits Management</h5>
                </div>
                <div class="col-sm-3 p0 text-right mt5 mtnegative25 add-button-left">
                  <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>buyEmployerCredits" class="btn btn-danger"> Add Credits </a>
                </div>
              </div>
            </div>
            <div class="clear"></div>
            <form id="" class="green-bg-padding" name="" action="#" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
                    <input type="text" class="datetimepicker form-control" placeholder="Purchased Date" id="scheduleFromTime" name="scheduleFromTime"/>
              </div>
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Credits Purchased" id="creditsPurchased" name="creditsPurchased" onkeypress="return keyRestrict(event,'int');"/>
              </div>
              <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" id="" name="employerCreditsManagementSearchButton" onclick = "javascript:searchAjx('employerSearchCreditsManagementAjax', 1)"><i class="fa fa-search"></i>Search</button>
              </div>
            </form>
          <div id="employercreditsmanagementajax" class="table-responsive clear default-bg">
          <h6><strong>
          		Credits Available : <span class="clr-red"><s:if test="creditsAvailable!=null"><s:property value="creditsAvailable.noOfCreditsAvailable" /></s:if><s:else>0</s:else></span><br/><br/>
          		Total No Of Credits Purchased : <span class="clr-red"><s:if test="creditsAvailable!=null"><s:property value="creditsAvailable.totalNoOfCreditsPurchased" /></s:if><s:else>0</s:else></span>
          		</strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                  	<th>View</th>
                    <th>ID</th>
                    <th>Payment Date</th>
                    <th>Transaction No</th>
                    <th>Invoice No</th>
                    <th>Credits Purchased</th>
                    <th>Price/Credit</th>
                    <th>Amount To Pay</th>
                    <th>Coupon Applied</th>
                    <th>Discount Amount</th>
                    <th>Paid Amount</th>                   
                  </tr>
                </thead>
                <tbody>
                <s:if test="paymentDetailList!=null && paymentDetailList.size>0">
	      		  <s:iterator var="paymentDetail" value="paymentDetailList">
                  <tr>
                  	<td>
                    	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewemployerpayment"  onclick="javascript:callAjx('vEmployerPayment',<s:property value="partyTypeId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a> <!-- aViewEmployerPaymentDetails.jsp -->
                    </td>
                    <td><s:property value="partyTypeId" /></td>
                    <td><s:date name="paymentDate" format="MM/dd/yyyy" /></td>
                    <td><s:property value="transactionNumber" /></td>
                    <td><s:property value="invoiceNumber" /></td>
                    <td><s:property value="noOfCreditsBought" /></td>
                    <td>$ <s:property value="priceOfCredit" /></td>
                    <td>$ <s:property value="amount" /></td>
                    <td><s:property value="coupon.couponCode" /></td>
                    <td>$ <s:property value="discountAmount" /></td>
                    <td>$ <s:property value="totalAmount" /></td>
                  </tr>
                  </s:iterator>
                </s:if>
                <s:else><tr><td colspan="8">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="modal fade" id="viewemployerpayment" role="dialog"></div>  
<%@include file="includes/footer.jsp"%>