package com.moso.microservice.customerservice.enity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@JsonFilter("DrawFilter")
@Entity(name="draw_request")
public class DrawRequest {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private int builtDrawId;
	private String builtDrawStatus;
	private int dtDrawID;
	private int drawNumber;
	private long dtDealID;
	private String dealName;
	private Date drawDate;
	private Date requestRecievedDate;
	private Date sorReceivedDate;
	private BigDecimal advanceAmount;
	private Boolean isHardCost;
	private Boolean isTitleRequired;
	private double budgetUtilizationPercentage;
	private String wFType;
	private String createdBy;
	@CreationTimestamp
	private Date createdOn; 
	private String modifiedBy;
	@UpdateTimestamp
	private Date modifiedOn;
	@OneToMany(mappedBy = "iDraw")
	private List<FundingSource> fundingSources;
	
	public DrawRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBuiltDrawId() {
		return builtDrawId;
	}

	public void setBuiltDrawId(int builtDrawId) {
		this.builtDrawId = builtDrawId;
	}

	public String getBuiltDrawStatus() {
		return builtDrawStatus;
	}

	public void setBuiltDrawStatus(String builtDrawStatus) {
		this.builtDrawStatus = builtDrawStatus;
	}

	public int getDtDrawID() {
		return dtDrawID;
	}

	public void setDtDrawID(int dtDrawID) {
		this.dtDrawID = dtDrawID;
	}

	public int getDrawNumber() {
		return drawNumber;
	}

	public void setDrawNumber(int drawNumber) {
		this.drawNumber = drawNumber;
	}

	public long getDtDealID() {
		return dtDealID;
	}

	public void setDtDealID(long dtDealID) {
		this.dtDealID = dtDealID;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public Date getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(Date drawDate) {
		this.drawDate = drawDate;
	}

	public Date getRequestRecievedDate() {
		return requestRecievedDate;
	}

	public void setRequestRecievedDate(Date requestRecievedDate) {
		this.requestRecievedDate = requestRecievedDate;
	}

	public Date getSorReceivedDate() {
		return sorReceivedDate;
	}

	public void setSorReceivedDate(Date sorReceivedDate) {
		this.sorReceivedDate = sorReceivedDate;
	}

	public BigDecimal getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(BigDecimal advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public Boolean getIsHardCost() {
		return isHardCost;
	}

	public void setIsHardCost(Boolean isHardCost) {
		this.isHardCost = isHardCost;
	}

	public Boolean getIsTitleRequired() {
		return isTitleRequired;
	}

	public void setIsTitleRequired(Boolean isTitleRequired) {
		this.isTitleRequired = isTitleRequired;
	}

	public double getBudgetUtilizationPercentage() {
		return budgetUtilizationPercentage;
	}

	public void setBudgetUtilizationPercentage(double budgetUtilizationPercentage) {
		this.budgetUtilizationPercentage = budgetUtilizationPercentage;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public List<FundingSource> getFundingSources() {
		return fundingSources;
	}

	public void setFundingSources(List<FundingSource> fundingSources) {
		this.fundingSources = fundingSources;
	}
	
	public String getwFType() {
		return wFType;
	}

	public void setwFType(String wFType) {
		this.wFType = wFType;
	}

	@Override
	public String toString() {
		return "DrawRequest [builtDrawId=" + builtDrawId + ", builtDrawStatus=" + builtDrawStatus + ", dtDrawID="
				+ dtDrawID + ", drawNumber=" + drawNumber + ", dtDealID=" + dtDealID + ", dealName=" + dealName
				+ ", drawDate=" + drawDate + ", requestRecievedDate=" + requestRecievedDate + ", sorReceivedDate="
				+ sorReceivedDate + ", advanceAmount=" + advanceAmount + ", isHardCost=" + isHardCost
				+ ", isTitleRequired=" + isTitleRequired + ", budgetUtilizationPercentage="
				+ budgetUtilizationPercentage + ", wFType=" + wFType + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + ", fundingSources="
				+ fundingSources + "]";
	}
	

	

	
}
