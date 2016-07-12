package com.secureVerify.bo.impl;

import java.util.Date;
import java.util.List;

import com.secureVerify.bo.LocationBo;
import com.secureVerify.dao.LocationDAO;
import com.secureVerify.model.Location;

public class LocationBoImpl implements LocationBo {

	LocationDAO locationDAO;
	
	//DI via Spring
	public void setLocationDAO(LocationDAO locationDAO){
		this.locationDAO = locationDAO;
	}
	
	public void addLocation(Location location) {
		locationDAO.addLocation(location);
	}

	public void updateLocation(Location location) {
		locationDAO.updateLocation(location);
	}

	public void deleteLocation(Location location) {
		locationDAO.deleteLocation(location);
	}

	public void deleteLocationList(List<Location> locationList) {
		locationDAO.deleteLocationList(locationList);
	}

	public List<Location> listLocation() {
		return locationDAO.listLocation();
	}

	public List<Location> listActiveLocation() {
		return locationDAO.listActiveLocation();
	}

	public List<Location> searchLocation(Integer locationId,
			String locationName, String locationBusinessName,
			String locationAddressLine1, String locationAddressLine2,
			String locationCity, String locationState, String locationCountry,
			String locationZipcode, String locationPhoneNo,
			Integer locationPrimaryAgentId, Integer locationSecondaryAgentId,
			Integer createdBy, Integer lastModifiedBy, Date fromDate,
			Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return locationDAO.searchLocation(locationId, locationName, locationBusinessName, locationAddressLine1, locationAddressLine2, 
				locationCity, locationState, locationCountry, locationZipcode, locationPhoneNo, locationPrimaryAgentId, 
				locationSecondaryAgentId, createdBy, lastModifiedBy, fromDate, toDate, status, startRecord, endRecord);
	}

	public Location getLocationByLocationId(Integer locationId) {
		return locationDAO.getLocationByLocationId(locationId);
	}

	public Location getLocation(String locationEmailId, String locationPassword) {
		return locationDAO.getLocation(locationEmailId, locationPassword);
	}

	public Location getLocationByEmailId(String locationEmailId) {
		return locationDAO.getLocationByEmailId(locationEmailId);
	}

	public List<Location> getLocationsByZipcode(String locationZipcode) {
		return locationDAO.getLocationsByZipcode(locationZipcode);
	}

	public List<Location> getLocationsByCity(String locationCity) {
		return locationDAO.getLocationsByCity(locationCity);
	}

	public List<Location> getLocationListByPage(int startRecord, int endRecord) {
		return locationDAO.getLocationListByPage(startRecord, endRecord);
	}

	public Integer getLocationListCount() {
		return locationDAO.getLocationListCount();
	}

	public List<Location> getLocationByAgentId(Integer locationAgentId) {
		return locationDAO.getLocationByAgentId(locationAgentId);
	}

	public List<Location> listLocationByLatitudeAndLongitude(Double latitude, Double longitude) {
		return locationDAO.listLocationByLatitudeAndLongitude(latitude, longitude);
	}
	
	public Integer getLocationListCount(String locationName, String locationBusinessName, String locationCity, String locationCountry) {
		return locationDAO.getLocationListCount(locationName, locationBusinessName, locationCity, locationCountry);
	}

	public List<Integer> getLocationIdsByAgentId(Integer locationAgentId) {
		return locationDAO.getLocationIdsByAgentId(locationAgentId);
	}

	
}
