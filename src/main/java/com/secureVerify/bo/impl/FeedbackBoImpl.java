package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.FeedbackBo;
import com.secureVerify.dao.FeedbackDAO;
import com.secureVerify.model.Feedback;

public class FeedbackBoImpl implements FeedbackBo {

	FeedbackDAO feedbackDAO;
	
	//DI via Spring
	public void setFeedbackDAO(FeedbackDAO feedbackDAO){
		this.feedbackDAO = feedbackDAO;
	}
	
	public void addFeedback(Feedback feedback) {
		feedbackDAO.addFeedback(feedback);
	}

	public void updateFeedback(Feedback feedback) {
		feedbackDAO.updateFeedback(feedback);
	}

	public void deleteFeedback(Feedback feedback) {
		feedbackDAO.deleteFeedback(feedback);
	}

	public void deleteFeedbackList(List<Feedback> feedbackList) {
		feedbackDAO.deleteFeedbackList(feedbackList);
	}

	public List<Feedback> listFeedback() {
		return feedbackDAO.listFeedback();
	}

	public List<Feedback> listActiveFeedback() {
		return feedbackDAO.listActiveFeedback();
	}

	public List<Feedback> searchFeedback(Integer feedbackId,
			Integer candidateScheduleTimingId, String feedbackText,
			Integer performance, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return feedbackDAO.searchFeedback(feedbackId, candidateScheduleTimingId, feedbackText, performance, fromDate, toDate, status, startRecord, endRecord);
	}

	public Feedback getFeedbackByFeedbackId(Integer feedbackId) {
		return feedbackDAO.getFeedbackByFeedbackId(feedbackId);
	}

	public List<Feedback> getFeedbacksByCandidateScheduleTimingId(Integer candidateScheduleTimingId) {
		return feedbackDAO.getFeedbacksByCandidateScheduleTimingId(candidateScheduleTimingId);
	}

	public List<Feedback> getFeedbacksByPerformance(Integer performance) {
		return feedbackDAO.getFeedbacksByPerformance(performance);
	}

	public List<Feedback> getFeedbackListByPage(int startRecord, int endRecord) {
		return feedbackDAO.getFeedbackListByPage(startRecord, endRecord);
	}

	public List<Feedback> getFeedbackListByPage(Integer candidateScheduleTimingId, int startRecord, int endRecord) {
		return feedbackDAO.getFeedbackListByPage(candidateScheduleTimingId, startRecord, endRecord);
	}

}
