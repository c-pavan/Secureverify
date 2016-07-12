<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="col-sm-3 page-sidebar left-navigation-block">
  <aside>
    <div class="inner-left-menu mb0">
      <div class="widget sidebar-widget jobs-filter-widget">
        <h5 class="widget-title clr-red">Employer Menu</h5>
        <div class="widget-content">
          <div>
            <ul class="filter-list">
              <!--<li><a href="#">Search</a></li>-->
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerCandidates" <s:if test="urlPage!=null && urlPage.equals('employerCandidates')">class="active"</s:if> >New Candidates</a></li><!-- employerCandidates.jsp -->
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAppliedCandidates" <s:if test="urlPage!=null && urlPage.equals('employerAppliedCandidates')">class="active"</s:if> >Applied Candidates</a></li><!-- employerAppliedCandidates.jsp -->
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerScheduledCandidates" <s:if test="urlPage!=null && urlPage.equals('employerScheduledCandidates')">class="active"</s:if> >Scheduled Candidates</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerInterviewedCandidates" <s:if test="urlPage!=null && urlPage.equals('employerInterviewedCandidates')">class="active"</s:if> >Interviewed Candidates</a></li>
              <%-- <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerAllCandidates" <s:if test="urlPage!=null && urlPage.equals('employerAllCandidates')">class="active"</s:if> >All Candidates</a></li> --%>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>creditsManagment"  <s:if test="urlPage!=null && urlPage.equals('employerCreditsManagment')">class="active"</s:if> >Credits Management</a></li>
              <li <s:if test="urlPage!=null && ( urlPage.equals('updateCompanyInfo') || urlPage.equals('employerUpdateProfile') || urlPage.equals('employerChangePassword'))">class="active has-submenu"</s:if><s:else>class="has-submenu"</s:else> > <a href="#" <s:if test="urlPage!=null && ( urlPage.equals('updateCompanyInfo') || urlPage.equals('employerUpdateProfile') || urlPage.equals('employerChangePassword'))">class="active"</s:if> >My Account <i class="fa fa-caret-down"></i></a>
                <ul>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerChangePassword" <s:if test="urlPage!=null && urlPage.equals('employerChangePassword')">class="active"</s:if> >Change Password</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerUpdateProfile" <s:if test="urlPage!=null && urlPage.equals('employerUpdateProfile')">class="active"</s:if> >Update Profile</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>updateCompanyInfo" <s:if test="urlPage!=null && urlPage.equals('updateCompanyInfo')">class="active"</s:if> >Update Company Info</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>employerLogout">Logout</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </aside>
</div>