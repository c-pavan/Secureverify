package com.secureVerify.model;

import java.util.Date;

public class CandidateCouponMap implements java.io.Serializable {

	private static final long serialVersionUID = 2427555022915603878L;
	
	private Integer candidateCouponMapId;
	private Integer candidateId;
	private Integer couponId;
	private Integer employerId;
	private Date updateTime;
	
	public CandidateCouponMap(){
		
	}

	public CandidateCouponMap(Integer candidateCouponMapId, Integer candidateId, Integer couponId, Integer employerId, Date updateTime){
		this.candidateCouponMapId = candidateCouponMapId;
		this.candidateId = candidateId;
		this.couponId = couponId;
		this.employerId = employerId;
		this.updateTime = updateTime;
	}

	public CandidateCouponMap(Integer candidateId, Integer couponId, Integer employerId, Date updateTime){
		this.candidateId = candidateId;
		this.couponId = couponId;
		this.employerId = employerId;
		this.updateTime = updateTime;
	}

	public Integer getCandidateCouponMapId() {
		return candidateCouponMapId;
	}

	public void setCandidateCouponMapId(Integer candidateCouponMapId) {
		this.candidateCouponMapId = candidateCouponMapId;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
