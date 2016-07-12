<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Admin Location | Secure Verify</title>
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
                  <h5 class="m0 clr-white">Location Details</h5>
                </div>
                <div class="col-sm-3 p0 text-right mt5 mtnegative25 add-button-left">
                  <a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>addLocation" class="btn btn-danger">Add Location </a>
                </div>
              </div>
            </div>
            <div class="clear"></div>
            <form id="adminLocationSearchForm" class="green-bg-padding" name="adminLocationSearchForm" action="adminLocationSearch" method="post" onsubmit="return false;">
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="locationName" name="locationName" placeholder="Location Name" onkeypress="return keyRestrict(event,'char');">
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="locationBusinessName" name="locationBusinessName" placeholder="Location Business " >
              </div>
              <div class="col-sm-2 search-padding"> 
                <input type="text" class="form-control" id="locationCity" name="locationCity" placeholder="City" onkeypress="return keyRestrict(event,'char');">
              </div>
              <div class="col-sm-2 search-padding">
                <input type="text" class="form-control" id="locationCountry" name="locationCountry" placeholder="Country" onkeypress="return keyRestrict(event,'char');">
              </div>
              <div class="col-sm-2 search-padding">
                <button type="button" class="btn btn-default height40 black-search-button" onclick="javascript:searchAjx('adminSearchLocationAjax', 1);" ><i class="fa fa-search"></i>Search</button>
              </div>
            </form>
            <div id="adminsearchlocationajax" class="table-responsive default-bg clear">
            <h6><strong>No. of Locations: <span class="clr-red"><s:property value="totalSize" /></span></strong></h6>
              <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Location Name</th>
                    <th>Location Business Name</th>
                    <th>Country</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                <s:if test="locationList!=null && locationList.size>0">
	      		<s:iterator var="location" value="locationList">
                  <tr>
                    <td><s:property value="locationId"/></td>
                    <td><s:property value="locationName"/></td>
                    <td><s:property value="locationBusinessName"/></td>
                    <td><s:property value="locationCountry"/></td>
                    <td>
                    	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#viewlocation"  onclick="javascript:callAjx('vLocation',<s:property value="locationId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/view-btn-img.png" alt="View" data-toggle="tooltip" title="View" /></a>
                      	<a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>editLocation?locationId=<s:property value="locationId" />" class="btn btn-success boxed-float-btn"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/edit-btn-img.png" alt="Edit" data-toggle="tooltip" title="Edit" /></a>
                      	<a href="#" class="btn btn-success boxed-float-btn" data-toggle="modal" data-target="#deletelocation" onclick="javascript:callAjx('dLocation',<s:property value="locationId" />);"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/delete-btn-img.png" alt="Delete" data-toggle="tooltip" title="Delete" /></a>
                    </td>
                  </tr>
                   </s:iterator>
                  </s:if>
                  <s:else><tr><td colspan="5">No Data to Display</td></tr></s:else>
                </tbody>
              </table>
              <ul class="pagination">
                <s:if test="pageNo==1" ><li class="prev disabled"><a href="#"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:if>
				<s:else><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo-1)" />"> <i class="fa fa-arrow-left"></i> Previous </a></li></s:else>
				<s:if test="(pageNo>4) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo-4)" />"><s:property value="(pageNo-4)" /></a></li></s:if>
				<s:if test="(pageNo>3) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo-3)" />"><s:property value="(pageNo-3)" /></a></li></s:if>
				<s:if test="(pageNo>2) && ((pageNo-2)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo-2)" />"><s:property value="(pageNo-2)" /></a></li></s:if>
				<s:if test="(pageNo>1) && ((pageNo-1)>0)" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo-1)" />"><s:property value="(pageNo-1)" /></a></li></s:if>
				<li class="active"><a href="#"><s:property value="pageNo" /></a></li>
				<s:if test="(pageNo+1)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo+1)" />"><s:property value="(pageNo+1)" /></a></li></s:if>
				<s:if test="(pageNo+2)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo+2)" />"><s:property value="(pageNo+2)" /></a></li></s:if>
				<s:if test="(pageNo+3)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo+3)" />"><s:property value="(pageNo+3)" /></a></li></s:if>
				<s:if test="(pageNo+4)<=noOfPages" ><li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo+4)" />"><s:property value="(pageNo+4)" /></a></li></s:if>
				<s:if test="noOfPages<=pageNo" ><li class="next disabled"><a href="#"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:if>
				<s:else><li class="next"><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation?pageNo=<s:property value="(pageNo+1)" />"> Next <i class="fa fa-arrow-right"></i> </i></a></li></s:else>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="deletelocation" role="dialog"></div>
<div class="modal fade" id="viewlocation" role="dialog"></div>
<%@include file="includes/footer.jsp"%>