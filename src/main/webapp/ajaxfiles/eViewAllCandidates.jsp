<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Properties, com.secureVerify.util.Helper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% Properties properties = Helper.getPropertiesFromFile(); %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Candidate Interview Details</h4>
    </div>
    <div class="modal-body viewform">
    <div class="col-md-7 col-sm-5 p0">
       <h5>Schedule Details</h5>
       <div class="viewlabel"><p class="labelspan">Zip Code : </p> <p class="viewlabeldetails"> <s:property value="location.locationZipcode" /></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled Location : </p> <p class="viewlabeldetails"> <s:property value="location.locationName"/></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled From Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled To Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       </div>
       
       <!-- only after feedback Start -->
       <div class="col-md-4 col-sm-4 ">
       <canvas id="myCanvas" width="318" height="200"></canvas>
					<script>
				     image = new Image();
				     var canvas = document.getElementById("myCanvas"); var context = canvas.getContext("2d");  var hcandidatePerformance = '<s:property value="candidateScheduleTiming.candidatePerformance"/>';
				     if(hcandidatePerformance=='1'){ image.src = '<%=properties.getProperty("CONTEXT_PATH").toString() %>img/certificate-best.jpg'; }
				     else if(hcandidatePerformance=='2'){ image.src = '<%=properties.getProperty("CONTEXT_PATH").toString() %>img/certificate-good.jpg'; }
				     else if(hcandidatePerformance=='3'){image.src = '<%=properties.getProperty("CONTEXT_PATH").toString() %>img/certificate-average.jpg'; }
				     else if(hcandidatePerformance=='4'){ image.src = '<%=properties.getProperty("CONTEXT_PATH").toString() %>img/certificate-not-qualified.jpg'; }
					 var skillSet = "<s:property value="skillSet.primarySkillSet"/>"; 
					 var verificationId = "<s:property value="candidateScheduleTiming.candidateUniqueId"/>";
				     image.onload = function(){
						context.drawImage(image, 0, 0);
				        context.font = '15pt Arial '; context.fillStyle = "#fff"; context.textAlign = 'left'; context.fillText(skillSet,15,157);
						context.font = '15pt Arial'; context.fillStyle = "#fff"; context.textAlign = 'left'; context.fillText(verificationId,49,190);
				     };
				</script>
       </div>
       <div class="clear"></div>       
       <h5>Feedback of Candidate</h5>
       <div class="feedback-blocks-parent">
       <s:if test="feedbackList!=null && feedbackList.size>0">
       <s:iterator var="feedback" value="feedbackList">
       <div class="feedback-blocks">
       <div class="viewlabel">
	       <p class="labelspan">Candidate Performance : </p> 
	       <p class="viewlabeldetails">
	       	<select id="candidatePerformance" name="candidatePerformance" disabled>
                 <option value="<s:property value="candidateScheduleTiming.candidatePerformance"/>" selected="selected">
                 	<s:if test="performance==1">Best</s:if>
	                <s:elseif test="performance==2">Good</s:elseif>
	                <s:elseif test="performance==3">Average</s:elseif>
	                <s:elseif test="performance==4">Not Qualified</s:elseif>
                 </option>
               </select>
	       </p>
       </div>
       <div class="viewlabel">
       		<p class="labelspan">Feedback : </p>
       		<p class="feedbackblock"><s:property value="feedbackText" /></p> 
       </div>
       <div class="viewlabel"><p class="labelspan">Feedback Time: </p> <p class="viewlabeldetails"> <s:date name="createdTime" format="MM/dd/yyyy hh:mm:ss a"/></p></div>
       </div>
       </s:iterator>
       </s:if>
       </div>
       
       <!-- only after Interviewer picks Start -->
       <h5>Interviewer Details</h5>
       <div class="viewlabel"><p class="labelspan">Interviewer Id : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="interviewer.interviewerFirstName" /> <s:property value="interviewer.interviewerLastName" /></p></div>
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
       <!-- only after Interviewer picks End -->
       
       <!-- only after feedback End -->
       
       <h5>Candidate Details</h5>
       <div class="viewlabel"><p class="labelspan">Interviewer Id : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateFirstName" /> <s:property value="candidate.candidateLastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Email : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateEmailId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Phone Number : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidatePhoneNo" /> <s:property value="candidate.candidatePhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Alternate Phone Number : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateAlternatePhone" /> <s:property value="candidate.candidateAlternatePhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Skill Set : </p> <p class="viewlabeldetails"> <s:property value="skillSet.primarySkillSet"/></p></div>
       <div class="viewlabel resume-textarea">
       		<p class="labelspan">Resume : </p> <textarea id="interviewerResume" name="interviewerResume" disabled><s:property value="candidate.candidateResume" /></textarea>
       		<s:url id="candidateResumeDownload" namespace="/" action="downloadCandidateResume" >
            	<s:param name="candidateId" value="candidate.candidateId"/>
            </s:url>
            <s:a href="%{candidateResumeDownload}" cssClass="btn btn-default mt10" >Download Resume of <s:property value="candidate.candidateFirstName" /> <i class="fa fa-download"></i></s:a>
       </div>
       <hr/>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>