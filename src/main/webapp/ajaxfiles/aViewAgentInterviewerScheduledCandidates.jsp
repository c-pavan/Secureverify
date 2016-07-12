<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Candidate Scheduled for Interview Details</h4>
    </div>
    <div class="modal-body viewform">
       <h5>Interviewer Details</h5>
       <div class="viewlabel"><p class="labelspan">Interviewer Id : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerFirstName" /> <s:property value="interviewer.interviewerLastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Email : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerEmailId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Phone Number : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerPhoneNo" /> <s:property value="interviewer.interviewerPhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Alternate Phone Number : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerAlternatePhone" /> <s:property value="interviewer.interviewerAlternatePhoneNoExtension" /></p></div>
       <div class="viewlabel">
       		<p class="labelspan">Skill Set : </p> 
       		<p class="viewlabeldetails">
                    <select id="interviewerSkillSet1" name="interviewerSkillSet1" disabled>
                      <option value="">Select</option>
                      <s:if test="skillSetList!=null && skillSetList.size>0">
	      				<s:iterator var="skillSet" value="skillSetList">
                      	<option value="<s:property value="skillSetId"/>"  <s:if test="interviewer.interviewerSkillSet1.equals(skillSetId)">selected="selected"</s:if> ><s:property value="primarySkillSet"/></option>
                      	</s:iterator>
                      </s:if>
                    </select>
                    <select id="interviewerSkillSet2" name="interviewerSkillSet2" disabled>
                      <option value="">Select</option>
                      <s:if test="skillSetList!=null && skillSetList.size>0">
	      				<s:iterator var="skillSet" value="skillSetList">
                      	<option value="<s:property value="skillSetId"/>"  <s:if test="interviewer.interviewerSkillSet2.equals(skillSetId)">selected="selected"</s:if> ><s:property value="primarySkillSet"/></option>
                      	</s:iterator>
                      </s:if>
                    </select>
                    <select id="interviewerSkillSet3" name="interviewerSkillSet3" disabled>
                      <option value="">Select</option>
                      <s:if test="skillSetList!=null && skillSetList.size>0">
	      				<s:iterator var="skillSet" value="skillSetList">
                      	<option value="<s:property value="skillSetId"/>"  <s:if test="interviewer.interviewerSkillSet3.equals(skillSetId)">selected="selected"</s:if> ><s:property value="primarySkillSet"/></option>
                      	</s:iterator>
                      </s:if>
                    </select>
       		</p>
       </div>
       <h5>Candidate Details</h5>
       <div class="viewlabel"><p class="labelspan">Interviewer Id : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateFirstName" /> <s:property value="candidate.candidateLastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Email : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateEmailId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Phone Number : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidatePhoneNo" /> <s:property value="candidate.candidatePhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Alternate Phone Number : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateAlternatePhone" /> <s:property value="candidate.candidateAlternatePhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Skill Set : </p> <p class="viewlabeldetails"> <s:property value="skillSet.primarySkillSet"/></p></div>
       <h5>Schedule Details</h5>
       <div class="viewlabel"><p class="labelspan">Zip Code : </p> <p class="viewlabeldetails"> <s:property value="location.locationZipcode" /></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled Location : </p> <p class="viewlabeldetails"> <s:property value="location.locationName"/></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled From Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled To Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       <hr/>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
       
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>