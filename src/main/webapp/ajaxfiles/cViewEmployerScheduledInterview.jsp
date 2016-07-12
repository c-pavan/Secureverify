<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Properties, com.secureVerify.util.Helper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% Properties properties = Helper.getPropertiesFromFile(); %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Employer Scheduled Interview</h4>
    </div>
    <div class="modal-body viewform">
       <div class="col-md-7 col-sm-5 p0">
       <div class="viewlabel"><p class="labelspan">Employer Name : </p> <p class="viewlabeldetails"> <s:property value="employer.employerFirstName" /> <s:property value="employer.employerLastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Employer Title : </p> <p class="viewlabeldetails"> <s:property value="employer.employerTitle" /></p></div>
       <div class="viewlabel"><p class="labelspan">Employer Company Name : </p> <p class="viewlabeldetails"> <s:property value="employer.employerCompanyName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Skill Set : </p> <p class="viewlabeldetails"> <s:property value="skillSet.primarySkillSet"/></p></div>
       <div class="viewlabel"><p class="labelspan">Selected Location : </p> <p class="viewlabeldetails"> <s:property value="location.locationName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Scheduled Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /><br/> - <s:date name="candidateScheduleTiming.candidateScheduleToTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
       </div>
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
       <div class="feedback-blocks-parent">
       <s:if test="feedbackList!=null && feedbackList.size>0">
       <s:iterator value="feedbackList" var="feedback">
       <div class="feedback-blocks">
       <div class="viewlabel"><p class="labelspan">Candidate Performance : </p> 
       <p class="viewlabeldetails">
       <select id="candidatePerformance" name="candidatePerformance" disabled>
                 <option value="<s:property value="performance"/>" selected="selected">
                 	<s:if test="performance==1">Best</s:if>
	                <s:elseif test="performance==2">Good</s:elseif>
	                <s:elseif test="performance==3">Average</s:elseif>
	                <s:elseif test="performance==4">Not Qualified</s:elseif>
                 </option>
               </select> 
       </p>
       </div>
       <div class="viewlabel">
       <p class="labelspan">Candidate Feedback : </p> 
       <p class="feedbackblock"><s:property value="feedbackText" /></p> 
       </div>
       <div class="viewlabel"><p class="labelspan">Feedback Time: </p> <p class="viewlabeldetails"> <s:date name="createdTime" format="MM/dd/yyyy hh:mm:ss a"/></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
       </div>
       </s:iterator>
       </s:if>
       </div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>