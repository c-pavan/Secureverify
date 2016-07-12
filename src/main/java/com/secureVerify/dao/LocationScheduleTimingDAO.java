package com.secureVerify.dao;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.LocationScheduleTiming;

public interface LocationScheduleTimingDAO {

	void addLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming);
	
	void updateLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming);
	
	void deleteLocationScheduleTiming(LocationScheduleTiming locationScheduleTiming);
	
	void deleteLocationScheduleTimingList(List<LocationScheduleTiming> locationScheduleTimingList);
	
	List<LocationScheduleTiming> listLocationScheduleTiming();
	
	List<LocationScheduleTiming> listActiveLocationScheduleTiming();
	
	LocationScheduleTiming getLocationScheduleTimingByLocationScheduleTimingId(Integer locationScheduleTimingId);
	
	List<LocationScheduleTiming>  getLocationScheduleTimingByLocationId(Integer locationId);
	
	List<LocationScheduleTiming>  getLocationScheduleTimingByAgentId(Integer agentId);
	
	List<LocationScheduleTiming> searchLocationScheduleTiming(Integer locationScheduleTimingId, Integer locationId, Date locationScheduleFromTime, Date locationScheduleToTime, 
			Integer createdBy, Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, Integer startRecord, Integer endRecord);
	
	List<LocationScheduleTiming> getLocationScheduleTimingListByPage(final int startRecord, final int endRecord);
	
	List<LocationScheduleTiming> getLocationScheduleTimingListByLocationIdPage(Integer locationId, final int startRecord, final int endRecord);
	
	List<LocationScheduleTiming> getLocationScheduleTimingListByLocationIdListPage(List<Integer> locationIdList, Integer startRecord, Integer endRecord);
	
	Integer getLocationScheduleTimingListCount();
	
	Integer getLocationScheduleTimingListCountByLocationId(Integer locationId);
	
	Integer getLocationScheduleTimingListCountByLocationIds(List<Integer> locationIdList);
	
}
