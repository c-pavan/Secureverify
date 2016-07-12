<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Admin Agent | Secure Verify</title>
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
                  <h5 class="m0 clr-white">Agent Details</h5>
                </div>
                <div class="col-sm-3 p0 text-right mt5 mtnegative25 add-button-left">
                  <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>addAgent" class="btn btn-danger">Add Agent</a>
                </div>
              </div>
            </div>
            <form id="adminagentSearchForm" class="green-bg-padding" name="adminagentSearchForm" action="adminAgentSearch" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="agentEmailId" name="agentEmailId" placeholder="Agent Email Id" onkeypress="return keyRestrict(event,'emailchar');">
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="agentPhoneNo" name="agentPhoneNo" placeholder="Agent Phone No " onkeypress="return keyRestrict(event,'phone');">
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="agentCountry" name="agentCountry" placeholder="Agent Country" onkeypress="return keyRestrict(event,'char');">
              </div>
              <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" id="adminagentSearchButton" name="adminagentSearchButton" onclick="javascript:searchAjx('adminSearchAgentAjax', 1);"><i class="fa fa-search"></i>Search</button>
              </div>
            </form>
            <div id="adminsearchagentajax" class="table-responsive clear default-bg">
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
                    	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewagent"  onclick="javascript:callAjx('vAgent',<s:property value="agentId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a>
                      	<a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>editAgent?agentId=<s:property value="agentId" />" class="btn btn-success boxed-float-btn"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/edit-btn-img.png" alt="Edit" data-toggle="tooltip" title="Edit" /></a>
                      	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#deleteagent" onclick="javascript:callAjx('dAgent',<s:property value="agentId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/delete-btn-img.png" alt="Delete" data-toggle="tooltip" title="Delete" /></a>
                    </td>
                  </tr>
                   </s:iterator>
                  </s:if>
                  <s:else><tr><td colspan="5">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="deleteagent" role="dialog"></div>
<div class="modal fade" id="viewagent" role="dialog"></div>
<%@include file="includes/footer.jsp"%>