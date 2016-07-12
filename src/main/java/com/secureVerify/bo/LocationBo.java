package com.secureVerify.bo;

import java.util.Date;
import java.util.List;

import com.secureVerify.model.Location;

public interface LocationBo {

	void addLocation(Location location);
	
	void updateLocation(Location location);
	
	void deleteLocation(Location location);
	
	void deleteLocationList(List<Location> locationList);
	
	List<Location> listLocation();
	
	List<Location> listActiveLocation();
	
	List<Location> searchLocation(Integer locationId, String locationName, String locationBusinessName, 
			String locationAddressLine1, String locationAddressLine2, String locationCity, String locationState, 
			String locationCountry, String locationZipcode, String locationPhoneNo, Integer locationPrimaryAgentId, 
			Integer locationSecondaryAgentId, Integer createdBy, Integer lastModifiedBy, Date fromDate, 
			Date toDate, Integer status, Integer startRecord, Integer endRecord);
	
	Location getLocationByLocationId(Integer locationId);
	
	Location getLocation(String locationEmailId, String locationPassword);
	
	Location getLocationByEmailId(String locationEmailId);
	
	List<Location> getLocationByAgentId(Integer locationAgentId);
	
	List<Integer> getLocationIdsByAgentId(Integer locationAgentId);
	
	List<Location> getLocationsByZipcode(String locationZipcode);
	
	List<Location> getLocationsByCity(String locationCity);
	
	List<Location> getLocationListByPage(final int startRecord, final int endRecord);
	
	Integer getLocationListCount();
	
	Integer getLocationListCount(String locationName, String locationBusinessName, String locationCity, String locationCountry);
	
	List<Location> listLocationByLatitudeAndLongitude(Double latitude, Double longitude);
	
}
