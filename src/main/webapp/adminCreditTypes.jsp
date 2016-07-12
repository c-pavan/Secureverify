<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Admin Credits Details | Secure Verify</title>
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
        
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="green-bg">
            <div class="col-xs-12 green-bg-padding">
              <div class="bottom-admin-line">
                <div class="col-sm-9 no-padding">
                  <h5 class="m0 clr-white">Credits Type Details</h5>
                </div>
                <%-- <div class="col-sm-3 p0 text-right mt5 mtnegative25 add-button-left">
                  <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>addCreditType" class="btn btn-danger">Add Credit Type</a>
                </div> --%>
              </div>
            </div>
            <div id="" class="table-responsive clear default-bg">
            <h6><strong>Available Credit Types: <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Credit Type</th>
                    <th>Description</th>
                    <th>Amount</th>
                    <th>Status</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                <s:if test="creditTypesList!=null && creditTypesList.size>0">
	      		  <s:iterator var="creditTypes" value="creditTypesList">
                  <tr>
                  	<td><s:property value="creditTypesId" /></td>
                    <td><s:property value="creditType" /></td>
                    <td><s:property value="description" /></td>
                    <td>$ <s:property value="amount" /></td>
                    <td><s:if test="status==1">Active</s:if><s:else>In Active</s:else></td>
                    <td>
                    	<%-- <a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewcredittype"  onclick="javascript:callAjx('vCreditType',<s:property value="creditTypeId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a><!-- aViewCreditType.jsp --> --%>
                      	<a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>editCreditType?creditTypesId=<s:property value="creditTypesId" />" class="btn btn-success boxed-float-btn"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/edit-btn-img.png" alt="Edit" data-toggle="tooltip" title="Edit" /></a><!-- editCreditType.jsp -->
                      	<%-- <a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#deletecredittype" onclick="javascript:callAjx('dCreditType',<s:property value="creditTypeId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/delete-btn-img.png" alt="Delete" data-toggle="tooltip" title="Delete" /></a><!-- aDeleteCreditType.jsp --> --%>
                    </td>
                  </tr>
                  </s:iterator>
                 </s:if>
                  <s:else><tr><td colspan="6">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <%-- <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous  </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul> --%>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="deletecredittype" role="dialog"></div>
<div class="modal fade" id="viewcredittype" role="dialog"></div>
<%@include file="includes/footer.jsp"%>