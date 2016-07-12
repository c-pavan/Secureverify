<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Properties, com.secureVerify.util.Helper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% Properties properties = Helper.getPropertiesFromFile(); %>
<h6><strong>No. of Agents: <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Agent Email Id</th>
                    <th>Agent Phone No</th>
                    <th>Agent Country</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                 <s:if test="agentList!=null && agentList.size>0">
	      		 <s:iterator var="agent" value="agentList">
                  <tr>
                    <td><s:property value="agentId"/></td>
                    <td><s:property value="agentEmailId"/></td>
                    <td><s:property value="agentPhoneNo"/></td>
                    <td><s:property value="agentCountry"/></td>
                    <td>
                    	<a href="#" class="btn btn-default boxed-float-btn" data-toggle="modal" data-target="#viewagent"  onclick="javascript:callAjx('vAgent',<s:property value="agentId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a>
                      	<a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>editAgent?agentId=<s:property value="agentId" />" class="btn btn-default boxed-float-btn"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/edit-btn-img.png" alt="Edit" data-toggle="tooltip" title="Edit" /></a>
                      	<a href="#" class="btn btn-default boxed-float-btn" data-toggle="modal" data-target="#deleteagent" onclick="javascript:callAjx('dAgent',<s:property value="agentId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/delete-btn-img.png" alt="Delete" data-toggle="tooltip" title="Delete" /></a>
                    </td>
                  </tr>
                   </s:iterator>
                  </s:if>
                  <s:else><tr><td colspan="5">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
			    <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo-1)" />);" > <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo-4)" />);" ><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo-3)" />);" ><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo-2)" />);" ><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo-1)" />);" ><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo+1)" />);" ><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo+2)" />);" ><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo+3)" />);" ><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo+4)" />);" ><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i></a></li></s:if>
				<s:else><li class="next"><a href="#" onclick="javascript: searchAjx('adminSearchAgentAjax',<s:property value="(pageNo+1)" />);" >  Next <i class="fa fa-arrow-right"></i></a></li></s:else>
			 </ul>