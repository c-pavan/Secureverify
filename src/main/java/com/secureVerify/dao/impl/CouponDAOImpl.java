package com.secureVerify.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.CouponDAO;
import com.secureVerify.model.Coupon;

public class CouponDAOImpl extends HibernateDaoSupport implements CouponDAO {

	public void addCoupon(Coupon coupon) {
		getHibernateTemplate().save(coupon);
	}

	public void updateCoupon(Coupon coupon) {
		getHibernateTemplate().update(coupon);
	}

	public void deleteCoupon(Coupon coupon) {
		getHibernateTemplate().delete(coupon);
	}

	public void deleteCouponList(List<Coupon> couponList) {
		getHibernateTemplate().deleteAll(couponList);
	}

	@SuppressWarnings("unchecked")
	public List<Coupon> listCoupon() {
		return getHibernateTemplate().find("from Coupon c order by c.couponId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Coupon> listActiveCoupon() {
		return getHibernateTemplate().find("from Coupon c where c.status = 1 order by c.couponId desc");
	}

	@SuppressWarnings("unchecked")
	public List<Coupon> searchCoupon(Integer couponId, String couponCode,
			String couponName, BigDecimal discountPercentage,
			BigDecimal discountAmount, Date expiryFromDate, Date expirytoDate, Integer createdBy,
			Integer lastModifiedBy, Date fromDate, Date toDate, Integer status, Integer startRecord, Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Coupon.class);
		if(couponId!=null){
			criteria.add(Restrictions.eq("couponId", couponId));
		}
		if(couponCode!=null && !couponCode.trim().equals("")){
			criteria.add(Restrictions.like("couponCode", "%"+ couponCode +"%"));
		}
		if(couponName!=null && !couponName.trim().equals("")){
			criteria.add(Restrictions.like("couponName", "%"+ couponName +"%"));
		}
		if(discountPercentage!=null){
			criteria.add(Restrictions.like("discountPercentage", discountPercentage));
		}
		if(discountAmount!=null){
			criteria.add(Restrictions.like("discountAmount", discountAmount));
		}
		if(expiryFromDate!=null && expirytoDate!=null){
			criteria.add(Restrictions.between("expiryDate", expiryFromDate, expirytoDate));
		}else if(expiryFromDate!=null){
			criteria.add(Restrictions.ge("expiryDate", expiryFromDate));
		}else if(expirytoDate!=null){
			criteria.add(Restrictions.le("expiryDate", expirytoDate));
		}
		if(createdBy!=null && createdBy!=0){
			criteria.add(Restrictions.eq("createdBy", createdBy));
		}
		if(lastModifiedBy!=null && lastModifiedBy!=0){
			criteria.add(Restrictions.eq("lastModifiedBy", lastModifiedBy));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("expiryDate", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("expiryDate", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("expiryDate", toDate));
		}
		if(status!=null){
			criteria.add(Restrictions.eq("status", status));
		}
		criteria.addOrder(Order.desc("couponId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public Coupon getCouponByCouponId(Integer couponId) {
		List<Coupon> couponList = getHibernateTemplate().find("from Coupon where couponId = ?", couponId);
		if(couponList!=null && !couponList.isEmpty()){ return couponList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Coupon getCoupon(String couponCode) {
		List<Coupon> couponList = getHibernateTemplate().find("from Coupon where upper(couponCode) = ?", couponCode.toUpperCase());
		if(couponList!=null && !couponList.isEmpty()){ return couponList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Coupon getActiveCoupon(String couponCode) {
		List<Coupon> couponList = getHibernateTemplate().find("from Coupon where upper(couponCode) = ? and status = 1", couponCode.toUpperCase());
		if(couponList!=null && !couponList.isEmpty()){ return couponList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public List<Coupon> getCouponByCouponName(String couponName) {
		return getHibernateTemplate().find("from Coupon where couponName = ?", couponName);
	}

	@SuppressWarnings("unchecked")
	public List<Coupon> getCouponsByExpiryDate(Date expiryDate) {
		return getHibernateTemplate().find("from Coupon where expiryDate = ?", expiryDate);
	}

	@SuppressWarnings("unchecked")
	public List<Coupon> getCouponListByPage(final int startRecord, final int endRecord) {
		return (List<Coupon>) getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Coupon c order by c.couponId desc");
				query.setFirstResult(startRecord);
				query.setMaxResults(endRecord);
				List<Coupon> list = query.list();
				return list;
			}
		});
	}

	public Integer getCouponListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Coupon"));
	}
	
	public Integer getCouponListCount(String couponCode, String couponName, Date expiryFromDate, Date expirytoDate) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Coupon.class);
		
		if(couponCode!=null && !couponCode.trim().equals("")){
			criteria.add(Restrictions.like("couponCode", "%"+ couponCode +"%"));
		}
		if(couponName!=null && !couponName.trim().equals("")){
			criteria.add(Restrictions.like("couponName", "%"+ couponName +"%"));
		}
		if(expiryFromDate!=null && expirytoDate!=null){
			criteria.add(Restrictions.between("expiryDate", expiryFromDate, expirytoDate));
		}else if(expiryFromDate!=null){
			criteria.add(Restrictions.ge("expiryDate", expiryFromDate));
		}else if(expirytoDate!=null){
			criteria.add(Restrictions.le("expiryDate", expirytoDate));
		}
		
		return getHibernateTemplate().findByCriteria(criteria).size();
	}
}

