package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.LocationScheduleTimingBo;
import com.secureVerify.dao.LocationScheduleTimingDAO;
import com.secureVerify.model.LocationScheduleTiming;

public class LocationScheduleTimingBoImpl implements LocationScheduleTimingBo {
	
	LocationScheduleTimingDAO locationScheduleTimingDAO;
	
	//DI via Spring
	public void setLocationScheduleTimingDAO(LocationScheduleTimingDAO locationScheduleTimingDAO){
		this.locationScheduleTimingDAO = locationScheduleTimingDAO;
	}

	public void addLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming) {
		locationScheduleTimingDAO.addLocationScheduleTiming(locationScheduleTiming);
	}

	public void updateLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming) {
		locationScheduleTimingDAO.updateLocationScheduleTiming(locationScheduleTiming);
	}

	public void deleteLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming) {
		locationScheduleTimingDAO.deleteLocationScheduleTiming(locationScheduleTiming);
	}

	public void deleteLocationScheduleTimingList(List<LocationScheduleTiming> locationScheduleTimingList) {
		locationScheduleTimingDAO.deleteLocationScheduleTimingList(locationScheduleTimingList);
	}

	public List<LocationScheduleTiming> listLocationScheduleTiming() {
		return locationScheduleTimingDAO.listLocationScheduleTiming();
	}

	public List<LocationScheduleTiming> listActiveLocationScheduleTiming() {
		return locationScheduleTimingDAO.listActiveLocationScheduleTiming();
	}

	public LocationScheduleTiming getLocationScheduleTimingByLocationScheduleTimingId(Integer locationScheduleTimingId) {
		return locationScheduleTimingDAO.getLocationScheduleTimingByLocationScheduleTimingId(locationScheduleTimingId);
	}

	public List<LocationScheduleTiming> getLocationScheduleTimingByLocationId(Integer locationId) {
		return locationScheduleTimingDAO.getLocationScheduleTimingByLocationId(locationId);
	}

	public List<LocationScheduleTiming> getLocationScheduleTimingByAgentId(Integer agentId) {
		return locationScheduleTimingDAO.getLocationScheduleTimingByAgentId(agentId);
	}

	public List<LocationScheduleTiming> searchLocationScheduleTiming(
			Integer locationScheduleTimingId, Integer locationId,
			Date locationScheduleFromTime, Date locationScheduleToTime,
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return locationScheduleTimingDAO.searchLocationScheduleTiming(locationScheduleTimingId, locationId, locationScheduleFromTime, locationScheduleToTime, createdBy, lastModifiedBy, fromDate, toDate, status, startRecord, endRecord);
	}

	public List<LocationScheduleTiming> getLocationScheduleTimingListByPage(int startRecord, int endRecord) {
		return locationScheduleTimingDAO.getLocationScheduleTimingListByPage(startRecord, endRecord);
	}

	public Integer getLocationScheduleTimingListCount() {
		return locationScheduleTimingDAO.getLocationScheduleTimingListCount();
	}

	public Integer getLocationScheduleTimingListCountByLocationId(Integer locationId) {
		return locationScheduleTimingDAO.getLocationScheduleTimingListCountByLocationId(locationId);
	}

	public List<LocationScheduleTiming> getLocationScheduleTimingListByLocationIdPage(
			Integer locationId, int startRecord, int endRecord) {
		return locationScheduleTimingDAO.getLocationScheduleTimingListByLocationIdPage(locationId, startRecord, endRecord);
	}

	public Integer getLocationScheduleTimingListCountByLocationIds(List<Integer> locationIdList) {
		return locationScheduleTimingDAO.getLocationScheduleTimingListCountByLocationIds(locationIdList);
	}

	public List<LocationScheduleTiming> getLocationScheduleTimingListByLocationIdListPage(
			List<Integer> locationIdList, Integer startRecord, Integer endRecord) {
		return locationScheduleTimingDAO.getLocationScheduleTimingListByLocationIdListPage(locationIdList, startRecord, endRecord);
	}

}
