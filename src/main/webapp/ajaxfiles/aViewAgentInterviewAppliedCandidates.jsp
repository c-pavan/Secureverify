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
       <div class="viewlabel"><p class="labelspan">Zip Code : </p> <p class="viewlabeldetails"> <s:property value="location.locationZipcode" /></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled Location : </p> <p class="viewlabeldetails"> <s:property value="location.locationName"/></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled From Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled To Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       <div class="viewlabel resume-textarea">
       		<p class="labelspan">Resume : </p> <textarea id="interviewerResume" name="interviewerResume" disabled><s:property value="candidate.candidateResume" /></textarea>
       		<s:url id="candidateResumeDownload" namespace="/" action="downloadCandidateResume" >
                		<s:param name="candidateId" value="candidate.candidateId"/>
                	</s:url>
                  	<s:a href="%{candidateResumeDownload}" cssClass="btn btn-default mt10" >Download Resume of <s:property value="candidate.candidateFirstName" /> <i class="fa fa-download"></i></s:a>
       </div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>