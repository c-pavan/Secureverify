<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Edit Profile | Secure Verify</title>
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
                <div class="col-sm-10 no-padding">
                  <h5 class="m0 clr-white pl25">Edit Profile Details</h5>
                </div>
              </div>
            </div>
            <form class="clear pt5" id="updateAdminForm" name="updateAdminForm" action="updateAdmin" method="post" onsubmit="return false;">
                
                <h6 class="label">Admin ID</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="huserId" name="huserId" value="<s:property value="user.userId" />"  disabled/>
                    <input type="hidden" id="userId" name="userId" value="<s:property value="user.userId" />" />
                  </div>
                </div>
                <h6 class="label">Name</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="userFirstName" name="userFirstName" value="<s:property value="user.userFirstName" />"  placeholder="First Name" onkeypress="return keyRestrict(event,'char');"/>
                  </div>
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="userLastName" name="userLastName" value="<s:property value="user.userLastName" />" placeholder="Last Name" onkeypress="return keyRestrict(event,'char');"/>
                  </div>
                </div>
                <h6 class="label">Email</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="userEmailId" name="userEmailId" value="<s:property value="user.userEmailId" />" placeholder="Email" onkeypress="return keyRestrict(event,'emailchar');"/>
                  </div>
                </div>
                <h6 class="label">Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="userPhoneNo" name="userPhoneNo" value="<s:property value="user.userPhoneNo" />" placeholder="Mobile" onkeypress="return keyRestrict(event,'phone');"  />
                  </div>
                </div>
                <h6 class="label">Address</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="userAddressLine1" name="userAddressLine1" value="<s:property value="user.userAddressLine1" />" placeholder="Address Line 1"  />
                  </div>
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="userAddressLine2" name="userAddressLine2" value="<s:property value="user.userAddressLine2" />" placeholder="Address Line 2"  />
                  </div>
                </div>
                <div class="row pt15">
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="userCity" name="userCity" value="<s:property value="user.userCity" />" placeholder="City"  />
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="userState" name="userState" value="<s:property value="user.userState" />" placeholder="State"  />
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="userCountry" name="userCountry" value="<s:property value="user.userCountry" />" placeholder="Country"  />
                  </div>
                  <div class="col-sm-2 pr0">
                    <input type="text" class="form-control" id="userZipcode" name="userZipcode" value="<s:property value="user.userZipcode" />" placeholder="Zip" onkeypress="return keyRestrict(event,'charnum');"  />
                  </div>
                </div>   
                <h6 class="label">Designation</h6>
                <div class="row">
                  <div class="col-sm-4 pr0">
                    <input type="text" class="form-control" id="userDesignation" name="userDesignation" value="<s:property value="user.userDesignation" />" placeholder="Designation"  />
                  </div>
                </div>
            <button type="button" class="btn btn-success btn-large mt10" id="updateAdminButton" name="updateAdminButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button>
       
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>