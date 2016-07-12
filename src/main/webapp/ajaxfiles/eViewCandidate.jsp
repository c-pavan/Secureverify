<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Candidate Details</h4>
    </div>
    <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Candidate Id : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateFirstName" /> <s:property value="candidate.candidateLastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Email : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateEmailId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Phone Number : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidatePhoneNo" /> <s:property value="candidate.candidatePhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Alternate Phone Number : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateAlternatePhone" /> <s:property value="candidate.candidateAlternatePhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Skill Set : </p> <p class="viewlabeldetails"> <s:property value="skillSet.primarySkillSet"/></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="candidate.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="candidate.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>