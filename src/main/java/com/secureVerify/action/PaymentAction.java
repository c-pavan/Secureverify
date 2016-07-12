package com.secureVerify.action;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.secureVerify.model.Candidate;
import com.secureVerify.model.Coupon;
import com.secureVerify.model.CreditsAvailable;
import com.secureVerify.model.Employer;
import com.secureVerify.model.PaymentDetail;

public class PaymentAction extends MasterAction {

	private static final long serialVersionUID = -9083501860562278760L;
	
	private static final Logger log = Logger.getLogger(PaymentAction.class);
	
	private Integer couponId;
	private String couponCode;
	private String Company;
	private BigDecimal discountAmount;
	

	public Integer ID;
	public Integer partyId;
	public Integer partyTypeId;
	public Integer noOfCreditsBought;
	public String auth_response;
	public String avs_response;
	public String approved;
	public String inv;
	public String FirstName;
	public String LastName;
	public String ExpMonth;
	public String ExpYear;
	public String transid;
	public String Address;
	public String Zip;
	public String EMail;
	public String Phone;
	private String couponCodeValue;
	private BigDecimal priceOfCredit;
	private BigDecimal Total;
	private BigDecimal amount;
	
	
	private Candidate candidate;
	private CreditsAvailable creditsAvailable;
	private Coupon coupon;
	private Employer employer;
	private PaymentDetail paymentDetail;
	

	public String applyCouponCode(){
		try{
			getGlobalContent();
			coupon = couponBo.getActiveCoupon(couponCode);
			if(coupon==null){
				return ERROR;
			}else{
				couponId = coupon.getCouponId();
				couponCode = coupon.getCouponCode();
				discountAmount = coupon.getDiscountAmount();
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getEmployerTransactionApprovedPage(){
		try{
			getGlobalContent();
			urlPage = "employerCreditsManagment";
			employer = (Employer) session.get("employer");
			
			log.trace("Transaction Approved for ID: "+ID+" partyId: "+partyId+" partyTypeId: "+partyTypeId+" transid: "+transid+" priceOfCredit: "+
					priceOfCredit+" noOfCreditsBought: "+noOfCreditsBought+" discountAmount: "+discountAmount+" amount: "+amount+
					" Total: "+Total+" auth_response: "+auth_response+" avs_response: "+avs_response+" approved: "+approved+" inv: "+
					inv+" FirstName: "+FirstName+" LastName: "+LastName+" ExpMonth: "+ExpMonth+" ExpYear: "+ExpYear+" Address: "+Address+
					" Zip: "+Zip+" EMail: "+EMail+" Phone: "+Phone+" couponId: "+couponId+" couponCodeValue: "+couponCodeValue+" Company: "+Company);
			
			if(transid!=null){
				paymentDetail = paymentDetailBo.getPaymentDetail(transid);
				if(paymentDetail!=null){
					return "processed";
				}
			}
			
			paymentDetail = new PaymentDetail(ID, partyId, partyTypeId, transid, priceOfCredit, noOfCreditsBought, Total, 
					discountAmount, amount, new Date(), auth_response, avs_response, approved, inv, FirstName, LastName, 
					ExpMonth, ExpYear, Address, Zip, EMail, Phone, new Date(), couponId);
			paymentDetailBo.addPaymentDetail(paymentDetail);
			
			creditsAvailable = creditsAvailableBo.getCreditsAvailable(partyId, partyTypeId);
			if(creditsAvailable==null){
				creditsAvailable = new CreditsAvailable(partyId, partyTypeId, 0, 0, new Date(), ACTIVE);
				creditsAvailableBo.addCreditsAvailable(creditsAvailable);
				creditsAvailable = creditsAvailableBo.getCreditsAvailable(partyId, partyTypeId);
			}
			int totalNoOfCreditsPurchased = creditsAvailable.getTotalNoOfCreditsPurchased() + noOfCreditsBought;
			int noOfCreditsAvailable = creditsAvailable.getNoOfCreditsAvailable() + noOfCreditsBought;
			creditsAvailable.setTotalNoOfCreditsPurchased(totalNoOfCreditsPurchased);
			creditsAvailable.setNoOfCreditsAvailable(noOfCreditsAvailable);
			creditsAvailable.setLastModified(new Date());
			creditsAvailableBo.updateCreditsAvailable(creditsAvailable);
			
			if(couponId!=null && couponId!=0){
				coupon = couponBo.getCouponByCouponId(couponId);
				coupon.setStatus(INACTIVE);
				couponBo.updateCoupon(coupon);
			}
			

		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void getEmployerTransactionApprovedPageValidator(){
        if(isNumberNullOrZero(getID())){
            addActionError("ID can't be Empty / Zero !!");
        }
        if(isNumberNullOrZero(getPartyId())){
            addActionError("Employer Id can't be Empty / Zero !!");
        }
        if(isNumberNullOrZero(getPartyTypeId())){
            addActionError("Party Type Id can't be Empty / Zero !!");
        }
        if(isEmpty(getTransid())){
            addActionError("Transaction Number can't be empty !!");
        }
    	if(isBigDecimalNullOrZero(getPriceOfCredit())){
    		addActionError("Price Of Each  Credit can't be Empty / Zero !!");
    	}
    	if(isNumberNullOrZero(getNoOfCreditsBought())){
    		addActionError("No Of Credits Bought can't be Empty / Zero !!");
    	}
    	if(isBigDecimalNullOrZero(getTotal())){
    		addActionError("Total Amount Paid can't be Empty / Zero !!");
    	}
    	if(isBigDecimalNullOrZero(getDiscountAmount())){
    		addActionError("Discount Amount can't be Empty / Zero !!");
    	}
    	if(isBigDecimalNullOrZero(getAmount())){
    		addActionError("Amount to Pay can't be Empty / Zero !!");
    	}
        if(isEmpty(getAuth_response())){
            addActionError("Auth Response can't be empty !!");
        }
        if(isEmpty(getAvs_response())){
            addActionError("AVS Response can't be empty !!");
        }
        if(isEmpty(getApproved())){
            addActionError("Approved can't be empty !!");
        }
        if(isEmpty(getInv())){
            addActionError("Invoice Number can't be empty !!");
        }
        if(isEmpty(getFirstName())){
            addActionError("First Name can't be empty !!");
        }
        if(isEmpty(getLastName())){
            addActionError("Last Name can't be empty !!");
        }
        if(isEmpty(getExpMonth())){
            addActionError("Expiry Month can't be empty !!");
        }
        if(isEmpty(getExpYear())){
            addActionError("Expiry Year can't be empty !!");
        }
        if(isEmpty(getAddress())){
            addActionError("Address can't be empty !!");
        }
        if(isEmpty(getZip())){
            addActionError("Zipcode can't be empty !!");
        }
        if(isEmpty(getEMail())){
            addActionError("EMail-Id can't be empty !!");
        }
        if(isEmpty(getPhone())){
            addActionError("Phone can't be empty !!");
        }
        if(isNumberNull(getCouponId())){
            addActionError("Coupon Id be empty !!");
        }
    }
	
	public String getEmployerTransactionSuccessPage(){
		try{
			getGlobalContent();
			urlPage = "employerCreditsManagment";
			employer = (Employer) session.get("employer");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getEmployerTransactionAllReadyProcessedPage(){
		try{
			getGlobalContent();
			urlPage = "employerCreditsManagment";
			employer = (Employer) session.get("employer");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getEmployerTransactionDeclinedPage(){
		try{
			getGlobalContent();
			urlPage = "employerCreditsManagment";
			
			log.trace("Transaction Declined for ID: "+ID+" partyId: "+partyId+" partyTypeId: "+partyTypeId+" transid: "+transid+" priceOfCredit: "+
			priceOfCredit+" noOfCreditsBought: "+noOfCreditsBought+" discountAmount: "+discountAmount+" amount: "+amount+
			" Total: "+Total+" auth_response: "+auth_response+" avs_response: "+avs_response+" approved: "+approved+" inv: "+
			inv+" FirstName: "+FirstName+" LastName: "+LastName+" ExpMonth: "+ExpMonth+" ExpYear: "+ExpYear+" Address: "+Address+
			" Zip: "+Zip+" EMail: "+EMail+" Phone: "+Phone+" couponId: "+couponId+" couponCodeValue: "+couponCodeValue+" Company: "+Company);

			employer = (Employer) session.get("employer");
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getEmployerTransactionErrorPage(){
		try{
			getGlobalContent();
			urlPage = "employerCreditsManagment";
			employer = (Employer) session.get("employer");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getCandidateTransactionApprovedPage(){
		try{
			getGlobalContent();
			urlPage = "candidateCredits";
			candidate = (Candidate) session.get("candidate");

			log.trace("Transaction Approved for ID: "+ID+" partyId: "+partyId+" partyTypeId: "+partyTypeId+" transid: "+transid+" priceOfCredit: "+
					priceOfCredit+" noOfCreditsBought: "+noOfCreditsBought+" discountAmount: "+discountAmount+" amount: "+amount+
					" Total: "+Total+" auth_response: "+auth_response+" avs_response: "+avs_response+" approved: "+approved+" inv: "+
					inv+" FirstName: "+FirstName+" LastName: "+LastName+" ExpMonth: "+ExpMonth+" ExpYear: "+ExpYear+" Address: "+Address+
					" Zip: "+Zip+" EMail: "+EMail+" Phone: "+Phone+" couponId: "+couponId+" couponCodeValue: "+couponCodeValue+" Company: "+Company);

			if(transid!=null){
				paymentDetail = paymentDetailBo.getPaymentDetail(transid);
				if(paymentDetail!=null){
					return "processed";
				}
			}
			
			paymentDetail = new PaymentDetail(ID, partyId, partyTypeId, transid, priceOfCredit, noOfCreditsBought, Total, 
					discountAmount, amount, new Date(), auth_response, avs_response, approved, inv, FirstName, LastName, 
					ExpMonth, ExpYear, Address, Zip, EMail, Phone, new Date(), couponId);
			paymentDetailBo.addPaymentDetail(paymentDetail);

			creditsAvailable = creditsAvailableBo.getCreditsAvailable(partyId, partyTypeId);
			if(creditsAvailable==null){
				creditsAvailable = new CreditsAvailable(partyId, partyTypeId, 0, 0, new Date(), ACTIVE);
				creditsAvailableBo.addCreditsAvailable(creditsAvailable);
				creditsAvailable = creditsAvailableBo.getCreditsAvailable(partyId, partyTypeId);
			}
			int totalNoOfCreditsPurchased = creditsAvailable.getTotalNoOfCreditsPurchased() + noOfCreditsBought;
			int noOfCreditsAvailable = creditsAvailable.getNoOfCreditsAvailable() + noOfCreditsBought;
			creditsAvailable.setTotalNoOfCreditsPurchased(totalNoOfCreditsPurchased);
			creditsAvailable.setNoOfCreditsAvailable(noOfCreditsAvailable);
			creditsAvailable.setLastModified(new Date());
			creditsAvailableBo.updateCreditsAvailable(creditsAvailable);

			if(couponId!=null && couponId!=0){
				coupon = couponBo.getCouponByCouponId(couponId);
				coupon.setStatus(INACTIVE);
				couponBo.updateCoupon(coupon);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

    public void getCandidateTransactionApprovedPageValidator(){
        if(isNumberNullOrZero(getID())){
            addActionError("ID can't be Empty / Zero !!");
        }
        if(isNumberNullOrZero(getPartyId())){
            addActionError("Candidate Id can't be Empty / Zero !!");
        }
        if(isNumberNullOrZero(getPartyTypeId())){
            addActionError("Party Type Id can't be Empty / Zero !!");
        }
        if(isEmpty(getTransid())){
            addActionError("Transaction Number can't be empty !!");
        }
    	if(isBigDecimalNullOrZero(getPriceOfCredit())){
    		addActionError("Price Of Each  Credit can't be Empty / Zero !!");
    	}
    	if(isNumberNullOrZero(getNoOfCreditsBought())){
    		addActionError("No Of Credits Bought can't be Empty / Zero !!");
    	}
    	if(isBigDecimalNullOrZero(getTotal())){
    		addActionError("Total Amount Paid can't be Empty / Zero !!");
    	}
    	if(isBigDecimalNullOrZero(getDiscountAmount())){
    		addActionError("Discount Amount can't be Empty / Zero !!");
    	}
    	if(isBigDecimalNullOrZero(getAmount())){
    		addActionError("Amount to Pay can't be Empty / Zero !!");
    	}
        if(isEmpty(getAuth_response())){
            addActionError("Auth Response can't be empty !!");
        }
        if(isEmpty(getAvs_response())){
            addActionError("AVS Response can't be empty !!");
        }
        if(isEmpty(getApproved())){
            addActionError("Approved can't be empty !!");
        }
        if(isEmpty(getInv())){
            addActionError("Invoice Number can't be empty !!");
        }
        if(isEmpty(getFirstName())){
            addActionError("First Name can't be empty !!");
        }
        if(isEmpty(getLastName())){
            addActionError("Last Name can't be empty !!");
        }
        if(isEmpty(getExpMonth())){
            addActionError("Expiry Month can't be empty !!");
        }
        if(isEmpty(getExpYear())){
            addActionError("Expiry Year can't be empty !!");
        }
        if(isEmpty(getAddress())){
            addActionError("Address can't be empty !!");
        }
        if(isEmpty(getZip())){
            addActionError("Zipcode can't be empty !!");
        }
        if(isEmpty(getEMail())){
            addActionError("EMail-Id can't be empty !!");
        }
        if(isEmpty(getPhone())){
            addActionError("Phone can't be empty !!");
        }
        if(isNumberNull(getCouponId())){
            addActionError("Coupon Id be empty !!");
        }
    }
	
	public String getCandidateTransactionSuccessPage(){
		try{
			getGlobalContent();
			urlPage = "candidateCredits";
			candidate = (Candidate) session.get("candidate");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getCandidateTransactionAllReadyProcessedPage(){
		try{
			getGlobalContent();
			urlPage = "candidateCredits";
			candidate = (Candidate) session.get("candidate");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getCandidateTransactionDeclinedPage(){
		try{
			getGlobalContent();
			urlPage = "candidateCredits";
			
			log.trace("Transaction Declined for ID: "+ID+" partyId: "+partyId+" partyTypeId: "+partyTypeId+" transid: "+transid+" priceOfCredit: "+
			priceOfCredit+" noOfCreditsBought: "+noOfCreditsBought+" discountAmount: "+discountAmount+" amount: "+amount+
			" Total: "+Total+" auth_response: "+auth_response+" avs_response: "+avs_response+" approved: "+approved+" inv: "+
			inv+" FirstName: "+FirstName+" LastName: "+LastName+" ExpMonth: "+ExpMonth+" ExpYear: "+ExpYear+" Address: "+Address+
			" Zip: "+Zip+" EMail: "+EMail+" Phone: "+Phone+" couponId: "+couponId+" couponCodeValue: "+couponCodeValue+" Company: "+Company);

			candidate = (Candidate) session.get("candidate");
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getCandidateTransactionErrorPage(){
		try{
			getGlobalContent();
			urlPage = "candidateCredits";
			candidate = (Candidate) session.get("candidate");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
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

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
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

	public Integer getNoOfCreditsBought() {
		return noOfCreditsBought;
	}

	public void setNoOfCreditsBought(Integer noOfCreditsBought) {
		this.noOfCreditsBought = noOfCreditsBought;
	}

	public String getAuth_response() {
		return auth_response;
	}

	public void setAuth_response(String auth_response) {
		this.auth_response = auth_response;
	}

	public String getAvs_response() {
		return avs_response;
	}

	public void setAvs_response(String avs_response) {
		this.avs_response = avs_response;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getInv() {
		return inv;
	}

	public void setInv(String inv) {
		this.inv = inv;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getExpMonth() {
		return ExpMonth;
	}

	public void setExpMonth(String expMonth) {
		ExpMonth = expMonth;
	}

	public String getExpYear() {
		return ExpYear;
	}

	public void setExpYear(String expYear) {
		ExpYear = expYear;
	}

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String eMail) {
		EMail = eMail;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public BigDecimal getPriceOfCredit() {
		return priceOfCredit;
	}

	public void setPriceOfCredit(BigDecimal priceOfCredit) {
		this.priceOfCredit = priceOfCredit;
	}

	public BigDecimal getTotal() {
		return Total;
	}

	public void setTotal(BigDecimal total) {
		Total = total;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getCouponCodeValue() {
		return couponCodeValue;
	}

	public void setCouponCodeValue(String couponCodeValue) {
		this.couponCodeValue = couponCodeValue;
	}

	public CreditsAvailable getCreditsAvailable() {
		return creditsAvailable;
	}

	public void setCreditsAvailable(CreditsAvailable creditsAvailable) {
		this.creditsAvailable = creditsAvailable;
	}
	

}
