package com.secureVerify.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.secureVerify.model.PaymentDetail;

public interface PaymentDetailDAO {

	void addPaymentDetail(PaymentDetail paymentDetail);
	
	void updatePaymentDetail(PaymentDetail paymentDetail);
	
	void deletePaymentDetail(PaymentDetail paymentDetail);
	
	void deletePaymentDetailList(List<PaymentDetail> paymentDetailList);
	
	List<PaymentDetail> listPaymentDetail();
	
	List<PaymentDetail> getPaymentDetail(Integer partyId, Integer partyTypeId);
	
	List<PaymentDetail> searchPaymentDetail(Integer paymentDetailsId, Integer partyId, Integer partyTypeId, 
			String transactionNumber, BigDecimal priceOfCredit, Integer noOfCreditsBought, BigDecimal totalAmount, 
			BigDecimal discountAmount, BigDecimal amount, Date paymentDate, String authResponse, String avsResponse, 
			String approved, String invoiceNumber, String firstName, String lastName, String expMonth, String expYear, 
			String address, String zip, String emailId, String phone, Integer couponId, Date fromDate, Date toDate, 
			Integer startRecord, Integer endRecord);
	
	PaymentDetail getPaymentDetail(Integer paymentDetailsId);
	
	PaymentDetail getPaymentDetail(String transactionNumber);
	
	Integer selectMaxPaymentDetailId();
	
	Integer getPaymentDetailListCount();

	Integer getPaymentDetailListCount(Integer partyId, Integer partyTypeId);

	Integer searchPaymentDetail(Integer paymentDetailsId, Integer partyId, Integer partyTypeId, 
			String transactionNumber, BigDecimal priceOfCredit, Integer noOfCreditsBought, BigDecimal totalAmount, 
			BigDecimal discountAmount, BigDecimal amount, Date paymentDate, String authResponse, String avsResponse, 
			String approved, String invoiceNumber, String firstName, String lastName, String expMonth, String expYear, 
			String address, String zip, String emailId, String phone, Integer couponId, Date fromDate, Date toDate);
	
	List<PaymentDetail> getPaymentDetailListByPage(final Integer startRecord, final Integer endRecord);
	
	PaymentDetail getPaymentDetailByPartyTypeId(Integer partyTypeId);
}
