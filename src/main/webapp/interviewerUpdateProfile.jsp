<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Interviewer Update Profile | Secure Verify</title>
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
                  <h5 class="m0 clr-white pl25">Update Profile Details</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="interviewerUpdateProfileForm" name="interviewerUpdateProfileForm" action="interviewerUpdateProfile" method="post" onsubmit="return false;"  enctype="multipart/form-data">
                <h6 class="label">Interviewer ID</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="hinterviewerId" name="hinterviewerId" value="<s:property value="interviewer.interviewerId" />" placeholder="Interviewer ID" disabled />
                  </div>
                </div>
                <h6 class="label">Name</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerFirstName" name="interviewerFirstName" value="<s:property value="interviewer.interviewerFirstName" />" placeholder="First Name" onkeypress="return keyRestrict(event,'char');"/>
                  </div>
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerLastName" name="interviewerLastName" value="<s:property value="interviewer.interviewerLastName" />" placeholder="Last Name" onkeypress="return keyRestrict(event,'char');"/>
                  </div>
                </div>
                <h6 class="label">Email</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerEmailId" name="interviewerEmailId" value="<s:property value="interviewer.interviewerEmailId" />" placeholder="Email" disabled onkeypress="return keyRestrict(event,'emailchar');" />
                  </div>
                </div>
                <h6 class="label">Contact Number</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerPhoneNo" name="interviewerPhoneNo" value="<s:property value="interviewer.interviewerPhoneNo" />" placeholder="Phone Number"  onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="interviewerPhoneNoExtension" name="interviewerPhoneNoExtension" value="<s:property value="interviewer.interviewerPhoneNoExtension" />" placeholder="Ext"  onkeypress="return keyRestrict(event,'int');" />
                  </div>
                </div>
                <h6 class="label">Alternate Contact Number</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="interviewerAlternatePhone" name="interviewerAlternatePhone" value="<s:property value="interviewer.interviewerAlternatePhone" />" placeholder="Alternate Phone Number"  onkeypress="return keyRestrict(event,'phone');" />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="interviewerAlternatePhoneNoExtension" name="interviewerAlternatePhoneNoExtension" value="<s:property value="interviewer.interviewerAlternatePhoneNoExtension" />" placeholder="Ext"  onkeypress="return keyRestrict(event,'int');" />
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
                <h6 class="label">View Resume</h6>
                <div class="row">
                <div class="col-sm-12 resume-textarea">
                  <textarea id="hinterviewerResume" name="hinterviewerResume" disabled><s:property value="interviewer.interviewerResume" /></textarea>
                </div>
              </div> 
              <div class="row">
                <div class="col-sm-12">
                  <s:url id="interviewerResumeDownload" namespace="/" action="downloadInterviewerResume" >
                		<s:param name="interviewerId" value="interviewer.interviewerId"/>
                	</s:url>
                  	<s:a href="%{interviewerResumeDownload}" cssClass="btn btn-success mt10" >Download Resume of <s:property value="interviewer.interviewerFirstName" /> <i class="fa fa-download"></i></s:a>
                </div>
              </div>
                <h6 class="label">Update Resume</h6>                
                <div class="row">
                  <div class="col-sm-4">
                    <input type="file" class="form-control" id="resume" name="resume">
                  </div>
                </div>
            <div class="clearfix"> 
            <hr class="mt10" />
            <button type="button" class="btn btn-success btn-large" id="interviewerUpdateProfileButton" name="interviewerUpdateProfileButton" >Update Profile &nbsp;<i class="fa fa-caret-right"></i></button>
            </div>
            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>