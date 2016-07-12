<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Candidate Details | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body>
<div id="main-wrapper" class="candidate-feedback-page">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
        <div class="col-md-10 col-sm-10 block-center">
          <ul class="one-step one clearfix">
            <li class="active">Candidate Details</li>
          </ul>
          <div class="white-container faq">
            <% if(request.getParameter("id").toString().equals("success")) { %>
				<div class="modal-body viewform candidatefeedback">
			       <div class="col-md-7 col-sm-5 p0">
			       <div class="viewlabel"><p class="labelspan">Verification Id : </p> <p class="viewlabeldetails"> <s:property value="candidateScheduleTiming.candidateUniqueId" /></p></div>
			       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateFirstName" /> <s:property value="candidate.candidateLastName" /></p></div>
			       <div class="viewlabel"><p class="labelspan">Skill Set : </p> <p class="viewlabeldetails"> <s:property value="skillSet.primarySkillSet"/></p></div>
			       <div class="viewlabel"><p class="labelspan">Location : </p> <p class="viewlabeldetails"> <s:property value="location.locationName" /></p></div>
			       <div class="viewlabel"><p class="labelspan">Scheduled Date : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></p></div>
			       <div class="viewlabel"><p class="labelspan">Scheduled Time : </p> <p class="viewlabeldetails"> <s:date name="candidateScheduleTiming.candidateScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></p></div>
			       </div>
			       <div class="col-md-4 col-sm-4 p0">
              		<canvas id="myCanvas" width="318" height="200"></canvas>
					<script>
				     window.onload = function(){
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
            </div>
            
			<%}else{%>
			<h5 class="text-center normal-texttransform">Candidate with Verification Id <span> "<s:property value="candidateUniqueId"/>" </span> does not Exist. <br/><br/><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>home">Go to Home Page</a> and check Again</h5>
			<%}%>
            
            
            
            <div class="clear"></div>
		    
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>