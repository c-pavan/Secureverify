package com.secureVerify.model;

import java.util.Date;

public class Feedback implements java.io.Serializable {

	private static final long serialVersionUID = -1940913696951800647L;

	private Integer feedbackId;
	private Integer candidateScheduleTimingId;
	private String feedbackText;
	private Integer performance;
	private Date createdTime;
	private Integer status;
	
	public Feedback(){
		
	}

	public Feedback(Integer feedbackId, Integer candidateScheduleTimingId, String feedbackText, Integer performance, 
			Date createdTime, Integer status){
		this.feedbackId = feedbackId;
		this.candidateScheduleTimingId = candidateScheduleTimingId;
		this.feedbackText = feedbackText;
		this.performance = performance;
		this.createdTime = createdTime;
		this.status = status;
	}

	public Feedback(Integer candidateScheduleTimingId, String feedbackText, Integer performance, Date createdTime, Integer status){
		this.candidateScheduleTimingId = candidateScheduleTimingId;
		this.feedbackText = feedbackText;
		this.performance = performance;
		this.createdTime = createdTime;
		this.status = status;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Integer getCandidateScheduleTimingId() {
		return candidateScheduleTimingId;
	}

	public void setCandidateScheduleTimingId(Integer candidateScheduleTimingId) {
		this.candidateScheduleTimingId = candidateScheduleTimingId;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	public Integer getPerformance() {
		return performance;
	}

	public void setPerformance(Integer performance) {
		this.performance = performance;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
