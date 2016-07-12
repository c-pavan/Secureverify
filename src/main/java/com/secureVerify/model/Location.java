package com.secureVerify.model;

import java.util.Comparator;
import java.util.Date;

public class Location implements java.io.Serializable {

	private static final long serialVersionUID = -4157803153951533732L;
	
	private Integer locationId;
	private String locationName;
	private String locationBusinessName;
	private String locationAddressLine1;
	private String locationAddressLine2;
	private String locationCity;
	private String locationState;
	private String locationCountry;
	private String locationZipcode;
	private String locationPhoneNo;
	private String locationPhoneNoExtension;
	private String locationAlternatePhone;
	private String locationAlternatePhoneNoExtension;
	private String locationPrimaryAgentName;
	private Integer locationPrimaryAgentId;
	private String locationSecondaryAgentName;
	private Integer locationSecondaryAgentId;
	private Double latitude;
	private Double longitude;
	private Double distance;
	private String createdByName;
	private Integer createdBy;
	private String lastModifiedByName;
	private Integer lastModifiedBy;
	private Date creationDate;
	private Date lastModifiedTime;
	private Integer status;
	
	public Location(){
		
	}

	public Location(Integer locationId, String locationName, String locationBusinessName, String locationAddressLine1, 
			String locationAddressLine2, String locationCity, String locationState, String locationCountry, String locationZipcode, 
			String locationPhoneNo, String locationPhoneNoExtension, String locationAlternatePhone, String locationAlternatePhoneNoExtension, 
			Integer locationPrimaryAgentId, Integer locationSecondaryAgentId, Double latitude, Double longitude, Integer createdBy, 
			Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, Integer status){
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationBusinessName = locationBusinessName;
		this.locationAddressLine1 = locationAddressLine1;
		this.locationAddressLine2 = locationAddressLine2;
		this.locationCity = locationCity;
		this.locationState = locationState;
		this.locationCountry = locationCountry;
		this.locationZipcode = locationZipcode;
		this.locationPhoneNo = locationPhoneNo;
		this.locationPhoneNoExtension = locationPhoneNoExtension;
		this.locationAlternatePhone = locationAlternatePhone;
		this.locationAlternatePhoneNoExtension = locationAlternatePhoneNoExtension;
		this.locationPrimaryAgentId = locationPrimaryAgentId;
		this.locationSecondaryAgentId = locationSecondaryAgentId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public Location(String locationName, String locationBusinessName, String locationAddressLine1, String locationAddressLine2, 
			String locationCity, String locationState, String locationCountry, String locationZipcode, String locationPhoneNo, 
			String locationPhoneNoExtension, String locationAlternatePhone, String locationAlternatePhoneNoExtension, 
			Integer locationPrimaryAgentId, Integer locationSecondaryAgentId, Double latitude, Double longitude, Integer createdBy, 
			Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, Integer status){
		this.locationName = locationName;
		this.locationBusinessName = locationBusinessName;
		this.locationAddressLine1 = locationAddressLine1;
		this.locationAddressLine2 = locationAddressLine2;
		this.locationCity = locationCity;
		this.locationState = locationState;
		this.locationCountry = locationCountry;
		this.locationZipcode = locationZipcode;
		this.locationPhoneNo = locationPhoneNo;
		this.locationPhoneNoExtension = locationPhoneNoExtension;
		this.locationAlternatePhone = locationAlternatePhone;
		this.locationAlternatePhoneNoExtension = locationAlternatePhoneNoExtension;
		this.locationPrimaryAgentId = locationPrimaryAgentId;
		this.locationSecondaryAgentId = locationSecondaryAgentId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationBusinessName() {
		return locationBusinessName;
	}

	public void setLocationBusinessName(String locationBusinessName) {
		this.locationBusinessName = locationBusinessName;
	}

	public String getLocationAddressLine1() {
		return locationAddressLine1;
	}

	public void setLocationAddressLine1(String locationAddressLine1) {
		this.locationAddressLine1 = locationAddressLine1;
	}

	public String getLocationAddressLine2() {
		return locationAddressLine2;
	}

	public void setLocationAddressLine2(String locationAddressLine2) {
		this.locationAddressLine2 = locationAddressLine2;
	}

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public String getLocationCountry() {
		return locationCountry;
	}

	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}

	public String getLocationZipcode() {
		return locationZipcode;
	}

	public void setLocationZipcode(String locationZipcode) {
		this.locationZipcode = locationZipcode;
	}

	public String getLocationPhoneNo() {
		return locationPhoneNo;
	}

	public void setLocationPhoneNo(String locationPhoneNo) {
		this.locationPhoneNo = locationPhoneNo;
	}

	public String getLocationPhoneNoExtension() {
		return locationPhoneNoExtension;
	}

	public void setLocationPhoneNoExtension(String locationPhoneNoExtension) {
		this.locationPhoneNoExtension = locationPhoneNoExtension;
	}

	public String getLocationAlternatePhone() {
		return locationAlternatePhone;
	}

	public void setLocationAlternatePhone(String locationAlternatePhone) {
		this.locationAlternatePhone = locationAlternatePhone;
	}

	public String getLocationAlternatePhoneNoExtension() {
		return locationAlternatePhoneNoExtension;
	}

	public void setLocationAlternatePhoneNoExtension(
			String locationAlternatePhoneNoExtension) {
		this.locationAlternatePhoneNoExtension = locationAlternatePhoneNoExtension;
	}

	public Integer getLocationPrimaryAgentId() {
		return locationPrimaryAgentId;
	}

	public void setLocationPrimaryAgentId(Integer locationPrimaryAgentId) {
		this.locationPrimaryAgentId = locationPrimaryAgentId;
	}

	public Integer getLocationSecondaryAgentId() {
		return locationSecondaryAgentId;
	}

	public void setLocationSecondaryAgentId(Integer locationSecondaryAgentId) {
		this.locationSecondaryAgentId = locationSecondaryAgentId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLocationPrimaryAgentName() {
		return locationPrimaryAgentName;
	}

	public void setLocationPrimaryAgentName(String locationPrimaryAgentName) {
		this.locationPrimaryAgentName = locationPrimaryAgentName;
	}

	public String getLocationSecondaryAgentName() {
		return locationSecondaryAgentName;
	}

	public void setLocationSecondaryAgentName(String locationSecondaryAgentName) {
		this.locationSecondaryAgentName = locationSecondaryAgentName;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public String getLastModifiedByName() {
		return lastModifiedByName;
	}

	public void setLastModifiedByName(String lastModifiedByName) {
		this.lastModifiedByName = lastModifiedByName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public static Comparator<Location> COMPARE_BY_DISTANCE = new Comparator<Location>() {
        public int compare(Location one, Location other) {
            return one.distance.compareTo(other.distance);
        }
    };
    
    public static Comparator<Location> COMPARE_BY_NAME = new Comparator<Location>() {
        public int compare(Location one, Location other) {
            return one.locationName.compareTo(other.locationName);
        }
    };

}
