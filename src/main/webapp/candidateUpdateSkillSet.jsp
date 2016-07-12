<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Update Skillset | Secure Verify</title>
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
        <%@include file="includes/candidateLeftMenu.jsp"%>
        
        <!-- left main end -->
        <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Update Skillset</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="candidateUpdatePasswordForm" name="candidateUpdatePasswordForm" action="updateCandidatePassword" method="post" onsubmit="return false;">
              <div class="row">
              	<div class="col-sm-12 p0">
                <div class="col-sm-4">
                  <h6 class="label">Primary Skillset</h6>
                  <select id="skillSetId" name="skillSetId">
                      <option value="">Select</option>
                      <s:if test="skillSetList!=null && skillSetList.size>0">
	      				<s:iterator var="skillSet" value="skillSetList">
                      		<option value="<s:property value="skillSetId" />" ><s:property value="primarySkillSet" /></option>
                      	</s:iterator>
                      </s:if>
                    </select>
                    </div>
                    </div>
                  <div class="col-sm-12 p0">
                  <div class="col-sm-6">
                  <h6 class="label">Other Skillsets</h6>
                  </div>
                    </div>
                  <div class="col-sm-12 p0">
                    <div class="col-sm-4">
                    <select id="" name="">
                      <option value="">skillset 1</option>	      				
                      <option value="" >English, Telugu, Hindi</option>
                      <option value="" >C, C++, Java Script</option>
                      <option value="" >Java, J2ee, Spring, Hibernate</option>
                    </select>
                    </div>
                    <div class="col-sm-4">
                    <select id="" name="">
                      <option value="">skillset 2</option>	      				
                      <option value="" >English, Telugu, Hindi</option>
                      <option value="" >C, C++, Java Script</option>
                      <option value="" >Java, J2ee, Spring, Hibernate</option>
                    </select>
                    </div>
                    
                    <div class="col-sm-4">
                    <select id="" name="">
                      <option value="">skillset 3</option>	      				
                      <option value="" >English, Telugu, Hindi</option>
                      <option value="" >C, C++, Java Script</option>
                      <option value="" >Java, J2ee, Spring, Hibernate</option>
                    </select>
                    </div>
                    </div>
                  <div class="clear"></div>
                  <div class="col-sm-4 mt10">
                  <button type="button" class="btn btn-success btn-large" id="" name="" >Update Skillset</button>
                  </div>
                </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>