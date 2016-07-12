package com.secureVerify.bo.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.secureVerify.bo.PaymentDetailBo;
import com.secureVerify.dao.PaymentDetailDAO;
import com.secureVerify.model.PaymentDetail;

public class PaymentDetailBoImpl implements PaymentDetailBo {

	PaymentDetailDAO paymentDetailDAO;
	
	//DI via Spring
	public void setPaymentDetailDAO(PaymentDetailDAO paymentDetailDAO){
		this.paymentDetailDAO = paymentDetailDAO;
	}
	
	public void addPaymentDetail(PaymentDetail paymentDetail) {
		paymentDetailDAO.addPaymentDetail(paymentDetail);
	}

	public void updatePaymentDetail(PaymentDetail paymentDetail) {
		paymentDetailDAO.updatePaymentDetail(paymentDetail);
	}

	public void deletePaymentDetail(PaymentDetail paymentDetail) {
		paymentDetailDAO.deletePaymentDetail(paymentDetail);
	}

	public void deletePaymentDetailList(List<PaymentDetail> paymentDetailList) {
		paymentDetailDAO.deletePaymentDetailList(paymentDetailList);
	}

	public List<PaymentDetail> listPaymentDetail() {
		return paymentDetailDAO.listPaymentDetail();
	}

	public List<PaymentDetail> getPaymentDetail(Integer partyId, Integer partyTypeId) {
		return paymentDetailDAO.getPaymentDetail(partyId, partyTypeId);
	}

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
		return paymentDetailDAO.searchPaymentDetail(paymentDetailsId, partyId, partyTypeId, transactionNumber, 
				priceOfCredit, noOfCreditsBought, totalAmount, discountAmount, amount, paymentDate, authResponse, 
				avsResponse, approved, invoiceNumber, firstName, lastName, expMonth, expYear, address, zip, emailId, 
				phone, couponId, fromDate, toDate, startRecord, endRecord);
	}

	public PaymentDetail getPaymentDetail(Integer paymentDetailsId) {
		return paymentDetailDAO.getPaymentDetail(paymentDetailsId);
	}

	public PaymentDetail getPaymentDetail(String transactionNumber) {
		return paymentDetailDAO.getPaymentDetail(transactionNumber);
	}

	public Integer selectMaxPaymentDetailId() {
		return paymentDetailDAO.selectMaxPaymentDetailId();
	}

	public Integer getPaymentDetailListCount() {
		return paymentDetailDAO.getPaymentDetailListCount();
	}

	public Integer getPaymentDetailListCount(Integer partyId, Integer partyTypeId) {
		return paymentDetailDAO.getPaymentDetailListCount(partyId, partyTypeId);
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
		return paymentDetailDAO.searchPaymentDetail(paymentDetailsId, partyId, partyTypeId, transactionNumber, priceOfCredit, 
				noOfCreditsBought, totalAmount, discountAmount, amount, paymentDate, authResponse, avsResponse, approved, 
				invoiceNumber, firstName, lastName, expMonth, expYear, address, zip, emailId, phone, couponId, fromDate, toDate);
	}

	public List<PaymentDetail> getPaymentDetailListByPage(final Integer startRecord, final	Integer endRecord) {
		return paymentDetailDAO.getPaymentDetailListByPage(startRecord, endRecord);
	}
	
	public PaymentDetail getPaymentDetailByPartyTypeId(Integer partyTypeId){
		return paymentDetailDAO.getPaymentDetailByPartyTypeId(partyTypeId);
	}

}
