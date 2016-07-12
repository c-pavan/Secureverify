<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Add Location | Secure Verify</title>
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
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Add Location Details</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="addLocationForm" name="addLocationForm" action="saveLocation" method="post" onsubmit="return false;">
               <h6 class="label">Location Name</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="locationName" name="locationName" value="<s:property value="locationName"/>" placeholder="Location Name" />
                  </div>
                </div>
                  <h6 class="label">Business Name</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="locationBusinessName" name="locationBusinessName" value="<s:property value="locationBusinessName"/>" placeholder="Business Name" />
                  </div>
                </div>
                <h6 class="label">Address</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="locationAddressLine1" name="locationAddressLine1" value="<s:property value="locationAddressLine1"/>" placeholder="Address Line 1"  />
                  </div>
                  
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="locationAddressLine2" name="locationAddressLine2" value="<s:property value="locationAddressLine2"/>" placeholder="Address Line 2"  />
                  </div>
                </div>
               <div class="row mt20">
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="locationCity" name="locationCity" value="<s:property value="locationCity"/>" placeholder="City"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="locationState" name="locationState" value="<s:property value="locationState"/>" placeholder="State"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="locationCountry" name="locationCountry" value="<s:property value="locationCountry"/>" placeholder="Country"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="locationZipcode" name="locationZipcode" value="<s:property value="locationZipcode"/>" placeholder="Zip" onkeypress="return keyRestrict(event,'charnum');" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-3">
                <h6 class="label">Latitude</h6>
                    <input type="text" class="form-control" id="latitude" name="latitude" value="<s:property value="latitude"/>" placeholder="Latitude" onkeypress="return keyRestrict(event,'latlong');" />
                  </div>
                  
                  <div class="col-sm-3">
                <h6 class="label">Longitude</h6>
                    <input type="text" class="form-control" id="longitude" name="longitude" value="<s:property value="longitude"/>" placeholder="Longitude" onkeypress="return keyRestrict(event,'latlong');" />
                  </div>
                </div>
                 <h6 class="label">Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="locationPhoneNo" name="locationPhoneNo" value="<s:property value="locationPhoneNo"/>" placeholder="Phone Number" onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="locationPhoneNoExtension" name="locationPhoneNoExtension" value="<s:property value="locationPhoneNoExtension"/>" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                 <div class="col-sm-4">
                    <input type="text" class="form-control" id="locationAlternatePhone" name="locationAlternatePhone" value="<s:property value="locationAlternatePhone"/>" placeholder="Alternate Phone Number" onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                   <div class="col-sm-2">
                    <input type="text" class="form-control" id="locationAlternatePhoneNoExtension" name="locationAlternatePhoneNoExtension" value="<s:property value="locationAlternatePhoneNoExtension"/>" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-4">
                <h6 class="label">Primary Agent</h6>
	      		 	<select id="locationPrimaryAgentId" name="locationPrimaryAgentId">
                      <option value="">Select</option>
                	  <s:if test="agentList!=null && agentList.size>0">
	      		 	  <s:iterator var="agent" value="agentList">
                      	<option value="<s:property value="agentId"/>" <s:if test="locationPrimaryAgentId.equals(agentId)">selected="selected"</s:if> ><s:property value="agentFirstName"/> <s:property value="agentLastName"/></option>
                      </s:iterator>
                      </s:if>
                    </select>
                  </div>
                  <div class="col-sm-4">
                <h6 class="label">Secondary Agent</h6>
                	<select id="locationSecondaryAgentId" name="locationSecondaryAgentId">
                      <option value="">Select</option>
                	  <s:if test="agentList!=null && agentList.size>0">
	      		 	  <s:iterator var="agent" value="agentList">
                      	<option value="<s:property value="agentId"/>" <s:if test="locationSecondaryAgentId.equals(agentId)">selected="selected"</s:if> ><s:property value="agentFirstName"/> <s:property value="agentLastName"/></option>
                      </s:iterator>
                      </s:if>
                    </select>
                  </div>
                </div>
               <hr class="mt10" />
            <div class="clearfix"> <button type="button" class="btn btn-success btn-large" id="addLocationButton" name="addLocationButton" >Add Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
             </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>