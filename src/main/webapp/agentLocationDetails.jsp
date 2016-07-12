<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Agent Update Profile | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body class="form-block-page">
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
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white">Location Details</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
            
            <form id="" class="green-bg-padding" name="" action="#" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Location Name" id="locationName" name="locationName" onkeypress="return keyRestrict(event,'char');"/>
              </div>
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Business Name" id="locationBusinessName" name="locationBusinessName" onkeypress="return keyRestrict(event,'char');"/>
              </div>
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Primary Agent" id="locationPrimaryAgentId" name="locationPrimaryAgentId" onkeypress="return keyRestrict(event,'char');"/>
              </div>
              <div class="col-sm-2 search-padding">
                    <input type="text" class="form-control" placeholder="Secondary Agent" id="locationSecondaryAgentId" name="locationSecondaryAgentId" onkeypress="return keyRestrict(event,'char');"/>
              </div>
              <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" id="" name="agentLocationSearchButton" onclick = "javascript:searchAjx('agentSearchLocationAjax', 1);"><i class="fa fa-search"></i>Search</button>
              </div>
            </form>
            <div id="agentsearchlocationajax" class="table-responsive clear default-bg">
            <h6><strong>No. of Locations : <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Location Name</th>
                    <th>Business Name</th>
                    <th>Primary Agent</th>
                    <th>Secondary Agent</th>
                    <th>Phone Number</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                <s:if test="locationList!=null && locationList.size>0">
                	<s:iterator value="locationList" var="location">
	                  <tr>
	                  <td><s:property value="locationId" /></td>
	                  <td><s:property value="locationName" /></td>
	                  <td><s:property value="locationBusinessName" /></td>
	                  <td><s:property value="locationPrimaryAgentName" /></td>
	                  <td><s:property value="locationSecondaryAgentName" /></td>
	                  <td><s:property value="locationPhoneNo" /> <s:property value="locationPhoneNoExtension" /></td>
	                  <td>
	                  	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewlocationDetails"  onclick="javascript:callAjx('vLocationDetails',<s:property value="locationId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a>  <!-- aViewLocationDetails.jsp -->
	                  </td>
	                  </tr>
                	</s:iterator>
                </s:if>
                <s:else><tr><td colspan="7">No Locations to display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous</a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo-1)" />"><i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocationDetails?pageNo=<s:property value="(pageNo+1)" />">Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div> 
          </div>
        </div>
      </div>
    </div>
    <div class="modal fade" id="viewlocationDetails" role="dialog"></div>
  </div>
<%@include file="includes/footer.jsp"%>