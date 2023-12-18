package com.moso.microservice.customerservice.enity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;


@Entity(name="funding_source_auditlog")
@IdClass(FundingSourceAuditLogID.class)
public class FundingSourceAuditLog {
	
	@Id
	private int builtSourceID;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private int version;
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
	private int drawRequestID;
	
	
	@CreationTimestamp
	private Date createdOn; 
	
	@UpdateTimestamp
	private Date modifiedOn;
	
	public FundingSourceAuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundingSourceAuditLog(FundingSource lSource) {
		super();
		this.builtSourceID = lSource.getBuiltSourceID();
		this.dtDrawFundingID = lSource.getDtDrawFundingID();
		this.facilityID = lSource.getFacilityID();
		this.commitmentID = lSource.getCommitmentID();
		this.loanID = lSource.getLoanID();
		this.sourceDescription= lSource.getSourceDescription();
		this.isCommitmentActive = lSource.getIsCommitmentActive();
		this.isLoanActive = lSource.getIsLoanActive();
		this.outstandingPplBal = lSource.getOutstandingPplBal();
		this.amountNotBorrowed = lSource.getAmountNotBorrowed();
		this.fundingAmount = lSource.getFundingAmount();
		this.capiAmount = lSource.getCapiAmount();
		
		if (lSource.getiDraw() != null) {
			this.drawRequestID = lSource.getiDraw().getBuiltDrawId();
		}
		
		
	}
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getBuiltSourceID() {
		return builtSourceID;
	}

	public void setBuiltSourceID(int builtSourceID) {
		this.builtSourceID = builtSourceID;
	}

	public int getDtDrawFundingID() {
		return dtDrawFundingID;
	}

	public void setDtDrawFundingID(int dtDrawFundingID) {
		this.dtDrawFundingID = dtDrawFundingID;
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

	public String getSourceDescription() {
		return sourceDescription;
	}

	public void setSourceDescription(String sourceDescription) {
		this.sourceDescription = sourceDescription;
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

	public int getDrawRequestID() {
		return drawRequestID;
	}

	public void setDrawRequestID(int drawRequestID) {
		this.drawRequestID = drawRequestID;
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
		return "FundingSourceAuditLog [builtSourceID=" + builtSourceID + ", version=" + version + ", dtDrawFundingID="
				+ dtDrawFundingID + ", facilityID=" + facilityID + ", commitmentID=" + commitmentID + ", loanID="
				+ loanID + ", sourceDescription=" + sourceDescription + ", isCommitmentActive=" + isCommitmentActive
				+ ", isLoanActive=" + isLoanActive + ", outstandingPplBal=" + outstandingPplBal + ", amountNotBorrowed="
				+ amountNotBorrowed + ", fundingAmount=" + fundingAmount + ", capiAmount=" + capiAmount
				+ ", drawRequestID=" + drawRequestID + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
	}

	
	
	

}
