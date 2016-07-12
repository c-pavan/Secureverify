package com.secureVerify.bo;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.CandidateCouponMap;

public interface CandidateCouponMapBo {

	void addCandidateCouponMap(CandidateCouponMap candidateCouponMap);
	
	void updateCandidateCouponMap(CandidateCouponMap candidateCouponMap);
	
	void deleteCandidateCouponMap(CandidateCouponMap candidateCouponMap);
	
	void deleteCandidateCouponMapList(List<CandidateCouponMap> candidateCouponMapList);
	
	List<CandidateCouponMap> listCandidateCouponMap();
	
	List<CandidateCouponMap> searchCandidateCouponMap(Integer candidateCouponMapId, Integer candidateId, Integer couponId, 
			Integer employerId, Date fromDate, Date toDate, Integer startRecord, Integer endRecord);
	
	CandidateCouponMap getCandidateCouponMap(Integer candidateCouponMapId);
	
	List<CandidateCouponMap> getCandidateCouponMapByCandidateId(Integer candidateId);
	
	CandidateCouponMap getCandidateCouponMapByCouponId(Integer couponId);
	
	List<CandidateCouponMap> getCandidateCouponMapByEmployerId(Integer employerId);
	
	Integer getCandidateCouponMapListCount();
	
	Integer getCandidateCouponMapByCandidateIdListCount(Integer candidateId);
	
	Integer getCandidateCouponMapByEmployerIdListCount(Integer employerId);
	
	Integer getCandidateCouponMapByCandidateIdEmployerIdCouponStatusListCount(Integer candidateId, Integer employerId);
	
}
