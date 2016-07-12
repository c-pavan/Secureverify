<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Candidate Details</h4>
    </div>
    <div class="modal-body">
      <form id="#" name="#" action="#" method="get">
            <h6 class="label">Candidate Id</h6>
                <div class="row">
               <div class="col-sm-6">
                    <input type="text" class="form-control" id="candidateId" name="candidateId"  value="<s:property value="candidate.candidateId" />"  disabled />
                  </div>
             </div>
		<div class="row">
                <div class="col-sm-4">
              <h6 class="label">Scheduled Date</h6>
                  <input type="text" class="form-control" id="candidateScheduledDate" name="candidateScheduledDate" value="<s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" />" disabled />
                </div>
                <div class="col-sm-4">
              <h6 class="label">Scheduled Time</h6>
                  <input type="text" class="form-control" id="candidateScheduledTime" name="candidateScheduledTime" value="<s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" />" disabled />
                </div>
              </div>
              <h6 class="label">Name</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateFirstName" name="candidateFirstName" value="<s:property value="candidate.candidateFirstName" />"  disabled />
                </div>
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="candidateLastName" name="candidateLastName" value="<s:property value="candidate.candidateLastName" />" disabled />
                </div>
              </div>
             <h6 class="label">Skill Set</h6>
              <div class="row">
                <div class="col-sm-4">
                  <select id="candidateSkillSet" name="candidateSkillSet" disabled>
                    <option value="<s:property value="skillSet.primarySkillSet"/>" selected="selected"><s:property value="skillSet.primarySkillSet"/></option>
                  </select>
                </div>
               </div>
              <h6 class="label">Resume</h6>
              <div class="row">
                <div class="col-sm-12 resume-textarea">
                  <textarea id="candidateResume" name="candidateResume" disabled><s:property value="candidate.candidateResume" /></textarea>
                </div>
              </div> 
              <div class="row">
                <div class="col-sm-12">
                  <s:url id="candidateResumeDownload" namespace="/" action="downloadCandidateResume" >
                		<s:param name="candidateId" value="candidate.candidateId"/>
                	</s:url>
                  	<s:a href="%{candidateResumeDownload}" class="btn btn-default mt10" >Download Resume of <s:property value="candidate.candidateFirstName" /> <i class="fa fa-download"></i></s:a>
                </div>
              </div>
		   </form>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>