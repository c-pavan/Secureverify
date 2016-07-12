<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% if(request.getParameter("id").toString().equals("success")) { %>
<option value="">Near Locations</option>
<s:if test="locationList!=null && locationList.size>0">
<s:iterator var="location" value="locationList">
<option value="<s:property value="#location.locationId"/>" ><s:property value="#location.locationName" /></option>
</s:iterator>
</s:if>
<%}else{%>
<option value="">Near Locations</option>
<%}%>