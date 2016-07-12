package com.secureVerify.model;

import java.math.BigDecimal;

public class CreditTypes implements java.io.Serializable {

	private static final long serialVersionUID = -6821558771599244737L;
	
	private Integer creditTypesId;
	private Integer creditType;
	private String description;
	private BigDecimal amount;
	private Integer status;
	
	public CreditTypes(){
		
	}

	public CreditTypes(Integer creditTypesId, Integer creditType, String description, BigDecimal amount, Integer status){
		this.creditTypesId = creditTypesId;
		this.creditType = creditType;
		this.description = description;
		this.amount = amount;
		this.status = status;
	}

	public CreditTypes(Integer creditType, String description, BigDecimal amount, Integer status){
		this.creditType = creditType;
		this.description = description;
		this.amount = amount;
		this.status = status;
	}

	public Integer getCreditTypesId() {
		return creditTypesId;
	}

	public void setCreditTypesId(Integer creditTypesId) {
		this.creditTypesId = creditTypesId;
	}

	public Integer getCreditType() {
		return creditType;
	}

	public void setCreditType(Integer creditType) {
		this.creditType = creditType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
