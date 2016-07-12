<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Employer Details</h4>
    </div>
    <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Employer Id : </p> <p class="viewlabeldetails"> <s:property value="employer.employerId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Name : </p> <p class="viewlabeldetails"> <s:property value="employer.employerFirstName" /> <s:property value="employer.employerLastName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Email : </p> <p class="viewlabeldetails"> <s:property value="employer.employerEmailId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Phone Number : </p> <p class="viewlabeldetails"> <s:property value="employer.employerPhoneNo" />&nbsp; <s:property value="employer.employerPhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Alternate Phone Number : </p> <p class="viewlabeldetails"> <s:property value="employer.employerAlternatePhone" />&nbsp; <s:property value="employer.employerAlternatePhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Company Name : </p> <p class="viewlabeldetails"> <s:property value="employer.employerCompanyName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Title : </p> <p class="viewlabeldetails"> <s:property value="employer.employerTitle" /></p></div>
       <div class="viewlabel"><p class="labelspan">Address : </p> <p class="viewlabeldetails"> <s:property value="employer.employerAddressLine1" />, <s:property value="employer.employerAddressLine2" />, <s:property value="employer.employerCity" />, <s:property value="employer.employerState" />, <s:property value="employer.employerCountry" />, <s:property value="employer.employerZipcode" /></p></div>
       <div class="viewlabel"><p class="labelspan">Status : </p> <p class="viewlabeldetails"> <s:if test="status==1">ACTIVE</s:if><s:else>IN ACTIVE</s:else></p></div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>