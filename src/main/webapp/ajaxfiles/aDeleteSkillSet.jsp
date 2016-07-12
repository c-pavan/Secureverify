<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
        <h4 class="modal-title">Are You Sure Want to Delete ?</h4>
      </div>
      <div class="modal-body">
        <form id="deleteSkillSetForm" name="deleteSkillSetForm" action="deleteSkillSet" method="post">
    		<input type="hidden" id="uniqueId" name="uniqueId" value="<s:property value="skillSet.skillSetId" />" />
	     	<button type="button" class="btn btn-success"  onclick="javascript:deleteSkillSet();">Yes</button>
	    	<button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
    	</form>
      </div>
    </div>
  </div>