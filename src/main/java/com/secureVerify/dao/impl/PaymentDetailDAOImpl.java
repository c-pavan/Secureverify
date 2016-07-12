package com.secureVerify.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secureVerify.dao.PaymentDetailDAO;
import com.secureVerify.model.PaymentDetail;

public class PaymentDetailDAOImpl extends HibernateDaoSupport implements PaymentDetailDAO {

	public void addPaymentDetail(PaymentDetail paymentDetail) {
		getHibernateTemplate().save(paymentDetail);
	}

	public void updatePaymentDetail(PaymentDetail paymentDetail) {
		getHibernateTemplate().update(paymentDetail);
	}

	public void deletePaymentDetail(PaymentDetail paymentDetail) {
		getHibernateTemplate().delete(paymentDetail);
	}

	public void deletePaymentDetailList(List<PaymentDetail> paymentDetailList) {
		getHibernateTemplate().deleteAll(paymentDetailList);
	}

	@SuppressWarnings("unchecked")
	public List<PaymentDetail> listPaymentDetail() {
		return getHibernateTemplate().find("from PaymentDetail");
	}

	@SuppressWarnings("unchecked")
	public List<PaymentDetail> getPaymentDetail(Integer partyId, Integer partyTypeId) {
		Object[] values = {partyId, partyTypeId};
		return getHibernateTemplate().find("from PaymentDetail where partyId = ? and partyTypeId = ?", values);
	}

	@SuppressWarnings("unchecked")
	public List<PaymentDetail> searchPaymentDetail(Integer paymentDetailsId,
			Integer partyId, Integer partyTypeId, String transactionNumber,
			BigDecimal priceOfCredit, Integer noOfCreditsBought,
			BigDecimal totalAmount, BigDecimal discountAmount,
			BigDecimal amount, Date paymentDate, String authResponse,
			String avsResponse, String approved, String invoiceNumber,
			String firstName, String lastName, String expMonth, String expYear,
			String address, String zip, String emailId, String phone,
			Integer couponId, Date fromDate, Date toDate, Integer startRecord,
			Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PaymentDetail.class);
		if(paymentDetailsId!=null){
			criteria.add(Restrictions.eq("paymentDetailsId", paymentDetailsId));
		}
		if(partyId!=null && partyId!=0){
			criteria.add(Restrictions.eq("partyId", partyId));
		}
		if(partyTypeId!=null && partyTypeId!=0){
			criteria.add(Restrictions.eq("partyTypeId", partyTypeId));
		}
		if(transactionNumber!=null && !transactionNumber.equals("")){
			criteria.add(Restrictions.ilike("transactionNumber", "%"+transactionNumber+"%"));
		}
		if(priceOfCredit!=null){
			criteria.add(Restrictions.eq("priceOfCredit", priceOfCredit));
		}
		if(noOfCreditsBought!=null && noOfCreditsBought!=0){
			criteria.add(Restrictions.eq("noOfCreditsBought", noOfCreditsBought));
		}
		if(totalAmount!=null){
			criteria.add(Restrictions.eq("totalAmount", totalAmount));
		}
		if(discountAmount!=null){
			criteria.add(Restrictions.eq("discountAmount", discountAmount));
		}
		if(amount!=null){
			criteria.add(Restrictions.eq("amount", amount));
		}
		if(paymentDate!=null){
			criteria.add(Restrictions.eq("paymentDate", paymentDate));
		}
		if(authResponse!=null && !authResponse.equals("")){
			criteria.add(Restrictions.ilike("authResponse", authResponse));
		}
		if(avsResponse!=null && !avsResponse.equals("")){
			criteria.add(Restrictions.ilike("avsResponse", avsResponse));
		}
		if(approved!=null && !approved.equals("")){
			criteria.add(Restrictions.ilike("approved", approved));
		}
		if(invoiceNumber!=null && !invoiceNumber.equals("")){
			criteria.add(Restrictions.ilike("invoiceNumber", "%"+invoiceNumber+"%"));
		}
		if(firstName!=null && !firstName.equals("")){
			criteria.add(Restrictions.ilike("firstName", "%"+firstName+"%"));
		}
		if(lastName!=null && !lastName.equals("")){
			criteria.add(Restrictions.ilike("lastName", "%"+lastName+"%"));
		}
		if(expMonth!=null && !expMonth.equals("")){
			criteria.add(Restrictions.ilike("expMonth", expMonth));
		}
		if(expYear!=null && !expYear.equals("")){
			criteria.add(Restrictions.ilike("expYear", expYear));
		}
		if(address!=null && !address.equals("")){
			criteria.add(Restrictions.ilike("address", "%"+address+"%"));
		}
		if(zip!=null && !zip.equals("")){
			criteria.add(Restrictions.ilike("zip", "%"+zip+"%"));
		}
		if(emailId!=null && !emailId.equals("")){
			criteria.add(Restrictions.ilike("emailId", "%"+emailId+"%"));
		}
		if(phone!=null && !phone.equals("")){
			criteria.add(Restrictions.ilike("phone", "%"+phone+"%"));
		}
		if(couponId!=null && couponId!=0){
			criteria.add(Restrictions.eq("couponId", couponId));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("lastModified", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("lastModified", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("lastModified", toDate));
		}
		criteria.addOrder(Order.desc("paymentDetailsId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public PaymentDetail getPaymentDetail(Integer paymentDetailsId) {
		List<PaymentDetail> paymentDetailList = getHibernateTemplate().find("from PaymentDetail where paymentDetailsId = ?", paymentDetailsId);
		if(paymentDetailList!=null && !paymentDetailList.isEmpty()){ return paymentDetailList.get(0); }else{ return null; }
	}
	
	@SuppressWarnings("unchecked")
	public PaymentDetail getPaymentDetail(String transactionNumber) {
		List<PaymentDetail> paymentDetailList = getHibernateTemplate().find("from PaymentDetail where transactionNumber = ?", transactionNumber);
		if(paymentDetailList!=null && !paymentDetailList.isEmpty()){ return paymentDetailList.get(0); }else{ return null; }
	}

	@SuppressWarnings("unchecked")
	public Integer selectMaxPaymentDetailId() {
		DetachedCriteria c1 = DetachedCriteria.forClass(PaymentDetail.class).setProjection(Projections.max("paymentDetailsId"));
		List<Integer> maxIds = getHibernateTemplate().findByCriteria(c1);
		if(maxIds!=null && !maxIds.isEmpty()){
			return maxIds.get(0);
		}
		return 0;
	}

	public Integer getPaymentDetailListCount() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from PaymentDetail"));
	}

	public Integer getPaymentDetailListCount(Integer partyId, Integer partyTypeId) {
		Object[] values = {partyId, partyTypeId};
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from PaymentDetail where partyId = ? and partyTypeId = ?", values));
	}

	public Integer searchPaymentDetail(Integer paymentDetailsId,
			Integer partyId, Integer partyTypeId, String transactionNumber,
			BigDecimal priceOfCredit, Integer noOfCreditsBought,
			BigDecimal totalAmount, BigDecimal discountAmount,
			BigDecimal amount, Date paymentDate, String authResponse,
			String avsResponse, String approved, String invoiceNumber,
			String firstName, String lastName, String expMonth, String expYear,
			String address, String zip, String emailId, String phone,
			Integer couponId, Date fromDate, Date toDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PaymentDetail.class);
		if(paymentDetailsId!=null){
			criteria.add(Restrictions.eq("paymentDetailsId", paymentDetailsId));
		}
		if(partyId!=null && partyId!=0){
			criteria.add(Restrictions.eq("partyId", partyId));
		}
		if(partyTypeId!=null && partyTypeId!=0){
			criteria.add(Restrictions.eq("partyTypeId", partyTypeId));
		}
		if(transactionNumber!=null && !transactionNumber.equals("")){
			criteria.add(Restrictions.ilike("transactionNumber", "%"+transactionNumber+"%"));
		}
		if(priceOfCredit!=null){
			criteria.add(Restrictions.eq("priceOfCredit", priceOfCredit));
		}
		if(noOfCreditsBought!=null && noOfCreditsBought!=0){
			criteria.add(Restrictions.eq("noOfCreditsBought", noOfCreditsBought));
		}
		if(totalAmount!=null){
			criteria.add(Restrictions.eq("totalAmount", totalAmount));
		}
		if(discountAmount!=null){
			criteria.add(Restrictions.eq("discountAmount", discountAmount));
		}
		if(amount!=null){
			criteria.add(Restrictions.eq("amount", amount));
		}
		if(paymentDate!=null){
			criteria.add(Restrictions.eq("paymentDate", paymentDate));
		}
		if(authResponse!=null && !authResponse.equals("")){
			criteria.add(Restrictions.ilike("authResponse", authResponse));
		}
		if(avsResponse!=null && !avsResponse.equals("")){
			criteria.add(Restrictions.ilike("avsResponse", avsResponse));
		}
		if(approved!=null && !approved.equals("")){
			criteria.add(Restrictions.ilike("approved", approved));
		}
		if(invoiceNumber!=null && !invoiceNumber.equals("")){
			criteria.add(Restrictions.ilike("invoiceNumber", "%"+invoiceNumber+"%"));
		}
		if(firstName!=null && !firstName.equals("")){
			criteria.add(Restrictions.ilike("firstName", "%"+firstName+"%"));
		}
		if(lastName!=null && !lastName.equals("")){
			criteria.add(Restrictions.ilike("lastName", "%"+lastName+"%"));
		}
		if(expMonth!=null && !expMonth.equals("")){
			criteria.add(Restrictions.ilike("expMonth", expMonth));
		}
		if(expYear!=null && !expYear.equals("")){
			criteria.add(Restrictions.ilike("expYear", expYear));
		}
		if(address!=null && !address.equals("")){
			criteria.add(Restrictions.ilike("address", "%"+address+"%"));
		}
		if(zip!=null && !zip.equals("")){
			criteria.add(Restrictions.ilike("zip", "%"+zip+"%"));
		}
		if(emailId!=null && !emailId.equals("")){
			criteria.add(Restrictions.ilike("emailId", "%"+emailId+"%"));
		}
		if(phone!=null && !phone.equals("")){
			criteria.add(Restrictions.ilike("phone", "%"+phone+"%"));
		}
		if(couponId!=null && couponId!=0){
			criteria.add(Restrictions.eq("couponId", couponId));
		}
		if(fromDate!=null && toDate!=null){
			criteria.add(Restrictions.between("lastModified", fromDate, toDate));
		}else if(fromDate!=null){
			criteria.add(Restrictions.ge("lastModified", fromDate));
		}else if(toDate!=null){
			criteria.add(Restrictions.le("lastModified", toDate));
		}
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentDetail> getPaymentDetailListByPage(final Integer startRecord, final	Integer endRecord) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PaymentDetail.class);
		criteria.addOrder(Order.desc("paymentDetailsId"));
		if(startRecord!=null){
			criteria.getExecutableCriteria(getSession()).setFirstResult(startRecord);
		}
		if(endRecord!=null){
			criteria.getExecutableCriteria(getSession()).setMaxResults(endRecord);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public PaymentDetail getPaymentDetailByPartyTypeId(Integer partyTypeId) {
		List<PaymentDetail> paymentDetailList = getHibernateTemplate().find("from PaymentDetail where partyTypeId = ?", partyTypeId);
		if(paymentDetailList!=null && !paymentDetailList.isEmpty()){ return paymentDetailList.get(0); }else{ return null; }
	}

}
