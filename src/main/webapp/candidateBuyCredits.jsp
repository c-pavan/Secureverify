<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Buy Credits | Secure Verify</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="includes/links.jsp"%>
</head>
<body>
<div id="main-wrapper" class="payment-page">
<%@include file="includes/header.jsp"%>
  <div id="page-content">
    <div class="container">
      <div class="row">
      <%@include file="includes/candidateLeftMenu.jsp"%>
      <div class="col-sm-9 page-content">
        <%@include file="includes/alertBoxSuccessError.jsp"%>
          <div class="white-container sign-up-form">
            <div class="col-xs-12 p0 green-bg">
              <div class="bottom-admin-line">
                <div class="col-sm-12 no-padding">
                  <h5 class="m0 clr-white pl25">Buy Credits</h5>
                </div>
              </div>
            </div>
            <div class="clear"></div>
            <div class="col-sm-9 pb20">
            	<h6 class="label heading">Cart Details</h6>
            	<div class="table-responsive">
            <table class="table table-bordered table-striped m0">
                <thead>
                  <tr>
                    <th>Amount per Credit</th>
                    <th>No. of Credits</th>
                    <th>Amount</th>
                  </tr>
                </thead>
                <tbody>
                <s:if test="creditTypes!=null">
                
              	<input type="hidden" name="amount_per_credit" id="amount_per_credit" value="<s:property value="creditTypes.amount"/>" />
              	<input type="hidden" name="amount_to_pay" id="amount_to_pay" value="0" />
              	<input type="hidden" name="no_of_credits_selected" id="no_of_credits_selected" value="0" />
              	<input type="hidden" name="coupon_id" id="coupon_id" value="0" />
              	<input type="hidden" name="coupon_code" id="coupon_code" value="" />
              	<input type="hidden" name="coupon_code_discount_amount" id="coupon_code_discount_amount" value="0" />
              	<input type="hidden" name="total_amount_to_pay" id="total_amount_to_pay" value="0" />
              	
                  <tr>
                    <td>$ <s:property value="creditTypes.amount"/></td>
                    <td>
	                    <select id="no_of_credits" name="no_of_credits" onchange="calculateAmount();">
	                      <option value="" selected="selected">No. of Credits</option>
	                      <%for(int i=1; i <=30; i++){ %>
	                      <option value="<%=i %>"><%=i %></option>
	                      <%} %>
	                    </select>
                    </td>
                    <td id="credit_amount">$ 0</td>
                  </tr>
                  <tr  id="coupon_code_discount_row" class="discount-row">
                    <td colspan="2" class="highlight-text">Discount</td>
                    <td id="coupon_code_discount">$ 0</td>
                  </tr>
                  <tr>
                    <td colspan="2" class="highlight-text">Total</td>
                    <td id="total_amount">$ 0</td>
                  </tr>
                </s:if>
                  
                </tbody>
              </table>
              </div>
              <div class="payment-coupon mt10">
              	<label><input type="checkbox" name="coupon" value="coupon"> I have a coupon code</label>
                <div class="coupon" style="overflow: hidden; display: none;">
					<div class="col-sm-5 p0">
	              		<div class="input-group">
		                  <input type="text" class="form-control" id="couponCode" name="couponCode" value="" placeholder="Coupon Code">
		                  <span class="input-group-btn">
		             		<button class="btn btn-success zipsearch-btn" type="button" id="couponCodeButton" name="couponCodeButton" onclick="applyCouponCode();" >Apply</button> 
		                  </span> 
		                </div>                    
	                </div>	
	                <div class="col-sm-1 p0"><img src="<%=properties.getProperty("CONTEXT_PATH").toString() %>img/loader.gif" alt="" id="" class="couponloading"/></div>  	
				</div>
              </div>             
              
            	<h6 class="label heading mt30">Payment Details</h6>
              <form id="dummyForm" name="dummyForm" action="#" method="post" onsubmit="return false;"  >
                <div class="row">
                  <div class="col-sm-6">
                  <h6 class="label">First Name on Credit Card</h6>
                    <input type="text" class="form-control" id="first_name" name="first_name" onkeypress="return keyRestrict(event,'vchar');" placeholder="First Name on Card" />
                  </div>
                  <div class="col-sm-6">
                  <h6 class="label">Last Name on Credit Card</h6>
                    <input type="text" class="form-control" id="last_name" name="last_name" onkeypress="return keyRestrict(event,'vchar');" placeholder="Last Name on Card" />
                  </div>
                </div>
                <h6 class="label">Credit Card Number</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="card" name="card" onkeypress="return keyRestrict(event,'int');"  placeholder="Card Number" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-3">
                	<h6 class="label">Expiry Date</h6>
                    <select name="expiration_month" id="expiration_month" class="align_left">
		            	<option value="">Month</option>
		            	<option value="01">01</option>
		            	<option value="02">02</option>
		            	<option value="03">03</option>
		            	<option value="04">04</option>
		            	<option value="05">05</option>
		            	<option value="06">06</option>
		            	<option value="07">07</option>
		            	<option value="08">08</option>
		            	<option value="09">09</option>
		            	<option value="10">10</option>
		            	<option value="11">11</option>
		            	<option value="12">12</option>
		            </select>
                  </div>
                  <div class="col-sm-3">
                    <select name="expiration_year" id="expiration_year">
		            	<option value="">Year</option>
		            	<%for(int i=2016; i<=2050; i++){ %><option value="<%=i%>"><%=i%></option><%} %>
		            </select>
                  </div>
                  <div class="col-sm-6">
                  <h6 class="label">Cvv2</h6>
                    <input type="text" class="form-control" id="cvv_code" name="cvv_code" onkeypress="return keyRestrict(event,'int');" placeholder="Cvv 2" maxlength="4" />
                  </div>
                </div>
                
                
                <h6 class="label">Address</h6>
                <div class="row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="addressLine" name="addressLine" onkeypress="return keyRestrict(event,'vchar');" placeholder="Address" maxlength="200"  />
                  </div>
                </div>
                <div class="row pt15">
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="city" name="city" onkeypress="return keyRestrict(event,'vchar');" placeholder="City" maxlength="50" />
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="state" name="state" onkeypress="return keyRestrict(event,'vchar');" placeholder="State"  maxlength="50" />
                  </div>
                  <div class="col-sm-3">
                    <select name="country" id="country" class="align_left">
		            	<option value="">Country</option>
		            	<option value="USA">USA</option>
		            	<option value="India">India</option>
		            </select>
                   
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="zipcode" name="zipcode" onkeypress="return keyRestrict(event,'charspace');" placeholder="Zip" maxlength="10" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-6">
                	<h6 class="label">Email</h6>
                    <input type="text" class="form-control" id="email_id" name="email_id" onkeypress="return keyRestrict(event,'emailchar');"  placeholder="Email" maxlength="100" />
                  </div>
                  <div class="col-sm-6">
                	<h6 class="label">Phone</h6>
                    <input type="text" class="form-control" id="phone_no" name="phone_no" onkeypress="return keyRestrict(event,'phone');" placeholder="Phone" maxlength="20" />
                  </div>
                </div>
            <button type="button" class="btn btn-default btn-large mt10" id="submitCandidatePaymentForm" name="submitCandidatePaymentForm" onclick="submitCandidatePayment();" >Continue</button>
            
            </form>
            
            
           <form name="frmOrder" action="https://www.eProcessingNetwork.com/cgi-bin/dbe/transact.pl" method="post" > 
             <!-- <form name="frmOrder" action="buyCandidateCredits" method="get" > -->
				
		    		<INPUT TYPE="HIDDEN" NAME="ePNAccount" ID="ePNAccount" VALUE="1015998">
		    		<INPUT TYPE="HIDDEN" NAME="TranType" ID="TranType" VALUE="Sale">
			    	<INPUT TYPE="HIDDEN" NAME="LogoURL" ID="LogoURL"  VALUE="http://www.secureverify.com/img/payment-logo.jpg">
			    	<INPUT TYPE="HIDDEN" NAME="Redirct" VALUE="1">
					<INPUT TYPE="HIDDEN" NAME="BackgroundColor" VALUE="ffffff">
					<INPUT TYPE="HIDDEN" NAME="TextColor" VALUE="000000">
					
			    	<INPUT TYPE="HIDDEN" NAME="ID" ID="ID" VALUE="<s:property value="paymentDetailsId"/>" />
					<INPUT TYPE="HIDDEN" NAME="partyId" ID="partyId" VALUE="<s:property value="candidate.candidateId"/>" />
					<INPUT TYPE="HIDDEN" NAME="Company" ID="Company" VALUE="Secure Verify Inc" />
					<INPUT TYPE="HIDDEN" NAME="partyTypeId" ID="partyTypeId" VALUE="2" />
					<INPUT TYPE="HIDDEN" NAME="priceOfCredit" ID="priceOfCredit" VALUE="<s:property value="creditTypes.amount"/>" />
					<INPUT TYPE="HIDDEN" NAME="noOfCreditsBought" ID="noOfCreditsBought" VALUE="0" />
					<INPUT TYPE="HIDDEN" NAME="amount" ID="amount" VALUE="0" />
					<INPUT TYPE="HIDDEN" NAME="discountAmount" ID="discountAmount" VALUE="0" />
					<INPUT TYPE="HIDDEN" NAME="couponId" ID="couponId" VALUE="0" />
					<INPUT TYPE="HIDDEN" NAME="couponCodeValue" ID="couponCodeValue" VALUE="" />
			    	
					<INPUT TYPE="HIDDEN" NAME="FirstName" ID="FirstName" VALUE="">
					<INPUT TYPE="HIDDEN" NAME="LastName" ID="LastName" VALUE="" />
					<INPUT TYPE="HIDDEN" NAME="CardNo" ID="CardNo" VALUE="" />
					<INPUT TYPE="HIDDEN" NAME="ExpMonth" ID="ExpMonth" VALUE="" />
					<INPUT TYPE="HIDDEN" NAME="ExpYear" ID="ExpYear" VALUE="" />
					<INPUT TYPE="HIDDEN" SIZE="4" maxlength="4" NAME="CVV2" ID="CVV2" value="" />
			    	<INPUT TYPE="hidden" NAME="Total" ID="Total" VALUE="" />
			    	
					<INPUT TYPE="HIDDEN" NAME="Address" ID="Address" VALUE="" />
					<INPUT TYPE="HIDDEN" NAME="Zip" ID="Zip" VALUE="" />
					<INPUT TYPE="HIDDEN" NAME="EMail" ID="EMail" VALUE="" />
					<INPUT TYPE="HIDDEN" NAME="Phone" ID="Phone" VALUE="" />
					
					<INPUT TYPE="HIDDEN" NAME="ReturnApprovedURL" VALUE="http://www.secureverify.com/candidateTransactionApproved" />
					<INPUT TYPE="HIDDEN" NAME="ReturnDeclinedURL" VALUE="http://www.secureverify.com/candidateTransactionDeclined" />
			        <div class="clearfix"></div>
				</form>
              
            </div>
              <div class="clear"></div>
          </div>
        </div>
          
      </div>
    </div>
  </div>
<%@include file="includes/footer.jsp"%>