<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Edit Interviewer | Secure Verify</title>
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
                  <h5 class="m0 clr-white pl25"><span>Interviewer Name</span> - Edit Details</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="updateInterviewerForm" name="updateInterviewerForm" action="updateInterviewer" method="post" onsubmit="return false;" enctype="multipart/form-data">
          		<h6 class="label">Interviewer Id</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="hinterviewerId" name="hinterviewerId" value="<s:property value="interviewer.interviewerId" />" disabled="disabled"/>
                  </div>
                </div>
          		<input type="hidden" id="interviewerId" name="interviewerId" value="<s:property value="interviewer.interviewerId" />" />
                <h6 class="label">Name</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerFirstName" name="interviewerFirstName" value="<s:property value="interviewer.interviewerFirstName" />" placeholder="First Name" />
                  </div>
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerLastName" name="interviewerLastName" value="<s:property value="interviewer.interviewerLastName" />" placeholder="Last Name" />
                  </div>
                </div>
                <h6 class="label">Email</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerEmailId" name="interviewerEmailId" value="<s:property value="interviewer.interviewerEmailId" />" placeholder="Email" />
                  </div>
                </div>
                <h6 class="label">Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerPhoneNo" name="interviewerPhoneNo" value="<s:property value="interviewer.interviewerPhoneNo" />" placeholder="Phone Number" onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="interviewerPhoneNoExtension" name="interviewerPhoneNoExtension" value="<s:property value="interviewer.interviewerPhoneNoExtension" />" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerAlternatePhone" name="interviewerAlternatePhone" value="<s:property value="interviewer.interviewerAlternatePhone" />" placeholder="Alternate Phone Number" onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="interviewerAlternatePhoneNoExtension" name="interviewerAlternatePhoneNoExtension" value="<s:property value="interviewer.interviewerAlternatePhoneNoExtension" />" placeholder="Ext" onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <h6 class="label">Skill Set</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <select id="interviewerSkillSet1" name="interviewerSkillSet1">
                      <option value="">Select</option>
                      <s:if test="skillSetList!=null && skillSetList.size>0">
	      				<s:iterator var="skillSet" value="skillSetList">
                      	<option value="<s:property value="skillSetId"/>"  <s:if test="interviewer.interviewerSkillSet1.equals(skillSetId)">selected="selected"</s:if> ><s:property value="primarySkillSet"/></option>
                      	</s:iterator>
                      </s:if>
                    </select>
                  </div>
                  <div class="col-sm-4">
                    <select id="interviewerSkillSet2" name="interviewerSkillSet2">
                      <option value="">Select</option>
                      <s:if test="skillSetList!=null && skillSetList.size>0">
	      				<s:iterator var="skillSet" value="skillSetList">
                      	<option value="<s:property value="skillSetId"/>"  <s:if test="interviewer.interviewerSkillSet2.equals(skillSetId)">selected="selected"</s:if> ><s:property value="primarySkillSet"/></option>
                      	</s:iterator>
                      </s:if>
                    </select>
                  </div>
                  <div class="col-sm-4">
                    <select id="interviewerSkillSet3" name="interviewerSkillSet3">
                      <option value="">Select</option>
                      <s:if test="skillSetList!=null && skillSetList.size>0">
	      				<s:iterator var="skillSet" value="skillSetList">
                      	<option value="<s:property value="skillSetId"/>"  <s:if test="interviewer.interviewerSkillSet3.equals(skillSetId)">selected="selected"</s:if> ><s:property value="primarySkillSet"/></option>
                      	</s:iterator>
                      </s:if>
                    </select>
                  </div>
                </div>
              <h6 class="label">Resume</h6>
              <div class="row">
                <div class="col-sm-12 resume-textarea">
                  <textarea id="interviewerResume" name="interviewerResume" disabled><s:property value="interviewer.interviewerResume" /></textarea>
                </div>
              </div> 
                <h6 class="label">Change Resume</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="file" class="form-control" id="resume" name="resume" value=""/>
                  </div>
                </div>                
                <hr class="mt10" />
            <div class="clearfix"> <button type="button" class="btn btn-success btn-large" id="updateInterviewerButton" name="updateInterviewerButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>