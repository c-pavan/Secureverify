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
                    <input type="text" class="form-control" id="candidateId" name="candidateId" value="<s:property value="candidate.candidateId" />" disabled />
                  </div>
             </div>
                <div class="row">
                 <div class="col-sm-6">
                 <h6 class="label">Candidate Performance</h6>
                    <select id="candidatePerformance" name="candidatePerformance" disabled>
                      <option value="<s:property value="candidateScheduleTiming.candidatePerformance"/>" selected="selected">
                      	<s:if test="candidateScheduleTiming.candidatePerformance==1">Best</s:if>
	                    <s:elseif test="candidateScheduleTiming.candidatePerformance==2">Good</s:elseif>
	                    <s:elseif test="candidateScheduleTiming.candidatePerformance==3">Average</s:elseif>
	                    <s:elseif test="candidateScheduleTiming.candidatePerformance==4">Not Qualified</s:elseif>
                      </option>
                    </select>
                 </div>
               </div> 
               
              <div class="row">    
                <div class="col-sm-12">
              <h6 class="label">Feedback</h6> 
                  <textarea rows="7"  id="candidateFeedback" name="candidateFeedback" disabled><s:property value="candidateScheduleTiming.candidateFeedback" /></textarea>
                </div>
               </div>
              <div class="row">    
                <div class="col-sm-12">
              <h6 class="label">Certificates</h6> 
              <div class="col-sm-4">
                <img src="img/certification2.jpg" alt="certification2" />
              </div>
                </div>
               </div>
               <hr/>
               
               
            <h5>Candidate Details</h5>
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
                  <select id="" name="" disabled>
                    <option value="<s:property value="skillSet.primarySkillSet"/>" selected="selected"><s:property value="skillSet.primarySkillSet"/></option>
                  </select>
                </div>
               </div>
                <hr/>
            <h5>Interviewer Details</h5>
                
              <h6 class="label">Name</h6>
              <div class="row">
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="interviewerFirstName" name="interviewerFirstName" value="<s:property value="interviewer.interviewerFirstName" />"  disabled />
                </div>
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="interviewerLastName" name="interviewerLastName" value="<s:property value="interviewer.interviewerLastName" />" disabled />
                </div>
              </div>
              
              <h6 class="label">Skill Set</h6>
              <div class="row">
                <div class="col-sm-4">
                  <select id="" name="" disabled>
                    <option value="<s:property value="interviewer.interviewerSkillSet1"/>" selected="selected"><s:property value="interviewer.interviewerSkillSet1"/></option>
                  </select>
                </div>
                <div class="col-sm-4">
                  <select id="" name="" disabled>
                    <option value="<s:property value="interviewer.interviewerSkillSet2"/>" selected="selected"><s:property value="interviewer.interviewerSkillSet2"/></option>
                </select>
                </div>
                <div class="col-sm-4">
                  <select id="" name="" disabled>
                    <option value="<s:property value="interviewer.interviewerSkillSet3"/>" selected="selected"><s:property value="interviewer.interviewerSkillSet3"/></option>
                  </select>
                </div>
              </div>
                <hr/>
            <h5>Scheduled Location</h5>
              <div class="row">
                <div class="col-sm-6">
              		<h6 class="label">Zip Code</h6>
                    <div class="input-group">
	                  <input type="text" class="form-control" id="locationZipcode" name="locationZipcode" value="<s:property value="location.locationZipcode" />" placeholder="Zip" disabled />
	                   
	                </div>                    
                </div>
              </div>
				<div class="row">
                <div class="col-sm-6">
              <h6 class="label">Scheduled Location</h6>
                    <select name="" id="" disabled>
                    	<option value="<s:property value="location.locationName"/>" selected="selected"><s:property value="location.locationName"/></option>
                    </select> 
                </div>
                </div>
                <div class="row">
                <div class="col-sm-6">
              		<h6 class="label">Scheduled From Time</h6>
                  	<input type="text" class="form-control" id="candidateScheduleFromTime" name="candidateScheduleFromTime" value="<s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" />" disabled/>
                </div>
                <div class="col-sm-6">
              		<h6 class="label">Scheduled To Time</h6>
                  	<input type="text" class="form-control" id="candidateScheduleToTime" name="candidateScheduleToTime" value="<s:date name="candidateScheduleTiming.candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" />" disabled/>
                </div>
               </div>
              
		   </form>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>