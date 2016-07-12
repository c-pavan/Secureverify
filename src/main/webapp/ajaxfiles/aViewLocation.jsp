<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
        <h4 class="modal-title">Location Details</h4>
      </div>
      <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Location Id : </p> <p class="viewlabeldetails"> <s:property value="location.locationId" /></p></div>
       <div class="viewlabel"><p class="labelspan">Location Name : </p> <p class="viewlabeldetails"> <s:property value="location.locationName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Business Name : </p> <p class="viewlabeldetails"> <s:property value="location.locationBusinessName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Address : </p> <p class="viewlabeldetails"> <s:property value="location.locationAddressLine1" />, <s:property value="location.locationAddressLine2" />, <s:property value="location.locationCity" />, <s:property value="location.locationState" />, <s:property value="location.locationCountry" />, <s:property value="location.locationZipcode" /></p></div>
       <div class="viewlabel"><p class="labelspan">Latitude : </p> <p class="viewlabeldetails"> <s:property value="location.latitude" /></p></div>
       <div class="viewlabel"><p class="labelspan">Longitude : </p> <p class="viewlabeldetails"> <s:property value="location.longitude" /></p></div>
       <div class="viewlabel"><p class="labelspan">Phone Number : </p> <p class="viewlabeldetails"> <s:property value="location.locationPhoneNo" />&nbsp; <s:property value="location.locationPhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Alternate Phone Number : </p> <p class="viewlabeldetails"> <s:property value="location.locationAlternatePhone" />&nbsp; <s:property value="location.locationAlternatePhoneNoExtension" /></p></div>
       <div class="viewlabel"><p class="labelspan">Primary Agent : </p> <p class="viewlabeldetails"> <s:property value="location.locationPrimaryAgentName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Secondary Agent : </p> <p class="viewlabeldetails"> <s:property value="location.locationSecondaryAgentName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created By : </p> <p class="viewlabeldetails"> <s:property value="location.createdByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="location.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified By : </p> <p class="viewlabeldetails"> <s:property value="location.lastModifiedByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="location.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
      </div>
    </div>
  </div>