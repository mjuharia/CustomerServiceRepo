package com.moso.microservice.customerservice.enity;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@JsonFilter("DrawFilter")
@Entity(name="funding_source")
public class FundingSource {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private int builtSourceID;
	private int dtDrawFundingID;
	private int facilityID;
	private String commitmentID;
	private String loanID;
	private String sourceDescription;
	private Boolean isCommitmentActive;
	private Boolean isLoanActive;
	private BigDecimal outstandingPplBal;
	private BigDecimal amountNotBorrowed;
	private BigDecimal fundingAmount;
	private BigDecimal capiAmount;
	
	@CreationTimestamp
	private Date createdOn; 
	
	@UpdateTimestamp
	private Date modifiedOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private DrawRequest iDraw;
		
	public FundingSource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBuiltSourceID() {
		return builtSourceID;
	}

	public void setBuiltSourceID(int builtSourceID) {
		this.builtSourceID = builtSourceID;
	}

	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public String getCommitmentID() {
		return commitmentID;
	}

	public void setCommitmentID(String commitmentID) {
		this.commitmentID = commitmentID;
	}

	public String getLoanID() {
		return loanID;
	}

	public void setLoanID(String loanID) {
		this.loanID = loanID;
	}

	public Boolean getIsCommitmentActive() {
		return isCommitmentActive;
	}

	public void setIsCommitmentActive(Boolean isCommitmentActive) {
		this.isCommitmentActive = isCommitmentActive;
	}

	public Boolean getIsLoanActive() {
		return isLoanActive;
	}

	public void setIsLoanActive(Boolean isLoanActive) {
		this.isLoanActive = isLoanActive;
	}

	public BigDecimal getOutstandingPplBal() {
		return outstandingPplBal;
	}

	public void setOutstandingPplBal(BigDecimal outstandingPplBal) {
		this.outstandingPplBal = outstandingPplBal;
	}

	public BigDecimal getAmountNotBorrowed() {
		return amountNotBorrowed;
	}

	public void setAmountNotBorrowed(BigDecimal amountNotBorrowed) {
		this.amountNotBorrowed = amountNotBorrowed;
	}

	public BigDecimal getFundingAmount() {
		return fundingAmount;
	}

	public void setFundingAmount(BigDecimal fundingAmount) {
		this.fundingAmount = fundingAmount;
	}

	public BigDecimal getCapiAmount() {
		return capiAmount;
	}

	public void setCapiAmount(BigDecimal capiAmount) {
		this.capiAmount = capiAmount;
	}


	public DrawRequest getiDraw() {
		return iDraw;
	}

	public void setiDraw(DrawRequest iDraw) {
		this.iDraw = iDraw;
	}
	


	public int getDtDrawFundingID() {
		return dtDrawFundingID;
	}

	public void setDtDrawFundingID(int dtDrawFundingID) {
		this.dtDrawFundingID = dtDrawFundingID;
	}

	public String getSourceDescription() {
		return sourceDescription;
	}

	public void setSourceDescription(String sourceDescription) {
		this.sourceDescription = sourceDescription;
	}


	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "FundingSource [builtSourceID=" + builtSourceID + ", dtDrawFundingID=" + dtDrawFundingID
				+ ", facilityID=" + facilityID + ", commitmentID=" + commitmentID + ", loanID=" + loanID
				+ ", sourceDescription=" + sourceDescription + ", isCommitmentActive=" + isCommitmentActive
				+ ", isLoanActive=" + isLoanActive + ", outstandingPplBal=" + outstandingPplBal + ", amountNotBorrowed="
				+ amountNotBorrowed + ", fundingAmount=" + fundingAmount + ", capiAmount=" + capiAmount + ", createdOn="
				+ createdOn + ", modifiedOn=" + modifiedOn + ", iDraw=" + iDraw + "]";
	}
	
	
	
	
}
