package com.secureVerify.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.secureVerify.model.Coupon;

public interface CouponBo {

	void addCoupon(Coupon coupon);
	
	void updateCoupon(Coupon coupon);
	
	void deleteCoupon(Coupon coupon);
	
	void deleteCouponList(List<Coupon> couponList);
	
	List<Coupon> listCoupon();
	
	List<Coupon> listActiveCoupon();
	
	List<Coupon> searchCoupon(Integer couponId, String couponCode, String couponName, BigDecimal discountPercentage, BigDecimal discountAmount, 
			Date expiryFromDate, Date expirytoDate, Integer createdBy, Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, 
			Integer startRecord, Integer endRecord);
	
	Coupon getCouponByCouponId(Integer couponId);
	
	Coupon getCoupon(String couponCode);
	
	Coupon getActiveCoupon(String couponCode);
	
	List<Coupon> getCouponByCouponName(String couponName);
	
	List<Coupon> getCouponsByExpiryDate(Date expiryDate);
	
	List<Coupon> getCouponListByPage(final int startRecord, final int endRecord);
	
	Integer getCouponListCount();
	
	Integer getCouponListCount(String couponCode, String couponName, Date expiryFromDate, Date expirytoDate);
}
