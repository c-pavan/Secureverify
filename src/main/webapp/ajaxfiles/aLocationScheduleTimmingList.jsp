<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% if(request.getParameter("id").toString().equals("success")) { %>
<option value="">Select Schedule Time</option>
<s:if test="locationScheduleTimingList!=null && locationScheduleTimingList.size>0">
<s:iterator var="locationScheduleTiming" value="locationScheduleTimingList">
<option value="<s:property value="#locationScheduleTiming.locationScheduleTimingId"/>" <s:if test="#locationScheduleTiming.locationScheduleTimingId.equals(candidateScheduleTiming.locationScheduleTimingId)">selected="selected"</s:if> ><s:date name="#locationScheduleTiming.locationScheduleFromTime" format="MM/dd/yyyy hh:mm a" /> - <s:date name="#locationScheduleTiming.locationScheduleToTime" format="MM/dd/yyyy hh:mm a" /></option>
</s:iterator>
</s:if>
<%}else{%>
<option value="">Select Schedule Time</option>
<%}%>