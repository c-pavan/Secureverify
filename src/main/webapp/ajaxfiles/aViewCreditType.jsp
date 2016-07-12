<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
        <h4 class="modal-title">Credit Details</h4>
      </div>
      <div class="modal-body viewform">
       <div class="viewlabel"><p class="labelspan">Credit Type Id : </p> <p class="viewlabeldetails"> <s:property value="" /></p></div>
       <div class="viewlabel"><p class="labelspan">Credit Type : </p> <p class="viewlabeldetails"> <s:property value="" /></p></div>
       <div class="viewlabel"><p class="labelspan">Description : </p> <p class="viewlabeldetails"> <s:property value="" /></p></div>
       <div class="viewlabel"><p class="labelspan">Amount Per Credit : </p> <p class="viewlabeldetails"> <s:property value="" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created By : </p> <p class="viewlabeldetails"> <s:property value="" /></p></div>
       <div class="viewlabel"><p class="labelspan">Created Date : </p> <p class="viewlabeldetails"> <s:date name="" format="MM/dd/yyyy" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified By : </p> <p class="viewlabeldetails"> <s:property value="" /></p></div>
       <div class="viewlabel"><p class="labelspan">Last Modified Time : </p> <p class="viewlabeldetails"> <s:date name="" format="MM/dd/yyyy hh:mm:ss" /></p></div>
       <div class="viewlabel"><p class="labelspan">Status : </p> <p class="viewlabeldetails"> <s:property value="" /></p></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
      </div>
    </div>
  </div>