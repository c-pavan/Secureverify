<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Properties, com.secureVerify.util.Helper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% Properties properties = Helper.getPropertiesFromFile(); %>
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
	<s:else><li><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo-1)" />);" > <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
	<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo-4)" />);" ><s:property value="(pageNo-4)" /></a></li></s:if>
	<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo-3)" />);" ><s:property value="(pageNo-3)" /></a></li></s:if>
	<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo-2)" />);" ><s:property value="(pageNo-2)" /></a></li></s:if>
	<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo-1)" />);" ><s:property value="(pageNo-1)" /></a></li></s:if>
	<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
	<s:if test="(pageNo+1)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo+1)" />);" ><s:property value="(pageNo+1)" /></a></li></s:if>
	<s:if test="(pageNo+2)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo+2)" />);" ><s:property value="(pageNo+2)" /></a></li></s:if>
	<s:if test="(pageNo+3)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo+3)" />);" ><s:property value="(pageNo+3)" /></a></li></s:if>
	<s:if test="(pageNo+4)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo+4)" />);" ><s:property value="(pageNo+4)" /></a></li></s:if>
	<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i></a></li></s:if>
	<s:else><li class="next"><a href="#" onclick="javascript: searchAjx('adminSearchEmployerAjax',<s:property value="(pageNo+1)" />);" >  Next <i class="fa fa-arrow-right"></i></a></li></s:else>
 </ul>