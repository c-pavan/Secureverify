<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="col-sm-3 page-sidebar left-navigation-block">
  <aside>
    <div class="inner-left-menu mb0">
      <div class="widget sidebar-widget jobs-filter-widget">
        <h5 class="widget-title clr-red">Candidate Menu</h5>
        <div class="widget-content">
          <div>
            <ul class="filter-list">
              <!--<li><a href="#">Search</a></li>-->
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateScheduleVerification" <s:if test="urlPage!=null && urlPage.equals('candidateScheduleVerification')">class="active"</s:if> >Schedule Verification</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateScheduledTimeSlots" <s:if test="urlPage!=null && urlPage.equals('candidateScheduledTimeSlots')">class="active"</s:if> >Scheduled Time Slots</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateScheduledInterviews" <s:if test="urlPage!=null && urlPage.equals('candidateScheduledInterviews')">class="active"</s:if> >Scheduled Interviews</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateInterviewFeedback" <s:if test="urlPage!=null && urlPage.equals('candidateInterviewFeedback')">class="active"</s:if> >Interview Feedback</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateManageCertifications" <s:if test="urlPage!=null && urlPage.equals('candidateManageCertifications')">class="active"</s:if> >Manage Certifications</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateEmployerScheduledInterview" <s:if test="urlPage!=null && urlPage.equals('candidateEmployerScheduledInterview')">class="active"</s:if> >Employer Scheduled Interview</a></li>
              <li  <s:if test="urlPage!=null && ( urlPage.equals('candidateUpdatePassword') || urlPage.equals('candidateUpdateProfile') || urlPage.equals('candidateResumesHistory') || urlPage.equals('candidateUpdatePrimarySkill') || urlPage.equals('employerDetails') || urlPage.equals('visaDetails') || urlPage.equals('candidateCredits') )">class="has-submenu active"</s:if><s:else>class="has-submenu"</s:else> > <a href="#">My Account <i class="fa fa-caret-down"></i></a>
                <ul>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateUpdateProfile" <s:if test="urlPage!=null && urlPage.equals('candidateUpdateProfile')">class="active"</s:if> >Update Profile</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateUpdatePassword" <s:if test="urlPage!=null && urlPage.equals('candidateUpdatePassword')">class="active"</s:if> >Update Password</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateResumesHistory" <s:if test="urlPage!=null && urlPage.equals('candidateResumesHistory')">class="active"</s:if> >Resumes History</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>visaDetails" <s:if test="urlPage!=null && urlPage.equals('visaDetails')">class="active"</s:if> >Visa Details</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateCredits" <s:if test="urlPage!=null && urlPage.equals('candidateCredits')">class="active"</s:if> >Credits Management</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>candidateLogout" >Logout</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </aside>
</div>