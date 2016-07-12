package com.secureVerify.bo;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.Feedback;

public interface FeedbackBo {

	void addFeedback(Feedback feedback);
	
	void updateFeedback(Feedback feedback);
	
	void deleteFeedback(Feedback feedback);
	
	void deleteFeedbackList(List<Feedback> feedbackList);
	
	List<Feedback> listFeedback();
	
	List<Feedback> listActiveFeedback();
	
	List<Feedback> searchFeedback(Integer feedbackId, Integer candidateScheduleTimingId, String feedbackText, Integer performance, 
			Date fromDate, Date toDate, Integer status, Integer startRecord, Integer endRecord);
	
	Feedback getFeedbackByFeedbackId(Integer feedbackId);
	
	List<Feedback> getFeedbacksByCandidateScheduleTimingId(Integer candidateScheduleTimingId);
	
	List<Feedback> getFeedbacksByPerformance(Integer performance);
	
	List<Feedback> getFeedbackListByPage(final int startRecord, final int endRecord);
	
	List<Feedback> getFeedbackListByPage(Integer candidateScheduleTimingId, final int startRecord, final int endRecord);
	
}
