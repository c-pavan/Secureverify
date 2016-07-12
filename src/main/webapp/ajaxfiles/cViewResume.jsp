<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Resume Details</h4>
    </div>
    <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Id : </p> <p class="viewlabeldetails"> <s:property value="candidate.candidateId" /></p></div>
       <div class="viewlabel resume-textarea">
       		<p class="labelspan">Resume : </p> <textarea id="candidateResume" name="candidateResume" disabled><s:property value="candidate.candidateResume" /></textarea>
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