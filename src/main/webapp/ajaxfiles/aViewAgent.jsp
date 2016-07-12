<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
        <h4 class="modal-title">Agent Details</h4>
      </div>
      <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Agent Id : </p> <p class="viewlabeldetails"> <s:property value="agent.agentId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="agent.agentFirstName" /> <s:property value="agent.agentLastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Email : </p> <p class="viewlabeldetails"> <s:property value="agent.agentEmailId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Phone Number : </p> <p class="viewlabeldetails"> <s:property value="agent.agentPhoneNo" />&nbsp; <s:property value="agent.agentPhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Alternate Phone Number : </p> <p class="viewlabeldetails"> <s:property value="agent.agentAlternatePhone" />&nbsp; <s:property value="agent.agentAlternatePhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Agent Market : </p> <p class="viewlabeldetails"> <s:property value="agent.agentMarket1" />, <s:property value="agent.agentMarket2" />, <s:property value="agent.agentMarket3" /></p></div>
       <div class="viewlabel"><p class="labelspan">Address : </p> <p class="viewlabeldetails"> <s:property value="agent.agentAddressLine1" />, <s:property value="agent.agentAddressLine2" />, <s:property value="agent.agentCity" />, <s:property value="agent.agentState" />, <s:property value="agent.agentCountry" />, <s:property value="agent.agentZipcode" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created By : </p> <p class="viewlabeldetails"> <s:property value="agent.createdByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="agent.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified By : </p> <p class="viewlabeldetails"> <s:property value="agent.lastModifiedByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="agent.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
      </div>
    </div>
  </div>