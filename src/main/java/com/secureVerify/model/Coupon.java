package com.secureVerify.model;

import java.math.BigDecimal;
import java.util.Date;

public class Coupon implements java.io.Serializable {

	private static final long serialVersionUID = 6596901568345515675L;
	
	private Integer couponId;
	private String couponCode;
	private String couponName;
	private BigDecimal discountPercentage;
	private BigDecimal discountAmount;
	private Date expiryDate;
	private String createdByName;
	private Integer createdBy;
	private String lastModifiedByName;
	private Integer lastModifiedBy;
	private Date creationDate;
	private Date lastModifiedTime;
	private Integer status;
	
	public Coupon(){
		
	}

	public Coupon(Integer couponId, String couponCode, String couponName, BigDecimal discountPercentage, BigDecimal discountAmount, 
			Date expiryDate, Integer createdBy, Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, Integer status){
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.couponName = couponName;
		this.discountPercentage = discountPercentage;
		this.discountAmount = discountAmount;
		this.expiryDate = expiryDate;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public Coupon(String couponCode, String couponName, BigDecimal discountPercentage, BigDecimal discountAmount, 
			Date expiryDate, Integer createdBy, Integer lastModifiedBy, Date creationDate, Date lastModifiedTime, Integer status){
		this.couponCode = couponCode;
		this.couponName = couponName;
		this.discountPercentage = discountPercentage;
		this.discountAmount = discountAmount;
		this.expiryDate = expiryDate;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.creationDate = creationDate;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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
	

}
