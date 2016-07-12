<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
        <h4 class="modal-title">Interviewer Details</h4>
      </div>
      <div class="modal-body">
        <form id="#" name="#" action="#" method="get">
          <h6 class="label">Name</h6>
          <div class="row">
            <div class="col-sm-6">
              <input type="text" class="form-control" id="" name="" value="<s:property value="employer.employerFirstName" />" placeholder="First Name" disabled />
            </div>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="" name="" value="<s:property value="employer.employerLastName" />" placeholder="Last Name" disabled />
            </div>
          </div>
          <h6 class="label">Email</h6>
          <div class="row">
            <div class="col-sm-6">
              <input type="text" class="form-control" id="" name="" value="<s:property value="employer.employerEmailId" />" placeholder="Email" disabled />
            </div>
          </div>
          <h6 class="label">Contact Number</h6>
          <div class="row">
            <div class="col-sm-6">
              <input type="text" class="form-control" id="" name="" value="<s:property value="employer.employerPhoneNo" />" placeholder="Mobile" disabled />
            </div>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="" name="" value="<s:property value="employer.employerPhoneNoExtension" />" placeholder="Ext" disabled />
            </div>
          </div>
          <h6 class="label">Alternate Contact Number</h6>
          <div class="row">
            <div class="col-sm-6">
              <input type="text" class="form-control" id="" name="" value="<s:property value="employer.employerAlternatePhone" />" placeholder="Mobile" disabled />
            </div>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="" name="" value="<s:property value="employer.employerAlternatePhoneNoExtension" />" placeholder="Ext" disabled />
            </div>
          </div>
          <h6 class="label">Skill Set</h6>
          <div class="row">
            <div class="col-sm-6">
              <select id="" name="" value="" disabled>
                <option value="" selected="selected" >Skill Set 1</option>
              </select>
            </div>
            <div class="col-sm-4">
              <select value="" disabled>
                <option value="">Skill Set 2</option>
                <option value="">1</option>
                <option value="">2</option>
                <option value="">3</option>
                <option value="">4</option>
                <option value="">5</option>
              </select>
            </div>
            <div class="col-sm-4">
              <select value="" disabled>
                <option value="">Skill Set 3</option>
                <option value="">1</option>
                <option value="">2</option>
                <option value="">3</option>
                <option value="">4</option>
                <option value="">5</option>
              </select>
            </div>
          </div>
          <h6 class="label">Resume</h6>
          <div class="row">
            <div class="col-sm-12 resume-textarea">
              <textarea id="" name="" value="<s:property value="employer." />" disabled>Resume Text</textarea>
            </div>
          </div>
              <div class="row">
                <div class="col-sm-12">
                  <button type="button" class="btn btn-default mt10" id="" name="">Download Resume <i class="fa fa-download"></i></button>
                </div>
              </div>
          <div class="row">
            <div class="col-sm-4">
              <h6 class="label">Created By</h6>
              <input type="text" class="form-control" id="" name="" value="<s:property value="employer." />" placeholder="Created By" disabled />
            </div>
            <div class="col-sm-4">
              <h6 class="label">Created Date</h6>
              <input type="text" class="form-control" id="" name="" value="<s:date name="employer.creationDate" format="MM/dd/yyyy" />" placeholder="Created Date" disabled />
            </div>
          </div>
          <div class="row">
            <div class="col-sm-4">
              <h6 class="label">Last Modified By</h6>
              <input type="text" class="form-control" id="" name="" value="<s:property value="employer." />" placeholder="Last Modified By" disabled />
            </div>
            <div class="col-sm-4">
              <h6 class="label">Last Modified Date</h6>
              <input type="text" class="form-control" id="" name="" value="<s:date name="employer.lastModifiedTime" format="MM/dd/yyyy hh:mm:ss" />" placeholder="Last Modified Date" disabled />
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
      </div>
    </div>
  </div>