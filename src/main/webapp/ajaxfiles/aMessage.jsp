<%@ taglib prefix="s" uri="/struts-tags" %>
<% if(request.getParameter("id").toString().equals("success")) { %>
<s:if test="hasActionMessages()">
<s:actionmessage/>
</s:if>
<%}else{%>
<s:if test="hasActionErrors()">
<s:actionerror/>
</s:if>
<%}%>