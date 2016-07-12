<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Candidate Scheduled Interviews</h4>
    </div>
    <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Interviewer Name : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerFirstName" /> <s:property value="interviewer.interviewerLastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Skill Set : </p> <p class="viewlabeldetails"> <s:property value="skillSet.primarySkillSet"/></p></div>
       <div class="viewlabel"><p class="labelspan">Selected Location : </p> <p class="viewlabeldetails"> <s:property value="location.locationName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled Timings : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /> - <s:date name="candidateScheduleTiming.candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>