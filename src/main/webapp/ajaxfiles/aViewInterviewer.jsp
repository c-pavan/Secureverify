<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Interviewer Details</h4>
    </div>
    <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Interviewer Id : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerFirstName" /> <s:property value="interviewer.interviewerLastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Email : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerEmailId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Phone Number : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerPhoneNo" />&nbsp; <s:property value="interviewer.interviewerPhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Alternate Phone Number : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerAlternatePhone" />&nbsp; <s:property value="interviewer.interviewerAlternatePhoneNoExtension" /></p></div>
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
       
       <div class="viewlabel resume-textarea">
	   		<p class="labelspan">Resume : </p> <textarea id="interviewerResume" name="interviewerResume" disabled><s:property value="interviewer.interviewerResume" /></textarea>
	   		<s:url id="interviewerResumeDownload" namespace="/" action="downloadInterviewerResume" >
	            <s:param name="interviewerId" value="interviewer.interviewerId"/>
	        </s:url>
	        <s:a href="%{interviewerResumeDownload}" cssClass="btn btn-default mt10" >Download Resume of <s:property value="interviewer.interviewerFirstName" /> <i class="fa fa-download"></i></s:a>
       </div>
       <div class="viewlabel"><p class="labelspan">Created By : </p> <p class="viewlabeldetails"> <s:property value="interviewer.createdByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="interviewer.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified By : </p> <p class="viewlabeldetails"> <s:property value="interviewer.lastModifiedByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="interviewer.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
      
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>