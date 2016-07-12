package com.secureVerify.bo.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.secureVerify.bo.CouponBo;
import com.secureVerify.dao.CouponDAO;
import com.secureVerify.model.Coupon;

public class CouponBoImpl implements CouponBo {

	CouponDAO couponDAO;
	
	//DI via Spring
	public void setCouponDAO(CouponDAO couponDAO){
		this.couponDAO = couponDAO;
	}
	
	public void addCoupon(Coupon coupon) {
		couponDAO.addCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon) {
		couponDAO.updateCoupon(coupon);
	}

	public void deleteCoupon(Coupon coupon) {
		couponDAO.deleteCoupon(coupon);
	}

	public void deleteCouponList(List<Coupon> couponList) {
		couponDAO.deleteCouponList(couponList);
	}

	public List<Coupon> listCoupon() {
		return couponDAO.listCoupon();
	}

	public List<Coupon> listActiveCoupon() {
		return couponDAO.listActiveCoupon();
	}

	public List<Coupon> searchCoupon(Integer couponId, String couponCode,
			String couponName, BigDecimal discountPercentage,
			BigDecimal discountAmount, Date expiryFromDate, Date expirytoDate, Integer createdBy,
			Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		return couponDAO.searchCoupon(couponId, couponCode, couponName, discountPercentage, discountAmount, expiryFromDate, 
				expirytoDate, createdBy, lastModifiedBy, fromDate, toDate, status, startRecord, endRecord);
	}

	public Coupon getCouponByCouponId(Integer couponId) {
		return couponDAO.getCouponByCouponId(couponId);
	}

	public Coupon getCoupon(String couponCode) {
		return couponDAO.getCoupon(couponCode);
	}

	public Coupon getActiveCoupon(String couponCode) {
		return couponDAO.getActiveCoupon(couponCode);
	}

	public List<Coupon> getCouponByCouponName(String couponName) {
		return couponDAO.getCouponByCouponName(couponName);
	}

	public List<Coupon> getCouponsByExpiryDate(Date expiryDate) {
		return couponDAO.getCouponsByExpiryDate(expiryDate);
	}

	public List<Coupon> getCouponListByPage(int startRecord, int endRecord) {
		return couponDAO.getCouponListByPage(startRecord, endRecord);
	}

	public Integer getCouponListCount() {
		return couponDAO.getCouponListCount();
	}
	
	public Integer getCouponListCount(String couponCode, String couponName, Date expiryFromDate, Date expirytoDate) {
		return couponDAO.getCouponListCount(couponCode, couponName, expiryFromDate, expirytoDate);
	}

}
