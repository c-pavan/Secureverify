package com.secureVerify.model;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentDetail implements java.io.Serializable {

	private static final long serialVersionUID = 2485665380049023682L;
	
	private Integer paymentDetailsId;
	private Integer partyId;
	private Integer partyTypeId;
	private String transactionNumber;
	private BigDecimal priceOfCredit;
	private Integer noOfCreditsBought;
	private BigDecimal totalAmount;
	private BigDecimal discountAmount;
	private BigDecimal amount;
	private Date paymentDate;
	private String authResponse;
	private String avsResponse;
	private String approved;
	private String invoiceNumber;
	private String firstName;
	private String lastName;
	private String expMonth;
	private String expYear;
	private String address;
	private String zip;
	private String emailId;
	private String phone;
	private Date lastModified;
	private Integer couponId;
	
	private Coupon coupon;

	public PaymentDetail() {
		
	}

	public PaymentDetail(Integer paymentDetailsId, Integer partyId, Integer partyTypeId, String transactionNumber, BigDecimal priceOfCredit, 
			Integer noOfCreditsBought, BigDecimal totalAmount, BigDecimal discountAmount, BigDecimal amount, Date paymentDate, 
			String authResponse, String avsResponse, String approved, String invoiceNumber, String firstName, String lastName, 
			String expMonth, String expYear, String address, String zip, String emailId, String phone, Date lastModified, Integer couponId) {
		this.paymentDetailsId = paymentDetailsId;
		this.partyId = partyId;
		this.partyTypeId = partyTypeId;
		this.transactionNumber = transactionNumber;
		this.priceOfCredit = priceOfCredit;
		this.noOfCreditsBought = noOfCreditsBought;
		this.totalAmount = totalAmount;
		this.discountAmount = discountAmount;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.authResponse = authResponse;
		this.avsResponse = avsResponse;
		this.approved = approved;
		this.invoiceNumber = invoiceNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.address = address;
		this.zip = zip;
		this.emailId = emailId;
		this.phone = phone;
		this.lastModified = lastModified;
		this.couponId = couponId;
	}

	public PaymentDetail(Integer partyId, Integer partyTypeId, String transactionNumber, BigDecimal priceOfCredit, 
			Integer noOfCreditsBought, BigDecimal totalAmount, BigDecimal discountAmount, BigDecimal amount, Date paymentDate, 
			String authResponse, String avsResponse, String approved, String invoiceNumber, String firstName, String lastName, 
			String expMonth, String expYear, String address, String zip, String emailId, String phone, Date lastModified, Integer couponId) {
		this.partyId = partyId;
		this.partyTypeId = partyTypeId;
		this.transactionNumber = transactionNumber;
		this.priceOfCredit = priceOfCredit;
		this.noOfCreditsBought = noOfCreditsBought;
		this.totalAmount = totalAmount;
		this.discountAmount = discountAmount;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.authResponse = authResponse;
		this.avsResponse = avsResponse;
		this.approved = approved;
		this.invoiceNumber = invoiceNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.address = address;
		this.zip = zip;
		this.emailId = emailId;
		this.phone = phone;
		this.lastModified = lastModified;
		this.couponId = couponId;
	}

	public Integer getPaymentDetailsId() {
		return paymentDetailsId;
	}

	public void setPaymentDetailsId(Integer paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public Integer getPartyTypeId() {
		return partyTypeId;
	}

	public void setPartyTypeId(Integer partyTypeId) {
		this.partyTypeId = partyTypeId;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public BigDecimal getPriceOfCredit() {
		return priceOfCredit;
	}

	public void setPriceOfCredit(BigDecimal priceOfCredit) {
		this.priceOfCredit = priceOfCredit;
	}

	public Integer getNoOfCreditsBought() {
		return noOfCreditsBought;
	}

	public void setNoOfCreditsBought(Integer noOfCreditsBought) {
		this.noOfCreditsBought = noOfCreditsBought;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getAuthResponse() {
		return authResponse;
	}

	public void setAuthResponse(String authResponse) {
		this.authResponse = authResponse;
	}

	public String getAvsResponse() {
		return avsResponse;
	}

	public void setAvsResponse(String avsResponse) {
		this.avsResponse = avsResponse;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}


}
