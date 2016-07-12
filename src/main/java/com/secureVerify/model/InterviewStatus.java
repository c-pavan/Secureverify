package com.secureVerify.model;

public enum InterviewStatus {
	
	APPLIED(1), SCHEDULED(2), INTERVIEWED(3);
	
	private int value;
	
	private InterviewStatus(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}

}
