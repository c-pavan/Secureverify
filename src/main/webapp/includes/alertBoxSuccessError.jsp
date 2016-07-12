<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="hasActionMessages()">
	<div class="alertbox" id="actionmessage" >
	  <div class="alertbox-text">
	    <button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="$('#actionmessage').hide();">×</button>
	  	<div class="successblock">
			<s:actionmessage/>
		</div>
	  </div>
	</div>
</s:if>
<s:if test="hasActionErrors()">
	<div class="alertbox" id="actionerror" >
	  <div class="alertbox-text">
	    <button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="$('#actionerror').hide();">×</button>
	  	<div class="errorblock">
			<p>Please check the following errors :</p>
			<s:actionerror/>
		</div>
	  </div>
	</div>
</s:if>

<div class="alertbox" id="success" >
  <div class="alertbox-text">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="$('#sMsg').html(''); $('#success').hide();">×</button>
    <div id="sMsg"></div>
  </div>
</div>
<div class="alertbox" id="failure">
  <div class="alertbox-text">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="$('#eMsg').html(''); $('#failure').hide();">×</button>
    <h5>Please check for the errors below</h5>
    <hr/>
    <div id="eMsg"></div>
  </div>
</div>