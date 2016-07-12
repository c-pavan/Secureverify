<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="col-sm-3 page-sidebar left-navigation-block">
  <aside>
    <div class="inner-left-menu mb0">
      <div class="widget sidebar-widget jobs-filter-widget">
        <s:if test="user!=null" >
        <h5 class="widget-title clr-blue">Admin Menu</h5>
        </s:if>
        <s:elseif test="agent!=null">
        <h5 class="widget-title clr-blue">Agent Menu</h5>
        </s:elseif>
        <s:elseif test="interviewer!=null">
        <h5 class="widget-title clr-blue">Interviewer Menu</h5>
        </s:elseif>
        
        <div class="widget-content">
          <div>
            <ul class="filter-list">
              <s:if test="user!=null" >
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminInterviewer" <s:if test="urlPage!=null && urlPage.equals('adminInterviewer')">class="active"</s:if> >Interviewer</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCandidate" <s:if test="urlPage!=null && urlPage.equals('adminCandidate')">class="active"</s:if> >Candidate</a></li> 
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminSkillSet" <s:if test="urlPage!=null && urlPage.equals('adminSkillSet')">class="active"</s:if> >SkillSet</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLocation" <s:if test="urlPage!=null && urlPage.equals('adminLocation')">class="active"</s:if> >Location</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminAgent" <s:if test="urlPage!=null && urlPage.equals('adminAgent')">class="active"</s:if> >Agent</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEmployer" <s:if test="urlPage!=null && urlPage.equals('adminEmployer')">class="active"</s:if> >Employers</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCoupon" <s:if test="urlPage!=null && urlPage.equals('adminCoupon')">class="active"</s:if> >Coupon</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminCreditTypes" <s:if test="urlPage!=null && urlPage.equals('adminCreditTypes')">class="active"</s:if> >Credit Types</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminPayments" <s:if test="urlPage!=null && urlPage.equals('adminPayments')">class="active"</s:if> >Payments</a></li>
              <li <s:if test="urlPage!=null && ( urlPage.equals('adminViewProfile') || urlPage.equals('adminEditProfile') )">class="has-submenu active"</s:if><s:else>class="has-submenu"</s:else>  > <a href="#">Admin Details <i class="fa fa-caret-down"></i></a>
                <ul>
                  <li <s:if test="urlPage!=null && urlPage.equals('adminViewProfile')">class="active"</s:if> ><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminViewProfile">View Profile</a></li>
                  <li <s:if test="urlPage!=null && urlPage.equals('adminEditProfile')">class="active"</s:if> ><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminEditProfile">Edit Profile</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>adminLogout">Logout</a></li>
                </ul>
              </li>
              </s:if>
              <s:elseif test="agent!=null">
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLocation" <s:if test="urlPage!=null && urlPage.equals('agentLocation')">class="active"</s:if> >Location</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentScheduleTimings" <s:if test="urlPage!=null && urlPage.equals('agentScheduleTimings')">class="active"</s:if> >Add Schedule Timings</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewAppliedCandidates" <s:if test="urlPage!=null && urlPage.equals('agentInterviewAppliedCandidates')">class="active"</s:if> >Applied Candidates</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewerScheduledCandidates" <s:if test="urlPage!=null && urlPage.equals('agentInterviewerScheduledCandidates')">class="active"</s:if> >Scheduled Candidates</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentInterviewedCandidates" <s:if test="urlPage!=null && urlPage.equals('agentInterviewedCandidates')">class="active"</s:if> >Interviewed Candidates</a></li>
              <li <s:if test="urlPage!=null && ( urlPage.equals('agentProfile') || urlPage.equals('agentPassword') )">class="has-submenu active"</s:if><s:else>class="has-submenu"</s:else>  > <a href="#">Agent Details <i class="fa fa-caret-down"></i></a>
                <ul>
                  <li <s:if test="urlPage!=null && urlPage.equals('agentPassword')">class="active"</s:if> ><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>editAgentPassword">Update Password</a></li>
                  <li <s:if test="urlPage!=null && urlPage.equals('agentProfile')">class="active"</s:if> ><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>editAgentProfile">Update Profile</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>agentLogout">Logout</a></li>
                </ul>
              </li>
              </s:elseif>
              <s:elseif test="interviewer!=null">
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerAppliedCandidates" <s:if test="urlPage!=null && urlPage.equals('interviewerAppliedCandidates')">class="active"</s:if> >Applied Candidates</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerScheduledCandidates" <s:if test="urlPage!=null && urlPage.equals('interviewerScheduledCandidates')">class="active"</s:if> >Scheduled Candidates</a></li>
              <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerInterviewedCandidates" <s:if test="urlPage!=null && urlPage.equals('interviewerInterviewedCandidates')">class="active"</s:if> >Interviewed Candidates</a></li>
              <li <s:if test="urlPage!=null && ( urlPage.equals('interviewerEditPassword') || urlPage.equals('interviewerEditProfile') )">class="has-submenu active"</s:if><s:else>class="has-submenu"</s:else>  > <a href="#">Interviewer Details <i class="fa fa-caret-down"></i></a>
                <ul>
                  <li <s:if test="urlPage!=null && urlPage.equals('interviewerEditPassword')">class="active"</s:if> ><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerEditPassword" <s:if test="urlPage!=null && urlPage.equals('interviewerEditPassword')">class="active"</s:if> >Update Password</a></li>
                  <li <s:if test="urlPage!=null && urlPage.equals('interviewerEditProfile')">class="active"</s:if> ><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerEditProfile" <s:if test="urlPage!=null && urlPage.equals('interviewerEditProfile')">class="active"</s:if> >Update Profile</a></li>
                  <li><a href="<%=properties.getProperty("CONTEXT_PATH").toString() %>interviewerLogout">Logout</a></li>
                </ul>
              </li>
              </s:elseif>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </aside>
</div>