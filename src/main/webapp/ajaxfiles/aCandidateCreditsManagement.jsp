<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Properties, com.secureVerify.util.Helper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% Properties properties = Helper.getPropertiesFromFile(); %>
 <h6><strong>Total No. Credits Purchased: <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>           
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
                    <th>Coupon Code</th>
                    <th>Discount Amount</th>
                    <th>Paid Amount</th>
                  </tr>
                </thead>
                <tbody>
                  <s:if test="paymentDetailList!=null && paymentDetailList.size>0">
	      		  <s:iterator var="paymentDetail" value="paymentDetailList">
                  <tr>
                    <td>
                    	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewcandidatepayment"  onclick="javascript:callAjx('vCandidatePayment',<s:property value="partyTypeId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a> <!-- aViewCandidatePaymentDetails.jsp -->
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
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateSearchCreditsManagementAjax?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>