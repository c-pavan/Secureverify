package com.secureVerify.model;

import java.util.Date;

public class LocationScheduleTiming implements java.io.Serializable {

	private static final long serialVersionUID = 1799296068283567802L;
	
	private Integer locationScheduleTimingId;
	private Integer locationId;
	private Date locationScheduleFromTime;
	private Date locationScheduleToTime;
	private String createdByName;
	private Integer createdBy;
	private String lastModifiedByName;
	private Integer lastModifiedBy;
	private Date creationDate;
	private Date lastModifiedTime;
	private Integer status;
	
	private Location location;
	
	public LocationScheduleTiming(){
		
	}

	public LocationScheduleTiming(Integer locationScheduleTimingId, Integer locationId, Date locationScheduleFromTime, 
			Date locationScheduleToTime, Integer createdBy, Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, Integer status){
		this.locationScheduleTimingId = locationScheduleTimingId;
		this.locationId = locationId;
		this.locationScheduleFromTime = locationScheduleFromTime;
		this.locationScheduleToTime = locationScheduleToTime;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public LocationScheduleTiming(Integer locationId, Date locationScheduleFromTime, Date locationScheduleToTime, 
			Integer createdBy, Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, Integer status){
		this.locationId = locationId;
		this.locationScheduleFromTime = locationScheduleFromTime;
		this.locationScheduleToTime = locationScheduleToTime;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public Integer getLocationScheduleTimingId() {
		return locationScheduleTimingId;
	}

	public void setLocationScheduleTimingId(Integer locationScheduleTimingId) {
		this.locationScheduleTimingId = locationScheduleTimingId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Date getLocationScheduleFromTime() {
		return locationScheduleFromTime;
	}

	public void setLocationScheduleFromTime(Date locationScheduleFromTime) {
		this.locationScheduleFromTime = locationScheduleFromTime;
	}

	public Date getLocationScheduleToTime() {
		return locationScheduleToTime;
	}

	public void setLocationScheduleToTime(Date locationScheduleToTime) {
		this.locationScheduleToTime = locationScheduleToTime;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedByName() {
		return lastModifiedByName;
	}

	public void setLastModifiedByName(String lastModifiedByName) {
		this.lastModifiedByName = lastModifiedByName;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

}
