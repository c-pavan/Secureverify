<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
        <h4 class="modal-title">SKILL SET Details</h4>
      </div>
      <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Skill Set Id : </p> <p class="viewlabeldetails"> <s:property value="skillSet.skillSetId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Primary Skill Set : </p> <p class="viewlabeldetails"> <s:property value="skillSet.primarySkillSet" /></p></div>
       <div class="viewlabel"><p class="labelspan">Category : </p> <p class="viewlabeldetails"> <s:property value="skillSet.skillSetCategory" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created By : </p> <p class="viewlabeldetails"> <s:property value="skillSet.createdByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="skillSet.creationDate" format="MM/dd/yyyy"  /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified By : </p> <p class="viewlabeldetails"> <s:property value="skillSet.lastModifiedByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="skillSet.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
      </div>
    </div>
  </div>