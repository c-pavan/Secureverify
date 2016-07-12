<%@ taglib prefix="s" uri="/struts-tags" %>
<% if(request.getParameter("id").toString().equals("success")) { %>
<s:property value="couponId"/>|<s:property value="couponCode"/>|<s:property value="discountAmount"/>
<%}else{%>
Invalid Coupon Code
<%}%>