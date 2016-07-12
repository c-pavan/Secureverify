<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="modal-dialog modal-lg">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" id="" name="">&times;</button>
      <h4 class="modal-title">Employer Details</h4>
    </div>
    <div class="modal-body">
      <form id="#" name="#" action="#" method="post" onsubmit="return false;">
                <br/>
                 <h6 class="label">Employe ID</h6>
                 <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerId" name="employerId" value="<s:property value="employer.employerId" />"  disabled />
                  </div>
                 </div>
                <h6 class="label"> Name</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerFirstName" name="employerFirstName" value="<s:property value="employer.employerFirstName" />" disabled />
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerLastName" name="employerLastName" value="<s:property value="employer.employerLastName" />" disabled />
                  </div>
                </div>
                <h6 class="label">Email Id</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerEmailId" name="employerEmailId" value="<s:property value="employer.employerEmailId" />" disabled />
                  </div>
                </div>
                 <h6 class="label">Phone Number</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerPhoneNo" name="employerPhoneNo" value="<s:property value="employer.employerPhoneNo" />" disabled />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="employerPhoneNoExtension" name="employerPhoneNoExtension" value="<s:property value="employer.employerPhoneNoExtension" />" disabled />
                  </div>
                </div>
                <h6 class="label">Alternate Phone Number</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerAlternatePhone" name="employerAlternatePhone" value="<s:property value="employer.employerAlternatePhone" />" disabled />
                  </div>
                  <div class="col-sm-2">
                    <input type="text" class="form-control" id="employerAlternatePhoneNoExtension" name="employerAlternatePhoneNoExtension" value="<s:property value="employer.employerAlternatePhoneNoExtension"/>" disabled />
                  </div>
                </div>
                 <h6 class="label">Company Name</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerCompanyName" name="employerCompanyName" value="<s:property value="employer.employerCompanyName" />" disabled />
                  </div>
                </div>
                <h6 class="label">Title</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerTitle" name="employerTitle" value="<s:property value="employer.employerTitle" />" disabled />
                  </div>
                </div>
                 <h6 class="label">Address</h6>
                 <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerAddressLine1" name="employerAddressLine1" value="<s:property value="employer.employerAddressLine1" />" disabled  />
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="employerAddressLine2" name="employerAddressLine2"  value="<s:property value="employer.employerAddressLine2" />" disabled />
                  </div>
                </div>
                <div class="row pt15">
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="employerCity" name="employerCity"  value="<s:property value="employer.employerCity" />" disabled />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="employerState" name="employerState"  value="<s:property value="employer.employerState" />" disabled />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="employerCountry" name="employerCountry"  value="<s:property value="employer.employerCountry" />" disabled />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="employerZipcode" name="employerZipcode"  value="<s:property value="employer.employerZipcode" />" disabled />
                  </div>
                </div>
                </form>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal" id="" name="">Close</button>
    </div>
  </div>
</div>