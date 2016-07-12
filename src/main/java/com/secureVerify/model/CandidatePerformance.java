package com.secureVerify.model;

public enum CandidatePerformance {
	
	UNDER_PROCESS(0), BEST(1), GOOD(2), AVERAGE(3), NOT_QUALIFIED(4);
	
	private int value;
	
	private CandidatePerformance(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
