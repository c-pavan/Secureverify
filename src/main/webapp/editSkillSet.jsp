<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Edit Skill Set | Secure Verify</title>
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
                  <h5 class="m0 clr-white pl25">Edit Skillset</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
          <form id="updateSkillSetForm" name="updateSkillSetForm" action="updateSkillSet" method="post" onsubmit="return false;">
               <h6 class="label">Skill Set Id</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="hskillSetId" name="hskillSetId" value="<s:property value="skillSet.skillSetId"/>" disabled="disabled" />
                    <input type="hidden" id="skillSetId" name="skillSetId" value="<s:property value="skillSet.skillSetId"/>" />
                  </div>
                </div>
                <h6 class="label">Primary Skill Set</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <input type="text" class="form-control" id="primarySkillSet" name="primarySkillSet" value="<s:property value="skillSet.primarySkillSet"/>" placeholder="Primary Skill Set" />
                  </div>
                </div>
                 <h6 class="label">Category</h6>
                <div class="row">
                  <div class="col-sm-4">
                    <select name="skillSetCategory" id="skillSetCategory">
                       <option value="">Select</option>
                      <option value="General" <s:if test="skillSet.skillSetCategory.equals('General')">selected="selected"</s:if> >General</option>
                      <option value="IT" <s:if test="skillSet.skillSetCategory.equals('IT')">selected="selected"</s:if> >IT</option>
                     </select>
                  </div>
                  </div>
                   <hr class="mt10" />
            <div class="clearfix"> <button type="button" class="btn btn-success btn-large" id="updateSkillSetButton" name="updateSkillSetButton" >Update Details &nbsp;<i class="fa fa-caret-right"></i></button></div>
             </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>