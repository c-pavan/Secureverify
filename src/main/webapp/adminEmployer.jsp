<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Admin Employer | Secure Verify</title>
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
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="green-bg">
            <div class="col-xs-12 green-bg-padding">
              <div class="bottom-admin-line">
                <div class="col-sm-9 no-padding">
                  <h5 class="m0 clr-white">Employer Details</h5>
                </div>                
              </div>
            </div>
            <div class="clear"></div>
            <form id="adminEmployerSearchForm" class="green-bg-padding" name="adminEmployerSearchForm" action="adminEmployerSearch" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="employerFirstName" name="employerFirstName" value="" placeholder="Name" onkeypress="return keyRestrict(event,'char');">
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="employerEmailId" name="employerEmailId" value="" placeholder="Email" onkeypress="return keyRestrict(event,'emailchar');">
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="employerPhoneNo" name="employerPhoneNo" value="" placeholder="Phone No" onkeypress="return keyRestrict(event,'phone');">
              </div>
              <div class="col-sm-2 search-padding">
                <select id="status" name="status">
                   <option value="">Status</option>
                   <option value="1">Active</option>
                   <option value="0">In Active</option>                  	
               </select>
              </div>
              <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" onclick="javascript:searchAjx('adminSearchEmployerAjax', 1);" ><i class="fa fa-search"></i>Search</button>
              </div>
            </form>
            <div id="adminSearchEmployerAjax" class="table-responsive clear default-bg">
            <h6><strong>No. of Employers: <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone No</th>
                    <th>Company Name</th>
                    <th>Status</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                <s:if test="employerList!=null && employerList.size>0">
	      		 <s:iterator var="employer" value="employerList">
                <tr>
                    <td><s:property value="employerId"/></td>
                    <td><s:property value="employerFirstName"/> <s:property value="employerLastName"/></td>
                    <td><s:property value="employerEmailId"/></td>
                    <td><s:property value="employerPhoneNo"/> <s:property value="employerPhoneNoExtension"/></td>
                    <td><s:property value="employerCompanyName"/></td>
                    <td><s:if test="status==1">ACTIVE</s:if><s:if test="status==0">IN ACTIVE</s:if></td>
                    <td>
                    	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewemployer"  onclick="javascript:callAjx('vEmployer',<s:property value="employerId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a> <!-- aViewEmployer.jsp -->
                    	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#activeemployer"  onclick="javascript:callAjx('aEmployer',<s:property value="employerId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/pick-btn-img.png" alt="Active" data-toggle="tooltip" title="Active" /></a> <!-- aEmployerActive.jsp -->
                    	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#inactiveemployer"  onclick="javascript:callAjx('iEmployer',<s:property value="employerId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/inactive-btn-img.png" alt="InActive" data-toggle="tooltip" title="InActive" /></a> <!-- aEmployerInActive.jsp -->
                    </td>
                  </tr>
               	</s:iterator>
               </s:if>
                  <s:else><tr><td colspan="7">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="modal fade" id="viewemployer" role="dialog"></div>
  <div class="modal fade" id="activeemployer" role="dialog"></div>
  <div class="modal fade" id="inactiveemployer" role="dialog"></div>
<%@include file="includes/footer.jsp"%>