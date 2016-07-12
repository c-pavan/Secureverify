package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.CandidateCouponMapBo;
import com.secureVerify.dao.CandidateCouponMapDAO;
import com.secureVerify.model.CandidateCouponMap;

public class CandidateCouponMapBoImpl implements CandidateCouponMapBo {
	
	CandidateCouponMapDAO candidateCouponMapDAO;

	//DI via Spring
	public void setCandidateCouponMapDAO(CandidateCouponMapDAO candidateCouponMapDAO){
		this.candidateCouponMapDAO = candidateCouponMapDAO;
	}
	
	public void addCandidateCouponMap(CandidateCouponMap candidateCouponMap) {
		candidateCouponMapDAO.addCandidateCouponMap(candidateCouponMap);
	}

	public void updateCandidateCouponMap(CandidateCouponMap candidateCouponMap) {
		candidateCouponMapDAO.updateCandidateCouponMap(candidateCouponMap);
	}

	public void deleteCandidateCouponMap(CandidateCouponMap candidateCouponMap) {
		candidateCouponMapDAO.deleteCandidateCouponMap(candidateCouponMap);
	}

	public void deleteCandidateCouponMapList(List<CandidateCouponMap> candidateCouponMapList) {
		candidateCouponMapDAO.deleteCandidateCouponMapList(candidateCouponMapList);
	}

	public List<CandidateCouponMap> listCandidateCouponMap() {
		return candidateCouponMapDAO.listCandidateCouponMap();
	}

	public List<CandidateCouponMap> searchCandidateCouponMap(
			Integer candidateCouponMapId, Integer candidateId,
			Integer couponId, Integer employerId, Date fromDate, Date toDate,
			Integer startRecord, Integer endRecord) {
		return candidateCouponMapDAO.searchCandidateCouponMap(candidateCouponMapId, candidateId, couponId, employerId, 
				fromDate, toDate, startRecord, endRecord);
	}

	public CandidateCouponMap getCandidateCouponMap(Integer candidateCouponMapId) {
		return candidateCouponMapDAO.getCandidateCouponMap(candidateCouponMapId);
	}

	public List<CandidateCouponMap> getCandidateCouponMapByCandidateId(Integer candidateId) {
		return candidateCouponMapDAO.getCandidateCouponMapByCandidateId(candidateId);
	}

	public CandidateCouponMap getCandidateCouponMapByCouponId(Integer couponId) {
		return candidateCouponMapDAO.getCandidateCouponMapByCouponId(couponId);
	}

	public List<CandidateCouponMap> getCandidateCouponMapByEmployerId(Integer employerId) {
		return candidateCouponMapDAO.getCandidateCouponMapByEmployerId(employerId);
	}

	public Integer getCandidateCouponMapListCount() {
		return candidateCouponMapDAO.getCandidateCouponMapListCount();
	}

	public Integer getCandidateCouponMapByCandidateIdListCount(Integer candidateId) {
		return candidateCouponMapDAO.getCandidateCouponMapByCandidateIdListCount(candidateId);
	}

	public Integer getCandidateCouponMapByEmployerIdListCount(Integer employerId) {
		return candidateCouponMapDAO.getCandidateCouponMapByEmployerIdListCount(employerId);
	}

	public Integer getCandidateCouponMapByCandidateIdEmployerIdCouponStatusListCount(
			Integer candidateId, Integer employerId) {
		return candidateCouponMapDAO.getCandidateCouponMapByCandidateIdEmployerIdCouponStatusListCount(candidateId, employerId);
	}

}
