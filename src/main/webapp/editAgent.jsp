<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Edit Agent | Secure Verify</title>
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
                  <h5 class="m0 clr-white pl25">Edit Agent Details</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="updateAgentForm" name="updateAgentForm" action="updateAgent" method="post" onsubmit="return false;">
          		 <h6 class="label">Agent Id</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="hagentId" name="hagentId" value="<s:property value="agent.agentId" />" disabled="disabled" />
                    <input type="hidden" id="agentId" name="agentId" value="<s:property value="agent.agentId" />"/>
                  </div>
                </div>
                <h6 class="label">Name</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentFirstName" name="agentFirstName" value="<s:property value="agent.agentFirstName" />" placeholder="First Name" />
                  </div>
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentLastName" name="agentLastName" value="<s:property value="agent.agentLastName" />" placeholder="Last Name" />
                  </div>
                </div>
                <h6 class="label">Email</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentEmailId" name="agentEmailId" value="<s:property value="agent.agentEmailId" />" placeholder="Email" />
                  </div>
                </div>
                <h6 class="label">Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentPhoneNo" name="agentPhoneNo" value="<s:property value="agent.agentPhoneNo" />" placeholder="Phone Number" onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="agentPhoneNoExtension" name="agentPhoneNoExtension" value="<s:property value="agent.agentPhoneNoExtension" />" placeholder="Ext" onkeypress="return keyRestrict(event,'int');"  />
                  </div>
                </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentAlternatePhone" name="agentAlternatePhone" value="<s:property value="agent.agentAlternatePhone" />" placeholder="Alternate Phone Number" onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="agentAlternatePhoneNoExtension" name="agentAlternatePhoneNoExtension" value="<s:property value="agent.agentAlternatePhoneNoExtension" />" placeholder="Ext"  onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <h6 class="label">Agent Market</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentMarket1" name="agentMarket1" value="<s:property value="agent.agentMarket1" />" placeholder="Agent Market 1" />
                  </div>
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentMarket2" name="agentMarket2" value="<s:property value="agent.agentMarket2" />" placeholder="Agent Market 2" />
                  </div>
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentMarket3" name="agentMarket3" value="<s:property value="agent.agentMarket3" />" placeholder="Agent Market 3" />
                  </div>
                </div>
                <h6 class="label">Address</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentAddressLine1" name="agentAddressLine1" value="<s:property value="agent.agentAddressLine1" />" placeholder="Address Line 1"  />
                  </div>
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="agentAddressLine2" name="agentAddressLine2" value="<s:property value="agent.agentAddressLine2" />" placeholder="Address Line 2"  />
                  </div>
                </div>
                <div class="row mt20">
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="agentCity" name="agentCity" value="<s:property value="agent.agentCity" />" placeholder="City"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="agentState" name="agentState" value="<s:property value="agent.agentState" />" placeholder="State"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="agentCountry" name="agentCountry" value="<s:property value="agent.agentCountry" />" placeholder="Country"  />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="agentZipcode" name="agentZipcode" value="<s:property value="agent.agentZipcode" />" placeholder="Zip" onkeypress="return keyRestrict(event,'charnum');" />
                  </div>
                </div>
                          
                <hr class="mt10" />
            <div class="clearfix"> <button type="button" class="btn btn-success btn-large" id="updateAgentButton" name="updateAgentButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>