<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Schedule Timings Details</h4>
    </div>
    <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Location Name : </p> <p class="viewlabeldetails"> <s:property value="location.locationName" /></p></div>
       <div class="viewlabel"><p class="labelspan">From : </p> <p class="viewlabeldetails"> <s:date name="locationScheduleTiming.locationScheduleFromTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       <div class="viewlabel"><p class="labelspan">To : </p> <p class="viewlabeldetails"> <s:date name="locationScheduleTiming.locationScheduleToTime" format="MM/dd/yyyy hh:mm a" /></p></div>
       <div class="viewlabel"><p class="labelspan">Timings Added by : </p> <p class="viewlabeldetails"> <s:property value="locationScheduleTiming.lastModifiedByName" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="locationScheduleTiming.creationDate" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="locationScheduleTiming.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" /></p></div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>